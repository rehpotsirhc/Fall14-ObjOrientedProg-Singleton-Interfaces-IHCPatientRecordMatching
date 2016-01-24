/**
 * 
 */
package edu.usu.cs.oo;

import org.joda.time.LocalDate;

/**
 * @author Christopher Johnson
 *
 */
interface IPatientInfo {

	
	/**
	 * patient's id
	 */
	public int getId();
	
	/**
	 * patient's first name
	 */
	public String getFirstName();
	/**
	 * patient last name
	 */
	public String getLastName();
	
	/**
	 * patient's full name
	 */
	public String getFullName();
	

	/**
	 *  patient's date of birth
	 */
	public LocalDate getDateOfBirth();
	
	
	/**
	 * patient's Gender (type Gender enum)
	 */
	public Gender getGender();
	
	/**
	 * patient's age (type Gender enum)
	 */
	public int getAge();
	
	public boolean IsSamePatient(IPatientSurveyRecord patientSurveyRecord);
}
