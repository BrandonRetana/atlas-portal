import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Component } from '@angular/core';
import { FormBuilder, Validators } from '@angular/forms';
import { ImageService } from '../service/image.service';


@Component({
  selector: 'app-form-image',
  templateUrl: './form-image.component.html',
  styleUrls: ['./form-image.component.css']
})
export class FormImageComponent {
  selectedFile: any;
  calendar: any;
  
  constructor(private service: ImageService, private formBuilder: FormBuilder) { 
  }

  public ImageForm = this.formBuilder.group({
    selectedFile: [null, Validators.required],
    imageName: ['', Validators.required],
    imageDescription: ['', Validators.required],
    myDate:['', Validators.required],
    author:['', Validators.required],
    authorName:['', Validators.required]
  });
  
  
  onFileChange(event: Event): void {
    const input = event.target as HTMLInputElement;
    if (input.files && input.files.length) {
      this.selectedFile = input.files[0];
    }
  }
  
  onSubmit(): void {
    const formData = new FormData();
    formData.append('image', this.selectedFile);
    this.service.submitImage(formData).subscribe(response => console.log(response));
  }

  public setAuthor(id:string, name:string){
    this.ImageForm.controls['author'].setValue(id);
    this.ImageForm.controls['authorName'].setValue(name);
  }

 
}


