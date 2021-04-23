package Codility;

import Exercises.Arrays.CyclicRotation;
import Exercises.Arrays.Orderer;
import Exercises.BinaryGap.BinaryGap_v02;
import Exercises.Demo.Demo_Exercise_01;
import Exercises.FibonacciNumber.Ladder;
import Exercises.PrimeAndCompositiveNumbers.Flags;
import Exercises.PrimeAndCompositiveNumbers.Peaks;
import Exercises.StacksAndQueues.Brackets_v01;
import Exercises.StacksAndQueues.Brackets_v02;
import Exercises.StacksAndQueues.Nesting;
import Exercises.TapeEquilibrium.Fish;
import Exercises.TapeEquilibrium.TapeEquilibrium;
import Exercises.Solution_02;
import Exercises.*;
import org.junit.Assert;
import org.junit.Test;
import Exercises.BinaryGap.BinaryGap_v01;

import static org.junit.Assert.assertEquals;

public class Tests {

    @Test
    public void BinaryGap_v01() {
        BinaryGap_v01 obj = new BinaryGap_v01();
        int ret = obj.solution(10);

        Assert.assertNotNull(ret);
    }

    @Test
    public void BinaryGap_v02() {
        BinaryGap_v02 obj = new BinaryGap_v02();

        assertEquals(obj.solution(9), 2);
        assertEquals(obj.solution(529), 4);
        assertEquals(obj.solution(20), 1);
        assertEquals(obj.solution(15), 0);
    }

    @Test
    public void Demo_Exercise_01() {
        Demo_Exercise_01 obj = new Demo_Exercise_01();

        int[] A = {1, 3, 6, 4, 1, 2};
        int[] B = {1, 2, 3};
        int[] C = {-1, -3};

        assertEquals(obj.solution(A), 5);
        assertEquals(obj.solution(B), 4);
        assertEquals(obj.solution(C), 1);
    }

    @Test
    public void TapeEquilibrium() {
        TapeEquilibrium obj = new TapeEquilibrium();

        int[] A = {3, 1, 2, 4, 3};

        assertEquals(obj.solution(A), 1);
    }

    @Test
    public void Nesting() {
        Nesting obj = new Nesting();

        String CASE_01 = "(()(())())";
        String CASE_02 = "())";
        String CASE_03 = "(";
        String CASE_04 = ")";
        String CASE_05 = "";
        String CASE_06 = "())(";

        assertEquals(obj.solution(CASE_01), 1);
        assertEquals(obj.solution(CASE_02), 0);
        assertEquals(obj.solution(CASE_03), 0);
        assertEquals(obj.solution(CASE_04), 0);
        assertEquals(obj.solution(CASE_05), 1);
        assertEquals(obj.solution(CASE_06), 0);
    }

    @Test
    public void Brackets_v01() {
        Brackets_v01 obj = new Brackets_v01();

        String CASE_01 = "(()(())())";
        String CASE_02 = "())";
        String CASE_03 = "(";
        String CASE_04 = ")";
        String CASE_05 = "";
        String CASE_06 = "())(";
        String CASE_07 = "{[()()]}";
        String CASE_08 = "([)()]";

        assertEquals(1, obj.solution(CASE_01));
        assertEquals(0, obj.solution(CASE_02));
        assertEquals(0, obj.solution(CASE_03));
        assertEquals(0, obj.solution(CASE_04));
        assertEquals(1, obj.solution(CASE_05));
        assertEquals(0, obj.solution(CASE_06));
        assertEquals(1, obj.solution(CASE_07));
    }

    @Test
    public void Brackets_v02() {
        Brackets_v02 obj = new Brackets_v02();

        String CASE_01 = "(()(())())";
        String CASE_02 = "())";
        String CASE_03 = "(";
        String CASE_04 = ")";
        String CASE_05 = "";
        String CASE_06 = "())(";
        String CASE_07 = "{[()()]}";
        String CASE_08 = "([)()]";
        String CASE_09 = "(**)";

        assertEquals(1, obj.solution(CASE_01));
        assertEquals(0, obj.solution(CASE_02));
        assertEquals(0, obj.solution(CASE_03));
        assertEquals(0, obj.solution(CASE_04));
        assertEquals(1, obj.solution(CASE_05));
        assertEquals(0, obj.solution(CASE_06));
        assertEquals(1, obj.solution(CASE_07));
        assertEquals(0, obj.solution(CASE_08));
        assertEquals(0, obj.solution(CASE_09));
    }

    @Test
    public void Fish() {
        Fish obj = new Fish();

        int[] CASE_01_A = {4, 3, 2, 1, 5};
        int[] CASE_01_B = {0, 1, 0, 0, 0};

        int[] CASE_02_A = {6, 5, 4, 3, 2, 1};
        int[] CASE_02_B = {1, 1, 0, 1, 0, 0};

        int[] CASE_03_A = {};
        int[] CASE_03_B = {};

        int[] CASE_04_A = {5};
        int[] CASE_04_B = {0};

        int[] CASE_05_A = {4, 3};
        int[] CASE_05_B = {0, 1};

        assertEquals(obj.solution(CASE_01_A, CASE_01_B), 2);
        assertEquals(obj.solution(CASE_02_A, CASE_02_B), 3);
        assertEquals(obj.solution(CASE_03_A, CASE_03_B), 0);
        assertEquals(obj.solution(CASE_04_A, CASE_04_B), 1);
        assertEquals(obj.solution(CASE_05_A, CASE_05_B), 2);
    }

