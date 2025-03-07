package aula3.recursao;

public class Exer1 {
    //Crie um método recursivo que receba um valor inteiro decimal e retorne uma
    //String com o valor correspondente em binário

    public static String converteDecimal(int decimal) {
    	String bin = "";
        if(decimal < 2) {
        	bin = String.valueOf(decimal);
            return bin;
        } else {
        	bin = String.valueOf(decimal % 2);
        	
        }
        return converteDecimal(decimal / 2) + bin;
    }
    
    public static void main(String[] args) {
    	int decimal = 255;
    	
    	System.out.println(converteDecimal(decimal));
    }

}
