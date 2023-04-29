import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class ImageService {

  constructor(private http: HttpClient) { }


  private url: string = "http://localhost:8080/";

  public submitImage(formData:any){
    return this.http.post(this.url+"upload/image", formData);
  }

}
