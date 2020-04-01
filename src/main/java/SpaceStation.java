import java.util.ArrayList;

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

    public String toString() {
        String s = "Users: ";
        for (User u : this.users) {
            s += u.getId() + " ";
        }
        s += "\nResources: ";
        for (Resource r : this.resources) {
            s += r.getName() + " " + r.getAmount() + " ";
        }
        return s;
    }

}
