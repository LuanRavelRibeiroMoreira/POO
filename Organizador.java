package com.submissaoAvaliacaoTrabalhosAcademicos.model;
import com.submissaoAvaliacaoTrabalhosAcademicos.view.DetalhesEventoView;
import java.util.ArrayList;
import java.util.Scanner;

public class Organizador extends Autor{
    private Evento evento;
    private ArrayList<Evento> eventosCadastrados = new ArrayList<Evento>();
    private ArrayList<Trabalho> trabalhosCadastrados = new ArrayList<Trabalho>();

    public String toString(){
        return "Organizador: " + getNome() +
                "\nEmail: " + getEmail();
    }
    

    public void gerarCertificado(Trabalho trabalho){ // metodo para gerar certificados para todos os participanttes presentes em uma determinada Trabalho;
        Certificado certificado = new Certificado(trabalho);
        for (Participante participante: trabalho.getParticipantesPresentes()) {
            certificado.emitirCertificado(participante);
        }
        System.out.println("Certificado(s) gerado(s) com sucesso!");
    }

    public Evento criarEvento(){ // metodo para criar evento;
        Evento evento = new Evento();
        eventosCadastrados.add(evento);
        System.out.println("Preencha os dados para a criacao do evento:");
        System.out.println("Nome:");
        evento.setNome(scanner.nextLine());
        System.out.println("Descricao:");
        evento.setDescricao(scanner.nextLine());
        System.out.println("---------------------------------------------------------");
        System.out.println("Data de Inicio:");
        evento.setDataInicio(scanner.nextLine());
        System.out.println("Data de Fim:");
        evento.setDataFim(scanner.nextLine());
        System.out.println("Hora de Inicio:");
        evento.setHoraInicio(scanner.nextLine());
        return evento;
    }

    public void editarEvento(Evento evento, Model model){ // metodo para editar um evento existente;
        this.evento = evento;
        System.out.println("Qual atributo do evento você deseja editar?");
        System.out.println("[1] - Nome");
        System.out.println("[2] - Descricao");
        System.out.println("[3] - Data de inicio");
        System.out.println("[4] - Data de fim");
        System.out.println("[5] - Hora de inicio");
        System.out.println("[6] - Hora de fim");
        System.out.println("[7] - Voltar a tela anterior");
        System.out.println("Escolha uma opcao:");
        int i = scanner.nextInt();
        scanner.nextLine();
        handleEvent1(i, model);
        scanner.close();
    }

    public void handleEvent1(int i, Model model){ // metodo para de acordo com a escolha do usuario fazer determinada funcao;
        Scanner sc = new Scanner(System.in);
        switch (i){
            case 1:
                System.out.println("Defina o novo nome desejado:");
                String nome = sc.nextLine();
                evento.setNome(nome);
                DetalhesEventoView view = new DetalhesEventoView();
                view.initDetalhesEventoView(model, evento);
            case 2:
                System.out.println("Escreva a nova descricao desejada:");
                String descricao = sc.nextLine();
                evento.setDescricao(descricao);
                DetalhesEventoView view0 = new DetalhesEventoView();
                view0.initDetalhesEventoView(model, evento);
            case 3:
                System.out.println("Defina uma nova data de inicio:");
                String dataInicio = sc.nextLine();
                evento.setDataInicio(dataInicio);
                DetalhesEventoView view2 = new DetalhesEventoView();
                view2.initDetalhesEventoView(model, evento);
            case 4:
                System.out.println("Defina uma nova data de encerramento:");
                String dataFim = sc.nextLine();
                evento.setDataFim(dataFim);
                DetalhesEventoView view3 = new DetalhesEventoView();
                view3.initDetalhesEventoView(model, evento);
            case 5:
                System.out.println("Defina um novo horario para inicio:");
                String horarioInicio = sc.nextLine();
                evento.setHoraInicio(horarioInicio);
                DetalhesEventoView view4 = new DetalhesEventoView();
                view4.initDetalhesEventoView(model, evento);
            case 6:
                System.out.println("Defina um novo horario para encerramento:");
                String horarioFim = sc.nextLine();
                evento.setHoraInicio(horarioFim);
                DetalhesEventoView view5 = new DetalhesEventoView();
                view5.initDetalhesEventoView(model, evento);
            case 7:
                DetalhesEventoView view6 = new DetalhesEventoView();
                view6.initDetalhesEventoView(model, evento);
            default:
                System.out.println("Opcao invalida, confira o numero digitado.");
                System.out.println("Tente novamente.");
                editarEvento(evento, model);
        }
    }


