package edu.usu.cs.oo;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Scanner;

import org.joda.time.LocalDate;


//This is a token change
//This is a second token change that that I know how to add reviewers to my own pull requests
public class Driver {
	
	public static void main(String[] args) throws ParseException, IOException
	{
		LoadPartialPatientRecords("master");
		
		LoadPatientSurveyRecords("questions");
		
		WriteFile("Output");
	}
	
	
	private static void WriteFile(String fileName) throws IOException
	{
		 Writer w = new FileWriter(fileName);
		 
		 w.write(PatientDirectory.Directory().toString());
		
		w.close();
	}
	
	
	private static void LoadPartialPatientRecords(String fileName) throws FileNotFoundException, ParseException
	{
		Scanner a = new Scanner(new FileReader(fileName));

		a.nextLine(); //Doing this to ignore the header
		
		while (a.hasNextLine())
		{
			String line = a.nextLine();
			String[] data = line.split(",");
			
			int id = Integer.parseInt(data[0]);
			String firstName = data[1];
			String lastName = data[2];
			String birthday = data[3];
			String gender = data[4];
		
			
			PatientDirectory.Directory().AddPartialPatientRecord(new PatientInfo(id, firstName, lastName, gender, birthday));
			
		}
		
		a.close();
	}
	
	private static void LoadPatientSurveyRecords(String fileName) throws FileNotFoundException
	{
	
		Scanner a = new Scanner(new FileReader(fileName));

	a.nextLine(); //Doing this to ignore the header
	
	ISurvey s = new Survey("A COOL SURVEY");
	s.AddQuestion(1, "Is OOP the coolest or what?");
	s.AddQuestion(2, "Do you like C# or Java better?");
	s.AddQuestion(3, "Did you eat a nutritious breakfast?");
	s.AddQuestion(5, "Really, OOP is the best");
	s.AddQuestion(5, "Are there two question 5s?");
	
	
	
	while (a.hasNextLine())
	{
		String line = a.nextLine();
		String[] data = line.split(",");
		
		String firstName = data[0];
		String lastInitial = data[1];
		int age = Integer.parseInt(data[2]);
		String gender = data[3];
		String q1 = data[4];
		String q2 = data[5];
		String q3 = data[6];
		String q4 = data[7];
		String q5 = data[8];
		
		PatientSurveyInfo info = new PatientSurveyInfo(firstName, lastInitial, gender, age);
		
	
		
		
		ArrayList<Response> responses = new ArrayList<Response>();
		
		responses.add(new Response(q1));
		responses.add(new Response(q2));
		responses.add(new Response(q3));
		responses.add(new Response(q4));
		responses.add(new Response(q5));
		
	
		
		PatientDirectory.Directory().AddPatientSurveyRecord(new PatientSurveyRecord(info, s, responses, new LocalDate(2014, 2, 1)));
		
	}
	
	a.close();
	}
	
	

}
