package org.dexefer;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;

/**
 * This class extends <c>BufferedWriter</c> providing useful methods to create DXF files.
 * @author luisro
 *
 */
public class DXFWriter extends BufferedWriter {
	
	private static final String CODE_PREFIX="  ";
	
	/**
	 * Creates an instance of DXFWriter decorating the given OutputStream.
	 * @param oStream The OutputStream object where writing will be actually done.
	 */
	public DXFWriter(OutputStream oStream) {
		super(new OutputStreamWriter(oStream));
	}

	/**
	 * Creates an instance of DXFWriter decorating the given Writer.
	 * @param writer The Writer instance where writing will actually be done.
	 */
	public DXFWriter(Writer writer) {
		super(writer);
	}
	
	/**
	 * Creates an instance of DXFWriter decorating the given Writer.
	 * @param writer The Writer instance where writing will actually be done.
	 * @param size 
	 */
	public DXFWriter(Writer writer, int size) {
		super(writer, size);
	}

	/**
	 * Writes a String element to a DXF file.
	 * @param code The code that defines the element's type.
	 * @param value The element's value.
	 * @throws IOException If it's launched by writing operations.
	 */
	public void writeEntry(int code, String value) throws IOException {
		
		this.write(CODE_PREFIX);
		this.write(code);
		this.newLine();
		this.write(value);
		this.newLine();
	}
}
