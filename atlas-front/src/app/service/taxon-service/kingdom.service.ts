import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class KingdomService {
  constructor(private http: HttpClient) { }


  private url: string = "http://localhost:8080/";

  public delete(id:string){
    this.http.delete(`${this.url}delete/${id}`).subscribe(() => {
      console.log(`Kingdom with id: ${id} deleted`);
    });
  }
}
