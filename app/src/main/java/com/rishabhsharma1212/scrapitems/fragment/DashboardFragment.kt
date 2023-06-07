 package com.rishabhsharma1212.scrapitems.fragment


import android.app.AlertDialog
//import android.app.DownloadManager.Request
import android.content.Context
import android.os.Bundle
import android.telecom.Connection
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.core.graphics.drawable.toDrawable
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.rishabhsharma1212.scrapitems.R
import com.rishabhsharma1212.scrapitems.adapter.DashboardRecyclerAdapter
import com.rishabhsharma1212.scrapitems.model.Scrap
import com.rishabhsharma1212.scrapitems.util.connectionManager


 // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [DashboardFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class DashboardFragment : Fragment() {

    private var param1: String? = null
    private var param2: String? = null


    lateinit var recyclerDashboard:RecyclerView
    lateinit var layoutManager : RecyclerView.LayoutManager
    lateinit var btnCheckInternet:Button

    /*var bookList= arrayListOf(
        "NEWSPAPER",
        "COPIES/BOOKS",
        "CARDBOARD",
        "PLASTIC ",
        "IRON ",
        "STEEL",
        "ALUMINIUM",
        "BRASS",
        "COPPER",
    )*/
    lateinit var recyclerAdapter:DashboardRecyclerAdapter

    val scrapInfoList= arrayListOf<Scrap>(
        Scrap("NEWSPAPER","Recyclables","Rs. 18/KG","4.5",R.drawable.newspaper_image),
        Scrap("COPIES/BOOKS","Recyclables","Rs. 16/KG","4.6",R.drawable.copies_books),
        Scrap("CARDBOARD","Recyclables","Rs. 10/KG","4.8",R.drawable.cardboard_image),
        Scrap("PLASTIC","Recyclables","Rs. 10/KG","4.3",R.drawable.plastic_image),
        Scrap("IRON","Recyclables","Rs. 30/KG","5.0",R.drawable.iron_image),
        Scrap("STEEL","Recyclables","Rs. 37/KG","4.6",R.drawable.steel_image),
        Scrap("ALUMINIUM","Recyclables","Rs. 105/KG","4.9",R.drawable.aluminum_image),
        Scrap("BRASS","Recyclables","Rs. 305/KG","4.7",R.drawable.brass_image),
        Scrap("COPPER","Recyclables","Rs. 425/KG","4.6",R.drawable.copper_image),
        Scrap("IRON COOLER","Large Appliances","Rs. 30/KG","4.6", R.drawable.iron_cooler),
        Scrap("PLASTIC COOLER","Large Appliances","Rs. 15/KG","4.6",R.drawable.plastic_cooler),
        Scrap("WINDOW AC ALUMINIUM(1.5 TON)","Large Appliances","Rs. 2500/PIECE","4.6",R.drawable.air_conditioner),
        Scrap("FRONT LOAD FULLY AUTOMATIC WASHING MACHINE","Large Appliances","Rs. 800/PIECE","4.6",R.drawable.washing_machine),
        Scrap("TOP LOAD FULLY AUTOMATIC WASHING MACHINE","Large Appliances","Rs. 550/PIECE","4.6",R.drawable.washing_machine),
        Scrap("SEMI AUTOMATIC WASHING MACHINE (DOUBLE DRUM)","Large Appliances","Rs. 550/PIECE","4.6",R.drawable.washing_machine),
        Scrap("GEYSER","Large Appliances","Rs. 20/KG","4.6",R.drawable.geyser),
        Scrap("SINGLE DOOR FRIDGE ","Large Appliances","Rs. 750/KG","4.6",R.drawable.fridge),
        Scrap("DOUBLE DOOR FRIDGE ","Large Appliances","Rs. 1000/PIECE","4.6",R.drawable.fridge),
        Scrap("AC (2 TON)","Large Appliances","Rs. 4000/PIECE","4.6",R.drawable.air_conditioner),
        Scrap("AC COPPER (1.5 TON)","Large Appliances","Rs. 3500/PIECE","4.6",R.drawable.air_conditioner),
        Scrap("AC (1 TON)","Large Appliances","Rs. 2100/PIECE","4.6",R.drawable.air_conditioner)


    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        val view=inflater.inflate(R.layout.fragment_dashboard, container, false)
        recyclerDashboard=view.findViewById(R.id.recyclerDashboard)

        btnCheckInternet=view.findViewById(R.id.btnCheckInternet)

        btnCheckInternet.setOnClickListener{
            if(connectionManager().checkConnectivity(activity as Context)){
                //Internet is available
                val dialog=AlertDialog.Builder(activity as Context)
                dialog.setTitle("Success")
                dialog.setMessage("Internet Connection Found")
                dialog.setPositiveButton("Ok"){text,listener->

                }
                dialog.create()
                dialog.show()
            }else
            {
                //Internet is not available
                val dialog=AlertDialog.Builder(activity as Context)
                dialog.setTitle("Error")
                dialog.setMessage("Internet Connection is not Found")
                dialog.setPositiveButton("Ok"){text,listener->

                }
                dialog.create()
                dialog.show()
            }
        }


        layoutManager= LinearLayoutManager(activity)

        recyclerAdapter= DashboardRecyclerAdapter(activity as Context,scrapInfoList)

        recyclerDashboard.adapter=recyclerAdapter

        recyclerDashboard.layoutManager=layoutManager

        recyclerDashboard.addItemDecoration(
            DividerItemDecoration(
                recyclerDashboard.context,
                (layoutManager as LinearLayoutManager).orientation
            )
        )
        val queue=Volley.newRequestQueue(activity as Context)

        val url = "http://13.235.250.119/v1/book/fetch_books/"

        val jsonObjectRequest=object :JsonObjectRequest(Request.Method.GET,url,null,Response.Listener { it ->
            //Here we will handle the response
            println("Response is $it")
        },Response.ErrorListener {
            //println("Error is $it")
            //Here we will handle the errors

        }){
            override fun getHeaders(): MutableMap<String, String> {
                val headers=HashMap<String,String>()
                headers["Content-type"]="application/json"
                headers["token"]="9bf34118365f1"
                return headers
            }
        }
        queue.add(jsonObjectRequest)
        return view

    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment DashboardFragment.
         */

        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            DashboardFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}