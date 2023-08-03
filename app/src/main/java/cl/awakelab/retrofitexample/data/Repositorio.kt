package cl.awakelab.retrofitexample.data

import cl.awakelab.retrofitexample.data.remote.Terreno
import cl.awakelab.retrofitexample.data.remote.TerrenoAPI

class Repositorio(private val terrenoAPI: TerrenoAPI) {

    suspend fun cargarTerreno(): List<Terreno> {
        val response = terrenoAPI.getData()

        if (response.isSuccessful) {
            val resp = response.body()
            resp?.let {
                return it
            }
        }
        return emptyList()
    }
}