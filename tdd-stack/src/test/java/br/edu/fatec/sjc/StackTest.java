package br.edu.fatec.sjc;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

@ExtendWith(MockitoExtension.class)
public class StackTest {

    private CustomStack<Double> stack;
    @Mock
    CalculableStrategy<Double> calculableStrategy;

    @BeforeEach
    public void setup() {
        stack = new CustomStack<>(5, calculableStrategy);
    }

    @Test
    public void validatePushOneElementInStack() {
        Double elementValue = 5.0;
        Double value = 0.0;
        Mockito.when(
                calculableStrategy.calculateValue(Mockito.anyDouble())
        ).thenReturn(5.0);
        try {
            stack.push(elementValue);
            assertFalse(stack.isEmpty());
            assertEquals(elementValue, stack.top());
            assertEquals(1, stack.size());
            value = stack.pop();
        } catch(StackEmptyException | StackFullException ex) {
            fail();
        }
        assertEquals(elementValue, value);
        assertEquals(0.0, stack.size());
        Mockito.verify(calculableStrategy, Mockito.times(1))
                .calculateValue(Mockito.anyDouble());
    }

    @Test
    public void validatePushOneElementWithNullValueInStack() {
        Mockito.when(calculableStrategy.calculateValue(Mockito.isNull()))
                .thenThrow((NullPointerException.class));

        Assertions.assertThrows(NullPointerException.class, () -> stack.push(null));

        assertTrue(stack.isEmpty());
        assertEquals(0, stack.size());

        Mockito.verify(calculableStrategy, Mockito.times(1))
                .calculateValue(Mockito.isNull());
    }

    @Test
    public void validatePushTwoElementAndRemoveOneOfThenInStack() {
        Double secondElementValue = 10.0;
        Double value = 0.0;
        Mockito.when(
                calculableStrategy.calculateValue(Mockito.anyDouble())
        ).thenReturn(10.0);
        try {
            stack.push(5.0);
            stack.push(secondElementValue);
            assertFalse(stack.isEmpty());
            assertEquals(secondElementValue, stack.top());
            assertEquals(2, stack.size());
            value = stack.pop();
        } catch(StackEmptyException | StackFullException ex) {
            fail();
        }
        assertEquals(secondElementValue, value);
        assertEquals(1, stack.size());
    }

    @Test
    public void validatePushOneElementAndRemoveTwoElementsInStack() {
        Double secondElementValue = 10.0;
        Mockito.when(
                calculableStrategy.calculateValue(Mockito.anyDouble())
        ).thenReturn(10.0);
        try {
            stack.push(secondElementValue);
            stack.pop();
        } catch(StackEmptyException | StackFullException ex) {
            fail();
        }
        assertTrue(stack.isEmpty());
        assertEquals(0, stack.size());
        assertThrows(StackEmptyException.class, () -> {
            stack.pop();
        });
    }

    @Test
    public void validatePushTwoElementForStackWithLimitSizeEqualOne() {
        this.stack = new CustomStack<>(1, calculableStrategy);
        Mockito.when(
                calculableStrategy.calculateValue(Mockito.anyDouble())
        ).thenReturn(20.0);
        try {
            stack.push(5.0);
        } catch(StackFullException ex) {
            fail();
        }
        assertThrows(StackFullException.class, () -> {
            stack.push(10.0);
        });
    }
    
    @Test
    public void validateSortingNumbers() throws StackEmptyException, StackFullException{
    	
    	CustomStack<Integer> stack1 = new CustomStack<>(6, new CalculableStrategy<Integer>() {
    		@Override
    		public Integer calculateValue(Integer value) throws NullPointerException{
    			return value;
    		}
    	});
    	
    	stack1.push(10);
    	stack1.push(25);
    	stack1.push(7);
    	stack1.push(42);
    	stack1.push(18);
    	stack1.push(31);
    	
    	List<Integer> sortedNumbers1 = NumberAscOrder.sort(stack1);
    	List<Integer> expected1 = List.of(7, 10, 18, 25, 31, 42);
    	assertEquals(expected1, sortedNumbers1);
    	
    	CustomStack<Integer> stack2 = new CustomStack<>(6, new CalculableStrategy<Integer>() {
    		@Override
    		public Integer calculateValue(Integer value) throws NullPointerException{
    			return value; 
    		}
    	});
    	
    	assertThrows(StackEmptyException.class, () ->{
    		NumberAscOrder.sort(stack2);
    	});
    }
}
