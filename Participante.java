package com.submissaoAvaliacaoTrabalhosAcademicos.model;


import java.util.ArrayList;

public class Participante extends Usuario {
    private Trabalho trabalho;
    private ArrayList<Trabalho> trabalhosInscritos = new ArrayList<Trabalho>();
    public void inscreverseTrabalho(Trabalho trabalho){ // metodo para o participante se inscrever no trabalho
        this.trabalho = trabalho;
        this.trabalho.addParticipante(this);
    }
    public void cancelarInscricaoTrabalho(Trabalho trabalho){ // metodo para o participante cancelar inscricao de uma trabalho
        this.trabalho = trabalho;
        this.trabalho.getParticipantesDoTrabalho().remove(this);
    }

    public ArrayList<Trabalho> getTrabalhosInscritos() {
        return trabalhosInscritos;
    }

    public void setTrabalhosInscritos(ArrayList<Trabalho> trabalhosInscritos) {
        this.trabalhosInscritos = trabalhosInscritos;
    }
   
    public Trabalho getTrabalho() {
        return trabalho;
    }

    public void setTrabalho(Trabalho trabalho) {
        this.trabalho = trabalho;
    }
}
