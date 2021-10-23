import com.fasterxml.jackson.databind.JsonNode

class VKTreeParser {
    fun parseTree(tree: JsonNode): List<Long> = tree["response"]["items"].map { it["date"].asLong() }
}