import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { IProduct, products } from '../model/products';
import { ProductsService } from '../products.service';

@Component({
  selector: 'app-products',
  templateUrl: './products.component.html',
  styleUrls: ['./products.component.css']
})
export class ProductsComponent implements OnInit {

  products: IProduct[] | undefined;

  constructor(private productsService: ProductsService, private route: ActivatedRoute) { }

  ngOnInit(): void {
    const products = this.productsService.getAll();
    this.route.queryParamMap.subscribe(params => {
      const search = params.get("search")?.toLowerCase();

      if (search) {
        this.products = products.filter(product => product.description.toLowerCase().includes(search));
        return;
      }

      this.products = products;
    });
  }

}
