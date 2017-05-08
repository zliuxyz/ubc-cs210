package example;

import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

import java.util.List;

// An example of a simple SAX parser to parse a library XML file

public class LibraryParser extends DefaultHandler {

	private StringBuffer accumulator;

    // Constructor
    public LibraryParser() {
        accumulator = null;
    }

	/**
	 * Called at the start of the document (as the name suggests)
	 */
	@Override
	public void startDocument() {
        // Just so you can visualize how the parser is working
		System.out.println("Start Document!");

		// Use accumulator to remember information parsed. Just initialize for
		// now.
		accumulator = new StringBuffer();
	}

	/**
	 * Called when the parsing of an element starts. (e.g., <book>)
	 * 
	 * Lookup documentation to learn meanings of parameters.
	 */
	@Override
	public void startElement(String namespaceURI, String localName,
			String qName, Attributes atts) {

        // Just so you can visualize how the parser is working
		System.out.println("StartElement: " + qName);

		// What are we parsing?
		if (qName.toLowerCase().equals("book")) {
            // Just so you can visualize how the parser is working
			System.out.println("Reached a new book with isbn = " + atts.getValue("isbn"));
		} 
		// Let's start the accumulator
		// to remember the value that gets parsed
		accumulator.setLength(0);
	}

	/**
	 * Called for values of elements
	 * 
	 * Lookup documentation to learn meanings of parameters.
	 */
	public void characters(char[] temp, int start, int length) {
		// Remember the value parsed
		accumulator.append(temp, start, length);
	}

	/**
	 * Called when the end of an element is seen. (e.g., </title>)
	 * 
	 * Lookup documentation to learn meanings of parameters.
	 */
	public void endElement(String uri, String localName, String qName) {
        String data = accumulator.toString().trim();

        // Just so you can visualize how the parser is working
		System.out.println("EndElement: " + qName + " value: " + data);

		// Reset the accumulator because we have seen the value
		accumulator.setLength(0);
	}

	/**
	 * Called when the end of the document is reached
	 */
	public void endDocument() {
		// Just so you can visualize how the parser is working
		System.out.println("End Document!");
	}

}
