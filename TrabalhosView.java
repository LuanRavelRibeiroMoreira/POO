package com.submissaoAvaliacaoTrabalhosAcademicos.view;
import com.submissaoAvaliacaoTrabalhosAcademicos.controller.TrabalhosController;
import com.submissaoAvaliacaoTrabalhosAcademicos.model.*;
import java.util.Scanner;

public class TrabalhosView implements Observer{

    private Model model;
    private TrabalhosController controller;
    private Trabalho trabalhoEscolhido;
    private int escolhaUsuario;
    private Scanner scanner = new Scanner(System.in);

    public void initTrabalhosView(Model model, Trabalho trabalhoEscolhido) { // iniciando view de Trabalho
        this.model = model;
        this.trabalhoEscolhido = trabalhoEscolhido;
        controller = new TrabalhosController();
        controller.initTrabalhosController(model, this);
        model.attachObserver(this);
        detalhesDoTrabalho();

    }

    public void detalhesDoTrabalho(){ // view da Trabalho
        String[] opcoes = { "[1] - Realizar inscricao na Trabalho", "[2] - Ver participante(s) inscritos", "[3] - Voltar a pagina inicial", "[4] - Sair do sistema", "index-4","index-5","index-6", "index-7", "index-8"};
        System.out.println("=========================================");
        System.out.println("| Detalhes sobre a Trabalho: " + trabalhoEscolhido.getNome() + " |");
        System.out.println("=========================================");
        System.out.println(trabalhoEscolhido);
        System.out.println();
        if (model.getUsuario() instanceof Organizador){
            opcoes[0] = "[1] - Editar Trabalho";
            opcoes[1] = "[2] - Atribuir autor";
            opcoes[2] = "[3] - Remover autor";
            opcoes[3] = "[4] - Emitir certificados dos participantes";
            opcoes[4] = "[5] - Ver participantes inscritos";
            opcoes[5] = "[6] - Ver autor atribuidos";
            opcoes[6] = "[7] - Excluir Trabalho";
            opcoes[7] = "[8] - Voltar a pagina inicial";
            opcoes[8] = "[9] - Sair";
            System.out.println(opcoes[0]);
            System.out.println(opcoes[1]);
            System.out.println(opcoes[2]);
            System.out.println(opcoes[3]);
            System.out.println(opcoes[4]);
            System.out.println(opcoes[5]);
            System.out.println(opcoes[6]);
            System.out.println(opcoes[7]);
            System.out.println(opcoes[8]);
        } else if (model.getUsuario() instanceof Autor) {
            opcoes[0] = "[1] - Editar Trabalho";
            System.out.println(opcoes[0]);
            System.out.println(opcoes[1]);
            System.out.println(opcoes[2]);
            System.out.println(opcoes[3]);
        } else {
            if (trabalhoEscolhido.getParticipantesDOTrabalho().contains((Participante) model.getUsuario())){
                System.out.println("***Voce ja esta inscrito nesso Trabalho!***");
                opcoes[0] = "[1] - Cancelar inscricao";
            }
            System.out.println(opcoes[0]);
            System.out.println(opcoes[1]);
            System.out.println(opcoes[2]);
            System.out.println(opcoes[3]);
        }
        System.out.println("Escolha uma opcao: ");
        escolhaUsuario = scanner.nextInt();
        controller.handleEvent(escolhaUsuario);
        model.detachObserver(this);

    }
    public static String msgDoisPontos = ":";
    public static String msgIdRemoverAutor = "Digite o ID correspondente ao autor que voce deseja remover do Trabalho:";
    public static String msgNenhumAutorEncontrado = "Nenhum autor cadastrado...";
    public void exibirMensagem(String mensagem){
        System.out.println();
        System.out.println(mensagem);
        System.out.println();
    }
    public void inscricaoRealizada(){
        System.out.println("Inscricao realizada com sucesso!");
    }
    public void atribuirAutor(Organizador organizador){
        model.autoresCadastrados();
        exibirMensagem("Digite o ID correspondente ao autor que você deseja atribuir o Trabalho:" + gettrabalhoEscolhido().getNome() + ":");
        int id = scanner.nextInt();
        controller.atribuirAutor(organizador, id);
        exibirMensagem("Autor " + model.getAutoresLista().get(id-1).getNome() + " atribuido com sucesso!");
    }
    public void autoresAtribuidos(){
        int i = 0;
        exibirMensagem("Autores atribuidos:");
        for (Autor autor : gettrabalhoEscolhido().getAutoresDaTrabalho()) {
            System.out.println("ID: " + i + " - " + "Nome: " + autor.getNome());
            i++;
        }
        System.out.println();
    }
    public void participantesInscritos(){
        exibirMensagem("Participantes inscritos:");
        gettrabalhoEscolhido().getParticipantesDOTrabalho().forEach(participante -> System.out.println("Participante : " + participante.getNome()));
    }

    public Trabalho gettrabalhoEscolhido() {
        return trabalhoEscolhido;
    }
    public void settrabalhoEscolhido(Trabalho trabalhoEscolhido) {
        this.trabalhoEscolhido = trabalhoEscolhido;
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

    public TrabalhosController getController() {
        return controller;
    }

    public void setController(TrabalhosController controller) {
        this.controller = controller;
    }

    @Override
    public void update() {

    }
}
