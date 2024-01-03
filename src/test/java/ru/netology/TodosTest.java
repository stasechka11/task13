package ru.netology;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class TodosTest {
    @Test
    public void shouldAddThreeTasksOfDifferentType() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");

        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(55, subtasks);

        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = {simpleTask, epic, meeting};
        Task[] actual = todos.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldReturnOneTaskArrayByQuery() {
        SimpleTask simpleTask = new SimpleTask(67, "Встреча с друзьями");

        String[] subtasks = {"Разработка", "Тестирование", "Поддержка"};
        Epic epic = new Epic(8, subtasks);

        Meeting meeting = new Meeting(
                728,
                "Планирование спринта",
                "Разработка функциональности",
                "Каждый второй понедельник"
        );

        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = {meeting};
        Task[] actual = todos.search("Планирование спринта");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldReturnSeveralTasksArrayByQuery() {
        SimpleTask simpleTask = new SimpleTask(9, "Тестирование");

        String[] subtasks = {"Разработка", "Тестирование", "Поддержка"};
        Epic epic = new Epic(59, subtasks);

        Meeting meeting = new Meeting(
                111,
                "Покрыие тестами",
                "Тестирование фичи",
                "16.02.2024"
        );

        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = {simpleTask, epic, meeting};
        Task[] actual = todos.search("Тестирование");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldReturnEmptyArrayNoTasksFound() {
        SimpleTask simpleTask = new SimpleTask(276, "Повторение");

        String[] subtasks = {"Подзадача 1", "Подзадача 2", "Подзадача 3"};
        Epic epic = new Epic(393, subtasks);

        Meeting meeting = new Meeting(
                11,
                "Планирование",
                "Обновление",
                "Завтра"
        );

        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = {};
        Task[] actual = todos.search("Встреча");

        Assertions.assertArrayEquals(expected, actual);
    }
}