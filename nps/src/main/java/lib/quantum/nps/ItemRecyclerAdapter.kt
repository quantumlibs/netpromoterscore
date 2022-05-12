package lib.quantum.nps

import android.content.Context
import android.graphics.Color
import android.graphics.PorterDuff
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

open class ItemRecyclerAdapter(
    var context: Context,
    var itemList: List<String>,
    var npsAnswer: Int = -1,
    var shape: Shape
) : RecyclerView.Adapter<ViewHolder>() {

 var npsAnswerSelectedListener: NPSRecyclerView.NPSAnswerSelectedListener? = null


    constructor(context: Context,
                itemList: List<String>,
                npsAnswer: Int = -1,
                shape: Shape,
                npsAnswerSelectedListener: NPSRecyclerView.NPSAnswerSelectedListener
    ) : this(context, itemList, npsAnswer, shape) {
        this.npsAnswerSelectedListener = npsAnswerSelectedListener
            }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.nps_item_layout, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        Log.d("NPS>>>>>", shape.name)
        holder.itemText.text = itemList.get(position)

        if (shape.equals(Shape.SQUARE))
            holder.itemLayout.background = context.resources.getDrawable(R.drawable.item_bg_rect)
        else
            holder.itemLayout.background = context.resources.getDrawable(R.drawable.item_bg_circle)

        if (position <= npsAnswer-1) {
            holder.itemText.setTextColor(Color.WHITE)
            holder.itemLayout.getBackground().setColorFilter(Color.parseColor("#04B2AB"), PorterDuff.Mode.SRC_ATOP);
        }

        holder.itemLayout.setOnClickListener { v ->
            run {
                npsAnswer = position+1
                notifyDataSetChanged()
                npsAnswerSelectedListener?.onAnswerSelected(npsAnswer)
                holder.itemText.setTextColor(Color.WHITE)
                holder.itemLayout.getBackground()
                    .setColorFilter(Color.parseColor("#04B2AB"), PorterDuff.Mode.SRC_ATOP);
            }
        }
    }

    open fun getSelectedAnswer(): Int {
        return npsAnswer
    }
}

class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val itemText = itemView.findViewById<TextView>(R.id.nps_item_value)!!
    val itemLayout = itemView.findViewById<RelativeLayout>(R.id.nps_item_layout)
}
