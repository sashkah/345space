public class Environment {
    private SpaceStation localStation;
    private int timeCounter;
    private boolean isRunning;

    public Environment(SpaceStation localStation){
        this.localStation = localStation;
        timeCounter = 1;
        isRunning = true;
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
        for(int i = 0; i < localStation.getResources().size(); i++){ // For each resource
            for(int j = 0; j < localStation.getUsers().size(); j++){ // For each user
                for(int k = 0; k < localStation.getUsers().get(j).getResourceUsage().size(); k++){ // For each resource used by user
                    if(localStation.users.get(j).resourceUsage.get(k).resourceName == localStation.resources.get(i).getName()){ // If the same as current resource
                        if(timeCounter % localStation.users.get(j).resourceUsage.get(k).timeframe == 0){ // If enough time has passed
                            localStation.resources.get(i).setAmount(localStation.users.get(j).resourceUsage.get(k).usagePerTimeframe); // Deplete resource
                        }
                    }
                }
            }
        }
        // This is very ugly code rn, I will make it prettier...
    }
}