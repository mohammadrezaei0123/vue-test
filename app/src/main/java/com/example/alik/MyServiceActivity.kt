package com.example.alik

import android.content.Context
import android.content.Intent
import android.content.res.Resources
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import com.example.alik.appCoustomSitting.*
import com.example.alik.models.*
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.android.synthetic.main.activity_my_service.*

class MyServiceActivity : AppCompatActivity(), ChangeCostString {
    val HEAD = " مورد نظر خود را انتخاب کنید" + " : "
    val HEAD_SIZE = "لطفاً حداکثر حجم " + HEAD
    val HEAD_SPEED = "لطفاً سرعت " + HEAD
    val HEAD_PERIOD = "لطفاً زمان " + HEAD
    val HEAD_COST = "مقدار قابل پرداخت" + " : "
    val CONST_SPEED = 1
    val CONST_PERIOD = 2
    val CONST_SIZE = 4
    var currentFilter = 0
    val HEAD_UNIT_COST = " ریال"
    var serviceId: Int = -1
    var totalCost: Long = 0
    var serviceCost: Long = 0
    var firstTime = true
    var firstTimeTime = true
    var firstTimeSize = true
    var firstTimeSpeed = true
    var users1: User? = null
    var serviceCompany: List<Package>? = null
    var serviceCompany1: List<Package>? = null
    var existsservise: List<Modem>? = null
    var stringServices = ""
    lateinit var adapterMode: ModemAdapter
    lateinit var res: Resources
    lateinit var speedList: ArrayList<StatusBean>
    lateinit var peroidList: ArrayList<StatusBean>
    lateinit var limitsList: ArrayList<StatusBean>
    lateinit var speedList1: ArrayList<StatusBean>
    lateinit var contexService: Context
    lateinit var inflater: LayoutInflater
    var filterMap: HashMap<String, String>
    var sour: Int = -1


    init {
        filterMap = HashMap()
        filterMap.put(HEAD_SPEED, "")
        filterMap.put(HEAD_PERIOD, "")
        filterMap.put(HEAD_SIZE, "")
    }

    override fun changeCost(text: String) {
        costText.text = text
    }

    override fun onBackPressed() {
        val intent = Intent(this, MainPanelActivity::class.java)
        intent.putExtra(USER_KEY, Gson().toJson(users1))
        startActivity(intent)
        finish()
    }

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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_service)
        val st = intent.getStringExtra(USER_KEY)
        users1 = try {
            Gson().fromJson<User>(st, User::class.java)
        } catch (ex: java.lang.Exception) {
            null
        }
        if (users1 == null) {
            cToast(this, "خروج به دلیل " + "دریافت اطلاعات نامعتبر")
            finish()
        }

        costText.text = """${HEAD_COST} : 0""" + HEAD_UNIT_COST
        castingJson(intent.getStringExtra(SERVICE_KEY))
        existsservise = try {
            Gson().fromJson<List<Modem>>(intent.getStringExtra(MODEM_KEY), object : TypeToken<List<Modem>>() {}.type)
        } catch (ex: java.lang.Exception) {
            null
        }
        if(existsservise!!.size==0){
            cToast(this, "خروج به دلیل " + "دریافت اطلاعات نامعتبر")
            finish()
        }
        if (serviceCompany!!.size == 0) {
            finish()
        }
