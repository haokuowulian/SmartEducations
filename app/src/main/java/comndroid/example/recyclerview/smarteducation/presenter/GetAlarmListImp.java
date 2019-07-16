package comndroid.example.recyclerview.smarteducation.presenter;

import comndroid.example.recyclerview.smarteducation.Beans.BaojingBean;
import comndroid.example.recyclerview.smarteducation.http.HttpUtils;
import comndroid.example.recyclerview.smarteducation.http.HttpUtils.OnResultListener;
import comndroid.example.recyclerview.smarteducation.http.Url;
import comndroid.example.recyclerview.smarteducation.http.helper.RetrofitHelper;
import comndroid.example.recyclerview.smarteducation.http.service.GetAlarmList;
import comndroid.example.recyclerview.smarteducation.ui.GetAlarmListView;

public class GetAlarmListImp
        implements GetAlarmListPresenter
{
    private GetAlarmListView getAlarmListView;

    public GetAlarmListImp(GetAlarmListView paramGetAlarmListView)
    {
        this.getAlarmListView = paramGetAlarmListView;
    }

    public void huoqu(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7)
    {
        HttpUtils.requestNetByPost(((GetAlarmList)RetrofitHelper.getService(Url.HOST, GetAlarmList.class)).huoqu(paramString1, paramString2, paramString3, paramString4, paramString5, paramString6, paramString7), new HttpUtils.OnResultListener<BaojingBean>()
        {
            public void onError(Throwable paramThrowable, String paramString)
            {
                GetAlarmListImp.this.getAlarmListView.geterror(paramThrowable, paramString);
            }

            public void onSuccess(BaojingBean paramBaojingBean)
            {
                GetAlarmListImp.this.getAlarmListView.getBaojingBean(paramBaojingBean);
            }
        });
    }
}