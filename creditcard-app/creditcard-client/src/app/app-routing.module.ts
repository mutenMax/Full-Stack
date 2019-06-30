import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { CreditCardFormComponent } from './creditcard-form/creditcard-form.component';
import { CreditCardListComponent } from './creditcard-list/creditcard-list.component';


const routes: Routes = [
  { path: 'creditcards', component: CreditCardListComponent, runGuardsAndResolvers: 'always' }
];

@NgModule({
  imports: [RouterModule.forRoot(routes, {onSameUrlNavigation: 'reload'})],
  exports: [RouterModule]
})
export class AppRoutingModule { }
