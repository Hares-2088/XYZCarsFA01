import java.io.File
import java.io.FileWriter
import java.util.*

class EightSeater : XYZ() {

    fun accessAndPrint() {
        println("Do you want to print data or add a new car? (Enter 'print' or 'add')")
        val choice = readLine()?.trim()
        when (choice) {
            "print" -> printData()
            "add" -> addNewCar()
            else -> println("Invalid choice.")
        }
    }

    private fun printData() {
        println("Do you want to print data on console or in a file? (Enter 'console' or 'file')")
        val choice = readLine()?.trim()
        when (choice) {
            "console" -> {
                println("Printing data on console:")
                for ((index, car) in eightSeatsCars.withIndex()) {
                    println("Car ${index + 1}: $car")
                }
            }
            "file" -> printInFile()
            else -> println("Invalid choice.")
        }
    }

    private fun printInFile() {
        println("Enter the file name to save the data:")
        val fileName = readLine()?.trim()
        if (fileName.isNullOrEmpty()) {
            println("Invalid file name.")
            return
        }
        val file = File(fileName)
        try {
            if (!file.exists()) {
                println("File doesn't exist. Do you want to create a new file? (yes/no)")
                val createNewFileChoice = readLine()?.trim()?.toLowerCase()
                if (createNewFileChoice == "yes") {
                    file.createNewFile()
                } else {
                    println("Operation cancelled.")
                    return
                }
            }
            FileWriter(file).use { writer ->
                writer.write("Printing data in file:\n")
                for ((index, car) in eightSeatsCars.withIndex()) {
                    writer.write("Car ${index + 1}: $car\n")
                }
                println("Data printed successfully in file: $fileName")
            }
        } catch (e: Exception) {
            println("Error occurred while writing to file: ${e.message}.")
        }
    }

    private fun addNewCar() {
        val read = Scanner(System.`in`)
        println("Enter details of the new car:")
        println("Year:")
        val year = read.nextInt()
        println("Model:")
        val model = read.next() // Use next() instead of nextLine() to read the next token without consuming the newline character
        println("Length:")
        val length = read.nextDouble()
        println("Height:")
        val height = read.nextDouble()
        println("Cargo Space:")
        val cargoSpace = read.nextDouble()

        val newCar = EightSeaterCar(year, model, length, height, cargoSpace)
        eightSeatsCars = eightSeatsCars.copyOf(eightSeatsCars.size + 1)
        eightSeatsCars[eightSeatsCars.size - 1] = newCar
        println("New car added successfully!")
    }
}
