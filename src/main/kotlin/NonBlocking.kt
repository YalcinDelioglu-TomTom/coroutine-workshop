import kotlinx.coroutines.*

fun main() {
    GlobalScope.launch {
        delay(1000L)
        log("World!")
    }
    runBlocking { // waits it body and all its children to be completed, blocks the current thread.
        log("Hello,")
        delay(2000L)
    }
}
