import { Component, OnInit } from '@angular/core';
import { TaxonServiceService } from '../service/taxon-service.service';
import { ActivatedRoute, Route, Router } from '@angular/router';

@Component({
  selector: 'app-table-taxon',
  templateUrl: './table-taxon.component.html',
  styleUrls: ['./table-taxon.component.css']
})
export class TableTaxonComponent implements OnInit{

  public taxons: Array<any> = [];
  
    constructor(private service:TaxonServiceService, private route:ActivatedRoute, private router:Router) { }


  ngOnInit(): void {
      this.route.paramMap.subscribe((params) => {
        const id = params.get('id') || 'phylums';
        this.getTaxons(id);
      });
    }
    

  public getTaxons(typeClass:string){
    switch(typeClass){
      case "phylum":
        this.service.getPhylums().subscribe((data) => {
          this.taxons = data['phylums'];
        }
        );
        break;
      case "class":
        this.service.getClasses().subscribe((data) => {
          this.taxons = data['classes'];
        }
        );
        break;
      case "order":
        this.service.getOrders().subscribe((data) => {
          this.taxons = data['orders'];
        }
        );
        break;
      case "family":
        this.service.getFamilies().subscribe((data) => {
          this.taxons = data['families'];
        }
        );
        break;
      case "genus":
        this.service.getGenus().subscribe((data) => {
          this.taxons = data['genus'];
        }
        );
        break;
      case "specie":
        this.service.getSpecies().subscribe((data) => {
          this.taxons = data['species'];
        }
        );
        break;
    }
  }

  public deleteTaxon(id:string){  
    this.service.delete(id);
    window.location.reload(); 
  }

  public update(id: string) {
    console.log(id)
    if (this.router) {
      this.router.navigate(['/create/taxon', id]);
    }
  }


}
