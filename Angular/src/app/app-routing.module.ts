import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './pages/home/home.component';
import { LivrosComponent } from './pages/livros/livros.component';
import { CadastrarComponent } from './pages/cadastrar/cadastrar.component';
import { SobreComponent } from './pages/sobre/sobre.component';

const routes: Routes = [
  { path: '', redirectTo: '/home', pathMatch: 'full' }, // A rota padrão do domínio direcioará para a rota home
  { path: 'home', component: HomeComponent},
  { path: 'livros', component: LivrosComponent},
  { path: 'cadastrar', component: CadastrarComponent},
  { path: 'sobre', component: SobreComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
