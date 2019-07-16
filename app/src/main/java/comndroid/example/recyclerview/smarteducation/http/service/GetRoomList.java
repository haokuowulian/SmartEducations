package comndroid.example.recyclerview.smarteducation.http.service;

import comndroid.example.recyclerview.smarteducation.Beans.RoomBean;
import retrofit2.http.POST;
import retrofit2.http.Query;
import rx.Observable;

public abstract interface GetRoomList
{
    @POST("app/getRoomList.do")
    public abstract Observable<RoomBean> huoqu(@Query("userId") String paramString1, @Query("token") String paramString2, @Query("distId") String paramString3, @Query("buildingId") String paramString4);
}