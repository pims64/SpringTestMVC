package fr.formation.entities;

public class Bet {

    private int scoreFrance;

    private int scorePerou;

    public Bet() {
	//
    }

    public int getScoreFrance() {
	return scoreFrance;
    }

    public void setScoreFrance(int scoreFrance) {
	this.scoreFrance = scoreFrance;
    }

    public int getScorePerou() {
	return scorePerou;
    }

    public void setScorePerou(int scorePerou) {
	this.scorePerou = scorePerou;
    }

    @Override
    public String toString() {
	return "{scoreFrance=" + scoreFrance + ", scorePerou=" + scorePerou
		+ "}";
    }
}
