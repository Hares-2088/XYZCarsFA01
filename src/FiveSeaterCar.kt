class FiveSeaterCar(
    var year: Int = 0,
    var model: String = "",
    var length: Double = 0.0,
    var height: Double = 0.0,
    var engineSize: Double = 0.0,
    var numberOfDoors: Int = 0
){
    override fun toString(): String {
        return """
            Year: $year
            Model: $model
            Length: $length meters
            Height: $height meters
            Engine Size: $engineSize liters
            Number of Doors: $numberOfDoors
        """.trimIndent()
    }
}