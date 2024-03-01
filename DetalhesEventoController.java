package com.submissaoAvaliacaoTrabalhosAcademicos.controller;
import com.submissaoAvaliacaoTrabalhosAcademicos.model.Atividade;
import com.submissaoAvaliacaoTrabalhosAcademicos.model.Evento;
import com.submissaoAvaliacaoTrabalhosAcademicos.model.Model;
import com.submissaoAvaliacaoTrabalhosAcademicos.model.Organizador;
import com.submissaoAvaliacaoTrabalhosAcademicos.view.TrabalhoView;
import com.submissaoAvaliacaoTrabalhosAcademicos.view.DetalhesEventoView;
import com.submissaoAvaliacaoTrabalhosAcademicos.view.Observer;
import com.submissaoAvaliacaoTrabalhosAcademicos.view.PaginaEventosView;

import java.util.Scanner;

public class DetalhesEventoController implements Observer {

    private Model model;
    private DetalhesEventoView view;
    private int numeroAtividadeEscolhida;
    private Atividade atividadeEscolhida;

    public void initDetalhesEventoController(Model model, DetalhesEventoView view) {
        this.model = model;
        this.view = view;
        model.attachObserver(this);
    }

    public void handleEvent(int escolhaUsuario, Evento evento){

        switch (escolhaUsuario){
            case 1:
                if (model.getUsuario() instanceof Organizador){
                    Organizador organizador = (Organizador) model.getUsuario();
                    organizador.editarEvento(evento, model);
                    chamarDetalhesEventoView(model, evento);
                } else {
                    escolherAtividade();
                }
            case 2:
                if (model.getUsuario() instanceof Organizador){
                    if (model.getTrabalhoCadastrados().isEmpty()) {
                        view.exibirMensagem(DetalhesEventoView.msgNenhumaAtividadeCadastrada);
                        chamarDetalhesEventoView(model, evento);
                    }
                    escolherAtividade();
                } else {
                    model.voltarPaginaInicial();
                }
            case 3:
                if (model.getUsuario() instanceof Organizador) {
                    Organizador organizador = (Organizador) model.getUsuario();
                    Atividade novaAtividade = organizador.criarAtividade();
                    model.getTrabalhoCadastrados().add(novaAtividade);
                    view.exibirMensagem(DetalhesEventoView.msgAtividadeEncontradaSucesso);
                    chamarDetalhesEventoView(model, evento);
                } else {
                    model.deslogarUsuario();
                }
            case 4:
                model.getEventosCadastrados().remove(evento);
                view.exibirMensagem(DetalhesEventoView.msgEventoExcluidoSucesso);
                chamarPaginaEventosView(model);
            case 5:
                model.voltarPaginaInicial();
            case 6:
                model.deslogarUsuario();

        }
    }

    public void chamarPaginaEventosView(Model model){
        PaginaEventosView view1 = new PaginaEventosView();
        view1.initPaginaEventosView(model);
    }
    public void chamarDetalhesEventoView(Model model, Evento evento){
        DetalhesEventoView view = new DetalhesEventoView();
        view.initDetalhesEventoView(model, evento);
    }

    public void escolherTrabalho() throws NullPointerException{
        Scanner scanner = new Scanner(System.in);
        view.totalTrabalhoDisponiveis();
        view.exibirMensagem(DetalhesEventoView.msgDigiteNumeroCorrespondente);
        numeroAtividadeEscolhida = scanner.nextInt();
        try{
            atividadeEscolhida = model.getTrabalhoCadastrados().get(numeroAtividadeEscolhida-1);
            TrabalhoView view1 = new TrabalhoView();
            view1.initTrabalhoView(model, atividadeEscolhida);
        } catch (NullPointerException exception){
            view.exibirMensagem(DetalhesEventoView.msgNenhumaAtividadeCorrespondente);
            DetalhesEventoView view1 = new DetalhesEventoView();
            view1.initDetalhesEventoView(model, view.getEventoEscolhido());
        }
    }
    @Override
    public void update() {

    }
}
