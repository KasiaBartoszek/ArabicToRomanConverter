package pl.bartoszek.katarzyna.server.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Converts data entered by the user to Roman numerals.
 * @author Katarzyna Bartoszek
 * @version 1.2
 */
public class NumberConverter {

    /**
     * List of the essential Roman numerals, consists of a Roman value and assigned Arabic value.
     */
    private List<Numeral> reverseSortedNumerals;

    /**
     * The same list created for the needs of the project.
     */
    private List<Numeral> backupReverseSortedNumerals;

    /**
     * Adds the necessary numbers to the list of numbers.
     * The numbers declared in advance are decimal multiples of 1, 4, 5 and 9.
     */
    public NumberConverter() {
        reverseSortedNumerals = new ArrayList<>();
        reverseSortedNumerals.add(new Numeral("M", 1000));
        reverseSortedNumerals.add(new Numeral("CM", 900));
        reverseSortedNumerals.add(new Numeral("D", 500));
        reverseSortedNumerals.add(new Numeral("CD", 400));
        reverseSortedNumerals.add(new Numeral("C", 100));
        reverseSortedNumerals.add(new Numeral("XC", 90));
        reverseSortedNumerals.add(new Numeral("L", 50));
        reverseSortedNumerals.add(new Numeral("XL", 40));
        reverseSortedNumerals.add(new Numeral("X", 10));
        reverseSortedNumerals.add(new Numeral("IX", 9));
        reverseSortedNumerals.add(new Numeral("V", 5));
        reverseSortedNumerals.add(new Numeral("IV", 4));
        reverseSortedNumerals.add(new Numeral("I", 1));
    }

    /**
     * Saves the list of sorted numerals to another list.
     * Uses for-each loop.
     *
     * @return list of sorted numerals
     */
    public List<Numeral> getBackupList() {
        for(Numeral numeral : reverseSortedNumerals)
        {
            backupReverseSortedNumerals.add(numeral);
        }
        return backupReverseSortedNumerals;
    }

    /**
     * Includes the algorithm for converting an Arabic number to a Roman number.
     * @param number Arabic number entered by the user
     * @return <code>String</code> sb which is a Roman number
     */
    public String convertFromArabicToRoman(int number) {
        int i = 0;
        StringBuilder sb = new StringBuilder();
        while ((number > 0) && (i < reverseSortedNumerals.size())) {
            Numeral currentSymbol = reverseSortedNumerals.get(i);
            if (currentSymbol.getArabicValue() <= number) {
                sb.append(currentSymbol.getRomanValue());
                number -= currentSymbol.getArabicValue();
            } else {
                i++;
            }
        }
        return sb.toString();
    }
}
