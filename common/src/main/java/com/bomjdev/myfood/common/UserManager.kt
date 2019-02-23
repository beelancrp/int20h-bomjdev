package com.bomjdev.myfood.common

import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import io.reactivex.Single
import io.reactivex.SingleEmitter

/**
 * Created by azazellj on 2/23/19.
 */
object UserManger {

    /////   DOCTOR  /////

    fun registerDoctor(email: String, password: String) = registerUser(email, password)

    fun loginDoctor(email: String, password: String) = loginUser(email, password)


    /////   PATIENT /////

    fun registerPatient(email: String, password: String) = registerUser(email, password)

    fun loginPatient(email: String, password: String) = loginUser(email, password)


    /////   COMMON  /////

    private fun loginUser(email: String, password: String) = Single.create<FirebaseUser> { emitter ->
        FirebaseAuth.getInstance()
            .signInWithEmailAndPassword(email, password)
            .subscribe(emitter)
    }

    private fun registerUser(email: String, password: String) = Single.create<FirebaseUser> { emitter ->
        FirebaseAuth.getInstance()
            .createUserWithEmailAndPassword(email, password)
            .subscribe(emitter)
    }

    private inline fun Task<AuthResult>.subscribe(emitter: SingleEmitter<FirebaseUser>) {
        this.addOnFailureListener { error -> emitter.onError(error) }
            .addOnSuccessListener { result -> emitter.onSuccess(result.user) }
    }
}
