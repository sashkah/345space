import java.io.IOException;

public class Environment {
    SpaceStation localStation;
    int timeCounter;
    boolean isRunning;

    public Environment(SpaceStation localStation){
        this.localStation = localStation;
        timeCounter = 1;
        isRunning = true;
    }

    public void runLoop(int numHours) throws InterruptedException{
        while(isRunning){
            System.out.println("\n");
            System.out.println("Time: " + timeCounter);
            for(int i = 0; i < localStation.resources.size(); i++){
                System.out.println(localStation.resources.get(i).name + ": " +  localStation.resources.get(i).amount);
            }
            System.out.println("\n");

            if(timeCounter % numHours == 0){
                isRunning = false;
            }
            nextStep();
            Thread.sleep(200);
        }
    }

    private void nextStep(){
        timeCounter ++;
        for(int i = 0; i < localStation.resources.size(); i++){ // For each resource
            for(int j = 0; j < localStation.users.size(); j++){ // For each user
                for(int k = 0; k < localStation.users.get(j).resourceUsage.size(); k++){ // For each resource used by user
                    if(localStation.users.get(j).resourceUsage.get(k).resourceName == localStation.resources.get(i).getName()){ // If the same as current resource
                        if(timeCounter % localStation.users.get(j).resourceUsage.get(k).timeframe == 0){ // If enough time has passed
                            localStation.resources.get(i).amount -= localStation.users.get(j).resourceUsage.get(k).usagePerTimeframe; // Deplete resource
                        }
                    }
                }
            }
        }
        // This is very ugly code rn, I will make it prettier...
    }
}
