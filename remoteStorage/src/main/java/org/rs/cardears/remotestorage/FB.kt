package org.rs.cardears.remotestorage

import android.util.Log
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.firestore.ktx.toObject
import com.google.firebase.ktx.Firebase
import org.rs.cardears.remotestorage.model.ProviderDto
import java.util.*


class FB {

    fun test() {
        val db = Firebase.firestore
        val randomUUID = UUID.randomUUID()
        Log.d("TAG", randomUUID.toString())

//        db.collection("providers").document(randomUUID.toString()).set(
//            ProviderDto("title", "shortDesc", "Description")
//
//        )
        val docRef = db.collection("providers").document("80e78d15-8171-41d8-af5b-a270321bc49e")
        val list = mutableListOf<ProviderDto>()
        val ref = db.collection("providers")
            .get()
            .addOnSuccessListener { result ->
                for (doc in result) {
                  list.add(element = doc.toObject())
                }
        }
        Log.d("TAG", list.toString())


//        docRef.get()
//            .addOnSuccessListener { document ->
//                if (document != null) {
//                    Log.d("TAG", "DocumentSnapshot data: ${document.data}")
//                } else {
//                    Log.d("TAG", "No such document")
//                }
//            }
//            .addOnFailureListener { exception ->
//                Log.d("TAG", "get failed with ", exception)
//            }

//        docRef.get().addOnSuccessListener { documentSnapshot ->
//            if (documentSnapshot != null) {
//                    Log.d("TAG", "DocumentSnapshot data: ${documentSnapshot.data}")
//                } else {
//                    Log.d("TAG", "No such document")
//                }
//            Log.d("TAG", documentSnapshot.data.toString())
//            val providerDto = documentSnapshot.toObject<ProviderDto>()
//            Log.d("TAG", providerDto.toString())
//
//        }
    }
}
