package Entities.Tasks;

import static org.mockito.Mockito.*;

import modules.Entities.Tasks.TaskEnums.TaskStatus;
import org.junit.jupiter.api.*;

public class TasksTest {


    @Test
    public void initStatusTest_Planned() {

        Assertions.assertAll(
                "Grouped Assertions of initStatus",
                () -> Assertions.assertEquals(TaskStatus.PLANNED, TaskStatus.initStatus(0), "Status should be 'Planned'"),
                () -> Assertions.assertEquals(TaskStatus.IN_PROGRESS, TaskStatus.initStatus(1), "Status should be 'In_Progress'"),
                () -> Assertions.assertEquals(TaskStatus.DELAYED, TaskStatus.initStatus(2), "Status should be 'Delayed'"),
                () -> Assertions.assertEquals(TaskStatus.EXPIRED, TaskStatus.initStatus(3), "Status should be 'Expired'"),
                () -> Assertions.assertEquals(TaskStatus.BLOCKED, TaskStatus.initStatus(4), "Status should be 'Blocked'"),
                () -> Assertions.assertEquals(TaskStatus.DONE, TaskStatus.initStatus(5), "Status should be 'Done'")
        );
    }
}