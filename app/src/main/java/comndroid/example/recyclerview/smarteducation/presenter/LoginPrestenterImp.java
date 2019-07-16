package comndroid.example.recyclerview.smarteducation.presenter;

import comndroid.example.recyclerview.smarteducation.Beans.Loginreturns;
import comndroid.example.recyclerview.smarteducation.http.HttpUtils;
import comndroid.example.recyclerview.smarteducation.http.HttpUtils.OnResultListener;
import comndroid.example.recyclerview.smarteducation.http.Url;
import comndroid.example.recyclerview.smarteducation.http.helper.RetrofitHelper;
import comndroid.example.recyclerview.smarteducation.http.service.login;
import comndroid.example.recyclerview.smarteducation.ui.LoginVIew;

public class LoginPrestenterImp
        implements Loginpresenter
{
    private LoginVIew loginVIew;

    public LoginPrestenterImp(LoginVIew paramLoginVIew)
    {
        this.loginVIew = paramLoginVIew;
    }

    public void login(String paramString1, String paramString2)
    {
        HttpUtils.requestNetByGet(((login)RetrofitHelper.getService(Url.HOST, login.class)).login(paramString1, paramString2), new HttpUtils.OnResultListener<Loginreturns>()
        {
            public void onError(Throwable paramThrowable, String paramString)
            {
                loginVIew.geterror(paramThrowable, paramString);
            }

            public void onSuccess(Loginreturns paramLoginreturns)
            {
                loginVIew.getLoginreturns(paramLoginreturns);
            }
        });
    }
}