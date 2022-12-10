package com.example.mydiaryfinal;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;

// 데이터 관리 클래스
public class DataBaseHelper extends SQLiteOpenHelper {

    private static final  int DB_VERSION = 1;
    private static final String DB_NAME = "MyDiary.db";

    String[] MoneyList = new String[18];   // 경비값만 모아놓은 배열
    String[] TypeList = new String[18];    // 경비타입만 모아놓은 배열

    public DataBaseHelper(@Nullable Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        // 테이블 생성 (최초 1회만 생성)
        db.execSQL("CREATE TABLE IF NOT EXISTS DiaryInfo(" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "title TEXT NOT NULL, " +
                "title2 TEXT NOT NULL, " +
                "content TEXT NOT NULL, " +
                "weatherType INTEGER NOT NULL, " +
                "userDate TEXT NOT NULL, " +
                "userDate2 TEXT NOT NULL, " +
                "writeDate TEXT NOT NULL," +

                "tTime1 TEXT NOT NULL," +
                "tContext1 TEXT NOT NULL," +
                "tSpin1 TEXT NOT NULL," +
                "tMoney1 TEXT NOT NULL," +

                "tTime2 TEXT NOT NULL," +
                "tContext2 TEXT NOT NULL," +
                "tSpin2 TEXT NOT NULL," +
                "tMoney2 TEXT NOT NULL," +

                "tTime3 TEXT NOT NULL," +
                "tContext3 TEXT NOT NULL," +
                "tSpin3 TEXT NOT NULL," +
                "tMoney3 TEXT NOT NULL," +

                "tTime4 TEXT NOT NULL," +
                "tContext4 TEXT NOT NULL," +
                "tSpin4 TEXT NOT NULL," +
                "tMoney4 TEXT NOT NULL," +

                "tTime5 TEXT NOT NULL," +
                "tContext5 TEXT NOT NULL," +
                "tSpin5 TEXT NOT NULL," +
                "tMoney5 TEXT NOT NULL," +

                "tTime6 TEXT NOT NULL," +
                "tContext6 TEXT NOT NULL," +
                "tSpin6 TEXT NOT NULL," +
                "tMoney6 TEXT NOT NULL," +

                "tTime7 TEXT NOT NULL," +
                "tContext7 TEXT NOT NULL," +
                "tSpin7 TEXT NOT NULL," +
                "tMoney7 TEXT NOT NULL," +

                "tTime8 TEXT NOT NULL," +
                "tContext8 TEXT NOT NULL," +
                "tSpin8 TEXT NOT NULL," +
                "tMoney8 TEXT NOT NULL," +

                "tTime9 TEXT NOT NULL," +
                "tContext9 TEXT NOT NULL," +
                "tSpin9 TEXT NOT NULL," +
                "tMoney9 TEXT NOT NULL," +

                "tTime10 TEXT NOT NULL," +
                "tContext10 TEXT NOT NULL," +
                "tSpin10 TEXT NOT NULL," +
                "tMoney10 TEXT NOT NULL," +

                "tTime11 TEXT NOT NULL," +
                "tContext11 TEXT NOT NULL," +
                "tSpin11 TEXT NOT NULL," +
                "tMoney11 TEXT NOT NULL," +

                "tTime12 TEXT NOT NULL," +
                "tContext12 TEXT NOT NULL," +
                "tSpin12 TEXT NOT NULL," +
                "tMoney12 TEXT NOT NULL," +

                "tTime13 TEXT NOT NULL," +
                "tContext13 TEXT NOT NULL," +
                "tSpin13 TEXT NOT NULL," +
                "tMoney13 TEXT NOT NULL," +

                "tTime14 TEXT NOT NULL," +
                "tContext14 TEXT NOT NULL," +
                "tSpin14 TEXT NOT NULL," +
                "tMoney14 TEXT NOT NULL," +

                "tTime15 TEXT NOT NULL," +
                "tContext15 TEXT NOT NULL," +
                "tSpin15 TEXT NOT NULL," +
                "tMoney15 TEXT NOT NULL," +

                "tTime16 TEXT NOT NULL," +
                "tContext16 TEXT NOT NULL," +
                "tSpin16 TEXT NOT NULL," +
                "tMoney16 TEXT NOT NULL," +

                "tTime17 TEXT NOT NULL," +
                "tContext17 TEXT NOT NULL," +
                "tSpin17 TEXT NOT NULL," +
                "tMoney17 TEXT NOT NULL," +

                "tTime18 TEXT NOT NULL," +
                "tContext18 TEXT NOT NULL," +
                "tSpin18 TEXT NOT NULL," +
                "tMoney18 TEXT NOT NULL)" );

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onCreate(db);
    }

