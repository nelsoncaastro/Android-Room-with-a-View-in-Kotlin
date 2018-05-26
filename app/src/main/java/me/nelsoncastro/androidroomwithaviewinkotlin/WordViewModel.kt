package me.nelsoncastro.androidroomwithaviewinkotlin

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.LiveData

class WordViewModel(application: Application): AndroidViewModel(application){
    internal var mRepository: WordRepository? = null
    internal var allWords: LiveData<List<Word>>? = null

    init {
       mRepository = WordRepository(application)
        allWords = mRepository!!.getAllWords()
    }

    fun getAllWords(): LiveData<List<Word>> {        return allWords!!}

    fun insert(word: Word) {        mRepository!!.insert(word)    }
}


