import { Component, OnInit } from '@angular/core';
import { BackOfficeService } from '../../service/back-office.service';
import { KingdomService } from 'src/app/service/taxon-service/kingdom.service';

@Component({
  selector: 'app-table-kingdom',
  templateUrl: './table-kingdom.component.html',
  styleUrls: ['./table-kingdom.component.css']
})
export class TableKingdomComponent implements OnInit {
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
}
