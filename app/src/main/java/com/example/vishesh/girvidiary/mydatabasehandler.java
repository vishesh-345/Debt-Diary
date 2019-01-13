package com.example.vishesh.girvidiary;

/**
 * Created by Vishesh on 05-Jul-18.
 */
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.content.Context;


public class mydatabasehandler extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "Custmore.db";
    public static final String TABLE_NAME = "Custmore_table";
    public static final String COL_1 = "id";
    public static final String COL_2 = "date";
    public static final String COL_3 = "customer_name";
    public static final String COL_4 = "item_name";
    public static final String COL_5 = "village_name";
    public static final String COL_6 = "mobile_no";
    public static final String COL_7 = "rate";
    //EditText editcust;
    //editcust = (EditText) findViewById(R.id.customer);



    public mydatabasehandler(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE " + TABLE_NAME + "(id INTEGER PRIMARY KEY AUTOINCREMENT, date INTEGER, customer_name TEXT, item_name TEXT, village_name TEXT, mobile_no INTEGER, rate INTEGER);";
        db.execSQL(query);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String query = "DROP TABLE IF EXISTS " + TABLE_NAME ;
        db.execSQL(query);
        onCreate(db);

    }

    public boolean insertdata(String date,String customer_n,String item_n,String village_n,String mobile_n,String rate)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COL_2,date);
        values.put(COL_3,customer_n);
        values.put(COL_4,item_n);
        values.put(COL_5,village_n);
        values.put(COL_6,mobile_n);
        values.put(COL_7,rate);
        long result = db.insert(TABLE_NAME,null,values);
        if(result==-1)
            return false;
        else
            return true;
    }
    public Cursor getAllData()
    {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("SELECT * FROM " + TABLE_NAME,null);


        return res;
    }
    public Cursor getparticulardata(String custname)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        //Cursor res = db.rawQuery("SELECT * FROM " + TABLE_NAME + " WHERE " + COL_3 + "=?",new String[]{custname});
        Cursor res = db.rawQuery("SELECT * FROM " + TABLE_NAME + " WHERE " + COL_3 + " LIKE " + "'%" + custname + "%'",null);
        return res;
    }
    public Integer deletedata(String id)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(TABLE_NAME, "id = ?",new String[]{id});
    }
   /* public Cursor sumrate()
    {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("SELECT SUM " + " ( " + COL_7 + " ) FROM " + TABLE_NAME,null);


        return res;
    }*/
}
