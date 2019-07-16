package comndroid.example.recyclerview.smarteducation.presenter;

import comndroid.example.recyclerview.smarteducation.Beans.ApproveListBean;
import comndroid.example.recyclerview.smarteducation.http.HttpUtils;
import comndroid.example.recyclerview.smarteducation.http.HttpUtils.OnResultListener;
import comndroid.example.recyclerview.smarteducation.http.Url;
import comndroid.example.recyclerview.smarteducation.http.helper.RetrofitHelper;
import comndroid.example.recyclerview.smarteducation.http.service.Approvelist;
import comndroid.example.recyclerview.smarteducation.ui.ApproveListView;

public class ApproveListImp
        implements ApprovelistPrensenter
{
    private ApproveListView approveListView;

    public ApproveListImp(ApproveListView paramApproveListView)
    {
        this.approveListView = paramApproveListView;
    }

    public void huoqu(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
    {
        HttpUtils.requestNetByPost(((Approvelist)RetrofitHelper.getService(Url.HOST, Approvelist.class)).huoqu(paramString1, paramString2, paramString3, paramString4, paramString5), new HttpUtils.OnResultListener<ApproveListBean>()
        {
            public void onError(Throwable paramThrowable, String paramString)
            {
                ApproveListImp.this.approveListView.geterror(paramThrowable, paramString);
            }

            public void onSuccess(ApproveListBean paramApproveListBean)
            {
                ApproveListImp.this.approveListView.getApproveListBean(paramApproveListBean);
            }
        });
    }
}