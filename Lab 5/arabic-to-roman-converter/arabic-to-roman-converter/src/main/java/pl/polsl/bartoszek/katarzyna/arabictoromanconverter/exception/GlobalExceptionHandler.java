package pl.polsl.bartoszek.katarzyna.arabictoromanconverter.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

/**
 * Responsible for handling global exceptions.
 *
 * @author Katarzyna Bartoszek
 * @version 1.0
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    /**
     * The class of exception it catches is InvalidDataException.
     * Shows the page with an error.
     *
     * @param e exception
     * @return mav view
     */
    @ExceptionHandler(value = {InvalidDataException.class})
    public ModelAndView fileNotFoundExceptionHandler(InvalidDataException e) {

        ModelAndView mav = new ModelAndView();
        mav.setViewName("error");
        mav.addObject("message", "Invalid data.");
        //mav.getModel().put("text", "Invalid data.");
        return mav;
    }
}
