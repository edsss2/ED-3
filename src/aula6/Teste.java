package aula6;

public class Teste {
    
    public static void main(String[] args) {
        ListaLigada minhaLista = new ListaLigada();
        minhaLista.add("A");
        minhaLista.add("B");
        minhaLista.add("C");

        for(int i = 0; i < minhaLista.getTamanho(); i++) {
            System.out.println(minhaLista.get(i));
        }
    }
}
