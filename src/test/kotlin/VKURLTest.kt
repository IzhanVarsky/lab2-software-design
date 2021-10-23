import org.junit.Assert
import org.junit.Test

class VKURLTest {
    private val parameters = mapOf("arg1" to "x1", "arg2" to "x2", "arg3" to "x3")

    @Test
    fun test1() {
        val url = VKAPIUrlCreator(method = "method").createUrl(parameters, false).toString()
        Assert.assertEquals(
            "https://api.vk.com/method/method?arg1=x1&arg2=x2&arg3=x3",
            url
        )
    }

    @Test
    fun test2() {
        val url = VKAPIUrlCreator(method = "method").createUrl(parameters).toString()
        Assert.assertEquals(
            "https://api.vk.com/method/method?access_token=1b8ed68c1b8ed68c1b8ed68c2f1bf775cb11b8e1b8ed68c7aecc0e7c6affb2633e4d95b&v=5.131&arg1=x1&arg2=x2&arg3=x3",
            url
        )
    }
}