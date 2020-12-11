import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';

import {AppRoutingModule} from './app-routing.module';
import {AppComponent} from './app.component';
import {ReserveringListComponent} from './component/reservering/reservering-list/reservering-list.component';
import {PageNotFoundComponent} from './component/page-not-found/page-not-found.component';
import {HttpClientModule} from '@angular/common/http';
import {FormsModule} from '@angular/forms';
import {BezoekersComponent} from './component/bezoekers/bezoekers.component';
import { BesmettingReportComponent } from './component/besmetting-report/besmetting-report.component';
import { ReserveringDetailComponent } from './component/reservering/reservering-detail/reservering-detail.component';
import { ReserveringCreateComponent } from './component/reservering/reservering-create/reservering-create.component';

@NgModule({
  declarations: [
    AppComponent,
    ReserveringListComponent,
    PageNotFoundComponent,
    BezoekersComponent,
    BesmettingReportComponent,
    ReserveringDetailComponent,
    ReserveringCreateComponent
  ],
    imports: [
        BrowserModule,
        AppRoutingModule,
        HttpClientModule,
        FormsModule
    ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
