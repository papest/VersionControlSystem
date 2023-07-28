data class Ship(val name: String, val ammunition: Int) {
    override fun toString(): String {
        return "$name-$ammunition"
    }
}

fun main() {
    val ships = readln().split(" ")
    val shipsList = ships.map { Ship(it.split("-")[0], it.split("-")[1].toInt()) }
    println(shipsList.reversed())
}