import { Component, NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { NavbarComponent } from './navbar/navbar.component';
import { GalleryComponent } from './gallery/gallery.component';
import { FormImageComponent } from './form-image/form-image.component';
import { BackOfficeComponent } from './back-office/back-office.component';
import { SingleImageInfoComponent } from './single-image-info/single-image-info.component';
import { FormTaxonComponent } from './form-taxon/form-taxon.component';
import { TableKingdomComponent } from './table-kingdom/table-kingdom.component';
import { TableTaxonComponent } from './table-taxon/table-taxon.component';


const routes: Routes = [
  {
    path:"",
    component:GalleryComponent
  },
  {
    path: "create/image",
    component:FormImageComponent
  },
  {
    path:"back/office",
    component: BackOfficeComponent
  },
  {
    path:"page/:id",
    component:SingleImageInfoComponent
  },
  {
    path:"create/taxon",
    component:FormTaxonComponent
  },
  {
    path:"create/taxon/:id",
    component:FormTaxonComponent
  },
  {
    path:"list/kingdoms",
    component:TableKingdomComponent
  },
  {
    path:"list/taxons",
    component:TableTaxonComponent
  },
  {
    path: "list/taxons/:id",
    component:TableTaxonComponent
  }

 
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
