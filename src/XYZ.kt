import java.io.File

 open class XYZ {
    var fiveSeatsCars = arrayOfNulls<FiveSeaterCar>(0)
    var eightSeatsCars = arrayOfNulls<EightSeaterCar>(0)

    init {
        readFromFile5("C:\\Users\\ademb\\IdeaProjects\\Mobile App\\XYZCars\\src\\5seater.txt")
        readFromFile8("C:\\Users\\ademb\\IdeaProjects\\Mobile App\\XYZCars\\src\\8seater.txt")
    }

    fun readFromFile5(path: String) {
        val file = File(path)
        val lines = file.readLines()

        fiveSeatsCars = Array(lines.size - 1) { index ->
            val tokens = lines[index + 1].split(" ")
            FiveSeaterCar(
                tokens[0].toInt(),
                tokens[1],
                tokens[2].toDouble(),
                tokens[3].toDouble(),
                tokens[4].toDouble(),
                tokens[5].toInt()
            )
        }
    }

    fun readFromFile8(path: String) {
        val file = File(path)
        val lines = file.readLines()
        eightSeatsCars = Array(lines.size - 1) { index ->
            val tokens = lines[index + 1].split(" ")
            EightSeaterCar(
                tokens[0].toInt(),
                tokens[1],
                tokens[2].toDouble(),
                tokens[3].toDouble(),
                tokens[4].toDouble()
            )
        }

    }

    fun calculateVehicleType(): List<String> {
        val vehicleTypes = mutableListOf<String>()

        for (car in fiveSeatsCars) {
            car?.let {
                val type = if (it.height > 5.5) "SUV" else "Sedan car"
                vehicleTypes.add(type)
            }
        }

        return vehicleTypes
    }

    override fun toString(): String {
        return "XYZ(fiveSeatsCars=${fiveSeatsCars.contentToString()}, eightSeatsCars=${eightSeatsCars.contentToString()})"
    }
}
