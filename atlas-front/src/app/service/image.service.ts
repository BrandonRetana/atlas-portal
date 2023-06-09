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

  public getImages(){
    return this.http.get<any>(this.url+"list/image")
  }

  public getImage(id: string){
    return this.http.get<any>(this.url+"image/"+id);
  }

  public deleteImage(id: string){
    return this.http.delete(this.url+"delete/image/"+id);
  }

  public updateImage(formData:any, id:string){
    return this.http.put(this.url+"update/image/"+id, formData);
  }

}
