import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {ReserveringComponent} from './component/reservering/reservering.component';
import {PageNotFoundComponent} from './component/page-not-found/page-not-found.component';
import {StartComponent} from './component/start/start.component';

const routes: Routes = [
  {path: 'start', component: StartComponent},
  {path: 'reservering', component: ReserveringComponent},
  {path: 'not-found', component: PageNotFoundComponent},
  {path: '', redirectTo: '/start', pathMatch: 'full'},
  {path: '**', redirectTo: '/not-found'}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
