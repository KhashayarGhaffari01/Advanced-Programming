package database;

import model.Date;

public class DateManager extends BaseManager<Date, Integer> {
    private static DateManager dateManager;

    public static DateManager getInstance() {
        if (dateManager == null) {
            dateManager = new DateManager();
        }
        return dateManager;
    }

    @Override
    protected Class<Date> getEntityClass() {
        return Date.class;
    }
}
