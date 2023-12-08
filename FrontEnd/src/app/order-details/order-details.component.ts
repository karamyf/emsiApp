import {Component, OnInit} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {ActivatedRoute, Router} from "@angular/router";
import {DatePipe, DecimalPipe, JsonPipe, NgForOf} from "@angular/common";

@Component({
  selector: 'app-order-details',
  standalone: true,
  imports: [
    JsonPipe,
    DatePipe,
    NgForOf,
    DecimalPipe
  ],
  templateUrl: './order-details.component.html',
  styleUrl: './order-details.component.css'
})
export class OrderDetailsComponent implements OnInit{
  order: any;
  orderId!: number;
  orderItems!: [];
  constructor(private http: HttpClient, private router: Router, private activatedRoute: ActivatedRoute) {
    this.orderId =  this.activatedRoute.snapshot.params['orderId'];
  }

  ngOnInit() {
    this.http.get(`http://localhost:9999/order-service/fullOrder/${this.orderId}`)
      .subscribe(data => {
      this.order = data;
    }
    );
  }

}
