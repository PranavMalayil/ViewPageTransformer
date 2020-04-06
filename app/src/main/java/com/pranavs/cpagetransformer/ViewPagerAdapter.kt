package com.pranavs.cpagetransformer

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.pranavs.cpagetransformer.fragments.*

class ViewPagerAdapter(fm: FragmentManager, behavior: Int) : FragmentStatePagerAdapter(fm, behavior) {


    var mList: MutableList<Fragment> = ArrayList()
    init {
        mList.add(FragmentOne())
        mList.add(FragfmentTwo())
        mList.add(FragmentThree())
        mList.add(FragmentFour())
        mList.add(FragfmentFive())
    }



    override fun getItem(position: Int): Fragment {
        return mList[position]
    }

    override fun getCount(): Int {
        return mList.size
    }


}