package org.capgemini.proyecto1.helper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.capgemini.proyecto1.model.Juego;
import org.springframework.web.multipart.MultipartFile;

public class CSVHelper {
	public static String TYPE = "text/csv";
	static String[] HEADERs = { "Rank", "Name", "Platform", "Year", "Genre", "Publisher", "NA_Sales", "EU_Sales",
			"JP_Sales", "Other_Sales", "Global_Sales" };

	public static boolean hasCSVFormat(MultipartFile file) {
		if (!TYPE.equals(file.getContentType())) {
			return false;
		}

		return true;
	}

	public static List<Juego> csvToJuegos(InputStream is) {
		try (BufferedReader fileReader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
				CSVParser csvParser = new CSVParser(fileReader,
						CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim());) {
			List<Juego> juegosList = new ArrayList<>();
			Iterable<CSVRecord> csvRecords = csvParser.getRecords();
			for (CSVRecord csvRecord : csvRecords) {
				try {
					Juego juego = new Juego(Integer.parseInt(csvRecord.get("Rank")), csvRecord.get("Name"),
							csvRecord.get("Platform"), Integer.parseInt(csvRecord.get("Year")), csvRecord.get("Genre"),
							csvRecord.get("Publisher"), Double.parseDouble(csvRecord.get("NA_Sales")),
							Double.parseDouble(csvRecord.get("EU_Sales")),
							Double.parseDouble(csvRecord.get("JP_Sales")),
							Double.parseDouble(csvRecord.get("Other_Sales")),
							Double.parseDouble(csvRecord.get("Global_Sales")));
					juegosList.add(juego);
				} catch (NumberFormatException e) {
					continue;
				}
			}
			return juegosList;
		} catch (IOException e) {
			throw new RuntimeException("fail to parse CSV file: " + e.getMessage());
		}
	}
}
