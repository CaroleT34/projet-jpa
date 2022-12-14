/**
 * FileUtils.java
 */
package fr.diginamic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * @author CaroleTOULORGE
 *
 */
public class FileUtils {

	public static List<String> readFromInputStream(InputStream inputStream) throws IOException {

		List<String> lines = new ArrayList<>();

		try (BufferedReader br = new BufferedReader(new InputStreamReader(inputStream))) {
			String line;
			while ((line = br.readLine()) != null) {
				lines.add(line);
			}
		}
		return lines;
	}
}
