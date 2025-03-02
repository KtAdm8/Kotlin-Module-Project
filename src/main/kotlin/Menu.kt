import java.util.Scanner

abstract class Menu<T>(
    private val items: List<T>,
    private val title: String,
    private val itemName: (T) -> String,
    protected var onSelect: (Int) -> Unit
) {
    protected val scanner = Scanner(System.`in`)

    fun show() {
        while (true) {
            println("\n$title")
            items.forEachIndexed { index, item -> println("$index. ${itemName(item)}") }
            println("${items.size}. ${Messages.CREATE.text}")
            println("${items.size + 1}. ${Messages.EXIT.text}")

            when (val choice = getUserInput()) {
                null -> println(Messages.ERROR_INVALID_OPTION.text)
                items.size -> onCreate()
                items.size + 1 -> return
                in items.indices -> onSelect(choice)
                else -> println(Messages.ERROR_INVALID_OPTION.text)
            }
        }
    }

    private fun getUserInput(): Int? {
        val input = scanner.nextLine()
        return if (input.isBlank() || !input.all { it.isDigit() }) null else input.toInt()
    }

    protected open fun onCreate() {}

    fun getInput(prompt: String, errorMessage: String, allowBlank: Boolean = false): String {
        while (true) {
            print(prompt)
            val input = scanner.nextLine().trim()
            if (input.isNotBlank() || allowBlank) return input
            println(errorMessage)
        }
    }
}
