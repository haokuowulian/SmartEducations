package comndroid.example.recyclerview.smarteducation.presenter;

import java.net.URI;

import comndroid.example.recyclerview.smarteducation.Beans.HandlereturnBean;
import comndroid.example.recyclerview.smarteducation.http.HttpUtils;
import comndroid.example.recyclerview.smarteducation.http.HttpUtils.OnResultListener;
import comndroid.example.recyclerview.smarteducation.http.Url;
import comndroid.example.recyclerview.smarteducation.http.helper.RetrofitHelper;
import comndroid.example.recyclerview.smarteducation.http.service.ApproveHandleing;
import comndroid.example.recyclerview.smarteducation.ui.ApproveHandleingView;

public class ApproveHandleingImp
        implements ApproveHandleingPresenter
{
    private ApproveHandleingView approveHandleingView;

    public ApproveHandleingImp(ApproveHandleingView paramApproveHandleingView)
    {
        this.approveHandleingView = paramApproveHandleingView;
    }

    public void huoqu(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
    {
        HttpUtils.requestNetByPost(((ApproveHandleing)RetrofitHelper.getService(Url.HOST, ApproveHandleing.class)).huoqu(paramString1, paramString2, paramString3, paramString4, paramString5), new HttpUtils.OnResultListener<HandlereturnBean>()
        {
            public void onError(Throwable paramThrowable, String paramString)
            {
                ApproveHandleingImp.this.approveHandleingView.geterror(paramThrowable, paramString);
            }

            public void onSuccess(HandlereturnBean paramHandlereturnBean)
            {
                ApproveHandleingImp.this.approveHandleingView.getHandlereturnBean(paramHandlereturnBean);
            }
        });
    }
}