package com.example.bubblesloveapp.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.bubblesloveapp.ui.adapters.PlanAdapter
import com.example.bubblesloveapp.data.models.PlanItemModel
import com.example.bubblesloveapp.R
import com.example.bubblesloveapp.data.models.ServiceItemModel
import com.example.bubblesloveapp.databinding.FragmentCitaBinding

class CitaFragment : Fragment() {

    private var _binding: FragmentCitaBinding?= null
    private val binding: FragmentCitaBinding get() = _binding!!
    private val args: CitaFragmentArgs by navArgs()
    private lateinit var planAdapter: PlanAdapter
    private lateinit var categories: MutableList<String>

    override fun onCreateView(
        inflater: LayoutInflater , container: ViewGroup? ,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentCitaBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onStart() {
        super.onStart()
        planAdapter = PlanAdapter(listOf())
        binding.homeFragmentRecycler.apply {
            adapter = planAdapter
            layoutManager = LinearLayoutManager(context)
        }
        val categorias = listOf(
            ServiceItemModel(
                "1", "Románticas", "citas para no parar de suspirar de amor",
                R.drawable.corazon.toString()
            ) ,
            ServiceItemModel(
                "2", "Picantes", "citas para dejar volar la imaginación",
                R.drawable.llama.toString()
            ) ,
            ServiceItemModel(
                "3", "En casita", "citas para cuando hay pereza y no se quiere salir",
                R.drawable.casa.toString()
            ) ,
            ServiceItemModel(
                "4", "Retadoras", "citas para afrontar y apoyarse mutuamente",
                R.drawable.bomba.toString()
            ) ,
            ServiceItemModel(
                "5", "Al aire libre", "citas para conectar con la naturaleza y recargarse",
                R.drawable.natural.toString()
            ) ,
            ServiceItemModel(
                "6", "Divertidas", "citas para no parar de reir y disfrutar",
                R.drawable.divertidas.toString()
            ) ,
            ServiceItemModel(
                "7", "De experiencias", "citas para siempre recordar",
                R.drawable.experiencias.toString()
            )
        )
        categories = categorias.map {it.title}.toMutableList()
        categories.add(0,"Todos")
        val planes = listOf(
            PlanItemModel("1", "Testeando Traguitos", "Picantes", R.drawable.citaimage.toString(),
                "Hagan una lista de bares y vayan a tomarse un trago distinto en cada bar") ,
            PlanItemModel("2", "Noche de pasión", "Picantes", R.drawable.citaimage.toString(),
                "Escojan un hotel o motel, lo que el pudor los deje, usen algo sexy") ,
            PlanItemModel("3", "Fiesta privada", "Románticas", R.drawable.citaimage.toString(),
                "¿Casa sola? Aprovechen para variar y hagan una fiesta para dos, compren") ,
            PlanItemModel("4", "Rumba sin testigos", "Retadoras", R.drawable.citaimage.toString(),
                "Vayan a la discoteca que más les guste solos; ¿solos?, ¡sí!, ¡solos!.")
        )
        if(args.search){
            binding.citaFragmentRecyclerSearchLayout.visibility = View.VISIBLE
            binding.citaFragmentRecyclerTitle.visibility = View.GONE
            binding.citaFragmentTittle.text = getString(R.string.cita_tittle)
            binding.citaFragmentSubtittle.text = getString(R.string.cita_subtittle)
            planAdapter.updateDataSet(planes)
            binding.citaFragmentRecyclerSearch.setAdapter(ArrayAdapter(requireContext(), android.R.layout.simple_dropdown_item_1line, categories))
            binding.citaFragmentRecyclerSearch.setOnItemClickListener { parent, view, position, id ->
                if(position==0){
                    planAdapter.updateDataSet(planes)
                }else{
                    val category = categories[position]
                    planAdapter.updateDataSet(planes.filter { it -> it.categoria == category })
                }
            }
        } else {
            binding.citaFragmentRecyclerSearchLayout.visibility = View.GONE
            binding.citaFragmentRecyclerTitle.visibility = View.VISIBLE
            binding.citaFragmentTittle.text = args.name
            binding.citaFragmentSubtittle.text = args.description
            planAdapter.updateDataSet(planes.filter { it -> it.categoria ==args.name })
        }
    }
}