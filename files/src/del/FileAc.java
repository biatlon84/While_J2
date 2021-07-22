package del;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileAc {

	private char[] ch = new char[2];
	private short[][] array = new short[267][14];

	public short[][] getF(String string) {
		int bu = 0;
		File y = new File("/home/kwas/eclipse-workspace/files/" + string);
		try {
			FileReader fr = new FileReader(y);
			int j = 0;
			int C = 0;
			while (bu >= 0) {
				bu = fr.read();
				if (bu == '$') {
					fr.read(ch);
					String buf = new String();
					buf = ("" + ch[0] + ch[1]);
					array[C][j] = (short) Integer.parseInt(buf, 16);
					j++;
				}
				if (bu == ')') {
					if (fr.read() == ',') {
						C++;
						j = 0;
					} else {

					}
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return array;

	}

}
