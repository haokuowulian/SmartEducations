package comndroid.example.recyclerview.smarteducation.http.service;

import comndroid.example.recyclerview.smarteducation.Beans.Baoxiubeans;
import retrofit2.http.POST;
import retrofit2.http.Query;
import rx.Observable;

public abstract interface getMyRepairList
{
    @POST("app/getMyRepairList.do")
    public abstract Observable<Baoxiubeans> huoqu(@Query("userId") String paramString1, @Query("token") String paramString2, @Query("distId") String paramString3, @Query("state") String paramString4, @Query("pageIndex") String paramString5, @Query("pageSize") String paramString6, @Query("repairType") String paramString7, @Query("sign") String paramString8);
}