package exercise;

import static org.assertj.core.api.Assertions.assertThat;
import java.util.List;
import java.util.ArrayList;
import org.junit.jupiter.api.Test;

class AppTest {

    @Test
    void testTake() {
        // BEGIN
        List<Integer> listForTest = new ArrayList<>();
        listForTest.add(1);
        listForTest.add(2);
        listForTest.add(3);
        listForTest.add(4);
        listForTest.add(5);
        List<Integer> emptyList = new ArrayList<>();

        assertThat(Implementations.right(listForTest, 3)).hasSize(3);
        assertThat(Implementations.right(listForTest, 0)).hasSize(0);
        assertThat(Implementations.right(listForTest, 8)).hasSize(5);
        assertThat(Implementations.right(emptyList, 3)).isEmpty();

        assertThat(Implementations.wrong1(listForTest, 3)).hasSize(3);
        assertThat(Implementations.wrong1(listForTest, 0)).hasSize(0);
        assertThat(Implementations.wrong1(listForTest, 8)).hasSize(5);
        assertThat(Implementations.wrong1(emptyList, 3)).isEmpty();

        assertThat(Implementations.wrong2(listForTest, 3)).hasSize(3);
        assertThat(Implementations.wrong2(listForTest, 0)).hasSize(0);
        assertThat(Implementations.wrong2(listForTest, 8)).hasSize(5);
        assertThat(Implementations.wrong2(emptyList, 3)).isEmpty();

        assertThat(Implementations.wrong3(listForTest, 3)).hasSize(3);
        assertThat(Implementations.wrong3(listForTest, 0)).hasSize(0);
        assertThat(Implementations.wrong3(listForTest, 8)).hasSize(5);
        assertThat(Implementations.wrong3(emptyList, 3)).isEmpty();
        // END
    }
}
