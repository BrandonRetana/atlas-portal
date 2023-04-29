import { Component, NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { NavbarComponent } from './navbar/navbar.component';
import { GalleryComponent } from './gallery/gallery.component';
import { FormImageComponent } from './form-image/form-image.component';
import { BackOfficeComponent } from './back-office/back-office.component';
import { SingleImageInfoComponent } from './single-image-info/single-image-info.component';
import { FormTaxonComponent } from './form-taxon/form-taxon.component';
import { TableKingdomComponent } from './taxon-tables/table-kingdom/table-kingdom.component';

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
    path:"page/tucan",
    component:SingleImageInfoComponent
  },
  {
    path:"create/taxon",
    component:FormTaxonComponent
  },
  {
    path:"list/kingdoms",
    component:TableKingdomComponent
  }

 
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
