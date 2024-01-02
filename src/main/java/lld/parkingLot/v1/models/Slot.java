//package lld.parkingLot.v1.models;
//
//import lombok.Builder;
//import lombok.Getter;
//import lombok.Setter;
//
//@Getter
//@Builder
//public class Slot {
//    @Getter
//    private boolean occupied;
//    private int id;
//    private Floor floor;
//    private VehicleType type = VehicleType.BIKE;
//
//    public Slot(Floor _floor){this.floor = _floor;}
//    public Slot(Floor _floor, VehicleType _type){this.floor = _floor; this.type = _type;}
//
//    public void park(){
//        this.occupied = true;
//    }
//    public void unpark(){
//        this.occupied = false;
//    }
//
//
//}
