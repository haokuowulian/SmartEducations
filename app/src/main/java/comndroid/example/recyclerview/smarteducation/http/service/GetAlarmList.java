package comndroid.example.recyclerview.smarteducation.http.service;

import comndroid.example.recyclerview.smarteducation.Beans.BaojingBean;
import retrofit2.http.POST;
import retrofit2.http.Query;
import rx.Observable;

public abstract interface GetAlarmList
{
    @POST("app/getAlarmList.do")
    public abstract Observable<BaojingBean> huoqu(@Query("userId") String paramString1, @Query("token") String paramString2, @Query("distId") String paramString3, @Query("sign") String paramString4, @Query("isConfirmed") String paramString5, @Query("pageIndex") String paramString6, @Query("pageSize") String paramString7);
}