package io.techministry.android.missionchurch.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import io.techministry.android.missionchurch.databinding.FragmentConnectBinding

class ConnectFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val binding = FragmentConnectBinding.inflate(inflater,
            container,false)
        return binding.root
//        return super.onCreateView(inflater, container, savedInstanceState)
    }

    init {
        Log.d("LIFECYCLE", "{${this.javaClass.simpleName}} Class Created")
    }
}