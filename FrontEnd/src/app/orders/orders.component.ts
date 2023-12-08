import {Component, OnInit} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {ActivatedRoute, Router} from "@angular/router";
import {DatePipe, NgForOf} from "@angular/common";

@Component({
  selector: 'app-orders',
  standalone: true,
  imports: [
    NgForOf,
    DatePipe
  ],
  templateUrl: './orders.component.html',
  styleUrl: './orders.component.css'
})
export class OrdersComponent implements OnInit{
  orders: any;
  customerId!: number;
  constructor(private http: HttpClient, private router: Router, private activatedRoute: ActivatedRoute) {
    this.customerId =  this.activatedRoute.snapshot.params['customerId'];
  }

  ngOnInit() {
    this.http.get(`http://localhost:9999/order-service/orders/search/byCustomerId?customerId=${this.customerId}&projection=fullOrder`)
      .subscribe(data => {
      this.orders = data;
    }
    );
  }

  onGetOrderDetails(order: any) {
    this.router.navigate([`/order-details/${order.id}`]);
  }
}
