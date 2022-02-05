/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package outpatient;

import java.util.ArrayList;

/**
 *
 * @author Samir
 */
public class Specialization {

    private ArrayList <Doctor> doctorlist = new ArrayList<Doctor>();

    private String Specializationname;
    

    public Specialization(String Specializationname) {
        this.Specializationname = Specializationname;
    }
    

    public Specialization() {
    }

    public ArrayList<Doctor> viewDoctorlist() {
        return doctorlist;
    }

    public String getSpecializationname() {
        return Specializationname;
    }

    public void setSpecializationname(String Specializationname) {
        this.Specializationname = Specializationname;
    }

    public void addDoctor(Doctor x) {
       doctorlist.add(x);
    }
    
    public Doctor Searchdoctorid(int doctorid){
        for (Doctor i : doctorlist) {
        if (i.getID()==doctorid ) {
            return i;
        }
       }
    return null;
    }
        public boolean Searchdoctoremail (String doctoremail, String Password){
        if(doctorlist.isEmpty()){
            return false;
        }else {
        for (Doctor g : doctorlist) {
        if ((g.getEmail().equals(doctoremail)) && (g.getPassword().equals(Password))) {
            return true;
        }
       }
    return false;
    }
        }
      public Doctor getSearchdoctor (String doctoremail, String Password){
        for (Doctor g : doctorlist) {
        if (g.getEmail().equals(doctoremail) && g.getPassword().equals(Password)) {
            return g;
        }
       }
    return null;
    }
        
    public String removeDoctor(int doctorid){
    if(Searchdoctorid(doctorid) == null){
     return "your entered id is not found, please,enter a valaid doctor's id ";    
    }else{
       doctorlist.remove(Searchdoctorid(doctorid));
       return "Doctor removed from system sucessfully";
    }
    }
    
    @Override
    public String toString() {
        return   Specializationname ;
    }
   
}
