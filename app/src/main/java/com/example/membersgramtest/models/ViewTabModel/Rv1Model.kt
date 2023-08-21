sealed class Rv1Model {

    data class Rv1BodyModel(
        val count_post: Int,
        var isSelected: Boolean = false // Adding the isSelected field with a default value
    ) : Rv1Model()
}
