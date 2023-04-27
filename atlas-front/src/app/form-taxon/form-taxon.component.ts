import { Component } from '@angular/core';
import { FormBuilder, Validators } from '@angular/forms';
import { TaxonServiceService } from '../service/taxon-service.service';

@Component({
  selector: 'app-form-taxon',
  templateUrl: './form-taxon.component.html',
  styleUrls: ['./form-taxon.component.css']
})
export class FormTaxonComponent {
  constructor(private formBuilder: FormBuilder, private service: TaxonServiceService){

  }
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
