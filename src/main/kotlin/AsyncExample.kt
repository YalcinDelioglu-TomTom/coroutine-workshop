import kotlinx.coroutines.*

fun main() = runBlocking {
    val deferred: Deferred<String> = async {
        loadData()
    }
    log("waiting...")
    log(deferred.await())
}

private suspend fun loadData(): String {
    log("loading...")
    delay(1000L)
    return "Loaded!!!"
}