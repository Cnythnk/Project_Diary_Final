package com.example.mydiaryfinal;

import java.io.Serializable;

/**
 * 다이어리 리스트 아이템을 구성하는 모델 (표본)
 */

public class DiaryModel implements Serializable {

    int id;                 // 게시물 고유 Id 값
    String title;           // 게시물 제목
    String title2;          // 여행지 입력란
    String content;         // 게시물 내용
    int weatherType;        // 날씨 값 (0:맑음 1:흐림뒤갬 2:흐림 3:매우흐림 4:비 5:눈)
    String userDate;        // 사용자가 지정한 날짜(일시)
    String userDate2;
    String writeDate;       // 게시글 작성한 날짜(일시)
    String tTime1, tTime2, tTime3, tTime4, tTime5, tTime6, tTime7, tTime8, tTime9, tTime10,
           tTime11, tTime12, tTime13, tTime14, tTime15, tTime16, tTime17, tTime18;
    String tContext1, tContext2, tContext3, tContext4, tContext5, tContext6, tContext7, tContext8,
           tContext9, tContext10, tContext11, tContext12, tContext13, tContext14, tContext15,
           tContext16, tContext17, tContext18;
    String tSpin1, tSpin2, tSpin3, tSpin4, tSpin5, tSpin6, tSpin7, tSpin8, tSpin9, tSpin10,
           tSpin11, tSpin12, tSpin13, tSpin14, tSpin15, tSpin16, tSpin17, tSpin18;          // 선택한 경비 항목
    String tMoney1, tMoney2, tMoney3, tMoney4, tMoney5, tMoney6, tMoney7, tMoney8,          // 경비 금액
           tMoney9, tMoney10, tMoney11, tMoney12, tMoney13, tMoney14, tMoney15, tMoney16, tMoney17, tMoney18;
//    배열로 간단하게 표현하기
//    String tMoney[] = new String[18];
    String waveIcon;

    // getter & setter 게터세터
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public String getTitle2() { return  title2; }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setTitle2(String title2) {this.title2 = title2;}

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getWeatherType() {
        return weatherType;
    }

    public void setWeatherType(int weatherType) {
        this.weatherType = weatherType;
    }

    public String getUserDate() {
        return userDate;
    }

    public String getUserDate2() { return userDate2; }

    public String getTTime1() { return tTime1; }
    public String getTTime2() {
        return tTime2;
    }
    public String getTTime3() { return tTime3; }
    public String getTTime4() { return tTime4; }
    public String getTTime5() { return tTime5; }
    public String getTTime6() { return tTime6; }
    public String getTTime7() { return tTime7; }
    public String getTTime8() { return tTime8; }
    public String getTTime9() { return tTime9; }
    public String getTTime10() { return tTime10; }
    public String getTTime11() { return tTime11; }
    public String getTTime12() { return tTime12; }
    public String getTTime13() { return tTime13; }
    public String getTTime14() { return tTime14; }
    public String getTTime15() { return tTime15; }
    public String getTTime16() { return tTime16; }
    public String getTTime17() { return tTime17; }
    public String getTTime18() { return tTime18; }

    public void setTTime1(String tTime1) { this.tTime1 = tTime1; }
    public void setTTime2(String tTime2) { this.tTime2 = tTime2; }
    public void setTTime3(String tTime3) { this.tTime3 = tTime3; }
    public void setTTime4(String tTime4) { this.tTime4 = tTime4; }
    public void setTTime5(String tTime5) { this.tTime5 = tTime5; }
    public void setTTime6(String tTime6) { this.tTime6 = tTime6; }
    public void setTTime7(String tTime7) { this.tTime7 = tTime7; }
    public void setTTime8(String tTime8) { this.tTime8 = tTime8; }
    public void setTTime9(String tTime9) { this.tTime9 = tTime9; }
    public void setTTime10(String tTime10) { this.tTime10 = tTime10; }
    public void setTTime11(String tTime11) { this.tTime11 = tTime11; }
    public void setTTime12(String tTime12) { this.tTime12 = tTime12; }
    public void setTTime13(String tTime13) { this.tTime13 = tTime13; }
    public void setTTime14(String tTime14) { this.tTime14 = tTime14; }
    public void setTTime15(String tTime15) { this.tTime15 = tTime15; }
    public void setTTime16(String tTime16) { this.tTime16 = tTime16; }
    public void setTTime17(String tTime17) { this.tTime17 = tTime17; }
    public void setTTime18(String tTime18) { this.tTime18 = tTime18; }

