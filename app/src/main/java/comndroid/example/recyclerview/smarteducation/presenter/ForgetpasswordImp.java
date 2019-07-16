package comndroid.example.recyclerview.smarteducation.presenter;

import comndroid.example.recyclerview.smarteducation.Beans.ForgetPasswordbean;
import comndroid.example.recyclerview.smarteducation.http.HttpUtils;
import comndroid.example.recyclerview.smarteducation.http.HttpUtils.OnResultListener;
import comndroid.example.recyclerview.smarteducation.http.Url;
import comndroid.example.recyclerview.smarteducation.http.helper.RetrofitHelper;
import comndroid.example.recyclerview.smarteducation.http.service.forgetPassword;
import comndroid.example.recyclerview.smarteducation.ui.ForgetpasswordView;

public class ForgetpasswordImp
        implements ForgetpasswordPresenter
{
    private ForgetpasswordView forgetpasswordView;

    public ForgetpasswordImp(ForgetpasswordView paramForgetpasswordView)
    {
        this.forgetpasswordView = paramForgetpasswordView;
    }

    public void reset(String paramString1, String paramString2, String paramString3)
    {
        HttpUtils.requestNetByPost(((forgetPassword)RetrofitHelper.getService(Url.HOST, forgetPassword.class)).reset(paramString1, paramString2, paramString3), new HttpUtils.OnResultListener<ForgetPasswordbean>()
        {
            public void onError(Throwable paramThrowable, String paramString)
            {
                ForgetpasswordImp.this.forgetpasswordView.geterror(paramThrowable, paramString);
            }

            public void onSuccess(ForgetPasswordbean paramForgetPasswordbean)
            {
                ForgetpasswordImp.this.forgetpasswordView.getForgetpassworbean(paramForgetPasswordbean);
            }
        });
    }
}