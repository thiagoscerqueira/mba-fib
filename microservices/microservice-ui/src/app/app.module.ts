import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';


import { AppComponent } from './app.component';
import {NavbarComponent} from './navbar/navbar.component';
import {CalendarModule, DataTableModule, InputMaskModule, InputTextModule} from 'primeng/primeng';
import {ButtonModule} from 'primeng/button';
import {FormsModule} from '@angular/forms';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import {HttpClientModule} from '@angular/common/http';
import { AutorPesquisaComponent } from './autor-pesquisa/autor-pesquisa.component';
import { AutorCadastroComponent } from './autor-cadastro/autor-cadastro.component';
import {AutorService} from './service/autor.service';
import {RouterModule, Routes} from '@angular/router';

const appRoutes: Routes = [
  { path: 'autores', component: AutorPesquisaComponent },
  { path: 'autores/novo', component: AutorCadastroComponent },
  { path: 'autores/editar/:id', component: AutorCadastroComponent },
  { path: '',
    redirectTo: '/autores',
    pathMatch: 'full'
  }
];

@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    AutorPesquisaComponent,
    AutorCadastroComponent
  ],
  imports: [
    RouterModule.forRoot(
      appRoutes,
      { enableTracing: true } // <-- debugging purposes only
    ),
    BrowserModule,
    HttpClientModule,
    BrowserAnimationsModule,
    FormsModule,

    DataTableModule,
    ButtonModule,
    InputTextModule,
    InputMaskModule,
    CalendarModule
  ],
  providers: [AutorService],
  bootstrap: [AppComponent]
})
export class AppModule { }
