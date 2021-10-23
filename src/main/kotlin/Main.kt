fun main() {
    VKAPIUrlCreator(method = "newsfeed.search").createUrl(mapOf("count" to 3, "q" to "#vk")).readText().let { println(it) }
    println(VKManager().getStatistics("#наруто"))
}