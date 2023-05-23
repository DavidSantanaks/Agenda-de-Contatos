import dao.ContatoDAO;
import jakarta.persistence.EntityManager;
import modelo.Contatos;
import util.JPAUtil;
import views.ContatoView;

import java.util.Scanner;

public class AgendaContatosApp {
    public static void main(String[] args) {
        ContatoView contatoView = new ContatoView();
        contatoView.iniciarSoftware();
    }

}
