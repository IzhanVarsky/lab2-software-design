import com.fasterxml.jackson.databind.JsonNode
import com.fasterxml.jackson.databind.ObjectMapper
import java.net.URL

class VKReader {
    fun readTree(url: String): JsonNode = readTree(URL(url))

    fun readTree(url: URL): JsonNode = ObjectMapper().readTree(url)
}