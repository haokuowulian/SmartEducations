package comndroid.example.recyclerview.smarteducation.http.service;

import comndroid.example.recyclerview.smarteducation.Beans.FileitemBean;
import retrofit2.http.POST;
import retrofit2.http.Query;
import rx.Observable;

public abstract interface Fileitem
{
    @POST("app/getInfoFileTransfer.do")
    public abstract Observable<FileitemBean> huoqu(@Query("userId") String paramString1, @Query("token") String paramString2, @Query("id") String paramString3);
}