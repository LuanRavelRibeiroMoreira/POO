package com.gerenciadorDeEventosAcademicos.view;
import com.gerenciadorDeEventosAcademicos.controller.DetalhesEventoController;
import com.gerenciadorDeEventosAcademicos.model.Trabalho;
import com.gerenciadorDeEventosAcademicos.model.Evento;
import com.gerenciadorDeEventosAcademicos.model.Model;
import com.gerenciadorDeEventosAcademicos.model.Organizador;
import java.util.Scanner;

public class DetalhesEventoView implements Observer{

    private Model model;
    private DetalhesEventoController controller;
    private Evento eventoEscolhido;
    private int escolhaUsuario;
    public void initDetalhesEventoView(Model model, Evento eventoEscolhido) { // iniciando a tela de detalhes do evento
        this.model = model;
        this.eventoEscolhido = eventoEscolhido;
        controller = new DetalhesEventoController();
        controller.initDetalhesEventoController(model, this);
        model.attachObserver(this);
        detalhesDoEvento();

    }
    public void detalhesDoEvento(){ // view detalhes do evento
        Scanner scanner = new Scanner(System.in);
        String[] opcoes = {"[1] - Escolher Trabalho", "[2] - Voltar a pagina inicial", "[3] - Sair", "index 3", "index 4", "index 5"};
        System.out.println("=================================");
        System.out.println("|       Detalhes do evento      |");
        System.out.println("=================================");
        System.out.println(eventoEscolhido);
        System.out.println("Total Trabalhos cadastrados: " + model.getTrabalhosCadastrados().size());
        System.out.println();
        if (model.getTrabalhosCadastrados().isEmpty()){
            System.out.println("Nenhuma trabalho cadastrado....");
        } else {
            int i = 0;
            System.out.println("Lista de Trabalhos cadastradas >>>");
            for (Trabalho trabalho: model.getTrabalhosCadastrados()) {
                System.out.println(i + " - " + trabalho.getNome() + " - " + trabalho.getDescricao());
                i++;
            }
        }
        System.out.println();
        if (model.getUsuario() instanceof Organizador){
            opcoes[0] = "[1] - Editar dados do evento";
            opcoes[1] = "[2] - Escolher trabalho";
            opcoes[2] = "[3] - Criar trabalho";
            opcoes[3] = "[4] - ExcLuir evento";
            opcoes[4] = "[5] - Voltar a pagina inicial";
            opcoes[5] = "[6] - Sair";
            System.out.println(opcoes[0]);
            System.out.println(opcoes[1]);
            System.out.println(opcoes[2]);
            System.out.println(opcoes[3]);
            System.out.println(opcoes[4]);
            System.out.println(opcoes[5]);
        } else {
            System.out.println(opcoes[0]);
            System.out.println(opcoes[1]);
            System.out.println(opcoes[2]);
        }
        System.out.println("Escolha uma opcao");
        int escolhaUsuario = scanner.nextInt();
        scanner.nextLine();
        controller.handleEvent(escolhaUsuario, eventoEscolhido);
        model.detachObserver(this);
    }
    public static String msgNenhumaTrabalhoCadastrada = "Nenhuma trabalho cadastrada...";
    public static String msgTrabalhoEncontradaSucesso = "Trabalho cadastrada com sucesso!";
    public static String msgEventoExcluidoSucesso = "Evento excluído com sucesso!";
    public static String msgDigiteNumeroCorrespondente = "Digite o numero correspondente a trabalho desejada: ";
    public static String msgNenhumaTrabalhoCorrespondente = "Nenhuma trabalho correspondente.\nTente novamente.";

    public void exibirMensagem(String mensagem) {
        System.out.println();
        System.out.println(mensagem);
        System.out.println();
    }
    public void totalTrabalhosDisponiveis() throws NullPointerException{
        int i = 1;
        try {
            exibirMensagem("Total Trabalhos disponiveis: " + model.getTrabalhosCadastrados().size());
            exibirMensagem("Lista de Trabalhos:");
            for (Trabalho trabalho: model.getTrabalhosCadastrados()) {
                System.out.println(i + " >>> " + trabalho.getNome() + " ID: " + trabalho.getId());
                i++;
            }
        } catch (NullPointerException exception){
            exibirMensagem("Nenhuma trabalho cadastrada.....");
        }
    }
    public Evento getEventoEscolhido() {
        return eventoEscolhido;
    }
    public void setEventoEscolhido(Evento eventoEscolhido) {
        this.eventoEscolhido = eventoEscolhido;
    }
    public int getEscolhaUsuario() {
        return escolhaUsuario;
    }
    public void setEscolhaUsuario(int escolhaUsuario) {
        this.escolhaUsuario = escolhaUsuario;
    }

    public Model getModel() {
        return model;
    }

    public void setModel(Model model) {
        this.model = model;
    }

    public DetalhesEventoController getController() {
        return controller;
    }

    public void setController(DetalhesEventoController controller) {
        this.controller = controller;
    }

    @Override
    public void update() {

    }
}
