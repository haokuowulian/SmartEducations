package comndroid.example.recyclerview.smarteducation.Beans;

import java.util.List;

public class FileitemBean
{
    private List<fileList> fileList;
    private ft ft;

    public List<fileList> getFileList()
    {
        return this.fileList;
    }

    public ft getFt()
    {
        return this.ft;
    }

    public void setFileList(List<fileList> paramList)
    {
        this.fileList = paramList;
    }

    public void setFt(ft paramft)
    {
        this.ft = paramft;
    }

    public class fileList
    {
        private String createDate;
        private String creator;
        private String distId;
        private String id;
        private int state;
        private String title;
        private String url;

        public fileList()
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

        public String getDistId()
        {
            return this.distId;
        }

        public String getId()
        {
            return this.id;
        }

        public int getState()
        {
            return this.state;
        }

        public String getTitle()
        {
            return this.title;
        }

        public String getUrl()
        {
            return this.url;
        }

        public void setCreateDate(String paramString)
        {
            this.createDate = paramString;
        }

        public void setCreator(String paramString)
        {
            this.creator = paramString;
        }

        public void setDistId(String paramString)
        {
            this.distId = paramString;
        }

        public void setId(String paramString)
        {
            this.id = paramString;
        }

        public void setState(int paramInt)
        {
            this.state = paramInt;
        }

        public void setTitle(String paramString)
        {
            this.title = paramString;
        }

        public void setUrl(String paramString)
        {
            this.url = paramString;
        }
    }

    public class ft
    {
        private String createDate;
        private String deleted;
        private String distId;
        private String fileIds;
        private String id;
        private String sendTo;
        private String sendToName;
        private int state;
        private String title;
        private String userId;

        public ft()
        {
        }

        public String getCreateDate()
        {
            return this.createDate;
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

        public int getState()
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

        public void setState(int paramInt)
        {
            this.state = paramInt;
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