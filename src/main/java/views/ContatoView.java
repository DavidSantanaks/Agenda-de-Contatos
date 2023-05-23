package views;

import services.ContatoService;

import java.util.Scanner;

public class ContatoView {

    public void iniciarSoftware(){
        ContatoService contatoService = new ContatoService();
        Scanner ler = new Scanner(System.in);
        var resp = 0;
        while(resp != 5) {
            switch (resp){
                case 1:
                    contatoService.verContatos();
                    break;
                case 2:
                    contatoService.cadastrar();
                    break;
                case 3:
                    contatoService.atualizarContato();
                    break;
                case 4:
                    contatoService.deletarContatos();
                    break;
            }
            exibirMenu();
            resp = ler.nextInt();
        }
    }

    private static void exibirMenu(){
        System.out.println("""
                AGENDA DE CONTATOS
                1- Ver contatos
                2- Adicionar contatos
                3- Atualizar contatos
                4- Excluir contato
                5- Sair
                """);
    }

}
