package comndroid.example.recyclerview.smarteducation.presenter;

import comndroid.example.recyclerview.smarteducation.Beans.Baoxiuitembean;
import comndroid.example.recyclerview.smarteducation.http.HttpUtils;
import comndroid.example.recyclerview.smarteducation.http.Url;
import comndroid.example.recyclerview.smarteducation.http.helper.RetrofitHelper;
import comndroid.example.recyclerview.smarteducation.http.service.infoRepair;
import comndroid.example.recyclerview.smarteducation.ui.InfoRepairView;

public class InfoRepairImp
        implements InfoRepairPrensenter
{
    private InfoRepairView infoRepairView;

    public InfoRepairImp(InfoRepairView paramInfoRepairView)
    {
        this.infoRepairView = paramInfoRepairView;
    }

    public void huoqu(String paramString1, String paramString2, String paramString3)
    {
        HttpUtils.requestNetByPost(((infoRepair) RetrofitHelper.getService(Url.HOST, infoRepair.class)).huoqu(paramString1, paramString2, paramString3), new HttpUtils.OnResultListener<Baoxiuitembean>()
        {
            public void onError(Throwable paramThrowable, String paramString)
            {
                InfoRepairImp.this.infoRepairView.getError(paramThrowable, paramString);
            }

            public void onSuccess(Baoxiuitembean paramBaoxiuitembean)
            {
                InfoRepairImp.this.infoRepairView.getBaoxiuitembean(paramBaoxiuitembean);
            }
        });
    }
}