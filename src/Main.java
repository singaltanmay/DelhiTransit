import java.io.*;
import java.util.List;

public class Main {


    public static void main(String[] args) {

        InputStream file = null;

        try {
            file = (InputStream) new FileInputStream("src/VehiclePositions.pb");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        GtfsRealtime.FeedMessage feedMessage = null;
        try {
            feedMessage = GtfsRealtime.FeedMessage.parseFrom(file);
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(feedMessage.toString());

        List<GtfsRealtime.FeedEntity> entityList = feedMessage.getEntityList();

        for (GtfsRealtime.FeedEntity entity : entityList) {

            System.out.println("id: " + entity.getId() + " route: " + entity.getVehicle().getTrip().getRouteId() + " coordinates: " + entity.getVehicle().getPosition().getLatitude() + " " + entity.getVehicle().getPosition().getLongitude() + " speed: " + entity.getVehicle().getPosition().getSpeed());

        }



    }


}

