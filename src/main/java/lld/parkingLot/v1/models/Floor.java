//package lld.parkingLot.v1.models;
//
//import lombok.Builder;
//import lombok.Getter;
//import lombok.Setter;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Optional;
//
//@Getter
//@Builder
//public class Floor {
//    private final  int id;
//    private List<Slot> slots = new ArrayList<>();
//    @Setter
//    private ParkingLot parkingLot;
//    @Setter
//    private Floor floor;
//
//
//    public Optional<Slot> firstEmptySlot(VehicleType type) {
//        return slots.stream().filter(type::canParkIn).findFirst();
//    }
//
//    public int emptySlotCount(VehicleType type) {
//        return (int) slots.stream().filter(type::canParkIn).count();
//    }
//
//    public void addSlot(Slot slot) {
//        int slotId = slots.size()+1;
//        slots.add(slot.builder().floor(this).id(slotId).build());
//    }
//
//    public List<Slot> getSlots(){ return this.slots.stream().toList();}
//
//    public void setId(int i) {
//    }
//}
