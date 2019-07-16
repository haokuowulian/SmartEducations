package comndroid.example.recyclerview.smarteducation.presenter;

import comndroid.example.recyclerview.smarteducation.Beans.FileitemBean;
import comndroid.example.recyclerview.smarteducation.http.HttpUtils;
import comndroid.example.recyclerview.smarteducation.http.HttpUtils.OnResultListener;
import comndroid.example.recyclerview.smarteducation.http.Url;
import comndroid.example.recyclerview.smarteducation.http.helper.RetrofitHelper;
import comndroid.example.recyclerview.smarteducation.http.service.Fileitem;
import comndroid.example.recyclerview.smarteducation.ui.FileitemView;

public class FileitemImp
        implements FileitemPresenter
{
    private FileitemView fileitemView;

    public FileitemImp(FileitemView paramFileitemView)
    {
        this.fileitemView = paramFileitemView;
    }

    public void huoqu(String paramString1, String paramString2, String paramString3)
    {
        HttpUtils.requestNetByPost(((Fileitem)RetrofitHelper.getService(Url.HOST, Fileitem.class)).huoqu(paramString1, paramString2, paramString3), new HttpUtils.OnResultListener<FileitemBean>()
        {
            public void onError(Throwable paramThrowable, String paramString)
            {
                FileitemImp.this.fileitemView.geterror(paramThrowable, paramString);
            }

            public void onSuccess(FileitemBean paramFileitemBean)
            {
                FileitemImp.this.fileitemView.getFileitemBean(paramFileitemBean);
            }
        });
    }
}