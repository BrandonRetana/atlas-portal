import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { ImageService } from '../service/image.service';

@Component({
  selector: 'app-single-image-info',
  templateUrl: './single-image-info.component.html',
  styleUrls: ['./single-image-info.component.css']
})
export class SingleImageInfoComponent implements OnInit{

  image: any = {};

  constructor(private route: ActivatedRoute, private imageService:ImageService) { }

  ngOnInit(): void {
    this.route.params.subscribe(params => {
      this.imageService.getImage(params['id']).subscribe(data => {
        console.log(data);
        this.image = data['image'];
      })
    })
  }

}
