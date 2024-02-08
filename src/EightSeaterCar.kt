class EightSeaterCar(
    var year: Int,
    var model: String,
    var length: Double,
    var height: Double,
    var cargoSpace: Double
) {

    override fun toString(): String {
        return """
            Year: $year
            Model: $model
            Length: $length meters
            Height: $height meters
            Cargo Space: $cargoSpace meters
        """.trimIndent()
    }
}