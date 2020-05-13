package pl.polsl.bartoszek.katarzyna.arabictoromanconverter.model;

import java.time.LocalDate;

/**
 * Restores information about the numbers that had been converted.
 *
 * @author Katarzyna Bartoszek
 * @version 1.0
 */

public class ConversionHistory {

    /**
     * Arabic value
     */
    private String value;

    /**
     * Roman value
     */
    private String convertedValue;

    /**
     * Variable storing the actual date
     */
    private LocalDate conversionDate;

    /**
     * Status of the conversion (SUCCESS or ERROR)
     */
    private String status;

    /**
     * The constructor responsible for getting the date.
     */
    public ConversionHistory() {
        conversionDate = LocalDate.now();
    }

    /**
     * Returns the Arabic value.
     * @return Arabic value
     */
    public String getValue() {
        return value;
    }

    /**
     * Sets the Arabic value.
     * @param value Arabic number
     */
    public void setValue(String value) {
        this.value = value;
    }

    /**
     * Returns the Roman value.
     * @return Roman value
     */
    public String getConvertedValue() {
        return convertedValue;
    }

    /**
     * Sets the Roman value.
     * @param convertedValue Roman number
     */
    public void setConvertedValue(String convertedValue) {
        this.convertedValue = convertedValue;
    }

    /**
     * Returns the date.
     * @return date of conversion
     */
    public LocalDate getConversionDate() {
        return conversionDate;
    }

    /**
     * Sets the conversion date.
     * @param conversionDate date of conversion
     */
    public void setConversionDate(LocalDate conversionDate) {
        this.conversionDate = conversionDate;
    }

    /**
     * Returns the status of the conversion (SUCCESS or ERROR).
     * @return status
     */
    public String getStatus() {
        return status;
    }

    /**
     * Sets the status.
     * @param status status of the conversion
     */
    public void setStatus(String status) {
        this.status = status;
    }
}
