import kotlinx.coroutines.*

fun main() {
    GlobalScope.launch {
        delay(1000L)
        log("World!")
    }
    log("Hello,")
    Thread.sleep(2000L)
}
