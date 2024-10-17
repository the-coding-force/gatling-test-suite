package simulations

import io.gatling.javaapi.core.CoreDsl.atOnceUsers
import io.gatling.javaapi.core.CoreDsl.scenario
import io.gatling.javaapi.core.Simulation
import io.gatling.javaapi.http.HttpDsl.http

class BasicSimulation : Simulation() {
    private val httpProtocol = http.baseUrl("https://example.com")
    private val scn = scenario("Basic Scenario")
        .exec(
            http("Request 1")
                .get("/")
        )

    init {
        setUp(
            scn.injectOpen(
                atOnceUsers(10)
            )
        ).protocols(httpProtocol)
    }
}
