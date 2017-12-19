package demo.service;

import demo.domain.RunningInformation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface RunningInformationService {

    List<RunningInformation> saveRunningInformation(List<RunningInformation> runningInformationList);

    void deleteAll();

    Page<RunningInformation> findByUsername(String username, Pageable pageable);

    Page<RunningInformation> findByRunningId(String runningId, Pageable pageable);

    Page<RunningInformation> findAllByOrderByHealthWarningLevelDesc(Pageable pageable);
}
