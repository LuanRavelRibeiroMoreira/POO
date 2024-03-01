package com.submissaoAvaliacaoTrabalhosAcademicos.model;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Certificado {
    private Trabalho trabalho;
    private Nota nota;
    public Certificado(Trabalho trabalho, Nota nota) {
        this.trabalho = trabalho;
        this.nota = nota;
    }
    public void emitirCertificado (Participante participante) { // metodo para emissao dos certificados dos participantes com nota;
        String conteudo = "Certificamos que " + participante.getNome() + ", autor do trabalho " + trabalho.getNome() + "e concluiu com uma nota" + trabalho.getNota() + " realizada em " + trabalho.getDataInicio() + ".";
        String nomeArquivo = participante.getNome() + "-" + trabalho.getNome() + ".txt";
        try {
            PrintWriter writer = new PrintWriter(new FileWriter(nomeArquivo));
            writer.println(conteudo);
            writer.close();
            System.out.println("Nota para " + participante.getNome() + " salvo com sucesso no arquivo " + nomeArquivo);
        } catch (IOException e) {
            System.out.println("Erro ao salvar o certificado de " + participante.getNome() + " no arquivo " + nomeArquivo);
            e.printStackTrace();
        }
    }
    public Trabalho getTrabalho() {
        return trabalho;
    }
    public void setTrabalho(Trabalho trabalho) {
        this.trabalho = trabalho;
    }

    public Nota getNota() {
        return nota;
    }
    public void setNota(Nota nota) {
        this.nota = nota;
    }
}

