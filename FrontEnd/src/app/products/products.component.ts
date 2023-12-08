import {Component, OnInit} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {NgForOf} from "@angular/common";

@Component({
  selector: 'app-products',
  standalone: true,
  imports: [
    NgForOf
  ],
  templateUrl: './products.component.html',
  styleUrl: './products.component.css'
})
export class ProductsComponent implements OnInit{
  products: any;

  constructor(private http:HttpClient) { }

  ngOnInit() {
    this.http.get('http://localhost:9999/inventory-service/products?projection=fullProduct').subscribe(data => {
      console.log(data);
      this.products = data;
    });
  }

}
