import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, Validators } from '@angular/forms';
import { ImageService } from '../service/image.service';
import { TaxonServiceService } from '../service/taxon-service.service';
import { OwnerService } from '../service/owner.service';


@Component({
  selector: 'app-form-image',
  templateUrl: './form-image.component.html',
  styleUrls: ['./form-image.component.css']
})
export class FormImageComponent implements OnInit{
  selectedFile: any;
  kingdoms: Array<any> = [];
  phylums: Array<any> = [];
  classes: Array<any> = [];
  orders: Array<any> = [];
  families: Array<any> = [];
  genus: Array<any> = [];
  species: Array<any> = [];
  authors: Array<any> = [];
  owners: Array<any> = [];
  
  
  constructor(private service: ImageService, private formBuilder: FormBuilder, private taxonService:TaxonServiceService, private ownerService:OwnerService) { 
  }


  ngOnInit(): void {
    this.loadTaxonData();
  }


  public ImageForm = this.formBuilder.group({
    selectedFile: [null, Validators.required],
    imageName: ['', Validators.required],
    imageDescription: ['', Validators.required],
    date:['', Validators.required],
    author:['', Validators.required],
    authorName:['', Validators.required],
    owner:['', Validators.required],
    ownerName:['', Validators.required],
    license:['', Validators.required],

    checkbox1:[''],
    checkbox2:[''],

    kingdom:[''],
    phylum:[''],
    class:[''],
    order:[''],
    family:[''],
    genus:[''],
    species:[''],
    kingdomName:[''],
    phylumName:[''],
    className:[''],
    orderName:[''],
    familyName:[''],
    genusName:[''],
    speciesName:[''],
  });
  
  
  onFileChange(event: Event): void {
    const input = event.target as HTMLInputElement;
    if (input.files && input.files.length) {
      this.selectedFile = input.files[0];
    }
  }
  
  onSubmit(): void {
    const formData = new FormData();
    formData.append('image', this.selectedFile);
    formData.append('imageName', this.ImageForm.controls['imageName'].value || '');
    formData.append('imageDescription', this.ImageForm.controls['imageDescription'].value || '');
    formData.append('date', this.ImageForm.controls['date'].value || '');
    formData.append('author', this.ImageForm.controls['author'].value || '');
    formData.append('owner', this.ImageForm.controls['owner'].value || '');
    formData.append('license', this.ImageForm.controls['license'].value || '');
    const checkbox1 = this.ImageForm.controls['checkbox1'].value ? 'Angiospermae' : 'Planta';
    formData.append('checkbox1', checkbox1);
    const checkbox2 = this.ImageForm.controls['checkbox2'].value ? 'Gymnospermae' : 'Planta';
    formData.append('checkbox2', checkbox2);
    formData.append('kingdom', this.ImageForm.controls['kingdom'].value || '');
    formData.append('phylum', this.ImageForm.controls['phylum'].value || '');
    formData.append('class', this.ImageForm.controls['class'].value || '');
    formData.append('order', this.ImageForm.controls['order'].value || '');
    formData.append('family', this.ImageForm.controls['family'].value || '');
    formData.append('genus', this.ImageForm.controls['genus'].value || '');
    formData.append('species', this.ImageForm.controls['species'].value || '');
    this.service.submitImage(formData).subscribe(response => console.log(response));
  }

  public setAuthor(id:string, name:string){
    this.ImageForm.controls['author'].setValue(id);
    this.ImageForm.controls['authorName'].setValue(name);
  }

  public setOwner(id:string, name:string){
    this.ImageForm.controls['owner'].setValue(id);
    this.ImageForm.controls['ownerName'].setValue(name);

  }

  public setLicense(id:string){
    this.ImageForm.controls['license'].setValue(id);
  }

  public setKingdom(id:string, name:string, ancestorID:number){
    this.ImageForm.controls['kingdom'].setValue(id);
    this.ImageForm.controls['kingdomName'].setValue(name);
    this.setAncestor(ancestorID);
  }

  public setPhylum(id:string, name:string, ancestorID:number){
    this.ImageForm.controls['phylum'].setValue(id);
    this.ImageForm.controls['phylumName'].setValue(name);
    this.setAncestor(ancestorID);
  }

