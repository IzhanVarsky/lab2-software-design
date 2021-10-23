import java.net.URL

open class VKClient(
    private val reader: VKReader = VKReader(),
    private val parser: VKTreeParser = VKTreeParser(),
    private val postsDownloaded: Int = 200
) {
    private val MAX_POST_DOWNLOADED: Int = 200

    open fun getDateTimes(tag: String): List<Long> {
        val tree = reader.readTree(createUrlWithQuery(tag))
        return parser.parseTree(tree)
    }

    private fun createUrlWithQuery(query: String): URL {
        require(postsDownloaded in 1..MAX_POST_DOWNLOADED) { postsDownloaded }
        return VKAPIUrlCreator(method = "newsfeed.search").createUrl(mapOf("count" to postsDownloaded, "q" to query))
    }
}