import io.gatling.javaapi.core.CoreDsl.constantConcurrentUsers
import io.gatling.javaapi.core.CoreDsl.scenario
import io.gatling.javaapi.core.Simulation
import io.gatling.javaapi.http.HttpDsl.http
import io.gatling.javaapi.http.HttpDsl.status

class DeleteApiComparison : Simulation() {

    private val httpProtocol = http.baseUrl("http://localhost:8080")

    private val endpointWithCoroutines = "/api/coroutine/delete/3"
    private val endpointWithoutCoroutines = "/api/delete/3"


    private val scenarioWithCoroutines = scenario("Test with Coroutines")
        .exec(
            http("Request with Coroutines")
                .delete(endpointWithCoroutines)
                .check(status().`is`(200))
        )

    private val scenarioWithoutCoroutines = scenario("Test without Coroutines")
        .exec(
            http("Request without Coroutines")
                .delete(endpointWithoutCoroutines)
                .check(status().`is`(200))
        )

    init {
        setUp(
            scenarioWithCoroutines.injectClosed(constantConcurrentUsers(1).during(1)),
            scenarioWithoutCoroutines.injectClosed(constantConcurrentUsers(1).during(1))
        ).protocols(httpProtocol)
    }
}
