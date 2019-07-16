package comndroid.example.recyclerview.smarteducation.http.service;

import comndroid.example.recyclerview.smarteducation.Beans.Loginreturns;
import retrofit2.http.POST;
import retrofit2.http.Query;
import rx.Observable;

public abstract interface login
{
    @POST("login.do")
    public abstract Observable<Loginreturns> login(@Query("telphone") String paramString1, @Query("password") String paramString2);
}
