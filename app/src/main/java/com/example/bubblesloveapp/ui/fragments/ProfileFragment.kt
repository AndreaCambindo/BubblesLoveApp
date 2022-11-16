package com.example.bubblesloveapp.ui.fragments

import android.content.ActivityNotFoundException
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.bubblesloveapp.CAMERA_PERMISSION_CODE
import com.example.bubblesloveapp.REQUEST_IMAGE_CODE
import com.example.bubblesloveapp.checkPermission
import com.example.bubblesloveapp.databinding.FragmentProfileBinding
import com.example.bubblesloveapp.ui.activities.LoginActivity

class ProfileFragment : Fragment() {

    private var _binding: FragmentProfileBinding?= null
    private val binding: FragmentProfileBinding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater , container: ViewGroup? ,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentProfileBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onStart() {
        super.onStart()
        binding.profileFragmentLogout.setOnClickListener {
            val intent = Intent(requireContext() , LoginActivity::class.java)
            startActivity(intent)
            requireActivity().finish()
        }

        binding.profileFragmentImage.setOnClickListener {
            if (checkPermission(android.Manifest.permission.CAMERA, CAMERA_PERMISSION_CODE)){
                openCamera()
            }
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int ,
        permissions: Array<out String> ,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode , permissions , grantResults)
        if (requestCode == CAMERA_PERMISSION_CODE && grantResults[0] == PackageManager.PERMISSION_GRANTED){
            openCamera()
        }
    }

    override fun onActivityResult(requestCode: Int , resultCode: Int , data: Intent?) {
        super.onActivityResult(requestCode , resultCode , data)
        if (requestCode == REQUEST_IMAGE_CODE){
            val extras = data!!.extras
            val image = extras!!["data"] as Bitmap?
            binding.profileFragmentImage.setImageBitmap(image)
        }
    }

    private fun openCamera(){
        val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        try {
            startActivityForResult(intent, REQUEST_IMAGE_CODE)
        } catch (e: ActivityNotFoundException){
            Log.d("HOLA", e.message.toString())
        }
    }


}



