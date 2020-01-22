package com.example.alik.models

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.content.res.Resources
import android.graphics.drawable.Drawable
import android.opengl.Visibility
import android.support.constraint.ConstraintLayout
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonArrayRequest
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.NetworkImageView
import com.example.alik.*
import com.example.alik.appCoustomSitting.MySingleton
import com.example.alik.appCoustomSitting.baseAppUrl
import com.example.alik.appCoustomSitting.cToast
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

//class MySpinnerAdapter1(var values: ArrayList<String>, val contex: Context):SpinnerAdapter{
//    override fun isEmpty(): Boolean =values.isEmpty()
//
//    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
//        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
//    }
//
//    override fun registerDataSetObserver(observer: DataSetObserver?) {
//        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
//    }
//
//    override fun getItemViewType(position: Int): Int {
//        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
//    }
//
//    override fun getItem(position: Int): Any {
//        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
//    }
//
//    override fun getViewTypeCount(): Int {
//        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
//    }
//
//    override fun getItemId(position: Int): Long {
//        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
//    }
//
//    override fun hasStableIds(): Boolean {
//        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
//    }
//
//    override fun getDropDownView(position: Int, convertView: View?, parent: ViewGroup?): View {
//        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
//    }
//
//    override fun unregisterDataSetObserver(observer: DataSetObserver?) {
//        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
//    }
//
//    override fun getCount(): Int {
//        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
//    }
//}
class Holders(itemView:View):RecyclerView.ViewHolder(itemView){
    val speedText:TextView
    val limitValuItem:TextView
    val timeValuItem:TextView
    val costValuItem:TextView
    val mainConstrainLayout:ConstraintLayout
    val acceptValueButton:Button
    var isDelete:Boolean
    init {
        speedText = itemView.findViewById<TextView>(R.id.speedValuItem)
        limitValuItem = itemView.findViewById<TextView>(R.id.limitValuItem)
        timeValuItem = itemView.findViewById<TextView>(R.id.timeValuItem)
        costValuItem=itemView.findViewById<TextView>(R.id.costValuItem)
        acceptValueButton=itemView.findViewById<Button>(R.id.chooseButton)
        mainConstrainLayout=itemView.findViewById<ConstraintLayout>(R.id.recMainConstraint)
        isDelete = false
    }

//    fun chooceMode() {
//
//        isDelete = false
//        chooOrDele.setBackgroundColor(resources.getColor(R.color.green_12))
//        chooOrDele.text = "انتخاب"
//        chooOrDele.setTextColor(resources.getColor(R.color.withe_1))
//    }
//
//    fun deleteMode() {
//        isDelete = true
//        chooOrDele.setBackgroundColor(resources.getColor(R.color.red_1))
//        chooOrDele.text = "حذف"
//        chooOrDele.setTextColor(resources.getColor(R.color.withe_1))
//    }
}
class Holders1(itemView:View):RecyclerView.ViewHolder(itemView){
    val nameValuItem1:TextView
    val familyValuItem1:TextView
    val usernsmeValuItem1:TextView
    val phoneValuItem1:TextView
    val mainConstrainLayout:ConstraintLayout
    val acceptValueButton:Button
    var isDelete:Boolean
    init {
        nameValuItem1 = itemView.findViewById<TextView>(R.id.nameValuItem1)
        familyValuItem1 = itemView.findViewById<TextView>(R.id.familyValuItem1)
        usernsmeValuItem1 = itemView.findViewById<TextView>(R.id.usernsmeValuItem1)
        phoneValuItem1=itemView.findViewById<TextView>(R.id.phoneValuItem1)
        acceptValueButton=itemView.findViewById<Button>(R.id.chooseButton1)
        mainConstrainLayout=itemView.findViewById<ConstraintLayout>(R.id.recMainConstraint1)
        isDelete = false
    }

//    fun chooceMode() {
//
//        isDelete = false
//        chooOrDele.setBackgroundColor(resources.getColor(R.color.green_12))
//        chooOrDele.text = "انتخاب"
//        chooOrDele.setTextColor(resources.getColor(R.color.withe_1))
//    }
//
//    fun deleteMode() {
//        isDelete = true
//        chooOrDele.setBackgroundColor(resources.getColor(R.color.red_1))
//        chooOrDele.text = "حذف"
//        chooOrDele.setTextColor(resources.getColor(R.color.withe_1))
//    }
}
interface RecycleServiceIdListener{
    fun serviceIdListener(id:Int,cost:Long)
}
class MyRecycleAdapter(var inflater: LayoutInflater,
                       var services:List<Package>
                       ,val recycler:RecyclerView,
                       val textNoFound:TextView,
                       val chooseDrable:Drawable,
                       val notChooseDrable:Drawable,
                       var recycleListeners:RecycleServiceIdListener): RecyclerView.Adapter<Holders>() {
    var serviceIdAdapter=-10
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): Holders {
        val view = inflater.inflate(R.layout.recy_row_item, p0, false)
        val myHoldeler = Holders(view)
        addListeners(view, myHoldeler, p1)
        return myHoldeler
    }


    private fun addListeners(view: View, p0: Holders, p1: Int) {
//        view.setBackgroundColor(resources.getColor(R.color.green_12))
        view.setOnClickListener {
            var position = recycler.getChildLayoutPosition(it)
            if(serviceIdAdapter==services[position].id) {
                serviceIdAdapter = -10
                p0.acceptValueButton.text="انتخاب"
                p0.mainConstrainLayout.background=notChooseDrable
                recycleListeners.serviceIdListener(
                    -1,
                    (services[position].price*-1).toLong()
                )
            }else {
                serviceIdAdapter = services[position].id
                p0.acceptValueButton.text="حذف"
                p0.mainConstrainLayout.background=chooseDrable
                recycleListeners.serviceIdListener(
                    services[position].id,
                    services[position].price.toLong()
                )
            }
            notifyDataSetChanged()
//            forChangeModes(services[position], myHoldeler, true)
        }
    }

    override fun getItemCount(): Int = services.size


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
    override fun onBindViewHolder(p0: Holders, p1: Int) {
        val p: Package = services[p1]
        p0.speedText.text = p.bandwidth.toString()+" "+getUnitTagFromid(1)
        p0.costValuItem.text = p.price.toString()+" "+"ریال"
        p0.limitValuItem.text = p.traffic.toString()+" "+getUnitTagFromid(0)
//                    ${serviceCompany.finalLimit} ${getUnitTagFromid(serviceCompany.unitLimit)}
//                    """
        if(p.id==serviceIdAdapter){
            p0.acceptValueButton.text="حذف"
            p0.mainConstrainLayout.background=chooseDrable
        }else{
            p0.acceptValueButton.text="انتخاب"
            p0.mainConstrainLayout.background=notChooseDrable
        }
        p0.acceptValueButton.setOnClickListener {
            if( serviceIdAdapter==services[p1].id){
                serviceIdAdapter=-10
                p0.acceptValueButton.text="حذف"
                p0.mainConstrainLayout.background=chooseDrable
                recycleListeners.serviceIdListener(-1,(-1*services[p1].price).toLong())
            }else{
                serviceIdAdapter=services[p1].id
                p0.acceptValueButton.text="حذف"
                p0.mainConstrainLayout.background=chooseDrable
                recycleListeners.serviceIdListener(services[p1].id,services[p1].price.toLong())}
            notifyDataSetChanged()
        }
        p0.timeValuItem.text=p.time.toString()+" "+"ماه"
//        forChangeModes(p, p0, false)
//        p0.chooOrDele.setOnClickListener {
//            forChangeModes(p, p0, true)
//        }
    }

    private fun forChangeModes(p: Existsservise, h: Holders?, b: Boolean) {
        //        if (b) {
//            if (p.ischoose) {
//                p.ischoose = false
//                mapPiece.remove(p.idPiece)
//                h!!.layotCard.setBackgroundColor(resources.getColor(R.color.green_12))
//                h!!.chooceMode()
//            } else {
//                p.ischoose = true
//                try {
//                    mapPiece.put(p.idPiece, p.atterNeedModels1!![0].valueAttribute.minNeed)
//                } catch (ex: Exception) {
//                }
//                h!!.layotCard.setBackgroundColor(resources.getColor(R.color.red_1))
//                h!!.deleteMode()
//            }
//            checkAttrMatch(p)
//        }
//
//        if (p.ischoose) {
//            h!!.layotCard.setBackgroundColor(resources.getColor(R.color.green_12))
//        } else {
//            h!!.layotCard.setBackgroundColor(resources.getColor(R.color.red_1))
//        }
//
//
    }
    fun changeListModel(list: List<Package>) {
//            listModel.listPiece.clear()
//    var l = ListPeice(list)
        if(list.size>0){
            recycler.visibility=View.VISIBLE
            textNoFound.visibility=View.GONE
        }else{
            recycler.visibility=View.GONE
            textNoFound.visibility=View.VISIBLE
        }
        services = list
        notifyDataSetChanged()
    }
