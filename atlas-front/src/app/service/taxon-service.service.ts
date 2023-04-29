import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class TaxonServiceService {

  constructor(private http: HttpClient) { 

  }

  private url: string = "http://localhost:8080/";

  public submit(taxonJson:any){
    return this.http.post<any>(this.url+"create/taxon", taxonJson);
  }

  public getAuthors(){
    return this.http.get<any>(this.url+"list/author");
  }

  public getKingdoms(){
    return this.http.get<any>(this.url+"list/kingdoms")
  }

  public getPhylums(){
    return this.http.get<any>(this.url+"list/phylums")
  }

  public getClasses(){
    return this.http.get<any>(this.url+"list/classes")
  }

  public getOrders(){
    return this.http.get<any>(this.url+"list/orders")
  }

  public getFamilies(){
    return this.http.get<any>(this.url+"list/families")
  }

  public getGenus(){
    return this.http.get<any>(this.url+"list/genus")
  }

  public getSpecies(){
    return this.http.get<any>(this.url+"list/species")
  }
}
