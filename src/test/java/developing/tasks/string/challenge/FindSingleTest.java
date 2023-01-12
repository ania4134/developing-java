package developing.tasks.string.challenge;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class FindSingleTest {

    @Test
    public void findSingleTest() {
        //given
        int[] A = {4, 6, 9, 9, 4, 1, 6};
        FindSingle findSingle = new FindSingle();

        //when
        int result = findSingle.solution(A);

        //then
        Assertions.assertEquals(1, result);
        Assertions.assertNotEquals(4, result);
    }
}