//        fun checkAttrMatch(piece: PieceModel): Boolean {
//            var list3=allMainPiece.filter { it.ischoose }
//            val list1 = ArrayList<Needs1.MinNeed>()
//            mapPiece.values.forEach {
//                list1.addAll(it)
//            }
//            try {
//                for (r in list3){
//                    val list2 = list1.filter {
//                        it.idBrunch == r.idBrunch
//                    }
//                    for (k in r.listAttributes!!) {
//                        for (i in list2) {
//                            for (j in i.values) {
////                                StaticForAll.toastMyMessage(this@PieceMatch2Activity,
////                                        j.key + "  " + j.value + " - " + k.keyAttribute + " " + k.valueAttribute.valueAttribute)
//                                if (j.key == k.keyAttribute) {
//                                    val v1 = k.valueAttribute.valueAttribute.toDoubleOrNull()
//                                    val v = j.value.toDoubleOrNull()
//                                    if (v == null || v1 == null) {
////                                        StaticForAll.toastMyMessage(this@PieceMatch2Activity, "st " +
////                                                "" + j.value + " " + k.valueAttribute.valueAttribute)
////                                        if (j.value.equals(k.valueAttribute.valueAttribute)) {
////                                            StaticForAll.toastMyMessage(this@PieceMatch2Activity, "yes")
////                                        }
//                                    } else {
////                                        StaticForAll.toastMyMessage(this@PieceMatch2Activity, "num" + v!!.compareTo(v1!!))
//                                        if (v!!.compareTo(v1!!) > 0) {
//                                            piece.ischoose=false
//                                            forChangeModes(piece,null,false)
////                                            StaticForAll.toastMyMessage(this@PieceMatch2Activity, "yes")
//                                            return false
//                                        }
//                                    }
//                                }
//                            }
//                        }
//                    }
//
//                }
//
//
////                for (r in list3){
////                    for (rr in r.listAttributes!!){
////                        if(piece)
////                    }
////                }
//            } catch (ex: Exception) {
//                StaticForAll.toastMyMessage(this@PieceMatch2Activity,"my bababababsd")
//            }
//
////            try {
////                var list1 = mapPiece.values.filter { it.idBrunch == piece.idBrunch }
////                for (i in piece.listAttributes!!) {
////                    for (j in list1[0].values) {
////                        if (i.keyAttribute == j.key) {
////                            StaticForAll.toastMyMessage(this@PieceMatch2Activity, j.key + "  " + j.value)
////                        }
////                    }
////                }
////            }catch (ex:Exception){
////
////            }
//
//
//            return false
//        }


}
class MyRecycleAdapter1(var inflater: LayoutInflater,
                       var services:ArrayList<User>
                       ,val recycler:RecyclerView,
    val contex: Context
//                        ,
//                       val textNoFound:TextView,
//                       val chooseDrable:Drawable,
//                       val notChooseDrable:Drawable,
//                       var recycleListeners:RecycleServiceIdListener
): RecyclerView.Adapter<Holders1>() {
    var serviceIdAdapter=-10
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): Holders1 {
        val view = inflater.inflate(R.layout.rec_row_item_manager, p0, false)
        val myHoldeler = Holders1(view)
        addListeners(view, myHoldeler, p1)
        return myHoldeler
    }


    private fun addListeners(view: View, p0: Holders1, p1: Int) {
//        view.setBackgroundColor(resources.getColor(R.color.green_12))
        view.setOnClickListener {
            var position = recycler.getChildLayoutPosition(it)
            createRequest(services[position].id)
            services.remove(services[position])






//            if(serviceIdAdapter==services[position].id) {
//                serviceIdAdapter = -10
//                p0.acceptValueButton.text="انتخاب"
//                p0.mainConstrainLayout.background=notChooseDrable
//                recycleListeners.serviceIdListener(
//                    -1,
//                    (services[position].price*-1).toLong()
//                )
//            }else {
//                serviceIdAdapter = services[position].id
//                p0.acceptValueButton.text="حذف"
//                p0.mainConstrainLayout.background=chooseDrable
//                recycleListeners.serviceIdListener(
//                    services[position].id,
//                    services[position].price.toLong()
//                )
//            }
            notifyDataSetChanged()
//            forChangeModes(services[position], myHoldeler, true)
        }
    }

    override fun getItemCount(): Int = services.size

    fun createRequest(id:String,type:String="user"){

        val request= JsonArrayRequest(
            Request.Method.DELETE,(baseAppUrl+"users/"+id),null,
            Response.Listener { response ->

//                cToast(contex,"خطا در برقراری ارتباط")

            },
            Response.ErrorListener { error ->
//                cToast(contex,"خطا در برقراری ارتباط")
            }

        )
        MySingleton.getInstance(contex).requestQueue.add(request)
    }


    override fun onBindViewHolder(p0: Holders1, p1: Int) {
        val p: User = services[p1]
        p0.nameValuItem1.text = p.name
        p0.familyValuItem1.text = p.fname
        p0.phoneValuItem1.text = p.phone
//                    ${serviceCompany.finalLimit} ${getUnitTagFromid(serviceCompany.unitLimit)}
//                    """
//        if(p.id==serviceIdAdapter){
            p0.acceptValueButton.text="حذف"
//            p0.mainConstrainLayout.background=chooseDrable
//        }else{
//            p0.acceptValueButton.text="انتخاب"
//            p0.mainConstrainLayout.background=notChooseDrable
//        }

        p0.usernsmeValuItem1.text=p.user
        p0.acceptValueButton.setOnClickListener {
//            var position = recycler.getChildLayoutPosition(it)
            createRequest(p.id)
            services.remove(p)
//            if( serviceIdAdapter==services[p1].id){
//                serviceIdAdapter=-10
//                p0.acceptValueButton.text="حذف"
//                p0.mainConstrainLayout.background=chooseDrable
//                recycleListeners.serviceIdListener(-1,(-1*services[p1].price).toLong())
//            }else{
//                serviceIdAdapter=services[p1].id
//                p0.acceptValueButton.text="حذف"
//                p0.mainConstrainLayout.background=chooseDrable
//                recycleListeners.serviceIdListener(services[p1].id,services[p1].price.toLong())}
            notifyDataSetChanged()
        }
//        forChangeModes(p, p0, false)
//        p0.chooOrDele.setOnClickListener {
//            forChangeModes(p, p0, true)
//        }
    }

    private fun forChangeModes(p: Existsservise, h: Holders1?, b: Boolean) {
        //        if (b) {
//            if (p.ischoose) {
//                p.ischoose = false
//                mapPiece.remove(p.idPiece)
//                h!!.layotCard.setBackgroundColor(resources.getColor(R.color.green_12))
//                h!!.chooceMode()
//            } else {
//                p.ischoose = true
//                try {
//                    mapPiece.put(p.idPiece, p.atterNeedModels1!![0].valueAttribute.minNeed)
//                } catch (ex: Exception) {
//                }
//                h!!.layotCard.setBackgroundColor(resources.getColor(R.color.red_1))
//                h!!.deleteMode()
//            }
//            checkAttrMatch(p)
//        }
//
//        if (p.ischoose) {
//            h!!.layotCard.setBackgroundColor(resources.getColor(R.color.green_12))
//        } else {
//            h!!.layotCard.setBackgroundColor(resources.getColor(R.color.red_1))
//        }
//
//
    }
    fun changeListModel(list: ArrayList<User>) {
//            listModel.listPiece.clear()
//    var l = ListPeice(list)
        if(list.size>0){
            recycler.visibility=View.VISIBLE
//            textNoFound.visibility=View.GONE
        }else{
            recycler.visibility=View.GONE
//            textNoFound.visibility=View.VISIBLE
        }
        services = list
        notifyDataSetChanged()
    }
