import { Component, OnInit } from '@angular/core';
import { FormBuilder, Validators } from '@angular/forms';
import { TaxonServiceService } from '../service/taxon-service.service';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-form-taxon',
  templateUrl: './form-taxon.component.html',
  styleUrls: ['./form-taxon.component.css'],
})
export class FormTaxonComponent implements OnInit {
  public isUpdate: boolean = false;

  public haveFathers: boolean = false;

  public Authors: Array<any> = [];

  public ancestors: Array<any> = [];

  constructor(
    private formBuilder: FormBuilder,
    private service: TaxonServiceService,
    private route: ActivatedRoute
  ) { }


  public TaxonForm = this.formBuilder.group({
    id: [''],
    typeClass: ['', [Validators.required]],
    scientificName: ['', [Validators.required]],
    author: ['', [Validators.required]],
    publicationYear: ['', [Validators.required]],
    ancestor: ['', [Validators.required]],
    ancestorName: [''],
  });

  ngOnInit(): void {
    if(this.route){
    this.route.paramMap.subscribe((params) => {
      const id = params.get('id');
      if (id) {
        
        this.service.getTaxonById(id).subscribe((data) => {
          this.getAncestor(data['typeClass']);
          this.TaxonForm.controls['id'].setValue(id);
          this.TaxonForm.controls['typeClass'].setValue(data['typeClass']);
          this.TaxonForm.controls['scientificName'].setValue(data['scientificName']);
          this.TaxonForm.controls['author'].setValue(data['author']);
          this.TaxonForm.controls['publicationYear'].setValue(data['publicationYear']);
          this.TaxonForm.controls['ancestor'].setValue(data['ancestorID']);
          this.TaxonForm.controls['ancestorName'].setValue(data['ancestorName']);
          this.isUpdate = true;
          console.log(data);
        });
      }
    })
  }
}

  public getAuthor() {
    this.service.getAuthors().subscribe(
      (data) => {
        this.Authors = data['authors'];
        console.log(data);
      },
      (error) => {
        console.log('404 no authors');
      }
    );
  }

  public setAuthor(selector: string) {
    this.TaxonForm.controls['author'].setValue(selector);
  }

  public setAncestor(ancestorId: string, scientificName: string) {
    this.TaxonForm.controls['ancestor'].setValue(ancestorId);
    this.TaxonForm.controls['ancestorName'].setValue(scientificName);
  }

  public setClass(typeClass: string) {
    this.TaxonForm.controls['typeClass'].setValue(typeClass);
    this.getAncestor(typeClass);
  }

  public submit() {
   // if(this.isUpdate && this.TaxonForm.valid && this.haveFather()){
    const taxonJson = {
      id: this.TaxonForm.controls['id'].value,
      typeClass: this.TaxonForm.controls['typeClass'].value,
      scientificName: this.TaxonForm.controls['scientificName'].value,
      author: this.TaxonForm.controls['author'].value,
      publicationYear: this.TaxonForm.controls['publicationYear'].value,
      ancestorID: this.TaxonForm.controls['ancestor'].value,
    };

    this.service.submit(taxonJson).subscribe(() => {
      console.log('success');
    });//}
  }

  public haveFather() {
    if (this.TaxonForm.controls['ancestorName'].value == '' || this.TaxonForm.controls['ancestorName'].value == null || this.TaxonForm.controls['ancestorName'].value == undefined || this.TaxonForm.controls['ancestorName'].value == 'Sin ancestro') {
      this.haveFathers = false;
      return false;
    } else {
      this.haveFathers = true;
      return true;
    }
  }



public getAncestor(typeClass: String) {
  switch (typeClass) {
    case 'kingdom':
      this.TaxonForm.controls['ancestor'].clearValidators();
      this.TaxonForm.controls['ancestor'].updateValueAndValidity();
      this.TaxonForm.controls['ancestor'].disable();
      break;

    case 'phylum':
      this.service.getKingdoms().subscribe(
        (data) => {
          this.ancestors = data['kingdoms'];
          console.log(data);
        },
        (error) => {
          console.log('404 no kingdoms');
        }
      );
      break;

    case 'class':
      this.service.getPhylums().subscribe(
        (data) => {
          this.ancestors = data['phylums'];
          console.log(data);
        },
        (error) => {
          console.log('404 no phylums');
        }
      );
      break;

    case 'order':
      this.service.getClasses().subscribe(
        (data) => {
          this.ancestors = data['classes'];
          console.log(data);
        },
        (error) => {
          console.log('404 no classes');
        }
      );
      break;

    case 'family':
      this.service.getOrders().subscribe(
        (data) => {
          this.ancestors = data['orders'];
          console.log(data);
        },
        (error) => {
          console.log('404 no orders');
        }
      );
      break;

    case 'genus':
      console.log('genus');
      this.service.getFamilies().subscribe(
        (data) => {
          this.ancestors = data['families'];
          console.log(data);
        },
        (error) => {
          console.log('404 no families');
        }
      );
      break;

    case 'species':
      console.log('species');
      this.service.getGenus().subscribe(
        (data) => {
          this.ancestors = data['genus'];
          console.log(data);
        },
        (error) => {
          console.log('404 no genuses');
        }
      );
      break;

    default:
      this.TaxonForm.controls['ancestor'].setValidators(Validators.required);
      this.TaxonForm.controls['ancestor'].updateValueAndValidity();
      this.TaxonForm.controls['ancestor'].enable();
      break;
  }
}
}