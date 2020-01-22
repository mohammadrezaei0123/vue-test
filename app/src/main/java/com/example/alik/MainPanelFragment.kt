package com.example.alik


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView
import com.anychart.AnyChart
import com.anychart.AnyChartView
import com.anychart.chart.common.dataentry.ValueDataEntry
import com.anychart.enums.Anchor
import com.anychart.enums.HoverMode
import com.anychart.enums.Position
import com.anychart.enums.TooltipPositionMode
import com.example.alik.appCoustomSitting.perisanNumber
import com.example.alik.models.Computerunit
import com.example.alik.models.Package
import com.example.alik.models.ProfileUser


/**
 * A simple [Fragment] subclass.
 *
 */
class MainPanelFragment : Fragment() {

    lateinit var mainActivity: UserPanelActivity
    lateinit var serviceCompany:Package
    lateinit var anyChartView:AnyChartView

    fun getUnitStringFromid(id: Int): String {
        if (id==1) {
            return "مگابایت"
//            return computerUnit.findLast {
//                it.idComputerUnit == id
//            }!!.nameUnit
        } else {
            return "گیگا بایت"
        }
    }

    fun getUnitTagFromid(id: Int): String {
        if (id==1) {
            return "mb"
//            return computerUnit.findLast {
//                it.idComputerUnit == id
//            }!!.nameUnit
        } else {
            return "gb"
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val v=inflater.inflate(R.layout.fragment_main_panel, container, false)
        mainActivity=activity as UserPanelActivity
        anyChartView=v.findViewById<AnyChartView>(R.id.anyChartView)
        anyChartView.setProgressBar(v.findViewById<ProgressBar>(R.id.progress_bar))
        v.findViewById<TextView>(R.id.usernameTexts).text=mainActivity.users1!!.user
//        computerUnit=mainActivity.computerUnit
        serviceCompany=mainActivity.serviceCompany!!
        val wq = "حجم قابل استفاده "
//        val x=if(serviceCompany!!.idUnitPeriod==2){"ماه"}else{"سال"}
        val str = """
                    ${serviceCompany!!.bandwidth} ${getUnitStringFromid(1)}-${serviceCompany!!.time}${"ماه"}(${wq}${serviceCompany!!.traffic}${getUnitTagFromid(
            0
        )})
                    """.trimIndent()
        v.findViewById<TextView>(R.id.serviceTexts).text=str
        createChart()
        v.findViewById<Button>(R.id.accepteUserPanelButton1).setOnClickListener {

                mainActivity.onBackPressed()
        }
        return v
    }

    private fun createChart(){



        val cartesian = AnyChart.column()
        val data:List<ValueDataEntry> = listOf(
            (ValueDataEntry("1398.03.01", 80540)),
            (ValueDataEntry("1398.03.02", 94190)),
            (ValueDataEntry("1398.03.03", 102610)),
            (ValueDataEntry("1398.03.04", 110430)),
            (ValueDataEntry("1398.03.05", 128000)),
            (ValueDataEntry("1398.03.01", 80540)),
            (ValueDataEntry("1398.03.06", 143760)),
            (ValueDataEntry("1398.03.07", 170670)),
            (ValueDataEntry("1398.03.08", 213210)),
            (ValueDataEntry("1398.03.09", 249980))
        )

//      (ValueDataEntry(perisanNumber("1398.03.01"), 80540)),
//      (ValueDataEntry(perisanNumber("1398.03.02"), 94190)),
//      (ValueDataEntry(perisanNumber("1398.03.03"), 102610)),
//      (ValueDataEntry(perisanNumber("1398.03.04"), 110430)),
//      (ValueDataEntry(perisanNumber("1398.03.05"), 128000)),
//      (ValueDataEntry(perisanNumber("1398.03.01"), 80540)),
//      (ValueDataEntry(perisanNumber("1398.03.06"), 143760)),
//      (ValueDataEntry(perisanNumber("1398.03.07"), 170670)),
//      (ValueDataEntry(perisanNumber("1398.03.08"), 213210)),
//      (ValueDataEntry(perisanNumber("1398.03.09"), 249980))

        val column = cartesian.column(data)

        column.tooltip()
            .titleFormat("{%X}")
            .position(Position.CENTER_BOTTOM)
            .anchor(Anchor.CENTER_BOTTOM)
            .offsetX(0.0)
            .offsetY(5.0)
            .format(perisanNumber("\${%Value}{groupsSeparator: }"))

        cartesian.animation(true)
        cartesian.title("نمودار ریز مصرف")

        cartesian.yScale().minimum(0.0)

//        cartesian.yAxis(0).labels().format(perisanNumber("\${%Value}{groupsSeparator: }"))

        cartesian.tooltip().positionMode(TooltipPositionMode.POINT)
        cartesian.interactivity().hoverMode(HoverMode.BY_X)

        cartesian.xAxis(0).title("تاریخ")
        cartesian.yAxis(0).title("میزان مصرف")
        anyChartView.background=resources.getDrawable(R.drawable.draws_back)
        anyChartView.setChart(cartesian)

    }
}
