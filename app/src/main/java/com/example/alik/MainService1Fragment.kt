package com.example.alik

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.Spinner
import android.widget.TextView
import com.example.alik.appCoustomSitting.cToast
import com.example.alik.models.*


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
//private const val ARG_PARAM1 = "param1"
//private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Activities that contain this fragment must implement the
 * [MainService1Fragment.OnFragmentInteractionListener] interface
 * to handle interaction events.
 * Use the [MainService1Fragment.newInstance] factory method to
 * create an instance of this fragment.
 *
 */
class MainService1Fragment : Fragment() {

    lateinit var myServiceActivity: MyServiceActivity
    var changeListener: ChangeCostString? = null
    lateinit var speedSpinner: Spinner
    lateinit var speedSpinner1: Spinner
    lateinit var periodSpinner: Spinner
    lateinit var limitSpinner: Spinner
    lateinit var speedAdapterS: StatusAdapter
    lateinit var speedAdapterS1: StatusAdapter
    lateinit var periodAdapterS: StatusAdapter
    lateinit var limitAdapterS: StatusAdapter
    lateinit var serviceRecycle: RecyclerView
    var speedSelectedValue: StatusBean? = null
    var periodSelectedValue: StatusBean? = null
    var limitSelectedValue: StatusBean? = null
    var limitB = false
    var periodB = false
    var speedB = false
    lateinit var recAdapter:MyRecycleAdapter


    fun refreshAdapter() {
        myServiceActivity.changeExistingWithConst()

        limitAdapterS.dataChanger(myServiceActivity.limitsList)
        limitSpinner.setSelection(Math.max(limitAdapterS.getPosition(limitSelectedValue), 0))

        speedAdapterS1.dataChanger(myServiceActivity.speedList1)

        speedSpinner1.setSelection(Math.max(speedAdapterS1.getPosition(speedSelectedValue), 0))

        periodAdapterS.dataChanger(myServiceActivity.peroidList)

        periodSpinner.setSelection(Math.max(periodAdapterS.getPosition(periodSelectedValue), 0))

    }

    fun refreshAdapter1() {
        limitAdapterS.dataChanger(myServiceActivity.limitsList)
        var code = myServiceActivity.filterMap[myServiceActivity.HEAD_SIZE]
        var po = try {
            var w = 0
            limitAdapterS.statuses.mapIndexed { i, v ->
                if (v.statusCode.equals(code)) {
                    w = i
                }
            }
            w
        } catch (ex: Exception) {
            0
        }
        limitSpinner.setSelection(1)
        speedAdapterS1.dataChanger(myServiceActivity.speedList1)
        code = myServiceActivity.filterMap[myServiceActivity.HEAD_SPEED]
        po = try {
            var w = 0
            speedAdapterS1.statuses.mapIndexed { i, v ->
                if (v.statusCode.equals(code)) {
                    w = i
                }
            }
            w
        } catch (ex: Exception) {
            0
        }
        speedSpinner1.setSelection(po)
        periodAdapterS.dataChanger(myServiceActivity.peroidList)
        code = myServiceActivity.filterMap[myServiceActivity.HEAD_PERIOD]
        po = try {
            var w = 0
            periodAdapterS.statuses.mapIndexed { i, v ->
                if (v.statusCode.equals(code)) {
                    w = i
                }
            }
            w
        } catch (ex: Exception) {
            0
        }
        periodSpinner.setSelection(po)

    }

