package comndroid.example.recyclerview.smarteducation.Beans;

import java.nio.file.Path;

public class RepairBean {
    private String userName;
    private String buildingId;
    private String roomId;
    private String address;
    private String reportContent;
    private String image;

    public RepairBean(String userName, String buildingId, String roomId, String address, String reportContent, String image, String telphone, String repairType, String repairTypeName) {
        this.userName = userName;
        this.buildingId = buildingId;
        this.roomId = roomId;
        this.address = address;
        this.reportContent = reportContent;
        this.image = image;
        this.telphone = telphone;
        this.repairType = repairType;
        this.repairTypeName = repairTypeName;
    }

    private String telphone;
    private String repairType;
    private String repairTypeName;
}
