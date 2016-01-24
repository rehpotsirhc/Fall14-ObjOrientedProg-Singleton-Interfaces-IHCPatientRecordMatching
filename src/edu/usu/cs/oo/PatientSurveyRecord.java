/**
 * 
 */
package edu.usu.cs.oo;

import java.util.ArrayList;

import org.joda.time.LocalDate;


/**
 * @author Christopher Johnson
 *
 */
public class PatientSurveyRecord implements IPatientSurveyRecord {
	
	
	
	
	private ISurvey _survey;
	private ArrayList<Response> _responses;
	private IPatientSurveyInfo _patientInfo;
	private LocalDate _dateTaken;
	
	
	
	public PatientSurveyRecord(IPatientSurveyInfo patientInfo, ISurvey survey, ArrayList<Response> surveyResponses, LocalDate dateTaken)
	{
		_survey = survey;
		_patientInfo = patientInfo;
		_responses = surveyResponses;
		_dateTaken = dateTaken;
	}
	
	
	public ISurvey getSurvey()
	{
		return _survey;
	}
	
	public ArrayList<Response> getSurveyResponses()
	{
		return _responses;
	}
	
	public IPatientSurveyInfo getPatientSurveyInfo()
	{
		return _patientInfo;
	}

	
	public LocalDate getDateTaken() {

		return _dateTaken;
	}
	
	public boolean IsSurveyValid()
	{
		return !(_survey.getQuestions().size() < _responses.size());
	}
	public boolean IsSurveyComplete()
	{
		return _survey.getQuestions().size() == _responses.size();
	}
	
	@Override
	public String toString() {

		
		
		String s = "PATIENT'S RESPONSES: ";
		for(Response r: _responses)
		{
			s += r.getResponse() + ", ";
		}
		
		return _survey.toString() + "\n\n" + _patientInfo.toString() + "\n" + s;
	
	}


}
