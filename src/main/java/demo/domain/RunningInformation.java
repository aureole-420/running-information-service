package demo.domain;

import com.fasterxml.jackson.annotation.*;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;



/**
 * The object corresponding to RunnintInformation Entity in the relational database.
 */
@Data
@Entity
@Table(name = "RUNNING_ANALYSIS")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RunningInformation {

    enum HealthWarningLevel {
        LOW, NORMAL, HIGH;

        static HealthWarningLevel checkHealthWarningLevel(int heartRate) {
            if (heartRate > 120) {
                return HIGH;
            } else if (heartRate <= 75) {
                return LOW;
            } else {
                return NORMAL;
            }
        }
    }

    @Id
    @GeneratedValue
    private Long id;

    private String runningId;

    private double latitude;
    private double longitude;
    private double runningDistance;
    private double totalRunningTime;

    private int heartRate;

    private Date timestamp;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    private UserInfo userInfo;
    //private String username;
    //private String address;

    @Transient
    private HealthWarningLevel healthWarningLevel;

    @PostLoad
    public void setHealthWarningLevel() {
        this.healthWarningLevel = HealthWarningLevel.checkHealthWarningLevel(heartRate);
    }

    // no arg constructor for
    public RunningInformation() {

    }

    @JsonCreator
    public RunningInformation(@JsonProperty("runningId") String runningId,
                              @JsonProperty("heartRate") int heartRate,
                              @JsonProperty("username") String username,
                              @JsonProperty("address") String address) {

        this.userInfo = new UserInfo(username, address);
        this.runningId = runningId;
        // trial:
        this.heartRate = (int) (60 + 140 * Math.random()); // random integer between 60 and 200
        //this.healthWarningLevel = HealthWarningLevel.checkHealthWarningLevel(heartRate);
    }


}
