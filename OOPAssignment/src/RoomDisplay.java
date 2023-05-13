public class RoomDisplay {
    private int RoomNum;
    private String RoomType;

    public RoomDisplay() {
    }
    public RoomDisplay(int roomNum, String roomType) {
        RoomNum = roomNum;
        RoomType = roomType;
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
}
