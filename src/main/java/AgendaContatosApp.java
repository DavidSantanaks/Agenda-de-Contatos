import dao.ContatoDAO;
import jakarta.persistence.EntityManager;
import modelo.Contatos;
import util.JPAUtil;

import java.util.List;
import java.util.Scanner;

public class AgendaContatosApp {
    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);
        var resp = 0;
        while(resp != 5) {
            switch (resp){
                case 1:
                    verContatos();
                    break;
                case 2:
                    cadastrar();
                    break;
                case 3:
                    atualizarContato();
                    break;
                case 4:
                    deletarContatos();
                    break;

            }
            exibirMenu();
            resp = ler.nextInt();
        }

    }

    public static void exibirMenu(){
        System.out.println("""
                AGENDA DE CONTATOS
                1- Ver contatos
                2- Adicionar contatos
                3- Atualizar contatos
                4- Excluir contato
                5- Sair
                """);

    }

    public static void cadastrar(){
        EntityManager em = JPAUtil.getEntityManager();
        ContatoDAO dao = new ContatoDAO(em);
        Scanner ler = new Scanner(System.in);
        System.out.println("Informe os dados abaixo:");
        System.out.println("Nome: ");
        String nome = ler.nextLine();
        System.out.print("Telefone: ");
        String tel = ler.nextLine();
        System.out.print("E-mail: ");
        String email = ler.nextLine();
        Contatos contato = new Contatos(nome,tel,email);
        em.getTransaction().begin();
        dao.cadastrarContato(contato);
        em.getTransaction().commit();
        em.close();
    }

    public static void verContatos(){
        EntityManager em = JPAUtil.getEntityManager();
        ContatoDAO dao = new ContatoDAO(em);
        Scanner ler = new Scanner(System.in);
        dao.todosContatos();
    }

    public static void atualizarContato(){
        EntityManager em = JPAUtil.getEntityManager();
        ContatoDAO dao = new ContatoDAO(em);
        Scanner ler = new Scanner(System.in);
        System.out.print("Informe o ID do contato");
        var id = ler.nextInt();
        //dao.atualizarContato(id "arrumar");
    }

    public static void deletarContatos(){
        EntityManager em = JPAUtil.getEntityManager();
        ContatoDAO dao = new ContatoDAO(em);
        Scanner ler = new Scanner(System.in);
        System.out.print("Informe o ID do contato para deletar");
        var deletar = ler.nextInt();
        em.getTransaction().begin();
        dao.deletarContato(deletar);
        em.getTransaction().commit();
        em.close();
    }


}
