import { Injectable } from '@angular/core';
import { ICart } from './model/cart';

@Injectable({
  providedIn: 'root'
})
export class CartService {

  items: ICart[] = [];

  constructor() { }

  getCart() {
    return JSON.parse(localStorage.getItem("cart") || "");
  }

  addToCart(product: ICart) {
    this.items.push(product);
    localStorage.setItem("cart", JSON.stringify(this.items));
  }

  clearCart() {
    this.items = [];
    localStorage.clear();
  }
}
