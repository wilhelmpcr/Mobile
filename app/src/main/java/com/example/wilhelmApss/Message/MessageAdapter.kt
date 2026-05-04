package com.example.wilhelmApss.Message

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import com.bumptech.glide.Glide
import com.google.android.material.snackbar.Snackbar
import com.example.wilhelmApss.databinding.ItemMessageBinding

class MessageAdapter(
    context: Context,
    private val messages: List<MessageModel>
) : ArrayAdapter<MessageModel>(context, 0, messages) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val binding: ItemMessageBinding
        val view: View

        if (convertView == null) {
            binding = ItemMessageBinding.inflate(LayoutInflater.from(context), parent, false)
            view = binding.root
            view.tag = binding
        } else {
            binding = convertView.tag as ItemMessageBinding
            view = convertView
        }

        val data = messages[position]

        // Load image with Glide
        Glide.with(context)
            .load(data.avatarUrl)
            .centerCrop()
            .placeholder(android.R.drawable.ic_menu_gallery)
            .error(android.R.drawable.stat_notify_error)
            .into(binding.avatarImg)

        // Set text data
        binding.textSender.text = data.senderName
        binding.textMessage.text = data.messageText

        // Handle click event
        view.setOnClickListener {
            Snackbar.make(
                parent,
                "Pesan dari ${data.senderName}: ${data.messageText}",
                Snackbar.LENGTH_SHORT
            ).show()
        }

        return view
    }
}
