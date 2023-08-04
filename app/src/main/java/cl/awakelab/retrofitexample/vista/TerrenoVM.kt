package cl.awakelab.retrofitexample.vista

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import cl.awakelab.retrofitexample.data.Repositorio
import cl.awakelab.retrofitexample.data.local.TerrenoDatabase
import cl.awakelab.retrofitexample.data.remote.RetrofitClient
import cl.awakelab.retrofitexample.data.remote.Terreno
import kotlinx.coroutines.launch

class TerrenoVM(applicacion: Application) : AndroidViewModel(applicacion) {

    fun terrenosLiveData() = repositorio.obtenerTerrenos()

    private val repositorio: Repositorio

    init {
        val api = RetrofitClient.getRetrofitClient()
        val terrenoDatabase = TerrenoDatabase.getDataBase(applicacion).getITerrenoDao()
        repositorio = Repositorio(api, terrenoDatabase)
    }

    fun getAllTerrenos() = viewModelScope.launch {
        repositorio.cargarTerreno()
    }
}