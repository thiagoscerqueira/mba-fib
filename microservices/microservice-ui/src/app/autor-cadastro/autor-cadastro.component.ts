import { Component, OnInit } from '@angular/core';
import {AutorService} from '../service/autor.service';
import {FormControl} from '@angular/forms';
import {ActivatedRoute, Router} from '@angular/router';

@Component({
  selector: 'app-autor-cadastro',
  templateUrl: './autor-cadastro.component.html',
  styleUrls: ['./autor-cadastro.component.css']
})
export class AutorCadastroComponent implements OnInit {

  item: any = {};
  private id: number;
  action = 'Adicionar';

  constructor(private autorService: AutorService, private route: ActivatedRoute, private router: Router) { }

  ngOnInit() {
    this.route.params.subscribe(params => {
      if (!params.hasOwnProperty('id')) {
        this.item.nome = '';
        return;
      }

      this.id = +params['id'];
      this.autorService.consultar(this.id).subscribe(item => this.item = item);
      this.action = 'Alterar';
    });
  }

  submit(frm: FormControl) {

    if (this.action === 'Alterar') {
      this.autorService.alterar(this.id, frm.value)
        .subscribe(() => {
          this.router.navigate(['/autores']);
        });
    } else {
      this.autorService.adicionar(frm.value)
        .subscribe(() => {
          this.router.navigate(['/autores']);
        });
    }
  }
}
