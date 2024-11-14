package com.example.expoculturalaplha.ui.obras

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.expoculturalaplha.R
import com.example.expoculturalaplha.databinding.FragmentObrasBinding

class ObrasFragment : Fragment() {

    private var _binding: FragmentObrasBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val obrasViewModel = ViewModelProvider(this).get(ObrasViewModel::class.java)
        _binding = FragmentObrasBinding.inflate(inflater, container, false)

        val buttonVoltar: Button = binding.buttonVoltar
        buttonVoltar.setOnClickListener {
            findNavController().navigate(R.id.nav_home) // Navegar para o HomeFragment
        }

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
