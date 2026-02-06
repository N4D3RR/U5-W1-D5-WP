package naderdeghaili.u5w1d5wp.entities;


import jakarta.persistence.*;

@Entity
@Table(name = "edifici")
public class Edificio {

    @Id
    @GeneratedValue
    @Column(nullable = false)
    private Long id;

    private String nome;
    private String indirizzo;
    private String citta;


    //costruttori
    public Edificio() {
    }

    public Edificio(String nome, String indirizzo, String citta) {
        this.nome = nome;
        this.indirizzo = indirizzo;
        this.citta = citta;
    }


    //getter e setter
    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getIndirizzo() {
        return indirizzo;
    }

    public void setIndirizzo(String indirizzo) {
        this.indirizzo = indirizzo;
    }

    public String getCitta() {
        return citta;
    }

    public void setCitta(String citta) {
        this.citta = citta;
    }


    //toString
    @Override
    public String toString() {
        return "Edificio:" +
                " nome: '" + nome +
                " | id: " + id +
                " | indirizzo:" + indirizzo +
                " | citta: '" + citta;
    }
}
