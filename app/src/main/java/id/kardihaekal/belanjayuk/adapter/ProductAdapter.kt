package id.kardihaekal.belanjayuk.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import id.kardihaekal.belanjayuk.ActivityDetail
import id.kardihaekal.belanjayuk.GlobalData
import id.kardihaekal.belanjayuk.R
import id.kardihaekal.belanjayuk.model.Product
import kotlinx.android.synthetic.main.adapter_product.view.*

class ProductAdapter(var context: Context, var list:ArrayList<Product>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {




    class myProductAdapter(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun adapter(titles:String, hargas:Int, photos:String){

            itemView.title.text = titles
            itemView.harga.text = "$ " + hargas.toString()
            Picasso.get().load(photos).into(itemView.image)
        }

    }




    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        var view:View = LayoutInflater.from(context).inflate(R.layout.adapter_product, parent, false)

        return myProductAdapter(view)
    }




    override fun getItemCount(): Int {
        return list.size
    }




    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as myProductAdapter).adapter(list[position].nama, list[position].harga, list[position].photo)
        (holder as myProductAdapter).itemView.image.setOnClickListener {
            var intent = Intent(context, ActivityDetail::class.java)
            GlobalData.ids = list[position].id
            GlobalData.names = list[position].nama
            GlobalData.hargas = list[position].harga
            GlobalData.photos = list[position].photo
            GlobalData.deskripsis = list[position].deskripsi
            context.startActivity(intent)
        }
    }
}