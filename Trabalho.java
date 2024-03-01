package com.submissaoAvaliacaoTrabalhosAcademicos.model;

import java.util.ArrayList;
import java.util.Scanner;

public class Trabalho {

    private Evento evento;
    private int id;
    private String nome;
    private String descricao;
    private Autor autor;
    private String dataInicio;
    private String dataFim;
    private String horaInicio;
    private String horaFim;
    private ArrayList<Participante> participantesDoTrabalho = new ArrayList<Participante>();
    private ArrayList<Autor> autoresDoTrabalho = new ArrayList<Autor>();
    Scanner scanner = new Scanner(System.in);
    public Trabalho(Evento evento) {
        this.evento = evento;
    }
    @Override
    public String toString() {
        return "Nome: ***" + nome + "***" +
                "\n    Descricao: " + descricao +
                "\n    Autor: " + autor +
                "\n    Data de Inicio: " + dataInicio +
                "\n    Hora de inicio: " + horaInicio +
                "\n    Hora de fim: " + horaFim +
                "\n    Participantes da Trabalho: " + participantesDoTrabalho +
                "}";
    }
    public void addParticipante(Participante participante){
        participantesDoTrabalho.add(participante);
    }
    public void addAutor(Autor autor){
        autoresDoTrabalho.add(autor);
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getId() {
        return id;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Autor getAutor() {
        return autor;
    }
    public void setAutor(Autor autor) {
        if (autor == null){ // verificando se o autor existe;
            System.out.println("O autor informado não existe \n Tente novamente");
        } else {
            this.autor = autor;
        }
    }
    public String getDataInicio() {
        return dataInicio;
    }
    public void setDataInicio(String dataInicio) {
        if (dataInicio.matches("\\d{1,2}/\\d{1,2}/\\d{4}")) { // definindo um tipo especifico de entrada do usuario, nesse caso para datas;
            this.dataInicio = dataInicio;
        } else {
            System.out.println("O formato da data de inicio informada esta incoreto.\n Tente novamente passando a data no formato xx/xx/xxxx");
            this.setDataInicio(scanner.nextLine());
        }
    }
    public String getDataFim() {
        return dataFim;
    }
    public void setDataFim(String dataFim) {
        if (dataFim.matches("\\d{1,2}/\\d{1,2}/\\d{4}")) { // definindo um tipo especifico de entrada do usuario, nesse caso para datas;
            this.dataFim = dataFim;
        } else{
            System.out.println("O formato da data de fim informada esta incoreto.\n Tente novamente passando a data no formato xx/xx/xxxx");
            this.setDataFim(scanner.nextLine());
        }
    }
    public String getHoraInicio() {
        return horaInicio;
    }
    public void setHoraInicio(String horaInicio) {
        if (horaInicio.matches("\\d{1,2}:\\d{2}")) { // definindo um tipo especifico de entrada do usuario, nesse caso para horarios;
            this.horaInicio = horaInicio;
        }
        else {
            System.out.println("O formato da hora de inicio informada esta incoreto.\n Tente novamente passando a hora no formato xx:xx");
            this.setHoraInicio(scanner.nextLine());
        }
    }
    public String getHoraFim() {
        return horaFim;
    }
    public void setHoraFim(String horaFim) {
        if (horaInicio.matches("\\d{1,2}:\\d{2}")) { // definindo um tipo especifico de entrada do usuario, nesse caso para horarios;
            this.horaInicio = horaInicio;
        }
        else {
            System.out.println("O formato da hora do fim informado esta incoreto.\nTente novamente passando a hora no formato xx:xx");
            this.setHoraFim(scanner.nextLine());
        }
    }
    public ArrayList<Autor> getAutoresDoTrabalho() {
        return autoresDoTrabalho;
    }
    public void setAutoresDoTrabalho(ArrayList<Autor> autoresDoTrabalho) {
        this.autoresDoTrabalho = autoresDoTrabalho;
    }
    public ArrayList<Participante> getParticipantesDoTrabalho() {
        return participantesDoTrabalho;
    }
    public void setParticipantesDoTrabalho(ArrayList<Participante> participantesDoTrabalho) {
        this.participantesDoTrabalho = participantesDoTrabalho;
    }
    public Evento getEvento() {
        return evento;
    }
    public void setEvento(Evento evento) {
        this.evento = evento;
    }

    // class que puxa a nota do trabalho que o avaliador avaliou
    public void avaliarTrabalho(Trabalho trabalho, Avaliador avaliador){
        System.out.println("Avaliacao do trabalho: " + trabalho.getNome());
        System.out.println("Nota: " + trabalho.getNota());
    }
    
}
