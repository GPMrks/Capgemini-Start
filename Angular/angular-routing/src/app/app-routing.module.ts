import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AuthGuard } from './auth.guard';
import { FirstPageComponent } from './first-page/first-page.component';
import { LoginComponent } from './login/login.component';
import { PageNotFoundComponent } from './page-not-found/page-not-found.component';
import { PageParametersComponent } from './page-parameters/page-parameters.component';
import { ProtectedPageComponent } from './protected-page/protected-page.component';
import { SecondPageComponent } from './second-page/second-page.component';

const routes: Routes = [
  { path: "first-page", component: FirstPageComponent },
  { path: "second-page", component: SecondPageComponent },
  { path: "login", component: LoginComponent },
  { path: "", redirectTo: "first-page", pathMatch: "full" },
  { path: "page-parameters/:id", component: PageParametersComponent },
  { path: "protected-page", component: ProtectedPageComponent, canActivate: [AuthGuard] },
  { path: 'lazy-loading', loadChildren: () => import('./lazy-loading/lazy-loading.module').then(m => m.LazyLoadingModule) },
  { path: "**", component: PageNotFoundComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
