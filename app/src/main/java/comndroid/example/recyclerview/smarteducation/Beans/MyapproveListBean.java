package comndroid.example.recyclerview.smarteducation.Beans;

import java.io.Serializable;
import java.util.List;

public class MyapproveListBean
        implements Serializable
{
    private String code;
    private int count;
    private List<data> data;
    private String msg;
    private int pageIndex;
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

    public int getPageIndex()
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

    public void setPageIndex(int paramInt)
    {
        this.pageIndex = paramInt;
    }

    public void setPageSize(int paramInt)
    {
        this.pageSize = paramInt;
    }

    public class data
            implements Serializable
    {
        private int appStatus;
        private String createDate;
        private String creator;
        private String deleted;
        private String deptName;
        private String endDate;
        private String howlong;
        private String id;
        private String incident;
        private int leaveType;
        private int onelevelId;
        private int readyStatus;
        private String realName;
        private String startDate;
        private int twolevelId;
        private int userId;

        public data()
        {
        }

        public int getAppStatus()
        {
            return this.appStatus;
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

        public String getDeptName()
        {
            return this.deptName;
        }

        public String getEndDate()
        {
            return this.endDate;
        }

        public String getHowlong()
        {
            return this.howlong;
        }

        public String getId()
        {
            return this.id;
        }

        public String getIncident()
        {
            return this.incident;
        }

        public int getLeaveType()
        {
            return this.leaveType;
        }

        public int getOnelevelId()
        {
            return this.onelevelId;
        }

        public int getReadyStatus()
        {
            return this.readyStatus;
        }

        public String getRealName()
        {
            return this.realName;
        }

        public String getStartDate()
        {
            return this.startDate;
        }

        public int getTwolevelId()
        {
            return this.twolevelId;
        }

        public int getUserId()
        {
            return this.userId;
        }

        public void setAppStatus(int paramInt)
        {
            this.appStatus = paramInt;
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

        public void setDeptName(String paramString)
        {
            this.deptName = paramString;
        }

        public void setEndDate(String paramString)
        {
            this.endDate = paramString;
        }

        public void setHowlong(String paramInt)
        {
            this.howlong = paramInt;
        }

        public void setId(String paramString)
        {
            this.id = paramString;
        }

        public void setIncident(String paramString)
        {
            this.incident = paramString;
        }

        public void setLeaveType(int paramInt)
        {
            this.leaveType = paramInt;
        }

        public void setOnelevelId(int paramInt)
        {
            this.onelevelId = paramInt;
        }

        public void setReadyStatus(int paramInt)
        {
            this.readyStatus = paramInt;
        }

        public void setRealName(String paramString)
        {
            this.realName = paramString;
        }

        public void setStartDate(String paramString)
        {
            this.startDate = paramString;
        }

        public void setTwolevelId(int paramInt)
        {
            this.twolevelId = paramInt;
        }

        public void setUserId(int paramInt)
        {
            this.userId = paramInt;
        }
    }
}