package cl.awakelab.retrofitexample.vista

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import cl.awakelab.retrofitexample.databinding.FragmentListadoTerrenosBinding
import cl.awakelab.retrofitexample.view_model.TerrenoVM


class ListadoTerrenos : Fragment() {

    lateinit var binding: FragmentListadoTerrenosBinding
    private val terrenoVM: TerrenoVM by activityViewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentListadoTerrenosBinding.inflate(layoutInflater, container, false)
        initAdapter()
        binding.btnCargar.setOnClickListener {
            terrenoVM.getAllTerrenos()
        }

        return binding.root
    }

    private fun initAdapter() {
        terrenoVM.getAllTerrenos()
        val adapter = AdapterTerreno()
        binding.rvListado.adapter = adapter
        terrenoVM.terrenosLiveData().observe(viewLifecycleOwner) {
            adapter.setData(it)
        }
    }
}