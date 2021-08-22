package com.w4eret1ckrtb1tch.app32.temp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.w4eret1ckrtb1tch.app32.BR
import com.w4eret1ckrtb1tch.app32.R
import com.w4eret1ckrtb1tch.app32.databinding.FragmentOneBinding

class OneFragment : Fragment() {


    private lateinit var binding: FragmentOneBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        //binding = FragmentOneBinding.inflate(inflater, container, false)
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_one, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.text2 = "DataBinding"
        binding.visibility2 = true
        //QUESTION зачем выполнять этот метод?
        // Этот метод необходимо вызывать если все поля модели данных были изменены
        binding.notifyPropertyChanged(BR.text2)
        binding.notifyPropertyChanged(BR.visibility2)

        binding.button1.setOnClickListener {
            Toast.makeText(requireActivity(), "ViewBinding Fragment", Toast.LENGTH_SHORT).show()
            binding.visibility1 = false
        }

        binding.button2.setOnClickListener {
            binding.text2 = getString(R.string.button2)
        }
    }

}