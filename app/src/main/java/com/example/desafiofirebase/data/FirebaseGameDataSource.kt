package com.example.desafiofirebase.data

/* Esta classe vai ser a fonte de dados do Firebase
 */

import android.net.Uri
import com.example.desafiofirebase.BuildConfig
import com.example.desafiofirebase.domain.model.Game
import com.example.desafiofirebase.util.COLLECTION_GAME
import com.example.desafiofirebase.util.COLLECTION_ROOT
import com.example.desafiofirebase.util.STORAGE_IMAGES
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.storage.FirebaseStorage
import java.util.*
import javax.inject.Inject
import kotlin.coroutines.suspendCoroutine

class FirebaseGameDataSource @Inject constructor(
    firebaseFirestore: FirebaseFirestore,
    firebaseStorage: FirebaseStorage
): GameDataSource {

    private val documentReference = firebaseFirestore.document("$COLLECTION_ROOT/${BuildConfig.APPLICATION_ID}")
    private val storeReference = firebaseStorage.reference

    override suspend fun getGame(): List<Game> {
        return suspendCoroutine {
            continuation ->
            val gameReference = documentReference.collection(COLLECTION_GAME)
            gameReference.get().addOnSuccessListener { documentes ->
                val game = mutableListOf<Game>()
                for (documente in documentes){
                    documente.toObject(Game::class.java).run {
                        game.add(this)
                    }
                }
                continuation.resumeWith(Result.success(game))

            }
            gameReference.get().addOnFailureListener {exception ->
                continuation.resumeWith(Result.failure(exception))

            }
        }
    }

    override suspend fun uploadImageGame(imageUri: Uri): String {
        return suspendCoroutine { continuation ->
            val randomKey = UUID.randomUUID()
            val childReference = storeReference.child("$STORAGE_IMAGES/${com.google.firebase.firestore.BuildConfig.APPLICATION_ID}/$randomKey")

            childReference.putFile(imageUri).addOnSuccessListener {
                taskSnapshot -> taskSnapshot.storage.downloadUrl.addOnSuccessListener { uri -> val path = uri.toString()
                continuation.resumeWith(Result.success(path))}
            }.addOnFailureListener {
                continuation.resumeWith(Result.failure(it))
            }
        }
    }

    override suspend fun createGame(game: Game): Game {
        return suspendCoroutine { continuation ->
            documentReference.collection(COLLECTION_GAME)
                .document(System.currentTimeMillis().toString())
                .set(game)
                .addOnSuccessListener {
                    continuation.resumeWith(Result.success(game))
                }
                .addOnFailureListener {
                    continuation.resumeWith(Result.failure(it))
                }
        }
    }
}