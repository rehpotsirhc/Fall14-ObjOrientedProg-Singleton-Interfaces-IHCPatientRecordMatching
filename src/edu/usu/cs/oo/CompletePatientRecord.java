/**
 * 
 */
package edu.usu.cs.oo;

import java.util.ArrayList;


/**
 * @author Christopher Johnson
 *
 */
public class CompletePatientRecord implements ICompletePatientRecord {

	
	private IPatientInfo _patientInfo;
	private ArrayList<IPatientSurveyRecord> _patientSurveyRecords;

	
	public CompletePatientRecord(IPatientInfo patientInfo)
	{
		_patientInfo = patientInfo;
		_patientSurveyRecords = new ArrayList<IPatientSurveyRecord>();
	}
	
		
	public ArrayList<IPatientSurveyRecord> getPatientSurveys()
	{
		return  _patientSurveyRecords;
	}
	
	public void AddPatientSurveyRecord(IPatientSurveyRecord patientSurveyRecord)
	{
		_patientSurveyRecords.add(patientSurveyRecord);
	}

	
	public IPatientInfo getPatientInfo()
	{
		return _patientInfo;
	}


	@Override
	public String toString() {
		
		String s = "==================================================================BEGIN PATIENT RECORD==================================================================\n\n"+
					"PATIENT'S INFO:\n" + _patientInfo +"\n\n" +
					"PATIENT'S SURVEY RECORDS: \n\n";
		
	
		for(IPatientSurveyRecord psr : _patientSurveyRecords)
		{
		
			s += "++++++++++++++++++++++++++++++++++++++++START OF SURVEY RECORD++++++++++++++++++++++++++++++++++++++++\n\n" + 
			psr + 
			"\n\n++++++++++++++++++++++++++++++++++++++++END OF SURVEY RECORD++++++++++++++++++++++++++++++++++++++++\n\n"+
			
			"==================================================================END PATIENT RECORD==================================================================\n";
		}
		return s;
	}
	
	
	
	
	

	

	
	
}
