package com.example.bubblesloveapp.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.bubblesloveapp.R
import com.example.bubblesloveapp.ui.adapters.ServiceAdapter
import com.example.bubblesloveapp.data.models.ServiceItemModel
import com.example.bubblesloveapp.databinding.FragmentHomeBinding
import com.example.bubblesloveapp.interfaces.onServiceClickListener

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding?= null
    private val binding: FragmentHomeBinding get() = _binding!!
    private lateinit var serviceAdapter: ServiceAdapter

    override fun onCreateView(
        inflater: LayoutInflater , container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentHomeBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onStart() {
        super.onStart()
        serviceAdapter = ServiceAdapter(listOf(
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
        ))
        serviceAdapter.listener = object : onServiceClickListener {
            override fun onClick(item: ServiceItemModel) {
                val direction =
                    com.example.bubblesloveapp.HomeFragmentDirections.actionHomeFragmentToCitaFragment()
                direction.name = item.title
                direction.description = item.description
                direction.search = false
                findNavController().navigate(direction)
            }
        }
        binding.homeFragmentRecycler.apply {
            adapter = serviceAdapter
            layoutManager = LinearLayoutManager(requireContext())
        }
    }
}