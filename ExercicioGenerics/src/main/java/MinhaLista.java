import java.util.ArrayList;
import java.util.List;

public class MinhaLista<T, U> {
    private final List<T> elementos = new ArrayList<>();;

    /* Nesse caso a array vai ser final para não correr o risco de deletarem tudo instanciando uma nova ArrayList.
    public MinhaLista() {
        this.elementos = new ArrayList<>();
    }*/

    public void adicionar(T elemento) {
        this.elementos.add(elemento);
    }

    public T obter(int indice) {
        if (indice >= 0 && indice < this.elementos.size()) {
            return this.elementos.get(indice);
        } else {
            return null;
        }
    }

    public int indice(U identificador) {
        for (int i = 0; i < this.elementos.size(); i++) {
            if (this.elementos.get(i) instanceof Pessoa) {
                Pessoa pessoa = (Pessoa) this.elementos.get(i);
                Long l =(Long) pessoa.id();
                if (l.equals(identificador)) {
                    return i;
                }
            }
        }
        return -1;
    }

    public boolean contem(T elemento) {
        return this.elementos.contains(elemento);
    }

    public static void main(String[] args) {
        MinhaLista<Pessoa, Long> listaDeNomes = new MinhaLista<>();

        var jorge = new Pessoa(1, "jorge");
        listaDeNomes.adicionar(jorge);

        var maria = new Pessoa(2, "maria");
        listaDeNomes.adicionar(maria);

        var jess = new Pessoa(3, "jess");
        listaDeNomes.adicionar(jess);

        System.out.println("Elemento na posição 2: " + listaDeNomes.obter(2));
        System.out.println("A lista contém a pessoa maria? " + listaDeNomes.contem(maria));
        System.out.println("Qual a posição do elemento de ID 3? " + listaDeNomes.indice(3L));
    }
}

