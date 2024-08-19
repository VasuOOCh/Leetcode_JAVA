import java.util.ArrayList;
import java.util.Arrays;

public class UniqueCharSubstrings {
    public static void main(String[] args) {
//        System.out.println(uniqueLetterString("ABC"));
//        System.out.println(uniqueChar("AA"));
        System.out.println(subSeqComplex("", "ABC").toString());
    }

    static int uniqueLetterString(String s) {
        int count = 0;
        ArrayList<String> subs = new ArrayList<String>();
        subSeq("",s,subs);
        System.out.println(subs.size());
        for (int i = 0; i < subs.size(); i++) {
            count += uniqueChar(subs.get(i));
        }

        return count;

    }

    static int uniqueChar(String s) {
        int c =0;
        StringBuilder temp = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if(temp.indexOf(String.valueOf(s.charAt(i))) < 0) {
                c++;
                temp.append(s.charAt(i));
            }
        }
        return c;
    }

    static void subSeq(String p,String un, ArrayList<String> sub) {

        if(un.isEmpty()) {
            sub.add(p);
            System.out.println(Arrays.toString(sub.toArray()));
            return;
        }

        char ch = un.charAt(0);
        subSeq(p + ch, un.substring(1),sub);
        subSeq(p,un.substring(1),sub);

    }

    static ArrayList<String> subSeqComplex(String p,String un) {
        ArrayList<String> ans = new ArrayList<String>(); //init an empty arrayList

        // base condn
        if(un.isEmpty()) {
            return new ArrayList<>(Arrays.asList(p));
        }

        char ch = un.charAt(0);
        ans.addAll(subSeqComplex(p + ch, un.substring(1)));
        ans.addAll(subSeqComplex(p, un.substring(1)));

        return ans;
    }


}
