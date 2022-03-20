import { Component, OnInit } from '@angular/core';
import {CustomerService} from "../services/customer-service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-customer-delete',
  templateUrl: './customer-delete.component.html',
  styleUrls: ['./customer-delete.component.css']
})
export class CustomerDeleteComponent implements OnInit {

  constructor(private customerService: CustomerService, private route: Router) { }

  ngOnInit(): void {
  }

  delete(id: number) {
    if (confirm("Are you sure to delete?")) {
      this.customerService.removeCustomer(id).subscribe(next => {
        this.customerService.findAll().subscribe()
      })
    }
  }
}
