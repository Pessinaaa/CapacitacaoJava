import { Component } from '@angular/core';
import { LivrosService } from 'src/app/services/livros.service';
import { ILivro } from 'src/app/interfaces/livro';
import { ActivatedRoute, Router } from '@angular/router';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-livros',
  templateUrl: './livros.component.html',
  styleUrls: ['./livros.component.css']
})
export class LivrosComponent {
  livros: ILivro[] = [];
  constructor(private livrosService: LivrosService, private route: ActivatedRoute, private router: Router) {}

  ngOnInit() {
    this.livrosService.buscarTodosLivros().subscribe((result: ILivro[]) => {
      this.livros = result;
    });
    if (Number(this.route.snapshot.paramMap.get('id'))) {
      this.deletar();
    }
  }

  deletar() {
    Swal.fire({
      title: 'Deletar livro',
      text: "Deseja mesmo deletar o livro?",
      icon: 'warning',
      showCancelButton: true,
      confirmButtonColor: '#3085d6',
      cancelButtonColor: '#d33',
      confirmButtonText: 'Sim',
      cancelButtonText: 'Não'
    }).then((result) => {
      if (result.isConfirmed) {
        this.livrosService.deletarLivro(Number(this.route.snapshot.paramMap.get('id'))).subscribe(result => {}, error => {
          Swal.fire({
            title: 'Erro',
            text: error(error),
            icon: 'error',
            confirmButtonText: 'Ok'
          });
        });
      }
      this.router.navigateByUrl('/livros');
    });
  }
}
