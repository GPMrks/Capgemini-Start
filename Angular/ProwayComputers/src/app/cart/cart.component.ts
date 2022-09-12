import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { CartService } from '../cart.service';
import { ICart } from '../model/cart';

@Component({
  selector: 'app-cart',
  templateUrl: './cart.component.html',
  styleUrls: ['./cart.component.css']
})
export class CartComponent implements OnInit {

  itemsCart: ICart[] = [];

  total: number = 0;

  constructor(public cartService: CartService, private router: Router) { }

  ngOnInit(): void {
    this.itemsCart = this.cartService.getCart();
    this.sumTotal();
  }

  sumTotal() {
    this.total = this.itemsCart.reduce((prev, curr) => (prev + curr.price * curr.ammount), 0 );
  }

  removeProduct(productId: number) {
    this.itemsCart = this.itemsCart.filter(item => item.id !== productId);
    this.cartService.removeProduct(productId);
    this.sumTotal();
  }

  buy() {
    alert("Congratulations, you've completed your purchase!");
    this.cartService.clearCart();
    this.router.navigate(["products"]);
  }
}
