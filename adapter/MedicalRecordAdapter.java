package adapter;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * A class to adapt a Health Record into a Medical Record
 * @author Ana Boccanfuso
 */
public class MedicalRecordAdapter implements MedicalRecord {
    private HealthRecord record;


    /**
     * Creates a new Health Record from the parameter
     * @param record Health Record of the patient
     */
    public MedicalRecordAdapter(HealthRecord record) {
        this.record = record;
    }

    /**
     * Gets the first name of the patient
     * @return The first name of the patient in string format
     */
    public String getFirstName() {
        String name = record.getName();
        String[] split = name.split(" ");
        return split[0];
    }

    /**
     * Gets the last name of the patient
     * @return The last name of the patient in string format
     */
    public String getLastName() {
        String name = record.getName();
        String[] split = name.split(" ");
        return split[1];
    }

    /**
     * Gets the patients birthday from the Health Record
     * @return The birthday of the patient
     */
    public Date getBirthday() {
        return record.getBirthdate();
    }

    /**
     * Gets the gender of the patient
     * @return The gender of the patient from the enumeration
     */
    public Gender getGender() {
        String gender = record.getGender().toUpperCase();
        return Gender.valueOf(gender);
    }

    /**
     * Adds a visit to the Health Record
     * @param date The date the patient visited the medical office
     * @param well True if the visit is a well check, false otherwise
     * @param description The description of the visit
     */
    public void addVisit(Date date, boolean well, String description) {
        record.addHistory(date, well, description);
    }

    /**
     * Creates a new Date
     * @param year The Year of the date
     * @param month The month of the date
     * @param day The day of the date
     * @return The formatted date 
     */
    private Date makeDate(int year, int month, int day) {
        Calendar myCalendar = new GregorianCalendar(year, month - 1, day);
        return myCalendar.getTime();
    }

    /**
     * Gets the list of all the patients medical visits
     * in the Health Record
     * @return An ArrayList of patient medical visits
     */
    public ArrayList<Visit> getVisitHistory() {
        ArrayList<String> history = record.getHistory();
        ArrayList<Visit> visits = new ArrayList<Visit>();
        Boolean well = false;
        String desc = "";
        int month, day, year;
        for (String visit : history) {
            String[] line = visit.split("\n");
            String visitLine = line[0];
            String wellLine = line[1];
            String commentLine = line[2];

            String[] visitColon = visitLine.split(": ");
            String[] visitSpace = visitColon[1].split(" ");

            year = Integer.parseInt(visitSpace[3]);
            month = Integer.parseInt(visitSpace[2].substring(0, 1));
            day = Integer.parseInt(visitSpace[1].substring(0, 1));
           
            String[] wellColon = wellLine.split(": ");
            if(wellColon[1].equalsIgnoreCase("true"))
                well = true;
            
            String[] commentColon = commentLine.split(": ");
            desc = commentColon[1];
            visits.add(new Visit(makeDate(year, month, day), well, desc));
        }
        return visits;
    }

    /**
     * A string representation of the patients medical record
     * @return A string representation of the patients medical record
     */
    public String toString() {
        SimpleDateFormat simple = new SimpleDateFormat("MM/dd/yyyy");
        String birthday = simple.format(getBirthday());

        String gender = (getGender().toString().substring(0, 1).toUpperCase() + getGender().toString().substring(1).toLowerCase());

        String result = "***** " + getFirstName() + " " + getLastName() + " *****\n";
        result += "Birthday: " + birthday + "\n";
        result += "Gender: " + gender + "\n";
        result += "Medical Visit History: \n";
        
        if(getVisitHistory().size() == 0) {
            result += "No visits yet";
        } else {
            for(Visit visit : getVisitHistory()) {
                result += visit.toString() + "\n";
            }
        }
        return result;
    }

}
