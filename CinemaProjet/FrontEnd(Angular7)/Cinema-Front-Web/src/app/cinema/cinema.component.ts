import {Component, OnInit} from '@angular/core';
import {HttpClient, HttpClientModule} from '@angular/common/http';
import {CinemaService} from '../services/cinema.service';

@Component({
  selector: 'app-cinema',
  templateUrl: './cinema.component.html',
  styleUrls: ['./cinema.component.css']
})
export class CinemaComponent implements OnInit {
  public villes;
  public cinemas;
  public salles;
  public currentVille;
  public currentCinema;
  public currentProjection;
  public selectTickets;

  constructor(public cinemaService: CinemaService) {
  }

  ngOnInit() {

    this.cinemaService.getVilles()
      .subscribe(data => {
        this.villes = data;
      }, err => {
        console.log(err);
      });
  }

  onGetCinemas(v) {
    this.currentVille = v;
    this.salles = undefined;
    this.cinemaService.getCinemas(v).subscribe(data => {
      this.cinemas = data;
    }, err => {
      console.log(err);
    });
  }

  onGetSalles(c) {
    this.currentCinema = c;
    this.cinemaService.getSalles(c).subscribe(data => {
      this.salles = data;
      this.salles._embedded.salles.forEach(salle => {
        this.cinemaService.getProjections(salle)
          .subscribe(data => {
            salle.projections = data;
          }, err => {
            console.log(err);
          });


      });
    }, err => {
      console.log(err);
    });
  }

  onGetTicketsPlaces(p) {
    this.currentProjection = p;
    console.log(p);
    this.cinemaService.getTicketsPlaces(p)
      .subscribe(data => {
        this.currentProjection.tickets = data;
        this.selectTickets = [];
      }, err => {
        console.log(err);
      });
  }

  onSelectTicket(t) {

    if (!t.selected) {
      t.selected = true;
      this.selectTickets.push(t);

    } else {
      t.selected = false;
      this.selectTickets.splice(this.selectTickets.indexOf(t), 1);


    }
    console.log(this.selectTickets);
  }

  getTicketClass(t) {

    let str = 'btn ticket ';
    if (t.reserve == true) {

      str += 'btn-danger';
    } else if (t.selected) {
      str += 'btn-warning';
    } else {

      str += 'btn-success';
    }
    return str;
  }
  onPayTickets(dataForm){
       let tickets=[];
       this.selectTickets.forEach(t=>{
         tickets.push(t.id);
         });
    dataForm.tickets=tickets;
    console.log(dataForm);
    this.cinemaService.payerTickets(dataForm)
      .subscribe(data => {
        alert("ticket reserved");
          this.onGetTicketsPlaces(this.currentProjection);
      }, err => {
        console.log(err);
      });

  }
  // [ngClass]="t.reserve==true?'btn btn-danger ticket':'btn btn-success ticket'"

}
