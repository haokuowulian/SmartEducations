package comndroid.example.recyclerview.smarteducation.http.service;

import comndroid.example.recyclerview.smarteducation.Beans.AlarmHandleBean;
import retrofit2.http.POST;
import retrofit2.http.Query;
import rx.Observable;

public abstract interface AlarmHandle
{
    @POST("app/replyAlarm.do")
    public abstract Observable<AlarmHandleBean> huoqu(@Query("userId") String paramString1, @Query("token") String paramString2, @Query("distId") String paramString3, @Query("manager") String paramString4, @Query("report") String paramString5, @Query("image") String paramString6, @Query("id") String paramString7, @Query("confirmResult") String paramString8);
}