import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';

@Injectable()
export class AutorService {

  autorUrl = 'http://localhost:8090/autor';

  constructor(private http: HttpClient) { }

  listar() {
    return this.http.get<any>(this.autorUrl);
  }

  excluir(id) {
    console.log(id);
    return this.http.delete(this.autorUrl + '/' + id);
  }

  adicionar(item: any) {
    return this.http.post(this.autorUrl, item);
  }

  alterar(id, item: any) {
    return this.http.put(this.autorUrl + '/' + id, item);
  }

  consultar(id) {
    return this.http.get<any>(this.autorUrl + '/' + id);
  }

}
