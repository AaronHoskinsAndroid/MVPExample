package examples.aaronhoskins.com.mvpexample.model.datasource.local.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

import examples.aaronhoskins.com.mvpexample.model.datasource.tvshows.TvShow;

import static examples.aaronhoskins.com.mvpexample.model.datasource.local.database.TvDatabaseContract.COLUMN_DESC;
import static examples.aaronhoskins.com.mvpexample.model.datasource.local.database.TvDatabaseContract.COLUMN_RATING;
import static examples.aaronhoskins.com.mvpexample.model.datasource.local.database.TvDatabaseContract.COLUMN_SEASON;
import static examples.aaronhoskins.com.mvpexample.model.datasource.local.database.TvDatabaseContract.COLUMN_TITLE;
import static examples.aaronhoskins.com.mvpexample.model.datasource.local.database.TvDatabaseContract.CREATE_TABLE_QUERY;
import static examples.aaronhoskins.com.mvpexample.model.datasource.local.database.TvDatabaseContract.DATABASE_NAME;
import static examples.aaronhoskins.com.mvpexample.model.datasource.local.database.TvDatabaseContract.DATABASE_VERSION;
import static examples.aaronhoskins.com.mvpexample.model.datasource.local.database.TvDatabaseContract.SELECT_ALL_SHOWS_QUERY;
import static examples.aaronhoskins.com.mvpexample.model.datasource.local.database.TvDatabaseContract.TABLE_TVSHOW;

public class TvShowDatabaseHelper extends SQLiteOpenHelper {
    public TvShowDatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(CREATE_TABLE_QUERY);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        onCreate(sqLiteDatabase);
    }

    public TvShow getTvShowByTitle(final String title) {
        TvShow tvShow = new TvShow();
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery(SELECT_ALL_SHOWS_QUERY, null);
        if(cursor.moveToFirst()) {
                tvShow.setTitle(cursor.getString(cursor.getColumnIndex(COLUMN_TITLE)));
                tvShow.setDescription(cursor.getString(cursor.getColumnIndex(COLUMN_DESC)));
                tvShow.setSeason(cursor.getInt(cursor.getColumnIndex(COLUMN_SEASON)));
                tvShow.setRating(cursor.getString(cursor.getColumnIndex(COLUMN_RATING)));

            }

        cursor.close();
        sqLiteDatabase.close();
        return tvShow;
    }

    public ArrayList<TvShow> getAllTvShows() {
        ArrayList<TvShow> tvShowArrayList = new ArrayList<>();
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        Cursor cursor;

        cursor = sqLiteDatabase.rawQuery(SELECT_ALL_SHOWS_QUERY, null);
        if(cursor.moveToFirst()) {
            do {
                TvShow tvShow = new TvShow();
                tvShow.setTitle(cursor.getString(cursor.getColumnIndex(COLUMN_TITLE)));
                tvShow.setDescription(cursor.getString(cursor.getColumnIndex(COLUMN_DESC)));
                tvShow.setSeason(cursor.getInt(cursor.getColumnIndex(COLUMN_SEASON)));
                tvShow.setRating(cursor.getString(cursor.getColumnIndex(COLUMN_RATING)));
                tvShowArrayList.add(tvShow);
            } while (cursor.moveToNext());
        }
        cursor.close();
        sqLiteDatabase.close();
        return tvShowArrayList;
    }

    public void insertTvShowIntoDatabase(TvShow tvShow) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(COLUMN_TITLE, tvShow.getTitle());
        contentValues.put(COLUMN_DESC, tvShow.getDescription());
        contentValues.put(COLUMN_RATING, tvShow.getRating());
        contentValues.put(COLUMN_SEASON, tvShow.getSeason());

        sqLiteDatabase.insert(TABLE_TVSHOW, null, contentValues);
        sqLiteDatabase.close();
    }


}
