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
public abstract class HospitalSystem {

    public static ArrayList<Patient> patientList = new ArrayList<Patient>();
    public static ArrayList<Specialization> SpecializationList = new ArrayList<Specialization>();
    public static ArrayList<Admin> AdminList = new ArrayList<Admin>();
    public static int dr_ID = 0;
    public static int appintment_id = 0;

    public static int adddoctorid() {
        dr_ID++;
        return dr_ID;
    }

    public static int appointmentid() {
        appintment_id++;
        return appintment_id;
    }

    public static boolean palogin(String x, String y) {
        for (Patient k : patientList) {
            if (k.getEmail().equals(x)) {
                if (k.getPassword().equals(y)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static Patient pasearch(String x, String y) {
        for (Patient k : patientList) {
            if (k.getEmail().equals(x)) {
                if (k.getPassword().equals(y)) {
                    return k;
                }
            }
        }
        return null;
    }

    public static boolean adminlogin(String x, String y) {
        for (Admin k : AdminList) {
            if (k.getEmail().equals(x)) {
                if (k.getPassword().equals(y)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static Admin adminsearch(String x, String y) {
        for (Admin k : AdminList) {
            if (k.getEmail().equals(x)) {
                if (k.getPassword().equals(y)) {
                    return k;
                }
            }
        }
        return null;
    }

    public static boolean doctorLogin(String x, String y) {
        if(SpecializationList.isEmpty()){
            return false;
        }else {
        for (Specialization i : SpecializationList) {
                return i.Searchdoctoremail(x, y); 
        }
    }
        return false;
    }
    public static Doctor doctorsearch(String x, String y) {
        for (Specialization i : SpecializationList) { 
         return  i.getSearchdoctor(x, y);    
        }
        return null;
    }
        

    public static void addPatient(Patient y) {
        patientList.add(y);
    }

    public static void addSpecilization(Specialization x) {
        SpecializationList.add(x);
    }

    public static void addAdmin(Admin x) {
        AdminList.add(x);
    }

    public static Admin seachAdmin(String name) {
        for (Admin i : AdminList) {
            if (i.getName().equals(name)) {
                return i;
            }
        }
        return null;
    }

    public static void removeAdmin(String adminname) {
        AdminList.remove(seachAdmin(adminname));
    }

    public static Specialization seachSpecilization(String name) {
        for (Specialization i : SpecializationList) {
            if (i.getSpecializationname().equals(name)) {
                return i;
            }
        }
        return null;
    }

    public static void removeSpecilization(String Specilizationname) {
        SpecializationList.remove(seachSpecilization(Specilizationname));
    }

    public static Specialization searchforadoctor(int drid) {
        for (Specialization i : SpecializationList) {
            if (i.Searchdoctorid(drid) == null) {
            } else {
                return i;
            }
        }
        return null;
    }

    public static Doctor searchforappintment(int appid) {
        for (Specialization i : SpecializationList) {
            for (Doctor r : i.viewDoctorlist()) {
                for (Appointment x : r.getDrappointment()) {
                    if (x.getAppointmentId() == appid) {
                        return r;
                    }
                }
            }
        }
        return null;
    }

    public static Patient searchappointement(int appid) {
        for (Patient h : patientList) {
            for (Appointment l : h.getPaappoinement()) {
                if (l.getAppointmentId() == appid) {
                    return h;
                }
            }
        }
        return null;
    }

    public static Doctor searchDoctorname(String drname) {
        for (Specialization i : SpecializationList) {
            for (Doctor r : i.viewDoctorlist()) {
                if (r.getName().equals(drname)) {
                    return r;
                }
            }
        }
        return null;
    }
}
