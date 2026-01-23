import { Routes } from '@angular/router';
import { HomeComponent } from './pages/home/home.component';
import { PublishersComponent } from './pages/publishers/publishers.component';
import { CreatePublishersComponent } from './pages/create-publishers/create-publishers.component';
import { LoginComponent } from './pages/login/login.component';
export const routes: Routes = [
    { path: '', component: HomeComponent },
    { path: 'publishers', component: PublishersComponent },
    { path: 'publishers/create', component: CreatePublishersComponent },
    { path: 'login', component: LoginComponent },
    { path: '**', redirectTo: '' },

];
