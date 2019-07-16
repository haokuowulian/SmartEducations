package comndroid.example.recyclerview.smarteducation.Beans;

import java.io.Serializable;
import java.util.List;

public class Baoxiubeans
        implements Serializable
{
    private List<data> data;
    private int pageCount;
    private boolean success;
    private int total;

    public List<data> getData()
    {
        return this.data;
    }

    public int getPageCount()
    {
        return this.pageCount;
    }

    public int getTotal()
    {
        return this.total;
    }

    public boolean isSuccess()
    {
        return this.success;
    }

    public void setData(List<data> paramList)
    {
        this.data = paramList;
    }

    public void setPageCount(int paramInt)
    {
        this.pageCount = paramInt;
    }

    public void setSuccess(boolean paramBoolean)
    {
        this.success = paramBoolean;
    }

    public void setTotal(int paramInt)
    {
        this.total = paramInt;
    }

    public class data
            implements Serializable
    {
        private String address;
        private String image;
        private int repairId;
        private int repairType;
        private String repairTypeName;
        private String reportContent;
        private String reportTime;
        private int state;
        private String telphone;
        private String userName;

        public data()
        {
        }

        public String getAddress()
        {
            return this.address;
        }

        public String getImage()
        {
            return this.image;
        }

        public int getRepairId()
        {
            return this.repairId;
        }

        public int getRepairType()
        {
            return this.repairType;
        }

        public String getRepairTypeName()
        {
            return this.repairTypeName;
        }

        public String getReportContent()
        {
            return this.reportContent;
        }

        public String getReportTime()
        {
            return this.reportTime;
        }

        public int getState()
        {
            return this.state;
        }

        public String getTelphone()
        {
            return this.telphone;
        }

        public String getUserName()
        {
            return this.userName;
        }

        public void setAddress(String paramString)
        {
            this.address = paramString;
        }

        public void setImage(String paramString)
        {
            this.image = paramString;
        }

        public void setRepairId(int paramInt)
        {
            this.repairId = paramInt;
        }

        public void setRepairType(int paramInt)
        {
            this.repairType = paramInt;
        }

        public void setRepairTypeName(String paramString)
        {
            this.repairTypeName = paramString;
        }

        public void setReportContent(String paramString)
        {
            this.reportContent = paramString;
        }

        public void setReportTime(String paramString)
        {
            this.reportTime = paramString;
        }

        public void setState(int paramInt)
        {
            this.state = paramInt;
        }

        public void setTelphone(String paramString)
        {
            this.telphone = paramString;
        }

        public void setUserName(String paramString)
        {
            this.userName = paramString;
        }
    }
}