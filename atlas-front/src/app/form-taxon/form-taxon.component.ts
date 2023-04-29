import { Component, OnInit } from '@angular/core';
import { FormBuilder, Validators } from '@angular/forms';
import { TaxonServiceService } from '../service/taxon-service.service';

@Component({
  selector: 'app-form-taxon',
  templateUrl: './form-taxon.component.html',
  styleUrls: ['./form-taxon.component.css']
})
export class FormTaxonComponent implements OnInit {
  constructor(private formBuilder: FormBuilder, private service: TaxonServiceService){

  }

  public Authors:Array<any> = [];

  public TaxonForm = this.formBuilder.group({
    id: [''],
    typeClass: ['', [Validators.required]],
    scientificName: ['', [Validators.required]],
    author: ['', [Validators.required]],
    authorName: [''],
    publicationYear: ['', [Validators.required]],
    ancestor: ['', [Validators.required]],
    ancestorName: ['']
  });

  ngOnInit(): void {
    this.getAuthor();
  }

  public getAuthor(){
    this.service.getAuthors().subscribe(data=>{
      this.Authors = data["authors"];
      console.log(data);
    }, error =>{
      console.log("404 no authors");
    }
    )
  }
  

  public setSelectorAuthor(selector:string, authorname:string){
    this.TaxonForm.controls["author"].setValue(<string> selector)
    this.TaxonForm.controls["authorName"].setValue(<string> authorname)
  }

  public setAncestor(ancestorId:string, scientificName:string){
    this.TaxonForm.controls["ancestor"].setValue(ancestorId)
    this.TaxonForm.controls["ancestorName"].setValue(scientificName)
  }

  public setClass(typeClass:string){
    this.TaxonForm.controls['typeClass'].setValue(typeClass)
    this.getAncestor(typeClass);
  }

  public getAncestor(typeClass:String){
    switch(typeClass){
      case "kingdom":
      this.TaxonForm.controls['ancestor'].clearValidators();
      this.TaxonForm.controls['ancestor'].updateValueAndValidity();
      this.TaxonForm.controls['ancestor'].disable();
      break;


      default:
        this.TaxonForm.controls['ancestor'].setValidators(Validators.required);
        this.TaxonForm.controls['ancestor'].updateValueAndValidity();
        this.TaxonForm.controls['ancestor'].enable();
        break;
    }
  }

  public submit(){
    const taxonJson = {
      id: this.TaxonForm.controls['id'].value,
      typeClass: this.TaxonForm.controls['typeClass'].value,
      scientificName: this.TaxonForm.controls['scientificName'].value,
      author: this.TaxonForm.controls['author'].value,
      publicationYear: this.TaxonForm.controls['publicationYear'].value,
      ancestor: this.TaxonForm.controls['ancestor'].value
    }

    this.service.submit(taxonJson).subscribe(() => {
      console.log("success")
    })

  }


}
