package comndroid.example.recyclerview.smarteducation.Utils;

import android.app.Activity;
import android.support.v4.content.ContextCompat;
import android.text.format.Time;


import java.util.ArrayList;

import cn.qqtheme.framework.entity.City;
import cn.qqtheme.framework.entity.County;
import cn.qqtheme.framework.entity.Province;
import cn.qqtheme.framework.picker.AddressPicker;
import cn.qqtheme.framework.picker.DatePicker;
import cn.qqtheme.framework.picker.DateTimePicker;
import cn.qqtheme.framework.picker.OptionPicker;
import comndroid.example.recyclerview.smarteducation.R;

public class DateUtil {

    /**
     * 年-月
     */
    public static void setMonthDate(final Activity mContext, final DateListener dateListener){
        DatePicker picker = new DatePicker(mContext, DateTimePicker.YEAR_MONTH);
        //获取当前时间
        Time time = new Time();
        time.setToNow();
        int year = time.year;
        int month = time.month;
        //设置时间区间
        picker.setRange(2000,2020);
        //设置默认显示时间
        picker.setSelectedItem(year,month+1);
        //加入动画
        picker.setAnimationStyle(R.style.Animation_CustomPopup);
        //回传数据
        picker.setOnDatePickListener(new DatePicker.OnYearMonthPickListener() {
            @Override
            public void onDatePicked(String year, String month) {
                dateListener.setMouthDate(year,month);
            }
        });
        picker.show();
    }

    /**
     * 年-月-日
     */
    public static void setYearDate(final Activity mContext, final DateListener dateListener){
        DatePicker picker = new DatePicker(mContext);
        //获取当前时间
        Time time = new Time();
        time.setToNow();
        int year = time.year;
        int month = time.month;
        int monthDay = time.monthDay;
        //设置时间区间
        picker.setRange(2000,2020);
        //设置默认显示时间
        picker.setSelectedItem(year,month+1,monthDay);
        //加入动画
        picker.setAnimationStyle(R.style.Animation_CustomPopup);
        //回传数据
        picker.setOnDatePickListener(new DatePicker.OnYearMonthDayPickListener() {
            @Override
            public void onDatePicked(String year, String month, String day) {
                dateListener.setYearDate(year,month,day);
            }
        });
        picker.show();
    }

    /**
     * 年-月       最后可选日期为当日
     */
    public static void setMonthDate(final Activity mContext, String startYear, String startMonth, boolean dynamicStartTime, final DateListener dateListener) {
        DatePicker picker = new DatePicker(mContext, DatePicker.YEAR_MONTH);
        //获取当前时间
        Time time = new Time();
        time.setToNow();
        int currentYear = time.year;
        int currentMonth = time.month;
        LogUtils.e("currentMonth =" + currentMonth);

        //设置时间区间
        if (dynamicStartTime) {
            //动态的开始时间
            picker.setRangeStart(2000, 1);
            picker.setRangeEnd(2050, 1);
        } else {
            //动态的结束时间
            picker.setRangeStart(2000, 1);
            picker.setRangeEnd(currentYear, currentMonth + 1);
        }
        //设置时间区间
        //        picker.setRange(2000, year);
        //循环
        //        picker.setCycleDisable(false);
        //设置默认显示时间
        picker.setSelectedItem(currentYear, currentMonth + 1);
        //加入动画
        picker.setAnimationStyle(R.style.Animation_CustomPopup);
        //设置取消按钮文字颜色
        picker.setCancelTextColor(ContextCompat.getColor(mContext, R.color.result_points));
        //设置取消按钮文字大小
        picker.setCancelTextSize(14);
        //设置顶部标题栏下划线颜色
        picker.setTopLineColor(ContextCompat.getColor(mContext, R.color.white));
        //设置分割线颜色
        picker.setDividerColor(ContextCompat.getColor(mContext, R.color.white));
        //设置确定按钮文字颜色
        picker.setSubmitTextColor(ContextCompat.getColor(mContext, R.color.blue));
        picker.setTextColor(ContextCompat.getColor(mContext, R.color.blue));
        picker.setSubmitTextSize(14);
        //设置标题文字颜色
        picker.setTitleTextColor(ContextCompat.getColor(mContext, R.color.result_points));
        //设置标题文字
        picker.setTitleText("选择月份");
        //设置标题文字大小
        picker.setTitleTextSize(14);
        //回传数据
        picker.setOnDatePickListener(new DatePicker.OnYearMonthPickListener() {
            @Override
            public void onDatePicked(String year, String month) {
                dateListener.setMouthDate(year, month);
            }
        });
        picker.show();
    }

}








