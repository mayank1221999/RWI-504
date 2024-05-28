
package com.map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.List;

@Entity
public class SurveyQuestion {
    @Id
    @Column(name = "question_id")
    private int questionId;
    private String question;

    @ManyToMany
    private List<MyAnswer> answers;

    public SurveyQuestion() {
        super();
    }

    public SurveyQuestion(int questionId, String question, List<MyAnswer> answers) {
        super();
        this.questionId = questionId;
        this.question = question;
        this.answers = answers;
    }

    public int getQuestionId() {
        return questionId;
    }

    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public List<MyAnswer> getAnswers() {
        return answers;
    }

    public void setAnswers(List<MyAnswer> answers) {
        this.answers = answers;
    }

    @Override
    public String toString() {
        return "SurveyQuestion [questionId=" + questionId + ", question=" + question + ", answers=" + answers + "]";
    }
}
