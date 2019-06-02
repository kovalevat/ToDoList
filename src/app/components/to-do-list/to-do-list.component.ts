import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-to-do-list',
  templateUrl: './to-do-list.component.html',
  styleUrls: ['./to-do-list.component.css']
})
export class ToDoListComponent implements OnInit {


options:string[];
  constructor() { }

  ngOnInit() {

  this.options=[];
  }



AddOpt(option)
{
this.options.unshift(option);
return false;

}

DeleteOpt(option)
{
  for(let i=0;i<this.options.length;i++)
  {
    if(this.options[i]==option)
    {
      this.options.splice(i,1);
      break;
    }

  }
}

}
