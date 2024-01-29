package model;

import javax.persistence.*;

@Entity
public class Date implements Comparable<Date> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    @Column
    int Year;
    @Column
    int Month;
    @Column
    int Day;

    public Date(int year, int month, int day) {
        Year = year;
        Month = month;
        Day = day;
    }

    public Date() {
    }

    int dateToInt() {
        String date = "";
        date += this.Year;
        date += this.Month;
        date += this.Day;
        return Integer.parseInt(date);
    }

    @Override
    public String toString() {
        return "org.openjfx.main.Date{" +
                "Year=" + Year +
                ", Month=" + Month +
                ", Day=" + Day +
                '}';
    }

    @Override
    public int compareTo(Date o) {
        int comparedate = o.dateToInt();
        return this.dateToInt() - comparedate;

    }
}
