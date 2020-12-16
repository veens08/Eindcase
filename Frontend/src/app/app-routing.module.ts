import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {ReserveringListComponent} from './component/reservering/reservering-list/reservering-list.component';
import {PageNotFoundComponent} from './component/page-not-found/page-not-found.component';
import {BesmettingReportComponent} from './component/besmetting-report/besmetting-report.component';
import {ReserveringDetailComponent} from './component/reservering/reservering-detail/reservering-detail.component';
import {BezoekListComponent} from './component/bezoek/bezoek-list/bezoek-list.component';
import {StartpaginaComponent} from './component/startpagina/startpagina.component';

const routes: Routes = [
  {path: 'startpagina', component: StartpaginaComponent},
  {path: 'reserveringen', component: ReserveringListComponent},
  {path: 'reservering/:id', component: ReserveringDetailComponent},
  {path: 'bezoeken', component: BezoekListComponent},
  {path: 'besmetting-report/:', component: BesmettingReportComponent},
  {path: 'not-found', component: PageNotFoundComponent},
  {path: '', redirectTo: '/startpagina', pathMatch: 'full'},
  {path: '**', redirectTo: '/not-found'}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
