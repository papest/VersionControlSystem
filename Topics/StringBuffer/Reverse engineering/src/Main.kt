fun reverseWords(sentence: String): String = sentence.split(" ").reversed().joinToString(" ")

fun main() {
    val input = readln()
    val reversed = reverseWords(input)
    println(reversed)
}