package comndroid.example.recyclerview.smarteducation.presenter;

import comndroid.example.recyclerview.smarteducation.Beans.XiajiBean;
import comndroid.example.recyclerview.smarteducation.http.HttpUtils;
import comndroid.example.recyclerview.smarteducation.http.HttpUtils.OnResultListener;
import comndroid.example.recyclerview.smarteducation.http.Url;
import comndroid.example.recyclerview.smarteducation.http.helper.RetrofitHelper;
import comndroid.example.recyclerview.smarteducation.http.service.getListSubUser;
import comndroid.example.recyclerview.smarteducation.ui.ListSubUserView;

public class ListSubUserImp
        implements ListSubUserPresenter
{
    private ListSubUserView listSubUserView;

    public ListSubUserImp(ListSubUserView paramListSubUserView)
    {
        this.listSubUserView = paramListSubUserView;
    }

    public void get(String paramString1, String paramString2, String paramString3)
    {
        HttpUtils.requestNetByPost(((getListSubUser)RetrofitHelper.getService(Url.HOST, getListSubUser.class)).get(paramString1, paramString2, paramString3), new HttpUtils.OnResultListener<XiajiBean>()
        {
            public void onError(Throwable paramThrowable, String paramString)
            {
                ListSubUserImp.this.listSubUserView.getError(paramThrowable, paramString);
            }

            public void onSuccess(XiajiBean paramXiajiBean)
            {
                ListSubUserImp.this.listSubUserView.getXiajiBean(paramXiajiBean);
            }
        });
    }
}