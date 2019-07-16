package comndroid.example.recyclerview.smarteducation.presenter;

import comndroid.example.recyclerview.smarteducation.Beans.ShangjiBean;
import comndroid.example.recyclerview.smarteducation.http.HttpUtils;
import comndroid.example.recyclerview.smarteducation.http.HttpUtils.OnResultListener;
import comndroid.example.recyclerview.smarteducation.http.Url;
import comndroid.example.recyclerview.smarteducation.http.helper.RetrofitHelper;
import comndroid.example.recyclerview.smarteducation.http.service.getShangji;
import comndroid.example.recyclerview.smarteducation.ui.ShangjiView;

public class ShangjiImp
        implements ShangjiPresenter
{
    private ShangjiView shangjiView;

    public ShangjiImp(ShangjiView paramShangjiView)
    {
        this.shangjiView = paramShangjiView;
    }

    public void huoqu(String paramString1, String paramString2, String paramString3)
    {
        HttpUtils.requestNetByPost(((getShangji)RetrofitHelper.getService(Url.HOST, getShangji.class)).huoqu(paramString1, paramString2, paramString3), new HttpUtils.OnResultListener<ShangjiBean>()
        {
            public void onError(Throwable paramThrowable, String paramString)
            {
                ShangjiImp.this.shangjiView.geterror(paramThrowable, paramString);
            }

            public void onSuccess(ShangjiBean paramShangjiBean)
            {
                ShangjiImp.this.shangjiView.getShangjibean(paramShangjiBean);
            }
        });
    }
}