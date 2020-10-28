package com.romcy.androidcertification.fragment

import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.google.android.material.snackbar.Snackbar
import com.romcy.androidcertification.R

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class AndroidCoreFragment : Fragment() {

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_core, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<Button>(R.id.button_first).setOnClickListener {
            findNavController().navigate(R.id.action_core_to_data_management)
        }

        view.findViewById<Button>(R.id.toast).setOnClickListener{
            showToast(view)
        }
        view.findViewById<Button>(R.id.snackBar).setOnClickListener{
            showSnackBar(view)
        }
    }

    private fun showSnackBar(view: View) {
        val snackBar = Snackbar.make(view, "This is Simple Snackbar", Snackbar.LENGTH_SHORT)
        snackBar.show()
    }


    private fun showToast(view: View) {
        val inflater = layoutInflater
        val container = activity?.findViewById<ViewGroup>(R.id.custom_toast_container)
        val layout= inflater.inflate(R.layout.custom_toast, container) as ViewGroup
        val text: TextView = layout.findViewById(R.id.text)
        text.text = getString(R.string.custom_toast_description)
        with (Toast(activity?.applicationContext)) {
            setGravity(Gravity.BOTTOM, 0, 0)
            duration = Toast.LENGTH_LONG
            setView(layout)
            show()
        }
    }

}