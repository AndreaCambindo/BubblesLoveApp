package com.example.bubblesloveapp.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.bubblesloveapp.R
import com.example.bubblesloveapp.databinding.FragmentLugaresBinding
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

class LugaresFragment : Fragment(), OnMapReadyCallback {

    private var _binding: FragmentLugaresBinding?= null
    private val binding: FragmentLugaresBinding get() = _binding!!
    private lateinit var mMap: GoogleMap

    override fun onCreateView(
        inflater: LayoutInflater , container: ViewGroup? ,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentLugaresBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onStart() {
        super.onStart()
        val mapFragment: SupportMapFragment = childFragmentManager.findFragmentById(R.id.fragment_lugares_map) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }

    override fun onMapReady(map: GoogleMap) {
        mMap = map
        mMap.uiSettings.isZoomControlsEnabled = true
        mMap.isTrafficEnabled = true
        //latitud 6.219065380218608, -75.57237238934292
        val latLng = LatLng(6.219065380218608, -75.57237238934292)
        map.addMarker(MarkerOptions().position(latLng).title(getString(R.string.app_name)))
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng,14.0f))
    }
}