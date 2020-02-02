package org.course.spring.exceptions;

public class PersonException extends Exception {

	private static final long serialVersionUID = -1849937245559480095L;

	/**
	 * Creates a new instance of <code>PersonException</code> without detail
	 * message.
	 */
	public PersonException() {
	}

	/**
	 * Constructs an instance of <code>PersonException</code> with the specified
	 * detail message.
	 * 
	 * @param msg the detail message.
	 */
	public PersonException(String msg) {
		super(msg);
	}
}
