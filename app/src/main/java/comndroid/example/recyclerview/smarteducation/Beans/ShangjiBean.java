package comndroid.example.recyclerview.smarteducation.Beans;

import java.io.Serializable;
import java.util.List;

public class ShangjiBean
        implements Serializable
{
    private List<userList1> userList1;
    private List<userList2> userList2;

    public List<userList1> getUserList1()
    {
        return this.userList1;
    }

    public List<userList2> getUserList2()
    {
        return this.userList2;
    }

    public void setUserList1(List<userList1> paramList)
    {
        this.userList1 = paramList;
    }

    public void setUserList2(List<userList2> paramList)
    {
        this.userList2 = paramList;
    }

    public class userList1
            implements Serializable
    {
        private String id;
        private String realName;

        public userList1()
        {
        }

        public String getId()
        {
            return this.id;
        }

        public String getRealName()
        {
            return this.realName;
        }

        public void setId(String paramString)
        {
            this.id = paramString;
        }

        public void setRealName(String paramString)
        {
            this.realName = paramString;
        }
    }

    public class userList2
            implements Serializable
    {
        private String id;
        private String realName;

        public userList2()
        {
        }

        public String getId()
        {
            return this.id;
        }

        public String getRealName()
        {
            return this.realName;
        }

        public void setId(String paramString)
        {
            this.id = paramString;
        }

        public void setRealName(String paramString)
        {
            this.realName = paramString;
        }
    }
}