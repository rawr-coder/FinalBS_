package com.example.finalbs_.ui.addlocation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.finalbs_.databinding.FragmentAddlocationBinding
import com.example.finalbs_.databinding.FragmentWattcalcBinding

class wattcalcFragment : Fragment() {

    private var _binding: FragmentWattcalcBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val wattcalcViewModel =
            ViewModelProvider(this).get(wattcalcViewModel::class.java)

        _binding = FragmentWattcalcBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textNotifications
        wattcalcViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}