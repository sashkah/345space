import java.util.ArrayList;
import java.util.Hashtable;

public class SpaceStation {
    ArrayList<User> users;
    ArrayList<Resource> resources;

    public SpaceStation() {
        users = new ArrayList<>();
        resources = new ArrayList<>();
    }

    public SpaceStation(ArrayList<User> usersIn, ArrayList<Resource> resourcesIn){
        users = usersIn;
        resources = resourcesIn;
    }

    public ArrayList<User> getUsers(){
        return users;
    }

    public ArrayList<Resource> getResources(){
        return resources;
    }

    public void addUser(User userToAdd){
        users.add(userToAdd);
    }

    public void addResource(String resourceToAdd, double amountToAdd){
        for(int i = 0; i < resources.size(); i++){
            if(resources.get(i).name.equals(resourceToAdd)){
                resources.get(i).addAmount(amountToAdd);
                return;
            }
        }
    }

    public void addResource(Resource resourceToAdd){
        for(int i = 0; i < resources.size(); i++){
            if(resources.get(i).name.equals(resourceToAdd.name)){
                return;
            }
        }
        resources.add(resourceToAdd);
    }

}
