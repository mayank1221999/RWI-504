
package com.map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.List;

@Entity
public class MyAnswer {
    @Id
    @Column(name = "answer_id")
    private int answerId;
    private String answer;

    @ManyToMany(mappedBy = "answers")
    private List<SurveyQuestion> questions;

    public int getAnswerId() {
        return answerId;
    }

    public void setAnswerId(int answerId) {
        this.answerId = answerId;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public List<SurveyQuestion> getQuestions() {
        return questions;
    }

    public void setQuestions(List<SurveyQuestion> questions) {
        this.questions = questions;
    }

    public MyAnswer(int answerId, String answer) { // Corrected constructor name
        super();
        this.answerId = answerId;
        this.answer = answer;
    }

    public MyAnswer() {
        super();
    }
}
