/**
 * 
 */
package edu.usu.cs.oo;

/**
 * @author Christopher Johnson
 *
 */
public class Response {

	private String _response;
	
	public Response(String response)
	{
		_response = response;
	}
	
	
	public String getResponse()
	{
		return _response;
	}


	@Override
	public String toString() {
	
		return _response;
	}
	
	
	
}
