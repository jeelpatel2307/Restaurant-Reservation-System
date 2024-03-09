import java.util.HashMap;
import java.util.Map;

class Table {
    private int capacity;
    private boolean isOccupied;

    public Table(int capacity) {
        this.capacity = capacity;
        this.isOccupied = false;
    }

    public int getCapacity() {
        return capacity;
    }

    public boolean isOccupied() {
        return isOccupied;
    }

    public void setOccupied(boolean occupied) {
        isOccupied = occupied;
    }
}

class ReservationSystem {
    private Map<Integer, Table> tables;

    public ReservationSystem() {
        this.tables = new HashMap<>();
    }

    public void addTable(int tableNumber, int capacity) {
        tables.put(tableNumber, new Table(capacity));
    }

    public boolean makeReservation(int tableNumber, int numberOfPeople) {
        Table table = tables.get(tableNumber);
        if (table != null && !table.isOccupied() && table.getCapacity() >= numberOfPeople) {
            table.setOccupied(true);
            return true;
        }
        return false;
    }

    public void cancelReservation(int tableNumber) {
        Table table = tables.get(tableNumber);
        if (table != null) {
            table.setOccupied(false);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        ReservationSystem reservationSystem = new ReservationSystem();
        reservationSystem.addTable(1, 4);
        reservationSystem.addTable(2, 6);

        System.out.println("Making reservation for table 1 with 3 people: " + reservationSystem.makeReservation(1, 3));
        System.out.println("Making reservation for table 2 with 5 people: " + reservationSystem.makeReservation(2, 5));
        System.out.println("Making reservation for table 1 with 6 people: " + reservationSystem.makeReservation(1, 6));

        reservationSystem.cancelReservation(1);

        System.out.println("Making reservation for table 1 with 6 people: " + reservationSystem.makeReservation(1, 6));
    }
}
