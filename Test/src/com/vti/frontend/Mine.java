package com.vti.frontend;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Mine {
	public static void main(String args[]) {
		Mine m = new Mine();
		System.out.println(m.amethod());
	}

	public int amethod() {
		try {
			FileInputStream dis = new FileInputStream("JavaCodingConvetion.txt");
		} catch (FileNotFoundException fne) {
			System.out.println("No such file found");
			return -1;
		} catch (IOException ioe) {
		}

		finally {
			System.out.println("Doing finally");
		}
		return 0;
	}
}