    // 데이터를 DB에 저장 (insert)
    public void setInsertDiaryList(String _title, String _title2, String _content, int _weatherType, String _userDate, String _userDate2, String _writeDate,
                                   String _tTime1, String _tContext1, String _tSpin1, String _tMoney1,
                                   String _tTime2, String _tContext2, String _tSpin2, String _tMoney2,
                                   String _tTime3, String _tContext3, String _tSpin3, String _tMoney3,
                                   String _tTime4, String _tContext4, String _tSpin4, String _tMoney4,
                                   String _tTime5, String _tContext5, String _tSpin5, String _tMoney5,
                                   String _tTime6, String _tContext6, String _tSpin6, String _tMoney6,
                                   String _tTime7, String _tContext7, String _tSpin7, String _tMoney7,
                                   String _tTime8, String _tContext8, String _tSpin8, String _tMoney8,
                                   String _tTime9, String _tContext9, String _tSpin9, String _tMoney9,
                                   String _tTime10, String _tContext10, String _tSpin10, String _tMoney10,
                                   String _tTime11, String _tContext11, String _tSpin11, String _tMoney11,
                                   String _tTime12, String _tContext12, String _tSpin12, String _tMoney12,
                                   String _tTime13, String _tContext13, String _tSpin13, String _tMoney13,
                                   String _tTime14, String _tContext14, String _tSpin14, String _tMoney14,
                                   String _tTime15, String _tContext15, String _tSpin15, String _tMoney15,
                                   String _tTime16, String _tContext16, String _tSpin16, String _tMoney16,
                                   String _tTime17, String _tContext17, String _tSpin17, String _tMoney17,
                                   String _tTime18, String _tContext18, String _tSpin18, String _tMoney18) {

        SQLiteDatabase db = getWritableDatabase();

        db.execSQL("INSERT INTO DiaryInfo (title, title2, content, weatherType, userDate, userDate2, writeDate," +
                "tTime1, tContext1, tSpin1, tMoney1,tTime2, tContext2, tSpin2, tMoney2, tTime3, tContext3, tSpin3, tMoney3," +
                "tTime4, tContext4, tSpin4, tMoney4, tTime5, tContext5, tSpin5, tMoney5, tTime6, tContext6, tSpin6, tMoney6," +
                "tTime7, tContext7, tSpin7, tMoney7, tTime8, tContext8, tSpin8, tMoney8, tTime9, tContext9, tSpin9, tMoney9," +
                "tTime10, tContext10, tSpin10, tMoney10, tTime11, tContext11, tSpin11, tMoney11, tTime12, tContext12, tSpin12, tMoney12," +
                "tTime13, tContext13, tSpin13, tMoney13, tTime14, tContext14, tSpin14, tMoney14, tTime15, tContext15, tSpin15, tMoney15," +
                "tTime16, tContext16, tSpin16, tMoney16, tTime17, tContext17, tSpin17, tMoney17, tTime18, tContext18, tSpin18, tMoney18)" +
                "VALUES('" + _title + "','" + _title2 + "','" + _content + "', '" + _weatherType + "', '" + _userDate + "','" + _userDate2 + "', '" + _writeDate
                + "', '" + _tTime1 + "', '" + _tContext1 + "', '" + _tSpin1 + "', '" + _tMoney1
                + "', '" + _tTime2 + "', '" + _tContext2 + "', '" + _tSpin2 + "', '" + _tMoney2
                + "', '" + _tTime3 + "', '" + _tContext3 + "', '" + _tSpin3 + "', '" + _tMoney3
                + "', '" + _tTime4 + "', '" + _tContext4 + "', '" + _tSpin4 + "', '" + _tMoney4
                + "', '" + _tTime5 + "', '" + _tContext5 + "', '" + _tSpin5 + "', '" + _tMoney5
                + "', '" + _tTime6 + "', '" + _tContext6 + "', '" + _tSpin6 + "', '" + _tMoney6
                + "', '" + _tTime7 + "', '" + _tContext7 + "', '" + _tSpin7 + "', '" + _tMoney7
                + "', '" + _tTime8 + "', '" + _tContext8 + "', '" + _tSpin8 + "', '" + _tMoney8
                + "', '" + _tTime9 + "', '" + _tContext9 + "', '" + _tSpin9 + "', '" + _tMoney9
                + "', '" + _tTime10 + "', '" + _tContext10 + "', '" + _tSpin10 + "', '" + _tMoney10
                + "', '" + _tTime11 + "', '" + _tContext11 + "', '" + _tSpin11 + "', '" + _tMoney11
                + "', '" + _tTime12 + "', '" + _tContext12 + "', '" + _tSpin12 + "', '" + _tMoney12
                + "', '" + _tTime13 + "', '" + _tContext13 + "', '" + _tSpin13 + "', '" + _tMoney13
                + "', '" + _tTime14 + "', '" + _tContext14 + "', '" + _tSpin14 + "', '" + _tMoney14
                + "', '" + _tTime15 + "', '" + _tContext15 + "', '" + _tSpin15 + "', '" + _tMoney15
                + "', '" + _tTime16 + "', '" + _tContext16 + "', '" + _tSpin16 + "', '" + _tMoney16
                + "', '" + _tTime17 + "', '" + _tContext17 + "', '" + _tSpin17 + "', '" + _tMoney17
                + "', '" + _tTime18 + "', '" + _tContext18 + "', '" + _tSpin18 + "', '" + _tMoney18 + "')");

    }

