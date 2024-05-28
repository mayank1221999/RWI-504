
package com.map;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Maponetomany {
    public static void main(String[] args) {
        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");  // Corrected the filename
        SessionFactory factory = cfg.buildSessionFactory();

        // Creating question
        SurveyQuestion q1 = new SurveyQuestion();
        q1.setQuestionId(101);
        q1.setQuestion("What is your profile?");

        // Creating answers
        MyAnswer answer = new MyAnswer(102, "I am a software developer");
        MyAnswer answer1 = new MyAnswer(103, "I am a JAVA developer");
        MyAnswer answer2 = new MyAnswer(104, "I am an engineer");

        List<MyAnswer> list = new ArrayList<>();
        list.add(answer);
        list.add(answer1);
        list.add(answer2);

        q1.setAnswers(list);

        List<SurveyQuestion> questionList = new ArrayList<>();
        questionList.add(q1);

        answer.setQuestions(questionList);
        answer1.setQuestions(questionList);
        answer2.setQuestions(questionList);

        // Opening session
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();

        session.save(q1);
        session.save(answer);
        session.save(answer1);
        session.save(answer2);

        // Retrieving and printing the question and its answers
        SurveyQuestion retrievedQuestion = (SurveyQuestion) session.get(SurveyQuestion.class, 101);
        System.out.println(retrievedQuestion.getQuestion());
        for (MyAnswer a : retrievedQuestion.getAnswers()) {
            System.out.println(a.getAnswer());
        }

        // Commit and close session
        tx.commit();
        session.close();
        factory.close();
    }
}
