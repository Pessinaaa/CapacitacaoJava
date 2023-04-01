import { Component } from '@angular/core';
import { LivrosService } from 'src/app/services/livros.service';
import { ILivro } from 'src/app/interfaces/livro';

@Component({
  selector: 'app-livros',
  templateUrl: './livros.component.html',
  styleUrls: ['./livros.component.css']
})
export class LivrosComponent {
  livros: ILivro[] = [];
  constructor(private livrosService: LivrosService) {}

  ngOnInit() {
    this.livrosService.buscarTodosLivros().subscribe((result: ILivro[]) => {
      this.livros = result;
    });
  }
}
