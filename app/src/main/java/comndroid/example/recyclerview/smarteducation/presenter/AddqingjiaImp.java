package comndroid.example.recyclerview.smarteducation.presenter;

import comndroid.example.recyclerview.smarteducation.Beans.Addqingjiabean;
import comndroid.example.recyclerview.smarteducation.Beans.Datas;
import comndroid.example.recyclerview.smarteducation.http.HttpUtils;
import comndroid.example.recyclerview.smarteducation.http.HttpUtils.OnResultListener;
import comndroid.example.recyclerview.smarteducation.http.Url;
import comndroid.example.recyclerview.smarteducation.http.helper.RetrofitHelper;
import comndroid.example.recyclerview.smarteducation.http.service.addApprove;
import comndroid.example.recyclerview.smarteducation.ui.AddqingjiaView;
import rx.Observable;

public class AddqingjiaImp
        implements AddqingjiaPresenter
{
    private AddqingjiaView addqingjiaView;

    public AddqingjiaImp(AddqingjiaView paramAddqingjiaView)
    {
        this.addqingjiaView = paramAddqingjiaView;
    }

    public void add(String userId, String token, String distId, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10, String paramString11, String paramString12, String paramString13, String paramString14)
    {
        Datas data=new Datas(paramString4,paramString5,paramString6,paramString7,paramString8,paramString9,paramString10,paramString11,paramString12,paramString13);
        Observable<Addqingjiabean> observable=RetrofitHelper.getService(Url.HOST,addApprove.class).add(userId, token, distId,paramString14,data );
        HttpUtils.requestNetByPost(observable, new OnResultListener<Addqingjiabean>() {
            @Override
            public void onSuccess(Addqingjiabean addqingjiabean) {
          addqingjiaView.getAddqingbean(addqingjiabean);

            }

            @Override
            public void onError(Throwable error, String msg) {
              addqingjiaView.geterror(error, msg);

            }
        });

    }
}