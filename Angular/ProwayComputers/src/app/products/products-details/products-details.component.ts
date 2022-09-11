import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { CartService } from 'src/app/cart.service';
import { ICart } from 'src/app/model/cart';
import { IProduct } from 'src/app/model/products';
import { NotificationService } from 'src/app/notification.service';
import { ProductsService } from 'src/app/products.service';

@Component({
  selector: 'app-products-details',
  templateUrl: './products-details.component.html',
  styleUrls: ['./products-details.component.css']
})
export class ProductsDetailsComponent implements OnInit {

  product: IProduct | undefined;
  ammount: number = 1;

  constructor(private productsService: ProductsService, private route: ActivatedRoute, private notification: NotificationService, private cart: CartService) { }

  ngOnInit(): void {
    const routeParams = this.route.snapshot.paramMap;
    const productId = Number(routeParams.get("id"));
    this.product = this.productsService.getOne(productId);
  }

  addToCart() {
    this.notification.notify("Product added to cart");
    const product: ICart = {
      ...this.product!,
      ammount: this.ammount
    }
    this.cart.addToCart(product);
  }

}
