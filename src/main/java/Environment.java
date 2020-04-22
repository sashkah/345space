import java.util.ArrayList;

public class Environment {
    private EarthStation earthStation;
    private SpaceStation localStation;
    private int timeCounter;
    private boolean isRunning;
    private ArrayList<Payload> cargoInTransit;

    public Environment(SpaceStation localStation){
        this.earthStation = null;
        this.localStation = localStation;
        timeCounter = 1;
        isRunning = true;
        cargoInTransit = new ArrayList<Payload>();
    }

    public Environment(SpaceStation localStation, EarthStation earthStation){
        this.earthStation = earthStation;
        this.localStation = localStation;
        timeCounter = 1;
        isRunning = true;
        cargoInTransit = new ArrayList<Payload>();
    }

    public Environment(SpaceStation localStation, EarthStation earthStation, ArrayList<Payload> cargoInTransit){
        this.earthStation = earthStation;
        this.localStation = localStation;
        timeCounter = 1;
        isRunning = true;
        this.cargoInTransit = cargoInTransit;
    }

    public void runLoop(int numHours, int sleepTime, boolean print) throws InterruptedException{
        while(isRunning){
            if(print) {
                System.out.println("\n");
                System.out.println("Time: " + timeCounter);
                for (int i = 0; i < localStation.getResources().size(); i++) {
                    System.out.println(localStation.getResources().get(i).getName() + ": " + localStation.getResources().get(i).getAmount());
                }
                System.out.println("\n");
            }
            if(timeCounter % numHours == 0){
                isRunning = false;
            }
            nextStep();
            Thread.sleep(sleepTime);
        }
    }

    private void nextStep(){
        timeCounter ++;
        //Resource depletion by users
        for(int i = 0; i < localStation.getResources().size(); i++){ // For each resource
            for(int j = 0; j < localStation.getUsers().size(); j++){ // For each user
                for(int k = 0; k < localStation.getUsers().get(j).getResourceUsage().size(); k++){ // For each resource used by user
                    if(localStation.getUsers().get(j).getResourceUsage().get(k).getResourceName().equals(localStation.getResources().get(i).getName())){ // If the same as current resource
                        if(timeCounter % localStation.getUsers().get(j).getResourceUsage().get(k).getTimeframe() == 0){ // If enough time has passed
                            localStation.getResources().get(i).depleteAmount(localStation.getUsers().get(j).getResourceUsage().get(k).getUsagePerTimeframe()); // Deplete resource
                        }
                    }
                }
            }
        }
        //Track on the way resources
        for(int i = 0; i < cargoInTransit.size(); i++){ // for each payload
            if(timeCounter >= cargoInTransit.get(i).getStartTime()+cargoInTransit.get(i).getTripLength()){ // if arrived
                for(int j = 0; j < cargoInTransit.get(i).getCargo().size(); j++){ //for each resource
                    localStation.addResource(cargoInTransit.get(i).getCargo().get(j)); // add resource to station
                }
                cargoInTransit.remove(cargoInTransit.get(i));
                i--;
            }
        }
    }
}
