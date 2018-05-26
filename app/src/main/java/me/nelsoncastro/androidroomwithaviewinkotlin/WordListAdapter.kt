package me.nelsoncastro.androidroomwithaviewinkotlin

import android.content.Context
import android.view.View
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup

import android.widget.TextView

class WordListAdapter(private val contexte: Context) : RecyclerView.Adapter<WordListAdapter.WordViewHolder>() {

    private var mWords: List<Word>? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WordViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.recyclerview_item, parent, false)
        return WordViewHolder(v)
    }

    override fun getItemCount(): Int {
        return  if (mWords != null) mWords!!.size else 0
    }

    override fun onBindViewHolder(holder: WordViewHolder, position: Int) {
        val current = mWords!![position]
        holder.wordItemView.text = current.word
    }

    internal fun setWords(words: List<Word>) {
        mWords = words
        notifyDataSetChanged()
    }

    class WordViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        internal val wordItemView: TextView = itemView.findViewById(R.id.textView)
    }
}