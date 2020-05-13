package pl.polsl.bartoszek.katarzyna.arabictoromanconverter.service;

import org.springframework.stereotype.Service;
import pl.polsl.bartoszek.katarzyna.arabictoromanconverter.model.ConversionHistory;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Responsible for reading and writing history of the numbers that have been converted.
 * Reads and saves the history from a file.
 *
 * @author Katarzyna Bartoszek
 * @version 1.0
 */
@Service
public class ConversionHistoryService {

    /**
     * Responsible for saving some information about the conversion into a file named historyDatabase.txt.
     *
     * @param conversionHistory single record of the history
     * @throws IOException if some errors with the file occurs
     */
    public void save(ConversionHistory conversionHistory) throws IOException {
        FileWriter fileWriter = new FileWriter("historyDatabase.txt", true);
        PrintWriter printWriter = new PrintWriter(fileWriter);
        printWriter.printf("%s|%s|%tF|%s\n", conversionHistory.getValue(), conversionHistory.getConvertedValue(), conversionHistory.getConversionDate(), conversionHistory.getStatus());
        printWriter.close();
    }

    /**
     * Reads conversion history from the file.
     *
     * @return history which is a list of already converted numbers
     * @throws FileNotFoundException exception
     * @throws ParseException exception
     */
    public List<ConversionHistory> getHistory() throws FileNotFoundException, ParseException {
        List<ConversionHistory> history = new ArrayList<>();

        File file = new File("historyDatabase.txt");
        Scanner scanner = new Scanner(file);
        while (scanner.hasNext()) {
            String line = scanner.nextLine();
            ConversionHistory conversionHistory = new ConversionHistory();
            String values[] = line.split("\\|");
            conversionHistory.setValue(values[0]);
            conversionHistory.setConvertedValue(values[1]);
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            conversionHistory.setConversionDate(LocalDate.parse(values[2]));
            conversionHistory.setStatus(values[3]);
            history.add(conversionHistory);
        }
        return history;
    }
}
