package svcs

import java.io.File

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

fun Config.name(addName: String) {
    name = addName
}

class Config : Command(default = { println("Please, tell me who you are.") }) {
    private var config = File("vcs/config.txt")
    var name = if (config.exists()) config.readLines()[0] else ""
        get() {
            if (field == "") default() else println("The username is $field.")
            return field
        }
        set(value) {
            if (!config.exists()) {
                checkVcs()
                config.createNewFile()
            }
            config.writeText(value)
            field = value
            println("The username is $value.")
        }
}

class Add : Command(default = { println("Add a file to the index.") }) {
    private var index = File("vcs/index.txt")
    var text = if (index.exists()) index.readText() else ""
        get() {
            if (!index.exists()) {
                default()
            } else {
                println("Tracked files:\n$field")
            }

            return field
        }
        set(value) {
            if (!File(value).exists()) {
                println("Can't find '$value'.")
                return
            }
            if (!index.exists()) {
                checkVcs()
                index.createNewFile()
            }
            index.appendText(value)
            index.appendText("\n")
            println("The file '$value' is tracked.")
            field = index.readText()
        }

    fun apply(file: String = "") {
        if (file != "") text = file else println(text)
    }

}

fun checkVcs() {
    val dir = File("vcs")
    if (!dir.exists()) dir.mkdir()
}

open class Command(val default: () -> Unit = {})

fun main(args: Array<String>) {
    val config = Config()
    val add = Add()

    with(args) {
        when {
            isEmpty() || get(0) == "--help" -> println(HELP)
            get(0) == "config" -> {
                if (size > 1) config.name = get(1) else config.name
            }
            get(0) == "add" -> {
                if (size > 1) add.apply(get(1)) else add.text
            }
            commandDescriptions.containsKey(get(0)) -> println(commandDescriptions[get(0)])
            else -> println("'${args[0]}' $WRONG_COMMAND")
        }
    }
}