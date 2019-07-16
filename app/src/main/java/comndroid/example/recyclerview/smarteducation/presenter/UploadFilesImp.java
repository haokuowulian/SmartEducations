package comndroid.example.recyclerview.smarteducation.presenter;

import comndroid.example.recyclerview.smarteducation.Beans.ForgetPasswordbean;
import comndroid.example.recyclerview.smarteducation.http.HttpUtils;
import comndroid.example.recyclerview.smarteducation.http.HttpUtils.OnResultListener;
import comndroid.example.recyclerview.smarteducation.http.Url;
import comndroid.example.recyclerview.smarteducation.http.helper.RetrofitHelper;
import comndroid.example.recyclerview.smarteducation.http.service.UploadFiles;
import comndroid.example.recyclerview.smarteducation.ui.ForgetpasswordView;
import java.util.List;

public class UploadFilesImp
        implements UploadFilesPresenter
{
    private ForgetpasswordView forgetpasswordView;

    public UploadFilesImp(ForgetpasswordView paramForgetpasswordView)
    {
        this.forgetpasswordView = paramForgetpasswordView;
    }

    public void upload(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, List<String> paramList1, List<String> paramList2)
    {
        HttpUtils.requestNetByPost(((UploadFiles)RetrofitHelper.getService(Url.HOST, UploadFiles.class)).upload(paramString1, paramString2, paramString3, paramString4, paramString5, paramString6, paramString7, paramList1, paramList2), new HttpUtils.OnResultListener<ForgetPasswordbean>()
        {
            public void onError(Throwable paramThrowable, String paramString)
            {
                UploadFilesImp.this.forgetpasswordView.geterror(paramThrowable, paramString);
            }

            public void onSuccess(ForgetPasswordbean paramForgetPasswordbean)
            {
                UploadFilesImp.this.forgetpasswordView.getForgetpassworbean(paramForgetPasswordbean);
            }
        });
    }
}