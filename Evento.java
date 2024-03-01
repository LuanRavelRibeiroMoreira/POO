package com.submissaoAvaliacaoTrabalhosAcademicos.model;

import java.util.ArrayList;
import java.util.Scanner;

public class Evento {
    private int id;
    private String nome;
    private String descricao;
    private Organizador organizador;
    private String dataInicio;
    private String dataFim;
    private String horaInicio;
    private ArrayList<Trabalho> travalhosDoEvento = new ArrayList<Trabalho>();
    private ArrayList<Participante> participantesDoEvento = new ArrayList<Participante>();
    private ArrayList<Autor> autoresDoEvento = new ArrayList<Autor>();
    Scanner scanner = new Scanner(System.in);
    public String toString(){
        return "\nEvento: " + nome +
                "\nDescricao: " + descricao +
                "\n" + organizador +
                "\n*********************************" +
                "\nData de inicio: " + dataInicio +
                "\nData de finalizacao: " + dataFim +
                "\n*********************************";
    }
    
    public void setId(int id){
        if (id >= 0 && id <= 999999){ // verificacao do dado de entrada do usuario;
            this.id = id;
        } else {
            System.out.println("O id informado não esta entre o intervalo de 0 a 999999 \n Tente novamente");
        }
    }
    public void setDataFim(String dataFim) {
        if (dataFim.matches("\\d{1,2}/\\d{1,2}/\\d{4}")) {
            this.dataFim = dataFim;
        } else {
            System.out.println("O formato da data do fim informada esta incoreto.\nTente novamente passando a data no formato xx/xx/xxxx");
            this.setDataFim(scanner.nextLine());
        }
    }
    public void setDataInicio(String dataInicio) {
        if (dataInicio.matches("\\d{1,2}/\\d{1,2}/\\d{4}")) {
            this.dataInicio = dataInicio;
        } else {
            System.out.println("O formato da data de inicio informada esta incoreto.\nTente novamente passando a data no formato xx/xx/xxxx");
            this.setDataInicio(scanner.nextLine());
        }
    }
    public void setHoraInicio(String horaInicio) {
        if (horaInicio.matches("\\d{1,2}:\\d{2}")) {
            this.horaInicio = horaInicio;
        }
        else {
            System.out.println("O formato da hora de inicio informada esta incoreto.\nTente novamente passando a hora no formato xx:xx");
            this.setHoraInicio(scanner.nextLine());
        }
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
    
    public Organizador getOrganizador() {
        return organizador;
    }
    public void setOrganizador(Organizador organizador) {
        this.organizador = organizador;
    }
    public String getDataInicio() {
        return dataInicio;
    }
    public String getDataFim() {
        return dataFim;
    }
    public String getHoraInicio() {
        return horaInicio;
    }
    public ArrayList<Trabalho> getTrabalhosDoEvento() {
        return travalhosDoEvento;
    }
    public void setTrabalhosDoEvento(ArrayList<Trabalho> travalhosDoEvento) {
        this.travalhosDoEvento = travalhosDoEvento;
    }
    public ArrayList<Participante> getParticipantesDoEvento() {
        return participantesDoEvento;
    }
    public void setParticipantesDoEvento(ArrayList<Participante> participantesDoEvento) {
        this.participantesDoEvento = participantesDoEvento;
    }
    public ArrayList<Autor> getAutoresDoEvento() {
        return autoresDoEvento;
    }
    public void setAutoresDoEvento(ArrayList<Autor> autoresDoEvento) {
        this.autoresDoEvento = autoresDoEvento;
    }
    public void addTrabalho(Trabalho travalho) {
        travalhosDoEvento.add(travalho);
    }
 
}
