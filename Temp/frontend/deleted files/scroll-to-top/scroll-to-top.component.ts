import { animate, style, transition, trigger } from '@angular/animations';
import { ViewportScroller } from '@angular/common';
import { Component, HostListener, Input, OnInit } from '@angular/core';

@Component({
  selector: 'app-scroll-to-top',
  templateUrl: './scroll-to-top.component.html',
  styles: [
    '.scroll-to-top {position: fixed}'
  ],
  animations: [
    trigger(
      'inOutAnimation', [
        transition(
          ':enter', [
            style({opacity: 0}),
            animate('0.5s ease-out',
              style({opacity: 1}))
          ]
        ),
        transition(
          ':leave', [
            style({opacity: 1}),
            animate('0.5s ease-in',
              style({opacity: 0}))
          ]
        ),
      ]
    )
  ]
})
export class ScrollToTopComponent implements OnInit {


  CONFIG = {
    POSITION_SIDE: 15,
    POSITION_BOTTOM: 15,
    SCROLL_TOP_SHOW_LIMIT: 300,
    IS_LEFT_SIDE_POSITION: false

  }
  // limit pixel, when to show button
  @Input() scrollTopShowLimit = this.CONFIG.SCROLL_TOP_SHOW_LIMIT;

  // additional class for the button such as color
  @Input() buttonClass = '';

  // default button color by angular material API
  @Input() buttonColor = 'primary';

  // Position the button on the left side, as in multiple languages
  @Input() isLeftSidePosition = this.CONFIG.IS_LEFT_SIDE_POSITION;
  @Input() positionSidePixelNumber = this.CONFIG.POSITION_SIDE;
  @Input() positionBottomPixelNumber = this.CONFIG.POSITION_BOTTOM;

  // param to show the button
  isShowScrollButton = false;

  styleScrollToTop = {};

  constructor(
    private viewportScroller: ViewportScroller
  ) { }

  @HostListener('window:scroll', ['$event'])
  onWindowScroll($event: any): void {
    this.getIsShowScrollButton();
  }

  ngOnInit(): void {
    this.getIsShowScrollButton();
    this.setStyleButtonScrollToTop();
  }

  // Initiate
  getIsShowScrollButton(): void {
    const pos = this.viewportScroller.getScrollPosition();
    const yPos = pos[1];
    this.isShowScrollButton = (yPos > this.scrollTopShowLimit);
  }

  // Scroll to top action
  clickScrollToTop(): void {
    this.viewportScroller.scrollToPosition([0, 0]);
  }

  // Set Button position
  setStyleButtonScrollToTop(): void {

    this.styleScrollToTop = {
      bottom: this.positionBottomPixelNumber + 'px'
    };

    const side =  (this.isLeftSidePosition)  ? 'left' : 'right';
    // this.styleScrollToTop[side] = this.positionSidePixelNumber + 'px';
  }


}
