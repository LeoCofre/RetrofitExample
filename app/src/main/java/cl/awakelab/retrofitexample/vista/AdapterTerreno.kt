package cl.awakelab.retrofitexample.vista

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import cl.awakelab.retrofitexample.R
import cl.awakelab.retrofitexample.data.local.TerrenoEntity
import cl.awakelab.retrofitexample.data.remote.Terreno
import cl.awakelab.retrofitexample.databinding.ItemLayoutBinding
import coil.load

class AdapterTerreno : RecyclerView.Adapter<AdapterTerreno.ViewHolder>() {

    lateinit var binding: ItemLayoutBinding
    private val listItemTerreno = mutableListOf<TerrenoEntity>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        binding = ItemLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)

    }

    override fun getItemCount(): Int {
        return listItemTerreno.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val terreno = listItemTerreno[position]
        holder.bind(terreno)
    }

    fun setData(terreno: List<TerrenoEntity>) {
        this.listItemTerreno.clear()
        this.listItemTerreno.addAll(terreno)
        notifyDataSetChanged()
    }

    inner class ViewHolder(val binding: ItemLayoutBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(terreno: TerrenoEntity) {
            binding.imgItem.load(terreno.imagen)
            binding.imgItem.setOnClickListener{
                binding.imgItem.setOnClickListener{
                    //Pasamos los valores en el bundle
                    val bundle = Bundle()
                   // bundle.putString("tipo",terreno.tipo)
                    bundle.putString("imagen", terreno.imagen)
                    bundle.putString("precio",terreno.precio.toString())
                    Navigation.findNavController(binding.root).navigate(R.id.action_listadoTerrenos_to_detalleFragment)
                }

            }
        }
    }
}