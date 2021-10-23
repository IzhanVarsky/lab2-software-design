import org.junit.Assume
import org.junit.rules.TestRule
import org.junit.runner.Description
import org.junit.runners.model.Statement
import java.io.IOException
import java.util.*
import java.util.concurrent.TimeUnit

/**
 * @author akirakozov
 */
class HostReachableRule : TestRule {
    @kotlin.annotation.Retention(AnnotationRetention.RUNTIME)
    @Target(
        AnnotationTarget.FUNCTION,
        AnnotationTarget.PROPERTY_GETTER,
        AnnotationTarget.PROPERTY_SETTER,
        AnnotationTarget.ANNOTATION_CLASS,
        AnnotationTarget.CLASS
    )
    annotation class HostReachable(val value: String)

    override fun apply(statement: Statement, description: Description): Statement {
        val hostReachable = description.getAnnotation(HostReachable::class.java)
        if (hostReachable == null) {
            return statement
        } else if (!checkHost(hostReachable.value)) {
            return SkipStatement(hostReachable.value)
        }
        return statement
    }

    private class SkipStatement(private val host: String) : Statement() {
        @Throws(Throwable::class)
        override fun evaluate() {
            Assume.assumeTrue(
                "Skipped, because following host is not available at the moment: $host",
                false
            )
        }
    }

    companion object {
        private const val TIMEOUT = 2

        private fun checkHost(host: String): Boolean = try {
            val isWindows = System.getProperty("os.name").lowercase(Locale.getDefault()).contains("win")
            val pingProcess = ProcessBuilder("ping", if (isWindows) "-n" else "-c", "1", host).start()
            if (!pingProcess.waitFor(TIMEOUT.toLong(), TimeUnit.SECONDS)) {
                false
            } else pingProcess.exitValue() == 0
        } catch (e: IOException) {
            e.printStackTrace()
            false
        } catch (e: InterruptedException) {
            e.printStackTrace()
            false
        }

    }
}