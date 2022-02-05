/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package outpatient;

import java.time.LocalDate;

/**
 *
 * @author Samir
 */
public class Appointment {

    private int AppointmentId;
    private String time;
    private LocalDate date;

    public Appointment(String time, LocalDate date){
        this.time = time;
        this.date=date;
        this.AppointmentId= HospitalSystem.appointmentid();
    }

    public Appointment(LocalDate date) {
        this.date = date;
    }

    public int getAppointmentId() {
        return AppointmentId;
    }

    public void setAppointmentId(int AppointmentId) {
        this.AppointmentId = AppointmentId;
    }


    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "there is an Appointment at " + time + ",date :" + date + '\n';
    }
    public String patoString() {
        return "you have an Appointment at " + time + ",date :" + date +" ,Appointment ID :"+ AppointmentId +'\n';
    }
}
