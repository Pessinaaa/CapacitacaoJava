import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './pages/home/home.component';
import { LivrosComponent } from './pages/livros/livros.component';
import { CadastrarAtualizarLivrosComponent } from './pages/cadastrar-atualizar-livros/cadastrar-atualizar-livros.component';
import { SobreComponent } from './pages/sobre/sobre.component';

const routes: Routes = [
  { path: '', redirectTo: '/home', pathMatch: 'full' }, // A rota padrão do domínio direcioará para a rota home
  { path: 'home', component: HomeComponent},
  { path: 'livros', component: LivrosComponent},
  { path: 'livros/cadastrar', component: CadastrarAtualizarLivrosComponent},
  { path: 'livros/atualizar/:id', component: CadastrarAtualizarLivrosComponent},
  { path: 'sobre', component: SobreComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
