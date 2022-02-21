import { Component, OnInit } from '@angular/core';
import {Pet} from '../pet';

@Component({
  selector: 'app-pet',
  templateUrl: './pet.component.html',
  styleUrls: ['./pet.component.css']
})
export class PetComponent implements OnInit {
  pet: Pet = {
    name: 'puppie',
    img: 'https://www.google.com/url?sa=i&url=https%3A%2F%2Fcolombo.vn%2Fecom0081%2Fshop-thu-cung%2Fcun-con-1.html&psig=AOvVaw1qsltecyY97UoR4AS8vT7v&ust=1645101107622000&source=images&cd=vfe&ved=0CAsQjRxqFwoTCJD666ydhPYCFQAAAAAdAAAAABAD'
};
  constructor() { }

  ngOnInit(): void {
  }

}
