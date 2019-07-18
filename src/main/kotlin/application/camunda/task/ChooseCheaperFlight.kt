package application.camunda.task

import application.camunda.service.ListFlightsServiceTask
import org.camunda.bpm.engine.delegate.DelegateExecution
import org.camunda.bpm.engine.delegate.JavaDelegate
import org.springframework.stereotype.Component

@Component
class ChooseCheaperFlight() : JavaDelegate {

    override fun execute(delegateExecution: DelegateExecution) {

        var flightsList = delegateExecution.getVariable("flights") as List<Pair<String, Double>>
        var lowestPrice = flightsList.get(0).second
        var cheaperFight: Pair<String, Double>? = null
        flightsList.forEach {
            if (it.second < lowestPrice) {
                lowestPrice = it.second
                cheaperFight = it
            }
        }
        print("lowestPrice: " + lowestPrice)
        delegateExecution.setVariable("cheaperFlight", cheaperFight)

    }

}