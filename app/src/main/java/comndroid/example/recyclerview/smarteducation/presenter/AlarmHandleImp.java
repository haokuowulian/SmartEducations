package comndroid.example.recyclerview.smarteducation.presenter;

import comndroid.example.recyclerview.smarteducation.Beans.AlarmHandleBean;
import comndroid.example.recyclerview.smarteducation.http.HttpUtils;
import comndroid.example.recyclerview.smarteducation.http.HttpUtils.OnResultListener;
import comndroid.example.recyclerview.smarteducation.http.Url;
import comndroid.example.recyclerview.smarteducation.http.helper.RetrofitHelper;
import comndroid.example.recyclerview.smarteducation.http.service.AlarmHandle;
import comndroid.example.recyclerview.smarteducation.ui.AlarmHandleView;

public class AlarmHandleImp
        implements AlarmHandlePresenter
{
    private AlarmHandleView alarmHandleView;

    public AlarmHandleImp(AlarmHandleView paramAlarmHandleView)
    {
        this.alarmHandleView = paramAlarmHandleView;
    }

    public void huoqu(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8)
    {
        HttpUtils.requestNetByPost(((AlarmHandle)RetrofitHelper.getService(Url.HOST, AlarmHandle.class)).huoqu(paramString1, paramString2, paramString3, paramString4, paramString5, paramString6, paramString7, paramString8), new HttpUtils.OnResultListener<AlarmHandleBean>()
        {
            public void onError(Throwable paramThrowable, String paramString)
            {
                AlarmHandleImp.this.alarmHandleView.geterror(paramThrowable, paramString);
            }

            public void onSuccess(AlarmHandleBean paramAlarmHandleBean)
            {
                AlarmHandleImp.this.alarmHandleView.getAlarmHandleBean(paramAlarmHandleBean);
            }
        });
    }
}