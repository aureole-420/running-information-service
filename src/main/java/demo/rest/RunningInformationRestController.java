package demo.rest;


import demo.domain.RunningInformation;
import demo.service.RunningInformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RunningInformationRestController {

    private RunningInformationService runningInformationService;

    @Autowired
    public RunningInformationRestController(RunningInformationService runningInformationService) {
        this.runningInformationService = runningInformationService;
    }

    @RequestMapping(value = "/runningInformation", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public void upload(@RequestBody List<RunningInformation> runningInformationList) {
        runningInformationService.saveRunningInformation(runningInformationList);
    }

    @RequestMapping(value = "/purge", method = RequestMethod.DELETE)
    public void purge() {
        runningInformationService.deleteAll();
    }

    @RequestMapping(value = "/runningInformation/users", method = RequestMethod.GET)
    public Page<RunningInformation> findByUsername(@RequestParam("username") String username, @RequestParam("page") int page, @RequestParam("size") int size) {
        return runningInformationService.findByUsername(username, new PageRequest(page, size));
    }

    @RequestMapping(value = "/runningInformation/runningId", method = RequestMethod.GET)
    public Page<RunningInformation> findByRunningId(@RequestParam("runningId") String runningId, @RequestParam("page") int page, @RequestParam("size") int size) {
        return runningInformationService.findByRunningId(runningId, new PageRequest(page, size));
    }

    @RequestMapping(value = "/runningInformation/OrderByHWL", method = RequestMethod.GET)
    public Page<RunningInformation> findAllByOrderByHealthWarningLevelDesc(@RequestParam("page") int page, @RequestParam("size") int size) {
        return runningInformationService.findAllByOrderByHealthWarningLevelDesc(new PageRequest(page, size));
    }
}
