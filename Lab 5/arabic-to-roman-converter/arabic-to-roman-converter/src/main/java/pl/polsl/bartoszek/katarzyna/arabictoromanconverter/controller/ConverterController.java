package pl.polsl.bartoszek.katarzyna.arabictoromanconverter.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.polsl.bartoszek.katarzyna.arabictoromanconverter.exception.InvalidDataException;
import pl.polsl.bartoszek.katarzyna.arabictoromanconverter.service.ConverterService;

import java.io.IOException;

/**
 * Responsible for running the converter servlet.
 * Handles requests coming from the user.
 * The annotated class is a controller.
 *
 * @author Katarzyna Bartoszek
 * @version 1.1
 */
@Controller
public class ConverterController {

    /**
     *  A reference to the class ConverterService object.
     *  The annotation passes the values for the fields using the property name.
     *  Spring assigns the fields with the passed values.
     */
    @Autowired
    private ConverterService converterService;

    /**
     * GetMapping annotation is used for mapping HTTP POST requests.
     * Handles GET requests for / (slash) and returns index.
     *
     * @return view index
     */
    @GetMapping("/")
    public String index(){
        return "index";
    }

    /**
     * The annotation is used for mapping HTTP POST requests.
     * Handles POST requests for /convert and returns the name of the view (arabic2roman).
     * A view is responsible for rendering the HTML content.
     *
     * @param data the Arabic value given by the user
     * @param model Model model
     * @return view arabic2roman
     * @throws InvalidDataException in case of invalid Arabic number
     * @throws IOException exception
     */
    @PostMapping("/convert")
    public String convert(@RequestParam("data") String data, Model model) throws InvalidDataException, IOException {
        String convertedValue = converterService.convertData(data);
        model.addAttribute("convertedValue", convertedValue);
        return "arabic2roman";
    }
}
