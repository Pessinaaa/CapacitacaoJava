import { Component } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { ILivro } from 'src/app/interfaces/livro';
import { LivrosService } from 'src/app/services/livros.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-cadastrar-atualizar-livros',
  templateUrl: './cadastrar-atualizar-livros.component.html',
  styleUrls: ['./cadastrar-atualizar-livros.component.css']
})
export class CadastrarAtualizarLivrosComponent {
  constructor(private livrosService: LivrosService, private route: ActivatedRoute, private router: Router) { }

  livroForm = new FormGroup({
    titulo: new FormControl('', Validators.required),
    ano: new FormControl(0, Validators.required)
  })

  livroId = 0;

  ngOnInit() {
  this.livroId = Number(this.route.snapshot.paramMap.get('id'));
    this.livrosService.buscarLivroPorId(this.livroId).subscribe((livro: ILivro) => {
      this.livroForm.setValue({
        titulo: livro.titulo,
        ano: livro.ano || 0
      })
    });
  }

  cadastrar() {
    const livro: ILivro = this.livroForm.value as ILivro;
    this.livrosService.cadastrarLivro(livro).subscribe(result => {
      Swal.fire({
        title: 'Sucesso',
        text: 'Livro cadastrado',
        icon: 'success',
        confirmButtonText: 'Ok'
      }).then(() => {
        window.location.reload();
        });
    }, error => {
      Swal.fire({
        title: 'Erro',
        text: error(error),
        icon: 'error',
        confirmButtonText: 'Ok'
      });
    });
  }

  editar() {
    const livro: ILivro = this.livroForm.value as ILivro;
    this.livrosService.editarLivro(this.livroId, livro).subscribe(result => {
      Swal.fire({
        title: 'Sucesso',
        text: 'Livro alterado',
        icon: 'success',
        confirmButtonText: 'Ok'
      }).then(() => {
        this.router.navigateByUrl('/livros');
        });
    }, error => {
      Swal.fire({
        title: 'Erro',
        text: error(error),
        icon: 'error',
        confirmButtonText: 'Ok'
      });
    });
  }

  cadastraOuEdita() {
    if (this.livroId) {
      this.editar();
    } else {
      this.cadastrar();
    }
  }
}
