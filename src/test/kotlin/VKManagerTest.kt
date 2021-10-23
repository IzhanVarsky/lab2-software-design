import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito.`when`
import org.mockito.Mockito.mock
import java.time.Instant

class VKManagerTest {
    private lateinit var vkManager: VKManager
    private lateinit var client: VKClient

    @Before
    fun setUp() {
        client = mock(VKClient::class.java)
        vkManager = VKManager(client)
    }

    @Test
    fun noPosts() {
        testWithGivenAnswers(listOf(0, 0, 0, 0, 0, 0, 0, 0))
    }

    @Test
    fun easyTest() {
        testWithGivenAnswers(listOf(1, 2, 3, 0, 0))
    }

    @Test
    fun mediumTest() {
        testWithGivenAnswers(listOf(1, 2, 3, 0, 12, 3, 0, 11, 2, 5, 9, 0, 1))
    }

    private fun testWithGivenAnswers(trueAnswer: List<Int>) {
        `when`(client.getDateTimes("#vk"))
            .thenReturn(createAnswer(trueAnswer))
        val statistics = vkManager.getStatistics("#vk", trueAnswer.size)
        Assert.assertEquals(trueAnswer, statistics)
    }

    private fun createAnswer(trueAnswer: List<Int>): List<Long> {
        val startUnixTime = Instant.now().epochSecond
        val res = mutableListOf<Long>()
        trueAnswer.forEachIndexed { i, n ->
            repeat(n) { res.add(startUnixTime - 60 * 60 * i - 60 * 2) }
        }
        return res
    }
}