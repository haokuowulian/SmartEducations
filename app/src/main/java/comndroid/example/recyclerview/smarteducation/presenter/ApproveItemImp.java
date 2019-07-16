package comndroid.example.recyclerview.smarteducation.presenter;

import comndroid.example.recyclerview.smarteducation.Beans.ApproveItemBean;
import comndroid.example.recyclerview.smarteducation.http.HttpUtils;
import comndroid.example.recyclerview.smarteducation.http.HttpUtils.OnResultListener;
import comndroid.example.recyclerview.smarteducation.http.Url;
import comndroid.example.recyclerview.smarteducation.http.helper.RetrofitHelper;
import comndroid.example.recyclerview.smarteducation.http.service.ApproveItem;
import comndroid.example.recyclerview.smarteducation.ui.ApproveItemView;

public class ApproveItemImp
        implements ApproveItemPresenter
{
    private ApproveItemView approveItemView;

    public ApproveItemImp(ApproveItemView paramApproveItemView)
    {
        this.approveItemView = paramApproveItemView;
    }

    public void huoqu(String paramString1, String paramString2, String paramString3)
    {
        HttpUtils.requestNetByPost(((ApproveItem)RetrofitHelper.getService(Url.HOST, ApproveItem.class)).huoqu(paramString1, paramString2, paramString3), new HttpUtils.OnResultListener<ApproveItemBean>()
        {
            public void onError(Throwable paramThrowable, String paramString)
            {
                ApproveItemImp.this.approveItemView.geterror(paramThrowable, paramString);
            }

            public void onSuccess(ApproveItemBean paramApproveItemBean)
            {
                ApproveItemImp.this.approveItemView.getApproveItemBean(paramApproveItemBean);
            }
        });
    }
}
