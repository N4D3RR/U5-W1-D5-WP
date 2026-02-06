package naderdeghaili.u5w1d5wp.entities;


import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "prenotazioni")
public class Prenotazione {

    @Id
    @GeneratedValue
    private Long id;

    private LocalDate data;

    @ManyToOne
    @JoinColumn(name = "postazione_id")
    private Postazione postazione;

    @ManyToOne
    @JoinColumn(name = "utente_id")
    private Utente utente;


    //costruttori
    public Prenotazione() {
    }

    public Prenotazione(LocalDate data, Postazione postazione, Utente utente) {
        this.data = data;
        this.postazione = postazione;
        this.utente = utente;
    }


    //gettter e setter
    public Long getId() {
        return id;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public Postazione getPostazione() {
        return postazione;
    }

    public void setPostazione(Postazione postazione) {
        this.postazione = postazione;
    }

    public Utente getUtente() {
        return utente;
    }

    public void setUtente(Utente utente) {
        this.utente = utente;
    }


    //toString
    @Override
    public String toString() {
        return "Prenotazione: " +
                " | id: " + id +
                " | data: " + data +
                " | id postazione: " + postazione.getId() +
                " | tipo postazione: " + postazione.getTipo() +
                " | id utente: " + utente;
    }
}