    // 데이터 조회 기능 select read
    public ArrayList<DiaryModel> getDiaryListFromDB() {
        ArrayList<DiaryModel> lstDiary = new ArrayList<>();

        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM DiaryInfo ORDER BY writeDate DESC", null);
        if (cursor.getCount() != 0) {
            while (cursor.moveToNext()) {
                int id = cursor.getInt(cursor.getColumnIndexOrThrow("id"));
                String title = cursor.getString(cursor.getColumnIndexOrThrow("title"));
                String title2 = cursor.getString(cursor.getColumnIndexOrThrow("title2"));
                String content = cursor.getString(cursor.getColumnIndexOrThrow("content"));
                int weatherType = cursor.getInt(cursor.getColumnIndexOrThrow("weatherType"));
                String userDate = cursor.getString(cursor.getColumnIndexOrThrow("userDate"));
                String userDate2 = cursor.getString(cursor.getColumnIndexOrThrow("userDate2"));
                String writeDate = cursor.getString(cursor.getColumnIndexOrThrow("writeDate"));

                String tTime1 = cursor.getString(cursor.getColumnIndexOrThrow("tTime1"));
                String tContext1 = cursor.getString(cursor.getColumnIndexOrThrow("tContext1"));
                String tSpin1 = cursor.getString(cursor.getColumnIndexOrThrow("tSpin1"));
                String tMoney1 = cursor.getString(cursor.getColumnIndexOrThrow("tMoney1"));

                String tTime2 = cursor.getString(cursor.getColumnIndexOrThrow("tTime2"));
                String tContext2 = cursor.getString(cursor.getColumnIndexOrThrow("tContext2"));
                String tSpin2 = cursor.getString(cursor.getColumnIndexOrThrow("tSpin2"));
                String tMoney2 = cursor.getString(cursor.getColumnIndexOrThrow("tMoney2"));

                String tTime3 = cursor.getString(cursor.getColumnIndexOrThrow("tTime3"));
                String tContext3 = cursor.getString(cursor.getColumnIndexOrThrow("tContext3"));
                String tSpin3 = cursor.getString(cursor.getColumnIndexOrThrow("tSpin3"));
                String tMoney3 = cursor.getString(cursor.getColumnIndexOrThrow("tMoney3"));

                String tTime4 = cursor.getString(cursor.getColumnIndexOrThrow("tTime4"));
                String tContext4 = cursor.getString(cursor.getColumnIndexOrThrow("tContext4"));
                String tSpin4 = cursor.getString(cursor.getColumnIndexOrThrow("tSpin4"));
                String tMoney4 = cursor.getString(cursor.getColumnIndexOrThrow("tMoney4"));

                String tTime5 = cursor.getString(cursor.getColumnIndexOrThrow("tTime5"));
                String tContext5 = cursor.getString(cursor.getColumnIndexOrThrow("tContext5"));
                String tSpin5 = cursor.getString(cursor.getColumnIndexOrThrow("tSpin5"));
                String tMoney5 = cursor.getString(cursor.getColumnIndexOrThrow("tMoney5"));

                String tTime6 = cursor.getString(cursor.getColumnIndexOrThrow("tTime6"));
                String tContext6 = cursor.getString(cursor.getColumnIndexOrThrow("tContext6"));
                String tSpin6 = cursor.getString(cursor.getColumnIndexOrThrow("tSpin6"));
                String tMoney6 = cursor.getString(cursor.getColumnIndexOrThrow("tMoney6"));

                String tTime7 = cursor.getString(cursor.getColumnIndexOrThrow("tTime7"));
                String tContext7 = cursor.getString(cursor.getColumnIndexOrThrow("tContext7"));
                String tSpin7 = cursor.getString(cursor.getColumnIndexOrThrow("tSpin7"));
                String tMoney7 = cursor.getString(cursor.getColumnIndexOrThrow("tMoney7"));

                String tTime8 = cursor.getString(cursor.getColumnIndexOrThrow("tTime8"));
                String tContext8 = cursor.getString(cursor.getColumnIndexOrThrow("tContext8"));
                String tSpin8 = cursor.getString(cursor.getColumnIndexOrThrow("tSpin8"));
                String tMoney8 = cursor.getString(cursor.getColumnIndexOrThrow("tMoney8"));

                String tTime9 = cursor.getString(cursor.getColumnIndexOrThrow("tTime9"));
                String tContext9 = cursor.getString(cursor.getColumnIndexOrThrow("tContext9"));
                String tSpin9 = cursor.getString(cursor.getColumnIndexOrThrow("tSpin9"));
                String tMoney9 = cursor.getString(cursor.getColumnIndexOrThrow("tMoney9"));

                String tTime10 = cursor.getString(cursor.getColumnIndexOrThrow("tTime10"));
                String tContext10 = cursor.getString(cursor.getColumnIndexOrThrow("tContext10"));
                String tSpin10 = cursor.getString(cursor.getColumnIndexOrThrow("tSpin10"));
                String tMoney10 = cursor.getString(cursor.getColumnIndexOrThrow("tMoney10"));

                String tTime11 = cursor.getString(cursor.getColumnIndexOrThrow("tTime11"));
                String tContext11 = cursor.getString(cursor.getColumnIndexOrThrow("tContext11"));
                String tSpin11 = cursor.getString(cursor.getColumnIndexOrThrow("tSpin11"));
                String tMoney11 = cursor.getString(cursor.getColumnIndexOrThrow("tMoney11"));

                String tTime12 = cursor.getString(cursor.getColumnIndexOrThrow("tTime12"));
                String tContext12 = cursor.getString(cursor.getColumnIndexOrThrow("tContext12"));
                String tSpin12 = cursor.getString(cursor.getColumnIndexOrThrow("tSpin12"));
                String tMoney12 = cursor.getString(cursor.getColumnIndexOrThrow("tMoney12"));

                String tTime13 = cursor.getString(cursor.getColumnIndexOrThrow("tTime13"));
                String tContext13 = cursor.getString(cursor.getColumnIndexOrThrow("tContext13"));
                String tSpin13 = cursor.getString(cursor.getColumnIndexOrThrow("tSpin13"));
                String tMoney13 = cursor.getString(cursor.getColumnIndexOrThrow("tMoney13"));

                String tTime14 = cursor.getString(cursor.getColumnIndexOrThrow("tTime14"));
                String tContext14 = cursor.getString(cursor.getColumnIndexOrThrow("tContext14"));
                String tSpin14 = cursor.getString(cursor.getColumnIndexOrThrow("tSpin14"));
                String tMoney14 = cursor.getString(cursor.getColumnIndexOrThrow("tMoney14"));

                String tTime15 = cursor.getString(cursor.getColumnIndexOrThrow("tTime15"));
                String tContext15 = cursor.getString(cursor.getColumnIndexOrThrow("tContext15"));
                String tSpin15 = cursor.getString(cursor.getColumnIndexOrThrow("tSpin15"));
                String tMoney15 = cursor.getString(cursor.getColumnIndexOrThrow("tMoney15"));

                String tTime16 = cursor.getString(cursor.getColumnIndexOrThrow("tTime16"));
                String tContext16 = cursor.getString(cursor.getColumnIndexOrThrow("tContext16"));
                String tSpin16 = cursor.getString(cursor.getColumnIndexOrThrow("tSpin16"));
                String tMoney16 = cursor.getString(cursor.getColumnIndexOrThrow("tMoney16"));

                String tTime17 = cursor.getString(cursor.getColumnIndexOrThrow("tTime17"));
                String tContext17 = cursor.getString(cursor.getColumnIndexOrThrow("tContext17"));
                String tSpin17 = cursor.getString(cursor.getColumnIndexOrThrow("tSpin17"));
                String tMoney17 = cursor.getString(cursor.getColumnIndexOrThrow("tMoney17"));

                String tTime18 = cursor.getString(cursor.getColumnIndexOrThrow("tTime18"));
                String tContext18 = cursor.getString(cursor.getColumnIndexOrThrow("tContext18"));
                String tSpin18 = cursor.getString(cursor.getColumnIndexOrThrow("tSpin18"));
                String tMoney18 = cursor.getString(cursor.getColumnIndexOrThrow("tMoney18"));

                // create data class
                DiaryModel diaryModel = new DiaryModel();
                diaryModel.setId(id);
                diaryModel.setTitle(title);
                diaryModel.setTitle2(title2);
                diaryModel.setContent(content);
                diaryModel.setWeatherType(weatherType);
                diaryModel.setUserDate(userDate);
                diaryModel.setUserDate2(userDate2);
                diaryModel.setWriteDate(writeDate);

                diaryModel.setTTime1(tTime1);
                diaryModel.setTContext1(tContext1);
                diaryModel.setTSpin1(tSpin1);
                diaryModel.setTMoney1(tMoney1);

                diaryModel.setTTime2(tTime2);
                diaryModel.setTContext2(tContext2);
                diaryModel.setTSpin2(tSpin2);
                diaryModel.setTMoney2(tMoney2);

                diaryModel.setTTime3(tTime3);
                diaryModel.setTContext3(tContext3);
                diaryModel.setTSpin3(tSpin3);
                diaryModel.setTMoney3(tMoney3);

                diaryModel.setTTime4(tTime4);
                diaryModel.setTContext4(tContext4);
                diaryModel.setTSpin4(tSpin4);
                diaryModel.setTMoney4(tMoney4);

                diaryModel.setTTime5(tTime5);
                diaryModel.setTContext5(tContext5);
                diaryModel.setTSpin5(tSpin5);
                diaryModel.setTMoney5(tMoney5);

                diaryModel.setTTime6(tTime6);
                diaryModel.setTContext6(tContext6);
                diaryModel.setTSpin6(tSpin6);
                diaryModel.setTMoney6(tMoney6);

                diaryModel.setTTime7(tTime7);
                diaryModel.setTContext7(tContext7);
                diaryModel.setTSpin7(tSpin7);
                diaryModel.setTMoney7(tMoney7);

                diaryModel.setTTime8(tTime8);
                diaryModel.setTContext8(tContext8);
                diaryModel.setTSpin8(tSpin8);
                diaryModel.setTMoney8(tMoney8);

                diaryModel.setTTime9(tTime9);
                diaryModel.setTContext9(tContext9);
                diaryModel.setTSpin9(tSpin9);
                diaryModel.setTMoney9(tMoney9);

                diaryModel.setTTime10(tTime10);
                diaryModel.setTContext10(tContext10);
                diaryModel.setTSpin10(tSpin10);
                diaryModel.setTMoney10(tMoney10);

                diaryModel.setTTime11(tTime11);
                diaryModel.setTContext11(tContext11);
                diaryModel.setTSpin11(tSpin11);
                diaryModel.setTMoney11(tMoney11);

                diaryModel.setTTime12(tTime12);
                diaryModel.setTContext12(tContext12);
                diaryModel.setTSpin12(tSpin12);
                diaryModel.setTMoney12(tMoney12);

                diaryModel.setTTime13(tTime13);
                diaryModel.setTContext13(tContext13);
                diaryModel.setTSpin13(tSpin13);
                diaryModel.setTMoney13(tMoney13);

                diaryModel.setTTime14(tTime14);
                diaryModel.setTContext14(tContext14);
                diaryModel.setTSpin14(tSpin14);
                diaryModel.setTMoney14(tMoney14);

                diaryModel.setTTime15(tTime15);
                diaryModel.setTContext15(tContext15);
                diaryModel.setTSpin15(tSpin15);
                diaryModel.setTMoney15(tMoney15);

                diaryModel.setTTime16(tTime16);
                diaryModel.setTContext16(tContext16);
                diaryModel.setTSpin16(tSpin16);
                diaryModel.setTMoney16(tMoney16);

                diaryModel.setTTime17(tTime17);
                diaryModel.setTContext17(tContext17);
                diaryModel.setTSpin17(tSpin17);
                diaryModel.setTMoney17(tMoney17);

                diaryModel.setTTime18(tTime18);
                diaryModel.setTContext18(tContext18);
                diaryModel.setTSpin18(tSpin18);
                diaryModel.setTMoney18(tMoney18);

                lstDiary.add(diaryModel);

            }
        }
        cursor.close();

        return lstDiary;
    }

