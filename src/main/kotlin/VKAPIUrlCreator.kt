import java.net.URL
import java.net.URLEncoder
import java.nio.charset.StandardCharsets
import java.util.*

class VKAPIUrlCreator(
    private val baseURL: String = "https://api.vk.com/method/",
    private val method: String,
    private val token: String = "1b8ed68c1b8ed68c1b8ed68c2f1bf775cb11b8e1b8ed68c7aecc0e7c6affb2633e4d95b",
    private val version: Double = 5.131,
) {

    fun createUrl(arguments: Map<String, Any>, addTokenAndVersion: Boolean = true): URL {
        val params = StringJoiner("&")
        if (addTokenAndVersion) addAllParams(params, mapOf("access_token" to token, "v" to version))
        addAllParams(params, arguments)
        return URL("$baseURL$method?$params")
    }

    private fun addAllParams(params: StringJoiner, arguments: Map<String, Any>) =
        arguments.forEach { params.add(pairToParameter(it)) }

    private fun pairToParameter(pair: Map.Entry<String, Any>): String {
        val encodedParam = URLEncoder.encode(pair.value.toString(), StandardCharsets.UTF_8)
        return "${pair.key}=$encodedParam"
    }

}