import { Component, OnInit } from '@angular/core';
import { ImageService } from '../service/image.service';
import { Route, Router } from '@angular/router';

@Component({
  selector: 'app-gallery',
  templateUrl: './gallery.component.html',
  styleUrls: ['./gallery.component.css']
})
export class GalleryComponent implements OnInit{
  images: Array<any> = [];

  constructor(private imageService: ImageService, private router:Router) { }


  ngOnInit(): void {
    this.loadImages();
  }

  loadImages(){
    this.imageService.getImages().subscribe(data => {
      console.log(data);
      this.images = data['images'];
    })
  }

  public editKingdom(id: string) {
    console.log(id)
    if (this.router) {
      this.router.navigate(['/page', id]);
    }
  }


}
