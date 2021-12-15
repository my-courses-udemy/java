
public class Char {

    public static void main(String args[]){
        
        char miCaracter = '!'; // podemos asignar un caracter simplemente por el teclado
        System.out.println("miCaracter = " + miCaracter);
        
        char varChar = '\u0021'; // podemos usar este formato unicode para imprimir caracteres
        System.out.println("varChar = " + varChar);
        
        char varCharDecimal = 33; // le asignamos un numero, y obtenemos un caracter porque esta definido como char
        System.out.println("varCharDecimal = " + varCharDecimal);
        
        
        
        var miCaracter1 = '!'; // podemos asignar un caracter simplemente por el teclado
        System.out.println("miCaracter = " + miCaracter1);
        
        var varChar1 = '\u0021'; // en var detecta que usamos u = valor unicode
        System.out.println("varChar = " + varChar1);
        
        var varCharDecimal1 = (char) 33; // en var el nro lo toma como int, debemos añadir (char)
        System.out.println("varCharDecimal = " + varCharDecimal1);
        
        int varEnteraSimbolo = '!'; // asigna su codigo decimal de unicode al entero
        System.out.println("varEnteraSimbolo = " + varEnteraSimbolo);
    
        int letraA = 'A'; // asigna el codigo asociado
        System.out.println("letraA = " + letraA);
        
    }
    
}
