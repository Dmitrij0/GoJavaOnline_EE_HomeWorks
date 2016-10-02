package com.gojavaonline3.dlenchuk.ee.module08.todolist;

import java.util.*;

import static com.gojavaonline3.dlenchuk.ee.module08.todolist.ToDoItem.Priority.*;

public class ToDoItem {

    final private int id;
    private String name;
    private String description;
    private State state;
    private Priority priority;

    public ToDoItem(int id) {
        this(id, "", "");
    }

    public ToDoItem(int id, String name, String description) {
        this(id, name, description, MEDIUM);
    }

    public ToDoItem(int id, String name, String description, Priority priority) {
        this.id = id;
        this.priority = priority;
        this.name = name;
        this.description = description;
        this.state = State.INACTIVE;
    }

    public int getId() {
        return id;
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

    public Priority getPriority() {
        return priority;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    public List<State> nextStates() {
        return State.nextStates(state);
    }


    public enum Priority {
        LOW,
        MEDIUM,
        HIGH
    }

    public enum State {
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
            states.put(null, Collections.singletonList(INACTIVE));
            states.put(INACTIVE, Arrays.asList(READY, COMPLETED));
            states.put(READY, Arrays.asList(TERMINATED, EXPIRED, ASSIGNED));
            states.put(ASSIGNED, Arrays.asList(READY, TERMINATED, EXPIRED, FORWARDED, FINISHED, FAILED));
            states.put(TERMINATED, Collections.singletonList(COMPLETED));
            states.put(EXPIRED, Collections.singletonList(COMPLETED));
            states.put(FORWARDED, Collections.singletonList(COMPLETED));
            states.put(FINISHED, Collections.singletonList(COMPLETED));
            states.put(FAILED, Collections.singletonList(COMPLETED));
        }

        public static List<State> nextStates(State state) {
            return states.get(state);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ToDoItem toDoItem = (ToDoItem) o;

        return id == toDoItem.id;

    }

    @Override
    public int hashCode() {
        return id;
    }

    @Override
    public String toString() {
        return "ToDoItem{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", state=" + state +
                ", priority=" + priority +
                '}';
    }

}
