package com.bomjdev.myfood.common

import com.bomjdev.myfood.Doctor
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import io.reactivex.Single
import io.reactivex.SingleEmitter

/**
 * Created by azazellj on 2/23/19.
 */
object ChatManager {
    fun getListOfDoctors(): Single<List<Doctor>> {
        return Single.create<List<Doctor>> { emitter ->
            DOCTORS.addListenerForSingleValueEvent(object : ValueEventListener {
                override fun onCancelled(dbError: DatabaseError) {
                    emitter.onError(dbError.toException())
                }

                override fun onDataChange(data: DataSnapshot) {
                    emitter.onSuccess(data.children.map { return@map it.getValue(Doctor::class.java)!! })
                }
            })
        }
    }

    fun addDoctor(): Single<Any> = Single.create<Any> { emitter ->
        val user = FirebaseAuth.getInstance().currentUser!!
        val doctor = Doctor(user.uid, user.displayName ?: "Doctor")

        DOCTORS.child(user.uid).setValue(doctor)
            .addOnSuccessListener { emitter.onSuccess(doctor) }
            .addOnFailureListener { emitter.onError(it) }
    }

    fun sendMessageToDoctor(doctorId: String, message: String) = Single.create<String> { emitter ->
        val user = FirebaseAuth.getInstance().currentUser!!

        if (user.uid == doctorId) return@create emitter.onError(IllegalArgumentException("Can`t send message to yourself"))

        sendMessage(chatId = "${user.uid}$doctorId", senderId = user.uid, message = message, emitter = emitter)
    }

    fun sendMessageToPatient(patientId: String, message: String) = Single.create<String> { emitter ->
        val user = FirebaseAuth.getInstance().currentUser!!

        if (user.uid == patientId) return@create emitter.onError(IllegalArgumentException("Can`t send message to yourself"))

        sendMessage(chatId = "$patientId${user.uid}", senderId = user.uid, message = message, emitter = emitter)
    }

    private fun sendMessage(chatId: String, senderId: String, message: String, emitter: SingleEmitter<String>) {
        MESSAGES.child(chatId).push().child(senderId).setValue(message)
            .addOnSuccessListener { emitter.onSuccess(message) }
            .addOnFailureListener { emitter.onError(it) }
    }
}

private val DOCTORS = FirebaseDatabase.getInstance().getReference("doctors")
private val MESSAGES = FirebaseDatabase.getInstance().getReference("messages")