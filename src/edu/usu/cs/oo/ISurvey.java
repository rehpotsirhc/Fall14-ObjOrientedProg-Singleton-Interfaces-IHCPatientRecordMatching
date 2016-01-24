package edu.usu.cs.oo;

import java.util.ArrayList;

interface ISurvey {
	
	public String getName();
	
	public ArrayList<Question> getQuestions();
	
	public ArrayList<ICompletePatientRecord> getPatientsTakenThis();
	
	
	
	
	public void AddQuestion(Question question);
	public void AddQuestion(int questionNumber, String question);
	
	public void AddPatient(ICompletePatientRecord patient);
	

}
