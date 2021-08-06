package com.example.marspioneer.client.tools;

import java.util.Vector;

public class ResultType {

    public Vector<Long> sessionValidation = new Vector<>();
    public Vector<Long> stateRetrieval = new Vector<>();
    public Vector<Long> ruleProcessing = new Vector<>();
    public Vector<Long> stateModification = new Vector<>();
    public Vector<Long> stateSend = new Vector<>();
    public Vector<Long> total = new Vector<>();

    public ResultType(Vector<Long> sessionValidation, Vector<Long> stateRetrieval, Vector<Long> ruleProcessing, Vector<Long> stateModification, Vector<Long> stateSend, Vector<Long> total) {
        this.sessionValidation = sessionValidation;
        this.stateRetrieval = stateRetrieval;
        this.ruleProcessing = ruleProcessing;
        this.stateModification = stateModification;
        this.stateSend = stateSend;
        this.total = total;
    }

    public ResultType() {
    }

    public Vector<Long> getSessionValidation() {
        return sessionValidation;
    }

    public void setSessionValidation(Vector<Long> sessionValidation) {
        this.sessionValidation = sessionValidation;
    }

    public Vector<Long> getStateRetrieval() {
        return stateRetrieval;
    }

    public void setStateRetrieval(Vector<Long> stateRetrieval) {
        this.stateRetrieval = stateRetrieval;
    }

    public Vector<Long> getRuleProcessing() {
        return ruleProcessing;
    }

    public void setRuleProcessing(Vector<Long> ruleProcessing) {
        this.ruleProcessing = ruleProcessing;
    }

    public Vector<Long> getStateModification() {
        return stateModification;
    }

    public void setStateModification(Vector<Long> stateModification) {
        this.stateModification = stateModification;
    }

    public Vector<Long> getStateSend() {
        return stateSend;
    }

    public void setStateSend(Vector<Long> stateSend) {
        this.stateSend = stateSend;
    }

    public Vector<Long> getTotal() {
        return total;
    }

    public void setTotal(Vector<Long> total) {
        this.total = total;
    }
}
