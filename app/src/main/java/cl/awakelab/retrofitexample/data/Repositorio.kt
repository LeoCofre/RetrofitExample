package cl.awakelab.retrofitexample.data

import androidx.lifecycle.LiveData
import cl.awakelab.retrofitexample.data.local.TerrenoDao
import cl.awakelab.retrofitexample.data.local.TerrenoEntity
import cl.awakelab.retrofitexample.data.remote.Terreno
import cl.awakelab.retrofitexample.data.remote.TerrenoAPI

class Repositorio(private val terrenoAPI: TerrenoAPI, private val terrenoDao: TerrenoDao) {

    fun obtenerTerrenos(): LiveData<List<TerrenoEntity>> = terrenoDao.obtenerTerrenos()

    suspend fun cargarTerreno() {
        val response = terrenoAPI.getData()

        if (response.isSuccessful) {
            val resp = response.body()
            resp?.let { terrenos ->
                val terrenoEntity = terrenos.map { it.transformar() }
                terrenoDao.insertarTerrenos(terrenoEntity)
            }
        }
    }
}

fun Terreno.transformar(): TerrenoEntity = TerrenoEntity(this.id, this.price, this.type, this.img)