package com.example.tutor_hiring_app.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.tutor_hiring_app.Child;
import com.example.tutor_hiring_app.Parent;
import com.example.tutor_hiring_app.Tutor;


import com.example.tutor_hiring_app.database.TutorAppDbSchema.*;


import java.util.ArrayList;

public class TutorAppBaseHelper extends SQLiteOpenHelper {

    public static final int VERSION = 1;
    public static final String DATABASE_NAME = "TutorAppBase.db";

    //create table parent
    public static final String PARENT = "create table "+ Table.PARENT_TABLE + "(" +
            Table.Cols.F_NAME +","+
            Table.Cols.L_NAME +","+
            Table.Cols.CIVIC_NUMBER +","+
            Table.Cols.STREET_NAME +","+
            Table.Cols.APP_NUMBER +","+
            Table.Cols.CITY_NAME +","+
            Table.Cols.PROVINCE_NAME +","+
            Table.Cols.POSTAL_CODE +","+
            Table.Cols.COUNTRY_NAME +","+
            Table.Cols.TEL_NUMBER +");";

    //create table tutor
    public static final String TUTOR = "create table "+ Table.TUTOR_TABLE + "(" +
            Table.Cols.F_NAME +","+
            Table.Cols.L_NAME +","+
            Table.Cols.CIVIC_NUMBER +","+
            Table.Cols.STREET_NAME +","+
            Table.Cols.APP_NUMBER +","+
            Table.Cols.CITY_NAME +","+
            Table.Cols.PROVINCE_NAME +","+
            Table.Cols.POSTAL_CODE +","+
            Table.Cols.COUNTRY_NAME +","+
            Table.Cols.TEL_NUMBER +","+
            Table.Cols.SUBJ_NAME +","+
            Table.Cols.HOUR_FEES +","+
            Table.Cols.EXPERIENCE +");";

    //create table child
    public static final String CHILD = "create table "+ Table.CHILD_TABLE + "(" +
            Table.Cols.CHILD_F_NAME +","+
            Table.Cols.CHILD_L_NAME +","+
            Table.Cols.CHILD_AGE +");";


    public TutorAppBaseHelper(Context context)
    {
        super(context, DATABASE_NAME, null, VERSION);

    }

