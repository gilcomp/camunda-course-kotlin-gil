package application.controller

import application.camunda.service.ListFlightsServiceTask
import application.model.SendMessage
import application.model.SendMessageForProcess
import application.service.WorkflowService
import org.camunda.bpm.engine.runtime.MessageCorrelationResult
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/workflow")
class WorkflowController(private val workflowService: WorkflowService, private val listFlightsServiceTask: ListFlightsServiceTask) {

    @PostMapping("/start")
    @ResponseStatus(HttpStatus.OK)
    fun startWorkflow(): String {
        return workflowService.workflowStart()
    }

    @PostMapping("/message")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun sendMessage(@RequestBody request: SendMessage) {
        workflowService.sendMessage(request)
    }

    @PostMapping("/decolar")
    @ResponseStatus(HttpStatus.OK)
    fun startDecolar(): String {
        return workflowService.workflowDecolarStart()
    }


    @PostMapping("/payment")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun sendMessage(@RequestBody request: SendMessageForProcess) {
        workflowService.confirmPayment(request)
    }
}