//        fun checkAttrMatch(piece: PieceModel): Boolean {
//            var list3=allMainPiece.filter { it.ischoose }
//            val list1 = ArrayList<Needs1.MinNeed>()
//            mapPiece.values.forEach {
//                list1.addAll(it)
//            }
//            try {
//                for (r in list3){
//                    val list2 = list1.filter {
//                        it.idBrunch == r.idBrunch
//                    }
//                    for (k in r.listAttributes!!) {
//                        for (i in list2) {
//                            for (j in i.values) {
////                                StaticForAll.toastMyMessage(this@PieceMatch2Activity,
////                                        j.key + "  " + j.value + " - " + k.keyAttribute + " " + k.valueAttribute.valueAttribute)
//                                if (j.key == k.keyAttribute) {
//                                    val v1 = k.valueAttribute.valueAttribute.toDoubleOrNull()
//                                    val v = j.value.toDoubleOrNull()
//                                    if (v == null || v1 == null) {
////                                        StaticForAll.toastMyMessage(this@PieceMatch2Activity, "st " +
////                                                "" + j.value + " " + k.valueAttribute.valueAttribute)
////                                        if (j.value.equals(k.valueAttribute.valueAttribute)) {
////                                            StaticForAll.toastMyMessage(this@PieceMatch2Activity, "yes")
////                                        }
//                                    } else {
////                                        StaticForAll.toastMyMessage(this@PieceMatch2Activity, "num" + v!!.compareTo(v1!!))
//                                        if (v!!.compareTo(v1!!) > 0) {
//                                            piece.ischoose=false
//                                            forChangeModes(piece,null,false)
////                                            StaticForAll.toastMyMessage(this@PieceMatch2Activity, "yes")
//                                            return false
//                                        }
//                                    }
//                                }
//                            }
//                        }
//                    }
//
//                }
//
//
////                for (r in list3){
////                    for (rr in r.listAttributes!!){
////                        if(piece)
////                    }
////                }
//            } catch (ex: Exception) {
//                StaticForAll.toastMyMessage(this@PieceMatch2Activity,"my bababababsd")
//            }
//
////            try {
////                var list1 = mapPiece.values.filter { it.idBrunch == piece.idBrunch }
////                for (i in piece.listAttributes!!) {
////                    for (j in list1[0].values) {
////                        if (i.keyAttribute == j.key) {
////                            StaticForAll.toastMyMessage(this@PieceMatch2Activity, j.key + "  " + j.value)
////                        }
////                    }
////                }
////            }catch (ex:Exception){
////
////            }
//
//
//            return false
//        }


}




