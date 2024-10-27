import io.gatling.javaapi.core.CoreDsl.constantConcurrentUsers
import io.gatling.javaapi.core.CoreDsl.scenario
import io.gatling.javaapi.core.Simulation
import io.gatling.javaapi.http.HttpDsl.http
import io.gatling.javaapi.http.HttpDsl.status

class ReadApiComparison : Simulation() {

    private val httpProtocol = http.baseUrl("http://localhost:8080")

    private val endpointWithCoroutines = "/api/coroutine/read/1"
    private val endpointWithoutCoroutines = "/api/read/1"


    private val scenarioWithCoroutines = scenario("Test with Coroutines")
        .exec(
            http("Request with Coroutines")
                .get(endpointWithCoroutines)
                .check(status().`is`(200))
        )

    private val scenarioWithoutCoroutines = scenario("Test without Coroutines")
        .exec(
            http("Request without Coroutines")
                .get(endpointWithoutCoroutines)
                .check(status().`is`(200))
        )

    init {
        setUp(
            scenarioWithCoroutines.injectClosed(constantConcurrentUsers(10000).during(30)),
            scenarioWithoutCoroutines.injectClosed(constantConcurrentUsers(10000).during(30))
        ).protocols(httpProtocol)
    }
}
