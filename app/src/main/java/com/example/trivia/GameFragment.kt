package com.example.trivia

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import com.example.trivia.databinding.FragmentGameBinding

class GameFragment : Fragment() {
    private var check : Boolean = false;
    private var _binding: FragmentGameBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentGameBinding.inflate(inflater, container, false);
        val root: View = binding.root;

        if ( check ) {
            binding.submitButton.setOnClickListener{view: View ->
                view.findNavController().navigate(GameFragmentDirections.actionNavGameToNavGameOver());
            }
        } else {
            binding.submitButton.setOnClickListener{view: View ->
                view.findNavController().navigate(GameFragmentDirections.actionNavGameToGameWonFragment(12, "Hello no world"));
            }
        }


        return root;
    }
}