//        else {
//            existsservise = serviceCompany!!.existsservise
//        }

        res = getResources();
        sour = R.layout.spinner_items_row
        contexService = this
        inflater = getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        createAdapters()

        adapterMode = ModemAdapter(existsservise!!, this, object : ModemAdapter.ModemSelected {
            override fun costModemSelected(modems: Modem) {
                totalCost += if (modems.isModemCheched) {
//                    0
                    (modems.price)
//                    ((modems.costGood) * (modems.unitCostGoods))
                } else {
                    -1*(modems.price)
//                    0
//                    -1 * ((modems.costGood) * (modems.unitCostGoods))
                }
                costText.text = HEAD_COST + (totalCost) + HEAD_UNIT_COST
            }
        })

        servicePager.adapter = ServicePagerAdapter(supportFragmentManager, this, this)
        servicePager.currentItem = 1
        acceptAndGo.setOnClickListener {
            if(serviceId>=0){
                val serviceCompa=serviceCompany!!.filter { it.id==serviceId }[0]
                try {
                    val wq = "حجم قابل استفاده "
                    val str = """
                    ${serviceCompa.bandwidth} ${getUnitStringFromid(1)}-${serviceCompa.time}${"ماه"}(${wq}${serviceCompa.traffic}${getUnitTagFromid(
                        0
                    )})
                    """.trimIndent()
                    stringServices=str
                }catch (ex:Exception){

                }

            }
            if (stringServices.trim().length > 1) {
                val inten = Intent(this, PruchBasketActivity::class.java)
                inten.putExtra(USER_KEY, Gson().toJson(users1))
                inten.putExtra("idService", serviceId.toString())
                inten.putExtra("stringServ", stringServices)
                inten.putExtra("" +
                        "",costText.text.toString())
                var arr = ArrayList<Modem>()
                adapterMode.modems.map {
                    if (it.isModemCheched) {
                        arr.add(it)
                    }
                }
                inten.putExtra("listUrls", arr)
                inten.putExtra("moneyCost", totalCost)
                inten.putExtra("title",HEAD_COST + (totalCost) + HEAD_UNIT_COST)
//            progressLinnerservice.visibility=View.VISIBLE
//            val map=HashMap<String,String>();
//            map.put("idUser",users1!!.idUser.toString())
//            map.put("idService",serviceId.toString())
//            createPostRequest("service",this,map)
                startActivity(inten)
                finish()
            }
        }

    }

    private fun chackSpeed(existsservise: Package): Boolean {
        val speed = filterMap[HEAD_SPEED]
        val costs = """
                    ${existsservise.bandwidth}+${getUnitStringFromid(1)}
                    """.trimIndent()
        return speed.equals(costs)||speed==costs||speed!!.length<3
    }

    private fun checkLimit(existsservise: Package): Boolean {
        val limit = filterMap[HEAD_SIZE]
        val costs = """
                    ${existsservise.traffic}+${getUnitTagFromid(0)}
                    """.trimIndent()
        return limit.equals(costs)||limit==costs||limit!!.length<3
    }
    private fun checkPeriod(existsservise: Package):Boolean{
        val per = filterMap[HEAD_PERIOD]
        val costs = """${existsservise.time}+${"ماه"}"""
        return per.equals(costs)||per==costs||per!!.length<3
    }

    fun changeExistingWithConst() {
        serviceCompany=serviceCompany1!!.filter {
            checkLimit(it)&&checkPeriod(it)&&chackSpeed(it)
        }
    }

//    fun changeExistingWithConst1() {
//        when(currentFilter){
//            0->{
//                existsservise=serviceCompany!!.existsservise
//            }
//            1->{
//                existsservise=serviceCompany!!.existsservise.filter {
//                    chackSpeed(it)
//                }
//            }
//            2->{
//                existsservise=serviceCompany!!.existsservise.filter {
//                    checkPeriod(it)
//                }
//            }
//            3->{
//                existsservise=serviceCompany!!.existsservise.filter {
//                    checkPeriod(it)&&chackSpeed(it)
//                }
//            }
//            4->{
//                existsservise=serviceCompany!!.existsservise.filter {
//                    checkLimit(it)
//                }
//            }
//            5->{
//                existsservise=serviceCompany!!.existsservise.filter {
//                    checkLimit(it)&&chackSpeed(it)
//                }
//            }
//            6->{
//                existsservise=serviceCompany!!.existsservise.filter {
//                    checkLimit(it)&&checkPeriod(it)
//                }
//            }
//            7->{
//                existsservise=serviceCompany!!.existsservise.filter {
//                    checkLimit(it)&&checkPeriod(it)&&chackSpeed(it)
//                }
//            }
//            else->{
//                existsservise=serviceCompany!!.existsservise
//            }
//        }
//        createAdapters()
//    }

