package progettoIS.gruppo01.Calculator.Complex;

public class ComplexNum {

    private double realPart;        //Parte reale del numero complesso
    private double imgPart;         //Parte immaginaria del numero complesso

    //Costruttore con parametri di inizializzazione
    public ComplexNum(double realPart, double imgPart) {
        this.realPart = realPart;
        this.imgPart = imgPart;
    }

    //Get della parte reale
    public double getRealPart() {
        return realPart;
    }

    //Get della parte immaginaria
    public double getImgPart() {
        return imgPart;
    }

    /*
    Convertitore del numero complesso in stringa
    Restituisce il numero complesso nel formato “a + bj”, “a” o “bj”, 
    dove a e b sono rispettivamente la parte reale ed immaginaria del numero
        Input:
            - nessuno
        Output:
            - numero complesso espresso sotto forma di stringa
     */
    @Override
    public String toString() {

        String strReal = Double.toString(realPart);
        String strImg = Double.toString(imgPart);

        /*
            Tramite questo controllo nel caso in cui avessi un double senza 
            la parte decimale, ritorno come stringa solo la parte intera
         */
        if (strReal.matches("//d+.0")) {
            strReal = strReal.substring(0, strReal.length() - 2);
        }

        if (strImg.matches("//d+.0")) {
            strImg = strImg.substring(0, strImg.length() - 2);
        }

        if (imgPart == 0) {
            return strReal;
        } else if (realPart == 0) {
            return strImg;
        } else {
            if (Math.signum(imgPart) == -1.0) {
                return strReal + " - " + strImg.substring(1) + 'j';
            } else {
                return strReal + " + " + strImg + 'j';
            }
        }
        /*
          Per trasformare il numero complesso in una stringa nella forma 
          "a + bj" ho la necessità di conoscere il segno della parte immaginaria
          per inserirlo tra gli spazi.
          Per questo motivo nel caso sia negativa bisogna riportare 
          in stringa il valore assoluto della parte immaginaria, altrimenti 
          avrei due volte lo stesso segno ripetuto
         */
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

        /*
        L'espressione regolare di seguito riportata permette di accettare 
        stringhe nel formato "a + bj", pertanto impone che il numero contenga
        in successione:
            1) uno oppure nessun segno meno
            2) una oppure più cifre
            3) una oppure nessuna parte decimale, in cui ci sarà un punto
               seguito da una oppure più cifre
            4) uno spazio
            5) un segno meno oppure un segno più
            6) uno spazio
            7) una oppure più cifre
            8) una oppure nessuna parte decimale, in cui ci sarà un punto
               seguito da una oppure più cifre
            9) il carattere j 
         */
        if (num.matches("-?\\d+(.\\d+)? [-+] \\d+(.\\d+)?j")) {
            String numbers[] = num.split(" ");

            real = Double.parseDouble(numbers[0]);

            String sign = numbers[1];

            //tramite il substring riusciamo ad escludere il carattere 'j'
            String stringImg = numbers[2].substring(0, numbers[2].length() - 1);

            if (sign.equals("-")) {
                img = Double.parseDouble("-" + stringImg);
            } else {
                img = Double.parseDouble(stringImg);
            }
        } /*
        L'espressione regolare di seguito riportata permette di acccettare 
        stringhe nel formato "a", pertanto impone che il numero contenga
        in successione:
            1) uno oppure nessun segno meno
            2) una oppure più cifre
            3) una oppure nessuna parte decimale, in cui ci sarà un punto
               seguito da una oppure più cifre
         */ else if (num.matches("-?\\d+(.\\d+)?")) {
            real = Double.parseDouble(num);
        } /*
        L'espressione regolare di seguito riportata permette di acccettare 
        stringhe nel formato "bj", pertanto impone che il numero contenga
        in successione:
            1) uno oppure nessun segno meno
            2) una oppure più cifre
            3) una oppure nessuna parte decimale, in cui ci sarà un punto
               seguito da una oppure più cifre
            4) il carattere j 
         */ else if (num.matches("-?\\d+(.\\d+)?j")) {

            String stringImg = num.substring(0, num.length() - 1);

            img = Double.parseDouble(stringImg);

        } else {
            return null;
        }

        return new ComplexNum(real, img);
    }

}
