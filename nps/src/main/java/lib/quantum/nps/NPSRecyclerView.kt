package lib.quantum.nps

import android.content.Context
import android.content.res.TypedArray
import android.util.AttributeSet
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class NPSRecyclerView(context: Context, attrs: AttributeSet?) : RecyclerView(context, attrs) {

    private var shape: Shape? = null
    lateinit var npsAdapter: ItemRecyclerAdapter
    var boxItemPosition: Int = -1
    var count: Int = 0
    val items: MutableList<String> = ArrayList()

    init {
        if (attrs != null) {
            val ta: TypedArray = context.obtainStyledAttributes(attrs, R.styleable.NPSRecyclerView)
            count = ta.getInt(R.styleable.NPSRecyclerView_count, 10)
            boxItemPosition = ta.getInt(R.styleable.NPSRecyclerView_answer, -1)
            shape = Shape.values()[ta.getInt(R.styleable.NPSRecyclerView_shape, 0)]
            val orientation = ta.getInt(R.styleable.NPSRecyclerView_android_orientation, 0)

            for (i in 1..count) {
                items.add(i.toString())
            }
            this.layoutManager = LinearLayoutManager(context, orientation, false)
            npsAdapter = ItemRecyclerAdapter(context, items, boxItemPosition, shape!!)
            this.adapter = npsAdapter
            ta.recycle()
        }
    }

    fun getSelectedAnswer(): String {
        return npsAdapter.getSelectedAnswer().toString()
    }

    fun setSelectedAnswer(answer: Int) {
        boxItemPosition = answer - 1

        if (boxItemPosition > count) {
            Toast.makeText(context, "answer cannot be more than scale", Toast.LENGTH_SHORT)
                .show()
            return
        }
        this.layoutManager = LinearLayoutManager(context, HORIZONTAL, false)
        npsAdapter = ItemRecyclerAdapter(context, items, boxItemPosition, shape!!)
        this.adapter = npsAdapter
    }


}

enum class Shape {
    SQUARE, CIRCLE
}
