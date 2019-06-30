import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { AppRoutingModule } from './app-routing.module';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { AppComponent } from './app.component';

import { CreditCardFormComponent } from './creditcard-form/creditcard-form.component';
import { CreditCardListComponent } from './creditcard-list/creditcard-list.component';
import { CreditCardService } from './service/creditcard.service';

@NgModule({
  declarations: [
    AppComponent,
    CreditCardFormComponent,
    CreditCardListComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [CreditCardService],
  bootstrap: [AppComponent]
})
export class AppModule { }
