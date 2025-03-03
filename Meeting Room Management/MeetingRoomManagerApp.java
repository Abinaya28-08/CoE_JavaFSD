import java.util.*;


enum RoomFeature {
    PROJECTOR,
    VIDEO_CONFERENCING,
    WHITEBOARD,
    CONFERENCE_PHONE,
    AIR_CONDITIONING
}


class MeetingRoom {
    String roomId;
    String roomName;
    int capacity;
    EnumSet<RoomFeature> features;

    public MeetingRoom(String roomId, String roomName, int capacity, EnumSet<RoomFeature> features) {
        this.roomId = roomId;
        this.roomName = roomName;
        this.capacity = capacity;
        this.features = features;
    }
}


class RoomScheduler {
    private Map<String, MeetingRoom> meetingRooms = new HashMap<>();

    // Add a meeting room
    public void addMeetingRoom(MeetingRoom room) {
        meetingRooms.put(room.roomId, room);
        System.out.println("Room added: " + room.roomName + ", ID: " + room.roomId);
    }

 
    public String bookRoom(String roomId, EnumSet<RoomFeature> requiredFeatures) {
        if (meetingRooms.containsKey(roomId)) {
            MeetingRoom room = meetingRooms.get(roomId);
            if (room.features.containsAll(requiredFeatures)) {
                return "Room " + roomId + " booked successfully.";
            } else {
                return "Room " + roomId + " does not meet the required features.";
            }
        }
        return "Room ID not found.";
    }

    // List available rooms with required features
    public List<String> listAvailableRooms(EnumSet<RoomFeature> requiredFeatures) {
        List<String> availableRooms = new ArrayList<>();
        for (MeetingRoom room : meetingRooms.values()) {
            if (room.features.containsAll(requiredFeatures)) {
                availableRooms.add(room.roomName);
            }
        }
        return availableRooms;
    }
}


public class MeetingRoomManagerApp {
    public static void main(String[] args) {
        RoomScheduler scheduler = new RoomScheduler();


        scheduler.addMeetingRoom(new MeetingRoom("001", "Boardroom", 20, EnumSet.of(RoomFeature.PROJECTOR, RoomFeature.CONFERENCE_PHONE, RoomFeature.AIR_CONDITIONING)));
        scheduler.addMeetingRoom(new MeetingRoom("002", "Strategy Room", 10, EnumSet.of(RoomFeature.WHITEBOARD, RoomFeature.AIR_CONDITIONING)));


        System.out.println(scheduler.bookRoom("001", EnumSet.of(RoomFeature.PROJECTOR, RoomFeature.CONFERENCE_PHONE)));
   
        List<String> availableRooms = scheduler.listAvailableRooms(EnumSet.of(RoomFeature.AIR_CONDITIONING));
        System.out.println("Available rooms with AIR_CONDITIONING: " + availableRooms);
    }
}