package com.rhqiq.assignment;

interface Domestic { }
interface Import { }
interface Japanese extends Import { }
interface German extends Import { }
interface Detroit extends Domestic { }
interface SpringHill extends Domestic { }

interface Vehicle {
    int getWeightInPounds( );
}
interface Automobile extends Vehicle { }
interface LargeAutomobile extends Vehicle { }
interface Sedan extends Automobile { }
interface Van extends LargeAutomobile { }
interface Truck extends LargeAutomobile { }
interface Compact extends Automobile { }
interface SportsUtilityVehicle extends Truck, Van { }

class GenericAuto implements LargeAutomobile, Automobile{
    public int getWeightInPounds(){
        if (this instanceof Automobile){
            return 1000;
        }else{
            return 2500;
        }
    }
}

class SaturnSL1 extends GenericAuto implements SpringHill, Sedan { }
class HondaCivic extends GenericAuto implements Japanese, Compact { }
class MercedesC230 extends GenericAuto implements German, Sedan { }
class ChevyS10 extends GenericAuto implements Detroit, Truck { }
class SubaruOutback extends GenericAuto implements Japanese, SportsUtilityVehicle { }

public class InheritanceTest {

    public static void main(String[] args) {
        SaturnSL1 sl = new SaturnSL1();
        HondaCivic hc = new HondaCivic();
        Japanese jp = null;
        German gr = new MercedesC230();
        ChevyS10 cs = null;
        SubaruOutback sb = new SubaruOutback();
        Domestic dm = sl;
        dm = null;
        dm = null;
        dm = cs;
        dm = (Domestic) cs;
        Import im = sb;
        gr = null;
        gr = null;
        jp = null;
        jp = null;
        jp = (Japanese) im;
        Automobile a = null;
        a = hc;

        ParkingGarage parking = new ParkingGarage();
        for (int i = 0; i < 6; i++){
            parking.addVeicle(new SaturnSL1());
            parking.addVeicle(new HondaCivic());
            parking.addVeicle(new MercedesC230());
            parking.addVeicle(new ChevyS10());
            parking.addVeicle(new SubaruOutback());
        }
    }

}

class ParkingGarage {
    private int vehicleCap;
    private int totalWeightCap;

    ParkingGarage(){
        vehicleCap = 0;
        totalWeightCap = 0;
    }

    public void addVeicle(Vehicle v){
        if (vehicleCap == 20){
            System.out.println("There is no space in the parking!");
        }else{
            int vWeight = v.getWeightInPounds();
            if ((totalWeightCap + vWeight) > 25000){
                System.out.println("There is no space in the parking!");
            }else{
                totalWeightCap += vWeight;
                vehicleCap ++;
                System.out.println("Vehicle successfully parked!");
            }
        }
    }
}
