package comndroid.example.recyclerview.smarteducation.presenter;

import comndroid.example.recyclerview.smarteducation.Beans.ForgetPasswordbean;
import comndroid.example.recyclerview.smarteducation.http.HttpUtils;
import comndroid.example.recyclerview.smarteducation.http.HttpUtils.OnResultListener;
import comndroid.example.recyclerview.smarteducation.http.Url;
import comndroid.example.recyclerview.smarteducation.http.helper.RetrofitHelper;
import comndroid.example.recyclerview.smarteducation.http.service.updatePassword;
import comndroid.example.recyclerview.smarteducation.ui.UpdatePasswordView;

public class UpdatePasswordImp
        implements UpdatePasswordPresenter
{
    private UpdatePasswordView updatePasswordView;

    public UpdatePasswordImp(UpdatePasswordView paramUpdatePasswordView)
    {
        this.updatePasswordView = paramUpdatePasswordView;
    }

    public void update(String paramString1, String paramString2, String paramString3, String paramString4)
    {
        HttpUtils.requestNetByPost(((updatePassword)RetrofitHelper.getService(Url.HOST, updatePassword.class)).update(paramString1, paramString2, paramString3, paramString4), new HttpUtils.OnResultListener<ForgetPasswordbean>()
        {
            public void onError(Throwable paramThrowable, String paramString)
            {
                UpdatePasswordImp.this.updatePasswordView.geterror(paramThrowable, paramString);
            }

            public void onSuccess(ForgetPasswordbean paramForgetPasswordbean)
            {
                UpdatePasswordImp.this.updatePasswordView.getForgetPasswordbean(paramForgetPasswordbean);
            }
        });
    }
}