package comndroid.example.recyclerview.smarteducation.http.service;

import comndroid.example.recyclerview.smarteducation.Beans.XiajiBean;
import retrofit2.http.POST;
import retrofit2.http.Query;
import rx.Observable;

public abstract interface getListSubUser
{
    @POST("app/getListSubUser.do")
    public abstract Observable<XiajiBean> get(@Query("userId") String paramString1, @Query("token") String paramString2, @Query("distId") String paramString3);
}