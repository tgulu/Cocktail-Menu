package com.example.cocktail_menu.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.R
import androidx.navigation.fragment.findNavController
import com.example.cocktail_menu.databinding.BaseFragBinding

//import com.example.artmuseumapp.R
//import com.example.artmuseumapp.databinding.FragmentInitialBinding

class BaseFragment : Fragment() {

    private val binding by lazy {
        BaseFragBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        binding.initialButton.setOnClickListener{
            findNavController()
                .navigate(R.id.)
               // .navigate(R.id.action_initialFragment_to_recyclerViewFragment)
        }


        return binding.root
    }

    companion object {
        @JvmStatic
        fun newInstance() =
            BaseFragment()
    }
}