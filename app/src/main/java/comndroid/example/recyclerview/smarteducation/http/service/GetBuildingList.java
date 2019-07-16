package comndroid.example.recyclerview.smarteducation.http.service;

import comndroid.example.recyclerview.smarteducation.Beans.BuildingBean;
import retrofit2.http.POST;
import retrofit2.http.Query;
import rx.Observable;

public abstract interface GetBuildingList
{
    @POST("app/getBuildingList.do")
    public abstract Observable<BuildingBean> huoqu(@Query("userId") String paramString1, @Query("token") String paramString2, @Query("distId") String paramString3);
}
