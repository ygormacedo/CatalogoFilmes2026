package data.model.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Movie(
    val id: Int,
    val title: String,

    @SerialName("poster_path")
    val posterPath: String? = null,

    @SerialName("overview")
    val overview: String = ""
)