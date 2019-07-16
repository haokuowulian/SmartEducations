package comndroid.example.recyclerview.smarteducation.http.service;

import comndroid.example.recyclerview.smarteducation.Beans.ForgetPasswordbean;
import retrofit2.http.POST;
import retrofit2.http.Query;
import rx.Observable;

public abstract interface updatePassword
{
    @POST("app/updatePassword.do")
    public abstract Observable<ForgetPasswordbean> update(@Query("userId") String paramString1, @Query("token") String paramString2, @Query("oldPassword") String paramString3, @Query("newPassword") String paramString4);
}