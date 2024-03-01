package com.submissaoAvaliacaoTrabalhosAcademicos.model;
import com.submissaoAvaliacaoTrabalhosAcademicos.view.TrabalhosView;

import java.util.ArrayList;
import java.util.Scanner;

public class Autor extends Participante {

    private ArrayList<Trabalho> trabalhos = new ArrayList<Trabalho>();
    private Trabalho trabalho;
    Scanner scanner = new Scanner(System.in);

    @Override
    public String toString() {
        return "{" + super.toString() +
                ", trabalhos: " + trabalhos +
                '}';
    }

    public void inscreverseTrabalho(Trabalho trabalho){ // herdando metodo do participante, de se inscrever;
        super.inscreverseTrabalho(trabalho);
    }
    public void cancelarInscricaoTrabalho(Trabalho trabalho){ // herdando metodo do participante, de cancelar inscricao de uma trabalho;
        super.cancelarInscricaoTrabalho(trabalho);
    }
    public void editarTrabalho(Model model, Trabalho trabalho){ // metodo para o autor editar uma trabalho;
        this.trabalho = trabalho;
        System.out.println("Qual atributo do trabalho voce deseja editar?");
        System.out.println("----------------------------------------------");
        System.out.println("[1] - Nome:");
        System.out.println("[2] - Descrição:");
        System.out.println("----------------------------------------------");
        System.out.println("Escolha uma opcao:");
        int i = scanner.nextInt();
        scanner.nextLine();
        handleEvent(i, model, trabalho);
        scanner.close();
    }

    public void handleEvent(int i, Model model, Trabalho trabalho){ // metodo para dependendo da escolha do usuario fazer determinada funcao;
        switch (i){
            case 1:
                System.out.println("Defina o novo nome desejado:");
                trabalho.setNome(scanner.nextLine());
                TrabalhosView view = new TrabalhosView();
                view.initTrabalhosView(model, trabalho);
            case 2:
                System.out.println("Escreva a nova descricao desejada:");
                trabalho.setDescricao(scanner.nextLine());
                TrabalhosView view1 = new TrabalhosView();
                view1.initTrabalhosView(model, trabalho);
            default:
                System.out.println("Opcao invalida, confira o numero digitado.");
                System.out.println("Tente novamente.");
                editarTrabalho(model, trabalho);
        }
    }
    public ArrayList<Trabalho> getTrabalhos() {
        return trabalhos;
    }

    public void setTrabalhos(ArrayList<Trabalho> trabalhos) {
        this.trabalhos = trabalhos;
    }

    @Override
    public Trabalho getTrabalho() {
        return trabalho;
    }

    @Override
    public void setTrabalho(Trabalho trabalho) {
        this.trabalho = trabalho;
    }


}