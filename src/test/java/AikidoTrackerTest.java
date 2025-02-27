import org.junit.jupiter.api.Test;
import java.util.Date;
import static org.junit.jupiter.api.Assertions.*;

class AikidoTrackerTest {

    @Test
    void addPractice() {
        AikidoTracker tracker = new AikidoTracker("Armas", new Date());
        tracker.addPractice();
        tracker.addPractice();
        assertFalse(tracker.eligibleForExam());
    }

    @Test
    void setName() {
        AikidoTracker tracker = new AikidoTracker("Armas", new Date());
        tracker.setName("Amir");
        assertEquals("Amir", tracker.getName());
    }

    @Test
    void setStartDate() {
        Date oldDate = new Date();
        AikidoTracker tracker = new AikidoTracker("Armas", oldDate);
        Date newDate = new Date();
        tracker.setStartDate(newDate);
        assertEquals(newDate, tracker.getStartDate());
    }

    @Test
    void eligibleForExam() {
        AikidoTracker tracker = new AikidoTracker("Armas", new Date());
        for(int i = 0; i < 60; i++) {
            tracker.addPractice();
        }
        assertTrue(tracker.eligibleForExam());
    }
}
