package comndroid.example.recyclerview.smarteducation.http.service;

import comndroid.example.recyclerview.smarteducation.Beans.HandlereturnBean;
import retrofit2.http.POST;
import retrofit2.http.Query;
import rx.Observable;

public abstract interface ApproveHandleing
{
    @POST("app/dbSolveApprove.do")
    public abstract Observable<HandlereturnBean> huoqu(@Query("userId") String paramString1, @Query("id") String paramString2, @Query("token") String paramString3, @Query("state") String paramString4, @Query("refusefor") String paramString5);
}