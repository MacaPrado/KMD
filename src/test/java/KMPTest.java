import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class KMPTest {

    @Test
    void indexOfOK(){
        System.out.println("IndexOf Test");
        Assertions.assertEquals(5, KMP.indexOf("abab".toCharArray(), "sabasababa".toCharArray()));
        Assertions.assertEquals(1, KMP.indexOf("ab".toCharArray(), "sabasababa".toCharArray()));
        Assertions.assertEquals(0, KMP.indexOf("abra".toCharArray(), "abracadabra".toCharArray()));
        Assertions.assertEquals(7, KMP.indexOf("abras".toCharArray(), "abracadabras".toCharArray()));
    }

    @Test
    void findAllOk(){
        System.out.println("Find All Test");
        ArrayList<Integer> aux = new ArrayList<>();
        aux.add(2);
        aux.add(17);
        aux.add(29);    // aux = [2,17,29]
        Assertions.assertArrayEquals(aux.toArray(),KMP.findAll("no".toCharArray(), "sino se los digo no se si es nocivo".toCharArray()).toArray());
        aux.clear();   // aux = []
        Assertions.assertArrayEquals(aux.toArray(), KMP.findAll("ni".toCharArray(), "sino se los digo no se si es nocivo".toCharArray()).toArray());
        aux.add(0);
        aux.add(3);
        aux.add(4);     // aux = [0,3,4]
        Assertions.assertArrayEquals(aux.toArray(), KMP.findAll("aa".toCharArray(), "aabaaab".toCharArray()).toArray());
        aux.remove(1); //remove int 3
        aux.add(5);
        aux.add(6);     // aux = [0,4,5,6]
        Assertions.assertArrayEquals(aux.toArray(), KMP.findAll("aaa".toCharArray(), "aaabaaaaab".toCharArray()).toArray());
    }

    @Test
    void nextComputationOk(){
        int[] aux = {0,0,1};
        Assertions.assertArrayEquals(aux,KMP.nextComputation2("aba".toCharArray()));
        aux = new int[]{0, 0, 0, 0};
        Assertions.assertArrayEquals(aux,KMP.nextComputation2("xeee".toCharArray()));
        aux = new int[]{0, 0, 1, 2};
        Assertions.assertArrayEquals(aux,KMP.nextComputation2("bcbc".toCharArray()));
        aux = new int[]{0, 0, 0, 1, 0, 1, 0, 1, 2, 3, 4};
        Assertions.assertArrayEquals(aux,KMP.nextComputation2("abracadabra".toCharArray()));
    }

}
