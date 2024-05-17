import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LandingPageComponent } from './landing-page/landing-page.component';
import { MenuComponent } from './menu/menu.component';
import { ProductoDetallesComponent } from './producto-detalles/producto-detalles.component';
import { PedidoComponent } from './pedido/pedido.component';

const routes: Routes = [
  { path: 'inicio', component: LandingPageComponent},
  { path: '', redirectTo: 'inicio', pathMatch:'full'},
  { path: 'menu', component: MenuComponent },
  { path: 'producto-detalles', component: ProductoDetallesComponent },
  { path: 'pedido', component: PedidoComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
