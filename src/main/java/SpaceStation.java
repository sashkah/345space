import java.util.ArrayList;

public class SpaceStation {
    private ArrayList<User> users;
    private ArrayList<Resource> resources;

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

    public void setUsers(ArrayList<User> users) {
        this.users = users;
    }

        public ArrayList<Resource> getResources(){
            return resources;
        }

        public void setResources(ArrayList<Resource> resources) {
            this.resources = resources;
        }

        public void addUser(User userToAdd){
            users.add(userToAdd);
        }

        public void addResource(String resourceToAdd, double amountToAdd){
        Resource resource=new Resource(resourceToAdd,amountToAdd);
        int added=0;
        for(Resource resource1:resources) {
            if (resource1.getName().equalsIgnoreCase(resourceToAdd)) {
                resource1.addAmount(amountToAdd);
                added += 1;
            }
            }

        if(added==0){
            resources.add(resource);
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
