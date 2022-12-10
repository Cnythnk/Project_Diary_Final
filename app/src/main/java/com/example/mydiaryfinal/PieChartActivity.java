package com.example.mydiaryfinal;

import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;

import java.util.ArrayList;
import java.util.List;

public class PieChartActivity extends AppCompatActivity {

    PieChart pieChart;

    TextView type0, type1, type2, type3, total;

    int TotalMoney;                                // 경비 총합
    int TotType0, TotType1, TotType2, TotType3;    // 경비 타입별 합계

    DataBaseHelper mDataBaseHelper;

    int[] MoneyList = new int[18];                 // 경비 금액 (배열)
    String[] TypeList = new String[18];            // 경비 타입 (배열)

    @Override
    protected void onCreate(Bundle saveInstanceState) {
        super.onCreate(saveInstanceState);
        setContentView(R.layout.activity_piechart);

        // 데이터베이스에서 경비 항목을 조회하여 배열 형태로 가져오기 (금액, 타입)
        mDataBaseHelper = new DataBaseHelper(this);    // 데이터베이스 객체의 초기화
        mDataBaseHelper.getMoneyList();
        for (int i=0; i<MoneyList.length; i++) {
           MoneyList[i] = Integer.parseInt(mDataBaseHelper.getMoneyList()[i]);
        }
        mDataBaseHelper.getTypeList();
        for (int i=0; i<TypeList.length; i++) {
            TypeList[i] = mDataBaseHelper.getTypeList()[i];
        }

        // 뒤로가기 버튼
        ImageView iv_back = findViewById(R.id.iv_back);
        iv_back.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                finish();
            }

        });

        // 파이차트 생성
        pieChart = (PieChart) findViewById(R.id.piechart);

        type0 = (TextView) findViewById(R.id.et_type0);
        type1 = (TextView) findViewById(R.id.et_type1);
        type2 = (TextView) findViewById(R.id.et_type2);
        type3 = (TextView) findViewById(R.id.et_type3);
        total = (TextView) findViewById(R.id.et_total);

        pieChart.setUsePercentValues(true);
        pieChart.getDescription().setEnabled(false);
        pieChart.setExtraOffsets(5,10,5,5);

        pieChart.setDragDecelerationFrictionCoef(0.95f);

        pieChart.setDrawHoleEnabled(false);
        pieChart.setHoleColor(Color.BLACK);
        pieChart.setTransparentCircleRadius(61f);

        pieChart.setCenterTextSize(18);

        // 저장된 경비 항목 배열 가져오기
        Resources res = getResources();
        String[] money = res.getStringArray(R.array.typeArray);    // money = {"기타", "교통비", "숙박비", "식비"}

        // 경비 타입별 합계 구하기
        for (int i=0; i<TypeList.length; i++) {
            switch (TypeList[i]) {
                case "기타" :
                    TotType0 += MoneyList[i];
                    break;
                case "교통비" :
                    TotType1 += MoneyList[i];
                    break;
                case "숙박비" :
                    TotType2 += MoneyList[i];
                    break;
                case "식비" :
                    TotType3 += MoneyList[i];
                    break;
            }
        }

        // 경비 총합 구하기
        TotalMoney = TotType0 + TotType1 + TotType2 + TotType3;

        // 경비 타입별 퍼센트 구해서 배열에 넣기
        double per[] = {0, 0, 0, 0};

        per[0] = (float) TotType0 / TotalMoney * 100;
        per[1] = (float) TotType1 / TotalMoney * 100;
        per[2] = (float) TotType2 / TotalMoney * 100;
        per[3] = (float) TotType3 / TotalMoney * 100;

        // 경비 타입별 총합 출력
        type0.setText(String.valueOf(TotType0));
        type1.setText(String.valueOf(TotType1));
        type2.setText(String.valueOf(TotType2));
        type3.setText(String.valueOf(TotType3));
        total.setText(String.valueOf(TotalMoney));

        // 파이차트에 들어갈 퍼센트값 설정
        List<PieEntry> Values = new ArrayList();
        for (int i=0; i<per.length; i++) {
            Values.add(new PieEntry((float) per[i], (String) money[i]));
        }

        Description description = new Description();
        description.setText("여행 비용 통계");
        description.setTextSize(15);
        pieChart.setDescription(description);

        PieDataSet dataSet = new PieDataSet(Values, "money");
        dataSet.setSliceSpace(3f);
        dataSet.setSelectionShift(5f);

        final int[] MY_COLORS = { Color.rgb(32,127,177),
                                  Color.rgb(249,209,105),
                                  Color.rgb(0,190,159),
                                  Color.rgb(223,223,223) };

        ArrayList<Integer> colors = new ArrayList<Integer>();
        for (int c: MY_COLORS) colors.add(c);
        dataSet.setColors(colors);

        PieData data = new PieData(dataSet);
        data.setValueTextSize(15);
        data.setValueTextColor(Color.BLACK);

        pieChart.setData(data);
    }

}