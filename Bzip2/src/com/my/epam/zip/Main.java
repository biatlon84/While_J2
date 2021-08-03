package com.my.epam.zip;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Main {
	public static void main(String[] args) {
		/*
		 * File f = new File("/home/kwas/123.txt");
		 * 
		 * CBZip2InputStream inS = new CBZip2InputStream(null); FileOutputStream s; try
		 * { s = new FileOutputStream(f); } catch (FileNotFoundException e1) { // TODO
		 * Auto-generated catch block e1.printStackTrace(); } try { CBZip2OutputStream
		 * out = new CBZip2OutputStream(s); } catch (IOException e) { // TODO
		 * Auto-generated catch block e.printStackTrace(); }
		 * 
		 * } public static ArchiveOutputStreamFactory getCompressor() { // this is not
		 * very beautiful but at some point we will // get rid of
		 * ArchiveOutputStreamFactory in favor of the writable Resource return new
		 * ArchiveOutputStreamFactory() { public OutputStream
		 * createArchiveOutputStream() { try { OutputStream outStr = new
		 * FileOutputStream("/home/kwas/123.txt"); outStr.write('B'); outStr.write('Z');
		 * return new CBZip2OutputStream(outStr); } catch (Exception e) { String message
		 * = String.format("Unable to create bzip2 output stream for file %s",
		 * destination); throw new RuntimeException(message, e); } } }; }
		 */
		compress();
	}

	public static void compress() {
		try {

			File fileToArchive = new File("/home/kwas/test.in");

			BufferedInputStream input = new BufferedInputStream(new FileInputStream(fileToArchive));

			File archivedFile = new File(fileToArchive.getName() + ".bz2");
			archivedFile.createNewFile();

			FileOutputStream fos = new FileOutputStream(archivedFile);
			BufferedOutputStream bufStr = new BufferedOutputStream(fos);
			// added bzip2 prefix
			fos.write("BZ".getBytes());
			CBZip2OutputStream bzip2 = new CBZip2OutputStream(bufStr,9);

			while (input.available() > 0) {
				int size = 1000000;

				if (input.available() < 1000000) {
					size = input.available();
				}
				byte[] bytes = new byte[size];

				input.read(bytes);

				bzip2.write(bytes);
			}
			bzip2.close();
			bufStr.close();
			fos.close();
			input.close();

		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