//    fun createAdapters() {
//        speedList = try {
//            serviceCompany!!.mapIndexed { index, serviceCompany ->
//                val wq = "حجم قابل استفاده "
//                val str = """
//                    ${serviceCompany.numSpeed} ${getUnitStringFromid(serviceCompany.unitSpeed)}-${serviceCompany.numPeriod}${serviceCompany.nameUnitPeriod}(${wq}${serviceCompany.numLimit}${getUnitTagFromid(
//                    serviceCompany.unitLimit
//                )})
//                    """.trimIndent()
//                val costs = serviceCompany.numCost * serviceCompany.unitCost
//                StatusBean(serviceCompany.idCreatedService, str, costs.toString())
//            } as ArrayList<StatusBean>
//        } catch (ex: Exception) {
//            ArrayList<StatusBean>()
//        }
//        speedList1 = try {
//            existsservise!!.mapIndexed { index, serviceCompany ->
//                val wq = "حجم قابل استفاده "
//                val str = """
//                    ${serviceCompany.numSpeed} ${getUnitStringFromid(serviceCompany.unitSpeed)}
//                    """.trimIndent()
//                val costs = """
//                    ${serviceCompany.numSpeed}+${serviceCompany.unitSpeed}
//                    """.trimIndent()
//                StatusBean(serviceCompany.idCreatedService, str, costs)
//            }.distinctBy {
//                it.status
//            } as ArrayList<StatusBean>
//        } catch (ex: Exception) {
//            ArrayList<StatusBean>()
//        }
//        limitsList = try {
//            existsservise!!.mapIndexed { index, serviceCompany ->
//                val str = """
//                    ${serviceCompany.finalLimit} ${getUnitTagFromid(serviceCompany.unitLimit)}
//                    """.trimIndent()
//                val costs = """
//                    ${serviceCompany.finalLimit}+${serviceCompany.unitLimit}
//                    """.trimIndent()
//                StatusBean(serviceCompany.idCreatedService, str, costs)
//            }.distinctBy {
//                it.status
//            } as ArrayList<StatusBean>
//        } catch (ex: Exception) {
//            ArrayList<StatusBean>()
//        }
//        peroidList = try {
//            existsservise!!.mapIndexed { index, serviceCompany ->
//                val wq = "حجم قابل استفاده "
//                val str = """
//                    ${serviceCompany.numPeriod} ${serviceCompany.nameUnitPeriod}
//                    """.trimIndent()
//                val costs = """${serviceCompany.numPeriod}+${serviceCompany.nameUnitPeriod}"""
//                StatusBean(serviceCompany.idCreatedService, str, costs)
//            }.distinctBy {
//                it.status
//            } as ArrayList<StatusBean>
//        } catch (ex: Exception) {
//            ArrayList<StatusBean>()
//        }
//    }
fun createAdapters() {
    speedList = try {
        serviceCompany!!.mapIndexed { index, serviceCompany ->
            val wq = "حجم قابل استفاده "
            val str = """
                    ${serviceCompany.bandwidth} ${getUnitStringFromid(1)}-${serviceCompany.time}${"ماه"}(${wq}${serviceCompany.traffic}${getUnitTagFromid(
                0
            )})
                    """.trimIndent()
            val costs = serviceCompany.price
            StatusBean(serviceCompany.id, str, costs.toString())
        } as ArrayList<StatusBean>
    } catch (ex: Exception) {
        ArrayList<StatusBean>()
    }
    speedList1 = try {
        serviceCompany!!.mapIndexed { index, serviceCompany ->
            val wq = "حجم قابل استفاده "
            val str = """
                    ${serviceCompany.bandwidth} ${getUnitStringFromid(1)}
                    """.trimIndent()
            val costs = """
                    ${serviceCompany.bandwidth}+${getUnitStringFromid(1)}
                    """.trimIndent()
            StatusBean(serviceCompany.id, str, costs)
        }.distinctBy {
            it.status
        } as ArrayList<StatusBean>
    } catch (ex: Exception) {
        ArrayList<StatusBean>()
    }
    limitsList = try {
        serviceCompany!!.mapIndexed { index, serviceCompany ->
            val str = """
                    ${serviceCompany.traffic} ${getUnitTagFromid(0)}
                    """.trimIndent()
            val costs = """
                    ${serviceCompany.traffic}+${getUnitTagFromid(0)}
                    """.trimIndent()
            StatusBean(serviceCompany.id, str, costs)
        }.distinctBy {
            it.status
        } as ArrayList<StatusBean>
    } catch (ex: Exception) {
        ArrayList<StatusBean>()
    }
    peroidList = try {
        serviceCompany!!.mapIndexed { index, serviceCompany ->
            val wq = "حجم قابل استفاده "
            val str = """
                    ${serviceCompany.time} ${"ماه"}
                    """.trimIndent()
            val costs = """${serviceCompany.time}+${"ماه"}"""
            StatusBean(serviceCompany.id, str, costs)
        }.distinctBy {
            it.status
        } as ArrayList<StatusBean>
    } catch (ex: Exception) {
        ArrayList<StatusBean>()
    }
}
    fun castingJson(json: String) {
        serviceCompany = try {
            Gson().fromJson<List<Package>>(json, object : TypeToken<List<Package>>() {}.type)
        } catch (ex: java.lang.Exception) {
            null
        }
        serviceCompany1 = try {
            Gson().fromJson<List<Package>>(json, object : TypeToken<List<Package>>() {}.type)
        } catch (ex: java.lang.Exception) {
            null
        }
        if (serviceCompany != null) {

        } else {
            cToast(this, "خروج به دلیل " + "دریافت اطلاعات نامعتبر")
            finish()
        }
    }


}