    fun createAdapter() {
        speedAdapterS = StatusAdapter(
            myServiceActivity.contexService,
            R.layout.spinner_items_row, myServiceActivity.speedList,
            myServiceActivity.res,
            myServiceActivity.HEAD_SPEED
        );
        limitAdapterS = StatusAdapter(
            myServiceActivity.contexService,
            R.layout.spinner_items_row, myServiceActivity.limitsList,
            myServiceActivity.res,
            myServiceActivity.HEAD_SIZE
        );
        speedAdapterS1 = StatusAdapter(
            myServiceActivity.contexService,
            R.layout.spinner_items_row, myServiceActivity.speedList1,
            myServiceActivity.res,
            myServiceActivity.HEAD_SPEED
        );
        periodAdapterS = StatusAdapter(
            myServiceActivity.contexService,
            R.layout.spinner_items_row, myServiceActivity.peroidList,
            myServiceActivity.res,
            myServiceActivity.HEAD_PERIOD
        );
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val v = inflater.inflate(R.layout.fragment_main_service1, container, false)
        myServiceActivity = activity as MyServiceActivity
        speedSpinner = v.findViewById<Spinner>(R.id.speedSpinner)
        speedSpinner1 = v.findViewById<Spinner>(R.id.speedSpinner1)
        periodSpinner = v.findViewById<Spinner>(R.id.periadSpinner)
        limitSpinner = v.findViewById<Spinner>(R.id.traficSpinner)
        serviceRecycle = v.findViewById<RecyclerView>(R.id.serviceRecycle)
        serviceRecycle.layoutManager = LinearLayoutManager(myServiceActivity.contexService)
        recAdapter=MyRecycleAdapter(
            myServiceActivity.inflater,
            myServiceActivity.serviceCompany!!,
            serviceRecycle,
            v.findViewById<TextView>(R.id.notAccessTextView),
            resources.getDrawable(R.drawable.line_borders_g),
            resources.getDrawable(R.drawable.line_borders),
            object : RecycleServiceIdListener {
                override fun serviceIdListener(id: Int,cost:Long) {
                    if(id>=0||cost>=0){
                        myServiceActivity.serviceId = id
                        myServiceActivity.totalCost -= myServiceActivity.serviceCost
                        myServiceActivity.serviceCost=cost
                        myServiceActivity.totalCost += myServiceActivity.serviceCost
                    }else{
                        myServiceActivity.serviceId = -1
                        myServiceActivity.totalCost -= myServiceActivity.serviceCost
                        myServiceActivity.serviceCost=0
                    }
                    changeListener!!.changeCost(myServiceActivity.HEAD_COST + myServiceActivity.totalCost.toString() + myServiceActivity.HEAD_UNIT_COST)
                }
            }
        )
        serviceRecycle.adapter = recAdapter
        createAdapter()
        speedSpinner.adapter = speedAdapterS
        speedSpinner1.adapter = speedAdapterS1
        periodSpinner.adapter = periodAdapterS
        limitSpinner.adapter = limitAdapterS
        try {

            speedSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
                override fun onNothingSelected(parent: AdapterView<*>?) {

                }

                override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                        if (position > 0) {
                        myServiceActivity.serviceId = myServiceActivity.speedList[position - 1].statusId
                        myServiceActivity.totalCost -= myServiceActivity.serviceCost
                        myServiceActivity.serviceCost = try {
                            (myServiceActivity.speedList[position - 1].statusCode).toLong()
                        } catch (ex: Exception) {
                            cToast(myServiceActivity.contexService, "دریافت اطلاعات نادرست")
                            0
                        }
                        myServiceActivity.stringServices = myServiceActivity.speedList[position - 1].status
                        if (myServiceActivity.firstTime) {
                            myServiceActivity.serviceCost = 0;
                            myServiceActivity.totalCost = 0
                            myServiceActivity.firstTime = false
                            myServiceActivity.stringServices = ""
                        }
                        myServiceActivity.totalCost += myServiceActivity.serviceCost
                            changeListener!!.changeCost(myServiceActivity.HEAD_COST + myServiceActivity.totalCost.toString() + myServiceActivity.HEAD_UNIT_COST)
                    }
                }
            }

            periodSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
                override fun onNothingSelected(parent: AdapterView<*>?) {

                }

                override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                               if(position>0){
                                   val item = myServiceActivity.peroidList[position - 1].statusCode
                                   myServiceActivity.filterMap.put(myServiceActivity.HEAD_PERIOD,item)
                                   myServiceActivity.changeExistingWithConst()
                                   recAdapter.changeListModel(myServiceActivity!!.serviceCompany!!)
                               }else{
                                   myServiceActivity.filterMap.put(myServiceActivity.HEAD_PERIOD,"")
                                   myServiceActivity.changeExistingWithConst()
                                   recAdapter.changeListModel(myServiceActivity!!.serviceCompany!!)
                               }

                }
            }
            speedSpinner1.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
                override fun onNothingSelected(parent: AdapterView<*>?) {

                }

                override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {

                               if(position>0){
                                   val item = myServiceActivity.speedList1[position - 1].statusCode
                                   myServiceActivity.filterMap.put(myServiceActivity.HEAD_SPEED, item)
                                   myServiceActivity.changeExistingWithConst()
                                   recAdapter.changeListModel(myServiceActivity!!.serviceCompany!!)
                               }else{
                                   myServiceActivity.filterMap.put(myServiceActivity.HEAD_SPEED, "")
                                   myServiceActivity.changeExistingWithConst()
                                   recAdapter.changeListModel(myServiceActivity!!.serviceCompany!!)
                               }
                }
            }
            limitSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
                override fun onNothingSelected(parent: AdapterView<*>?) {

                }

                override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {

                             if(position>0){
                                 val item = myServiceActivity.limitsList[position - 1].statusCode
                                 myServiceActivity.filterMap.put(myServiceActivity.HEAD_SIZE, item)
                                 myServiceActivity.changeExistingWithConst()
                                 recAdapter.changeListModel(myServiceActivity!!.serviceCompany!!)
                             }else{
                                 myServiceActivity.filterMap.put(myServiceActivity.HEAD_SIZE, "")
                                 myServiceActivity.changeExistingWithConst()
                                 recAdapter.changeListModel(myServiceActivity!!.serviceCompany!!)
                             }
                }
            }
        } catch (ex: Exception) {

        }

        return v
    }
}
