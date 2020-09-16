package id.kardihaekal.belanjayuk.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import id.kardihaekal.belanjayuk.R
import id.kardihaekal.belanjayuk.model.Orders
import kotlinx.android.synthetic.main.adapter_orders.view.*

class ItemOrder(var context: Context, var list:ArrayList<Orders>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {




    class myCategory(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun category(name_products:String, id_users:String, jumlahs:Int, catatans:String){

            itemView.nama_product.text = name_products
            itemView.id_user.text = id_users.toString()
            itemView.jumlah.text = jumlahs.toString()
            itemView.catatan.text = catatans
        }

    }




    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        var view: View = LayoutInflater.from(context).inflate(R.layout.adapter_orders, parent, false)

        return myCategory(view)
    }




    override fun getItemCount(): Int {
        return list.size
    }




    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as myCategory).category(list[position].nama_product, list[position].id_user, list[position].jumlah, list[position].catatan)
    }
}