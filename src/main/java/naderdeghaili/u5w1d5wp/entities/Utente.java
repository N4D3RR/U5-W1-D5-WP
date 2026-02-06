package naderdeghaili.u5w1d5wp.entities;


import jakarta.persistence.*;

@Entity
@Table(name = "utenti")
public class Utente {

    @Id
    @GeneratedValue
    @Column(nullable = false)
    private Long id;

    private String username;
    private String nomeCognome;
    private String email;


    //costruttori
    public Utente() {
    }

    public Utente(String username, String nomeCognome, String email) {
        this.username = username;
        this.nomeCognome = nomeCognome;
        this.email = email;
    }

    
    //getter e setter
    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getNomeCognome() {
        return nomeCognome;
    }

    public void setNomeCognome(String nomeCognome) {
        this.nomeCognome = nomeCognome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    //toString
    @Override
    public String toString() {
        return "Utente:" +
                "id:" + id +
                " | username: '" + username +
                " | nomeCognome: '" + nomeCognome +
                " | email: '" + email
                ;
    }
}
