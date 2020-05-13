package pl.polsl.bartoszek.katarzyna.arabictoromanconverter.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import pl.polsl.bartoszek.katarzyna.arabictoromanconverter.model.ConversionHistory;
import pl.polsl.bartoszek.katarzyna.arabictoromanconverter.service.ConversionHistoryService;

import javax.servlet.http.Cookie;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

/**
 * Responsible for running the history controller (servlet).
 * Handles requests from the user.
 * The annotation in the beginning indicates that the class is a controller.
 *
 * @author Katarzyna Bartoszek
 * @version 1.0
 */
@Controller
public class ConversionHistoryController {

    /**
     * A reference to the class ConversionHistoryService object.
     */
    @Autowired
    private ConversionHistoryService conversionHistoryService;

    /**
     * The annotation is used for mapping HTTP POST requests.
     * Handles GET requests for /history and returns the history view.
     * CookieValue annotation indicates that the displayCounter value is bound to an HTTP cookie.
     *
     * @param displayCounter counts how many times the user has opened the history page
     * @param response HttpServletResponse
     * @param model Model model
     * @return view of the history
     * @throws FileNotFoundException exception
     * @throws ParseException exception
     */
    @GetMapping("/history")
    public String getHistory(@CookieValue(value = "displayCounter", defaultValue = "0")Long displayCounter, HttpServletResponse response, Model model) throws FileNotFoundException, ParseException {
        List<ConversionHistory> history = conversionHistoryService.getHistory();

        displayCounter++;

        Cookie cookie = new Cookie("displayCounter", displayCounter.toString());
        response.addCookie(cookie);
        model.addAttribute("displayCounter",displayCounter.toString());
        model.addAttribute("history",history);
        return "history";
    }

}
