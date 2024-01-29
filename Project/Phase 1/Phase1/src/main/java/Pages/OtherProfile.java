package Pages;

import com.google.gson.Gson;
import main.Action;
import main.Color;
import main.User;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class OtherProfile {
    static void run(User user1, User user2) throws IOException {
        Scanner sc = new Scanner(System.in);
        if (user1.getFollowers().contains(user2.getID())) {
            if (!user2.getBlocks().contains(user1.getID())) {
                System.out.println(Color.YELLOW_BOLD + user1.getFirstName() + " " + user1.getLastName() + Color.RESET);
                System.out.println(Color.YELLOW_BOLD + "@" + user1.getID());
                System.out.println(User.LastOnline(user1, user2));
                System.out.println(Color.BLUE + "Following");
                if (user2.getFollowers().contains(user1.getID())) {
                    System.out.println("Follows you");
                }
                System.out.println("1-Message");
                System.out.println("2-" + Color.RED_BOLD + "Block " + Color.RESET + user1.getID());
                System.out.println("3-Report " + user1.getID());
                System.out.println("4-Unfollow");
                System.out.println("5-Main menu");
                String Ans = sc.next();
                if (Ans.equals("1")) {
                    Telegram.run(user2);
                }
                if (Ans.equals("2")) {
                    Action.block(user2, user1);
                    run(user1, user2);
                }
                if (Ans.equals("3")) {
                    System.out.println("You Reported " + user1.getID() + " successfully.");
                    run(user1, user2);
                }
                if (Ans.equals("4")) {
                    Action.unfollow(user2, user1);
                    run(user1, user2);
                }
                if (Ans.equals("5")) {
                    MainMenu.run(user2);
                }
                if (!Ans.equals("1") && !Ans.equals("2") && !Ans.equals("3") && !Ans.equals("4") && !Ans.equals("5")) {
                    System.out.println("Invalid request!");
                    run(user1, user2);
                }
            } else {
                System.out.println(Color.YELLOW_BOLD + user1.getFirstName() + " " + user1.getLastName() + Color.RESET);
                System.out.println(Color.YELLOW_BOLD + "@" + user1.getID());
                System.out.println(User.LastOnline(user1, user2));
                System.out.println(Color.BLUE + "Following");
                System.out.println("1-Message");
                System.out.println("2-" + Color.RED_BOLD + "UnBlock " + Color.RESET + user1.getID());
                System.out.println("3-Report " + user1.getID());
                System.out.println("4-Unfollow");
                System.out.println("5-Main menu");
                String Ans = sc.next();
                if (Ans.equals("1")) {
                    Telegram.run(user2);
                }
                if (Ans.equals("2")) {
                    Action.unblock(user2, user1);
                    run(user1, user2);
                }
                if (Ans.equals("3")) {
                    System.out.println("You Reported " + user1.getID() + " successfully.");
                    run(user1, user2);
                }
                if (Ans.equals("4")) {
                    Action.unfollow(user2, user1);
                    run(user1, user2);
                }
                if (Ans.equals("5")) {
                    MainMenu.run(user2);
                }
                if (!Ans.equals("1") && !Ans.equals("2") && !Ans.equals("3") && !Ans.equals("4") && !Ans.equals("5")) {
                    System.out.println("Invalid request!");
                    run(user1, user2);
                }

            }
        } else {
            if (user1.isPublic()) {
                if (!user2.getBlocks().contains(user1.getID())) {
                    System.out.println(Color.YELLOW_BOLD + user1.getFirstName() + " " + user1.getLastName() + Color.RESET);
                    System.out.println(Color.YELLOW_BOLD + "@" + user1.getID());
                    System.out.println(user1.getLastOnline());
                    System.out.println(Color.BLUE + "Follow");
                    System.out.println("1-Message");
                    System.out.println("2-" + Color.RED_BOLD + "Block " + Color.RESET + user1.getID());
                    System.out.println("3-Report " + user1.getID());
                    System.out.println("4-Follow");
                    System.out.println("5-Main menu");
                    String Ans = sc.next();
                    if (Ans.equals("1")) {
                        System.out.println("You should follow this account first.");
                        run(user1, user2);
                    }
                    if (Ans.equals("2")) {
                        Action.block(user2, user1);
                        run(user1, user2);
                    }
                    if (Ans.equals("3")) {
                        System.out.println("You Reported " + user1.getID() + " successfully.");
                        run(user1, user2);
                    }
                    if (Ans.equals("4")) {
                        Action.follow(user2, user1);
                        run(user1, user2);
                    }
                    if (Ans.equals("5")) {
                        MainMenu.run(user2);
                    }
                    if (!Ans.equals("1") && !Ans.equals("2") && !Ans.equals("3") && !Ans.equals("4") && !Ans.equals("5")) {
                        System.out.println("Invalid request!");
                        run(user1, user2);
                    }
                } else {
                    System.out.println(Color.YELLOW_BOLD + user1.getFirstName() + " " + user1.getLastName() + Color.RESET);
                    System.out.println(Color.YELLOW_BOLD + "@" + user1.getID());
                    System.out.println(user1.getLastOnline());
                    System.out.println(Color.BLUE + "Follow");
                    System.out.println("1-Message");
                    System.out.println("2-" + Color.RED_BOLD + "UnBlock " + Color.RESET + user1.getID());
                    System.out.println("3-Report " + user1.getID());
                    System.out.println("4-Follow");
                    System.out.println("5-Main menu");
                    String Ans = sc.next();
                    if (Ans.equals("1")) {
                        System.out.println("You should follow this account first.");
                        run(user1, user2);
                    }
                    if (Ans.equals("2")) {
                        Action.unblock(user2, user1);
                        run(user1, user2);
                    }
                    if (Ans.equals("3")) {
                        System.out.println("You Reported " + user1.getID() + " successfully.");
                        run(user1, user2);
                    }
                    if (Ans.equals("4")) {
                        Action.follow(user2, user1);
                        run(user1, user2);
                    }
                    if (Ans.equals("5")) {
                        MainMenu.run(user2);
                    }
                    if (!Ans.equals("1") && !Ans.equals("2") && !Ans.equals("3") && !Ans.equals("4") && !Ans.equals("5")) {
                        System.out.println("Invalid request!");
                        run(user1, user2);
                    }

                }
            } else {
                if (!user1.getRequests().contains(user2.getID())) {
                    if (!user2.getBlocks().contains(user1.getID())) {
                        System.out.println(Color.YELLOW_BOLD + user1.getFirstName() + " " + user1.getLastName() + Color.RESET);
                        System.out.println(Color.YELLOW_BOLD + "@" + user1.getID());
                        System.out.println(user1.getLastOnline());
                        System.out.println(Color.BLUE + "Follow");
                        System.out.println("1-Message");
                        System.out.println("2-" + Color.RED_BOLD + "Block " + Color.RESET + user1.getID());
                        System.out.println("3-Report " + user1.getID());
                        System.out.println("4-Request to Follow");
                        System.out.println("5-Main menu");
                        String Ans = sc.next();
                        if (Ans.equals("1")) {
                            System.out.println("You should follow this account first.");
                            run(user1, user2);
                        }
                        if (Ans.equals("2")) {
                            Action.block(user2, user1);
                            run(user1, user2);
                        }
                        if (Ans.equals("3")) {
                            System.out.println("You Reported " + user1.getID() + " successfully.");
                            run(user1, user2);
                        }
                        if (Ans.equals("4")) {
                            Action.followRequest(user2, user1);
                            run(user1, user2);
                        }
                        if (Ans.equals("5")) {
                            MainMenu.run(user2);
                        }
                        if (!Ans.equals("1") && !Ans.equals("2") && !Ans.equals("3") && !Ans.equals("4") && !Ans.equals("5")) {
                            System.out.println("Invalid request!");
                            run(user1, user2);
                        }

                    } else {
                        System.out.println(Color.YELLOW_BOLD + user1.getFirstName() + " " + user1.getLastName() + Color.RESET);
                        System.out.println(Color.YELLOW_BOLD + "@" + user1.getID());
                        System.out.println(user1.getLastOnline());
                        System.out.println(Color.BLUE + "Follow");
                        System.out.println("1-Message");
                        System.out.println("2-" + Color.RED_BOLD + "UnBlock " + Color.RESET + user1.getID());
                        System.out.println("3-Report " + user1.getID());
                        System.out.println("4-Request to Follow");
                        System.out.println("5-Main menu");
                        String Ans = sc.next();
                        if (Ans.equals("1")) {
                            System.out.println("You should follow this account first.");
                            run(user1, user2);
                        }
                        if (Ans.equals("2")) {
                            Action.unblock(user2, user1);
                            run(user1, user2);
                        }
                        if (Ans.equals("3")) {
                            System.out.println("You Reported " + user1.getID() + " successfully.");
                            run(user1, user2);
                        }
                        if (Ans.equals("4")) {
                            Action.followRequest(user2, user1);
                            run(user1, user2);
                        }
                        if (Ans.equals("5")) {
                            MainMenu.run(user2);
                        }
                        if (!Ans.equals("1") && !Ans.equals("2") && !Ans.equals("3") && !Ans.equals("4") && !Ans.equals("5")) {
                            System.out.println("Invalid request!");
                            run(user1, user2);
                        }

                    }

                } else {
                    if (!user2.getBlocks().contains(user1.getID())) {
                        System.out.println(Color.YELLOW_BOLD + user1.getFirstName() + " " + user1.getLastName() + Color.RESET);
                        System.out.println(Color.YELLOW_BOLD + "@" + user1.getID());
                        System.out.println(user1.getLastOnline());
                        System.out.println(Color.BLUE + "Requested");
                        System.out.println("1-Message");
                        System.out.println("2-" + Color.RED_BOLD + "Block " + Color.RESET + user1.getID());
                        System.out.println("3-Report " + user1.getID());
                        System.out.println("4-UnRequest to Follow");
                        System.out.println("5-Main menu");
                        String Ans = sc.next();
                        if (Ans.equals("1")) {
                            System.out.println("You should follow this account first.");
                            run(user1, user2);
                        }
                        if (Ans.equals("2")) {
                            Action.block(user2, user1);
                            run(user1, user2);
                        }
                        if (Ans.equals("3")) {
                            System.out.println("You Reported " + user1.getID() + " successfully.");
                            run(user1, user2);
                        }
                        if (Ans.equals("4")) {
                            Action.unfollowRequest(user2, user1);
                            run(user1, user2);
                        }
                        if (Ans.equals("5")) {
                            MainMenu.run(user2);
                        }
                        if (!Ans.equals("1") && !Ans.equals("2") && !Ans.equals("3") && !Ans.equals("4") && !Ans.equals("5")) {
                            System.out.println("Invalid request!");
                            run(user1, user2);
                        }

                    } else {
                        System.out.println(Color.YELLOW_BOLD + user1.getFirstName() + " " + user1.getLastName() + Color.RESET);
                        System.out.println(Color.YELLOW_BOLD + "@" + user1.getID());
                        System.out.println(user1.getLastOnline());
                        System.out.println(Color.BLUE + "Requested");
                        System.out.println("1-Message");
                        System.out.println("2-" + Color.RED_BOLD + "UnBlock " + Color.RESET + user1.getID());
                        System.out.println("3-Report " + user1.getID());
                        System.out.println("4-UnRequest to Follow");
                        System.out.println("5-Main menu");
                        String Ans = sc.next();
                        if (Ans.equals("1")) {
                            System.out.println("You should follow this account first.");
                            run(user1, user2);
                        }
                        if (Ans.equals("2")) {
                            Action.unblock(user2, user1);
                            run(user1, user2);
                        }
                        if (Ans.equals("3")) {
                            System.out.println("You Reported " + user1.getID() + " successfully.");
                            run(user1, user2);
                        }
                        if (Ans.equals("4")) {
                            Action.unfollowRequest(user2, user1);
                            run(user1, user2);
                        }
                        if (Ans.equals("5")) {
                            MainMenu.run(user2);
                        }
                        if (!Ans.equals("1") && !Ans.equals("2") && !Ans.equals("3") && !Ans.equals("4") && !Ans.equals("5")) {
                            System.out.println("Invalid request!");
                            run(user1, user2);
                        }

                    }

                }
            }
        }
    }
}