    public String getTContext1() { return tContext1; }
    public String getTContext2() { return tContext2; }
    public String getTContext3() { return tContext3; }
    public String getTContext4() { return tContext4; }
    public String getTContext5() { return tContext5; }
    public String getTContext6() { return tContext6; }
    public String getTContext7() { return tContext7; }
    public String getTContext8() { return tContext8; }
    public String getTContext9() { return tContext9; }
    public String getTContext10() { return tContext10; }
    public String getTContext11() { return tContext11; }
    public String getTContext12() { return tContext12; }
    public String getTContext13() { return tContext13; }
    public String getTContext14() { return tContext14; }
    public String getTContext15() { return tContext15; }
    public String getTContext16() { return tContext16; }
    public String getTContext17() { return tContext17; }
    public String getTContext18() { return tContext18; }

    public void setTContext1(String tContext1) { this.tContext1 = tContext1; }
    public void setTContext2(String tContext2) { this.tContext2 = tContext2; }
    public void setTContext3(String tContext3) { this.tContext3 = tContext3; }
    public void setTContext4(String tContext4) { this.tContext4 = tContext4; }
    public void setTContext5(String tContext5) { this.tContext5 = tContext5; }
    public void setTContext6(String tContext6) { this.tContext6 = tContext6; }
    public void setTContext7(String tContext7) { this.tContext7 = tContext7; }
    public void setTContext8(String tContext8) { this.tContext8 = tContext8; }
    public void setTContext9(String tContext9) { this.tContext9 = tContext9; }
    public void setTContext10(String tContext10) { this.tContext10 = tContext10; }
    public void setTContext11(String tContext11) { this.tContext11 = tContext11; }
    public void setTContext12(String tContext12) { this.tContext12 = tContext12; }
    public void setTContext13(String tContext13) { this.tContext13 = tContext13; }
    public void setTContext14(String tContext14) { this.tContext14 = tContext14; }
    public void setTContext15(String tContext15) { this.tContext15 = tContext15; }
    public void setTContext16(String tContext16) { this.tContext16 = tContext16; }
    public void setTContext17(String tContext17) { this.tContext17 = tContext17; }
    public void setTContext18(String tContext18) { this.tContext18 = tContext18; }

    public String getTSpin1() { return tSpin1; }
    public String getTSpin2() { return tSpin2; }
    public String getTSpin3() { return tSpin3; }
    public String getTSpin4() { return tSpin4; }
    public String getTSpin5() { return tSpin5; }
    public String getTSpin6() { return tSpin6; }
    public String getTSpin7() { return tSpin7; }
    public String getTSpin8() { return tSpin8; }
    public String getTSpin9() { return tSpin9; }
    public String getTSpin10() { return tSpin10; }
    public String getTSpin11() { return tSpin11; }
    public String getTSpin12() { return tSpin12; }
    public String getTSpin13() { return tSpin13; }
    public String getTSpin14() { return tSpin14; }
    public String getTSpin15() { return tSpin15; }
    public String getTSpin16() { return tSpin16; }
    public String getTSpin17() { return tSpin17; }
    public String getTSpin18() { return tSpin18; }

    public void setTSpin1(String tSpin1) { this.tSpin1 = tSpin1; }
    public void setTSpin2(String tSpin2) { this.tSpin2 = tSpin2; }
    public void setTSpin3(String tSpin3) { this.tSpin3 = tSpin3; }
    public void setTSpin4(String tSpin4) { this.tSpin4 = tSpin4; }
    public void setTSpin5(String tSpin5) { this.tSpin5 = tSpin5; }
    public void setTSpin6(String tSpin6) { this.tSpin6 = tSpin6; }
    public void setTSpin7(String tSpin7) { this.tSpin7 = tSpin7; }
    public void setTSpin8(String tSpin8) { this.tSpin8 = tSpin8; }
    public void setTSpin9(String tSpin9) { this.tSpin9 = tSpin9; }
    public void setTSpin10(String tSpin10) { this.tSpin10 = tSpin10; }
    public void setTSpin11(String tSpin11) { this.tSpin11 = tSpin11; }
    public void setTSpin12(String tSpin12) { this.tSpin12 = tSpin12; }
    public void setTSpin13(String tSpin13) { this.tSpin13 = tSpin13; }
    public void setTSpin14(String tSpin14) { this.tSpin14 = tSpin14; }
    public void setTSpin15(String tSpin15) { this.tSpin15 = tSpin15; }
    public void setTSpin16(String tSpin16) { this.tSpin16 = tSpin16; }
    public void setTSpin17(String tSpin17) { this.tSpin17 = tSpin17; }
    public void setTSpin18(String tSpin18) { this.tSpin18 = tSpin18; }

