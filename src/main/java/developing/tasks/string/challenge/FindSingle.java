package developing.tasks.string.challenge;

//Write a function:
//class Solution { public int solution(int[] A); }
//that, given a non-empty array A of N integers, returns the first unique number in A.
// The function should return −1 if there are no unique numbers in A.

public class FindSingle {
    public int solution(int[] A) {
        int count;

        for(int i = 0; i < A.length; i++) {
            count = 0;
            for(int j = 0; j < A.length; j++) {
                if(A[i] == A[j] && i != j)
                    count++;
            }
            if(count == 0)
                return A[i];
        }
        return -1;
    }


}
