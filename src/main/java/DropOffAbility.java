import java.util.UUID;

public interface DropOffAbility {
    UUID dropOff(Car myCar) throws NoAvailableLotException;
}
