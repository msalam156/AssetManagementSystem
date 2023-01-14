import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AdminComponent } from './components/admin/admin.component';
import { VendorComponent } from './components/vendor/vendor.component';
import { PurchangeManagerComponent} from './components/purchange-manager/purchange-manager.component'
import { LoginComponent } from './components/login/login.component';

const routes: Routes = [
  {path:'',redirectTo:'/login',pathMatch:'full'},
  {path:'admin',component: AdminComponent},
  {path:'vendor',component: VendorComponent},
  {path:'purchageManager',component: PurchangeManagerComponent},
  {path:'login',component: LoginComponent},

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
