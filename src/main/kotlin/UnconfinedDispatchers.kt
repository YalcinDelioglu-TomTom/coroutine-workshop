import kotlinx.coroutines.*

fun main() = runBlocking {
    val deferred: Deferred<String> = async(Dispatchers.Unconfined) {
        loadData()
    }
    log("waiting...")
    log(deferred.await())
}

private suspend fun loadData(): String {
    log("loading...")
    delay(1000L)
    log("loaded!")
    return "Loaded!!!"
}