import org.slf4j.Logger
import org.slf4j.LoggerFactory

val log: Logger = LoggerFactory.getLogger("Workshop")

fun log(msg: String?) {
    log.info(msg)
}