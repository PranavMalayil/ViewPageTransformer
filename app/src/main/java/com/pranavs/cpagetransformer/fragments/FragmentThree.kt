package com.pranavs.cpagetransformer.fragments

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.pranavs.cpagetransformer.R
import kotlinx.android.synthetic.main.fragment_layout.*

class FragmentThree:Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_layout, container, false)
    }
    @SuppressLint("SetTextI18n")
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        lytRoot.setBackgroundColor(ContextCompat.getColor(context!!, R.color.mt_blue))
        textView.text="Fragment three"
    }

}