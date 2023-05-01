import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class OwnerService {

  constructor(private http: HttpClient) { }

  private url: string = "http://localhost:8080/";

  public getOwner(){
    return this.http.get<any>(this.url+"list/owner")
  }

  public getPerson(){
    return this.http.get<any>(this.url+"list/person")
  }
}
