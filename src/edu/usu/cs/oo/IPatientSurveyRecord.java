package edu.usu.cs.oo;


import java.util.ArrayList;

import org.joda.time.LocalDate;




interface IPatientSurveyRecord {
	
	
	
	public ISurvey getSurvey();
	
	public ArrayList<Response> getSurveyResponses();
	
	public IPatientSurveyInfo getPatientSurveyInfo();
	
	public LocalDate getDateTaken();
	
	public boolean IsSurveyValid();
	public boolean IsSurveyComplete();
	

}
