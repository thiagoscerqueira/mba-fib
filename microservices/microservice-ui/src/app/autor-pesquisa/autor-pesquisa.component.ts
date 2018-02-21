import { Component, OnInit } from '@angular/core';
import {AutorService} from '../service/autor.service';

@Component({
  selector: 'app-autor-pesquisa',
  templateUrl: './autor-pesquisa.component.html',
  styleUrls: ['./autor-pesquisa.component.css']
})
export class AutorPesquisaComponent implements OnInit {

  itens = [];
  constructor(private autorService: AutorService) { }

  ngOnInit() {
    this.consultar();
  }

  consultar() {
    this.autorService.listar().subscribe(dados => this.itens = dados);
  }

  excluir(id) {
    this.autorService.excluir(id).subscribe(res => {
      this.consultar();
    });
  }

}
