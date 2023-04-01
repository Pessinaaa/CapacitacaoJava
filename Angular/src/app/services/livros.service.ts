import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from 'src/environment/environment';
import { ILivro } from 'src/app/interfaces/livro';

@Injectable({
  providedIn: 'root'
})
export class LivrosService {
  endpoint = 'livros';
  api = environment.api;
  constructor(private http: HttpClient) { }

  buscarTodosLivros() {
    return this.http.get<ILivro[]>(`${this.api}/${this.endpoint}`);
  }
}
