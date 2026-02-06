package naderdeghaili.u5w1d5wp.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "postazioni")
public class Postazione {

    @Id
    @GeneratedValue
    private Long id;

    private String descrizione;

    @Enumerated(EnumType.STRING)
    private PostazioneTipo tipo;

    private int occupantiMassimi;

    @ManyToOne
    @JoinColumn(name = "edificio_id")
    private Edificio edificio;


    //costruttori
    public Postazione() {
    }

    public Postazione(Edificio edificio, int occupantiMassimi, PostazioneTipo tipo, String descrizione) {
        this.edificio = edificio;
        this.occupantiMassimi = occupantiMassimi;
        this.tipo = tipo;
        this.descrizione = descrizione;
    }


    //getter e setter
    public Long getId() {
        return id;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public PostazioneTipo getTipo() {
        return tipo;
    }

    public void setTipo(PostazioneTipo tipo) {
        this.tipo = tipo;
    }

    public int getOccupantiMassimi() {
        return occupantiMassimi;
    }

    public void setOccupantiMassimi(int occupantiMassimi) {
        this.occupantiMassimi = occupantiMassimi;
    }

    public Edificio getEdificio() {
        return edificio;
    }

    public void setEdificio(Edificio edificio) {
        this.edificio = edificio;
    }


    //toString
    @Override
    public String toString() {
        return "Postazione: " +
                "id: " + id +
                " | descrizione: " + descrizione +
                " | tipo: " + tipo +
                " | occupantiMassimi: " + occupantiMassimi +
                " | edificio: " + edificio.getNome() +
                " | città: " + edificio.getCitta()

                ;
    }
}