    @Override
    public void onCreate(SQLiteDatabase db){

        db.execSQL(PARENT);
        db.execSQL(TUTOR);
        db.execSQL(CHILD);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {

    }

    //method to get the ContentValues of a Parent object
    private static ContentValues getContentValues(Parent parent){
        ContentValues values = new ContentValues();
        values.put(Table.Cols.F_NAME, parent.getF_name());
        values.put(Table.Cols.L_NAME, parent.getL_name());
        values.put(Table.Cols.CIVIC_NUMBER, parent.getCivic_number());
        values.put(Table.Cols.STREET_NAME, parent.getStreet_name());
        values.put(Table.Cols.APP_NUMBER, parent.getApp_number());
        values.put(Table.Cols.CITY_NAME, parent.getCity_name());
        values.put(Table.Cols.PROVINCE_NAME, parent.getProvince_name());
        values.put(Table.Cols.POSTAL_CODE, parent.getPostal_code());
        values.put(Table.Cols.COUNTRY_NAME, parent.getCountry_name());
        values.put(Table.Cols.TEL_NUMBER, parent.getTel_number());
        return values;
    }

    //method to get the ContentValues of a Tutor object
    private static ContentValues getContentValues(Tutor tutor){
        ContentValues values = new ContentValues();
        values.put(Table.Cols.F_NAME, tutor.getF_name());
        values.put(Table.Cols.L_NAME, tutor.getL_name());
        values.put(Table.Cols.CIVIC_NUMBER, tutor.getCivic_number());
        values.put(Table.Cols.STREET_NAME, tutor.getStreet_name());
        values.put(Table.Cols.APP_NUMBER, tutor.getApp_number());
        values.put(Table.Cols.CITY_NAME, tutor.getCity_name());
        values.put(Table.Cols.PROVINCE_NAME, tutor.getProvince_name());
        values.put(Table.Cols.POSTAL_CODE, tutor.getPostal_code());
        values.put(Table.Cols.COUNTRY_NAME, tutor.getCountry_name());
        values.put(Table.Cols.TEL_NUMBER, tutor.getTel_number());
        values.put(Table.Cols.SUBJ_NAME, tutor.getSubj_name());
        values.put(Table.Cols.HOUR_FEES, tutor.getHour_fees());
        values.put(Table.Cols.EXPERIENCE, tutor.getExperience());
        return values;
    }

    //method to get the ContentValues of a Parent object
    private static ContentValues getContentValues(Child child){
        ContentValues values = new ContentValues();
        values.put(Table.Cols.CHILD_F_NAME, child.getChildFirstName());
        values.put(Table.Cols.CHILD_L_NAME, child.getChildLastName());
        values.put(Table.Cols.CHILD_AGE, child.getChildAge());
        return values;
    }

    //Adding a new parent record to the Database
    public void addNewParent(Parent parent){
        //writing data into database
        SQLiteDatabase db = this.getWritableDatabase();

        //creating values from ContentValues
        ContentValues values = getContentValues(parent);

        //insert values into table row
        db.insert(Table.PARENT_TABLE, null, values);

        //close database
        db.close();
    }

    //Adding a new tutor record to the Database
    public void addNewTutor(Tutor tutor){
        //writing data into database
        SQLiteDatabase db = this.getWritableDatabase();

        //creating values from ContentValues
        ContentValues values = getContentValues(tutor);

        //insert values into table row
        db.insert(Table.TUTOR_TABLE, null, values);

        //close database
        db.close();
    }

    //Adding a new Child record to the Database
    public void addNewChild(Child child){
        //writing data into database
        SQLiteDatabase db = this.getWritableDatabase();

        //creating values from ContentValues
        ContentValues values = getContentValues(child);

        //insert values into table row
        db.insert(Table.CHILD_TABLE, null, values);

        //close database
        db.close();
    }

    //Read data from database
    //Use cursor to fetch parents records from database
    public ArrayList<Parent> readParents(){

        //reading data from database
        SQLiteDatabase db = this.getReadableDatabase();

        //use Cursor to fetch records
        Cursor cursorParents = db.rawQuery("SELECT * from "+Table.PARENT_TABLE, null);

        //creating ArrayList
        ArrayList<Parent> parentModalArrayList = new ArrayList<>();

        //move Cursor to first and skipping through cursorParents
        if(cursorParents.moveToFirst()){
            do{
                parentModalArrayList.add(new Parent(cursorParents.getString(0),cursorParents.getString(1),cursorParents.getString(2),
                        cursorParents.getString(3), cursorParents.getString(4), cursorParents.getString(5), cursorParents.getString(6),
                        cursorParents.getString(7), cursorParents.getString(8), cursorParents.getLong(9)));
            }while(cursorParents.moveToNext());
        }
        //close database Cursor and return parentModalArrayList
        cursorParents.close();
        return parentModalArrayList;
    }

    //Use cursor to fetch parents records from database
    public ArrayList<Tutor> readTutors(){

        //reading data from database
        SQLiteDatabase db = this.getReadableDatabase();

        //use Cursor to fetch records
        Cursor cursorTutors = db.rawQuery("SELECT * from "+Table.TUTOR_TABLE, null);

        //creating ArrayList
        ArrayList<Tutor> tutorModalArrayList = new ArrayList<>();

        //move Cursor to first and skipping through cursorTutors
        if(cursorTutors.moveToFirst()){
            do{
                tutorModalArrayList.add(new Tutor(cursorTutors.getString(0),cursorTutors.getString(1),cursorTutors.getString(2),
                        cursorTutors.getString(3), cursorTutors.getString(4), cursorTutors.getString(5), cursorTutors.getString(6),
                        cursorTutors.getString(7), cursorTutors.getString(8), cursorTutors.getLong(9), cursorTutors.getString(10),
                        cursorTutors.getDouble(11), cursorTutors.getInt(12)));
            }while(cursorTutors.moveToNext());
        }
        //close database Cursor and return parentModalArrayList
        cursorTutors.close();
        return tutorModalArrayList;
    }

    //Use cursor to fetch childs records from database
    public ArrayList<Child> readChilds(){

        //reading data from database
        SQLiteDatabase db = this.getReadableDatabase();

        //use Cursor to fetch records
        Cursor cursorChilds = db.rawQuery("SELECT * from "+Table.CHILD_TABLE, null);

        //creating ArrayList
        ArrayList<Child> childModalArrayList = new ArrayList<>();

        //move Cursor to first and skipping through cursorTutors
        if(cursorChilds.moveToFirst()){
            do{
                childModalArrayList.add(new Child(cursorChilds.getString(0),cursorChilds.getString(1),cursorChilds.getInt(2)));
            }while(cursorChilds.moveToNext());
        }
        //close database Cursor and return parentModalArrayList
        cursorChilds.close();
        return childModalArrayList;
    }

    //update a parent record
    public void updateParent(Parent parent){
        String lastName_String = parent.getL_name();
        //creating values from ContentValues
        ContentValues values = getContentValues(parent);
        SQLiteDatabase db = this.getWritableDatabase();
        db.update(Table.PARENT_TABLE,values,Table.Cols.L_NAME+"=?",new String[] {lastName_String});
    }

    //update a Tutor record
    public void updateTutor(Tutor tutor){
        String lastName_String = tutor.getL_name();
        //creating values from ContentValues
        ContentValues values = getContentValues(tutor);
        SQLiteDatabase db = this.getWritableDatabase();
        db.update(Table.TUTOR_TABLE,values,Table.Cols.L_NAME+"=?",new String[] {lastName_String});
    }

    //update a Child record
    public void updateChild(Child child){
        String last_nameString = child.getChildLastName();
        //creating values from ContentValues
        ContentValues values = getContentValues(child);
        SQLiteDatabase db = this.getWritableDatabase();
        db.update(Table.CHILD_TABLE,values,Table.Cols.CHILD_L_NAME+"=?",new String[] {last_nameString});
    }

    //delete a parent record
    public void deleteParent(Parent parent){
        String lastName_String = parent.getL_name();
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(Table.PARENT_TABLE, Table.Cols.L_NAME+"=?",new String[] {lastName_String});
    }

    //delete a Tutor record
    public void deleteTutor(Tutor tutor){
        String lastName_String = tutor.getL_name();
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(Table.TUTOR_TABLE, Table.Cols.L_NAME+"=?",new String[] {lastName_String});
    }

    //delete a Child record
    public void deleteChild(Child child){
        String lastName_String = child.getChildLastName();
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(Table.CHILD_TABLE, Table.Cols.CHILD_L_NAME+"=?",new String[] {lastName_String});
    }

    //search a tutor by subject name
    public Tutor findTutor(String sub_name){
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "select * from "+Table.TUTOR_TABLE+" WHERE "+Table.Cols.SUBJ_NAME+" Like '%"+sub_name+"%'";
        Cursor cursorTutor = db.rawQuery(query, null);

        Tutor tutor = null;

        try {
            if (cursorTutor.moveToFirst()) {
                // creating a Billing object by reading column data
                tutor = new Tutor(cursorTutor.getString(0),cursorTutor.getString(1),cursorTutor.getString(2),cursorTutor.getString(3),
                        cursorTutor.getString(4), cursorTutor.getString(5), cursorTutor.getString(6), cursorTutor.getString(7),
                        cursorTutor.getString(8), cursorTutor.getLong(9), cursorTutor.getString(10), cursorTutor.getDouble(11),
                        cursorTutor.getInt(12));
            }
        }
        finally {
            cursorTutor.close();
        }
        return tutor;

    }
}
