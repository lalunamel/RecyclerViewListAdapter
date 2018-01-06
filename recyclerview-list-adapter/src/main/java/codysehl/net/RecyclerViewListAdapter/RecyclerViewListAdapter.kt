package codysehl.net.RecyclerViewListAdapter

import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup


abstract class RecyclerViewListAdapter<V: View, I>(var items: List<I> = listOf()): RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    companion object {
        fun <V: View, I>create(viewConstructor: () -> V, update: (V, I) -> Unit): RecyclerViewListAdapter<V, I> {
            return object: RecyclerViewListAdapter<V, I>() {

                override fun getItemCount(): Int = items.size

                override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): RecyclerView.ViewHolder {
                    val view: V = viewConstructor()
                    return object: RecyclerView.ViewHolder(view) {}
                }

                override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
                    val item = items[position]
                    @Suppress("UNCHECKED_CAST")
                    update(holder.itemView as V, item)
                }

            }
        }
    }
}