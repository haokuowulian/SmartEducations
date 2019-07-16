package comndroid.example.recyclerview.smarteducation.http.service;

import comndroid.example.recyclerview.smarteducation.Beans.ForgetPasswordbean;
import java.util.List;
import retrofit2.http.POST;
import retrofit2.http.Query;
import rx.Observable;

public abstract interface UploadFiles
{
    @POST("app/editFileTransfer.do")
    public abstract Observable<ForgetPasswordbean> upload(@Query("userId") String paramString1, @Query("token") String paramString2, @Query("distId") String paramString3, @Query("title") String paramString4, @Query("content") String paramString5, @Query("sendTo") String paramString6, @Query("sendToName") String paramString7, @Query("fileName") List<String> paramList1, @Query("filePath") List<String> paramList2);
}