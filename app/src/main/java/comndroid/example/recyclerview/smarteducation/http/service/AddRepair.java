package comndroid.example.recyclerview.smarteducation.http.service;

import comndroid.example.recyclerview.smarteducation.Beans.AddRepairBean;
import comndroid.example.recyclerview.smarteducation.Beans.RepairBean;
import okhttp3.RequestBody;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;
import rx.Observable;

public abstract interface AddRepair {
    @POST("app/insertRepair.do")


    public abstract Observable<AddRepairBean> huoqu(@Query("userId") String userId, @Query("token") String token, @Query("distId") String distId, @Body RepairBean data);

}
