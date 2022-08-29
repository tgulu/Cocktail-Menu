package com.example.cocktail_menu.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.cocktail_menu.databinding.DrinkDetailsFragmentBinding
import com.example.cocktail_menu.viewmodel.DrinkViewModel
import com.squareup.picasso.Picasso
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

class DrinkDetailFragment : Fragment() {

    private val viewModel: DrinkViewModel by sharedViewModel()

    private val binding by lazy {
        DrinkDetailsFragmentBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        // Inflate the layout for this fragment

        viewModel.fragmentDetail
            .observe(viewLifecycleOwner) { set ->
                binding.drinkTitle.text = set?.strDrink

                //binding.ArtDescription.text = set.description.toString()

                var description = set?.strInstructions ?: ""
                binding.drinkDetail.text = description.toString()

                Picasso.get()
                    .load(set?.strDrinkThumb)
                    .fit()
                    //.resize(1000, 1000)
                    .into(binding.drinkImage)
            }

        return binding.root
    }


    companion object {
        @JvmStatic
        fun newInstance() =
            BaseFragment()
    }

}