class ServicePagerAdapter(val fm:FragmentManager,val context: Context,val changeCostString: ChangeCostString):FragmentPagerAdapter(fm){
    override fun getItem(p0: Int): Fragment {
        if (p0 == 0) {
            val f = Modems1Fragment()
            f.changeListener = changeCostString
            return f
        } else {
            val f = MainService1Fragment()
            f.changeListener = changeCostString
            return f
        }
    }

    override fun getCount(): Int=2

    override fun getPageTitle(position: Int): CharSequence? {
        if(position==0)
            return "خدمات و مودم"
        else
            return "سرویس"
    }
}




class PanelAdapter(val fm:FragmentManager,val context: Context):FragmentPagerAdapter(fm){
    override fun getItem(p0: Int): Fragment =if(p0==0){EditUserFragment()}else{MainPanelFragment()}


    override fun getCount(): Int=2

    override fun getPageTitle(position: Int): CharSequence? {
        if(position==0)
            return "تغییر حساب کاربری"
        else
            return "پنل کاربری"
    }
}
class ModemAdapter1(val modems:List<String>,val contex:Context):BaseAdapter(){
    @SuppressLint("ViewHolder")
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val v=LayoutInflater.from(contex).inflate(R.layout.modem_items_row_1,parent,false)
//        val netImage=v.findViewById<NetworkImageView>(R.id.mainImage1)
//        netImage.setDefaultImageResId(R.drawable.ic_shopping_basket)
//        try {
////                val loader=MySingleton.getInstance(contex).imageLoader
//            netImage.setImageUrl(modems[position],MySingleton.getInstance(contex).imageLoader )
//        }catch (ex:Exception){
////            cToast(contex,ex.message.toString());
//        }
        return v
    }

    override fun getItem(position: Int): Any=modems[position]

    override fun getItemId(position: Int): Long=0

    override fun getCount(): Int =modems.size
}
class ModemAdapter(val modems:List<Modem>,val contex:Context,val modemSelected: ModemSelected):BaseAdapter(){
    interface ModemSelected{
        fun costModemSelected(modems:Modem)
    }

