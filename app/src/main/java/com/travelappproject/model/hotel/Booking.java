package com.travelappproject.model.hotel;

import java.io.Serializable;
import java.util.Date;

public class Booking implements Serializable {
    private String idBooking;
    private String hotelName;
    private String nameRoom;
    private long price;
    private Date date;
    private long idHotel;
    private long idRoom;
    private String addressHotel;
    private String dateCheckIn, dateCheckOut, choice;
    private String timeCheckIn, timeCheckOut;
    private long daysdiff,startDate,endDate;

    public String getChoice() {
        return choice;
    }

    public void setChoice(String choice) {
        this.choice = choice;
    }

    public long getStartDate() {
        return startDate;
    }

    public void setStartDate(long startDate) {
        this.startDate = startDate;
    }

    public long getEndDate() {
        return endDate;
    }

    public void setEndDate(long endDate) {
        this.endDate = endDate;
    }

    public long getDaysdiff() {
        return daysdiff;
    }

    public void setDaysdiff(long daysdiff) {
        this.daysdiff = daysdiff;
    }

    public String getDateCheckIn() {
        return dateCheckIn;
    }

    public void setDateCheckIn(String dateCheckIn) {
        this.dateCheckIn = dateCheckIn;
    }

    public String getDateCheckOut() {
        return dateCheckOut;
    }

    public void setDateCheckOut(String dateCheckOut) {
        this.dateCheckOut = dateCheckOut;
    }

    public String getTimeCheckIn() {
        return timeCheckIn;
    }

    public void setTimeCheckIn(String timeCheckIn) {
        this.timeCheckIn = timeCheckIn;
    }

    public String getTimeCheckOut() {
        return timeCheckOut;
    }

    public void setTimeCheckOut(String timeCheckOut) {
        this.timeCheckOut = timeCheckOut;
    }

    public String getAddressHotel() {
        return addressHotel;
    }

    public void setAddressHotel(String addressHotel) {
        this.addressHotel = addressHotel;
    }

    public long getIdHotel() {
        return idHotel;
    }

    public void setIdHotel(long idHotel) {
        this.idHotel = idHotel;
    }

    public long getIdRoom() {
        return idRoom;
    }

    public void setIdRoom(long idRoom) {
        this.idRoom = idRoom;
    }

    public String getIdBooking() {
        return idBooking;
    }

    public void setIdBooking(String idBooking) {
        this.idBooking = idBooking;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public String getNameRoom() {
        return nameRoom;
    }

    public void setNameRoom(String roomName) {
        this.nameRoom = roomName;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Booking() {
    }
}

