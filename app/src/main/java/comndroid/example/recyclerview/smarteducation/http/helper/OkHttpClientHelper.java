package comndroid.example.recyclerview.smarteducation.http.helper;

import android.util.Log;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import okhttp3.Cache;
import okhttp3.Interceptor;
import okhttp3.Interceptor.Chain;
import okhttp3.OkHttpClient;
import okhttp3.OkHttpClient.Builder;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import okhttp3.logging.HttpLoggingInterceptor.Level;
import okhttp3.logging.HttpLoggingInterceptor.Logger;

public class OkHttpClientHelper
{
    private static final long TIMEOUT = 10000L;
    private static OkHttpClientHelper clientHelper;
    private final Cache cache = CacheHelper.getInstance().getCache();
    private OkHttpClient mClient;

    public static OkHttpClientHelper getInstance()
    {
        if (clientHelper == null)
        {
            clientHelper=new OkHttpClientHelper();
            try
            {
                if (clientHelper == null)
                    clientHelper = new OkHttpClientHelper();
            }
            finally
            {
                clientHelper = new OkHttpClientHelper();
                ;
            }
        }
        return clientHelper;
    }

    public OkHttpClient getOkHttpClient()
    {
        HttpLoggingInterceptor localHttpLoggingInterceptor = new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger()
        {
            public void log(String paramString)
            {
                StringBuilder localStringBuilder = new StringBuilder();
                localStringBuilder.append("retrofitBack = ");
                localStringBuilder.append(paramString);
                Log.i("RetrofitLog", localStringBuilder.toString());
            }
        });
        localHttpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        if (this.mClient == null)
            this.mClient = new OkHttpClient.Builder().addInterceptor(localHttpLoggingInterceptor).connectTimeout(10000L, TimeUnit.SECONDS).readTimeout(10000L, TimeUnit.SECONDS).writeTimeout(10000L, TimeUnit.SECONDS).addInterceptor(new Interceptor()
            {
                public Response intercept(Interceptor.Chain paramChain)
                        throws IOException
                {
                    return paramChain.proceed(paramChain.request().newBuilder().addHeader("Content-Type", "application/json;charset=UTF-8").addHeader("Accept-Encoding", "gzip, deflate").addHeader("Connection", "keep-alive").addHeader("Accept", "*/*").addHeader("Cookie", "add cookies here").build());
                }
            }).cache(this.cache).build();
        return this.mClient;
    }
}