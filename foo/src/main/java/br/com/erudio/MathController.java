package br.com.erudio;

import br.com.erudio.exception.UnsupportedInputException;
import br.com.erudio.math.NumberConverter;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class MathController {

    @RequestMapping(value = "/sum/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public double sum(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) throws Exception {
        if (!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)) {
            throw new UnsupportedInputException("Please set a numeric input");
        }
        Double sum = NumberConverter.convertToDouble(numberOne) + NumberConverter.convertToDouble(numberTwo);
        return sum;
    }

    @RequestMapping(value = "/sub/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public double sub(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) throws Exception {
        if (!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)) {
            throw new UnsupportedInputException("Please set a numeric input");
        }
        Double sub = NumberConverter.convertToDouble(numberOne) - NumberConverter.convertToDouble(numberTwo);
        return sub;
    }

    @RequestMapping(value = "/times/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public double times(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) throws Exception {
        if (!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)) {
            throw new UnsupportedInputException("Please set a numeric input");
        }
        Double op = NumberConverter.convertToDouble(numberOne) * NumberConverter.convertToDouble(numberTwo);
        return op;
    }

    @RequestMapping(value = "/div/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public double div(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) throws Exception {
        if (!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)) {
            throw new UnsupportedInputException("Please set a numeric input");
        }
        Double op = NumberConverter.convertToDouble(numberOne) / NumberConverter.convertToDouble(numberTwo);
        return op;
    }

    @RequestMapping(value = "/media/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public double media(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) throws Exception {
        if (!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)) {
            throw new UnsupportedInputException("Please set a numeric input");
        }
        Double op = (NumberConverter.convertToDouble(numberOne) + NumberConverter.convertToDouble(numberTwo))/ 2;
        return op;
    }

    @RequestMapping(value = "/sqrt/{numberOne}", method = RequestMethod.GET)
    public double sqrt(@PathVariable("numberOne") String numberOne) throws Exception {
        if (!NumberConverter.isNumeric(numberOne)) {
            throw new UnsupportedInputException("Please set a numeric input");
        }
        Double op = Math.sqrt(NumberConverter.convertToDouble(numberOne));
        return op;
    }

}
