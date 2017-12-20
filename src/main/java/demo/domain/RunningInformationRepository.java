package demo.domain;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * The class dealing with DAO
 * No need to annotated as component because JpaRepository implies component;
 */
public interface RunningInformationRepository extends JpaRepository<RunningInformation, Long>{
    //Page<RunningInformation> findByUsername(@Param("username") String username, Pageable pageable);
    List<RunningInformation> findByUsername(@Param("username") String username);

    // Page<RunningInformation> findByRunningId(@Param("runningId") String runningId, Pageable pageable);
    List<RunningInformation> findByRunningId(@Param("runningId") String runningId);

    Page<RunningInformation> findAllByOrderByHeartRateDesc(Pageable pageable);

    @Transactional
    void deleteByRunningId(@Param("runningId") String runningId);


    @Transactional
    List<RunningInformation> removeByUsername(@Param("username") String username);
}
