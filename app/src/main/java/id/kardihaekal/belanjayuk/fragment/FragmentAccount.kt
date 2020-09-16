package id.kardihaekal.belanjayuk.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.toolbox.JsonArrayRequest
import com.android.volley.toolbox.Volley
import id.kardihaekal.belanjayuk.GlobalData
import id.kardihaekal.belanjayuk.R
import id.kardihaekal.belanjayuk.adapter.ItemOrder
import id.kardihaekal.belanjayuk.model.Orders
import kotlinx.android.synthetic.main.fragment_account.*
import kotlinx.android.synthetic.main.fragment_account.view.*

class FragmentAccount : Fragment() {

    var list = ArrayList<Orders>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?): View? {

        val view = inflater.inflate(R.layout.fragment_account, container, false)
        view.email.text = GlobalData.email



        getProduct()
        return view
    }

    private fun getProduct(){
        var queue: RequestQueue = Volley.newRequestQueue(activity)
        var reques = JsonArrayRequest(Request.Method.GET,
                "http://192.168.1.5/store/apiorder.php",
            null, Response.Listener { response ->


                for (s in 0..response.length() - 1){
                var job = response.getJSONObject(s)
                var id = job.getString("id_user")
                var name_product = job.getString("nama_product")
                var jumlah = job.getInt("jumlah")
                var catatan = job.getString("catatan")

                list.add(Orders(id, jumlah, catatan, name_product))
                var adapterku = ItemOrder(requireContext(), list)
                order.layoutManager = LinearLayoutManager(requireContext())
                order.adapter = adapterku
            }
        }, Response.ErrorListener { error ->
            Log.d("showError", error.toString())
        })
        queue.add(reques)
    }
}