  public setClass(id:string, name:string, ancestorID:number){
    this.ImageForm.controls['class'].setValue(id);
    this.ImageForm.controls['className'].setValue(name);
    this.setAncestor(ancestorID);
  }

  public setOrder(id:string, name:string, ancestorID:number){
    this.ImageForm.controls['order'].setValue(id);
    this.ImageForm.controls['orderName'].setValue(name);
    this.setAncestor(ancestorID);
  }

  public setFamily(id:string, name:string, ancestorID:number){
    this.ImageForm.controls['family'].setValue(id);
    this.ImageForm.controls['familyName'].setValue(name);
    this.setAncestor(ancestorID);
  }

  public setGenus(id:string, name:string, ancestorID:number){
    this.ImageForm.controls['genus'].setValue(id);
    this.ImageForm.controls['genusName'].setValue(name);
    this.setAncestor(ancestorID);
  }

  public setSpecies(id:string, name:string, ancestorID:number){
    this.ImageForm.controls['species'].setValue(id);
    this.ImageForm.controls['speciesName'].setValue(name);
    this.setAncestor(ancestorID);
  }
  

  setAncestor(ancestorId: number): void {
    let taxonomy = null;
    // Buscar el ancestro en el array correspondiente
    if ((taxonomy = this.kingdoms.find((t) => t.id === ancestorId))) {
      console.log("caso 1")
      this.ImageForm.controls['kingdom'].setValue(taxonomy.id);
      this.ImageForm.controls['kingdomName'].setValue(taxonomy.scientificName);

    } else if ((taxonomy = this.phylums.find((t) => t.id === ancestorId))) {
      this.ImageForm.controls['phylum'].setValue(taxonomy.id);
      this.ImageForm.controls['phylumName'].setValue(taxonomy.scientificName);

    } else if ((taxonomy = this.classes.find((t) => t.id === ancestorId))) {
      this.ImageForm.controls['class'].setValue(taxonomy.id);
      this.ImageForm.controls['className'].setValue(taxonomy.scientificName);

    } else if ((taxonomy = this.orders.find((t) => t.id === ancestorId))) {
      this.ImageForm.controls['order'].setValue(taxonomy.id);
      this.ImageForm.controls['orderName'].setValue(taxonomy.scientificName);

    } else if ((taxonomy = this.families.find((t) => t.id === ancestorId))) {
      this.ImageForm.controls['family'].setValue(taxonomy.id);
      this.ImageForm.controls['familyName'].setValue(taxonomy.scientificName);
      
    } else if ((taxonomy = this.genus.find((t) => t.id === ancestorId))) {
      this.ImageForm.controls['genus'].setValue(taxonomy.id);
      this.ImageForm.controls['genusName'].setValue(taxonomy.scientificName);
      
    } else if ((taxonomy = this.species.find((t) => t.id === ancestorId))) {
      this.ImageForm.controls['species'].setValue(taxonomy.id);
      this.ImageForm.controls['speciesName'].setValue(taxonomy.scientificName);

      
    } else {
      console.log("No se encontró ningún ancestro correspondiente");
    }

    if(taxonomy.ancestorID != undefined){
      this.setAncestor(taxonomy.ancestorID);
    }

    
}

  
  


  public loadTaxonData(){
    this.taxonService.getKingdoms().subscribe((data) => {
      this.kingdoms = data['kingdoms'];
    });
    this.taxonService.getPhylums().subscribe((data) => {
      this.phylums = data['phylums'];
    }
    );

    this.taxonService.getClasses().subscribe((data) => {
      this.classes = data['classes'];
    }
    );

    this.taxonService.getOrders().subscribe((data) => {
      this.orders = data['orders'];
    }
    );

    this.taxonService.getFamilies().subscribe((data) => {
      this.families = data['families'];
    }
    );

    this.taxonService.getGenus().subscribe((data) => {
      this.genus = data['genus'];
    }
    );

    this.taxonService.getSpecies().subscribe((data) => {
      this.species = data['species'];
    }
    );

    this.ownerService.getOwner().subscribe((data) => {
      this.owners = data['owners'];
    }
    );

    this.ownerService.getPerson().subscribe((data) => {
      this.authors = data['persons'];
    }
    );
  }


 
}


