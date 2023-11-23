package st2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.fail;

public class SimpleLinkedListUnitTest {
    static final int ITERATION_DEPTH = 100;
    Collection<String> testList;

    void initializeArbitraryList() {
        for (int i = 0; i < ITERATION_DEPTH; i++) {
            testList.add(Integer.toString(i));
        }
    }

    @BeforeEach
    void initializeEmptyList() {
        testList = new SimpleLinkedList<>();
    }

    @Nested
    class SizeFunctionTests {

        @Test
        void emptyListSize0() {
            assertThat(testList.size()).isEqualTo(0);
        }

        @Test
        void addIncreasesSize() {
            for (int i = 1; i < ITERATION_DEPTH; i++) {
                testList.add(Integer.toString(i));
                assertThat(testList.size()).isEqualTo(i);
            }
        }
    }

    @Nested
    class AddFunctionTests {

        @Test
        void addsElements() {
            for (int i = 0; i < ITERATION_DEPTH; i++) {
                String element = Integer.toString(i);
                testList.add(element);
                assertThat(testList).contains(element);
            }
        }

        @Test
        void acceptsNullValues() {
            testList.add(null);
            assertThat(testList).contains((String) null);
        }

        @Test
        void acceptsDoubleValues() {
            String element = "Test";
            testList.add(element);
            testList.add(element);
            assertThat(testList).containsExactly(element, element);
        }

        @Test
        void keepsOrder() {
            List<String> compareList = new ArrayList<>(ITERATION_DEPTH);
            for (int i = 0; i < ITERATION_DEPTH; i++) {
                String element = Integer.toString(i);
                testList.add(element);
                compareList.add(element);
            }
            assertThat(testList).containsSequence(compareList);
        }
    }

    @Nested
    class IteratorTests {

        @Nested
        class IteratorConstructorTests {

            @Test
            void iteratorStartsAtFirstElement() {
                initializeArbitraryList();
                assertThat(testList.iterator().next()).isEqualTo(Integer.toString(0));
            }
        }

        @Nested
        class HasNextFunctionTests {

            @Test
            void emptyListReturnsFalse() {
                assertThat(testList.iterator().hasNext()).isEqualTo(false);
            }

            @Test
            void returnsFalseAtEnd() {
                initializeArbitraryList();
                Iterator<String> iterator = testList.iterator();
                for (int i = 0; i < ITERATION_DEPTH; i++) {
                    iterator.next();
                }
                assertThat(iterator.hasNext()).isEqualTo(false);
            }

            @Test
            void returnsTrueWhenNextElementExists() {
                initializeArbitraryList();
                Iterator<String> iterator = testList.iterator();
                for (int i = 0; i < ITERATION_DEPTH; i++) {
                    assertThat(iterator.hasNext()).isTrue();
                    iterator.next();
                }
            }
        }

        @Nested
        class NextFunctionTests {

            @Test
            void emptyListThrowsNoSuchElementException() {
                try {
                    testList.iterator().next();
                    fail();
                }catch (NoSuchElementException ignored) {
                }
            }

            @Test
            void throwsNoSuchElementExceptionAtEnd() {
                initializeArbitraryList();
                Iterator<String> iterator = testList.iterator();
                for (int i = 0; i < ITERATION_DEPTH; i++) {
                    iterator.next();
                }
                try {
                    iterator.next();
                    fail();
                }catch (NoSuchElementException ignored) {
                }
            }

            @Test
            void returnsNextElement() {
                initializeArbitraryList();
                Iterator<String> iterator = testList.iterator();
                for (int i = 0; i < ITERATION_DEPTH; i++) {
                    assertThat(iterator.next()).isEqualTo(Integer.toString(i));
                }
            }
        }

        @Nested
        class RemoveFunctionTests {

            @Test
            void throwsUnsupportedOperationException() {
                try {
                    testList.iterator().remove();
                    fail();
                } catch (UnsupportedOperationException ignored) {
                }
            }
        }
    }
}
