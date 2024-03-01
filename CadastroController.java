package com.submissaoAvaliacaoTrabalhosAcademicos.controller;

import com.submissaoAvaliacaoTrabalhosAcademicos.model.*;
import com.submissaoAvaliacaoTrabalhosAcademicos.view.CadastroView;
import com.submissaoAvaliacaoTrabalhosAcademicos.view.Observer;

public class CadastroController implements Observer {
    private Model model;
    private CadastroView view;
    public void initCadastroController(Model model, CadastroView view) { // iniciando o controller para a view de cadastro;
        this.model = model;
        this.view = view;
        model.attachObserver(this);
    }
    public void handleEvent(String event) { // de acordo com os dados inseridos está sendo cadastrado um novo usuario;
        switch (event) {
            case "OK" :
                tipoUsuario(view.getTipoUsuario());
                model.getUsuario().setId(view.getId());
                model.getUsuario().setEmail(view.getEmail());
                model.getUsuario().setNome(view.getNome());
                model.getUsuario().setSenha(view.getSenha());
                model.setUsuarioSistema(model.getUsuario());
                model.detachObserver(this);
                break;
        }
    }

    public void tipoUsuario(int tipoUsuario){ // metodo para definir o tipo de conta que o usuario deseja criar;
        switch (tipoUsuario){
            case 1:
                tipoParticipante();
                break;
            case 2:
                tipoAutor();
                break;
            case 3:
                tipoOrganizador();
                break;
            case 4:
                tipoAvaliador();
                break;
        }
    }
    public void tipoParticipante(){
        Usuario usuario = new Participante();
        Participante participante = (Participante) usuario;
        model.setUsuario(participante);
        model.getParticipantesLista().add(participante);
    }
    public void tipoAutor(){
        Usuario usuario = new Autor();
        Autor autor = (Autor) usuario;
        model.setUsuario(autor);
        model.getAutoresLista().add(autor);
    }
    public void tipoAvaliador(){
        Usuario usuario = new Avaliador();
        Avaliador avaliador = (Avaliador) usuario;
        model.setUsuario(avaliador);
        model.getAvaliadoresLista().add(avaliador);
    }
    public void tipoOrganizador(){
        Usuario usuario = new Organizador();
        Organizador organizador = (Organizador) usuario;
        model.setUsuario(organizador);
        model.getOrganizadoresLista().add(organizador);
    }
    public Model getModel() {
        return model;
    }
    public void setModel(Model model) {
        this.model = model;
    }
    public CadastroView getView() {
        return view;
    }
    public void setView(CadastroView view) {
        this.view = view;
    }
    @Override
    public void update() {
        System.out.println("CadastroController update");
        System.out.println("model.getUsuario(): " + model.getUsuario());
        if (model.getUsuario() != null) {
            view.exibirMensagem("Cadastro realizado com sucesso!");
            model.voltarPaginaInicial();
        }
    }
}
