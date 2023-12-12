package uk.gov.dwp.health.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uk.gov.dwp.health.model.ActivateTaskRequest;
import uk.gov.dwp.health.model.AllocatedTask;
import uk.gov.dwp.health.model.CreateAdHocRequest;
import uk.gov.dwp.health.model.CreateTaskRequest;
import uk.gov.dwp.health.model.Referrals;
import uk.gov.dwp.health.model.RequestTask;
import uk.gov.dwp.health.model.Status;
import uk.gov.dwp.health.model.Task;
import uk.gov.dwp.health.model.TaskCmd;
import uk.gov.dwp.health.service.ReferralsService;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/tasks/api/v3")
public class TaskController {
  Logger logger = LoggerFactory.getLogger(TaskController.class);
  @Autowired
  ReferralsService referralsService;

  @PostMapping("/tasks/create/{organisationUnitName}/{taskTypeName}")
  public ResponseEntity<TaskCmd> createTask(@PathVariable String organisationUnitName,
                                            @PathVariable String taskTypeName,
                                            @RequestBody CreateTaskRequest taskRequest) {
    return ResponseEntity.status(HttpStatus.CREATED).body(new TaskCmd("ABC1234"));
  }

  @PostMapping("/tasks/create-and-reserve-agent/{organisationUnitName}/{taskTypeName}")
  public ResponseEntity<TaskCmd> createAndReserveAgent(@PathVariable String organisationUnitName,
                                                       @PathVariable String taskTypeName,
                                                       @RequestBody CreateTaskRequest taskRequest) {
    return ResponseEntity.status(HttpStatus.CREATED).body(new TaskCmd("ABC1234"));
  }

  @PostMapping("/tasks/create-and-reserve-agent-group/{organisationUnitName}/{taskTypeName}")
  public ResponseEntity<TaskCmd> createAndReserveAgentGroup(@PathVariable String organisationUnitName,
                                                            @PathVariable String taskTypeName,
                                                            @RequestBody CreateTaskRequest createAndReserveAgentGroupRequest
  ) {
    return ResponseEntity.status(HttpStatus.CREATED).body(new TaskCmd("ABC1234"));
  }

  @PostMapping("/tasks/create-ad-hoc/{organisationUnitName}")
  public ResponseEntity<TaskCmd> createAdHoc(@PathVariable String organisationUnitName,
                                             @RequestBody CreateAdHocRequest createAdHocRequest) {
    return ResponseEntity.status(HttpStatus.CREATED).body(new TaskCmd("ABC1234"));
  }

  @PutMapping("/tasks/unallocate")
  public List<String> unallocateTask(@RequestBody TaskCmd taskCmd) {
    RequestTask request = RequestTask.builder().taskId(List.of("task 1","task 2","task 3","un allocated")).build();
    return request.getTaskId();
  }

  @PutMapping("/tasks/complete")
  public List<String>  completeTask(@RequestBody TaskCmd taskCmd) {
    RequestTask request = RequestTask.builder().taskId(List.of("task 1","task 2","task 3","completed")).build();
    return request.getTaskId();
  }

  @PutMapping("/tasks/activate")
  public List<String>  activateTasks(@RequestBody TaskCmd taskCmd) {
    RequestTask request = RequestTask.builder().taskId(List.of("task 1","task 2","task 3","activated")).build();
    return request.getTaskId();
  }

  @GetMapping("/tasks/{organisationUnitName}/{taskId}")
  public ResponseEntity<Task> getTask(@PathVariable String organisationUnitName, @PathVariable String taskId) {
    return ResponseEntity.status(HttpStatus.OK).body(
            Task.builder().taskId(taskId).createdAt(LocalDateTime.of(2022, 12, 22, 12, 2))
             .organisationUnitName(organisationUnitName).status(Status.COMPLETED)
                    .agentGroupName("ORG1").subjectKey("sub1").taskTypeName("tas1").activatedAt(LocalDateTime.now()).reason("res")
                    .executionUrl("some-url").priority(1).mustCompleteBy("20/12/2023").mandatoryAttributes("taskId").optionalAttributes("org1")
                    .reservedForStaffNumber("ST123").citizenGuid("GUID").description("des").suspendedUntilDateTime(LocalDateTime.now())
                    .reservedForAgentGroupName("GROUP 1").completedAt(LocalDateTime.now()).failedAt(LocalDateTime.now())
                    .cancelledAt(LocalDateTime.of(2023, 02, 22, 12, 2))
                    .reservedAt(LocalDateTime.of(2023, 06, 27, 13, 2))
                    .suspendedAt(LocalDateTime.of(2023, 02, 22, 12, 2))
                    .build());
  }

  @GetMapping("tasks/{organisationUnitName}")
  public ResponseEntity<Referrals> getReferral(@PathVariable String organisationUnitName) {
    Referrals referrals = referralsService.getReferrals(organisationUnitName);
    return ResponseEntity.ok(referrals);
  }

  @PostMapping("/claim-next-agent-group-task")
  public TaskCmd allocateTask(@RequestBody AllocatedTask allocatedTask) {
    allocatedTask.setTaskTypeName("string");
    allocatedTask.setOrganisationUnitName("string");
    allocatedTask.setStaffNumber("ID123 allocated");
    allocatedTask.setAgentGroupName("String");
    TaskCmd taskCmd = TaskCmd.builder()
            .taskId(allocatedTask.getStaffNumber())
            .build();
    return taskCmd;
  }

}
