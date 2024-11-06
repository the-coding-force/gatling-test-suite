import io.gatling.javaapi.core.CoreDsl.StringBody
import io.gatling.javaapi.core.CoreDsl.constantConcurrentUsers
import io.gatling.javaapi.core.CoreDsl.scenario
import io.gatling.javaapi.core.Simulation
import io.gatling.javaapi.http.HttpDsl.http
import io.gatling.javaapi.http.HttpDsl.status

class CreateApiComparison : Simulation() {

    private val httpProtocol = http.baseUrl("http://localhost:8080")

    private val endpointWithCoroutines = "/api/coroutine/create"
    private val endpointWithoutCoroutines = "/api/create"


    private val scenarioWithCoroutines = scenario("Test with Coroutines")
        .exec(
            http("Request with Coroutines")
                .post(endpointWithCoroutines)
                .body(StringBody("""{"status": "TODO"}"""))
                .header("content-type", "application/json")
                .check(status().shouldBe(200))
        )

    private val scenarioWithoutCoroutines = scenario("Test without Coroutines")
        .exec(
            http("Request without Coroutines")
                .post(endpointWithoutCoroutines)
                .body(StringBody("""{"status": "TODO"}"""))
                .header("content-type", "application/json")
                .check(status().shouldBe(200))
        )

    init {
        setUp(
            scenarioWithCoroutines.injectClosed(constantConcurrentUsers(100).during(30)),
            scenarioWithoutCoroutines.injectClosed(constantConcurrentUsers(100).during(30))
        ).protocols(httpProtocol)
    }
}