    // 수정 메소드 - UPDATE
    public void setUpdateDiaryList(String _title, String _title2, String _content, int _weatherType,
                                   String _userDate, String _userDate2, String _writeDate,
                                   String _tTime1, String _tContext1, String _tSpin1, String _tMoney1,
                                   String _tTime2, String _tContext2, String _tSpin2, String _tMoney2,
                                   String _tTime3, String _tContext3, String _tSpin3, String _tMoney3,
                                   String _tTime4, String _tContext4, String _tSpin4, String _tMoney4,
                                   String _tTime5, String _tContext5, String _tSpin5, String _tMoney5,
                                   String _tTime6, String _tContext6, String _tSpin6, String _tMoney6,
                                   String _tTime7, String _tContext7, String _tSpin7, String _tMoney7,
                                   String _tTime8, String _tContext8, String _tSpin8, String _tMoney8,
                                   String _tTime9, String _tContext9, String _tSpin9, String _tMoney9,
                                   String _tTime10, String _tContext10, String _tSpin10, String _tMoney10,
                                   String _tTime11, String _tContext11, String _tSpin11, String _tMoney11,
                                   String _tTime12, String _tContext12, String _tSpin12, String _tMoney12,
                                   String _tTime13, String _tContext13, String _tSpin13, String _tMoney13,
                                   String _tTime14, String _tContext14, String _tSpin14, String _tMoney14,
                                   String _tTime15, String _tContext15, String _tSpin15, String _tMoney15,
                                   String _tTime16, String _tContext16, String _tSpin16, String _tMoney16,
                                   String _tTime17, String _tContext17, String _tSpin17, String _tMoney17,
                                   String _tTime18, String _tContext18, String _tSpin18, String _tMoney18,
                                   String _beforeDate) {

        SQLiteDatabase db = getWritableDatabase();

        db.execSQL("UPDATE DiaryInfo SET title = '" + _title + "' , title2 = '" + _title2 + "' , userdate = '" + _userDate + "', userdate2 = '" + _userDate2
                + "',  content = '" + _content + "', weatherType = '" + _weatherType + "',  writeDate = '" + _writeDate
                + "', tTime1 = '" + _tTime1 + "', tContext1 = '" + _tContext1 + "', tSpin1 = '" + _tSpin1 + "', tMoney1 = '" + _tMoney1
                + "', tTime2 = '" + _tTime2 + "', tContext2 = '" + _tContext2 + "', tSpin2 = '" + _tSpin2 + "', tMoney2 = '" + _tMoney2
                + "', tTime3 = '" + _tTime3 + "', tContext3 = '" + _tContext3 + "', tSpin3 = '" + _tSpin3 + "', tMoney3 = '" + _tMoney3
                + "', tTime4 = '" + _tTime4 + "', tContext4 = '" + _tContext4 + "', tSpin4 = '" + _tSpin4 + "', tMoney4 = '" + _tMoney4
                + "', tTime5 = '" + _tTime5 + "', tContext5 = '" + _tContext5 + "', tSpin5 = '" + _tSpin5 + "', tMoney5 = '" + _tMoney5
                + "', tTime6 = '" + _tTime6 + "', tContext6 = '" + _tContext6 + "', tSpin6 = '" + _tSpin6 + "', tMoney6 = '" + _tMoney6
                + "', tTime7 = '" + _tTime7 + "', tContext7 = '" + _tContext7 + "', tSpin7 = '" + _tSpin7 + "', tMoney7 = '" + _tMoney7
                + "', tTime8 = '" + _tTime8 + "', tContext8 = '" + _tContext8 + "', tSpin8 = '" + _tSpin8 + "', tMoney8 = '" + _tMoney8
                + "', tTime9 = '" + _tTime9 + "', tContext9 = '" + _tContext9 + "', tSpin9 = '" + _tSpin9 + "', tMoney9 = '" + _tMoney9
                + "', tTime10 = '" + _tTime10 + "', tContext10 = '" + _tContext10 + "', tSpin10 = '" + _tSpin10 + "', tMoney10 = '" + _tMoney10
                + "', tTime11 = '" + _tTime11 + "', tContext11 = '" + _tContext11 + "', tSpin11 = '" + _tSpin11 + "', tMoney11 = '" + _tMoney11
                + "', tTime12 = '" + _tTime12 + "', tContext12 = '" + _tContext12 + "', tSpin12 = '" + _tSpin12 + "', tMoney12 = '" + _tMoney12
                + "', tTime13 = '" + _tTime13 + "', tContext13 = '" + _tContext13 + "', tSpin13 = '" + _tSpin13 + "', tMoney13 = '" + _tMoney13
                + "', tTime14 = '" + _tTime14 + "', tContext14 = '" + _tContext14 + "', tSpin14 = '" + _tSpin14 + "', tMoney14 = '" + _tMoney14
                + "', tTime15 = '" + _tTime15 + "', tContext15 = '" + _tContext15 + "', tSpin15 = '" + _tSpin15 + "', tMoney15 = '" + _tMoney15
                + "', tTime16 = '" + _tTime16 + "', tContext16 = '" + _tContext16 + "', tSpin16 = '" + _tSpin16 + "', tMoney16 = '" + _tMoney16
                + "', tTime17 = '" + _tTime17 + "', tContext17 = '" + _tContext17 + "', tSpin17 = '" + _tSpin17 + "', tMoney17 = '" + _tMoney17
                + "', tTime18 = '" + _tTime18 + "', tContext18 = '" + _tContext18 + "', tSpin18 = '" + _tSpin18 + "', tMoney18 = '" + _tMoney18
                + "' WHERE writeDate = '" + _beforeDate + "' ");
    }

