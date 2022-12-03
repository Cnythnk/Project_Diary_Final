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

    PieChart pieChart;

    int TotalMoney;                                                 // 경비 총합
    int TotType0, TotType1, TotType2, TotType3;                     // 경비 타입별 합계

    DiaryModel diaryModel;

    String TSpin1Type;
    int TSpin1Money;

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

        // 파이차트 생성
        pieChart = (PieChart) findViewById(R.id.piechart);

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

        // 경비 타입과 금액 넘겨받기
        diaryModel = new DiaryModel();
        TSpin1Type = diaryModel.getTSpin1();
        // TODO: 셧다운 발생! (경비 금액을 Int형으로 변환하여 가져오기)
//        TSpin1Money = Integer.valueOf(diaryModel.getTMoney1());
//        TSpin1Money = Integer.parseInt(diaryModel.getTMoney1());

        // 작동 확인용 샘플
        TotType0 = 16000;
        TotType1 = 0;
        TotType2 = 16000;
        TotType3 = 16000;

        // 경비 타입별 합계 구하기
        // TODO: 코드가 내려오다가 걸리도록 만들기
//        switch (TSpin1Type) {
//            case "기타" :
//                TotType0 += TSpin1Money;
//                break;
//
//            case "교통비" :
//                TotType1 += TSpin1Money;
//                break;
//
//            case "숙박비" :
//                TotType2 += TSpin1Money;
//                break;
//
//            case "식비" :
//                TotType3 += TSpin1Money;
//        }

        TotalMoney = TotType0 + TotType1 + TotType2 + TotType3;

        // 경비 타입별 퍼센트 구해서 배열에 넣기
        double per[] = {0, 0, 0, 0};

        per[0] = (float) TotType0 / TotalMoney * 100;
        per[1] = (float) TotType1 / TotalMoney * 100;
        per[2] = (float) TotType2 / TotalMoney * 100;
        per[3] = (float) TotType3 / TotalMoney * 100;

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