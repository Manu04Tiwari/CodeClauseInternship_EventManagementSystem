import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class EventManagerUI extends JFrame {
    private JTextField eventNameField, eventDateField, venueField;
    private JTextArea descriptionArea;
    private JButton addButton;

    public EventManagerUI() {
        setTitle("Event Management System");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(5, 2));

        // UI Components
        eventNameField = new JTextField();
        eventDateField = new JTextField();
        venueField = new JTextField();
        descriptionArea = new JTextArea();
        addButton = new JButton("Add Event");

        // Adding components to the frame
        add(new JLabel("Event Name:"));
        add(eventNameField);
        add(new JLabel("Event Date (YYYY-MM-DD):"));
        add(eventDateField);
        add(new JLabel("Venue:"));
        add(venueField);
        add(new JLabel("Description:"));
        add(new JScrollPane(descriptionArea));
        add(new JLabel());
        add(addButton);

        // Button Action Listener
        addButton.addActionListener(e -> addEvent());

        setVisible(true);
    }

    // Method to add event to the database
    private void addEvent() {
        String name = eventNameField.getText();
        String date = eventDateField.getText();
        String venue = venueField.getText();
        String description = descriptionArea.getText();

        try (Connection conn = DatabaseConnection.getConnection()) {
            String query = "INSERT INTO events (event_name, event_date, venue, description) VALUES (?, ?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, name);
            stmt.setString(2, date);
            stmt.setString(3, venue);
            stmt.setString(4, description);
            stmt.executeUpdate();

            JOptionPane.showMessageDialog(this, "Event added successfully!");
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error adding event.");
        }
    }

    public static void main(String[] args) {
        new EventManagerUI();
    }
}
