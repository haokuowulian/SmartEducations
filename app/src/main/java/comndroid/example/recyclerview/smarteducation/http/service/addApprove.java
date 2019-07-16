package comndroid.example.recyclerview.smarteducation.http.service;

import comndroid.example.recyclerview.smarteducation.Beans.Addqingjiabean;
import comndroid.example.recyclerview.smarteducation.Beans.Datas;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import retrofit2.http.Query;
import rx.Observable;

public abstract interface addApprove
{

    @POST("app/addApprove.do")
    public abstract Observable<Addqingjiabean> add(@Query("userId") String userId, @Query("token") String token, @Query("distId")String distId,@Query("teaOrStu")String teaOrStu,@Body Datas data);
}