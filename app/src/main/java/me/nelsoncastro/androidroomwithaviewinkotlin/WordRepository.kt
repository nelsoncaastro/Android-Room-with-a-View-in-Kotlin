package me.nelsoncastro.androidroomwithaviewinkotlin

import android.app.Application
import android.arch.lifecycle.LiveData
import android.os.AsyncTask

class WordRepository(application: Application) {

    var mWordDao: WordDao? = null
    var mAllWords: LiveData<List<Word>>? = null

    init {
        val db = WordRoomDatabase.getDatabase(application)
        mWordDao = db!!.wordDao()
        mAllWords = mWordDao!!.getAlphabetizedWords()
    }

    internal fun getAllWords(): LiveData<List<Word>> {
        return mAllWords!!
    }

    fun insert(word: Word) {
        insertAsyncTask(mWordDao!!).execute(word)
    }


    private class insertAsyncTask internal constructor(private val mAsyncTaskDao: WordDao) : AsyncTask<Word, Void, Void>() {

        override fun doInBackground(vararg params: Word): Void? {
            mAsyncTaskDao.insert(params[0])
            return null
        }
    }
}

