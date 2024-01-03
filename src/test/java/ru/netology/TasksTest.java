package ru.netology;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TasksTest {
    @Test
    public void shouldFindSimpleTaskByQueryPositive() {
        SimpleTask simpleTask = new SimpleTask(1, "Написать тест");
        String query = "Написать тест";

        Assertions.assertTrue(simpleTask.matches(query));
    }

    @Test
    public void shouldFindSimpleTaskByQueryNegative() {
        SimpleTask simpleTask = new SimpleTask(2, "Изучить тему Наследование");
        String query = "Изучить тему Конструкторы";

        Assertions.assertFalse(simpleTask.matches(query));
    }

    @Test
    public void shouldFindEpicByQueryPositive() {
        String[] subtasks = {"Subtask 1", "Subtask 2", "Subtask 3"};
        Epic epic = new Epic(3, subtasks);
        String query = "Subtask 2";

        Assertions.assertTrue(epic.matches(query));
    }

    @Test
    public void shouldFindEpicByQueryNegative() {
        String[] subtasks = {"Subtask 1", "Subtask 2", "Subtask 3"};
        Epic epic = new Epic(4, subtasks);
        String query = "Subtask 22";

        Assertions.assertFalse(epic.matches(query));
    }

    @Test
    public void shouldFindMeetingByQueryInTopicPositive() {
        Meeting meeting = new Meeting(
                5,
                "Наследование классов",
                "Изучение Java",
                "05.01.2024 19:00"
        );

        String query = "Наследование классов";

        Assertions.assertTrue(meeting.matches(query));
    }
}
