package jp.jerome.cours4

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import jp.jerome.cours4.databinding.MessageItemBinding

class MessageAdapter: RecyclerView.Adapter<MessageAdapter.MessageViewHolder>() {

    var messagesList = listOf<Message>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MessageViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = MessageItemBinding.inflate(layoutInflater, parent, false)
        return MessageViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MessageViewHolder, position: Int) {
        if (position < messagesList.size) {
            holder.binding.message = messagesList[position]
        }
    }

    override fun getItemCount(): Int {
        return messagesList.size
    }

    class MessageViewHolder(val binding: MessageItemBinding) : RecyclerView.ViewHolder(binding.root)
}