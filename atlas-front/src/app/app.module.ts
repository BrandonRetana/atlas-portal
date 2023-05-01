import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NavbarComponent } from './navbar/navbar.component';
import { GalleryComponent } from './gallery/gallery.component';
import { FormImageComponent } from './form-image/form-image.component';
import { BackOfficeComponent } from './back-office/back-office.component';
import { HttpClientModule } from '@angular/common/http';
import { SingleImageInfoComponent } from './single-image-info/single-image-info.component';
import { FormTaxonComponent } from './form-taxon/form-taxon.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { TableKingdomComponent } from './table-kingdom/table-kingdom.component';
import { TableTaxonComponent } from './table-taxon/table-taxon.component';
import { TableImagesComponent } from './table-images/table-images.component';




@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    GalleryComponent,
    FormImageComponent,
    BackOfficeComponent,
    SingleImageInfoComponent,
    FormTaxonComponent,
    TableKingdomComponent,
    TableTaxonComponent,
    TableImagesComponent,

  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    ReactiveFormsModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
