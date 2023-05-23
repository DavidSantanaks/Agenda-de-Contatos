package services;

import dao.ContatoDAO;
import jakarta.persistence.EntityManager;
import modelo.Contatos;
import util.JPAUtil;

import java.util.Scanner;

public class ContatoService {

    private ContatoDAO dao;

    public ContatoService(){
        this.dao = new ContatoDAO();
    }

    public  void cadastrar(){
        Scanner ler = new Scanner(System.in);
        System.out.println("Informe os dados abaixo:");
        System.out.println("Nome: ");
        String nome = ler.nextLine();
        System.out.print("Telefone: ");
        String tel = ler.nextLine();
        System.out.print("E-mail: ");
        String email = ler.nextLine();
        Contatos contato = new Contatos(nome,tel,email);
        dao.cadastrarContato(contato);

    }

    public  void verContatos(){
        EntityManager em = JPAUtil.getEntityManager();
        ContatoDAO dao = new ContatoDAO();
        Scanner ler = new Scanner(System.in);
        System.out.println("""
               1- Ver todos os contatos 
               2- Unico contato
                """);
        var resp = ler.nextInt();
        if(resp == 1){
            dao.todosContatos();
        } else if (resp == 2) {
            System.out.print("Informe o ID do contato: ");
            var o = ler.nextInt();
            System.out.println(dao.buscarPorId(o));
        }

    }

    public  void atualizarContato(){
        EntityManager em = JPAUtil.getEntityManager();
        ContatoDAO dao = new ContatoDAO();
        Scanner ler = new Scanner(System.in);
        System.out.print("Informe o ID do contato: ");
        var id = ler.nextInt();
        dao.attContato(id);
    }

    public  void deletarContatos(){
        EntityManager em = JPAUtil.getEntityManager();
        ContatoDAO dao = new ContatoDAO();
        Scanner ler = new Scanner(System.in);
        System.out.print("Informe o ID do contato para deletar: ");
        var deletar = ler.nextInt();
        dao.deletarContato(deletar);

    }
}
