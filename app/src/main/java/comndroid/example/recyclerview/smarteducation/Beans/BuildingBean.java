package comndroid.example.recyclerview.smarteducation.Beans;

import java.io.Serializable;
import java.util.List;

public class BuildingBean
        implements Serializable
{
    private List<data> data;
    private boolean success;

    public List<data> getData()
    {
        return this.data;
    }

    public boolean isSuccess()
    {
        return this.success;
    }

    public void setData(List<data> paramList)
    {
        this.data = paramList;
    }

    public void setSuccess(boolean paramBoolean)
    {
        this.success = paramBoolean;
    }

    public class data
            implements Serializable
    {
        private String buildingId;
        private String buildingName;
        private int floorCount;

        public data()
        {
        }

        public String getBuildingId()
        {
            return this.buildingId;
        }

        public String getBuildingName()
        {
            return this.buildingName;
        }

        public int getFloorCount()
        {
            return this.floorCount;
        }

        public void setBuildingId(String paramString)
        {
            this.buildingId = paramString;
        }

        public void setBuildingName(String paramString)
        {
            this.buildingName = paramString;
        }

        public void setFloorCount(int paramInt)
        {
            this.floorCount = paramInt;
        }
    }
}