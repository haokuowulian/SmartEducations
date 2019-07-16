package comndroid.example.recyclerview.smarteducation.http.service;

import comndroid.example.recyclerview.smarteducation.Beans.AirReturnBean;
import retrofit2.http.POST;
import retrofit2.http.Query;
import rx.Observable;

public interface GetAir {
    @POST("app/getAirData.do")
    public abstract Observable<AirReturnBean> get(@Query("userId")String userId,@Query("token")String token,@Query("distId") String distId);


}
