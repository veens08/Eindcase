import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';

import {AppRoutingModule} from './app-routing.module';
import {AppComponent} from './app.component';
import {ReserveringListComponent} from './component/reservering/reservering-list/reservering-list.component';
import {PageNotFoundComponent} from './component/page-not-found/page-not-found.component';
import {HttpClientModule} from '@angular/common/http';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {BezoekDetailComponent} from './component/bezoek/bezoeker-detail/bezoek-detail.component';
import { BesmettingReportComponent } from './component/besmetting-report/besmetting-report.component';
import { ReserveringDetailComponent } from './component/reservering/reservering-detail/reservering-detail.component';
import { FilterPipe } from './pipe/filter.pipe';
import { BezoekListComponent } from './component/bezoek/bezoek-list/bezoek-list.component';
import { StartpaginaComponent } from './component/startpagina/startpagina.component';

@NgModule({
  declarations: [
    AppComponent,
    ReserveringListComponent,
    PageNotFoundComponent,
    BezoekDetailComponent,
    BesmettingReportComponent,
    ReserveringDetailComponent,
    FilterPipe,
    BezoekListComponent,
    StartpaginaComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
