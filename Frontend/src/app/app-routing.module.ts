import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {ReserveringListComponent} from './component/reservering/reservering-list/reservering-list.component';
import {PageNotFoundComponent} from './component/page-not-found/page-not-found.component';
import {BezoekersComponent} from './component/bezoekers/bezoekers.component';
import {BesmettingReportComponent} from './component/besmetting-report/besmetting-report.component';
import {ReserveringDetailComponent} from './component/reservering/reservering-detail/reservering-detail.component';
import {ReserveringCreateComponent} from './component/reservering/reservering-create/reservering-create.component';

const routes: Routes = [
  {path: 'reserveringen', component: ReserveringListComponent},
  {path: 'reservering/:id', component: ReserveringDetailComponent},
  {path: 'reservering-create', component: ReserveringCreateComponent},
  {path: 'bezoekers', component: BezoekersComponent},
  {path: 'besmetting-report', component: BesmettingReportComponent},
  {path: 'not-found', component: PageNotFoundComponent},
  {path: '', redirectTo: '/reserveringen', pathMatch: 'full'},
  {path: '**', redirectTo: '/not-found'}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
