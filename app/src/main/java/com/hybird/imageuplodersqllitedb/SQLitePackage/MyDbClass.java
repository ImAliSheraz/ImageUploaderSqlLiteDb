package com.hybird.imageuplodersqllitedb.SQLitePackage;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.widget.Toast;

import com.hybird.imageuplodersqllitedb.RecylcerPackage.DBModelClass;
import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

import java.util.ArrayList;


public class MyDbClass extends SQLiteAssetHelper {
    private static final String DATABASE_NAME= "sunset.dp";
    private static final int DATABASE_VERSION = 1;

    Context context;

    public MyDbClass(Context context) {
        super(context,DATABASE_NAME,null, DATABASE_VERSION);
        this.context = context;
    }

    public MyDbClass(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }
    public ArrayList<DBModelClass> getAllData()
    {
        try
        {
            ArrayList<DBModelClass> objDbModelClassArrayList = new ArrayList<>();
            SQLiteDatabase objSqLiteDatabase = getReadableDatabase();
            if(objSqLiteDatabase!=null)
            {
               Cursor objCursor =  objSqLiteDatabase.rawQuery("select * from sunsetdata",null);
               if(objCursor.getCount()!=0)
               {
                   while (objCursor.moveToNext())
                   {
                        String imageDes=objCursor.getString(0);
                        byte[] imageByte=objCursor.getBlob(1);
                       Bitmap ourImage = BitmapFactory.decodeByteArray(imageByte,0,imageByte.length);
                       objDbModelClassArrayList.add(
                               new DBModelClass(
                               imageDes,ourImage
                        )
                       );
                   }
                   return objDbModelClassArrayList;
               }
               else
               {
                   Toast.makeText(context, "no data is retrived", Toast.LENGTH_SHORT).show();
                   return null;
               }
            }
            else
            {
                Toast.makeText(context, "Data is null ", Toast.LENGTH_SHORT).show();
                return null;
            }
        }
        catch(Exception e)
        {
            Toast.makeText(context, "getAllData", Toast.LENGTH_SHORT).show();
            return null;
        }
    }
}
