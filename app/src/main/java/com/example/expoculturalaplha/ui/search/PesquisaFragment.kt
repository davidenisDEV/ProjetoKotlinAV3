package com.example.expoculturalaplha.ui.search

import androidx.fragment.app.viewModels
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController
import com.example.expoculturalaplha.R
import com.example.expoculturalaplha.databinding.FragmentPesquisaBinding

class PesquisaFragment : Fragment() {

    private var _binding: FragmentPesquisaBinding? = null
    private val binding get() = _binding!!

    private val viewModel: PesquisaViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentPesquisaBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val buttonVoltar: Button = binding.buttonVoltar
        buttonVoltar.setOnClickListener {
            findNavController().navigate(R.id.nav_home)
        }

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
