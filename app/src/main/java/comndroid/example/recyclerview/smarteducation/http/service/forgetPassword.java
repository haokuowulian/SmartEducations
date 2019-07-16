package comndroid.example.recyclerview.smarteducation.http.service;

import comndroid.example.recyclerview.smarteducation.Beans.ForgetPasswordbean;
import retrofit2.http.POST;
import retrofit2.http.Query;
import rx.Observable;

public abstract interface forgetPassword
{
    @POST("forgetPassword.do")
    public abstract Observable<ForgetPasswordbean> reset(@Query("password") String paramString1, @Query("authCode") String paramString2, @Query("telphone") String paramString3);
}