package developing.tasks.string.challenge;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionTest {

    @Test
    public void solutionTest(){
        //given && when
        Solution solution = new Solution();
        int result = solution.solution("a");

        //then
        Assertions.assertEquals(-1, result);
    }
}
