package demo.service;

import demo.domain.RunningInformation;
import demo.domain.RunningInformationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RunningInformationServiceImpl implements RunningInformationService {

    private RunningInformationRepository repository;

    @Autowired
    public RunningInformationServiceImpl(RunningInformationRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<RunningInformation> saveRunningInformation(List<RunningInformation> runningInformationList) {
        for (RunningInformation r : runningInformationList) {
            // r.setHeartRate(100);
            System.out.println(r.getHeartRate());
        }
        return repository.save(runningInformationList);
    }

    @Override
    public void deleteAll() {
        repository.deleteAll();
    }

//    @Override
//    public Page<RunningInformation> findByUsername(String username, Pageable pageable) {
//        return repository.findByUsername(username, pageable);
//    }

    @Override
    public List<RunningInformation> findByUserInfoUsername(String username) {
        return repository.findByUserInfoUsername(username);
    }

    @Override
    public List<RunningInformation> findByRunningId(String runningId) {
        return repository.findByRunningId(runningId);
    }

//    @Override
//    public Page<RunningInformation> findByRunningId(String runningId, Pageable pageable) {
//        return repository.findByRunningId(runningId, pageable);
//    }



    @Override
    public Page<RunningInformation> findAllByOrderByHealthWarningLevelDesc(Pageable pageable) {
        return repository.findAllByOrderByHeartRateDesc(pageable);
    }

    @Override
    public void deleteByRunningId(String runningId) {
        repository.deleteByRunningId(runningId);
    }

    @Override
    public void removeByUserInfoUsername(String username) {
        repository.removeByUserInfoUsername(username);
    }


}
