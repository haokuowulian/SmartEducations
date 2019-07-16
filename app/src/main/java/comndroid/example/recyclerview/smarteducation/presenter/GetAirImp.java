package comndroid.example.recyclerview.smarteducation.presenter;

import comndroid.example.recyclerview.smarteducation.Beans.AirReturnBean;
import comndroid.example.recyclerview.smarteducation.http.HttpUtils;
import comndroid.example.recyclerview.smarteducation.http.Url;
import comndroid.example.recyclerview.smarteducation.http.helper.RetrofitHelper;
import comndroid.example.recyclerview.smarteducation.http.service.GetAir;
import comndroid.example.recyclerview.smarteducation.ui.GetAirView;
import rx.Observable;

public class GetAirImp implements GetAirPresenter {
    private GetAirView getAirView;
    public GetAirImp(GetAirView getAirView){
        this.getAirView=getAirView;
    }
    @Override
    public void get(String userId, String token, String distId) {
        Observable<AirReturnBean> observable= RetrofitHelper.getService(Url.HOST, GetAir.class).get(userId, token, distId);
        HttpUtils.requestNetByPost(observable, new HttpUtils.OnResultListener<AirReturnBean>() {


            @Override
            public void onSuccess(AirReturnBean airReturnBean) {
                getAirView.getAirReturnBean(airReturnBean);
            }

            @Override
            public void onError(Throwable error, String msg) {
getAirView.getError(msg, error);
            }
        });
    }
}
