import { Component, OnInit } from '@angular/core';
import { IProduct, products } from '../model/products';
import { ProductsService } from '../products.service';

@Component({
  selector: 'app-products',
  templateUrl: './products.component.html',
  styleUrls: ['./products.component.css']
})
export class ProductsComponent implements OnInit {

  products: IProduct[] | undefined;

  constructor(private productsService: ProductsService) { }

  ngOnInit(): void {
    this.products = this.productsService.getAll();
  }

}
