/**
 * 
 */
package edu.usu.cs.oo;

/**
 * @author Christopher Johnson
 *
 */
public class PatientSurveyInfo implements IPatientSurveyInfo {

	
	private String _firstName;
	private String _lastInitial;
	private Gender _gender;
	private int _ageAtSurvey;
	public PatientSurveyInfo(String firstName, String lastInitial, String gender, int ageAtSurvey)
	{
		_firstName = firstName;
		_lastInitial = lastInitial;
		
		if(gender.equals("F")) _gender = Gender.Female;
		else _gender = Gender.Male;
		
		_ageAtSurvey = ageAtSurvey;
	}
	
	public String getFirstName()
	{
		return _firstName;
	}
	public String getLastInitial()
	{
		return _lastInitial;
	}
	public Gender getGender()
	{
		return _gender;
	}
	public int getAgeAtSurvey()
	{
		return _ageAtSurvey;
	}

	@Override
	public String toString() {

		return String.format("PATIENT'S INFO COLLECTED WITH SURVEY: NAME: %s %s.; GENDER: %s; Age When Survey Taken: %s", getFirstName(), getLastInitial(), getGender(), getAgeAtSurvey());
	
	}
	
	
}
