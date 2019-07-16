package comndroid.example.recyclerview.smarteducation.http.service;

import comndroid.example.recyclerview.smarteducation.Beans.ShangjiBean;
import retrofit2.http.POST;
import retrofit2.http.Query;
import rx.Observable;

public abstract interface getShangji
{
    @POST("app/getSupList.do")
    public abstract Observable<ShangjiBean> huoqu(@Query("userId") String paramString1, @Query("token") String paramString2, @Query("distId") String paramString3);
}