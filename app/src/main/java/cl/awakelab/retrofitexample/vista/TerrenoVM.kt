package cl.awakelab.retrofitexample.vista

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import cl.awakelab.retrofitexample.data.Repositorio
import cl.awakelab.retrofitexample.data.remote.RetrofitClient
import cl.awakelab.retrofitexample.data.remote.Terreno
import kotlinx.coroutines.launch

class TerrenoVM(applicacion: Application) : AndroidViewModel(applicacion) {

    val terrenosLiveData = MutableLiveData<List<Terreno>>()

    private val repositorio: Repositorio

    init {
        val api = RetrofitClient.getRetrofitClient()
        repositorio = Repositorio(api)
    }

    fun getAllTerrenos() = viewModelScope.launch{
        terrenosLiveData.value = repositorio.cargarTerreno()
    }
}