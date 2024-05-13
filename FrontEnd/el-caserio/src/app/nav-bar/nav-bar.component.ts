import { Component } from '@angular/core';
import { Directive, ElementRef, Output, EventEmitter, HostListener } from '@angular/core';
  

@Component({
  selector: 'app-nav-bar',
  templateUrl: './nav-bar.component.html',
  styleUrls: ['./nav-bar.component.css']
})
export class NavBarComponent {
  
  isMenuOpen = false;

  constructor() { }

  toggleMenu(): void {
    this.isMenuOpen = !this.isMenuOpen;
  }

  closeMenu(): void {
    this.isMenuOpen = false;
  }

}
