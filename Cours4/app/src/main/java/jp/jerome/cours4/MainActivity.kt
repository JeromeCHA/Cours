package jp.jerome.cours4

import android.app.Activity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.mlkit.nl.smartreply.SmartReply
import com.google.mlkit.nl.smartreply.SmartReplySuggestionResult
import com.google.mlkit.nl.smartreply.TextMessage
import jp.jerome.cours4.databinding.ActivityMainBinding

class MainActivity : Activity() {

    private lateinit var binding: ActivityMainBinding
    private var list = mutableListOf<Message>()
    private lateinit var adapter: MessageAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.activity = this

        adapter = MessageAdapter()
        adapter.messagesList = list

        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.adapter = adapter
    }

    fun sendMessage() {
        if (binding.sendEditText.text.isEmpty()) {
            Toast.makeText(this, "インプットテキストフィールドが空いています。", Toast.LENGTH_LONG).show()
            return
        }
        list.add(Message(
                userId = 1,
                message = binding.sendEditText.text.toString(),
                time = System.currentTimeMillis()
        ))
        // Creer la liste de conversation
        val conversation = mutableListOf<TextMessage>()
        list.forEach { message ->
            message.userId?.let { userId ->
                conversation.add(TextMessage.createForRemoteUser(
                        "Are you coming back soon?", System.currentTimeMillis(), userId.toString()))
            } ?: run {
                conversation.add(TextMessage.createForLocalUser(
                        message.message, System.currentTimeMillis()))
            }
        }

        // envoie de la liste de conversation
        val smartReply = SmartReply.getClient()
        smartReply.suggestReplies(conversation)
                .addOnSuccessListener { result ->
                    //  reception de la liste de smart replies
                    when (result.status) {
                        SmartReplySuggestionResult.STATUS_NOT_SUPPORTED_LANGUAGE -> {
                            Toast.makeText(this@MainActivity, "Language error", Toast.LENGTH_LONG).show()
                        }
                        SmartReplySuggestionResult.STATUS_SUCCESS -> {
                            list.add(Message(
                                    userId = null,
                                    message = result.suggestions.random().text,
                                    time = System.currentTimeMillis()
                            ))
                            adapter.messagesList = list
                        }
                        else -> Toast.makeText(this@MainActivity, "Smart Reply error", Toast.LENGTH_LONG).show()
                    }
                }
                .addOnFailureListener {
                    Toast.makeText(this@MainActivity, "Smart Reply error: ${it.localizedMessage}", Toast.LENGTH_LONG).show()
                }
    }
}