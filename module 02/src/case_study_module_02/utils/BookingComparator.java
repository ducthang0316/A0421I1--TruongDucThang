package case_study_module_02.utils;

import case_study_module_02.models.Booking;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;


public class BookingComparator implements Serializable, Comparator<Booking>{
    @Override
    public int compare(Booking o1, Booking o2) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate startDate1 = LocalDate.parse(o1.getStartDate(),formatter);
        LocalDate endDate1 = LocalDate.parse(o1.getEndDate(),formatter);
        LocalDate startDate2 = LocalDate.parse(o2.getStartDate(),formatter);
        LocalDate endDate2 = LocalDate.parse(o2.getEndDate(),formatter);

        if (startDate1.compareTo(startDate2) > 0){
            return 1;
        } else if (startDate1.compareTo(startDate2)< 0){
            return -1;
        } else {
            if (endDate1.compareTo(endDate2)> 0){
                return 1;
            } else if (endDate1.compareTo(endDate2)< 0){
                return -1;
            } else return 0;
        }
    }
}
