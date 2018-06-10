package com.example.paloma.finalproject1;

public class Question {
    private String Question;
    private String op1;
    private String op2;
    private String op3;
    private String op4;
    private String subject;
    private int answer_nr;

    public Question(){

    }

    public Question(String question, String op1, String op2, String op3, String op4, String subject, int answer_nr) {

        Question = question;
        this.op1 = op1;
        this.op2 = op2;
        this.op3 = op3;
        this.op4 = op4;
        this.subject = subject;
        this.answer_nr = answer_nr;
    }

    public String getQuestion() {
        return Question;
    }

    public void setQuestion(String question) {
        Question = question;
    }

    public String getOp1() {
        return op1;
    }

    public void setOp1(String op1) {
        this.op1 = op1;
    }

    public String getOp2() {
        return op2;
    }

    public void setOp2(String op2) {
        this.op2 = op2;
    }

    public String getOp3() {
        return op3;
    }

    public void setOp3(String op3) {
        this.op3 = op3;
    }

    public String getOp4() {
        return op4;
    }

    public void setOp4(String op4) {
        this.op4 = op4;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public int getAnswer_nr() {
        return answer_nr;
    }

    public void setAnswer_nr(int answer_nr) {
        this.answer_nr = answer_nr;
    }
}
