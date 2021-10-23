import HostReachableRule.HostReachable
import org.junit.Assert
import org.junit.ClassRule
import org.junit.Test

/**
 * @author akirakozov
 */
@HostReachable(VKClientIntegrationTest.HOST)
class VKClientIntegrationTest {
    @Test
    fun info() {
        val infos = VKClient().getDateTimes("#vk")
        Assert.assertTrue(infos.isNotEmpty())
    }

    companion object {
        @ClassRule
        @JvmField
        val rule = HostReachableRule()

        const val HOST = "api.vk.com"
    }
}