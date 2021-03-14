package com.example.trivia

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.*
import androidx.fragment.app.Fragment
import androidx.core.app.ShareCompat
import androidx.navigation.findNavController
import com.example.trivia.databinding.FragmentGameWonBinding

class GameWonFragment : Fragment() {
    private var _binding: FragmentGameWonBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentGameWonBinding.inflate(inflater, container, false)
        val root: View = binding.root
        binding.nextMatchButton.setOnClickListener{view: View->
            view.findNavController().navigate(GameWonFragmentDirections.actionGameWonFragmentToNavGame());
        }
        setHasOptionsMenu(true)
        return root
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
    private fun getShareIntent() : Intent {
        val argValue = GameWonFragmentArgs.fromBundle(requireArguments())
        var text: String = argValue.text;
        Log.e("test", text);
        return ShareCompat.IntentBuilder.from(requireActivity())
            .setText(text)
            .setType("text/plain")
            .intent
    }
    private fun shareSuccess() {
        startActivity(getShareIntent())
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.winner_share_menu, menu)
        // check if the activity resolves
        if (null == getShareIntent().resolveActivity(requireActivity().packageManager)) {
            // hide the menu item if it doesn't resolve
            menu.findItem(R.id.share)?.isVisible = false
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.share -> shareSuccess()
        }
        return super.onOptionsItemSelected(item)
    }
}