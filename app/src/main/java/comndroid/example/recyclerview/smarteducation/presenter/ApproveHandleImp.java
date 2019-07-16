package comndroid.example.recyclerview.smarteducation.presenter;

import comndroid.example.recyclerview.smarteducation.Beans.ApproveListBean;
import comndroid.example.recyclerview.smarteducation.http.HttpUtils;
import comndroid.example.recyclerview.smarteducation.http.HttpUtils.OnResultListener;
import comndroid.example.recyclerview.smarteducation.http.Url;
import comndroid.example.recyclerview.smarteducation.http.helper.RetrofitHelper;
import comndroid.example.recyclerview.smarteducation.http.service.ApproveHandle;
import comndroid.example.recyclerview.smarteducation.ui.ApproveListView;

public class ApproveHandleImp
        implements ApproveHandlePresenter
{
    private ApproveListView approveListView;

    public ApproveHandleImp(ApproveListView paramApproveListView)
    {
        this.approveListView = paramApproveListView;
    }

    public void huoqu(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
    {
        HttpUtils.requestNetByPost(((ApproveHandle)RetrofitHelper.getService(Url.HOST, ApproveHandle.class)).huoqu(paramString1, paramString2, paramString3, paramString4, paramString5), new HttpUtils.OnResultListener<ApproveListBean>()
        {
            public void onError(Throwable paramThrowable, String paramString)
            {
                ApproveHandleImp.this.approveListView.geterror(paramThrowable, paramString);
            }

            public void onSuccess(ApproveListBean paramApproveListBean)
            {
                ApproveHandleImp.this.approveListView.getApproveListBean(paramApproveListBean);
            }
        });
    }
}