package com.example.expoculturalaplha.ui.gallery

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.expoculturalaplha.R
import com.example.expoculturalaplha.databinding.FragmentGalleryBinding

class GalleryFragment : Fragment() {

    private var _binding: FragmentGalleryBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val galleryViewModel = ViewModelProvider(this).get(GalleryViewModel::class.java)

        // Infla o layout do fragmento
        _binding = FragmentGalleryBinding.inflate(inflater, container, false)
        val root: View = binding.root


        galleryViewModel.text.observe(viewLifecycleOwner) { text ->
            binding.textGallery.text = text
        }


        val buttonVoltar: Button = binding.root.findViewById(R.id.button_voltar)
        buttonVoltar.setOnClickListener {
            findNavController().navigate(R.id.nav_home)
        }

        return root
    }



    override fun onDestroyView() {
        super.onDestroyView()
        // Limpa o binding quando a view é destruída
        _binding = null
    }
}
