/*
   Copyright 2012 Luis Román Gutiérrez

   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.
 */
package org.dexefer.test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.dexefer.DXFColor;
import org.dexefer.DXFFile;
import org.dexefer.entities.Circle;
import org.dexefer.entities.Line;

public class DexeferTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		
		DXFFile file = new DXFFile();
		Line line  =new Line(0, 0, 0, 100, 100, 100);
		line.setColorNumber(DXFColor.CYAN.getColorCode());
		file.getEntities().add(line);
		
		Circle circle = new Circle(100, 100, 100, 50);
		circle.setColorNumber(DXFColor.RED.getColorCode());
		file.getEntities().add(circle);
		
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
