import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;

public class Form1 extends JFrame {
    private FlightTest flightTest;
    private JTextField flightDataField;
    private DefaultTableModel tableModel;

    public Form1() {
        flightTest = new FlightTest();
        
        setTitle("Flight Information App");
        setSize(900, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        
        JPanel inputPanel = new JPanel(new GridLayout(4, 2, 5, 5));
        
        inputPanel.add(new JLabel("Enter Flight Data (comma-separated):"));
        flightDataField = new JTextField();
        inputPanel.add(flightDataField);

        JButton addButton = new JButton("Add Flight");
        addButton.addActionListener(new AddFlightListener());
        inputPanel.add(addButton);

        JButton showButton = new JButton("Show Flight Info");
        showButton.addActionListener(e -> updateTable(flightTest.getFlights()));
        inputPanel.add(showButton);

        JButton sortButton = new JButton("Sort Flights");
        sortButton.addActionListener(e -> {
            flightTest.sortFlights();
            updateTable(flightTest.getFlights());
        });
        inputPanel.add(sortButton);

        JButton exportButton = new JButton("Export to CSV");
        exportButton.addActionListener(new ExportToCSVListener());
        inputPanel.add(exportButton);
        
        String[] columnNames = {"Airline Name", "Flight Number", "Origin", "Destination", "Airfare", 
                                "Departure Time", "Arrival Time", "Duration"};
        tableModel = new DefaultTableModel(columnNames, 0);
        JTable flightTable = new JTable(tableModel);
        add(new JScrollPane(flightTable), BorderLayout.CENTER);
        add(inputPanel, BorderLayout.NORTH);
    }

    private void updateTable(java.util.List<Flight> flights) {
        tableModel.setRowCount(0);
        for (Flight flight : flights) {
            tableModel.addRow(flight.toArray());
        }
    }

    private class AddFlightListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                String data = flightDataField.getText();
                String[] details = data.split(",");
                
                if (details.length != 8) {
                    JOptionPane.showMessageDialog(null, "Please enter exactly 8 comma-separated values.");
                    return;
                }

                Flight flight = new Flight(details[0].trim(), details[1].trim(), details[2].trim(), 
                                           details[3].trim(), Double.parseDouble(details[4].trim()), 
                                           details[5].trim(), details[6].trim(), Double.parseDouble(details[7].trim()));
                flightTest.addFlight(flight);
                flightDataField.setText("");
                JOptionPane.showMessageDialog(null, "Flight added successfully!");
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Please enter valid numbers for airfare and duration.");
            }
        }
    }
    //BYOD 
    private class ExportToCSVListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try (FileWriter writer = new FileWriter("flights.csv")) {
                writer.write(flightTest.exportFlightsToCSV());
                JOptionPane.showMessageDialog(null, "Flights exported to CSV successfully!");
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, "Error exporting to CSV.");
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Form1().setVisible(true));
    }
}
