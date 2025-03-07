package aula3.filas;


import java.util.ArrayList;
import java.util.List;

public class Fila {

    List<Pessoa> listaPrioritaria = new ArrayList<>();
    List<Pessoa> listaNormal = new ArrayList<>();

    public void add (Pessoa pessoa) {
        if (pessoa.getIdade() >= 60) {
            listaPrioritaria.add(pessoa);
        } else {
            listaNormal.add(pessoa);
        }
    }

    public Pessoa remover () {
        if (!listaPrioritaria.isEmpty()) {
            Pessoa pessoa = listaPrioritaria.get(0);
            listaPrioritaria.remove(0);
            return pessoa;
        } else {
            Pessoa pessoa = listaNormal.get(0);
            listaNormal.remove(0);
            return pessoa;
        }
    }

    public int tamanho (){
        return listaPrioritaria.size() + listaNormal.size();
    }

    public Pessoa exibir() {
        if (!listaPrioritaria.isEmpty()) {
            return listaPrioritaria.get(0);
        } else {
            return listaNormal.get(0);
        }
    }





}