    // 삭제 메소드 - DELETE
    public void setDeleteDiaryList(String _writeDate){
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL("DELETE FROM DiaryInfo WHERE writeDate = '" + _writeDate + "'");
    }


    // 경비 금액만 배열로 모아서 파이차트로 넘기기
    public String[] getMoneyList() {
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM DiaryInfo ORDER BY writeDate DESC", null);
        if (cursor.getCount() != 0) {
            while (cursor.moveToNext()) {
                for (int i=0; i<MoneyList.length; i++) {
                    if (cursor.getString(11+(i*4)).isEmpty()) {
                        MoneyList[i] = "0";
                    } else {
                        MoneyList[i] = cursor.getString(11+(i*4));
                    }
                }
            }
        }
        cursor.close();
        return MoneyList;
    }

    // 경비 타입만 배열로 모아서 파이차트로 넘기기
    public String[] getTypeList() {
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM DiaryInfo ORDER BY writeDate DESC", null);
        if (cursor.getCount() != 0) {
            while (cursor.moveToNext()) {
                for (int i=0; i<TypeList.length; i++) {
                    if (cursor.getString(10+(i*4)).isEmpty()) {
                        TypeList[i] = "기타";
                    } else {
                        TypeList[i] = cursor.getString(10+(i*4));
                    }
                }
            }
        }
        cursor.close();
        return TypeList;
    }

}