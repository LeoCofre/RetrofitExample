package cl.awakelab.retrofitexample.model.remote

import com.google.gson.annotations.SerializedName

data class Terreno(
    val id: String,
    val price: Int,
    val type: String,
    @SerializedName("img_src") val img: String
)