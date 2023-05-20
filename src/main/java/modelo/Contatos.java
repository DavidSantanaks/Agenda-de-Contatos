package modelo;


import jakarta.persistence.*;

@Entity
@Table(name = "contatos")
public class Contatos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nome;
    private String telefone;
    private String email;

    //construtores
    public Contatos(){}

    public Contatos(String nome, String telefone, String email) {
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
    }

    //gets e sets
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    //overide

    @Override
    public String toString() {
        return "Contato" + '\n'+
                "ID: " + id + '\n' +
                "Nome: " + nome + '\n'+
                "Telefone: " + telefone + '\n'+
                "Email: " + email + '\n';
    }
}
