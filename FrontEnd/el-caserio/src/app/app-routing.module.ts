import { NgModule } from '@angular/core';
import { ExtraOptions, RouterModule, Routes } from '@angular/router';
import { LandingPageComponent } from './landing-page/landing-page.component';
import { MenuComponent } from './menu/menu.component';
import { ProductoDetallesComponent } from './producto-detalles/producto-detalles.component';
import { PedidoComponent } from './pedido/pedido.component';
import { AdminComponent } from './admin/admin.component';

const routes: Routes = [
  { path: 'inicio', component: LandingPageComponent},
  { path: '', redirectTo: 'inicio', pathMatch:'full'},
  { path: 'menu', component: MenuComponent },
  { path: 'producto-detalles/:id', component: ProductoDetallesComponent },
  { path: 'pedido', component: PedidoComponent },
  { path: 'admin-el-caserio', component: AdminComponent },
];

const routerOptions: ExtraOptions = {
  scrollPositionRestoration: 'top', // Esto asegura que la posición se restablezca al inicio
};

@NgModule({
  imports: [RouterModule.forRoot(routes, routerOptions)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
