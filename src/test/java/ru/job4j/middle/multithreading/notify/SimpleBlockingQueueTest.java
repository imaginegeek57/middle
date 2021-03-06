package ru.job4j.middle.multithreading.notify;


import org.junit.Test;

import java.util.Arrays;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.IntStream;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class SimpleBlockingQueueTest {

    @Test
    public void whenFetchAllThenGetIt() throws InterruptedException {
        final CopyOnWriteArrayList <Integer> buffer = new CopyOnWriteArrayList <>();
        final SimpleBlockingQueue <Integer> queue = new SimpleBlockingQueue <>();
        Thread producer = new Thread(
                () -> {
                    IntStream.range(2, 8).forEach(
                            queue::offer
                    );
                }
        );
        producer.start();
        Thread consumer = new Thread(
                () -> {
                    while (!queue.isEmpty() || !Thread.currentThread().isInterrupted()) {
                        buffer.add(queue.poll());
                    }
                }
        );
        consumer.start();
        producer.join();
        consumer.interrupt();
        consumer.join();
        assertThat(buffer, is(Arrays.asList(2, 3, 4, 5, 6, 7)));
    }
}
