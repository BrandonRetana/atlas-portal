import { Component, OnInit } from '@angular/core';
import { BackOfficeService } from '../../service/back-office.service';
import { KingdomService } from 'src/app/service/taxon-service/kingdom.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-table-kingdom',
  templateUrl: './table-kingdom.component.html',
  styleUrls: ['./table-kingdom.component.css']
})
export class TableKingdomComponent implements OnInit {
  private router: Router | undefined;
  
  constructor(private officeService:BackOfficeService, private service:KingdomService){
  }

  ngOnInit() {
    this.callService();
  }

  public data: Array<any> = [];

  public callService(){
    this.officeService.getEddis().subscribe(data=>{
      this.data = data["species"];
      console.log(data);
    },error => {
      console.log("404 not found")
    })
  }


  public deleteKingdom(id:string){
    this.service.delete(id);
    window.location.reload(); 
  }

  public editKingdom(id: string) {
    if (this.router) {
      this.router.navigate(['/create/taxon', id]);
    }
  }

}
