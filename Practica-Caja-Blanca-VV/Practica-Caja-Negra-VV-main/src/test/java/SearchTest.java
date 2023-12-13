import static org.junit.jupiter.api.Assertions.*;
import com.bst.BST;
import com.bst.Node;
import com.exceptions.DepthException;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

/*
5 caminos Independientes:
    1. 1-2.A-3                  -> aux == null.
    2. 1-2.A-2.B-3              -> aux != null && enc == true. *1
    3. 1-2.A-2.B-4-5-2.A-2.B-3  -> aux != null && enc == false && content == auxContent
    4. 1-2.A-2.B-4-6-7-2.A-3    -> aux != null && enc == false && content < auxContent
    5. 1-2.A-2.B-4-6-8-2.A-3    -> aux != null && enc == false && content > auxContent

*1: Dado que enc se inicializa a false y el nodo 1 solo se visita una sola vez,
no es posible en la práctica seguir este camino. Sin embargo, estas aristas quedan probadas
en el camino 3, ya que dentro del if se establece enc == true.
 */
public class SearchTest {
    BST<Integer> bst;
    BST<Integer> bst1;
    @org.junit.jupiter.api.BeforeEach
    void setUp() throws DepthException {
        bst = new BST<>(33);
        bst1 = new BST<>();
    }

    @Test
    void searchPruebaEmptyBST()
    {
        Node<Integer> v = bst1.search(33);
        boolean obtenido = (v != null);
        assertFalse(obtenido);
    }
    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.CsvSource(value={
            "33, true",
            "23, false",
            "42, false"
    })
    void searchPruebaNotEmptyBST(int c, boolean esperado)
    {
        Node<Integer> v = bst.search(c);

        boolean obtenido = (v != null);

        assertEquals(esperado, obtenido);

    }
}
