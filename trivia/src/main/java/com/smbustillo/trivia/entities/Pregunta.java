package com.smbustillo.trivia.entities;

public class Pregunta {

    private String categoria;
    private String question;
    private String[] options;
    private int answer;
    private String explanation;


    public Pregunta(String categoria, String question, String[] options, int answer, String explanation) {
        this.categoria = categoria;
        this.question = question;
        this.options = options;
        this.answer = answer;
        this.explanation = explanation;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String[] getOptions() {
        return options;
    }

    public void setOptions(String[] options) {
        this.options = options;
    }

    public int getAnswer() {
        return answer;
    }

    public void setAnswer(int answer) {
        this.answer = answer;
    }

    public String getExplanation() {
        return explanation;
    }

    public void setExplanation(String explanation) {
        this.explanation = explanation;
    }
}
