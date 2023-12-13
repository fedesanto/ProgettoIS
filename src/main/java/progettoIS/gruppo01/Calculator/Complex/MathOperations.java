package progettoIS.gruppo01.Calculator.Complex;

public class MathOperations {
    private static final double ROUND_CONSTANT = 1000.0;
    /*
    Metodo che gestisce la somma tra numeri complessi.
    Il numero complesso risultato presenta come parte reale la somma tra
    la parte reale del primo numero complesso e la parte reale del secondo,
    invece, come parte immaginaria la somma tra la parte immaginaria del primo 
    numero complesso e la parte immaginaria del secondo
    
        Input:
            - num1, primo numero complesso
            - num2, secondo numero complesso
        Output:
            - numero complesso risultante dalla somma
     */
    public static ComplexNum somma(ComplexNum num1, ComplexNum num2) {
        double sommaRealPart;
        double sommaImgPart;

        sommaRealPart = num1.getRealPart() + num2.getRealPart();

        sommaImgPart = num1.getImgPart() + num2.getImgPart();

        return new ComplexNum(sommaRealPart, sommaImgPart);
    }

    /*
    Metodo che gestisce la sottrazione tra numeri complessi.
    Il numero complesso risultato presenta come parte reale la sottrazione tra
    la parte reale del primo numero complesso e la parte reale del secondo,
    invece, come parte immaginaria la sottrazione tra la parte immaginaria del 
    primo numero complesso e la parte immaginaria del secondo
    
        Input:
            - num1, primo numero complesso
            - num2, secondo numero complesso
        Output:
            - numero complesso risultante dalla sottrazione
     */
    public static ComplexNum sottrazione(ComplexNum num1, ComplexNum num2) {
        double sottrRealPart;
        double sottrImgPart;

        sottrRealPart = num1.getRealPart() - num2.getRealPart();

        sottrImgPart = num1.getImgPart() - num2.getImgPart();

        return new ComplexNum(sottrRealPart, sottrImgPart);
    }

    /*
    Metodo che gestisce la divisione tra numeri complessi.
    Intendendo il primo numero complesso come "a + bj" e il secondo come 
    "c + dj", dove a,b,c,d sono numeri reali, la divisione è data dalla formula:
    (ac + bd) / (c^2 + d^2) + j * (bc - ad) / (c^2 + d^2)
    
        Input:
            - num1, primo numero complesso
            - num2, secondo numero complesso
        Output:
            - numero complesso risultante dalla divisione oppure null se num2 
              è uguale a 0
     */
    public static ComplexNum divisione(ComplexNum num1, ComplexNum num2) {

        if (num2.getRealPart() == 0 && num2.getImgPart() == 0) {
            return null;
        }

        double a = num1.getRealPart();
        double b = num1.getImgPart();
        double c = num2.getRealPart();
        double d = num2.getImgPart();

        double divRealPart;
        double divImgPart;
        double denominatore = c * c + d * d;

        divRealPart = (a * c + b * d) / denominatore;

        divImgPart = (b * c - a * d) / denominatore;

        return new ComplexNum(Math.round(divRealPart * ROUND_CONSTANT) / ROUND_CONSTANT, Math.round(divImgPart * ROUND_CONSTANT) / ROUND_CONSTANT);
        // Math.round(num * ROUND_CONSTANT) / ROUND_CONSTANT permette di arrotondare un double alla terza cifra decimale
    }

    /*
    Metodo che gestisce la moltiplicazione tra numeri complessi.
    Intendendo il primo numero complesso come "a + bj" e il secondo come 
    "c + dj", dove a,b,c,d sono numeri reali, la moltiplicazione è data dalla formula:
     (ac - bd) + j * (ad + bc)
    
        Input:
            - num1, primo numero complesso
            - num2, secondo numero complesso
        Output:
            - numero complesso risultante dalla moltiplicazione
     */
    public static ComplexNum moltiplicazione(ComplexNum num1, ComplexNum num2) {

        double a = num1.getRealPart();
        double b = num1.getImgPart();
        double c = num2.getRealPart();
        double d = num2.getImgPart();

        double mulRealPart;
        double mulImgPart;

        mulRealPart = a * c - b * d;

        mulImgPart = a * d + b * c;

        return new ComplexNum(Math.round(mulRealPart * ROUND_CONSTANT) / ROUND_CONSTANT, Math.round(mulImgPart * ROUND_CONSTANT) / ROUND_CONSTANT);
        // Math.round(num * ROUND_CONSTANT) / ROUND_CONSTANT permette di arrotondare un double alla terza cifra decimale
    }

    /*
    Metodo che gestisce la radice quadrata di un numero complesso.
    Per un numero complesso z = a + bj, dove a e b sono numeri reali
    e con modulo espresso come |z|, la radice quadrata è data dalla formula:
     sqrt((|z| + a) / 2) + j * (sign(b) * sqrt((|z| - a) / 2))
    
        Input:
            - num, numero complesso su cui effettuare la radice quadrata
        Output:
            - numero complesso risultante dalla radice quadrata (restituisce
              solo il risultato della radice con il segno +)
     */
    public static ComplexNum sqrt(ComplexNum num) {

        double sqrtRealPart;
        double sqrtImgPart;

        double a = num.getRealPart();
        double b = num.getImgPart();

        double module = Math.sqrt(a * a + b * b);

        sqrtRealPart = Math.sqrt((module + a) / 2.0);
        sqrtImgPart = Math.sqrt((module - a) / 2.0) * (b == 0 ? 1.0 : Math.signum(b));

        return new ComplexNum(Math.round(sqrtRealPart * ROUND_CONSTANT) / ROUND_CONSTANT, Math.round(sqrtImgPart * ROUND_CONSTANT) / ROUND_CONSTANT);
        // Math.round(num * ROUND_CONSTANT) / ROUND_CONSTANT permette di arrotondare un double alla terza cifra decimale
    }

    /*
    Metodo che gestisce l'inversione di segno di un numero complesso.
    
        Input:
            - num, numero complesso su cui effettuare l'inversione di segno
        Output:
            - numero complesso risultante dall'inversione di segno
     */
    public static ComplexNum invSegno(ComplexNum num) {

        double invrealPart = -num.getRealPart();
        double invImgPart = -num.getImgPart();

        return new ComplexNum(invrealPart, invImgPart);
    }

}
