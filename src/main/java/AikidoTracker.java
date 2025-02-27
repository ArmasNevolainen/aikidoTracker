import java.time.LocalDate;
import java.util.Date;

public class AikidoTracker {
    private String name;
    private Date startDate;
    private int practiceCounter;

    public AikidoTracker(String name, Date startDate) {
        this.name = name;
        this.startDate = startDate;
        this.practiceCounter = 0;
    }

    public void addPractice() {
        practiceCounter++;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public boolean eligibleForExam() {
        LocalDate currentDate = LocalDate.now();
        LocalDate sixMonthsAgo = currentDate.minusMonths(6);
        Date sixMonthsAgoDate = java.sql.Date.valueOf(sixMonthsAgo);

        return practiceCounter >= 60 || startDate.before(sixMonthsAgoDate);
    }

    public String getName() {
        return name;
    }

    public Date getStartDate() {
        return startDate;
    }
}
