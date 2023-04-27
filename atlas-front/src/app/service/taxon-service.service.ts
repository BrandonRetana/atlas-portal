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
    return this.http.post<any>(this.url+"create/taxon", taxonJson)
  }
}
