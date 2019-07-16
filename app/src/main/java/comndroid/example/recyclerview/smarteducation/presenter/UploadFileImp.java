package comndroid.example.recyclerview.smarteducation.presenter;

import comndroid.example.recyclerview.smarteducation.Beans.UplaodBean;
import comndroid.example.recyclerview.smarteducation.http.HttpUtils;
import comndroid.example.recyclerview.smarteducation.http.HttpUtils.OnResultListener;
import comndroid.example.recyclerview.smarteducation.http.Url;
import comndroid.example.recyclerview.smarteducation.http.helper.RetrofitHelper;
import comndroid.example.recyclerview.smarteducation.http.service.uploadFile;
import comndroid.example.recyclerview.smarteducation.ui.UploadView;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.MultipartBody.Part;
import okhttp3.RequestBody;

public class UploadFileImp
        implements UploadFilePresenter
{
    private UploadView uploadView;

    public UploadFileImp(UploadView paramUploadView)
    {
        this.uploadView = paramUploadView;
    }

    public void upload(List<File> paramList)
    {
        ArrayList localArrayList = new ArrayList();
        int i = 0;
        while (i < paramList.size())
        {
            RequestBody localRequestBody = RequestBody.create(MediaType.parse("multipart/form-data"), (File)paramList.get(i));
            localArrayList.add(MultipartBody.Part.createFormData("file", ((File)paramList.get(i)).getName(), localRequestBody));
            i += 1;
        }
        HttpUtils.requestNetByPost(((uploadFile)RetrofitHelper.getService(Url.image, uploadFile.class)).upload(localArrayList), new HttpUtils.OnResultListener<UplaodBean>()
        {
            public void onError(Throwable paramThrowable, String paramString)
            {
                UploadFileImp.this.uploadView.geterror(paramThrowable, paramString);
            }

            public void onSuccess(UplaodBean paramUplaodBean)
            {
                UploadFileImp.this.uploadView.getUploadBean(paramUplaodBean);
            }
        });
    }
}