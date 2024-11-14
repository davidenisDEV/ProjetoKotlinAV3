package com.example.expoculturalaplha.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.expoculturalaplha.MainActivity
import com.example.expoculturalaplha.R
import com.example.expoculturalaplha.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val homeViewModel = ViewModelProvider(this).get(HomeViewModel::class.java)

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        binding.imageButtongaleria.setOnClickListener {
            irParaGaleria()
        }

        binding.imageButtonobras.setOnClickListener {
            irParaObras()
        }

        binding.imageButtonconquistas.setOnClickListener {
            irParaConquistas()
        }

        binding.imageButtonpesquisa.setOnClickListener {
            irParaPesquisa()
        }

        return root
    }

   private fun irParaPesquisa(){
       findNavController().navigate(R.id.nav_pesquisa)
   }


    private fun irParaObras() {
        findNavController().navigate(R.id.nav_obras)
    }

    private fun irParaConquistas() {
        findNavController().navigate(R.id.nav_slideshow)
    }

    private fun irParaGaleria() {
        findNavController().navigate(R.id.nav_gallery)
    }

    private fun fecharMenu() {
        (activity as? MainActivity)?.binding?.drawerLayout?.close()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
