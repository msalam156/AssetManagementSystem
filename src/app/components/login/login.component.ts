import { Component, OnInit } from '@angular/core';
import { UserService } from 'src/app/shared/user.service';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {

  constructor(private userService : UserService,
    private router : Router
    ) { }

  ngOnInit(): void {
  }
dataFromDB?:any ;
  submitLogin(form?:NgForm){
    this.userService.vaifyUser(form?.value).subscribe(
      response =>{
        this.dataFromDB = response;
        console.log(response);
        console.log(this.dataFromDB.data.role);
        console.log(this.dataFromDB.data.emailId);
        if(this.dataFromDB.data.role === 1){
          this.router.navigateByUrl('admin');
        }
        else if(this.dataFromDB.data.role === 2){
          this.router.navigateByUrl('purchageManager');
        }
        else if(this.dataFromDB.data.role === 3){
          this.router.navigateByUrl('vendor');
        }

      } ,
      erorr=>console.log(erorr)
    )
    
    // console.log(form?.value.username);
    // console.log(typeof form?.value.password);
  }
}
