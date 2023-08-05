fun main() {
    val stringProcessor = thread(
        block = {
            while (true) {
                val st = readln()
                if (st.matches(".*[a-z].*".toRegex())) {
                    println(st.uppercase())
                } else {
                    println("FINISHED")
                    break
                }
            }
        }
    )
}