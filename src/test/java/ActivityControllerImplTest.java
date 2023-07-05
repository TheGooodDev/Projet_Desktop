import com.projetDev.controller.ActivityControllerImpl;
import com.projetDev.model.Activity;
import com.projetDev.repository.ActivityRepositoryImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.mockito.internal.verification.VerificationModeFactory.times;

@ExtendWith(MockitoExtension.class)
@DisplayName("Group of units tests for the activity controller")
public class ActivityControllerImplTest {

    @Mock
    ActivityRepositoryImpl activityRepository;
    Activity sprintActivity = new Activity(
            "sprint",
            3600,
            4,
            new Date(new Date().getTime())
    );
    Activity brokenActivity = new Activity(
            "sprint",
            3600,
            -5,
            new Date(new Date().getTime()));
    String id = "idSprint";

    ActivityControllerImpl classUnderTest;

    @BeforeEach
    public void setUp() {
        classUnderTest = new ActivityControllerImpl(activityRepository);
    }

    @Disabled
    @Test
    @DisplayName("Test an action")
    public void voidAction_isTested_shouldFail() {
        fail("Not yet implemented");
    }

    @Test
    @DisplayName("Test if the save method of the repository is called with a Activity")
    public void save_withActivity_shouldCallRepository() {
        //Arrange
        when(activityRepository.save(sprintActivity).getInsertedId().toString()).thenReturn(id);

        //Act
        String result = classUnderTest.saveActivity(sprintActivity);

        //Assert
        verify(activityRepository).save(sprintActivity);
        verify(activityRepository).save(any(Activity.class));
        verify(activityRepository, times(1)).save(sprintActivity);
        verify(activityRepository, never()).findAll();
        assertEquals(id, result);
    }

    @Test
    @DisplayName("Test if the findAll method of the repository is called with a Activity")
    public void findAll_withActivity_shouldCallRepository() {

        //Arrange
        when(activityRepository.findAll()).thenReturn(null);

        //Act
        List<Activity> result = classUnderTest.getAll();

        //Assert
        verify(activityRepository).findAll();
        verify(activityRepository).findAll();
        verify(activityRepository, times(1)).findAll();
        verify(activityRepository, never()).save(any(Activity.class));

    }

}
