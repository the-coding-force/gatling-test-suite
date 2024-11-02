import io.gatling.javaapi.core.CoreDsl.StringBody
import io.gatling.javaapi.core.CoreDsl.constantConcurrentUsers
import io.gatling.javaapi.core.CoreDsl.scenario
import io.gatling.javaapi.core.Simulation
import io.gatling.javaapi.http.HttpDsl.http
import io.gatling.javaapi.http.HttpDsl.status

class UpdateApiComparison : Simulation() {

    private val httpProtocol = http.baseUrl("http://localhost:8080")

    private val endpointWithCoroutines = "/api/coroutine/update/2"
    private val endpointWithoutCoroutines = "/api/update/2"


    private val scenarioWithCoroutines = scenario("Test with Coroutines")
        .exec(
            http("Request with Coroutines")
                .put(endpointWithCoroutines)
                .body(StringBody("""{"status": "COMPLETED"}"""))
                .header("content-type", "application/json")
                .check(status().shouldBe(200))
        )

    private val scenarioWithoutCoroutines = scenario("Test without Coroutines")
        .exec(
            http("Request without Coroutines")
                .put(endpointWithoutCoroutines)
                .body(StringBody("""{"status": "COMPLETED"}"""))
                .header("content-type", "application/json")
                .check(status().shouldBe(200))
        )

    init {
        setUp(
            scenarioWithCoroutines.injectClosed(constantConcurrentUsers(1).during(1)),
            scenarioWithoutCoroutines.injectClosed(constantConcurrentUsers(1).during(1))
        ).protocols(httpProtocol)
    }
}
