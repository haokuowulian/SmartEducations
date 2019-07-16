package comndroid.example.recyclerview.smarteducation.presenter;

import comndroid.example.recyclerview.smarteducation.Beans.FileListBean;
import comndroid.example.recyclerview.smarteducation.http.HttpUtils;
import comndroid.example.recyclerview.smarteducation.http.HttpUtils.OnResultListener;
import comndroid.example.recyclerview.smarteducation.http.Url;
import comndroid.example.recyclerview.smarteducation.http.helper.RetrofitHelper;
import comndroid.example.recyclerview.smarteducation.http.service.getFilelist;
import comndroid.example.recyclerview.smarteducation.ui.FileListView;

public class FileListImp
        implements FileListPresenter
{
    private FileListView fileListView;

    public FileListImp(FileListView paramFileListView)
    {
        this.fileListView = paramFileListView;
    }

    public void huoqu(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
    {
        HttpUtils.requestNetByPost(((getFilelist)RetrofitHelper.getService(Url.HOST, getFilelist.class)).huoqu(paramString1, paramString2, paramString3, paramString4, paramString5), new HttpUtils.OnResultListener<FileListBean>()
        {
            public void onError(Throwable paramThrowable, String paramString)
            {
                FileListImp.this.fileListView.geterror(paramThrowable, paramString);
            }

            public void onSuccess(FileListBean paramFileListBean)
            {
                FileListImp.this.fileListView.getFileListBean(paramFileListBean);
            }
        });
    }
}