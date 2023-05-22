package dao;

import exceptions.CttNaoEncontradoException;
import exceptions.DeletarException;
import jakarta.persistence.EntityManager;
import modelo.Contatos;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ContatoDAO {


    private EntityManager em;

    //Construtor
    public ContatoDAO(EntityManager em){
        this.em = em;
    }

    //Metodos
    public void cadastrarContato(Contatos contatos){
        this.em.getTransaction().begin();
        this.em.persist(contatos);
        this.em.getTransaction().commit();
        this.em.close();
        System.out.println("Contato salvo com sucesso \n");
    }

    public void attContato(int id){
        Scanner ler = new Scanner(System.in);
        Contatos contatoAtualizado =  this.em.find(Contatos.class, id);

        System.out.println("""
                    1- Atualizar nome
                    2- Atualizar numero
                    3- Atualizar e-mail
                    """);
        int resp = ler.nextInt();
        ler.nextLine();

        if (resp == 1) {
            System.out.println("Informe um nome");
            String nome = ler.nextLine();

            this.em.getTransaction().begin();
            contatoAtualizado = this.em.merge(contatoAtualizado);
            contatoAtualizado.setNome(nome);
            this.em.getTransaction().commit();
            this.em.close();
            System.out.println("Nome atualizado: " + contatoAtualizado.getNome() + "\n" );
        } else if (resp == 2) {
            System.out.println("Informe o numero");
            String numero = ler.nextLine();
            this.em.getTransaction().begin();
            contatoAtualizado = this.em.merge(contatoAtualizado);
            contatoAtualizado.setTelefone(numero);
            this.em.getTransaction().commit();
            this.em.close();
            System.out.println("Numero atualizado: " + contatoAtualizado.getTelefone() + "\n");
        } else if (resp == 3) {
            System.out.println("Informe o e-mail");
            String email = ler.nextLine();
            this.em.getTransaction().begin();
            contatoAtualizado = this.em.merge(contatoAtualizado);
            contatoAtualizado.setEmail(email);
            this.em.getTransaction().commit();
            this.em.close();
            System.out.println("E-mail atualizado: " + contatoAtualizado.getEmail() + "\n");
        }
    }

    public String buscarPorId(int id){
        Contatos a =this.em.find(Contatos.class, id);
        if(a == null){
            //Exception
            CttNaoEncontradoException resp = new CttNaoEncontradoException("Contato não encontrado");
            return resp.getMessage();
        }else{
            return a.toString();
        }

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
        if (a == null){
            DeletarException deletarException = new DeletarException("Contato não existe");
            System.out.println(deletarException.getMessage() + '\n');
        }else{
            this.em.getTransaction().begin();
            this.em.remove(a);
            this.em.getTransaction().commit();
            this.em.close();
        }

    }
}
