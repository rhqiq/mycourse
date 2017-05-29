package com.rhqiq.ucberekelyjavadiscover.seven;

public class Balloon {

    private int maxInflationPressure;
    private int currentPressure;
    private boolean isBroken;

    public Balloon(int maxInflationPressure) {
        this.maxInflationPressure = maxInflationPressure;
        this.currentPressure = 0;
        this.isBroken = false;
    }

    public void inflate(int inputPressure) throws Exception {
        if (!isBroken){
            int res = currentPressure + inputPressure;
            if (res > maxInflationPressure){
                isBroken = true;
                throw new Exception("BOOOM! you had too much pressure on your Balloon!");
            }else if(res < 0){
                currentPressure = 0;
            }else{
                currentPressure = res;
                System.out.println("Your Balloon was inflated!");
            }
        }else{
            System.out.println("Sorry! Your Balloon has broken!");
        }
    }

    public int getCurrentPressure() {
        return currentPressure;
    }


    public int getMaxInflationPressure() {
        return maxInflationPressure;
    }
}
