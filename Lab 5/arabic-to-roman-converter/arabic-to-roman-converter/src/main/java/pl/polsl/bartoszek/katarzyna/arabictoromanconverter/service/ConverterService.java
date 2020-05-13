package pl.polsl.bartoszek.katarzyna.arabictoromanconverter.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.polsl.bartoszek.katarzyna.arabictoromanconverter.exception.InvalidDataException;
import pl.polsl.bartoszek.katarzyna.arabictoromanconverter.model.ConversionHistory;
import pl.polsl.bartoszek.katarzyna.arabictoromanconverter.model.NumberConverter;
import pl.polsl.bartoszek.katarzyna.arabictoromanconverter.model.NumberValidator;
import pl.polsl.bartoszek.katarzyna.arabictoromanconverter.repository.ConversionHistoryRepository;

import java.io.IOException;

/**
 * Responsible for the logic of the project.
 * Converts arabic numbers to Roman numbers.
 *
 * @author Katarzyna Bartoszek
 * @version 1.1
 */
@Service
public class ConverterService {

    /**
     *  Refers to an object form the class named ConversionHistoryService.
     *  The annotation @Autowired uses the property name to pass the values for the fields.
     *  Spring automatically assigns the fields with the passed values.
     */
    @Autowired
    private ConversionHistoryRepository conversionHistoryRepository;

    /**
     * Responsible for converting from an Arabic number to a Roman value.
     *
     * @param data input data provided by the user
     * @return Roman number
     * @throws InvalidDataException exception
     * @throws IOException exception
     */
    public String convertData(String data) throws InvalidDataException, IOException {
        ConversionHistory record = new ConversionHistory();
        record.setValue(data);
        try {
            NumberValidator numberValidator = new NumberValidator();
            numberValidator.isDataValid(data);
            NumberConverter numberConverter = new NumberConverter();
            String romanNumber = numberConverter.convertFromArabicToRoman(numberValidator.getArabicNumber());
            record.setConvertedValue(romanNumber);
            record.setStatus("SUCCESS");
            conversionHistoryRepository.save(record);
            return romanNumber;
        }catch (Exception e) {
            record.setStatus("ERROR");
            conversionHistoryRepository.save(record);
            throw e;
        }
    }
}
