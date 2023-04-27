import { Component, OnInit } from '@angular/core';
import { BackOfficeService } from '../service/back-office.service';

@Component({
  selector: 'app-back-office',
  templateUrl: './back-office.component.html',
  styleUrls: ['./back-office.component.css']


})
export class BackOfficeComponent implements OnInit{
  constructor(private officeService:BackOfficeService){
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
}
