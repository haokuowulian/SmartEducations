package comndroid.example.recyclerview.smarteducation.http.service;

import comndroid.example.recyclerview.smarteducation.Beans.FileListBean;
import retrofit2.http.POST;
import retrofit2.http.Query;
import rx.Observable;

public abstract interface getFilelist
{
    @POST("app/getListFileReceive.do")
    public abstract Observable<FileListBean> huoqu(@Query("userId") String paramString1, @Query("token") String paramString2, @Query("distId") String paramString3, @Query("pageSize") String paramString4, @Query("pageIndex") String paramString5);
}