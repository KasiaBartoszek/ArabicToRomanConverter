package pl.polsl.bartoszek.katarzyna.arabictoromanconverter.model;

/**
 * Consists of two elements - the Roman number and the Arabic value assigned to it.
 * @author Katarzyna Bartoszek
 * @version 1.1
 */
public class Numeral {

    /**
     * Roman number saved in advance
     */
    private String romanValue;

    /**
     * Arabic value of the Roman number
     */
    private int arabicValue;

    /**
     * Creates an object containing Roman and Arabic values.
     * @param romanValue Roman value declared in advance
     * @param arabicValue assigned Arabic value
     */
    public Numeral(String romanValue, int arabicValue) {
        this.romanValue = romanValue;
        this.arabicValue = arabicValue;
    }

    /**
     * Returns Roman value.
     * @return <code>String</code> Roman value
     */
    public String getRomanValue(){
        return romanValue;
    }

    /**
     * Returns Arabic value.
     * @return <code>String</code> Arabic value
     */
    public int getArabicValue(){
        return arabicValue;
    }

    /**
     * Sets Roman value.
     * @param romanValue Roman value
     */
    public void setRomanValue(String romanValue){
        this.romanValue = romanValue;
    }

    /**
     * Sets Arabic value.
     * @param ArabicValue Arabic value
     */
    public void setArabicValue(int ArabicValue) {
        this.arabicValue = arabicValue;
    }

    /**
     * Saves an Arabic number and its Roman value.
     * @return <code>String</code> Numeral with Arabic and Roman numbers
     */
    @Override
    public String toString() {
        return "Numeral{" +
                "romanValue='" + romanValue + '\'' +
                ", arabicValue=" + arabicValue +
                '}';
    }
}
