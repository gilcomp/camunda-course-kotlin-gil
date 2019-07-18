package application.camunda.task

import application.camunda.service.ListFlightsServiceTask
import org.camunda.bpm.engine.delegate.DelegateExecution
import org.camunda.bpm.engine.delegate.JavaDelegate
import org.springframework.stereotype.Component

@Component
class ListFlightsTask(private val listFlightsServiceTask: ListFlightsServiceTask) : JavaDelegate {

    override fun execute(delegateExecution: DelegateExecution) {

        delegateExecution.setVariable("flights", listFlightsServiceTask.listFlights())

    }

}