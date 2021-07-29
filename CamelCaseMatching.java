import java.util.*;


public class CamelCaseMatching {

    //Two pointer Approach
    //If both characters are matching increment both of them.
    //Else if the query pointer is captial it means it is invalid - Capital letter must match.
    //Else just move the query pointer.

    //TC: O(k A+B) where k is is number queries. A is query length and B is pattern length.
    //SC: O(1) not using any extra space.
    public List<Boolean> camelMatch(String[] queries, String pattern) {
        List<Boolean> result = new ArrayList();
        if (queries == null || queries.length == 0)
            return result;
        for (String query : queries) {
            result.add(isValid(query, pattern));
        }
        return result;
    }

    private boolean isValid(String query, String pattern) {

        int pointerOne = 0;
        int pointerTwo = 0;

        while (pointerOne < query.length()) {
            if (pointerTwo < pattern.length() && query.charAt(pointerOne) == pattern.charAt(pointerTwo)) {
                pointerOne++;
                pointerTwo++;
            } else if (Character.isUpperCase(query.charAt(pointerOne))) {
                return false;
            } else {
                pointerOne++;
            }
        }

        if (pointerTwo == pattern.length()) {
            return true;
        }
        return false;
    }
    
    public static void main(String[] args) {
        CamelCaseMatching camelCaseMatching = new CamelCaseMatching();
        List<Boolean> result = camelCaseMatching.camelMatch(new String[] {
            "FooBar","FooBarTest","FootBall","FrameBuffer","ForceFeedBack"
        }, "FoBa");
        System.out.println("The result: "+result);
    }
}