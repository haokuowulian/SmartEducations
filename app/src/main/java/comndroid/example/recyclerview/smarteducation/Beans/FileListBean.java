package comndroid.example.recyclerview.smarteducation.Beans;

import java.io.Serializable;
import java.util.List;

public class FileListBean
        implements Serializable
{
    private String code;
    private int count;
    private List<data> data;
    private String msg;
    private String pageIndex;
    private int pageSize;

    public String getCode()
    {
        return this.code;
    }

    public int getCount()
    {
        return this.count;
    }

    public List<data> getData()
    {
        return this.data;
    }

    public String getMsg()
    {
        return this.msg;
    }

    public String getPageIndex()
    {
        return this.pageIndex;
    }

    public int getPageSize()
    {
        return this.pageSize;
    }

    public void setCode(String paramString)
    {
        this.code = paramString;
    }

    public void setCount(int paramInt)
    {
        this.count = paramInt;
    }

    public void setData(List<data> paramList)
    {
        this.data = paramList;
    }

    public void setMsg(String paramString)
    {
        this.msg = paramString;
    }

    public void setPageIndex(String paramString)
    {
        this.pageIndex = paramString;
    }

    public void setPageSize(int paramInt)
    {
        this.pageSize = paramInt;
    }

    public class data
            implements Serializable
    {
        private String createDate;
        private String creator;
        private String deleted;
        private String distId;
        private String fileIds;
        private String id;
        private String sendTo;
        private String sendToName;
        private String state;
        private String title;
        private String userId;

        public data()
        {
        }

        public String getCreateDate()
        {
            return this.createDate;
        }

        public String getCreator()
        {
            return this.creator;
        }

        public String getDeleted()
        {
            return this.deleted;
        }

        public String getDistId()
        {
            return this.distId;
        }

        public String getFileIds()
        {
            return this.fileIds;
        }

        public String getId()
        {
            return this.id;
        }

        public String getSendTo()
        {
            return this.sendTo;
        }

        public String getSendToName()
        {
            return this.sendToName;
        }

        public String getState()
        {
            return this.state;
        }

        public String getTitle()
        {
            return this.title;
        }

        public String getUserId()
        {
            return this.userId;
        }

        public void setCreateDate(String paramString)
        {
            this.createDate = paramString;
        }

        public void setCreator(String paramString)
        {
            this.creator = paramString;
        }

        public void setDeleted(String paramString)
        {
            this.deleted = paramString;
        }

        public void setDistId(String paramString)
        {
            this.distId = paramString;
        }

        public void setFileIds(String paramString)
        {
            this.fileIds = paramString;
        }

        public void setId(String paramString)
        {
            this.id = paramString;
        }

        public void setSendTo(String paramString)
        {
            this.sendTo = paramString;
        }

        public void setSendToName(String paramString)
        {
            this.sendToName = paramString;
        }

        public void setState(String paramString)
        {
            this.state = paramString;
        }

        public void setTitle(String paramString)
        {
            this.title = paramString;
        }

        public void setUserId(String paramString)
        {
            this.userId = paramString;
        }
    }
}