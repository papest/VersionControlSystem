class MyCustomThread : Thread() {
    override fun run() {
        throw NumberFormatException()
    }
}