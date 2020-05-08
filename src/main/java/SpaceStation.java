import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class SpaceStation {
    private ArrayList<Astronaut> astronauts;
    private ArrayList<Resource> resources;
    private ArrayList<Room> rooms;

    public SpaceStation() {
        astronauts = new ArrayList<>();
        resources = new ArrayList<>();
        rooms = new ArrayList<>();
    }

    public SpaceStation(ArrayList<Astronaut> astronautsIn, ArrayList<Resource> resourcesIn, ArrayList<Room> roomsIn){
        astronauts = astronautsIn;
        resources = resourcesIn;
        rooms = roomsIn;
    }

    public ArrayList<Astronaut> getAstronauts(){
        return astronauts;
    }

    public void setAstronauts(ArrayList<Astronaut> astronauts) {
        this.astronauts = astronauts;
    }

    public ArrayList<Resource> getResources(){ return resources; }

    public void setResources(ArrayList<Resource> resources) {
            this.resources = resources;
        }

    public ArrayList<Room> getRooms() { return rooms; }

    public void setRooms(ArrayList<Room> rooms) { this.rooms = rooms; }

    public void addAstronaut(Astronaut astronautToAdd){
        astronauts.add(astronautToAdd);
    }

    public void addRoom(Room roomToAdd) { rooms.add(roomToAdd); }

    public void addResource(String resourceToAdd, double amountToAdd) {
        for (int i = 0; i < resources.size(); i++) {
            if (resources.get(i).getName().equals(resourceToAdd)) {
                resources.get(i).addAmount(amountToAdd);
            }
        }
    }

    public void addResource(Resource resourceToAdd){
        for(int i = 0; i < resources.size(); i++){
            if(resources.get(i).getName().equals(resourceToAdd.getName())){
                resources.get(i).addAmount(resourceToAdd.getAmount());
                return;
            }
        }
        resources.add(resourceToAdd);
    }

    public String toString() {
        String s = "Astronauts: ";
        for (User u : this.astronauts) {
            s += u.getId() + " ";
        }
        s += "\nResources: ";
        for (Resource r : this.resources) {
            s += r.getName() + " " + r.getAmount() + " ";
        }
        return s;
    }

    public String displayRooms() {
        String s = "";
        for(Room r : this.getRooms()) {
            s += r.getName() + ", ";
        }
        s = s.substring(0, s.length() - 2);
        return s;
    }

    public static ArrayList<String> resourceList(SpaceStation station) {
        ArrayList<String> resourceList = new ArrayList<>();
        for (int i = 0; i < station.getRooms().size(); i++) {
            for (int j = 0; j < station.getRooms().get(i).getAppliances().size(); j++) {
                if (!resourceList.contains(station.getRooms().get(i).getAppliances().get(j).getId())) {
                    resourceList.add(station.getRooms().get(i).getAppliances().get(j).getId());
                }
            }
        }
        return resourceList;
    }


    public Astronaut selectRandAstronaut() {
        Random rand = new Random();
        int randInt = rand.nextInt(this.astronauts.size());
        return astronauts.get(randInt);
    }

    public Room selectRandRoom() {
        Random rand = new Random();
        int randInt = rand.nextInt(this.rooms.size());
        return rooms.get(randInt);
    }

    public static void saveSpaceStation(String filename, SpaceStation objectToSerialize) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(SerializationFeature.INDENT_OUTPUT);
        mapper.writeValue(new File(filename), objectToSerialize);
    }



}
