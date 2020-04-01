import java.util.ArrayList;

public class SpaceStation {
    ArrayList<User> users;
    ArrayList<Resource> resources;

    public SpaceStation(){
        users = new ArrayList<User>();
        resources = new ArrayList<Resource>();

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
