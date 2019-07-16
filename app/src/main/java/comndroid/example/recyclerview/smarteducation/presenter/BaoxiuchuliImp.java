package comndroid.example.recyclerview.smarteducation.presenter;

import comndroid.example.recyclerview.smarteducation.Beans.ResetVerfiyCodebean;
import comndroid.example.recyclerview.smarteducation.http.HttpUtils;
import comndroid.example.recyclerview.smarteducation.http.Url;
import comndroid.example.recyclerview.smarteducation.http.helper.RetrofitHelper;
import comndroid.example.recyclerview.smarteducation.http.service.Baoxiuchuli;
import comndroid.example.recyclerview.smarteducation.ui.BaoxiuchuliView;

public class BaoxiuchuliImp
        implements BaoxiuchuliPrensenter
{
    private BaoxiuchuliView baoxiuchuliView;

    public BaoxiuchuliImp(BaoxiuchuliView paramBaoxiuchuliView)
    {
        this.baoxiuchuliView = paramBaoxiuchuliView;
    }

    public void huoqu(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
    {
        HttpUtils.requestNetByPost(((Baoxiuchuli) RetrofitHelper.getService(Url.HOST, Baoxiuchuli.class)).huoqu(paramString1, paramString2, paramString3, paramString4, paramString5), new HttpUtils.OnResultListener<ResetVerfiyCodebean>()
        {
            public void onError(Throwable paramThrowable, String paramString)
            {
                BaoxiuchuliImp.this.baoxiuchuliView.geterror(paramThrowable, paramString);
            }

            public void onSuccess(ResetVerfiyCodebean paramResetVerfiyCodebean)
            {
                BaoxiuchuliImp.this.baoxiuchuliView.getResetVerfiyCodebean(paramResetVerfiyCodebean);
            }
        });
    }
}
