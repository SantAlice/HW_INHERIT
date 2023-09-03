import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class TaskTest {

    @Test
    public void simpleTaskMatchesTest() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");

        boolean actual = simpleTask.matches( "Позвонить");
        boolean expected = true;
        Assertions.assertEquals  (expected, actual);
    }

    @Test
    public void simpleTaskNotMatchesTest() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");

        boolean actual = simpleTask.matches( "Написать");
        boolean expected = true;
        Assertions.assertFalse  (actual);
    }

    @Test
    public void EpicMatchesTest() {
        String[] subtasks = { "Молоко", "Яйца", "Хлеб" };
        Epic epic = new Epic(55, subtasks);

        boolean actual = epic.matches( "Хлеб");
        boolean expected = true;
        Assertions.assertTrue (actual);
    }

    @Test
    public void EpicNotMatchesTest() {
        String[] subtasks = { "Молоко", "Яйца", "Хлеб" };
        Epic epic = new Epic(55, subtasks);

        boolean actual = epic.matches( "Яблоки");
        boolean expected = false;
        Assertions.assertFalse (actual);
    }

    @Test
    public void MeetingMatchesInTopic() {
        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );
        boolean actual = meeting.matches( "приложения");
        boolean expected = true;
        Assertions.assertTrue (actual);

    }

    @Test
    public void MeetingMatchesInProject() {
        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );
        boolean actual = meeting.matches( "Приложение");
        boolean expected = true;
        Assertions.assertTrue (actual);

    }

    @Test
    public void MeetingMatchesNotFound() {
        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );
        boolean actual = meeting.matches( "Релиз");
        boolean expected = false;
        Assertions.assertFalse (actual);

    }
}