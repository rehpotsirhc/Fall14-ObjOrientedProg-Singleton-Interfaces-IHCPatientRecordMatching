/**
 * 
 */
package edu.usu.cs.oo;

import java.util.ArrayList;

/**
 * @author Christopher Johnson
 *
 */
interface ICompletePatientRecord {


	public ArrayList<IPatientSurveyRecord> getPatientSurveys();
	
	public void AddPatientSurveyRecord(IPatientSurveyRecord patientSurveyRecord);
	
	
	
	
	public IPatientInfo getPatientInfo();
}
