package com.example.mydiaryfinal;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.net.ipsec.ike.TunnelModeChildSessionParams;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class PieChartActivity extends AppCompatActivity {

    int TotalMoney;                                                 // 경비 총합

    int TotType0, TotType1, TotType2, TotType3;                     // 경비 타입별 합계

    int CntType0 = 0;   // 경비 "기타" 타입 개수 누적 변수
    int CntType1 = 0;   // 경비 "교통비" 타입 개수 누적 변수
    int CntType2 = 0;   // 경비 "숙박비" 타입 개수 누적 변수
    int CntType3 = 0;   // 경비 "식비 " 타입 개수 누적 변수

    DiaryModel diaryModel = new DiaryModel();

    String TSpin1Type = diaryModel.getTSpin1();                     // TSpin1Type : 경비1의 타입
    int TSpin1Money = Integer.parseInt(diaryModel.getTMoney1());    // TSpin1Money : 경비1의 금액

    double per[] = {};
//    double per[] = {49.9, 31.1, 9.9, 9.1};    // 경비 타입별 퍼센트

    // 저장된 경비 항목 배열 가져오기
    Resources res = getResources();
    String[] money = res.getStringArray(R.array.typeArray);
//    String money[] = {"기타", "교통비", "숙박비", "식비"};

    @Override
    protected void onCreate(Bundle saveInstanceState) {
        super.onCreate(saveInstanceState);
        setContentView(R.layout.activity_piechart);

        // 뒤로가기 버튼
        ImageView iv_back = findViewById(R.id.iv_back);
        iv_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        // 경비 타입별 개수와 합계 구하기
        switch (TSpin1Type) {
            case "기타" :
                CntType0 ++;
                TotType0 += TSpin1Money;
                break;

            case "교통비" :
                CntType1 ++;
                TotType1 += TSpin1Money;
                break;

            case "숙박비" :
                CntType2 ++;
                TotType2 += TSpin1Money;
                break;

            case "식비" :
                CntType3 ++;
                TotType3 += TSpin1Money;
        }

        // TODO:
        //  TSpin1Type, TSpin2Type ... 전부 분류 작업하기
        //  타입별 개수는 혹시 필요할까봐 추가해놓음

        // 경비 타입별 퍼센트 구하기
        per[0] = (float) TotalMoney / TotType0;
        per[1] = (float) TotalMoney / TotType1;
        per[2] = (float) TotalMoney / TotType2;
        per[3] = (float) TotalMoney / TotType3;

        // 파이차트 생성
        PieChart pieChart = findViewById(R.id.piechart);

        pieChart.setUsePercentValues(true);
        pieChart.getDescription().setEnabled(false);
        pieChart.setExtraOffsets(5,10,5,5);
        pieChart.setDragDecelerationFrictionCoef(0.95f);
        pieChart.setDrawHoleEnabled(false);
        pieChart.setCenterTextSize(18);
        pieChart.setHoleColor(Color.BLACK);
        pieChart.setTransparentCircleRadius(61f);

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