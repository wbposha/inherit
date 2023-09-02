package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TodosTest {

    @Test
    public void shouldAddThreeTasksOfDifferentType() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");

        String[] subtasks = { "Молоко", "Яйца", "Хлеб" };
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
        Task[] expected = { simpleTask, epic, meeting };
        Task[] actual = todos.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchIfTasksFound() {
        SimpleTask simpleTask = new SimpleTask(5, "Обновить приложения");

        String[] subtasks = { "Молоко", "Яйца", "Хлеб" };
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
        Task[] actual = todos.search("приложения");
        Task[] expected = { simpleTask, meeting };

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchIfTasksAreNotFound() {
        SimpleTask simpleTask = new SimpleTask(5, "Обновить приложения");

        String[] subtasks = { "Молоко", "Яйца", "Хлеб" };
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
        Task[] actual = todos.search("во");
        Task[] expected = {  };

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchIfAllTasksFound() {
        SimpleTask simpleTask = new SimpleTask(5, "Обновить приложения");

        String[] subtasks = { "Новые приложения", "Страницы пользователей", "Новые пользователи" };
        Epic epic = new Epic(55, subtasks);

        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после выпуска приложения"
        );

        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);
        Task[] actual = todos.search("приложения");
        Task[] expected = { simpleTask, epic, meeting };

        Assertions.assertArrayEquals(expected, actual);
    }
}
