import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { AuthComponentComponent } from './components/auth-component/auth-component.component';
import { ChatComponentComponent } from './components/chat-component/chat-component.component';
import { GroupComponentComponent } from './components/group-component/group-component.component';
import { ProfileComponentComponent } from './components/profile-component/profile-component.component';
import { NotificationComponentComponent } from './components/notification-component/notification-component.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';

@NgModule({
  declarations: [
    AppComponent,
    AuthComponentComponent,
    ChatComponentComponent,
    GroupComponentComponent,
    ProfileComponentComponent,
    NotificationComponentComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
