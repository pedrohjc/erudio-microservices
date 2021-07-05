package com.pedrohjc;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MathController {

    @RequestMapping(value = "/sum/{n1}/{n2}", method = RequestMethod.GET)
    public int sum(@PathVariable("n1") String n1, @PathVariable("n2") String n2) throws Exception{
        if (!isNumeric(n1) || !isNumeric(n2)){
            throw new Exception("Wrong input");
        }
        int sum  = Integer.parseInt(n1) + Integer.parseInt(n2);
        return sum;
    }

    private boolean isNumeric(String num) {
        if(num == null) return false;
        return num.matches("[-+]?[0-9]*\\.?[0-9]+");
    }


}
