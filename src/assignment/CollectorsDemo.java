package assignment;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class CollectorsDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> numbers = Arrays.asList(10, 20, 30, 11, 20, 33, 4, 44, 55, 20);
		
		// collect the result of a Stream into Set
		Set<Integer> numSet = numbers.stream().collect(Collectors.toSet());
		numSet.forEach(System.out::println);
		
		
		// collect the result of a Stream into list
		List<Integer> numList = numbers.stream().collect(Collectors.toList());
		numList.forEach(System.out::println);
		
		
		// create Map from the elements of Stream (first remove the duplicates)
		AtomicInteger index = new AtomicInteger();
		Map<Integer,Integer> numMap = numSet.stream().collect(Collectors.toMap(in->index.getAndIncrement(), n->n));
		numMap.forEach((k,v)->System.out.println("key "+k +"  value "+v));
		
		
		// find summary statistics from a Stream of numbers
		IntSummaryStatistics numStat = numbers.stream().collect(Collectors.summarizingInt(n->n));
		System.out.println(numStat);
		
		// partition the result of Stream in two parts i.e., odd and even
		Map<Boolean,List<Integer>> evenOdd = numbers.stream().collect(Collectors.partitioningBy(num->num%2 == 0));
		System.out.println(evenOdd);
		
		
		
		// create comma separated string from numbers
	    String stringNum = numbers.stream().map(n->n.toString()).collect(Collectors.joining(","));
	    System.out.println(stringNum);


	}

}
