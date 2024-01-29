package main;

public class Date implements Comparable<Date>{
    int Year;
    int Month;
    int Day;

    public Date(int year, int month, int day) {
        Year = year;
        Month = month;
        Day = day;
    }
    int dateToInt(){
        String date = "";
        date += this.Year;
        date += this.Month;
        date += this.Day;
        return Integer.parseInt(date);
    }

    @Override
    public String toString() {
        return "main.Date{" +
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
