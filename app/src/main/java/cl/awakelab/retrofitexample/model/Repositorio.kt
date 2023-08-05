package cl.awakelab.retrofitexample.model

import androidx.lifecycle.LiveData
import cl.awakelab.retrofitexample.model.local.TerrenoDao
import cl.awakelab.retrofitexample.model.local.TerrenoEntity
import cl.awakelab.retrofitexample.model.remote.Terreno
import cl.awakelab.retrofitexample.model.remote.TerrenoAPI

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

    fun obtenerTerreno(id: String): LiveData<TerrenoEntity> = terrenoDao.getTerreno(id)

}

fun Terreno.transformar(): TerrenoEntity = TerrenoEntity(this.id, this.price, this.type, this.img)

