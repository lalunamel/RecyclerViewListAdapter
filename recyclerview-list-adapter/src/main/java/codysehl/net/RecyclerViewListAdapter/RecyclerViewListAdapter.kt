package codysehl.net.RecyclerViewListAdapter

import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup


abstract class RecyclerViewListAdapter<V: View, I>(var items: List<I> = listOf()): RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    companion object {
        /**
         * @param createView A function that creates a View or a View subclass
         *
         * @param updateView A function that takes a View created by createView and an Item
         * and updates the View.
         */
        fun <V: View, I>create(createView: () -> V, updateView: (V, I) -> Unit): RecyclerViewListAdapter<V, I> {
            return object: RecyclerViewListAdapter<V, I>() {

                override fun getItemCount(): Int = items.size

                override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): RecyclerView.ViewHolder {
                    val view: V = createView()
                    return object: RecyclerView.ViewHolder(view) {}
                }

                override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
                    val item = items[position]
                    @Suppress("UNCHECKED_CAST")
                    updateView(holder.itemView as V, item)
                }

            }
        }
    }
}