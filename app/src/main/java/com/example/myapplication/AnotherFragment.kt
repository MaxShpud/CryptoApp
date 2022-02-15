package com.example.myapplication

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

class AnotherFragment : Fragment() {

    var name: String = ""

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.another_fragment, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        arguments?.let {
            name = it.getString(FRAGMENT_KEY, "22222")
        }
    }

    companion object {
        private const val FRAGMENT_KEY = "FRAGMENT_KEY"

        fun newInstance(name: String): AnotherFragment {
            val fragment = AnotherFragment()
            val bundle = Bundle()
            bundle.putString(FRAGMENT_KEY, name)
            fragment.arguments = bundle
            return fragment
        }
    }
}