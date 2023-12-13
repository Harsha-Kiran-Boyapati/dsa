package lld.parkingLot.v1.models;

import lld.parkingLot.v1.models.Floor;
import lld.parkingLot.v1.models.Slot;
import lld.parkingLot.v1.models.VehicleType;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Getter
public class ParkingLot {
    private String name;
    private List<Floor> floors = new ArrayList<>();
    public ParkingLot(String _name){
        this.name = _name;
    }
    public void addFloor(Floor floor){
        floors.add(floor);
        floor.setId(floors.size()+1);
        floor.setParkingLot(this);
    }

    public Floor getFloor(int floorId){
        if(floorId >= floors.size()) return null;
        return floors.get(floorId-1);
    }

    public Optional<Slot> getFirstEmtpySlot(VehicleType type){
        for(Floor floor: floors){
           Optional<Slot> optionalSlot = floor.firstEmptySlot(type);
           if(optionalSlot.isPresent()) return optionalSlot;
        }
        return Optional.empty();
    }
}
