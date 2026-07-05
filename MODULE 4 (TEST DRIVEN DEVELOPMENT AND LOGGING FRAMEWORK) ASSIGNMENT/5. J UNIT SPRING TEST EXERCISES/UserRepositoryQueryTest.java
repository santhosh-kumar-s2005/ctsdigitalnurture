import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Arrays;
import java.util.List;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class UserRepositoryQueryTest {

    @Mock
    private UserRepository userRepository;

    @Test
    public void testFindByName() {
        User user1 = new User();
        user1.setId(1L);
        user1.setName("Alice");

        User user2 = new User();
        user2.setId(2L);
        user2.setName("Alice");

        when(userRepository.findByName("Alice")).thenReturn(Arrays.asList(user1, user2));

        List<User> result = userRepository.findByName("Alice");

        assertEquals(2, result.size());
        assertEquals("Alice", result.get(0).getName());
        verify(userRepository).findByName("Alice");
    }
}
