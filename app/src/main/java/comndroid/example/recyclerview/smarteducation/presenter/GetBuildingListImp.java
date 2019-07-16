package comndroid.example.recyclerview.smarteducation.presenter;

import comndroid.example.recyclerview.smarteducation.Beans.BuildingBean;
import comndroid.example.recyclerview.smarteducation.http.HttpUtils;
import comndroid.example.recyclerview.smarteducation.http.HttpUtils.OnResultListener;
import comndroid.example.recyclerview.smarteducation.http.Url;
import comndroid.example.recyclerview.smarteducation.http.helper.RetrofitHelper;
import comndroid.example.recyclerview.smarteducation.http.service.GetBuildingList;
import comndroid.example.recyclerview.smarteducation.ui.GetBulidingListView;

public class GetBuildingListImp
        implements GetBulidingListPresenter
{
    private GetBulidingListView getBulidingListView;

    public GetBuildingListImp(GetBulidingListView paramGetBulidingListView)
    {
        this.getBulidingListView = paramGetBulidingListView;
    }

    public void huoqu(String paramString1, String paramString2, String paramString3)
    {
        HttpUtils.requestNetByPost(((GetBuildingList)RetrofitHelper.getService(Url.HOST, GetBuildingList.class)).huoqu(paramString1, paramString2, paramString3), new HttpUtils.OnResultListener<BuildingBean>()
        {
            public void onError(Throwable paramThrowable, String paramString)
            {
                GetBuildingListImp.this.getBulidingListView.geterror(paramThrowable, paramString);
            }

            public void onSuccess(BuildingBean paramBuildingBean)
            {
                GetBuildingListImp.this.getBulidingListView.getBuildingListBean(paramBuildingBean);
            }
        });
    }
}