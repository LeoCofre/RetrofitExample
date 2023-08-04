package cl.awakelab.retrofitexample.data.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface TerrenoDao {

    @Insert
    suspend fun insertarTerreno(terrenoEntity: TerrenoEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE )
    suspend fun insertarTerrenos(terrenosEntity: List<TerrenoEntity>)

    @Query("Select * from tabla_terreno order by id asc")
    fun obtenerTerrenos(): LiveData<List<TerrenoEntity>>
}