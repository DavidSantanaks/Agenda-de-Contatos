package dao;

import jakarta.persistence.EntityManager;
import modelo.Contatos;

import java.util.ArrayList;
import java.util.List;

public class ContatoDAO {

    private EntityManager em;

    public ContatoDAO(EntityManager em){
        this.em = em;
    }

    public void cadastrarContato(Contatos contatos){
        this.em.persist(contatos);
    }

    public Contatos atualizarContato(int id,String nome){
        Contatos a = em.find(Contatos.class, id);
        a.setNome(nome);
        return a;
    }

    public String buscarPorId(int id){
      Contatos a = em.find(Contatos.class, id);
      return a.toString();
    }

    public List<Contatos> todosContatos(){
        String jpql = "SELECT p FROM Contatos as p";
        List<Contatos> a = em.createQuery(jpql, Contatos.class).getResultList();

        List<Contatos> receber = new ArrayList<>();
        for (Contatos lista: a ) {
            System.out.println(lista);
            receber.add(lista);
        }
        return receber;
    }

    public void deletarContato(int id){
        Contatos a = this.em.find(Contatos.class, id);
        this.em.remove(a);
    }
}
