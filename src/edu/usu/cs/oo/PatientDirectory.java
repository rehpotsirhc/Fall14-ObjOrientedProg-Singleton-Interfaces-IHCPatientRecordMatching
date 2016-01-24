/**
 * 
 */
package edu.usu.cs.oo;

import java.util.ArrayList;

/**
 * @author Christopher Johnson
 *
 */
class PatientDirectory implements IPatientDirectory {

	
	private ArrayList<ICompletePatientRecord> _completePatientRecords;
	private ArrayList<IPatientInfo> _partialPatientRecords;
	private ArrayList<IPatientSurveyRecord> _patientSurveyRecords;
	
	private static IPatientDirectory _patientDirectory;
	private boolean _recordsMatched;
	
	private PatientDirectory()
	{
		_completePatientRecords = new ArrayList<ICompletePatientRecord>();
		_partialPatientRecords = new ArrayList<IPatientInfo>();
		_patientSurveyRecords = new ArrayList<IPatientSurveyRecord>();
	}
	
	public static IPatientDirectory Directory()
	{
		if(_patientDirectory == null)  _patientDirectory = new PatientDirectory();
			
		return _patientDirectory;
	}
	
	private void MatchUpRecords()
	{
		if(_partialPatientRecords.size() > 0 && _patientSurveyRecords.size() > 0)
		{
			
			for(IPatientInfo pi : _partialPatientRecords)
			{
				if(containsPatient(pi)) continue;
				
				ICompletePatientRecord cpr = new CompletePatientRecord(pi);
				
				for(IPatientSurveyRecord psr : _patientSurveyRecords)
				{
					if(pi.IsSamePatient(psr)) 
						{
							cpr.AddPatientSurveyRecord(psr);
							psr.getSurvey().AddPatient(cpr);
						}
					
				}
				
				_completePatientRecords.add(cpr);
			}
			
			_patientSurveyRecords.clear();
			_partialPatientRecords.clear();
			
			_recordsMatched = true;
		}
	}
	
	private boolean containsPatient(IPatientInfo patientInfo)
	{
		for(ICompletePatientRecord pi: _completePatientRecords)
		{
			if(pi.equals(patientInfo)) return true;
		}
		
		return false;
	}
	
	
	public ArrayList<ICompletePatientRecord> getPatients()
	{
		if(!_recordsMatched) MatchUpRecords();
		
		return _completePatientRecords;
	}
	
	
	public void AddPatientSurveyRecord(IPatientSurveyRecord patientSurveyRecord)
	{
		_patientSurveyRecords.add(patientSurveyRecord);
		_recordsMatched = false;
	}	
	
	public void AddPartialPatientRecord(IPatientInfo patient)
	{
		_partialPatientRecords.add(patient);
		
		_recordsMatched = false;
	}

	@Override
	public String toString() {
		
		String s = "";
		for(ICompletePatientRecord cpr : getPatients())
		{
			s += cpr.toString() + "\n\n\n";
		}
		
		return s;
	}
	
	
	
	
	
	
	
	
}
