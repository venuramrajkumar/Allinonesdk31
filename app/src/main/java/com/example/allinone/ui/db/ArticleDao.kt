package com.example.allinone.ui.db

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.allinone.ui.model.Article

@Dao
interface ArticleDao {

    @Insert (onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveAndUpdateArticles(article: Article) : Long

    @Query("SELECT * FROM articles")
    fun getAllArticles() : LiveData<List<Article>>

    @Delete
    suspend fun deleteArticle(article: Article)
}