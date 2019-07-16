package comndroid.example.recyclerview.smarteducation.presenter;

import comndroid.example.recyclerview.smarteducation.Beans.MyapproveListBean;
import comndroid.example.recyclerview.smarteducation.http.HttpUtils;
import comndroid.example.recyclerview.smarteducation.http.HttpUtils.OnResultListener;
import comndroid.example.recyclerview.smarteducation.http.Url;
import comndroid.example.recyclerview.smarteducation.http.helper.RetrofitHelper;
import comndroid.example.recyclerview.smarteducation.http.service.MyapproveList;
import comndroid.example.recyclerview.smarteducation.ui.MyapproveListView;

public class MyapproveListImp
        implements MyapproveListPresenter
{
    private MyapproveListView myapproveListView;

    public MyapproveListImp(MyapproveListView paramMyapproveListView)
    {
        this.myapproveListView = paramMyapproveListView;
    }

    public void huoqu(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
    {
        HttpUtils.requestNetByPost(((MyapproveList)RetrofitHelper.getService(Url.HOST, MyapproveList.class)).huoqu(paramString1, paramString2, paramString3, paramString4, paramString5), new HttpUtils.OnResultListener<MyapproveListBean>()
        {
            public void onError(Throwable paramThrowable, String paramString)
            {
              myapproveListView.geterror(paramThrowable, paramString);
            }

            public void onSuccess(MyapproveListBean paramMyapproveListBean)
            {
                myapproveListView.getmyapproveListbean(paramMyapproveListBean);
            }
        });
    }
}