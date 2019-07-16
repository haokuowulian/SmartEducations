package comndroid.example.recyclerview.smarteducation.presenter;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import comndroid.example.recyclerview.smarteducation.Beans.AddRepairBean;
import comndroid.example.recyclerview.smarteducation.Beans.RepairBean;
import comndroid.example.recyclerview.smarteducation.http.HttpUtils;
import comndroid.example.recyclerview.smarteducation.http.Url;
import comndroid.example.recyclerview.smarteducation.http.helper.RetrofitHelper;
import comndroid.example.recyclerview.smarteducation.http.service.AddRepair;
import comndroid.example.recyclerview.smarteducation.ui.AddRepairView;
import okhttp3.MediaType;
import okhttp3.RequestBody;

public class AddRepairImp
        implements AddRepairPresenter
{
    private AddRepairView addRepairView;

    public AddRepairImp(AddRepairView paramAddRepairView)
    {
        this.addRepairView = paramAddRepairView;
    }

    public void huoqu(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10, String paramString11, String paramString12)
    {

        RepairBean repairBean=new RepairBean(paramString4,paramString5,paramString6,paramString7,paramString8,paramString9,paramString10,paramString11,paramString12);
        HttpUtils.requestNetByPost(((AddRepair) RetrofitHelper.getService(Url.HOST, AddRepair.class)).huoqu(paramString1, paramString2, paramString3,repairBean), new HttpUtils.OnResultListener<AddRepairBean>()
        {
            public void onError(Throwable paramThrowable, String paramString)
            {
                AddRepairImp.this.addRepairView.geterror(paramThrowable, paramString);
            }

            public void onSuccess(AddRepairBean paramAddRepairBean)
            {
                AddRepairImp.this.addRepairView.getAddrepairBean(paramAddRepairBean);
            }
        });
    }
}