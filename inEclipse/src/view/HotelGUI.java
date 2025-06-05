package view;

import java.awt.BorderLayout;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;

import javax.swing.*;
import javax.swing.JFrame;

import BL.BL;
import Model.Guest;
import Model.Hotel;
import Model.Order;
import Model.Person;
import Model.Room;

public class HotelGUI  extends JFrame{
        private BL hotel =new BL();

        public HotelGUI() {
            setTitle("Hotel Management System");
            setSize(500, 400);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            // יצירת כפתורים עבור כל פעולה בתפריט
            JButton btnHotelDetails = new JButton("הדפסת פרטי בית המלון");
            JButton btnAddOrder = new JButton("הוספת הזמנה");
            JButton btnRemoveOrder = new JButton("מחיקת הזמנה");
            JButton btnPrintOrders = new JButton("הדפסת הזמנות");
            JButton btnRoomStatus = new JButton("הדפסת דוח על חדרים");
            JButton btnPrintGuests = new JButton("הדפסת פרטי הלקוחות");

            // יצירת JPanel שמכיל את הכפתורים
            JPanel panel = new JPanel();
            panel.setLayout(new GridLayout(7, 1, 10, 10));
            panel.add(btnHotelDetails);
            panel.add(btnAddOrder);
            panel.add(btnRemoveOrder);
            panel.add(btnPrintOrders);
            panel.add(btnRoomStatus);
            panel.add(btnPrintGuests);
            add(panel, BorderLayout.CENTER);

            // פעולות הכפתורים
            btnHotelDetails.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    showHotelDetails();
                }
            });
            btnAddOrder.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    addOrder();
                }
            });
            btnRemoveOrder.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    removeOrder();
                }
            });
            btnPrintOrders.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    printOrders();
                }
            });
            btnRoomStatus.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    try {
                        //printRoomStatus();
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                }
            });
            btnPrintGuests.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    printGuestDetails();
                }
            });
            // יצירת חדרים
            Room room1 = new Room(1, 1, 1, 1);
            Room room2 = new Room(2, 1, 1, 3);
            Room room3 = new Room(3, 1, 1, 5);
            hotel.getRooms().addRoom(room1);
            hotel.getRooms().addRoom(room2);
            hotel.getRooms().addRoom(room3);

            // יצירת לקוחות
            Guest guest1 = new Guest(new Person("55555555","MIRI", "miriw1045@gmail.com"));
            Guest guest2 =new Guest(new Person("6666666","chani", "cp750905@gmail.com"));
            hotel.getGuests().addGuest(guest1);
            hotel.getGuests().addGuest(guest2);
        }


        // פונקציות שמבצעות את הפעולות השונות
        private void showHotelDetails() {
            JOptionPane.showMessageDialog(this, hotel.showHotelDetails());
        }
        //הוספת הזמנה
        private void addOrder() {
            String guestId = JOptionPane.showInputDialog(this, "הכנס תעודת זהות של האורח:");
            String name = JOptionPane.showInputDialog(this, "הכנס שם  של האורח:");
            String email = JOptionPane.showInputDialog(this, "הכנס אימייל של האורח:");
            String phone = JOptionPane.showInputDialog(this, "הכנס טלפון של האורח:");
            
            Guest guest;
            if(hotel.getGuests().searchGuestById(guestId)==null)
            {
                 guest = new Guest(new Person(guestId,name,email));
            }

            String levelStr = JOptionPane.showInputDialog(this, "הכנס דרגת חדר (1-5):");
            String floorStr = JOptionPane.showInputDialog(this, "הכנס קומה: ");
            int requestedLevel = Integer.parseInt(levelStr);
            int requestedFloor = Integer.parseInt(floorStr);

            String numDaysStr = JOptionPane.showInputDialog(this, "הכנס מספר ימים בהזמנה:");
            int numDays = Integer.parseInt(numDaysStr);

            Room r=hotel.findRoomByLevel(1);
            hotel.getOrders().addOrder(new Order(guest,r, numDays));
        }
        //מחיקת הזמנה
        private void removeOrder() {
            String guestId = JOptionPane.showInputDialog(this, "הכנס תעודת זהות של האורח למחיקה:");
            Guest guest = hotel.getGuests().searchGuestById(guestId).get(0);

            if (guest != null) {
                hotel.getOrders().delete(guest);
                JOptionPane.showMessageDialog(this, "ההזמנה נמחקה");
            } else {
                JOptionPane.showMessageDialog(this, "אורח לא נמצא");
            }
        }
        //הדפסת הזמנות
        private void printOrders() {
            String[] options = {"הכל", "לפי לקוח", "לפי חדר"};
            String choice = (String) JOptionPane.showInputDialog(this, "בחר את סוג הדוח להדפסה",
                    "הדפסת הזמנות", JOptionPane.QUESTION_MESSAGE, null, options, options[0]);

            StringBuilder report = new StringBuilder();  // StringBuilder לצורך בניית הדוח

            switch (choice) {
                case "הכל":
                    // הדפסת כל ההזמנות
                   // hotel.getOrders().printAllOrders();
                    break;
                case "לפי לקוח":
                    String id = JOptionPane.showInputDialog(this, "הכנס תעודת זהות של האורח:");
                    Guest guest = hotel.getGuests().searchGuestById(id).get(0);
                    if (guest != null) {
                        Order order = hotel.getOrders().findByGuest(guest).get(0);
                        if (order != null) {
                            report.append(order.toString()).append("\n");
                        } else {
                            JOptionPane.showMessageDialog(this, "לא נמצאה הזמנה עבור האורח הזה.");
                            return;
                        }
                    } else {
                        JOptionPane.showMessageDialog(this, "אורח לא נמצא.");
                        return;
                    }
                    break;

                case "לפי חדר":
                    String roomNumStr = JOptionPane.showInputDialog(this, "הכנס מספר חדר:");
                    int roomNum = Integer.parseInt(roomNumStr);
                  //  Room room = hotel.getRooms().searchRoomByNumber(roomNum);
//                    if (room != null) {
//                        hotel.getListOrder().printOrdersByRoom(room);
//                    } else {
                        JOptionPane.showMessageDialog(this, "חדר לא נמצא");
                   // }
                    break;
            }

        }
        //הדפסת דוח חדרים
//        private void printRoomStatus() throws IOException {
//            int activeRooms = hotel.getRooms().getActiveRooms().size(); // חדרים תפוסים
//            int inactiveRooms = hotel.getListRoom().getInactiveRooms().size(); // חדרים פנויים
//            JOptionPane.showMessageDialog(this, "תפוסים: " + activeRooms + "\nפנויים: " + inactiveRooms);
//            hotel.getListRoom().exportActiveRoomsToFile("ActiveRooms.txt");
//            hotel.getListRoom().exportInactiveRoomsToFile("InActiveRooms.txt");
//
//        }
        //הדפסת פרטי הלקוחות
        private void printGuestDetails() {
           // hotel.getGuests().printAllGuests();
        }
        //הפקת דוח דוגמא
//      private void generateReportGust () {
//            hotel.getListGuest().getActiveGuests().forEach(System.out::println);
//            try {
//                hotel.getListGuest().exportActiveGuestsToFile();
//                System.out.println("הקובץ ActiveGuestsReport.txt נוצר בהצלחה!");
//            } catch (IOException e) {
//                System.out.println("אירעה שגיאה ביצירת הקובץ: " + e.getMessage());
//            }
//        }
public static void main (String[]args){
            HotelGUI gui = new HotelGUI();
            gui.setVisible(true);
        }
        
    }


