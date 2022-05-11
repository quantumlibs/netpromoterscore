package lib.quantum.nps

import android.content.Context
import android.content.res.TypedArray
import android.util.AttributeSet
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class NPSRecyclerView(context: Context, attrs: AttributeSet?) : RecyclerView(context, attrs) {

    lateinit var npsAdapter: ItemRecyclerAdapter

    init {
        if(attrs!=null){
            val ta: TypedArray = context.obtainStyledAttributes(attrs, R.styleable.NPSRecyclerView)
            val count = ta.getInt(R.styleable.NPSRecyclerView_count, 10)
            val shape = Shape.values()[ta.getInt(R.styleable.NPSRecyclerView_shape,0)]
            val orientation = ta.getInt(R.styleable.NPSRecyclerView_android_orientation, 0)

            val items: MutableList<String> = ArrayList()
            for(i in 1..count){
                items.add(i.toString())
            }
            this.layoutManager = LinearLayoutManager(context, orientation, false)
            npsAdapter = ItemRecyclerAdapter(context, items, -1, shape)
            this.adapter = npsAdapter
            ta.recycle()
        }
    }

    fun getSelectedAnswer() : String{
        return npsAdapter.getSelectedAnswer().toString()
    }

}

enum class Shape {
    SQUARE, CIRCLE
}
