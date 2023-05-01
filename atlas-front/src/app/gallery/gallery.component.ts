import { Component, OnInit } from '@angular/core';
import { ImageService } from '../service/image.service';

@Component({
  selector: 'app-gallery',
  templateUrl: './gallery.component.html',
  styleUrls: ['./gallery.component.css']
})
export class GalleryComponent implements OnInit{
  images: Array<any> = [];

  constructor(private imageService: ImageService) { }


  ngOnInit(): void {
    this.loadImages();
  }

  loadImages(){
    this.imageService.getImages().subscribe(data => {
      console.log(data);
      this.images = data['images'];
    })
  }
}
