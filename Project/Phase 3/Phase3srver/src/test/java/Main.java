import database.DateManager;
import database.UserManager;
import model.Date;
import model.User;

public class Main {
    public static void main(String[] args) {
        Date date = new Date(1380, 1, 2);
//        DataBase.getInstance().save(date);
        int id = DateManager.getInstance().save(date);
        Date newDate = DateManager.getInstance().fetch(id);
        System.out.println(newDate);
        User user = new User("khashi2");
        user.setPassword("1234");
        user.setFirstName("khashayar");
        user.setBirthday(newDate);
        UserManager.getInstance().save(user);
    }
}
