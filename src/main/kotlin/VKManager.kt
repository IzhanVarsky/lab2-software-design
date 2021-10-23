import java.time.Instant

class VKManager(private val vkClient: VKClient = VKClient()) {
    private val INIT_COUNT: Int = 0
    private val SECONDS_IN_HOUR: Int = 60 * 60
    private val MAX_PERIOD_OF_HOURS: Int = 24

    fun getStatistics(tag: String, periodOfHours: Int = MAX_PERIOD_OF_HOURS): List<Int> {
        require(periodOfHours in 1..MAX_PERIOD_OF_HOURS)

        val dateTimes = vkClient.getDateTimes(tag)

        val resultList = MutableList(periodOfHours) { INIT_COUNT }

        val startUnixTime = Instant.now().epochSecond
        dateTimes.forEach {
            val period = (startUnixTime - it) / SECONDS_IN_HOUR
            if (period >= resultList.size) return@forEach
            resultList[period.toInt()]++
        }

        return resultList
    }

}