    @Test
    public void CyclicRotation() {
        CyclicRotation obj = new CyclicRotation();

        int[] CASE_01_A = {3, 8, 9, 7, 6};
        int CASE_01_K = 3;

        obj.solution(CASE_01_A, CASE_01_K);
        obj.solution(CASE_01_A, 5);
        obj.solution(CASE_01_A, 8);
        obj.solution(CASE_01_A, 0);
        obj.solution(CASE_01_A, 1);
    }

    @Test
    public void Orderer() {
        Orderer obj = new Orderer();

        int[] CASE_01_A = {3, 8, 9, 7, 6};

        obj.solution(CASE_01_A);
    }

    @Test
    public void MaxDoubleSliceSum() {
        MaxDoubleSliceSum obj = new MaxDoubleSliceSum();

        int[] CASE_01_A = {3, 2, 6, -1, 4, 5, -1, 2};

        assertEquals(17, obj.solution(CASE_01_A));
    }

    @Test
    public void Flags() {
        Flags obj = new Flags();

        int[] CASE_01_A = {1, 5, 3, 4, 3, 4, 1, 2, 3, 4, 6, 2};

        assertEquals(3, obj.solution(CASE_01_A));
    }

    @Test
    public void Peaks() {
        Peaks obj = new Peaks();

        int[] CASE_01_A = {1, 2, 3, 4, 3, 4, 1, 2, 3, 4, 6, 2};

        assertEquals(3, obj.solution(CASE_01_A));
    }

    @Test
    public void CountNonDivisible() {
        CountNonDivisible obj = new CountNonDivisible();

        int[] CASE_01_A = {3, 1, 2, 3, 6};

        obj.solution(CASE_01_A);
    }

    @Test
    public void CountSemiprimes() {
        CountSemiprimes obj = new CountSemiprimes();

        int[] CASE_01_P = {1, 4, 16};
        int[] CASE_01_Q = {26, 10, 20};

        obj.solution(26, CASE_01_P, CASE_01_Q);
    }

    @Test
    public void CountSemiprimes_v02() {
        CountSemiprimes_v02 obj = new CountSemiprimes_v02();

        int[] CASE_01_P = {1, 4, 16};
        int[] CASE_01_Q = {26, 10, 20};

        obj.solution(26, CASE_01_P, CASE_01_Q);
    }

    @Test
    public void ChocolateByNumbers() {
        ChocolateByNumbers obj = new ChocolateByNumbers();

        assertEquals(5, obj.solution(10, 4));
        assertEquals(2, obj.solution(4, 10));
        assertEquals(1, obj.solution(1, 1));
    }

    @Test
    public void CommonPrimeDivisors() {
        CommonPrimeDivisors obj = new CommonPrimeDivisors();

        int[] CASE_01_A = {15, 10, 3};
        int[] CASE_01_B = {75, 30, 5};

        assertEquals(1, obj.solution(CASE_01_A, CASE_01_B));
    }

    @Test
    public void Ladder() {
        Ladder obj = new Ladder();

        int[] CASE_01_A = {4, 4, 5, 5, 1};
        int[] CASE_01_B = {3, 2, 4, 3, 1};

        int[] ret = obj.solution(CASE_01_A, CASE_01_B);
    }

    @Test
    public void Solution_01() {
        Solution_01 obj = new Solution_01();

        int[] CASE_A = {4, 2, 5, 8, 7, 3, 7};
        int[] CASE_B = {14, 21, 16, 35, 22};
        int[] CASE_C = {5, 5, 5, 5, 5, 5};
        int[] CASE_D = {4, 2};
        int[] CASE_E = {4, 1};
        int[] CASE_F = {4};

        int retA = obj.solution(CASE_A);
        int retB = obj.solution(CASE_B);
        int retC = obj.solution(CASE_C);
        int retD = obj.solution(CASE_D);
        int retE = obj.solution(CASE_E);
        int retF = obj.solution(CASE_F);
    }

    @Test
    public void Solution_02() {
        Solution_02 obj = new Solution_02();

        int[] CASE_01_P = {1, 4, 1};
        int[] CASE_01_S = {1, 5, 1};

        int[] CASE_02_P = {4, 4, 2, 4};
        int[] CASE_02_S = {5, 5, 2, 5};

        int[] CASE_03_P = {2, 3, 4, 2};
        int[] CASE_03_S = {2, 5, 7, 2};

        int[] CASE_04_P = {1, 1, 1};
        int[] CASE_04_S = {5, 5, 5};

        int ret01 = obj.solution(CASE_01_P, CASE_01_S);
        int ret02 = obj.solution(CASE_02_P, CASE_02_S);
        int ret03 = obj.solution(CASE_03_P, CASE_03_S);
        int ret04 = obj.solution(CASE_04_P, CASE_04_S);
    }

}
