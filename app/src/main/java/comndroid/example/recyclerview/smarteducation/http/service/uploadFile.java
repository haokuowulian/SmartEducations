package comndroid.example.recyclerview.smarteducation.http.service;

import comndroid.example.recyclerview.smarteducation.Beans.UplaodBean;
import java.util.List;

import okhttp3.MultipartBody;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import rx.Observable;

public abstract interface uploadFile
{
    @Multipart
    @POST("fileUpload/uploadFile.do")
    public abstract Observable<UplaodBean> upload(@Part List<MultipartBody.Part> paramList);
}