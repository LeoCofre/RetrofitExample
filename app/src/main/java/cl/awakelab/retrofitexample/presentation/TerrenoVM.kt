package cl.awakelab.retrofitexample.presentation

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import cl.awakelab.retrofitexample.data.Repositorio
import cl.awakelab.retrofitexample.data.remote.RetrofitClient
import kotlinx.coroutines.launch

class TerrenoVM(applicacion: Application) : AndroidViewModel(applicacion) {

    //

    private val repositorio: Repositorio

    init {
        val api = RetrofitClient.getRetrofitClient()
        repositorio = Repositorio(api)
    }

    fun getAllTerrenos() = viewModelScope.launch{
        repositorio.cargarTerreno()
    }
}