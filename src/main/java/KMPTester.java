public class KMPTester {
    public static void main(String[] args) {
        char[] target = "sabasababa".toCharArray();
        char[] query = "abab".toCharArray();
        System.out.println(KMP.indexOf(query, target));         // 5

        char[] target1 = "sino se los digo no se si es nocivo".toCharArray();
        char[] query1 = "no".toCharArray();
        System.out.println(KMP.findAll(query1,target1));        // [2, 17, 29]

        char[] target2 = "sino se los digo no se si es nocivo".toCharArray();
        char[] query2 = "ni".toCharArray();
        System.out.println(KMP.findAll(query2,target2));        // []

        char[] target3 = "aabaaab".toCharArray();
        char[] query3 = "aa".toCharArray();
        System.out.println(KMP.findAll(query3,target3));        // [0, 3, 4]

        char[] target4 = "aaabaaaaab".toCharArray();
        char[] query4 = "aaa".toCharArray();
        System.out.println(KMP.findAll(query4,target4));        //[0, 4, 5, 6]

    }
}
