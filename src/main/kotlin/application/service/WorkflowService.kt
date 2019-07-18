package application.service

import application.model.SendMessage
import application.model.SendMessageForProcess
import org.camunda.bpm.engine.RuntimeService
import org.camunda.bpm.engine.runtime.MessageCorrelationResult
import org.springframework.stereotype.Service

@Service
class WorkflowService(private val runtimeService: RuntimeService) {

    fun workflowStart(): String {
        return runtimeService.startProcessInstanceByKey("do_something").processInstanceId
    }

    fun sendMessage(request: SendMessage) {
        runtimeService.createMessageCorrelation("message_${request.message}")
                .correlateWithResult()
    }

    fun workflowDecolarStart(): String {
        return runtimeService.startProcessInstanceByKey("decolar").processInstanceId
    }

    fun confirmPayment(request: SendMessageForProcess) {
        runtimeService.createMessageCorrelation("paymentSuccess")
                .processInstanceId(request.process)
                .correlateWithResult()
    }
}