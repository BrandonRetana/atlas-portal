import { Component, OnInit } from '@angular/core';
import { ImageService } from '../service/image.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-table-images',
  templateUrl: './table-images.component.html',
  styleUrls: ['./table-images.component.css']
})
export class TableImagesComponent implements OnInit{
  images: Array<any> = [];

  
    constructor(private imageService:ImageService, private router:Router) { }
  
    ngOnInit(): void {
      this.loadImages();
    }

    loadImages(){
      this.imageService.getImages().subscribe(data => {
        console.log(data);
        this.images = data['images'];
      })
    }

    deleteImage(id: string){
      this.imageService.deleteImage(id).subscribe(data => {
        console.log(data);
      })
      window.location.reload();
    }

    public update(id: string) {
      console.log(id)
      if (this.router) {
        this.router.navigate(['/create/image', id]);
      }
    }


}
