package com.cognizant.ormlearn.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "attempt_option")
public class AttemptOption {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ao_id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "ao_aq_id")
    private AttemptQuestion attemptQuestion;

    @ManyToOne
    @JoinColumn(name = "ao_op_id")
    private Options option;

    @Column(name = "ao_answer")
    private boolean answer;

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public AttemptQuestion getAttemptQuestion() { return attemptQuestion; }
    public void setAttemptQuestion(AttemptQuestion attemptQuestion) { this.attemptQuestion = attemptQuestion; }
    public Options getOption() { return option; }
    public void setOption(Options option) { this.option = option; }
    public boolean isAnswer() { return answer; }
    public void setAnswer(boolean answer) { this.answer = answer; }

    @Override
    public String toString() {
        return "AttemptOption [id=" + id + ", answer=" + answer + "]";
    }
}
