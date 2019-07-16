package comndroid.example.recyclerview.smarteducation.presenter;

import comndroid.example.recyclerview.smarteducation.Beans.ResetVerfiyCodebean;
import comndroid.example.recyclerview.smarteducation.http.HttpUtils;
import comndroid.example.recyclerview.smarteducation.http.HttpUtils.OnResultListener;
import comndroid.example.recyclerview.smarteducation.http.Url;
import comndroid.example.recyclerview.smarteducation.http.helper.RetrofitHelper;
import comndroid.example.recyclerview.smarteducation.http.service.ResetVerfiyCode;
import comndroid.example.recyclerview.smarteducation.ui.ResetVerfiyCodeView;

public class ResetVerfiyCodeImp
        implements ResetVerfiyCodePresenter
{
    private ResetVerfiyCodeView resetVerfiyCodeView;

    public ResetVerfiyCodeImp(ResetVerfiyCodeView paramResetVerfiyCodeView)
    {
        this.resetVerfiyCodeView = paramResetVerfiyCodeView;
    }

    public void reset(String paramString)
    {
        HttpUtils.requestNetByPost(((ResetVerfiyCode)RetrofitHelper.getService(Url.HOST, ResetVerfiyCode.class)).reset(paramString), new HttpUtils.OnResultListener<ResetVerfiyCodebean>()
        {
            public void onError(Throwable paramThrowable, String paramString)
            {
                ResetVerfiyCodeImp.this.resetVerfiyCodeView.geterror(paramThrowable, paramString);
            }

            public void onSuccess(ResetVerfiyCodebean paramResetVerfiyCodebean)
            {
                ResetVerfiyCodeImp.this.resetVerfiyCodeView.getResetVerfiyCodebean(paramResetVerfiyCodebean);
            }
        });
    }
}
