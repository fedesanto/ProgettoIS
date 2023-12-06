package progettoIS.gruppo01.Calculator.Complex;

public class ComplexNum {

    private double realPart;
    private double imgPart;

    //Custruttore con parametri di inizializzazione
    public ComplexNum(double realPart, double imgPart) {
        this.realPart = realPart;
        this.imgPart = imgPart;
    }

    public double getRealPart() {
        return realPart;
    }

    public double getImgPart() {
        return imgPart;
    }

    /*
    Convertitore del numero complesso in stringa
        Restituisce il numero nel formato “a + bj”, “a” o “bj”, 
        dove a e b sono rispettivamente la parte reale ed immaginaria del numero
     */
    @Override
    public String toString() {
        if (this.imgPart == 0) {
            return Double.toString(this.realPart);

        } else if (this.realPart == 0) {
            return Double.toString(this.imgPart) + 'j';

        } else {

            return Double.toString(this.realPart) + Double.toString(this.imgPart) + 'j';
        }
    }

    /*
    Costruzione di un numero complesso da una stringa nel formato “a + bj”, “a” o “bj”,
    dove a e b sono rispettivamente la parte reale ed immaginaria del numero
        
        Input:
            - num : numero complesso sotto forma di stringa
        Output:
            - numero complesso costruito dalla stringa oppure null
            se il formato della stringa non è valido
     */
    public static ComplexNum parseComplex(String num) {
        double real = 0;
        double img = 0;

        if (num.matches("-?\\d+(.\\d+)? [-+] \\d+(.\\d+)?j")) {
            String numbers[] = num.split(" ");

            real = Double.parseDouble(numbers[0]);

            String sign = numbers[1];

            String stringImg = numbers[2].substring(0, numbers[2].length() - 1);

            if (sign.equals("-")) {
                img = Double.parseDouble("-" + stringImg);
            } else {
                img = Double.parseDouble(stringImg);
            }

        } else if (num.matches("-?\\d+(.\\d+)?")) {
            
            real = Double.parseDouble(num);
            
        } else if (num.matches("-?\\d+(.\\d+)?j")) {
            
            String stringImg = num.substring(0, num.length() - 1);
            
            img = Double.parseDouble(stringImg);
            
        } else {
            return null;
        }

        return new ComplexNum(real, img);
    }

}
