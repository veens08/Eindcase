import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {ReserveringComponent} from './component/reservering/reservering.component';
import {PageNotFoundComponent} from './component/page-not-found/page-not-found.component';

const routes: Routes = [
  {path: 'start', component: ReserveringComponent}, // todo aparte startpagina component maken
  // {path: 'reservering', component: ReserveringComponent},
  {path: 'not-found', component: PageNotFoundComponent},
  {path: '', redirectTo: '/start', pathMatch: 'full'}, // todo uncomment deze regel als een startpaginacomponent is gemaakt
  {path: '**', redirectTo: '/not-found'}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
