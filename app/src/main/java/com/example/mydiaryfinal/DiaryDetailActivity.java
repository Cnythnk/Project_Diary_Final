package com.example.mydiaryfinal;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.mydiaryfinal.DataBaseHelper;
import com.example.mydiaryfinal.DiaryModel;
import com.google.android.material.radiobutton.MaterialRadioButton;

import org.w3c.dom.Text;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.regex.Pattern;

/**
 * 상세보기 화면 or 작성하기 화면이다.
 */

public class DiaryDetailActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView mTvDate_start, mTvDate_end;    // 일시 설정 텍스트

    private EditText mEtTitle, mEtTitle2, mEtContent,
                     mETtime1, mETcontext1, mETMoney1, mETtime2, mETcontext2, mETMoney2,
                     mETtime3, mETcontext3, mETMoney3, mETtime4, mETcontext4, mETMoney4,
                     mETtime5, mETcontext5, mETMoney5, mETtime6, mETcontext6, mETMoney6,
                     mETtime7, mETcontext7, mETMoney7, mETtime8, mETcontext8, mETMoney8,
                     mETtime9, mETcontext9, mETMoney9, mETtime10, mETcontext10, mETMoney10,
                     mETtime11, mETcontext11, mETMoney11, mETtime12, mETcontext12, mETMoney12,
                     mETtime13, mETcontext13, mETMoney13, mETtime14, mETcontext14, mETMoney14,
                     mETtime15, mETcontext15, mETMoney15, mETtime16, mETcontext16, mETMoney16,
                     mETtime17, mETcontext17, mETMoney17, mETtime18, mETcontext18, mETMoney18;

    private Spinner MSpinner1, MSpinner2, MSpinner3, MSpinner4, MSpinner5, MSpinner6,
                    MSpinner7, MSpinner8, MSpinner9, MSpinner10, MSpinner11, MSpinner12,
                    MSpinner13, MSpinner14, MSpinner15, MSpinner16, MSpinner17, MSpinner18;

    private TextView SpinResult1, SpinResult2, SpinResult3, SpinResult4, SpinResult5, SpinResult6,
                     SpinResult7, SpinResult8, SpinResult9, SpinResult10, SpinResult11, SpinResult12,
                     SpinResult13, SpinResult14, SpinResult15, SpinResult16, SpinResult17, SpinResult18;

    private boolean  isFirstSelected = true;
    private boolean  isFirstSelected2 = true;
    private boolean  isFirstSelected3 = true;
    private boolean  isFirstSelected4 = true;
    private boolean  isFirstSelected5 = true;
    private boolean  isFirstSelected6 = true;
    private boolean  isFirstSelected7 = true;
    private boolean  isFirstSelected8 = true;
    private boolean  isFirstSelected9 = true;
    private boolean  isFirstSelected10 = true;
    private boolean  isFirstSelected11 = true;
    private boolean  isFirstSelected12 = true;
    private boolean  isFirstSelected13 = true;
    private boolean  isFirstSelected14 = true;
    private boolean  isFirstSelected15 = true;
    private boolean  isFirstSelected16 = true;
    private boolean  isFirstSelected17 = true;
    private boolean  isFirstSelected18 = true;

    private RadioGroup mRgWeather;

    private String mDetailMode = "";                    // intent로 받아낸 게시글 모드
    private String mBeforeDate = "";                    // intent로 받아낸 게시글 기준 작성 일자
    private String mSelectedUserDate_start = "";        // 선택된 일시 값
    private String mSelectedUserDate_end = "";          // 선택된 일시 값
    private int mSelectiveWeatherType = -1;             // 선택된 날씨 값(1 ~ 4)

    private DataBaseHelper mDatabaseHelper;             // Database 유틸객체

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diary_detail);

        Resources res = getResources();
        String[] mn_type = res.getStringArray(R.array.typeArray);

        // 경비 Spinner 연결하기
        SpinResult1 = (TextView) findViewById(R.id.tableSpinnerResult_1);
        MSpinner1 = (Spinner) findViewById(R.id.tableSpinner_1);
        ArrayAdapter<String> adapter1;
        adapter1 = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, mn_type);
        MSpinner1.setAdapter(adapter1);
        MSpinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if (isFirstSelected) {
                    isFirstSelected = false;
                } else {
                    SpinResult1.setText(adapterView.getItemAtPosition(i).toString());
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        SpinResult2 = (TextView) findViewById(R.id.tableSpinnerResult_2);
        MSpinner2 = (Spinner) findViewById(R.id.tableSpinner_2);
        ArrayAdapter<String> adapter2;
        adapter2 = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, mn_type);
        MSpinner2.setAdapter(adapter2);
        MSpinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if (isFirstSelected2) {
                    isFirstSelected2 = false;
                } else {
                    SpinResult2.setText(adapterView.getItemAtPosition(i).toString());
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        SpinResult3 = (TextView) findViewById(R.id.tableSpinnerResult_3);
        MSpinner3 = (Spinner) findViewById(R.id.tableSpinner_3);
        ArrayAdapter<String> adapter3;
        adapter3 = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, mn_type);
        MSpinner3.setAdapter(adapter3);
        MSpinner3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if (isFirstSelected3) {
                    isFirstSelected3 = false;
                } else {
                    SpinResult3.setText(adapterView.getItemAtPosition(i).toString());
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        SpinResult4 = (TextView) findViewById(R.id.tableSpinnerResult_4);
        MSpinner4 = (Spinner) findViewById(R.id.tableSpinner_4);
        ArrayAdapter<String> adapter4;
        adapter4 = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, mn_type);
        MSpinner4.setAdapter(adapter4);
        MSpinner4.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if (isFirstSelected4) {
                    isFirstSelected4 = false;
                } else {
                    SpinResult4.setText(adapterView.getItemAtPosition(i).toString());
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        SpinResult5 = (TextView) findViewById(R.id.tableSpinnerResult_5);
        MSpinner5 = (Spinner) findViewById(R.id.tableSpinner_5);
        ArrayAdapter<String> adapter5;
        adapter5 = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, mn_type);
        MSpinner5.setAdapter(adapter5);
        MSpinner5.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if (isFirstSelected5) {
                    isFirstSelected5 = false;
                } else {
                    SpinResult5.setText(adapterView.getItemAtPosition(i).toString());
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        SpinResult6 = (TextView) findViewById(R.id.tableSpinnerResult_6);
        MSpinner6 = (Spinner) findViewById(R.id.tableSpinner_6);
        ArrayAdapter<String> adapter6;
        adapter6 = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, mn_type);
        MSpinner6.setAdapter(adapter6);
        MSpinner6.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if (isFirstSelected6) {
                    isFirstSelected6 = false;
                } else {
                    SpinResult6.setText(adapterView.getItemAtPosition(i).toString());
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        SpinResult7 = (TextView) findViewById(R.id.tableSpinnerResult_7);
        MSpinner7 = (Spinner) findViewById(R.id.tableSpinner_7);
        ArrayAdapter<String> adapter7;
        adapter7 = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, mn_type);
        MSpinner7.setAdapter(adapter7);
        MSpinner7.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if (isFirstSelected7) {
                    isFirstSelected7 = false;
                } else {
                    SpinResult7.setText(adapterView.getItemAtPosition(i).toString());
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        SpinResult8 = (TextView) findViewById(R.id.tableSpinnerResult_8);
        MSpinner8 = (Spinner) findViewById(R.id.tableSpinner_8);
        ArrayAdapter<String> adapter8;
        adapter8 = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, mn_type);
        MSpinner8.setAdapter(adapter8);
        MSpinner8.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if (isFirstSelected8) {
                    isFirstSelected8 = false;
                } else {
                    SpinResult8.setText(adapterView.getItemAtPosition(i).toString());
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        SpinResult9 = (TextView) findViewById(R.id.tableSpinnerResult_9);
        MSpinner9 = (Spinner) findViewById(R.id.tableSpinner_9);
        ArrayAdapter<String> adapter9;
        adapter9 = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, mn_type);
        MSpinner9.setAdapter(adapter9);
        MSpinner9.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if (isFirstSelected9) {
                    isFirstSelected9 = false;
                } else {
                    SpinResult9.setText(adapterView.getItemAtPosition(i).toString());
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        SpinResult10 = (TextView) findViewById(R.id.tableSpinnerResult_10);
        MSpinner10 = (Spinner) findViewById(R.id.tableSpinner_10);
        ArrayAdapter<String> adapter10;
        adapter10 = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, mn_type);
        MSpinner10.setAdapter(adapter10);
        MSpinner10.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if (isFirstSelected10) {
                    isFirstSelected10 = false;
                } else {
                    SpinResult10.setText(adapterView.getItemAtPosition(i).toString());
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        SpinResult11 = (TextView) findViewById(R.id.tableSpinnerResult_11);
        MSpinner11 = (Spinner) findViewById(R.id.tableSpinner_11);
        ArrayAdapter<String> adapter11;
        adapter11 = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, mn_type);
        MSpinner11.setAdapter(adapter11);
        MSpinner11.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if (isFirstSelected11) {
                    isFirstSelected11 = false;
                } else {
                    SpinResult11.setText(adapterView.getItemAtPosition(i).toString());
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        SpinResult12 = (TextView) findViewById(R.id.tableSpinnerResult_12);
        MSpinner12 = (Spinner) findViewById(R.id.tableSpinner_12);
        ArrayAdapter<String> adapter12;
        adapter12 = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, mn_type);
        MSpinner12.setAdapter(adapter12);
        MSpinner12.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if (isFirstSelected12) {
                    isFirstSelected12 = false;
                } else {
                    SpinResult12.setText(adapterView.getItemAtPosition(i).toString());
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        SpinResult13 = (TextView) findViewById(R.id.tableSpinnerResult_13);
        MSpinner13 = (Spinner) findViewById(R.id.tableSpinner_13);
        ArrayAdapter<String> adapter13;
        adapter13 = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, mn_type);
        MSpinner13.setAdapter(adapter13);
        MSpinner13.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if (isFirstSelected13) {
                    isFirstSelected13 = false;
                } else {
                    SpinResult13.setText(adapterView.getItemAtPosition(i).toString());
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        SpinResult14 = (TextView) findViewById(R.id.tableSpinnerResult_14);
        MSpinner14 = (Spinner) findViewById(R.id.tableSpinner_14);
        ArrayAdapter<String> adapter14;
        adapter14 = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, mn_type);
        MSpinner14.setAdapter(adapter14);
        MSpinner14.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if (isFirstSelected14) {
                    isFirstSelected14 = false;
                } else {
                    SpinResult14.setText(adapterView.getItemAtPosition(i).toString());
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        SpinResult15 = (TextView) findViewById(R.id.tableSpinnerResult_15);
        MSpinner15 = (Spinner) findViewById(R.id.tableSpinner_15);
        ArrayAdapter<String> adapter15;
        adapter15 = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, mn_type);
        MSpinner15.setAdapter(adapter15);
        MSpinner15.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if (isFirstSelected15) {
                    isFirstSelected15 = false;
                } else {
                    SpinResult15.setText(adapterView.getItemAtPosition(i).toString());
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        SpinResult16 = (TextView) findViewById(R.id.tableSpinnerResult_16);
        MSpinner16 = (Spinner) findViewById(R.id.tableSpinner_16);
        ArrayAdapter<String> adapter16;
        adapter16 = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, mn_type);
        MSpinner16.setAdapter(adapter16);
        MSpinner16.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if (isFirstSelected16) {
                    isFirstSelected16 = false;
                } else {
                    SpinResult16.setText(adapterView.getItemAtPosition(i).toString());
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        SpinResult17 = (TextView) findViewById(R.id.tableSpinnerResult_17);
        MSpinner17 = (Spinner) findViewById(R.id.tableSpinner_17);
        ArrayAdapter<String> adapter17;
        adapter17 = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, mn_type);
        MSpinner17.setAdapter(adapter17);
        MSpinner17.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if (isFirstSelected17) {
                    isFirstSelected17 = false;
                } else {
                    SpinResult17.setText(adapterView.getItemAtPosition(i).toString());
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        SpinResult18 = (TextView) findViewById(R.id.tableSpinnerResult_18);
        MSpinner18 = (Spinner) findViewById(R.id.tableSpinner_18);
        ArrayAdapter<String> adapter18;
        adapter18 = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, mn_type);
        MSpinner18.setAdapter(adapter18);
        MSpinner18.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if (isFirstSelected18) {
                    isFirstSelected18 = false;
                } else {
                    SpinResult18.setText(adapterView.getItemAtPosition(i).toString());
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        // DataBase 객체 생성
        mDatabaseHelper = new DataBaseHelper(this);

        mTvDate_start = findViewById(R.id.tv_date);             // 일시 설정 텍스트
        mTvDate_end = findViewById(R.id.tv_date2);
        mEtTitle = findViewById(R.id.et_title);                 // 제목
        mEtTitle2 = findViewById(R.id.et_title2);               // 여행지
        mEtContent = findViewById(R.id.et_content);             // 내용
        mRgWeather = findViewById(R.id.rg_weather);             // 날씨 선택 라디오 그룹

        mETtime1 = findViewById(R.id.tableTime_1);
        mETtime2 = findViewById(R.id.tableTime_2);
        mETtime3 = findViewById(R.id.tableTime_3);
        mETtime4 = findViewById(R.id.tableTime_4);
        mETtime5 = findViewById(R.id.tableTime_5);
        mETtime6 = findViewById(R.id.tableTime_6);
        mETtime7 = findViewById(R.id.tableTime_7);
        mETtime8 = findViewById(R.id.tableTime_8);
        mETtime9 = findViewById(R.id.tableTime_9);
        mETtime10 = findViewById(R.id.tableTime_10);
        mETtime11 = findViewById(R.id.tableTime_11);
        mETtime12 = findViewById(R.id.tableTime_12);
        mETtime13 = findViewById(R.id.tableTime_13);
        mETtime14 = findViewById(R.id.tableTime_14);
        mETtime15 = findViewById(R.id.tableTime_15);
        mETtime16 = findViewById(R.id.tableTime_16);
        mETtime17 = findViewById(R.id.tableTime_17);
        mETtime18 = findViewById(R.id.tableTime_18);

        mETcontext1 = findViewById(R.id.tableContext_1);
        mETcontext2 = findViewById(R.id.tableContext_2);
        mETcontext3 = findViewById(R.id.tableContext_3);
        mETcontext4 = findViewById(R.id.tableContext_4);
        mETcontext5 = findViewById(R.id.tableContext_5);
        mETcontext6 = findViewById(R.id.tableContext_6);
        mETcontext7 = findViewById(R.id.tableContext_7);
        mETcontext8 = findViewById(R.id.tableContext_8);
        mETcontext9 = findViewById(R.id.tableContext_9);
        mETcontext10 = findViewById(R.id.tableContext_10);
        mETcontext11 = findViewById(R.id.tableContext_11);
        mETcontext12 = findViewById(R.id.tableContext_12);
        mETcontext13 = findViewById(R.id.tableContext_13);
        mETcontext14 = findViewById(R.id.tableContext_14);
        mETcontext15 = findViewById(R.id.tableContext_15);
        mETcontext16 = findViewById(R.id.tableContext_16);
        mETcontext17 = findViewById(R.id.tableContext_17);
        mETcontext18 = findViewById(R.id.tableContext_18);

        mETMoney1 = findViewById(R.id.tableMoney_1);
        mETMoney2 = findViewById(R.id.tableMoney_2);
        mETMoney3 = findViewById(R.id.tableMoney_3);
        mETMoney4 = findViewById(R.id.tableMoney_4);
        mETMoney5 = findViewById(R.id.tableMoney_5);
        mETMoney6 = findViewById(R.id.tableMoney_6);
        mETMoney7 = findViewById(R.id.tableMoney_7);
        mETMoney8 = findViewById(R.id.tableMoney_8);
        mETMoney9 = findViewById(R.id.tableMoney_9);
        mETMoney10 = findViewById(R.id.tableMoney_10);
        mETMoney11 = findViewById(R.id.tableMoney_11);
        mETMoney12 = findViewById(R.id.tableMoney_12);
        mETMoney13 = findViewById(R.id.tableMoney_13);
        mETMoney14 = findViewById(R.id.tableMoney_14);
        mETMoney15 = findViewById(R.id.tableMoney_15);
        mETMoney16 = findViewById(R.id.tableMoney_16);
        mETMoney17 = findViewById(R.id.tableMoney_17);
        mETMoney18 = findViewById(R.id.tableMoney_18);

        ImageView iv_back = findViewById(R.id.iv_back);         // 뒤로가기 버튼
        ImageView iv_check = findViewById(R.id.iv_check);       // 작성완료 버튼
        ImageView btn_next = findViewById(R.id.btn_next);       // 파이차트 버튼

        mTvDate_start.setOnClickListener(this);     // 클릭 기능 부여
        mTvDate_end.setOnClickListener(this);
        iv_back.setOnClickListener(this);
        iv_check.setOnClickListener(this);
        btn_next.setOnClickListener(this);

        mETtime1.setOnClickListener(this);
        mETtime2.setOnClickListener(this);
        mETtime3.setOnClickListener(this);
        mETtime4.setOnClickListener(this);
        mETtime5.setOnClickListener(this);
        mETtime6.setOnClickListener(this);
        mETtime7.setOnClickListener(this);
        mETtime8.setOnClickListener(this);
        mETtime9.setOnClickListener(this);
        mETtime10.setOnClickListener(this);
        mETtime11.setOnClickListener(this);
        mETtime12.setOnClickListener(this);
        mETtime13.setOnClickListener(this);
        mETtime14.setOnClickListener(this);
        mETtime15.setOnClickListener(this);
        mETtime16.setOnClickListener(this);
        mETtime17.setOnClickListener(this);
        mETtime18.setOnClickListener(this);

        mETcontext1.setOnClickListener(this);
        mETcontext2.setOnClickListener(this);
        mETcontext3.setOnClickListener(this);
        mETcontext4.setOnClickListener(this);
        mETcontext5.setOnClickListener(this);
        mETcontext6.setOnClickListener(this);
        mETcontext7.setOnClickListener(this);
        mETcontext8.setOnClickListener(this);
        mETcontext9.setOnClickListener(this);
        mETcontext10.setOnClickListener(this);
        mETcontext11.setOnClickListener(this);
        mETcontext12.setOnClickListener(this);
        mETcontext13.setOnClickListener(this);
        mETcontext14.setOnClickListener(this);
        mETcontext15.setOnClickListener(this);
        mETcontext16.setOnClickListener(this);
        mETcontext17.setOnClickListener(this);
        mETcontext18.setOnClickListener(this);

        mETMoney1.setOnClickListener(this);
        mETMoney2.setOnClickListener(this);
        mETMoney3.setOnClickListener(this);
        mETMoney4.setOnClickListener(this);
        mETMoney5.setOnClickListener(this);
        mETMoney6.setOnClickListener(this);
        mETMoney7.setOnClickListener(this);
        mETMoney8.setOnClickListener(this);
        mETMoney9.setOnClickListener(this);
        mETMoney10.setOnClickListener(this);
        mETMoney11.setOnClickListener(this);
        mETMoney12.setOnClickListener(this);
        mETMoney13.setOnClickListener(this);
        mETMoney14.setOnClickListener(this);
        mETMoney15.setOnClickListener(this);
        mETMoney16.setOnClickListener(this);
        mETMoney17.setOnClickListener(this);
        mETMoney18.setOnClickListener(this);

        // 기본으로 설정된 날씨의 값을 지정 (디바이스 현재 시간 기준)
        mSelectedUserDate_start = new SimpleDateFormat("yyyy/MM/dd (EE)", Locale.KOREA).format(new Date());
        mTvDate_start.setText(mSelectedUserDate_start);

        mSelectedUserDate_end = new SimpleDateFormat("yyyy/MM/dd (EE)", Locale.KOREA).format(new Date());
        mTvDate_end.setText(mSelectedUserDate_end);

        // 이전 Activity 값을 전달 받기
        Intent intent = getIntent();
        if (intent.getExtras() != null) {
            // intent putExtra 했던 데이터가 존재한다면 내부를 수행
            DiaryModel diaryModel = (DiaryModel) intent.getSerializableExtra("diaryModel");
            mDetailMode = intent.getStringExtra("mode");
            mBeforeDate = diaryModel.getWriteDate(); // 게시글 database update 처리를 위해서 여기서 받아둔다.

            // 넘겨받은 값을 활용해서 필드들을 설정해주기
            mEtTitle.setText(diaryModel.getTitle());
            mEtTitle2.setText(diaryModel.getTitle2());
            mEtContent.setText(diaryModel.getContent());

            int weatherType = diaryModel.getWeatherType();
            ((MaterialRadioButton) mRgWeather.getChildAt(weatherType)).setChecked(true);

            SpinResult1.setText(diaryModel.getTSpin1());
            SpinResult2.setText(diaryModel.getTSpin2());
            SpinResult3.setText(diaryModel.getTSpin3());
            SpinResult4.setText(diaryModel.getTSpin4());
            SpinResult5.setText(diaryModel.getTSpin5());
            SpinResult6.setText(diaryModel.getTSpin6());
            SpinResult7.setText(diaryModel.getTSpin7());
            SpinResult8.setText(diaryModel.getTSpin8());
            SpinResult9.setText(diaryModel.getTSpin9());
            SpinResult10.setText(diaryModel.getTSpin10());
            SpinResult11.setText(diaryModel.getTSpin11());
            SpinResult12.setText(diaryModel.getTSpin12());
            SpinResult13.setText(diaryModel.getTSpin13());
            SpinResult14.setText(diaryModel.getTSpin14());
            SpinResult15.setText(diaryModel.getTSpin15());
            SpinResult16.setText(diaryModel.getTSpin16());
            SpinResult17.setText(diaryModel.getTSpin17());
            SpinResult18.setText(diaryModel.getTSpin18());

            mSelectedUserDate_start = diaryModel.getUserDate();
            mSelectedUserDate_end = diaryModel.getUserDate2();

            mTvDate_start.setText(diaryModel.getUserDate());
            mTvDate_end.setText(diaryModel.getUserDate2());

            mETtime1.setText(diaryModel.getTTime1());
            mETtime2.setText(diaryModel.getTTime2());
            mETtime3.setText(diaryModel.getTTime3());
            mETtime4.setText(diaryModel.getTTime4());
            mETtime5.setText(diaryModel.getTTime5());
            mETtime6.setText(diaryModel.getTTime6());
            mETtime7.setText(diaryModel.getTTime7());
            mETtime8.setText(diaryModel.getTTime8());
            mETtime9.setText(diaryModel.getTTime9());
            mETtime10.setText(diaryModel.getTTime10());
            mETtime11.setText(diaryModel.getTTime11());
            mETtime12.setText(diaryModel.getTTime12());
            mETtime13.setText(diaryModel.getTTime13());
            mETtime14.setText(diaryModel.getTTime14());
            mETtime15.setText(diaryModel.getTTime15());
            mETtime16.setText(diaryModel.getTTime16());
            mETtime17.setText(diaryModel.getTTime17());
            mETtime18.setText(diaryModel.getTTime18());

            mETcontext1.setText(diaryModel.getTContext1());
            mETcontext2.setText(diaryModel.getTContext2());
            mETcontext3.setText(diaryModel.getTContext3());
            mETcontext4.setText(diaryModel.getTContext4());
            mETcontext5.setText(diaryModel.getTContext5());
            mETcontext6.setText(diaryModel.getTContext6());
            mETcontext7.setText(diaryModel.getTContext7());
            mETcontext8.setText(diaryModel.getTContext8());
            mETcontext9.setText(diaryModel.getTContext9());
            mETcontext10.setText(diaryModel.getTContext10());
            mETcontext11.setText(diaryModel.getTContext11());
            mETcontext12.setText(diaryModel.getTContext12());
            mETcontext13.setText(diaryModel.getTContext13());
            mETcontext14.setText(diaryModel.getTContext14());
            mETcontext15.setText(diaryModel.getTContext15());
            mETcontext16.setText(diaryModel.getTContext16());
            mETcontext17.setText(diaryModel.getTContext17());
            mETcontext18.setText(diaryModel.getTContext18());

            mETMoney1.setText(diaryModel.getTMoney1());
            mETMoney2.setText(diaryModel.getTMoney2());
            mETMoney3.setText(diaryModel.getTMoney3());
            mETMoney4.setText(diaryModel.getTMoney4());
            mETMoney5.setText(diaryModel.getTMoney5());
            mETMoney6.setText(diaryModel.getTMoney6());
            mETMoney7.setText(diaryModel.getTMoney7());
            mETMoney8.setText(diaryModel.getTMoney8());
            mETMoney9.setText(diaryModel.getTMoney9());
            mETMoney10.setText(diaryModel.getTMoney10());
            mETMoney11.setText(diaryModel.getTMoney11());
            mETMoney12.setText(diaryModel.getTMoney12());
            mETMoney13.setText(diaryModel.getTMoney13());
            mETMoney14.setText(diaryModel.getTMoney14());
            mETMoney15.setText(diaryModel.getTMoney15());
            mETMoney16.setText(diaryModel.getTMoney16());
            mETMoney17.setText(diaryModel.getTMoney17());
            mETMoney18.setText(diaryModel.getTMoney18());

            if (mDetailMode.equals("modify")) {
                //수정모드
                TextView tv_header_title = findViewById(R.id.tv_header_title);
                tv_header_title.setText("일기 수정");

            } else if (mDetailMode.equals("detail")) {
                //상세 보기 모드
                TextView tv_header_title = findViewById(R.id.tv_header_title);
                tv_header_title.setText("일기 상세보기");
                btn_next.setVisibility(View.VISIBLE);

                //읽기 전용 화면으로 표시
                MSpinner1.setEnabled(false);
                MSpinner2.setEnabled(false);
                MSpinner3.setEnabled(false);
                MSpinner4.setEnabled(false);
                MSpinner5.setEnabled(false);
                MSpinner6.setEnabled(false);
                MSpinner7.setEnabled(false);
                MSpinner8.setEnabled(false);
                MSpinner9.setEnabled(false);
                MSpinner10.setEnabled(false);
                MSpinner11.setEnabled(false);
                MSpinner12.setEnabled(false);
                MSpinner13.setEnabled(false);
                MSpinner14.setEnabled(false);
                MSpinner15.setEnabled(false);
                MSpinner16.setEnabled(false);
                MSpinner17.setEnabled(false);
                MSpinner18.setEnabled(false);

                SpinResult1.setEnabled(false);
                SpinResult2.setEnabled(false);
                SpinResult3.setEnabled(false);
                SpinResult4.setEnabled(false);
                SpinResult5.setEnabled(false);
                SpinResult6.setEnabled(false);
                SpinResult7.setEnabled(false);
                SpinResult8.setEnabled(false);
                SpinResult9.setEnabled(false);
                SpinResult10.setEnabled(false);
                SpinResult11.setEnabled(false);
                SpinResult12.setEnabled(false);
                SpinResult13.setEnabled(false);
                SpinResult14.setEnabled(false);
                SpinResult15.setEnabled(false);
                SpinResult16.setEnabled(false);
                SpinResult17.setEnabled(false);
                SpinResult18.setEnabled(false);

                mEtTitle.setEnabled(false);
                mEtTitle2.setEnabled(false);
                mEtContent.setEnabled(false);

                mTvDate_start.setEnabled(false);
                mTvDate_end.setEnabled(false);

                mETtime1.setEnabled(false);
                mETtime2.setEnabled(false);
                mETtime3.setEnabled(false);
                mETtime4.setEnabled(false);
                mETtime5.setEnabled(false);
                mETtime6.setEnabled(false);
                mETtime7.setEnabled(false);
                mETtime8.setEnabled(false);
                mETtime9.setEnabled(false);
                mETtime10.setEnabled(false);
                mETtime11.setEnabled(false);
                mETtime12.setEnabled(false);
                mETtime13.setEnabled(false);
                mETtime14.setEnabled(false);
                mETtime15.setEnabled(false);
                mETtime16.setEnabled(false);
                mETtime17.setEnabled(false);
                mETtime18.setEnabled(false);

                mETcontext1.setEnabled(false);
                mETcontext2.setEnabled(false);
                mETcontext3.setEnabled(false);
                mETcontext4.setEnabled(false);
                mETcontext5.setEnabled(false);
                mETcontext6.setEnabled(false);
                mETcontext7.setEnabled(false);
                mETcontext8.setEnabled(false);
                mETcontext9.setEnabled(false);
                mETcontext10.setEnabled(false);
                mETcontext11.setEnabled(false);
                mETcontext12.setEnabled(false);
                mETcontext13.setEnabled(false);
                mETcontext14.setEnabled(false);
                mETcontext15.setEnabled(false);
                mETcontext16.setEnabled(false);
                mETcontext17.setEnabled(false);
                mETcontext18.setEnabled(false);

                mETMoney1.setEnabled(false);
                mETMoney2.setEnabled(false);
                mETMoney3.setEnabled(false);
                mETMoney4.setEnabled(false);
                mETMoney5.setEnabled(false);
                mETMoney6.setEnabled(false);
                mETMoney7.setEnabled(false);
                mETMoney8.setEnabled(false);
                mETMoney9.setEnabled(false);
                mETMoney10.setEnabled(false);
                mETMoney11.setEnabled(false);
                mETMoney12.setEnabled(false);
                mETMoney13.setEnabled(false);
                mETMoney14.setEnabled(false);
                mETMoney15.setEnabled(false);
                mETMoney16.setEnabled(false);
                mETMoney17.setEnabled(false);
                mETMoney18.setEnabled(false);

                for (int i=0; i < mRgWeather.getChildCount(); i++) {
                    // 라디오 그룹 내에 읽기전용
                    mRgWeather.getChildAt(i).setEnabled(false);
                }
                // 작성완료 버튼을 투명처리한다.
                iv_check.setVisibility(View.INVISIBLE);
            }
        }
    }

    @Override
    public void onClick(View view) {
        // setOnClickListener 붙어있는 뷰들은 클릭하면 모두 이곳을 수행하게 된다.
        switch (view.getId()) {
            case R.id.iv_back:
                // 뒤로가기
                finish();       // 현재 액티비티 종료
                break;

            case R.id.iv_check:
                // 작성 완료

                // 라디오 그룹의 버튼 클릭 현재 상황 가지고 오기
                mSelectiveWeatherType = mRgWeather.indexOfChild(findViewById(mRgWeather.getCheckedRadioButtonId()));

                // 입력필드 작성란이 비어있는지 체크
                if(mEtTitle.getText().length() == 0 || mEtTitle2.getText().length() == 0) {
                    // error
                    Toast.makeText(this, "입력되지 않은 필드가 존재합니다.", Toast.LENGTH_SHORT).show();
                    return;     // 밑의 로직을 태우지 않고 되돌려 보냄
                }

                // 날씨 선택이 되어있는지 체크
                if (mSelectiveWeatherType == -1) {
                    // error
                    Toast.makeText(this, "날씨를 선택해주세요.", Toast.LENGTH_SHORT).show();
                    return;     // 밑의 로직을 태우지 않고 되돌려 보냄
                }

                // 시간의 형식이 맞지 않을 때
                EditText[] timeTableN = {
                        mETtime1, mETtime2, mETtime3,
                        mETtime4, mETtime5, mETtime6,
                        mETtime7, mETtime8, mETtime9,
                        mETtime10, mETtime11, mETtime12,
                        mETtime13, mETtime14, mETtime15,
                        mETtime16, mETtime17, mETtime18
                };

                Integer[] timetableID = {
                        R.id.tableTime_1, R.id.tableTime_2, R.id.tableTime_3,
                        R.id.tableTime_4, R.id.tableTime_5, R.id.tableTime_6,
                        R.id.tableTime_7, R.id.tableTime_8, R.id.tableTime_9,
                        R.id.tableTime_10, R.id.tableTime_11, R.id.tableTime_12,
                        R.id.tableTime_13, R.id.tableTime_14, R.id.tableTime_15,
                        R.id.tableTime_16, R.id.tableTime_17, R.id.tableTime_18,
                };

                for (int i=0; i<timeTableN.length; i++) {
                    timeTableN[i] = findViewById(timetableID[i]);
                }

                for (int i=0; i<18; i++) {
                    if (!Pattern.matches("^([0-9]{1,2}):([0-9]{1,2})$", (CharSequence) timeTableN[i].getText().toString())) {
                        // error
                        Toast.makeText(this, "시간 형식을 지켜주세요.", Toast.LENGTH_SHORT).show();
                        return;     // 밑의 로직을 태우지 않고 되돌려 보냄
                    }
                }

                // 이 곳까지 도착했다면 에러상황이 없으므로 데이터 저장!
                String tSpin1 = SpinResult1.getText().toString();
                String tSpin2 = SpinResult2.getText().toString();
                String tSpin3 = SpinResult3.getText().toString();
                String tSpin4 = SpinResult4.getText().toString();
                String tSpin5 = SpinResult5.getText().toString();
                String tSpin6 = SpinResult6.getText().toString();
                String tSpin7 = SpinResult7.getText().toString();
                String tSpin8 = SpinResult8.getText().toString();
                String tSpin9 = SpinResult9.getText().toString();
                String tSpin10 = SpinResult10.getText().toString();
                String tSpin11 = SpinResult11.getText().toString();
                String tSpin12 = SpinResult12.getText().toString();
                String tSpin13 = SpinResult13.getText().toString();
                String tSpin14 = SpinResult14.getText().toString();
                String tSpin15 = SpinResult15.getText().toString();
                String tSpin16 = SpinResult16.getText().toString();
                String tSpin17 = SpinResult17.getText().toString();
                String tSpin18 = SpinResult18.getText().toString();

                String title = mEtTitle.getText().toString();       // 제목 입력 값
                String title2 = mEtTitle2.getText().toString();
                String content = mEtContent.getText().toString();   // 내용 입력 값

                String tTime1 = mETtime1.getText().toString();
                String tTime2 = mETtime2.getText().toString();
                String tTime3 = mETtime3.getText().toString();
                String tTime4 = mETtime4.getText().toString();
                String tTime5 = mETtime5.getText().toString();
                String tTime6 = mETtime6.getText().toString();
                String tTime7 = mETtime7.getText().toString();
                String tTime8 = mETtime8.getText().toString();
                String tTime9 = mETtime9.getText().toString();
                String tTime10 = mETtime10.getText().toString();
                String tTime11 = mETtime11.getText().toString();
                String tTime12 = mETtime12.getText().toString();
                String tTime13 = mETtime13.getText().toString();
                String tTime14 = mETtime14.getText().toString();
                String tTime15 = mETtime15.getText().toString();
                String tTime16 = mETtime16.getText().toString();
                String tTime17 = mETtime17.getText().toString();
                String tTime18 = mETtime18.getText().toString();

                String tContext1 = mETcontext1.getText().toString();
                String tContext2 = mETcontext2.getText().toString();
                String tContext3 = mETcontext3.getText().toString();
                String tContext4 = mETcontext4.getText().toString();
                String tContext5 = mETcontext5.getText().toString();
                String tContext6 = mETcontext6.getText().toString();
                String tContext7 = mETcontext7.getText().toString();
                String tContext8 = mETcontext8.getText().toString();
                String tContext9 = mETcontext9.getText().toString();
                String tContext10 = mETcontext10.getText().toString();
                String tContext11 = mETcontext11.getText().toString();
                String tContext12 = mETcontext12.getText().toString();
                String tContext13 = mETcontext13.getText().toString();
                String tContext14 = mETcontext14.getText().toString();
                String tContext15 = mETcontext15.getText().toString();
                String tContext16 = mETcontext16.getText().toString();
                String tContext17 = mETcontext17.getText().toString();
                String tContext18 = mETcontext18.getText().toString();

                String tMoney1 = mETMoney1.getText().toString();
                String tMoney2 = mETMoney2.getText().toString();
                String tMoney3 = mETMoney3.getText().toString();
                String tMoney4 = mETMoney4.getText().toString();
                String tMoney5 = mETMoney5.getText().toString();
                String tMoney6 = mETMoney6.getText().toString();
                String tMoney7 = mETMoney7.getText().toString();
                String tMoney8 = mETMoney8.getText().toString();
                String tMoney9 = mETMoney9.getText().toString();
                String tMoney10 = mETMoney10.getText().toString();
                String tMoney11 = mETMoney11.getText().toString();
                String tMoney12 = mETMoney12.getText().toString();
                String tMoney13 = mETMoney13.getText().toString();
                String tMoney14 = mETMoney14.getText().toString();
                String tMoney15 = mETMoney15.getText().toString();
                String tMoney16 = mETMoney16.getText().toString();
                String tMoney17 = mETMoney17.getText().toString();
                String tMoney18 = mETMoney18.getText().toString();

                String userDate = mSelectedUserDate_start;          // 사용자가 선택한 일시
                if (userDate.equals("")) {
                    //날짜를 설정 안 한 경우
                    userDate = mTvDate_start.getText().toString();
                }
                String userDate2 = mSelectedUserDate_end;           // 사용자가 선택한 일시
                if (userDate2.equals("")) {
                    //날짜를 설정 안 한 경우
                    userDate2 = mTvDate_end.getText().toString();
                }
                String writeDate = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss", Locale.KOREAN).format(new Date()); // 작성 완료 누른 시점의 일시


                // 액티비티의 현재 모드에 따라서 데이터베이스에 저장 또는 업데이트
                if(mDetailMode.equals("modify")) {
                    // 게시글 수정 모드
                    mDatabaseHelper.setUpdateDiaryList(title, title2, content, mSelectiveWeatherType, userDate, userDate2, writeDate,
                            tTime1, tContext1, tSpin1, tMoney1,
                            tTime2, tContext2, tSpin2, tMoney2,
                            tTime3, tContext3, tSpin3, tMoney3,
                            tTime4, tContext4, tSpin4, tMoney4,
                            tTime5, tContext5, tSpin5, tMoney5,
                            tTime6, tContext6, tSpin6, tMoney6,
                            tTime7, tContext7, tSpin7, tMoney7,
                            tTime8, tContext8, tSpin8, tMoney8,
                            tTime9, tContext9, tSpin9, tMoney9,
                            tTime10, tContext10, tSpin10, tMoney10,
                            tTime11, tContext11, tSpin11, tMoney11,
                            tTime12, tContext12, tSpin12, tMoney12,
                            tTime13, tContext13, tSpin13, tMoney13,
                            tTime14, tContext14, tSpin14, tMoney14,
                            tTime15, tContext15, tSpin15, tMoney15,
                            tTime16, tContext16, tSpin16, tMoney16,
                            tTime17, tContext17, tSpin17, tMoney17,
                            tTime18, tContext18, tSpin18, tMoney18,
                            mBeforeDate);
                    Toast.makeText(this, "다이어리 수정이 완료 되었습니다.", Toast.LENGTH_SHORT).show();
                } else {
                    mDatabaseHelper.setInsertDiaryList(title, title2, content, mSelectiveWeatherType, userDate, userDate2, writeDate,
                            tTime1, tContext1, tSpin1, tMoney1,
                            tTime2, tContext2, tSpin2, tMoney2,
                            tTime3, tContext3, tSpin3, tMoney3,
                            tTime4, tContext4, tSpin4, tMoney4,
                            tTime5, tContext5, tSpin5, tMoney5,
                            tTime6, tContext6, tSpin6, tMoney6,
                            tTime7, tContext7, tSpin7, tMoney7,
                            tTime8, tContext8, tSpin8, tMoney8,
                            tTime9, tContext9, tSpin9, tMoney9,
                            tTime10, tContext10, tSpin10, tMoney10,
                            tTime11, tContext11, tSpin11, tMoney11,
                            tTime12, tContext12, tSpin12, tMoney12,
                            tTime13, tContext13, tSpin13, tMoney13,
                            tTime14, tContext14, tSpin14, tMoney14,
                            tTime15, tContext15, tSpin15, tMoney15,
                            tTime16, tContext16, tSpin16, tMoney16,
                            tTime17, tContext17, tSpin17, tMoney17,
                            tTime18, tContext18, tSpin18, tMoney18);
                    Toast.makeText(this, "다이어리 등록이 완료 되었습니다.", Toast.LENGTH_SHORT).show();
                }

                finish();       // 현재 Activity 종료
                break;

            case R.id.tv_date:
                // 일시 설정 텍스트

                // 달력을 띄워서 사용자에게 일시를 입력 받는다.
                Calendar calendar = Calendar.getInstance();
                DatePickerDialog dialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                        // 달력에 선택 된 (년, 월, 일)을 가지고와서 다시 캘린더 함수에 넣어줘서 사용자가 선택한 요일을 알아낸다.
                        Calendar innerCal = Calendar.getInstance();
                        innerCal.set(Calendar.YEAR, year);
                        innerCal.set(Calendar.MONTH, month);
                        innerCal.set(Calendar.DAY_OF_MONTH, day);

                        mSelectedUserDate_start = new SimpleDateFormat("yyyy/MM/dd (EE)", Locale.KOREAN).format(innerCal.getTime());
                        mTvDate_start.setText(mSelectedUserDate_start);

                    }
                }, calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DATE));
                dialog.show();      // 다이얼로그 (팝업) 활성화!

                break;

            case R.id.tv_date2:

                Calendar calendar2 = Calendar.getInstance();
                DatePickerDialog dialog2 = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                        // 달력에 선택 된 (년, 월, 일)을 가지고와서 다시 캘린더 함수에 넣어줘서 사용자가 선택한 요일을 알아낸다.
                        Calendar innerCal2 = Calendar.getInstance();
                        innerCal2.set(Calendar.YEAR, year);
                        innerCal2.set(Calendar.MONTH, month);
                        innerCal2.set(Calendar.DAY_OF_MONTH, day);

                        mSelectedUserDate_end = new SimpleDateFormat("yyyy/MM/dd (EE)", Locale.KOREAN).format(innerCal2.getTime());
                        mTvDate_end.setText(mSelectedUserDate_end);

                    }
                }, calendar2.get(Calendar.YEAR), calendar2.get(Calendar.MONTH), calendar2.get(Calendar.DATE));
                dialog2.show();      // 다이얼로그 (팝업) 활성화!

                break;

            // 통계 액티비티로 넘어가는 버튼
            case R.id.btn_next:
                Intent pieIntent = new Intent(DiaryDetailActivity.this, PieChartActivity.class);
                startActivity(pieIntent);

                finish();
                break;
        }
    }
}