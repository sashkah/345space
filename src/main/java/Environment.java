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
            ArrayList<Resource> cargo = new ArrayList<Resource>();
            for(int i = 0; i < localStation.getResources().size(); i++){
                outerloop:
                if(localStation.getResources().get(i).getAmount() <= 300){
                    for(int j = 0; j < cargoInTransit.size(); j++){
                        for(int k = 0; k < cargoInTransit.get(j).getCargo().size(); k++){
                            if(cargoInTransit.get(j).getCargo().get(k).getName() == localStation.getResources().get(i).getName()){
                                break outerloop;
                            }
                        }
                    }
                    cargo.add(new Resource(localStation.getResources().get(i).getName(), 300));
                }
            }
            if(cargo.size() != 0){
                Payload newPayload = new Payload(timeCounter, 10, cargo);
                cargoInTransit.add(newPayload);
            }
            if(timeCounter % numHours == 0){
                isRunning = false;
            }
            if(timeCounter % 2 == 0){
                System.out.println(randomEvent());
            }
            nextStep();
            Thread.sleep(sleepTime);
        }
    }

    private void nextStep(){
        timeCounter ++;
        //Resource depletion by users
        for(int i = 0; i < localStation.getResources().size(); i++){ // For each resource
            for(int j = 0; j < localStation.getAstronauts().size(); j++){ // For each user
                for(int k = 0; k < localStation.getAstronauts().get(j).getResourceUsages().size(); k++){ // For each resource used by user
                    if(localStation.getAstronauts().get(j).getResourceUsages().get(k).getResourceName().equals(localStation.getResources().get(i).getName())){ // If the same as current resource
                        if(timeCounter % localStation.getAstronauts().get(j).getResourceUsages().get(k).getTimeframe() == 0){ // If enough time has passed
                            localStation.getResources().get(i).depleteAmount(localStation.getAstronauts().get(j).getResourceUsages().get(k).getUsagePerTimeframe()); // Deplete resource
                        }
                    }
                }
            }
        }
        //Resource depletion by appliances
        for(int i = 0; i < localStation.getRooms().size(); i++){
            for(int j = 0; j < localStation.getRooms().get(i).getAppliances().size(); j++){
                if(localStation.getRooms().get(i).getAppliances().get(j).getInUse()){
                    for (int k = 0; k < localStation.getRooms().get(i).getAppliances().get(j).getResourceUsages().size(); k++) {
                        for(int l = 0; l < localStation.getResources().size(); l++){
                            if(localStation.getRooms().get(i).getAppliances().get(j).getResourceUsages().get(k).getResourceName() == localStation.getResources().get(l).getName()){
                                if(timeCounter % localStation.getRooms().get(i).getAppliances().get(j).getResourceUsages().get(k).getTimeframe() == 0) {
                                    localStation.getResources().get(l).depleteAmount(localStation.getRooms().get(i).getAppliances().get(j).getResourceUsages().get(k).getUsagePerTimeframe());
                                }
                            }
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
                System.out.println("Earth station sent a payload!");
                cargoInTransit.remove(cargoInTransit.get(i));
                i--;
            }
        }
    }

    public String randomEvent() {
        Astronaut eventAstronaut = localStation.selectRandAstronaut();
        Room eventRoom = localStation.selectRandRoom();
        String s = "";

        if(eventAstronaut.getCurrentRoom() == null || eventAstronaut.getCurrentRoom() != eventRoom) {
            eventAstronaut.changeRoom(eventRoom);
            s += eventAstronaut.getId() + " moved to " + eventRoom.getName() + " ";
            Appliance eventAppliance = eventRoom.selectRandAppliance();
            if(eventAppliance.getInUse() == false && (eventAstronaut.getCurrentAppliance() == null || eventAstronaut.getCurrentAppliance() != eventAppliance)) {
                eventAstronaut.useAppliance(eventAppliance);
                s += "and started using " + eventAppliance.getId() + ".";
            }
        }
        else {
            Appliance eventAppliance = eventRoom.selectRandAppliance();
            if(eventAstronaut.getCurrentAppliance() == null || eventAstronaut.getCurrentAppliance() != eventAppliance) {
                eventAstronaut.useAppliance(eventAppliance);
                s += eventAstronaut.getId() + " started using " + eventAppliance.getId() + ".";
            }
            else {
                s += eventAstronaut.getId() + " stopped using " + eventAstronaut.getCurrentAppliance().getId() + ".";
                eventAstronaut.useAppliance(null);
            }
        }
        return s;
    }

}
