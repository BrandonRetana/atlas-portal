import { Component, OnInit } from '@angular/core';
import { ImageService } from '../service/image.service';
import { Route, Router } from '@angular/router';
import { FormBuilder } from '@angular/forms';

@Component({
  selector: 'app-gallery',
  templateUrl: './gallery.component.html',
  styleUrls: ['./gallery.component.css']
})
export class GalleryComponent implements OnInit{
  images: Array<any> = [];

  constructor(private imageService: ImageService, private router:Router, private formBuilder:FormBuilder) { }


  ngOnInit(): void {
  }

  public thisImage = this.formBuilder.group({
    text: ['']
  })

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



  filterImages(text: string) {
    return this.images.filter(image => {
      if (image.name.includes(text)) {
        return true;
      }
      return true;
    });
  }
  

  search() {
    const tdfext:string = this.thisImage.controls['text'].value as string;
    let images = this.filterImages(tdfext);
    console.log(images);
    this.images = images;
  }



}
