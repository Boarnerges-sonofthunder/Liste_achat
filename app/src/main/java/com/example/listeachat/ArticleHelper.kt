package com.example.listeachat

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.widget.Toast

val TABLE_ARTICLE = "Article"
val COLUMN_ID = "_id"
val COLUMN_NOM = "nom"
val COLUMN_MAGASIN = "magasin"
val COLUMN_PRIX = "prix"
val COLUMN_QUANTITE = "quantite"
val COLUMN_IMAGEURL = "imgUrl";

class ArticleHelper(val context : Context ) : SQLiteOpenHelper(context,"ListeAchat.db",null,1){
				override fun onCreate(db: SQLiteDatabase?) {
								val sql = "CREATE TABLE IF NOT EXISTS " + TABLE_ARTICLE + " (" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
													COLUMN_NOM + " TEXT," + COLUMN_MAGASIN + " TEXT," + COLUMN_PRIX	+ " INTEGER,"	+
													COLUMN_QUANTITE	+ " INTEGER," + COLUMN_IMAGEURL + " TEXT)"

								db?.execSQL(sql)
				}

				fun addAll(article:Articles)
				{
								val db = this.writableDatabase
								val cv = ContentValues()

								cv.put(COLUMN_NOM,article._nom)
								cv.put(COLUMN_MAGASIN,article._magasin)
								cv.put(COLUMN_PRIX,article._prix)
								cv.put(COLUMN_QUANTITE,article._quantite)
								cv.put(COLUMN_IMAGEURL,article._imgUrl)

								val result = db.insert(TABLE_ARTICLE,null,cv)
								if(result == -1.toLong())
												Toast.makeText(context,"insertion echoué", Toast.LENGTH_SHORT).show()
								else
												Toast.makeText(context,"succes", Toast.LENGTH_SHORT).show()
				}

				fun getAllArticle():MutableList<Articles> {
								val db: SQLiteDatabase = this.readableDatabase
								val query = "SELECT * FROM $TABLE_ARTICLE"
								val cur: Cursor = db.rawQuery(query,null)

								//Declaration de la liste et remplissage avec l'objet
								var mutLst = mutableListOf<Articles>()

								if(cur.moveToFirst())
								{
												do{
																var articleId = cur.getInt(0)
																var articleNom = cur.getString(1)
																var articleMagasin = cur.getString(2)
																var articlePrix = cur.getDouble(3)
																var articleQuantite = cur.getInt(4)
																var articleImage = cur.getString(5)

																//Initialiser un objet article et lui attribuer les données recuperés de la bd
																var article = Articles(articleId,articleNom,articleMagasin,articlePrix,articleQuantite,articleImage)

																//Ajout de l'objet article dans la liste
																mutLst.add(article)

												}while(cur.moveToNext())
								}
								else
								{
												Toast.makeText(context,"Il n'y a pas d'article dans la liste",Toast.LENGTH_SHORT).show()
								}
								cur.close()
								db.close()
								return mutLst
				}

				fun deleteArticle(article:Articles):Boolean
				{
								val db = this.writableDatabase
								val query:String = "DELETE FROM " + TABLE_ARTICLE + " WHERE " + COLUMN_ID + " = " + article._id

								val cur:Cursor = db.rawQuery(query, null)

								return cur.moveToFirst()
				}

				fun updateArticle(article:Articles):Int
				{
								val db = this.writableDatabase
								val cv = ContentValues()

								cv.put(COLUMN_NOM,article._nom)
								cv.put(COLUMN_MAGASIN,article._magasin)
								cv.put(COLUMN_PRIX,article._prix)
								cv.put(COLUMN_QUANTITE,article._quantite)
								cv.put(COLUMN_IMAGEURL,article._imgUrl)

								val succes =  db.update(TABLE_ARTICLE,cv, "$COLUMN_ID = ?", arrayOf(article._id.toString()))
								db.close()

								return succes
				}

				fun getArticles(info:String):MutableList<Articles> {
								val db: SQLiteDatabase = this.readableDatabase
								val query = "SELECT * FROM $TABLE_ARTICLE WHERE $COLUMN_NOM LIKE  %$info%  OR $COLUMN_MAGASIN LIKE  %$info% "
								val cur:Cursor = db.rawQuery(query,null)

								//Declaration de la liste et remplissage avec l'objet
								var mutLst = mutableListOf<Articles>()

								if(cur.moveToFirst())
								{
												//iterer dans le cursor,creer un nouveau objet livre et le mettre dans la list
												do {
																var articleId = cur.getInt(0)
																var articleNom = cur.getString(1)
																var articleMagasin = cur.getString(2)
																var articlePrix = cur.getDouble(3)
																var articleQuantite = cur.getInt(4)
																var articleImage = cur.getString(5)

																//Initialiser un objet article et lui attribuer les données recuperés de la bd
																var article = Articles(articleId,articleNom,articleMagasin,articlePrix,articleQuantite,articleImage)

																//Ajout de l'objet article dans la liste
																mutLst.add(article)

												}while (cur.moveToNext())
								}
								else
								{
												Toast.makeText(context,"Il n'y a pas d'article dans la liste",Toast.LENGTH_SHORT).show()
								}
								cur.close()
								db.close()
								return mutLst
				}

				override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
								TODO("Not yet implemented")
				}
}