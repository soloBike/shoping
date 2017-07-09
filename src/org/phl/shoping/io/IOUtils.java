package org.phl.shoping.io;

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

public class IOUtils {

	public IOUtils() {

	}

	public static void persistObject(Object object, OutputStream out) {
		if (object == null)
			return;
		try {
			persistObjectNoClose(object, out);
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			out.close();

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static void persistObjectNoClose(Object object, OutputStream out) {
		if (object == null)
			return;
		ObjectOutputStream oos = null;
		try {
			oos = new ObjectOutputStream(out);
			oos.writeObject(object);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static Object getObject(InputStream in) {
		if (in == null)
			return null;
		Object object = null;
		try {
			object = getObjectNoClose(in);
			in.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return object;

	}

	public static Object getObjectNoClose(InputStream in) {
		if (in == null)
			return null;
		Object object = null;
		try {
			ObjectInputStream ois = new ObjectInputStream(in);
			object = ois.readObject();
		} catch (EOFException eofexception) {
		} catch (Exception e) {
			e.printStackTrace();
		}

		return object;
	}

}
