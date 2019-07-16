package comndroid.example.recyclerview.smarteducation.http.service;

import comndroid.example.recyclerview.smarteducation.Beans.Baoxiuitembean;
import retrofit2.http.POST;
import retrofit2.http.Query;
import rx.Observable;

public abstract interface infoRepair
{
    @POST("app/infoRepair.do")
    public abstract Observable<Baoxiuitembean> huoqu(@Query("userId") String paramString1, @Query("token") String paramString2, @Query("repairId") String paramString3);
}
