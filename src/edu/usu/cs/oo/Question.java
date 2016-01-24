/**
 * 
 */
package edu.usu.cs.oo;

/**
 * @author Chris
 *
 */
class Question {

	private String _question;
	private int _questionNumber;
	
	
	public Question(int questionNUmber, String question)
	{
		_questionNumber = questionNUmber;
		_question = question;
	}
	
	
	public String getQuestion()
	{
		return _question;
	}
	
	public int getQuestionNumber()
	{
		return _questionNumber;
	}


	@Override
	public String toString() {
		
		return String.format("{0}: {1}", _questionNumber, _question);
	}
	
	
}
