/**
 * 
 */
package edu.usu.cs.oo;

import java.text.ParseException;

import org.joda.time.LocalDate;
import org.joda.time.Years;
import org.joda.time.format.DateTimeFormat;


/**
 * @author Christopher Johnson
 *
 */
class PatientInfo implements IPatientInfo {

	private final static String DATEFORMAT = "MM/dd/yyyy";
	private int _id;
	private String _firstName;
	private String _lastName;
	private LocalDate _dateOfBirth;
	private Gender _gender;
	
	public PatientInfo(int id, String firstName, String lastName, String gender,  String dateOfBirth) throws ParseException
	{
	
	
		
		this(id, firstName, lastName, gender,  DateTimeFormat.forPattern(DATEFORMAT).parseLocalDate(dateOfBirth));
	}
	
	
	public PatientInfo(int id, String firstName, String lastName, String gender,  LocalDate dateOfBirth)
	{
		_id = id;
		_firstName = firstName;
		_lastName = lastName;
		
		if(gender.equals("F")) _gender = Gender.Female;
		else _gender = Gender.Male;
		
		_dateOfBirth = dateOfBirth;
		
	}
	
	
	
	
	
	@Override
	public int getId()
	{
		return _id;
	}
	
	@Override
	public String getFirstName() {
	
		return _firstName;
	}

	
	@Override
	public String getLastName() {
		
		return _lastName;
	}

	
	@Override
	public String getFullName() {
		
		return  getFirstName() + getLastName();
	}
	
	@Override
	public LocalDate getDateOfBirth()
	{
		return _dateOfBirth;
	}
	

	

	@Override
	public Gender getGender() {
		
		return _gender;
	}

	
	@Override
	public int getAge() {
		
		new LocalDate();
		return getAgeAtDate(LocalDate.now());
	}
	
	
	
	private int getAgeAtDate(LocalDate date)
	{
		
		return Years.yearsBetween(_dateOfBirth, date).getYears();
	
	}
	
	public boolean IsSamePatient(IPatientSurveyRecord patientSurveyRecord)
	{
		IPatientSurveyInfo patientSurveyInfo = patientSurveyRecord.getPatientSurveyInfo();
		
		
		
		return _firstName.equalsIgnoreCase(patientSurveyInfo.getFirstName()) &&
				_lastName.toLowerCase().startsWith(patientSurveyInfo.getLastInitial().toLowerCase()) &&
				_gender.equals(patientSurveyInfo.getGender()) && 		
				getAgeAtDate(patientSurveyRecord.getDateTaken()) == patientSurveyInfo.getAgeAtSurvey();
				
				
	}


	@Override
	public boolean equals(Object obj) {
		
		if(!(obj instanceof PatientInfo)) return false;
		
		if(obj == this) return true;
		
		PatientInfo that = (PatientInfo)obj;
		
		return this.getFirstName().equalsIgnoreCase(that.getFirstName()) 
				&& this.getLastName().equalsIgnoreCase(that.getLastName()) 
				&& this.getDateOfBirth().equals(that.getDateOfBirth())
				&& this.getGender() == that.getGender();
		
	
	}


	@Override
	public int hashCode() {
		
		
		return (this.getFirstName().length() + this.getLastName().length() + getAge());
		
		
	}


	@Override
	public String toString() {
	
	
		return String.format("ID: %s; NAME: %s, %s; GENDER: %s; DateOfBirth: %s; Age: %s", getId(), getLastName(), getFirstName(), getGender(), getDateOfBirth().toString("MM/dd/yyyy"), getAge());
		
	}
	
	
	

	
	


	
	
	
	
	
}
