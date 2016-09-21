package com.gojavaonline3.dlenchuk.ee.module08.todolist;

import java.util.*;

import static com.gojavaonline3.dlenchuk.ee.module08.todolist.ToDoItem.Priority.*;

public class ToDoItem {

    private Priority priority;
    private String name;
    private String description;
    private State state;

    public ToDoItem(String name, String description) {
        this.priority = MEDIUM;
        this.name = name;
        this.description = description;
        this.state = State.INACTIVE;
    }

    public ToDoItem(Priority priority, String name, String description) {
        this.priority = priority;
        this.name = name;
        this.description = description;
        this.state = State.INACTIVE;
    }

    public Priority getPriority() {
        return priority;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public enum Priority {
        LOW,
        MEDIUM,
        HIGH
    }

    private enum State {
        INACTIVE,
        READY,
        ASSIGNED,
        TERMINATED,
        EXPIRED,
        FORWARDED,
        FINISHED,
        FAILED,
        COMPLETED;

        private static Map<State, List<State>> states = new HashMap<>();

        static {
            states.put(INACTIVE, Arrays.asList(READY, COMPLETED));
            states.put(READY, Arrays.asList(TERMINATED, EXPIRED, ASSIGNED));
            states.put(ASSIGNED, Arrays.asList(READY, TERMINATED, EXPIRED, FORWARDED, FINISHED, FAILED));
            states.put(TERMINATED, Collections.singletonList(COMPLETED));
            states.put(EXPIRED, Collections.singletonList(COMPLETED));
            states.put(FORWARDED, Collections.singletonList(COMPLETED));
            states.put(FINISHED, Collections.singletonList(COMPLETED));
            states.put(FAILED, Collections.singletonList(COMPLETED));
        }

        public List<State> nextStates(State state) {
            return states.get(state);
        }
    }

}
