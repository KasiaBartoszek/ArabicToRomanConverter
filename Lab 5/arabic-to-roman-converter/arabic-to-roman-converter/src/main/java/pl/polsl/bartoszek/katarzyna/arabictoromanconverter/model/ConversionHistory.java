package pl.polsl.bartoszek.katarzyna.arabictoromanconverter.model;


import javax.persistence.*;
import java.time.LocalDate;

/**
 * Restores information about the numbers that had been converted.
 * The annotation Entity indicates that the class is mapped into a database.
 * The name of this database is the same as the name of the class.
 * The annotation Table sets the table name.
 * This class restores columns such as id, value, converted value, conversion date and conversion status.
 * This project uses XAMPP application which enables to use Apache and MySQL.
 *
 * @author Katarzyna Bartoszek
 * @version 1.1
 */
@Entity
@Table(name = "conversionhistory")
public class ConversionHistory {

    /**
     * This constructor is responsible for adding the values to the variables that are stored in the database.
     * @param id unique record number
     * @param value Arabic number
     * @param convertedValue Roman number
     * @param conversionDate date of conversion
     * @param status conversion status, can be SUCCESS or ERROR
     */
    public ConversionHistory(int id, String value, String convertedValue, LocalDate conversionDate, String status) {
        this.id = id;
        this.value = value;
        this.convertedValue = convertedValue;
        this.conversionDate = conversionDate;
        this.status = status;
    }

    /**
     * Column responsible for storing the unique record number.
     */
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    /**
     * Column which stores Arabic values.
     */
    @Column(name = "value")
    private String value;
    /**
     * Column which stores Roman values.
     */
    @Column(name = "convertedvalue")
    private String convertedValue;
    /**
     * Column which stores the conversion date.
     */
    @Column(name = "conversiondate")
    private LocalDate conversionDate;
    /**
     * Column which stores the conversion status.
     */
    @Column(name = "status")
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

    /**
     * Returns the record id.
     * @return unique record number (id)
     */
    public Integer getId() { return id; }

    /**
     * Sets the record id.
     * @param id unique record number
     */
    public void setId(Integer id) { this.id = id; }
}
