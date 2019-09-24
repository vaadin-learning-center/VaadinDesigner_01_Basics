import {html, PolymerElement} from '@polymer/polymer/polymer-element.js';
import '@vaadin/vaadin-ordered-layout/src/vaadin-vertical-layout.js';
import '@vaadin/vaadin-ordered-layout/src/vaadin-horizontal-layout.js';
import './my-first-component.js';
import '@vaadin/vaadin-grid/src/vaadin-grid.js';

class MyFirstView extends PolymerElement {

    static get template() {
        return html`
<style include="shared-styles">
                :host {
                    display: block;
                    height: 100%;
                }
            </style>
<vaadin-vertical-layout style="width: 100%; height: 100%;">
 <vaadin-horizontal-layout class="header" style="width: 100%; min-height: var(--lumo-size-l); background-color: var(--lumo-contrast-10pct)">
  <h1>My first view</h1>
 </vaadin-horizontal-layout>
 <vaadin-vertical-layout class="content" style="width: 100%; min-height: 0; flex: 1; align-items: stretch;">
  <my-first-component id="myFirstComponent"></my-first-component>
  <vaadin-grid id="vaadinGrid"></vaadin-grid>
 </vaadin-vertical-layout>
 <vaadin-horizontal-layout class="footer" style="width: 100%; min-height: var(--lumo-size-l); background-color: var(--lumo-contrast-10pct)">
  <h4>Heading 4</h4>
 </vaadin-horizontal-layout>
</vaadin-vertical-layout>
`;
    }

    static get is() {
        return 'my-first-view';
    }

    static get properties() {
        return {
            // Declare your properties here.
        };
    }
}

customElements.define(MyFirstView.is, MyFirstView);
