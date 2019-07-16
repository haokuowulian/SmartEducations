package comndroid.example.recyclerview.smarteducation.presenter;

import comndroid.example.recyclerview.smarteducation.Beans.RoomBean;
import comndroid.example.recyclerview.smarteducation.http.HttpUtils;
import comndroid.example.recyclerview.smarteducation.http.HttpUtils.OnResultListener;
import comndroid.example.recyclerview.smarteducation.http.Url;
import comndroid.example.recyclerview.smarteducation.http.helper.RetrofitHelper;
import comndroid.example.recyclerview.smarteducation.http.service.GetRoomList;
import comndroid.example.recyclerview.smarteducation.ui.GetRoomListView;

public class GetRoomListImp
        implements GetRoomListPresenter
{
    private GetRoomListView getRoomListView;

    public GetRoomListImp(GetRoomListView paramGetRoomListView)
    {
        this.getRoomListView = paramGetRoomListView;
    }

    public void huoqu(String paramString1, String paramString2, String paramString3, String paramString4)
    {
        HttpUtils.requestNetByPost(((GetRoomList)RetrofitHelper.getService(Url.HOST, GetRoomList.class)).huoqu(paramString1, paramString2, paramString3, paramString4), new HttpUtils.OnResultListener<RoomBean>()
        {
            public void onError(Throwable paramThrowable, String paramString)
            {
                GetRoomListImp.this.getRoomListView.geterror(paramThrowable, paramString);
            }

            public void onSuccess(RoomBean paramRoomBean)
            {
                GetRoomListImp.this.getRoomListView.getRoomBean(paramRoomBean);
            }
        });
    }
}