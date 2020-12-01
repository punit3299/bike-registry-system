import { Component, OnInit } from '@angular/core';
import { FormGroup, Validators, FormBuilder } from '@angular/forms';
import { Observable } from 'rxjs';
import { BikeService } from 'src/app/services/bike.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
  models: string[] = [
    'Globo MYB 29 Full Suspension',
    'Globo Carbon Fibre Race Series',
    'Globo Time Trial Blade'
  ]

  validMessage: string = "";
  bikeForm: FormGroup;

  constructor(private bikeService: BikeService, private formBuilder: FormBuilder) { }

  ngOnInit() {

    this.bikeForm = this.formBuilder.group({
      name:['',[Validators.required]],
      email:['',[Validators.required]],
      phone:['',[Validators.required]],
      model:['',[Validators.required]],
      serialNumber:['',[Validators.required]],
      purchasePrice:['',[Validators.required]],
      purchaseDate:['',[Validators.required]],
      contact:['',[Validators.required]]
    });
  }

  submitRegistration() {
    // if (this.bikeForm.valid) {
      console.log(this.bikeForm.value)
      this.bikeService.createBikeRegistration(this.bikeForm.value).subscribe(data => {
        this.bikeForm.reset();
        this.validMessage = "Bike registered successfully !";
        return true;
      },
        error => {
          return Observable.throw(error);
        }
      )
    }
    // else {
    //   this.validMessage = "Please fill out form before submitting !";
    // }

}
