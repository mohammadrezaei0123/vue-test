package com.example.alik


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.GridView
import com.example.alik.models.ChangeCostString
import com.example.alik.models.Good
import com.example.alik.models.ModemAdapter


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
//private const val ARG_PARAM1 = "param1"
//private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 *
 */
class Modems1Fragment : Fragment() {


    lateinit var myServiceActivity: MyServiceActivity
    var changeListener: ChangeCostString?=null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val v= inflater.inflate(R.layout.fragment_modems1, container, false)
        myServiceActivity=activity as MyServiceActivity
        val modemGrid=v.findViewById<GridView>(R.id.modemGrid)
        val modemCheck=v.findViewById<CheckBox>(R.id.modemCheck)
        val configCheck=v.findViewById<CheckBox>(R.id.configCheck)
        modemGrid.adapter = myServiceActivity.adapterMode
        modemCheck.setOnClickListener {
            if (modemCheck.isChecked) {
                modemGrid.visibility = View.VISIBLE
            } else {
                modemGrid.visibility = View.GONE
            }
        }
        configCheck.setOnClickListener {
            if (configCheck.isChecked) {
                myServiceActivity.totalCost += 30000
            } else {
                myServiceActivity.totalCost -= 30000
            }
            changeListener!!.changeCost(myServiceActivity.HEAD_COST + myServiceActivity.totalCost.toString() + myServiceActivity.HEAD_UNIT_COST)
        }
        return v
    }


}