    @SuppressLint("ViewHolder")
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val v=LayoutInflater.from(contex).inflate(R.layout.modem_items_row,parent,false)
//        val netImage=v.findViewById<NetworkImageView>(R.id.mainImage)
//        val netImage=v.findViewById<ImageView>(R.id.mainImage)
        val getItem=v.findViewById<CheckBox>(R.id.isChecked)
        val costModem=v.findViewById<TextView>(R.id.costModemTextView)
        costModem.text=((modems[position].price)).toString()
        getItem.text=modems[position].model
        getItem.setOnClickListener {
            modems[position].isModemCheched=getItem.isChecked
            modemSelected.costModemSelected(modems[position])
//            if (getItem.isChecked){
//                cToast(contex,"selected")
//            }else{
//                cToast(contex,"no selected")
//            }
        }
//        netImage.setDefaultImageResId(R.drawable.ic_shopping_basket)
//        try {
////                val loader=MySingleton.getInstance(contex).imageLoader
//                netImage.setImageUrl(modems[position].urlImg,MySingleton.getInstance(contex).imageLoader )
//        }catch (ex:Exception){
////            cToast(contex,ex.message.toString());
//        }
        return v
    }

    override fun getItem(position: Int): Any=modems[position]

    override fun getItemId(position: Int): Long=0

    override fun getCount(): Int =modems.size
}
class MySpinnerAdapter(val values:ArrayList<String>,val contex:Context):BaseAdapter(){


    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
       val textView=TextView(contex);
        textView.text=values[position]
        return textView
    }


    override fun getItem(position: Int): Any =values[position]
    override fun getItemId(position: Int): Long=0
    override fun getCount(): Int=values.size
}

