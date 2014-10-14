package dionis.utils;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class FileUtils {

	public static void saveToFile(String filename, Object obj) {
		
		FileOutputStream fos = null;
		ObjectOutputStream out = null;
		try {
			fos = new FileOutputStream(filename);
			out = new ObjectOutputStream(fos);
			out.writeObject(obj);
			out.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public static Object readFromFile(String filename) {
		Object rv = null;
		FileInputStream fis = null;
		ObjectInputStream in = null;
		try {
			fis = new FileInputStream(filename);
			in = new ObjectInputStream(fis);
			rv = in.readObject();
			in.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return rv;
	}
}
