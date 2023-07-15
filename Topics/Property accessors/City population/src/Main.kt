const val MAX_POPULATION = 50_000_000
const val MIN_POPULATION = 0

data class City(val name: String) {
    var population: Int = 0
        set(value) = when {
            value < MIN_POPULATION -> field = MIN_POPULATION
            value > MAX_POPULATION -> field = MAX_POPULATION
            else -> field = value
        }
}