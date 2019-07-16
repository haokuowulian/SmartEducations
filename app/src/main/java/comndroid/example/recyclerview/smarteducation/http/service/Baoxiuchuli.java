package comndroid.example.recyclerview.smarteducation.http.service;

import comndroid.example.recyclerview.smarteducation.Beans.ResetVerfiyCodebean;
import retrofit2.http.POST;
import retrofit2.http.Query;
import rx.Observable;

public abstract interface Baoxiuchuli
{
    @POST("app/replyRepair.do")
    public abstract Observable<ResetVerfiyCodebean> huoqu(@Query("userId") String paramString1, @Query("token") String paramString2, @Query("distId") String paramString3, @Query("replyContent") String paramString4, @Query("repairId") String paramString5);
}
