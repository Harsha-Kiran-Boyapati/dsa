package lld.parkingLot.v1.models;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Ticket {
    private Slot slot;
    private String registrationNumber;
    private String color;
}
