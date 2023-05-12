import java.util.ArrayList;

public class Hotel {
    private String hotelName;
    private ArrayList<Room> rooms;

    public Hotel(String hotelName, ArrayList<Room> rooms) {
        this.hotelName = hotelName;
        this.rooms = rooms;
    }

    public String getHotelName() {
        return hotelName;
    }

    public ArrayList<Room> getRooms() {
        return rooms;
    }

    public void displayRooms() {
        System.out.println("\n" + hotelName + " Room Types:");
        int i = 1;
        for (Room room : rooms) {
            System.out.println(i + ". " + room.getRoomType() + " (Max Pax: " + room.getMaxPax() + ") - RM " + room.getPrice());
            i++;
        }
    }
}

class Room {
    private String roomType;
    private int maxPax;
    private double price;

    public Room(String roomType, int maxPax, double price) {
        this.roomType = roomType;
        this.maxPax = maxPax;
        this.price = price;
    }

    public String getRoomType() {
        return roomType;
    }

    public int getMaxPax() {
        return maxPax;
    }

    public double getPrice() {
        return price;
    }
}

