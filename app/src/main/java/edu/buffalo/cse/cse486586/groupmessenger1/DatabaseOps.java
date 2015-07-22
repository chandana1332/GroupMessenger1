package edu.buffalo.cse.cse486586.groupmessenger1;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by chandana on 2/18/15.
 */
public class DatabaseOps extends SQLiteOpenHelper {

    public static final int database_version = 3;
    public String Create = "CREATE TABLE " + DataTable.TableInfo.TABLE_NAME + "(" + DataTable.TableInfo.key + " TEXT," + DataTable.TableInfo.value + " TEXT,PRIMARY KEY (" + DataTable.TableInfo.key + "));";

    public DatabaseOps(Context context) {
        super(context, DataTable.TableInfo.DATABASE_NAME, null, database_version);
        //Log.d("Database Ops","Database created");
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(Create);
        Log.d("Database Ops", "Table created");
    }

    public void insertinto(DatabaseOps dbo, ContentValues values) {
        SQLiteDatabase sdb = dbo.getWritableDatabase();

        long k = sdb.insert(DataTable.TableInfo.TABLE_NAME, null, values);

        if (k < 0) {

            long w = sdb.update(DataTable.TableInfo.TABLE_NAME, values, DataTable.TableInfo.key + " = '" + values.get(DataTable.TableInfo.key).toString()
                    + "'", null);

            Log.d("Update", "Update successful");

        }
        Log.d("Database Ops", "Data inserted");

    }

    public Cursor retrievefrom(DatabaseOps dob, String key) {
        SQLiteDatabase db = dob.getReadableDatabase();

        String Cols[] = {DataTable.TableInfo.key, DataTable.TableInfo.value};
        String wherearg = "key=" + key;
        //db.execSQL("drop table "+ DataTable.TableInfo.TABLE_NAME);
        // String q="Select * from "+ DataTable.TableInfo.TABLE_NAME+"key =\"key0\"";
        Cursor CR = db.query(DataTable.TableInfo.TABLE_NAME, Cols, "key=?", new String[]{key}, null, null, null);
        if (CR != null) {
            CR.moveToFirst();
        }

        return CR;
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
