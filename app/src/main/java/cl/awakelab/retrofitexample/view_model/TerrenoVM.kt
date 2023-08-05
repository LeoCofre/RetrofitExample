package cl.awakelab.retrofitexample.view_model

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import cl.awakelab.retrofitexample.model.Repositorio
import cl.awakelab.retrofitexample.model.local.TerrenoDatabase
import cl.awakelab.retrofitexample.model.remote.RetrofitClient
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

    fun terrenoLiveData(id: String) = repositorio.obtenerTerreno(id)
}