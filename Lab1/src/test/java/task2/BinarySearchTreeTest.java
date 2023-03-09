package test.java.task2;

import main.java.task1.ArcTanFunction;
import main.java.task2.BinarySearchTree;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.HashSet;
import java.util.stream.Collectors;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class BinarySearchTreeTest {
    private BinarySearchTree bst;
    HashSet<Integer> vals;
    private int maxV;
    private int minV;

    @BeforeAll
    public void initBST(){
        bst = new BinarySearchTree();
        Integer[] array = {50, 30, 20, 40, 70, 60, 80};
        this.vals = new HashSet<>(Arrays.stream(array).collect(Collectors.toSet())) ;

        maxV = array[0];
        minV = array[0];
        for(int i: array){
            bst.insert(i);
            maxV = Math.max(maxV, i);
            minV = Math.min(minV, i);
        }
    }

    @ParameterizedTest
    @ValueSource(ints = {1,2,3,4,5})
    public void sizeAfterInsertTest(int value) {
        bst.insert(value);
        vals.add(value);
        System.out.println(value + " " +  vals.size());
        Assertions.assertEquals(vals.size(), bst.getSz(), "Incorrect size of tree after insert");
    }

    @ParameterizedTest
    @ValueSource(ints = {20,40})
    public void sizeAfterRemovalTest(int value) {
        bst.deleteKey(value);
        vals.remove(value);
        Assertions.assertEquals(vals.size(), bst.getSz(), "Incorrect size of tree after insert");
    }

    @ParameterizedTest
    @CsvSource({
        "1, FALSE",
        "2, FALSE",
        "-20, FALSE",
        "20, TRUE",
        "30, TRUE",
        "80, TRUE",
    })
    public void elementPresenceTest(int value, boolean result) {
        Assertions.assertEquals(result, bst.hasvalue(value), "Incorrect result of BinarySearchTree.hasValue(key) function");
    }


    @ParameterizedTest
    @ValueSource(ints = {20,40,60,100,200,300})
    public void maxValueTest(int value) {
        bst.insert(value);
        vals.add(value);
        maxV = Math.max(maxV, value);
        minV = Math.min(minV, value);
        Assertions.assertEquals(maxV, bst.maxvalue(), "Incorrect max value");
    }

    @ParameterizedTest
    @ValueSource(ints = {20,40,60,100,200,300})
    public void minValueTest(int value) {
        bst.insert(value);
        vals.add(value);
        maxV = Math.max(maxV, value);
        minV = Math.min(minV, value);
        Assertions.assertEquals(minV, bst.minvalue(), "Incorrect min value");
    }
}
