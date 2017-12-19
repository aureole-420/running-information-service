package demo.domain;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

/**
 * The class dealing with DAO
 * No need to annotated as component because JpaRepository implies component;
 */
public interface RunningInformationRepository extends JpaRepository<RunningInformation, Long>{
    Page<RunningInformation> findByUsername(@Param("username") String username, Pageable pageable);

    Page<RunningInformation> findByRunningId(@Param("runningId") String runningId, Pageable pageable);

    Page<RunningInformation> findAllByOrderByHeartRateDesc(Pageable pageable);
}
