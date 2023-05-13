public class RoomDisplay {
    private int RoomNum;
    private String RoomType;
    private double RoomPrice;

    public RoomDisplay() {
    }
    public RoomDisplay(int roomNum, String roomType, double roomPrice) {
        this.RoomNum = roomNum;
        this.RoomType = roomType;
        this.RoomPrice = roomPrice;
    }

    public int getRoomNum() {
        return RoomNum;
    }

    public void setRoomNum(int roomNum) {
        RoomNum = roomNum;
    }

    public String getRoomType() {
        return RoomType;
    }

    public void setRoomType(String roomType) {
        RoomType = roomType;
    }

    public double getRoomPrice() {
        return RoomPrice;
    }

    public void setRoomPrice(double roomPrice) {
        RoomPrice = roomPrice;
    }
}
