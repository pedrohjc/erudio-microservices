package br.com.erudio.math;

public class NumberConverter {

    public static Double convertToDouble(String strnumber) {
        if(strnumber==null) return 0d;
        String number = strnumber.replaceAll(",",".");
        if (isNumeric(number)) return Double.parseDouble(number);
        return 0d;
    }

    public static boolean isNumeric(String strnumber) {
        if(strnumber==null) return false;
        String number = strnumber.replaceAll(",",".");
        return number.matches("[-+]?[0-9]*\\.?[0-9]+");
    }

}
