import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Component } from '@angular/core';
import { FormBuilder, Validators } from '@angular/forms';


@Component({
  selector: 'app-form-image',
  templateUrl: './form-image.component.html',
  styleUrls: ['./form-image.component.css']
})
export class FormImageComponent {
  selectedFile: any;
  constructor(private http: HttpClient, private formBuilder: FormBuilder) { 
  }

  public ImageForm = this.formBuilder.group({
    selectedFile: [null, Validators.required]
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
    this.http.post('http://localhost:8080/upload/image', formData)
      .subscribe(response => console.log(response));
  }

 
}


