import com.xebialabs.restito.server.StubServer
import com.xebialabs.restito.builder.stub.StubHttp
import com.xebialabs.restito.semantics.Action
import com.xebialabs.restito.semantics.Condition
import org.glassfish.grizzly.http.Method
import java.io.IOException
import org.glassfish.grizzly.http.util.HttpStatus
import org.junit.Assert
import org.junit.Test
import java.util.function.Consumer

class UrlReaderWithStubServerTest {
    private val PORT = 32453
    private val urlReader = VKReader()

    @Test
    fun readAsText() {
        withStubServer(PORT) { s: StubServer? ->
            StubHttp.whenHttp(s)
                .match(Condition.method(Method.GET), Condition.startsWithUri("/ping"))
                .then(Action.stringContent("""{"pong":""}"""))
            val result = urlReader.readTree("http://localhost:$PORT/ping").toString()
            Assert.assertEquals("""{"pong":""}""", result)
        }
    }

    @Test(expected = IOException::class)
    fun readAsTextWithNotFoundError() {
        withStubServer(PORT) { s: StubServer? ->
            StubHttp.whenHttp(s)
                .match(Condition.method(Method.GET), Condition.startsWithUri("/ping"))
                .then(Action.status(HttpStatus.NOT_FOUND_404))
            urlReader.readTree("http://localhost:$PORT/ping")
        }
    }

    private fun withStubServer(port: Int, callback: Consumer<StubServer?>) {
        var stubServer: StubServer? = null
        try {
            stubServer = StubServer(port).run()
            callback.accept(stubServer)
        } finally {
            stubServer?.stop()
        }
    }
}