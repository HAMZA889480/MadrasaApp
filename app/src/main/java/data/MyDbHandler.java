package data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import Model.Student;
import params.Params;

public class MyDbHandler extends SQLiteOpenHelper {

    public MyDbHandler(Context context){
        super(context, Params.DB_NAME,null,Params.DB_VERSION);
    }

    //Checked
    //Calls when db is to create
    @Override
    public void onCreate(SQLiteDatabase db)
    {
        //Calls when db object is created

        //Query to create table
        String create="CREATE TABLE " + Params.TABLE_NAME + "("
                + Params.KEY_ID+ " INTEGER PRIMARY KEY," + Params.KEY_NAME
                + " TEXT, " + Params.KEY_SABKI+" TEXT, "+ Params.KEY_SABAK + " TEXT"+")";

        db.execSQL(create);
        Log.d("dbhamza","Table is Created: "+create);
        //Execute the query

    }

    //Calls when data base is modified
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {
        //Drop the dataBase when tables are modified
        String command="Drop TABLE IF EXISTS "+Params.TABLE_NAME;
        db.rawQuery(command,null);
    }

    //Checked
    public void addStudent(Student student)
    {
        //add student to data base
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues values=new ContentValues();

        //adding values
        values.put(Params.KEY_NAME, student.getName());
        values.put(Params.KEY_SABAK, student.getSabak());
        values.put(Params.KEY_SABKI, student.getSabki());

        //Inserting in data base
        db.insert(Params.TABLE_NAME, null, values);
        Log.d("dbHamza","Successfully inserted");

        //Close the db connection
        db.close();
    }

    //Checked
    public List<Student> getAllStudents()
    {
        List <Student> studentList=new ArrayList<>();
        SQLiteDatabase db=this.getReadableDatabase();

        //SQL QUERY
        String select="SELECT * FROM "+Params.TABLE_NAME;
        Cursor cursor=db.rawQuery(select, null);

        if(cursor.moveToFirst())
        {
            do
            {
                //Creating Student Object
                Student student=new Student();

                student.setId(cursor.getString(0));
                student.setName(cursor.getString(1));
                student.setSabak(cursor.getString(2));
                student.setSabki(cursor.getString(3));

                //Add to List
                studentList.add(student);
            }while(cursor.moveToNext());
        }

        return studentList;
    }


    public int updateStudent(Student stu)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues values=new ContentValues();

        //adding values
        values.put(Params.KEY_NAME, stu.getName());
        values.put(Params.KEY_SABAK, stu.getSabak());
        values.put(Params.KEY_SABKI, stu.getSabki());

        return db.update(Params.TABLE_NAME, values, Params.KEY_ID + "=?",
                new String[]{stu.getId()});
    }

    //Checked
    public Student getData(String id)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor cursor=db.rawQuery("SELECT * FROM "+Params.TABLE_NAME+" WHERE "+Params.KEY_ID+"="+id+"",null);

        Student stu=new Student();
        if(cursor.moveToNext())
        {
            do {
                stu.setId(cursor.getString(0));
                stu.setName(cursor.getString(1));
                stu.setSabak(cursor.getString(2));
                stu.setSabki(cursor.getString(3));

            }while(cursor.moveToNext());
        }
        return stu;
    }

    public Cursor getRecords()
    {
        SQLiteDatabase db=this.getReadableDatabase();

        //SQL QUERY
        String select="SELECT * FROM "+Params.TABLE_NAME;
        Cursor cursor=db.rawQuery(select, null);

        return cursor;

    }

    public Integer deleteStudent(String id)
    {
        SQLiteDatabase db=this.getWritableDatabase();

        return db.delete(Params.TABLE_NAME, Params.KEY_ID+"=?",
                new String[]{id});

    }


}
