import { Component, OnInit } from '@angular/core';
import { BackOfficeService } from '../service/back-office.service';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-back-office',
  templateUrl: './back-office.component.html',
  styleUrls: ['./back-office.component.css']


})
export class BackOfficeComponent {
  constructor(private router:Router) { 

  }

  public goToTaxon(id:string){
    this.router.navigate(['/list/taxons', id]);
  }
}
