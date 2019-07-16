package comndroid.example.recyclerview.smarteducation.http.service;

import comndroid.example.recyclerview.smarteducation.Beans.ResetVerfiyCodebean;
import retrofit2.http.POST;
import retrofit2.http.Query;
import rx.Observable;

public abstract interface ResetVerfiyCode
{
    @POST("getResetVerfiyCode.do")
    public abstract Observable<ResetVerfiyCodebean> reset(@Query("telphone") String paramString);
}
