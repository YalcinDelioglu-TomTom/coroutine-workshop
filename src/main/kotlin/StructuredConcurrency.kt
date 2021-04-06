import kotlinx.coroutines.*

fun main() = runBlocking(CoroutineName("runBlocking")) {
    log("runBlocking is started!")
    val parent = launch(CoroutineName("parent")) {
        log("Started!")
        launch(CoroutineName("child")) {
            log("Started!")
            delay(3000L)
            log("Completed!")
        }
        log("Completed!")
    }
    delay(2000L)
    parent.cancel()
    log("Canceled!")
    delay(2000L)
    log("runBlocking is ended!")
}