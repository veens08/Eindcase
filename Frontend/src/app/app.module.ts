import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';

import {AppRoutingModule} from './app-routing.module';
import {AppComponent} from './app.component';
import {ReserveringComponent} from './component/reservering/reservering.component';
import {PageNotFoundComponent} from './component/page-not-found/page-not-found.component';
import {HttpClientModule} from '@angular/common/http';
import {StartComponent} from './component/start/start.component';
import {FormsModule} from '@angular/forms';
import {BezoekersComponent} from './component/bezoekers/bezoekers.component';
import { BesmettingReportComponent } from './component/besmetting-report/besmetting-report.component';

@NgModule({
  declarations: [
    AppComponent,
    ReserveringComponent,
    PageNotFoundComponent,
    StartComponent,
    BezoekersComponent,
    BesmettingReportComponent,
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
