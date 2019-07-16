package comndroid.example.recyclerview.smarteducation.presenter;

import comndroid.example.recyclerview.smarteducation.Beans.Baoxiubeans;
import comndroid.example.recyclerview.smarteducation.http.HttpUtils;
import comndroid.example.recyclerview.smarteducation.http.Url;
import comndroid.example.recyclerview.smarteducation.http.helper.RetrofitHelper;
import comndroid.example.recyclerview.smarteducation.http.service.getMyRepairList;
import comndroid.example.recyclerview.smarteducation.ui.MyRepairListPresenterView;

public class MyRepairListImp
        implements MyRepairListPresenter
{
    private MyRepairListPresenterView myRepairListPresenterView;

    public MyRepairListImp(MyRepairListPresenterView paramMyRepairListPresenterView)
    {
        this.myRepairListPresenterView = paramMyRepairListPresenterView;
    }

    public void huoqu(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8)
    {
        HttpUtils.requestNetByPost(((getMyRepairList) RetrofitHelper.getService(Url.HOST, getMyRepairList.class)).huoqu(paramString1, paramString2, paramString3, paramString4, paramString5, paramString6, paramString7, paramString8), new HttpUtils.OnResultListener<Baoxiubeans>()
        {
            public void onError(Throwable paramThrowable, String paramString)
            {
                MyRepairListImp.this.myRepairListPresenterView.getError(paramThrowable, paramString);
            }

            public void onSuccess(Baoxiubeans paramBaoxiubeans)
            {
                MyRepairListImp.this.myRepairListPresenterView.getBaoxiubeans(paramBaoxiubeans);
            }
        });
    }
}