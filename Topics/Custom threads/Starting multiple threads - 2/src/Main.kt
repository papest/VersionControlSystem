@Suppress("MagicNumber")
fun main() {

    for (i in 1..3) {
        Thread(RunnableWorker(), "worker-$i").start()
    }
}

class RunnableWorker : Runnable {
    override fun run() {
        val name = Thread.currentThread().name
        if (name.startsWith("worker-")) {
            println("too hard calculations...")
        } else {
            return
        }
    }
}