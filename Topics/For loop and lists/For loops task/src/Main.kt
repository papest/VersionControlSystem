fun main() {
    val size = readln().toInt()
    val list = List(size) { readln().toInt() }
    val twoNumbers = readln().split(" ").map { it.toInt() }
    println(if (list.containsAll(twoNumbers)) "YES" else "NO")
}