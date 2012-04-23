package warborn.model;

public class MapNotFoundException extends Exception {

	private static final long serialVersionUID = 1L;
	private String message;
	
	public MapNotFoundException(String msg){
		super();
		message=msg;
	}
	
	public String toString(){
		return message;
		
	}
}