    public Trabalho criarTrabalho(){ // metodo para criar uma trabalho;
        Trabalho trabalho = new Trabalho(evento);
        trabalhosCadastrados.add(trabalho);
        System.out.println("Preencha com os dados do trabalho >>>");
        System.out.println("Nome:");
        String nome = scanner.nextLine();
        trabalho.setNome(nome);
        System.out.println("Descricao:");
        String descricao = scanner.nextLine();
        trabalho.setDescricao(descricao);
        System.out.println("Data de inicio:");
        String dataInicio = scanner.nextLine();
        trabalho.setDataInicio(dataInicio);
        System.out.println("Data de finalizacao:");
        String dataFim = scanner.nextLine();
        trabalho.setDataFim(dataFim);
        System.out.println("Hora de inicio:");
        String horaInicio = scanner.nextLine();
        trabalho.setHoraInicio(horaInicio);
        System.out.println("Hora de finalizacao:");
        String horaFim = scanner.nextLine();
        trabalho.setHoraFim(horaFim);
        return trabalho;
    }

    public void removerAutor(Trabalho trabalho, Autor autor){ // metodo para remover um autor de uma Trabalho;
        trabalho.getAutoresDoTrabalho().remove(autor);
        System.out.println();
        System.out.println("Autor " + autor.getNome() + " removido com sucesso!");
        System.out.println();
    }

    public void excluirEvento(Evento evento){
        eventosCadastrados.remove(evento);
        System.out.println();
        System.out.println("Evento removido com sucesso!");
        System.out.println();
    }

    public void editarTrabalho(Model model, Trabalho trabalho){ // metodo para editar uma trabalho existente;
        super.editarTrabalho(model, trabalho);
    }

    public void excluirTrabalho(Trabalho trabalho){ // metodo para excluir uma trabalho existente;
        trabalhosCadastrados.remove(trabalho);
        System.out.println("Trabalho " + trabalho.getNome() + " excluida com sucesso!");
    }

    public void atribuirAutor(Autor autor, Trabalho trabalho){ // metodo para atribuir um autor a uma trabalho existente;
        trabalho.addAutor(autor);
    }
    public ArrayList<Evento> getEventos() {
        return eventosCadastrados;
    }

    public void setEventos(ArrayList<Evento> eventos) {
        this.eventosCadastrados = eventos;
    }

    public ArrayList<Trabalho> getTrabalhos() {
        return trabalhosCadastrados;
    }

    public void setTrabalhos(ArrayList<Trabalho> trabalhos) {
        this.trabalhosCadastrados = trabalhos;
    }

    public Evento getEvento() {
        return evento;
    }

    public void setEvento(Evento evento) {
        this.evento = evento;
    }

    public ArrayList<Evento> getEventosCadastrados() {
        return eventosCadastrados;
    }

    public void setEventosCadastrados(ArrayList<Evento> eventosCadastrados) {
        this.eventosCadastrados = eventosCadastrados;
    }

    public ArrayList<Trabalho> getTrabalhoCadastrados() {
        return trabalhosCadastrados;
    }

    public void setTrabalhosCadastrados(ArrayList<Trabalho> trabalhosCadastrados) {
        this.trabalhosCadastrados = trabalhosCadastrados;
    }

}
