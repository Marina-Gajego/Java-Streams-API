package entidade;
import java.util.Comparator;

public class ComparatorIdade implements Comparator<Oscar>{

    @Override
    public int compare(Oscar o1, Oscar o2) {
        return Integer.compare(o1.getIdade(), o2.getIdade());
    }
}
