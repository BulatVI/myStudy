package com.stepik.functionalProgramming.Lesson6.Tasks5;

import java.util.List;
import java.util.Spliterator;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.StreamSupport;

public class CustomSpliterator implements Spliterator<Integer> {

    public static void main(String[] args) {
        // produce values
        List<Integer> values = IntStream.range(0, 2000)
                .boxed()
                .collect(Collectors.toList());
        // create spliterator
        Spliterator<Integer> spliterator = new CustomSpliterator(
                values, 0, values.size() - 1
        );
        // consume spliterator
        Integer sum = StreamSupport.stream(spliterator, true)
                .reduce(0, Integer::sum, Integer::sum);
        System.out.println(sum); // 1999000
    }


    private final List<Integer> numbers;
    private int start;
    private int end;

    public CustomSpliterator(List<Integer> numbers, int start, int end) {
        this.numbers = numbers;
        this.start = start;
        this.end = end;
    }

    @Override
    public boolean tryAdvance(Consumer<? super Integer> action) {
        if (start <= end) {
            action.accept(numbers.get(start++));
            return true;
        }

        return false;
    }

    @Override
    public Spliterator<Integer> trySplit() {
        if (estimateSize() <= 1000) return null;
        int middle = (start + end) / 2;
        int oldStart = start;
        start = middle + 1;

        return new CustomSpliterator(numbers, oldStart, middle);
    }

    @Override
    public long estimateSize() {
        return end - start + 1;
    }

    @Override
    public int characteristics() {
        return ORDERED | SIZED | SUBSIZED;
    }
}
