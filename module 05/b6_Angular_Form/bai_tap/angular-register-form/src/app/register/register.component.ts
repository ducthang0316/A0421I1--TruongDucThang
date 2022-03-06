import {Component, EventEmitter, OnInit, Output} from '@angular/core';
import {FormControl, FormGroup, Validators} from '@angular/forms';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  @Output() submitCreate = new EventEmitter();

  registerForm: FormGroup;

  constructor() {
    this.registerForm = new FormGroup({
      id: new FormControl('', [Validators.required]),
      email: new FormControl('', [Validators.email, Validators.required]),
      password: new FormControl('', [Validators.minLength(6), Validators.required]),
      confPassword: new FormControl('', [Validators.minLength(6), Validators.required]),
      country: new FormControl('', [ Validators.required]),
      age: new FormControl('', [ Validators.required, Validators.min(18)]),
      gender: new FormControl('', [ Validators.required]),
      phone: new FormControl('', [Validators.pattern('^\\+84\\d{9,10}$')])
    });
  }

  ngOnInit(): void {
  }

  // createUser(registerForm: any) {
  //   console.log(registerForm);
  //   this.submitCreate.emit(registerForm.value);
  // }

  createUser() {
    console.log(this.registerForm);
    this.submitCreate.emit(this.registerForm.value);
  }
}
