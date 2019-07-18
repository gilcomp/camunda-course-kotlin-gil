package application.camunda.service

import org.springframework.stereotype.Service

@Service
class ListFlightsServiceTask {

    fun listFlights(): List<Pair<String, Double>>{
        return arrayListOf(Pair("UDI x CGH", 200.0),
                Pair("UDI x CGH", 300.0), Pair("UDI x CNF", 400.0), Pair("UDI x BSB", 150.0), Pair("UDI x GRU", 330.0))
    }
}