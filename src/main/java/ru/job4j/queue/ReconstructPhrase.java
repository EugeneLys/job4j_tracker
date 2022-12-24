package ru.job4j.queue;

import java.util.Queue;
import java.util.Deque;

public class ReconstructPhrase {

    private final Queue<Character> descendingElements;

    private final Queue<Character> evenElements;

    public ReconstructPhrase(Queue<Character> descendingElements, Queue<Character> evenElements) {
        this.descendingElements = descendingElements;
        this.evenElements = evenElements;
    }

    private String getEvenElements() {
        StringBuilder builder = new StringBuilder();
        for (int i = 1; i < evenElements.size(); i = i + 2) {
            builder.append(evenElements.poll());
        }
        return builder.toString();
    }

    private String getDescendingElements() {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < descendingElements.size(); i++) {
            builder.append(descendingElements.pollLast());
        }
        return builder.toString();
    }

    public String getReconstructPhrase() {
        return getDescendingElements() + getEvenElements();
    }
}
