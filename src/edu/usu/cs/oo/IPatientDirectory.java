package edu.usu.cs.oo;

import java.util.ArrayList;

interface IPatientDirectory {
	
	
	
	public ArrayList<ICompletePatientRecord> getPatients();
	
	
	public void AddPatientSurveyRecord(IPatientSurveyRecord patientSurveyRecord);
	public void AddPartialPatientRecord(IPatientInfo patient);

}
