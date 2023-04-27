import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class BackOfficeService {

  constructor(private http: HttpClient) { 
    
  }

  private url: string = "http://localhost:8080/";

  public getEddis (){
    return this.http.get<any>(this.url+"back/office")
  }
}
