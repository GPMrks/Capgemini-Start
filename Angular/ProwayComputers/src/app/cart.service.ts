import { Injectable } from '@angular/core';
import { ICart } from './model/cart';

@Injectable({
  providedIn: 'root'
})
export class CartService {

  items: ICart[] = [];

  constructor() { }

  getCart() {
    this.items = JSON.parse(localStorage.getItem("cart") || "[]");
    return this.items;
  }

  addToCart(product: ICart) {
    this.items.push(product);
    localStorage.setItem("cart", JSON.stringify(this.items));
  }

  clearCart() {
    this.items = [];
    localStorage.clear();
  }

  removeProduct(productId: number) {
    this.items = this.items.filter(item => item.id !== productId);
    localStorage.setItem("cart", JSON.stringify(this.items));
  }
}