    public String getTMoney1() {
        return tMoney1;
    }
    public String getTMoney2() {
        return tMoney2;
    }
    public String getTMoney3() {
        return tMoney3;
    }
    public String getTMoney4() {
        return tMoney4;
    }
    public String getTMoney5() {
        return tMoney5;
    }
    public String getTMoney6() {
        return tMoney6;
    }
    public String getTMoney7() {
        return tMoney7;
    }
    public String getTMoney8() {
        return tMoney8;
    }
    public String getTMoney9() {
        return tMoney9;
    }
    public String getTMoney10() {
        return tMoney10;
    }
    public String getTMoney11() {
        return tMoney11;
    }
    public String getTMoney12() {
        return tMoney12;
    }
    public String getTMoney13() {
        return tMoney13;
    }
    public String getTMoney14() {
        return tMoney14;
    }
    public String getTMoney15() {
        return tMoney15;
    }
    public String getTMoney16() {
        return tMoney16;
    }
    public String getTMoney17() {
        return tMoney17;
    }
    public String getTMoney18() {
        return tMoney18;
    }

//    배열로 간단하게 표현하기
//    public String getTMoney(int i) {
//        return tMoney[i];
//    };
//
//    public void setTMoney(String[] tMoney) {
//        for (int i=0; i<tMoney.length; i++) {
//            this.tMoney[i] = tMoney[i];
//        }
//    }

    public void setTMoney1(String tMoney1) {
        this.tMoney1 = tMoney1;
    }
    public void setTMoney2(String tMoney2) {
        this.tMoney2 = tMoney2;
    }
    public void setTMoney3(String tMoney3) {
        this.tMoney3 = tMoney3;
    }
    public void setTMoney4(String tMoney4) {
        this.tMoney4 = tMoney4;
    }
    public void setTMoney5(String tMoney5) {
        this.tMoney5 = tMoney5;
    }
    public void setTMoney6(String tMoney6) {
        this.tMoney6 = tMoney6;
    }
    public void setTMoney7(String tMoney7) {
        this.tMoney7 = tMoney7;
    }
    public void setTMoney8(String tMoney8) {
        this.tMoney8 = tMoney8;
    }
    public void setTMoney9(String tMoney9) {
        this.tMoney9 = tMoney9;
    }
    public void setTMoney10(String tMoney10) {
        this.tMoney10 = tMoney10;
    }
    public void setTMoney11(String tMoney11) {
        this.tMoney11 = tMoney11;
    }
    public void setTMoney12(String tMoney12) {
        this.tMoney12 = tMoney12;
    }
    public void setTMoney13(String tMoney13) {
        this.tMoney13 = tMoney13;
    }
    public void setTMoney14(String tMoney14) {
        this.tMoney14 = tMoney14;
    }
    public void setTMoney15(String tMoney15) {
        this.tMoney15 = tMoney15;
    }
    public void setTMoney16(String tMoney16) {
        this.tMoney16 = tMoney16;
    }
    public void setTMoney17(String tMoney17) {
        this.tMoney17 = tMoney17;
    }
    public void setTMoney18(String tMoney18) {
        this.tMoney18 = tMoney18;
    }

    public void setUserDate(String userDate) {
        this.userDate = userDate;
    }
    public void setUserDate2(String userDate2) {
        this.userDate2 = userDate2;
    }

    public String getWriteDate() {
        return writeDate;
    }

    public void setWriteDate(String writeDate) {
        this.writeDate = writeDate;
    }

    public String getWaveIcon() {
        return waveIcon;
    }

    public void setWaveIcon(String waveIcon) {
        this.waveIcon = waveIcon;
    }

}