class StatusAdapter(var contex: Context,
                    var textViewResourceId:Int,
                    var statuses:List<StatusBean>,
                    var resLocal:Resources,
                    val header:String,
                    var inflater: LayoutInflater=contex.getSystemService(Context.LAYOUT_INFLATER_SERVICE)as LayoutInflater,
                    val statuses1: List<List<StatusBean>> = listOf(listOf(StatusBean(-10,header,"")),statuses)
                    ):ArrayAdapter<StatusBean>(contex, textViewResourceId, statuses1.flatMap {
    it
}){
    override fun getDropDownView(position: Int, convertView: View?, parent: ViewGroup): View {
        return getCustomView(position, convertView, parent);
    }
//    fun getItemWithStatus(status:String):Int{
//        var postion=0
//        statuses.mapIndexed{i,v->
//            if(v.status.equals())
//        }
//    }
    fun dataChanger(sta:List<StatusBean>){
//        statuses.dropWhile {
//            false
//        }
        statuses=sta
//    cToast(contex,"""
//        sta:${sta.size.toString()}
//        status:${statuses.size.toString()}
//    """.trimIndent())
        notifyDataSetChanged()
    }
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        return getCustomView(position, convertView, parent);
    }
    private fun getCustomView(position:Int,convertView:View?,  parent:ViewGroup):View {
       val row = inflater.inflate(R.layout.spinner_items_row, parent, false);

        val label =row.findViewById<TextView>(R.id.spinnerItem);
        if (position == 0) {
            label.setText(header);
        } else {
            val currRowVal =try{statuses.get(position-1)}catch (ex:Exception){StatusBean(-1,"","")}
            label.setText(currRowVal.status);
        }

        return row;
    }

}