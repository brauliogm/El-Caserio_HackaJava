import { Directive, ElementRef, EventEmitter, Output, Renderer2, OnDestroy } from '@angular/core';

@Directive({
  selector: '[clickOutside]'
})
export class ClickOutsideDirective implements OnDestroy {
  @Output() clickOutside = new EventEmitter<void>();
  private clickListener: () => void;

  constructor(private elementRef: ElementRef, private renderer: Renderer2) {
    this.clickListener = this.renderer.listen('document', 'click', (event: Event) => {
      const targetElement = event.target as HTMLElement;
      const clickedInside = this.elementRef.nativeElement.contains(targetElement);
      if (!clickedInside) {
        this.clickOutside.emit();
      }
    });
  }

  ngOnDestroy() {
    if (this.clickListener) {
      this.clickListener();
    }
  }
}
