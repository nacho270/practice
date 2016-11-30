package otros2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SuppressWarnings("unused")
public class Recursividad {

    private static int suma = 0;
    private static int cont = 0;

    public static interface Node {
        int getValue();

        List<Node> getChildren();
    }

    public static void sumaNodoConFor(Node node) {
        suma += node.getValue();
        for (final Node child : node.getChildren()) {
            sumaNodoConFor(child);
        }
    }

    public static Map<Integer, List<Node>> getLevelsMap(Node root) {
        return innerGetLevels(root, 0, new HashMap<Integer, List<Node>>());
    }

    private static Map<Integer, List<Node>> innerGetLevels(Node node, int level, Map<Integer, List<Node>> hashMap) {
        if (hashMap.get(level) == null) {
            hashMap.put(level, new ArrayList<Node>());
        }
        hashMap.get(level).add(node);
        return getChildrenLevel(node.getChildren(), level + 1, 0, hashMap);
    }

    private static Map<Integer, List<Node>> getChildrenLevel(List<Node> children, int level, int index,
                    Map<Integer, List<Node>> hashMap) {
        if (children == null || children.isEmpty() || index >= children.size()) {
            return hashMap;
        }
        hashMap = innerGetLevels(children.get(index), level, hashMap);
        return getChildrenLevel(children, level, index + 1, hashMap);
    }

    public static double promedio(List<Integer> lista) {
        suma = suma(lista, cont);
        return suma / cont;
    }

    private static int suma(Node nodo) {
        System.out.println(nodo.getValue());
        return nodo.getValue() + sumaHijos(nodo.getChildren(), 0);
    }

    private static int sumaHijos(List<Node> children, int index) {
        if (children == null || children.isEmpty()) {
            return 0;
        }
        return index < children.size() ? suma(children.get(index++)) + sumaHijos(children, index) : 0;
    }

    public static int suma(List<Integer> lista, int index) {
        return cont < lista.size() ? lista.get(cont++) + suma(lista, cont) : 0;
    }

    public static int findMax(List<Integer> lista) {
        return findMax2(lista, 0, Integer.MIN_VALUE);
    }

    private static int findMax2(List<Integer> lista, int index, int tempMaxValue) {
        final int value = lista.get(index++);
        return index < lista.size() ? findMax2(lista, index, Math.max(tempMaxValue, value)) : tempMaxValue;
    }

    public static int findTreeHeight(Node root) {
        return 1 + findTreeHeightChildren(root.getChildren(), 0, Integer.MIN_VALUE);
    }

    private static int findTreeHeightChildren(List<Node> children, int index, int tempMaxValue) {
        if (children == null || children.isEmpty()) {
            return 0;
        }
        if (index < children.size()) {
            return findTreeHeightChildren(children, index + 1,
                            Math.max(tempMaxValue, findTreeHeight(children.get(index))));
        }
        return tempMaxValue;
    }

    public static int fibonacci(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1 || n == 2) {
            return 1;
        }
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    public static int factorial(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        return n * factorial(n - 1);
    }

    public static int powerN(int base, int n) {
        if (n == 0) {
            return 1;
        }
        if (n == 1) {
            return base;
        }
        return (n % 2 == 0 ? 1 : base) * powerN(base * base, n / 2);
    }

    public static int pow2(int base, int n) {
        if (n == 0) {
            return 1;
        }
        if (n == 1) {
            return base;
        }
        return base * powerN(base, n - 1);
    }

    public static int countPairs(String str) {
        if (str.length() < 3) {
            return 0;
        }
        return (str.charAt(0) == str.charAt(2) ? 1 : 0) + countPairs(str.substring(1, str.length()));
    }

    public static int bunnyEars(int bunnies) {
        if (bunnies == 0) {
            return 0;
        }
        return 2 + bunnyEars(bunnies - 1);
    }

    public static int bunnyEars2(int bunnies) {
        if (bunnies == 0) {
            return 0;
        }
        return (bunnies % 2 == 0 ? 3 : 2) + bunnyEars2(bunnies - 1);
    }

    /*
     * Given a non-negative int n, return the sum of its digits recursively (no
     * loops). Note that mod (%) by 10 yields the rightmost digit (126 % 10 is
     * 6), while divide (/) by 10 removes the rightmost digit (126 / 10 is 12).
     *
     * sumDigits(126) => 9 sumDigits(49) => 13 sumDigits(12) => 3
     */
    public static int sumDigits(int n) {
        if (n < 10) {
            return n;
        }
        return n % 10 + sumDigits(n / 10);
    }

    /*
     * We have triangle made of blocks. The topmost row has 1 block, the next
     * row down has 2 blocks, the next row has 3 blocks, and so on. Compute
     * recursively (no loops or multiplication) the total number of blocks in
     * such a triangle with the given number of rows.
     *
     * triangle(0) => 0 triangle(1) => 1 triangle(2) => 3
     */
    public static int triangle(int rows) {
        if (rows == 0 || rows == 1) {
            return rows;
        }
        return rows + triangle(rows - 1);
    }

