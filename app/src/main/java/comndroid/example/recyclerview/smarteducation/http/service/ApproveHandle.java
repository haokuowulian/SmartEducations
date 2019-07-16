package comndroid.example.recyclerview.smarteducation.http.service;

import comndroid.example.recyclerview.smarteducation.Beans.ApproveListBean;
import retrofit2.http.POST;
import retrofit2.http.Query;
import rx.Observable;

public abstract interface ApproveHandle
{
    @POST("app/getDBListApprove.do")
    public abstract Observable<ApproveListBean> huoqu(@Query("userId") String paramString1, @Query("token") String paramString2, @Query("distId") String paramString3, @Query("pageIndex") String paramString4, @Query("pageSize") String paramString5);
}