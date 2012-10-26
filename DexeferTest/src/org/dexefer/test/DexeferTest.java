package org.dexefer.test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.dexefer.DXFFile;
import org.dexefer.entities.Line;

public class DexeferTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		
		DXFFile file = new DXFFile();
		file.getEntities().add(new Line(0, 0, 0, 100, 100, 100));
		
		FileOutputStream oStream;
		try {
			oStream = new FileOutputStream(File.createTempFile("dexeferTest", ".dxf"));
			file.write(oStream);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();			
		}

	}

}
