package edu.usu.cs.oo;

import java.util.ArrayList;


class Survey implements ISurvey {

	
	
	private ArrayList<ICompletePatientRecord> _patientsTakenThis;
	
	private ArrayList<Question> _questions;
	private String _name;
	
	
	public Survey(String surveyName)
	{
		_name = surveyName;
		_patientsTakenThis = new ArrayList<ICompletePatientRecord>();
		_questions = new ArrayList<Question>();
	}
	
	public String getName()
	{
		return _name;
	}
	
	
	public ArrayList<Question> getQuestions() {
		
		return _questions;
	}
	
	
	
	public ArrayList<ICompletePatientRecord> getPatientsTakenThis()
	{
		return _patientsTakenThis;
	}
	
	public void AddQuestion(Question question)
	{
		_questions.add(question);
	}
	public void AddQuestion(int questionNumber, String question)
	{
		_questions.add(new Question(questionNumber, question));
	}
	
	public void AddPatient(ICompletePatientRecord patient)
	{
		_patientsTakenThis.add(patient);
	}

	@Override
	public String toString() {
		
		String s = "SURVEY NAME: " + _name + " \nQUESTIONS: ";
		
		for(Question q : _questions)
		{
			s += q.getQuestion().toString() + ", ";
		}
		return s;
	}

	
	
	

	
	
	
	
	
}
