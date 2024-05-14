package br.edu.fatec.sjc;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class NumberAscOrder {
	public static <E extends Number> List<E> sort(CustomStack<E> stack) throws StackEmptyException{
		if (stack.isEmpty()) {
			throw new StackEmptyException();
		}
		
		List<E> sortedNumbers = new ArrayList<>();
		while (!stack.isEmpty()) {
			sortedNumbers.add(stack.pop());
		}
		
		Collections.sort(sortedNumbers, (a, b) -> Double.compare(a.doubleValue(), b.doubleValue()));
		
		return sortedNumbers;
	}
}

