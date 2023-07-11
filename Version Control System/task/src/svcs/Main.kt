package svcs

const val WRONG_COMMAND = "is not a SVCS command."
const val HELP = "These are SVCS commands:\n" +
        "config     Get and set a username.\n" +
        "add        Add a file to the index.\n" +
        "log        Show commit logs.\n" +
        "commit     Save changes.\n" +
        "checkout   Restore a file.\n"
val commandDescriptions = mapOf(
    "config" to "Get and set a username.",
    "add" to "Add a file to the index.",
    "log" to "Show commit logs.",
    "commit" to "Save changes.",
    "checkout" to "Restore a file."
)

fun main(args: Array<String>) {
    with(args) {
        when {
            isEmpty() || get(0) == "--help" -> HELP
            commandDescriptions.containsKey(get(0)) -> commandDescriptions[get(0)]
            else -> "'${args[0]}' $WRONG_COMMAND"
        }
    }.let { println(it) }
}