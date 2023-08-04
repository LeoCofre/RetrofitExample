package cl.awakelab.retrofitexample.vista

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
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
        }
    }
}