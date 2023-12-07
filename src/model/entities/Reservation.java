package model.entities;
import model.exceptions.DomainException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;


public class Reservation {
    private Integer roomNumber;
    private Date checkIn;
    private Date checkOut;

    private final static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
    public Reservation(Integer roomNumber, Date checkIn, Date checkOut) throws DomainException {
        if(!checkOut.after(checkIn)) {
            throw new DomainException("Error in reservation: Check-out date must be after check-in date!!");
        }
        this.roomNumber = roomNumber;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
    }

    public Integer getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(Integer roomNumber) {
        this.roomNumber = roomNumber;
    }

    public Date getCheckIn() {
        return checkIn;
    }

    public Date getCheckOut() {
        return checkOut;
    }

    public long duration() {
        // Pegando a data de entrada menos a data de saida.
        long diff = checkOut.getTime() - checkIn.getTime();
        
        return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
    }

    public void updateDates(Date checkIn, Date checkOut) throws DomainException {
        Date now = new Date();

        if(checkIn.before(now) || checkOut.before(now)) {
            throw new DomainException("Reservation dater for updates must be future dates");
        }
        if(!checkOut.after(checkIn)) {
            throw new DomainException("Error in reservation: Check-out date must be after check-in date!!");
        }

        this.checkIn = checkIn;
        this.checkOut = checkOut;

    }

    @Override
    public String toString() {
        return "Room "
                + roomNumber
                + ", check-in: "
                + simpleDateFormat.format(checkIn)
                + ", check-out: "
                + simpleDateFormat.format(checkOut)
                + ", "
                + duration()
                + " nights";
    }

}
