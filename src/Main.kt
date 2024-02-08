import java.util.*

fun main() {
    val scanner = Scanner(System.`in`)
    var choice: Int

    do {
        val fiveSeater = FiveSeater()
        val eightSeater = EightSeater()

        println("Welcome to the Car Management System!")
        println("Select an option:")
        println("1. Manage 5-seater cars")
        println("2. Manage 8-seater cars")
        println("3. Exit")

        when (scanner.nextInt()) {
            1 -> {
                println("You chose to manage 5-seater cars.")
                fiveSeater.accessAndPrint()
            }
            2 -> {
                println("You chose to manage 8-seater cars.")
                eightSeater.accessAndPrint()
            }
            3 -> {
                println("Exiting the program. Goodbye!")
                return
            }
            else -> println("Invalid choice.")
        }

        println("Do you want to execute another command? (1 for Yes, 0 for No): ")
        choice = scanner.nextInt()
    } while (choice != 0)

    // Close scanner to prevent resource leak
    scanner.close()
}