    public static int count7(int n) {
        if (n < 10) {
            return n == 7 ? 1 : 0;
        }
        return (n % 10 == 7 ? 1 : 0) + count7(n / 10);
    }

    public static int count8(int n) {
        if (n < 10) {
            return n == 8 ? 1 : 0;
        }
        return (n % 10 == 8 ? (n / 10) % 10 == 8 ? 2 : 1 : 0) + count8(n / 10);
    }

    public static int countX(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }
        if (str.length() == 1) {
            return str.charAt(0) == 'x' ? 1 : 0;
        }
        return (str.charAt(0) == 'x' ? 1 : 0) + countX(str.substring(1, str.length()));
    }

    public static int countHi(String str) {
        if (str == null || str.length() < 2) {
            return 0;
        }
        if (str.length() == 2) {
            return str.equals("hi") ? 1 : 0;
        }
        return (str.substring(0, 2).equals("hi") ? 1 : 0) + countHi(str.substring(1, str.length()));
    }

    public static String changeXY(String str) {
        if (str == null || str.length() == 0) {
            return "";
        }
        if (str.length() == 1) {
            return str.charAt(0) == 'x' ? "y" : str;
        }
        return (str.charAt(0) == 'x' ? "y" : str.charAt(0)) + changeXY(str.substring(1));
    }

    public static String changePi(String str) {
        if (str == null || str.length() < 2) {
            return str;
        }
        if (str.length() == 2) {
            return str.equals("pi") ? "3.14" : str;
        }
        if (str.substring(0, 2).equals("pi")) {
            return "3.14" + changePi(str.substring(2, str.length()));
        } else {
            return str.charAt(0) + changePi(str.substring(1, str.length()));
        }
    }

    public static String noX(String str) {
        if (str == null || str.length() == 0) {
            return "";
        }
        return (str.charAt(0) == 'x' ? "" : str.charAt(0)) + noX(str.substring(1));
    }

    public static boolean array6(int[] nums, int index) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        if (nums.length == 1 && nums[0] == 6) {
            return true;
        }
        final int[] dest = new int[nums.length - 1];
        for (int i = 1; i < nums.length; i++) {
            dest[i - 1] = nums[i];
        }
        return nums[0] == 6 || array6(dest, index + 1);
    }

    public static int array11(int[] nums, int index) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1 && nums[0] == 11) {
            return 1;
        }
        final int[] dest = new int[nums.length - 1];
        for (int i = 1; i < nums.length; i++) {
            dest[i - 1] = nums[i];
        }
        return (nums[0] == 11 ? 1 : 0) + array11(dest, index + 1);
    }

    public static boolean array220(int[] nums, int index) {
        if (nums == null || nums.length < 2) {
            return false;
        }
        if (index >= nums.length) {
            return false;
        }
        final int num = nums[index];
        for (final int i = index; i < nums.length - 1;) {
            return nums[i + 1] == num * 10 || array220(nums, index + 1);
        }
        return false;
    }

    public static String allStar(String str) {
        if (str == null || str.length() == 0) {
            return "";
        }
        return str.charAt(0) + (str.length() > 1 ? "*" : "") + allStar(str.substring(1));
    }

    public static String pairStar(String str) {
        if (str == null) {
            return "";
        }
        if (str.length() < 2) {
            return str;
        }
        return str.charAt(0) + (str.charAt(0) == str.charAt(1) ? "*" : "") + pairStar(str.substring(1));
    }

    public static String endX(String str) {
        if (str == null) {
            return "";
        }
        if (str.length() < 2) {
            return str;
        }
        return str.charAt(0) == 'x' ? endX(str.substring(1)) + "x" : str.charAt(0) + endX(str.substring(1));
    }

    public static boolean lucky13(int[] nums) {
        for (final int num : nums) {
            if (num == 1 || num == 3) {
                return false;
            }
        }
        return true;
    }

    public static class TreeNode implements Node {

        public int value;
        public List<Node> children;

        public TreeNode() {
            children = new ArrayList<>();
        }

        @Override
        public int getValue() {
            return value;
        }

        @Override
        public List<Node> getChildren() {
            return children;
        }

        @Override
        public String toString() {
            return "" + value;
        }
    }

    private abstract static class Nodo2 {
    }

    private static class Nodo2Bifurcacion extends Nodo2 {
        public Nodo2 left;
        public Nodo2 right;
    }

    private static class Nodo2Leaf extends Nodo2 {
        public int value;
    }

    public static int findMin(Nodo2 nodo) {
        return findMinInternal(nodo, Integer.MAX_VALUE);
    }

    private static int findMinInternal(Nodo2 nodo, int minValue) {
        if (nodo instanceof Nodo2Leaf) {
            return ((Nodo2Leaf) nodo).value < minValue ? ((Nodo2Leaf) nodo).value : minValue;
        }
        final Nodo2Bifurcacion nBif = (Nodo2Bifurcacion) nodo;
        final int minR = findMinInternal(nBif.right, minValue);
        final int minL = findMinInternal(nBif.left, minValue);
        return Math.min(minR, minL);
    }

    private static final char[] HEX_CHARS = new char[] { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B',
                    'C', 'D', 'E', 'F' };

    private static String toHex(final String dec) {
        final int intValue = Integer.valueOf(dec);
        if (intValue < 16) {
            return "0x" + String.valueOf(HEX_CHARS[intValue % 16]);
        }
        return toHex(String.valueOf(intValue / 16)) + String.valueOf(HEX_CHARS[intValue % 16]);
    }

    public static void main(String[] args) {
        // System.out.println(promedio(Arrays.asList(1,2,3,4,5,6,7)));
        // System.out.println(countPairs("AxAxAxA"));
        // System.out.println(factorial(4));
        // System.out.println(fibonacci(8));
        // System.out.println(powerN(4, 5));
        // System.out.println(bunnyEars2(2));
        // System.out.println(sumDigits(5));
        // System.out.println(triangle(0));
        // System.out.println(count7(777));
        // System.out.println(count8(8818));
        // System.out.println(countX("xXxx"));
        // System.out.println(countHi("xhixhix"));
        // System.out.println(changeXY("codex"));
        // System.out.println(changePi("pipi"));
        // System.out.println(noX("x"));
        // System.out.println(array6(new int[]{2,5,6}, 0));
        // System.out.println(array11(new int[]{1,2,11}, 0) );
        // System.out.println(array220(new int[]{3}, 0));
        // System.out.println(allStar("hola"));
        // System.out.println(pairStar("xxyy"));
        // System.out.println(endX("xhixhix"));
        // System.out.println(lucky13(new int[]{0, 2, 3}));

        // root
        final TreeNode tn1 = new TreeNode();
        tn1.value = 1;

        // 2 nivel
        final TreeNode tn2 = new TreeNode();
        tn2.value = 22;

        final TreeNode tn3 = new TreeNode();
        tn3.value = 23;

        final TreeNode tn4 = new TreeNode();
        tn4.value = 24;

        // 3 nivel
        final TreeNode tn5 = new TreeNode();
        tn5.value = 35;

        final TreeNode tn6 = new TreeNode();
        tn6.value = 36;

        final TreeNode tn7 = new TreeNode();
        tn7.value = 37;

        // 4 nivel
        final TreeNode tn8 = new TreeNode();
        tn8.value = 38;

        final TreeNode tn9 = new TreeNode();
        tn9.value = 39;

        // 5 nivel
        final TreeNode tn10 = new TreeNode();
        tn10.value = 40;

        // 6 nivel
        final TreeNode tn11 = new TreeNode();
        tn11.value = 41;

        tn10.getChildren().add(tn11);

        tn9.getChildren().add(tn10);

        tn7.getChildren().add(tn8);
        tn6.getChildren().add(tn9);

        tn4.getChildren().add(tn5);
        tn3.getChildren().add(tn6);
        tn2.getChildren().add(tn7);

        tn1.getChildren().add(tn2);
        tn1.getChildren().add(tn3);
        tn1.getChildren().add(tn4);

        // System.out.println(findTreeHeight(tn1));
        // System.out.println(getLevelsMap(tn1));

        // int suma2 = suma(tn1);
        // System.out.println("===");
        // System.out.println(suma2);
        // average(tn1);
        // System.out.println(suma);

        // Map<Integer, List<Node>> levelsMap = getLevelsMap(tn1);
        // for(Integer i : levelsMap.keySet()){
        // System.out.println(i);
        // for(Node n : levelsMap.get(i)){
        // System.out.println("\t" + n);
        // }
        // }

        // Nodo2Bifurcacion n2Root = new Nodo2Bifurcacion();
        //
        // Nodo2Bifurcacion n2L11 = new Nodo2Bifurcacion();
        // Nodo2Leaf n2ValueL111 = new Nodo2Leaf(5);
        // Nodo2Leaf n2ValueL112 = new Nodo2Leaf(3);
        // n2L11.left = n2ValueL111;
        // n2L11.right = n2ValueL112;
        //
        // Nodo2Bifurcacion n2L12 = new Nodo2Bifurcacion();
        // Nodo2Leaf n2ValueL211 = new Nodo2Leaf(7);
        // Nodo2Leaf n2ValueL212 = new Nodo2Leaf(9);
        // n2L12.left=n2ValueL211;
        // n2L12.right=n2ValueL212;
        //
        // n2Root.left = n2L11;
        // n2Root.right = n2L12;
        // System.out.println(findMin(n2Root));
        // List<Integer> lista = Arrays.asList(1,2,3,5,8,4,5,4,85,488,85,65);
        // System.out.println(findMax(lista));
        System.out.println(toHex("4095"));
    }

}
