package demo.service;

import demo.domain.RunningInformation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;


public interface RunningInformationService {

    List<RunningInformation> saveRunningInformation(List<RunningInformation> runningInformationList);

    void deleteAll();

    //Page<RunningInformation> findByUsername(String username, Pageable pageable);
    List<RunningInformation> findByUserInfoUsername(String username);

    //Page<RunningInformation> findByRunningId(String runningId, Pageable pageable);
    List<RunningInformation> findByRunningId(String runningId);

    Page<RunningInformation> findAllByOrderByHealthWarningLevelDesc(Pageable pageable);

    void deleteByRunningId(String runningId);

    void removeByUserInfoUsername(String username);
}
