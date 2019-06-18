package com.study.spacequiz;

public class Questions {

    public String rightAnswer;
    public String answer1;
    public String answer2;
    public String answer3;
    public Integer questionIndex;
    public String description;

    public Questions(String rightAnswer, String answer1, String answer2, String answer3, Integer questionIndex, String description) {
        this.rightAnswer = rightAnswer;
        this.answer1 = answer1;
        this.answer2 = answer2;
        this.answer3 = answer3;
        this.questionIndex = questionIndex;
        this.description = description;
    }
}
