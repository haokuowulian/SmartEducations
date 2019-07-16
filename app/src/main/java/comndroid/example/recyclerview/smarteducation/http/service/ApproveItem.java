package comndroid.example.recyclerview.smarteducation.http.service;

import comndroid.example.recyclerview.smarteducation.Beans.ApproveItemBean;
import retrofit2.http.POST;
import retrofit2.http.Query;
import rx.Observable;

public abstract interface ApproveItem
{
    @POST("app/infoApprove.do")
    public abstract Observable<ApproveItemBean> huoqu(@Query("id") String paramString1, @Query("userId") String paramString2, @Query("token") String paramString3);
}
