package com.example.recycleapp.Databse;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;


public class RecycleDatabase extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 4;
    private static final String DATABASE_NAME = "recycleDatabase.db";

    // Recycable items
    private static final String TABLE_ITEMS = "items";

    private static final String COLUMN_ITEMS_ID = "items_id";
    private static final String COLUMN_ITEMS_NAME = "items_name";
    private static final String COLUMN_ITEMS_DESCRIPTION = "items_description";
    private static final String COLUMN_ITEMS_CATEGORY = "items_category";
    private static final String COLUMN_ITEMS_DISPOSAL = "items_disposal";


    private String CREATE_ITEMS_TABLE = "CREATE TABLE " + TABLE_ITEMS + "("
            + COLUMN_ITEMS_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," + COLUMN_ITEMS_NAME + " TEXT,"
            + COLUMN_ITEMS_DESCRIPTION + " TEXT," + COLUMN_ITEMS_CATEGORY + " TEXT," + COLUMN_ITEMS_DISPOSAL + " TEXT)";

    private String DROP_ITEMS_TABLE = "DROP TABLE IF EXISTS " + TABLE_ITEMS;

    public RecycleDatabase(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_ITEMS_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(DROP_ITEMS_TABLE);

        onCreate(db);
    }

    public void addItem(Items items)
    {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COLUMN_ITEMS_NAME, items.getName());
        values.put(COLUMN_ITEMS_DESCRIPTION, items.getDescription());
        values.put(COLUMN_ITEMS_CATEGORY, items.getCategory());
        values.put(COLUMN_ITEMS_DISPOSAL, items.getDisposal());

        db.insert(TABLE_ITEMS, null, values);
        db.close();
    }

    public Cursor getAllHousehold() {

        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.rawQuery("SELECT " + COLUMN_ITEMS_NAME + " FROM " +  TABLE_ITEMS  +  " WHERE " + COLUMN_ITEMS_DISPOSAL  + "=?", new String[]{"Household"});

        return cursor;
    }

    public Cursor getAllPlastic() {

        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.rawQuery("SELECT " + COLUMN_ITEMS_NAME + " FROM " +  TABLE_ITEMS  +  " WHERE " + COLUMN_ITEMS_DISPOSAL  + "=?", new String[]{"Plastics"});

        return cursor;
    }

    public Cursor getAllElectronics() {

        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.rawQuery("SELECT " + COLUMN_ITEMS_NAME + " FROM " +  TABLE_ITEMS  +  " WHERE " + COLUMN_ITEMS_DISPOSAL  + "=?", new String[]{"Electronics"});

        return cursor;
    }

    public Cursor getAllPaper() {

        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.rawQuery("SELECT " + COLUMN_ITEMS_NAME + " FROM " +  TABLE_ITEMS  +  " WHERE " + COLUMN_ITEMS_DISPOSAL  + "=?", new String[]{"Paper / Cardboard"});

        return cursor;
    }

    public Cursor getAllMetal() {

        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.rawQuery("SELECT " + COLUMN_ITEMS_NAME + " FROM " +  TABLE_ITEMS  +  " WHERE " + COLUMN_ITEMS_DISPOSAL  + "=?", new String[]{"Metal"});

        return cursor;
    }

    public String getItemsId(String name)
    {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor item = db.rawQuery("select * from " +  "items"  +  " where " + "items_name"  + "=?", new String[] {name});
        item.moveToFirst();
        String itemID = item.getString(0);

        return itemID;
    }

    public Cursor getItems (String itemsID)
    {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor items = db.rawQuery("SELECT * FROM " +  TABLE_ITEMS  +  " WHERE " + COLUMN_ITEMS_ID  + "=?", new String[]{itemsID});
        return  items;
    }
}
