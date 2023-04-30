import { Component, OnInit } from '@angular/core';

import { Router } from '@angular/router';
import { BackOfficeService } from 'src/app/service/back-office.service';
import { TaxonServiceService } from 'src/app/service/taxon-service.service';


@Component({
  selector: 'app-table-kingdom',
  templateUrl: './table-kingdom.component.html',
  styleUrls: ['./table-kingdom.component.css']
})
export class TableKingdomComponent implements OnInit {
  
  constructor(private service:TaxonServiceService, private router: Router){
  }

  ngOnInit() {
    this.callService();
  }

  public data: Array<any> = [];

  public callService(){
    this.service.getKingdoms().subscribe((data: any) => {
      this.data = data['kingdoms'];
    },
    error => {
      console.log(error);
    }
    );
  }


  public deleteKingdom(id:string){
    this.service.delete(id);
    window.location.reload(); 
  }

  public editKingdom(id: string) {
    console.log(id)
    if (this.router) {
      this.router.navigate(['/create/taxon', id]);
    }
  }

}
