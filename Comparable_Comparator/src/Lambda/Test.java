package Lambda;

public class Test {
    public static void main(String[] args) {

        System.out.println(removeDuplicates("123445"));
    }
    static String removeDuplicates(String s) {
        StringBuilder noDupes = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            String si = s.substring(i, i + 1);
            if (noDupes.indexOf(si) == -1) {
                noDupes.append(si);
            }
        }
        return noDupes.toString();
    }

}
