package comndroid.example.recyclerview.smarteducation.http;

import android.text.TextUtils;
import android.util.Log;

import comndroid.example.recyclerview.smarteducation.Utils.ToastUtils;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class HttpUtils {


    //Post方式请求网络
    public static<T> void requestNetByPost(Observable observable, final OnResultListener resultListener){

        setSubscriber(observable, new Subscriber<T>() {
            @Override
            public void onCompleted() {
                Log.e("onCompleted","读取完成");
            }

            @Override
            public void onError(Throwable error) {

                if(error!=null && resultListener!=null){
                    resultListener.onError(error,error.getMessage());
                }else if(resultListener!=null){
                    resultListener.onError(new Exception("与服务器连接失败"),"");
                    ToastUtils.showShort("与服务器连接失败");;
                    return;
                }

                String e  = error.getMessage();
                int code  =0;
                if(!TextUtils.isEmpty(e)){
                    try {
                        e = e.substring(e.length()-3,e.length());
                        code = Integer.valueOf(e);
                    }catch (Exception e1){
                        ToastUtils.showShort("与服务器连接失败");
                    }
                }
                Log.e("code==：",code+"");
                if(code>=300&&code<500){
                    ToastUtils.showShort("您的请求迷路了，请稍后再试");
                }else if(code>=500){
                    ToastUtils.showShort("服务器异常，请稍后再试");
                }else{
                    ToastUtils.showShort("与服务器连接失败");
                }
            }

            @Override
            public void onNext(T t) {

                if(resultListener!=null){
                    resultListener.onSuccess(t);
                }
            }
        });
    }

    //Get方式请求网络
    public static void requestNetByGet(Observable observable,final OnResultListener resultListener){

        requestNetByPost(observable,resultListener);
    }


    //订阅事件
    public static<T> void setSubscriber(Observable<T> observable, Subscriber<T> subscriber){

        observable.subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }


    //接口回调
    public interface OnResultListener<T>{

        void onSuccess(T t);
        void onError(Throwable error, String msg);
    }

}

