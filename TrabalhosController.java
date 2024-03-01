package com.submissaoAvaliacaoTrabalhosAcademicos.controller;
import com.submissaoAvaliacaoTrabalhosAcademicos.model.*;
import com.submissaoAvaliacaoTrabalhosAcademicos.view.TrabalhosView;
import com.submissaoAvaliacaoTrabalhosAcademicos.view.Observer;

import java.util.Scanner;

public class TrabalhosController implements Observer{
    private Model model;
    private TrabalhosView view;
    Scanner scanner = new Scanner(System.in);
    public void initTrabalhosController(Model model, TrabalhosView view) { // iniciando controller da view Trabalho;
        this.model = model;
        this.view = view;
        model.attachObserver(this);
    }
    public void handleEvent(int escolhaUsuario){ // de acordo com a escolha do usuario eh chamada o caso que sera executado

        int i = 1;
        switch (escolhaUsuario){
            case 1:
                if (model.getUsuario() instanceof Organizador){
                    Organizador organizador = (Organizador) model.getUsuario();
                    organizador.editarTrabalho(model, view.getTrabalhoEscolhida());
                } else if (model.getUsuario() instanceof Autor) {
                    Autor autor = (Autor) model.getUsuario();
                    autor.editarTrabalho(model, view.getTrabalhoEscolhida());
                } else {
                    if (view.getTrabalhoEscolhida().getParticipantesDaTrabalho().contains((Participante) model.getUsuario())){
                        ((Participante) model.getUsuario()).cancelarInscricaoTrabalho(view.getTrabalhoEscolhida());
                    } else {
                        ((Participante) model.getUsuario()).inscreverseTrabalho(view.getTrabalhoEscolhida());
                    }
                }
            case 2:
                if (model.getUsuario() instanceof Organizador){
                    if (model.getAutoresLista().isEmpty()){
                        view.exibirMensagem(TrabalhosView.msgNenhumAutorEncontrado);
                        chamarTrabalhosView(model, view);
                    } else {
                        Organizador organizador = (Organizador) model.getUsuario();
                        view.atribuirAutor(organizador);
                        chamarTrabalhosView(model, view);
                    }
                } else{
                    view.participantesInscritos();
                    chamarTrabalhosView(model, view);
                }
            case 3:
                if (model.getUsuario() instanceof Organizador) {
                    removerAutor();
                    chamarTrabalhosView(model, view);
                } else {
                    model.voltarPaginaInicial();
                }

            case 4:
                if (model.getUsuario() instanceof Organizador){
                    chamarTrabalhosView(model, view);
                } else {
                    model.deslogarUsuario();
                }
            case 5:
                view.participantesInscritos();
                chamarTrabalhosView(model, view);
            case 6:
                view.autoresAtribuidos();
                chamarTrabalhosView(model, view);
            case 7:
                Organizador organizador = (Organizador) model.getUsuario();
                organizador.excluirTrabalho(view.getTrabalhoEscolhida());
                chamarTrabalhosView(model, view);
            case 8:
                model.voltarPaginaInicial();;
            case 9:
                model.deslogarUsuario();
        }
    }
    public void removerAutor(){
        view.autoresAtribuidos();
        view.exibirMensagem(TrabalhosView.msgIdRemoverAutor + view.getTrabalhoEscolhida().getNome() + TrabalhosView.msgDoisPontos);
        Organizador organizador = (Organizador) model.getUsuario();
        int id = scanner.nextInt();
        organizador.removerAutor(view.getTrabalhoEscolhida(), model.getAutoresLista().get(id - 1));
    }
    public void atribuirAutor(Organizador organizador, int id){
        organizador.atribuirAutor(model.getAutoresLista().get(id-1), view.getTrabalhoEscolhida());

    }
    public void chamarTrabalhosView(Model model, TrabalhosView view){
        TrabalhosView view1 = new TrabalhosView();
        view1.initTrabalhosView(model, view.getTrabalhoEscolhida());
    }
    public Model getModel() {
        return model;
    }
    public void setModel(Model model) {
        this.model = model;
    }
    public TrabalhosView getView() {
        return view;
    }
    public void setView(TrabalhosView view) {
        this.view = view;
    }
    @Override
    public void update() {

    }
}
