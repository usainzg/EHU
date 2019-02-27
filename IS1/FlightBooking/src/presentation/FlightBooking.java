package presentation;

import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import businessLogic.FlightManager;
import domain.ConcreteFlight;

public class FlightBooking extends JFrame {

	private static final long serialVersionUID = 1L;
	private JFrame jFrame = this;
	private JPanel jPanelFlights = null;
	private JTextField departingCity = null;
	private JTextField arrivingCity = null;
	private JTextField day = null;
	private JComboBox<String> months = null;
	private JTextField year = null;
	private JRadioButton business = null;
	private JRadioButton first = null;
	private JRadioButton tourist = null;

	private ButtonGroup fareButtonGroup = new ButtonGroup(); // @jve:decl-index=0:
	private JButton lookForFlightsButton = null;
	private JComboBox<ConcreteFlight> flightCombo = null;
	private JButton bookFlightButton = null;

	private DefaultComboBoxModel<String> monthNames = new DefaultComboBoxModel<String>();

	private DefaultComboBoxModel<ConcreteFlight> flightInfo = new DefaultComboBoxModel<ConcreteFlight>();

	private Collection<ConcreteFlight> concreteFlightCollection;

	private FlightManager businessLogic; // @jve:decl-index=0:

	private ConcreteFlight selectedConcreteFlight;

	private JLabel jLabelDepartingCity = new JLabel("Departing city:");
	private JLabel jLabelArrivingCity = new JLabel("Arriving city:");
	private JLabel jLabelYear = new JLabel("Year:");
	private JLabel jLabelFare = new JLabel("Fare:");
	private JLabel jLabelMonth = new JLabel("Month:");
	private JLabel jLabelDay = new JLabel("Day:");;
	private JLabel jLabelResult = new JLabel();

	/**
	 * This is the default constructor
	 */
	public FlightBooking() {
		super();
		initialize();
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {

		this.setSize(457, 361);
		this.setContentPane(getJContentPane());
		this.setTitle("Book flights");
	}

	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJContentPane() {
		if (jPanelFlights == null) {
			jLabelResult.setBounds(new Rectangle(54, 176, 325, 20));
			jLabelResult.setHorizontalAlignment(SwingConstants.CENTER);
			jLabelResult.setHorizontalTextPosition(SwingConstants.CENTER);
			jLabelDay.setBounds(new Rectangle(342, 61, 50, 28));
			jLabelMonth.setBounds(new Rectangle(126, 63, 52, 26));
			jLabelFare.setBounds(new Rectangle(52, 96, 90, 32));
			jLabelYear.setBounds(new Rectangle(7, 63, 111, 28));
			jLabelArrivingCity.setBounds(new Rectangle(7, 33, 138, 25));
			jLabelDepartingCity.setBounds(new Rectangle(6, 10, 137, 22));
			jPanelFlights = new JPanel();
			jPanelFlights.setLayout(null);
			jPanelFlights.add(jLabelDepartingCity, null);
			jPanelFlights.add(getDepartingCity(), null);
			jPanelFlights.add(jLabelArrivingCity, null);
			jPanelFlights.add(getArrivingCity(), null);
			jPanelFlights.add(jLabelYear, null);
			jPanelFlights.add(getYear(), null);
			jPanelFlights.add(getMonth(), null);
			jPanelFlights.add(jLabelMonth, null);
			jPanelFlights.add(getDay(), null);
			jPanelFlights.add(jLabelDay, null);
			jPanelFlights.add(jLabelFare, null);
			jPanelFlights.add(getBusiness(), null);
			jPanelFlights.add(getFirst(), null);
			jPanelFlights.add(getTourist(), null);
			jPanelFlights.add(getLookForFlights(), null);
			jPanelFlights.add(getBookFlight(), null);
			jPanelFlights.add(jLabelResult, null);
			jPanelFlights.add(getFlightList(), null);
		}
		return jPanelFlights;
	}

	/**
	 * This method initializes departingCity
	 * 
	 * @return javax.swing.JTextField
	 */
	private JTextField getDepartingCity() {
		if (departingCity == null) {
			departingCity = new JTextField("Donostia");
			departingCity.setBounds(new Rectangle(143, 9, 294, 24));
		}
		return departingCity;
	}

	/**
	 * This method initializes arrivingCity
	 * 
	 * @return javax.swing.JTextField
	 */
	private JTextField getArrivingCity() {
		if (arrivingCity == null) {
			arrivingCity = new JTextField("Bilbao");
			arrivingCity.setBounds(new Rectangle(142, 33, 294, 27));
		}
		return arrivingCity;
	}

	/**
	 * This method initializes day
	 * 
	 * @return javax.swing.JTextField
	 */
	private JTextField getDay() {
		if (day == null) {
			day = new JTextField();
			day.setBounds(new Rectangle(371, 63, 70, 29));
		}
		return day;
	}

	/**
	 * This method initializes month
	 * 
	 * @return javax.swing.JComboBox
	 */
	private JComboBox<String> getMonth() {
		if (months == null) {
			months = new JComboBox<String>();
			months.setBounds(new Rectangle(170, 64, 165, 28));

			months.setModel(monthNames);
			monthNames.addElement("January");
			monthNames.addElement("February");
			monthNames.addElement("March");
			monthNames.addElement("April");
			monthNames.addElement("May");
			monthNames.addElement("June");
			monthNames.addElement("July");
			monthNames.addElement("August");
			monthNames.addElement("September");
			monthNames.addElement("October");
			monthNames.addElement("November");
			monthNames.addElement("December");

		}
		return months;
	}

	/**
	 * This method initializes year
	 * 
	 * @return javax.swing.JTextField
	 */
	private JTextField getYear() {
		if (year == null) {
			year = new JTextField();
			year.setBounds(new Rectangle(45, 64, 65, 30));
		}
		return year;
	}

	/**
	 * This method initializes business
	 * 
	 * @return javax.swing.JRadioButton
	 */
	private JRadioButton getBusiness() {
		if (business == null) {
			business = new JRadioButton();
			business.setBounds(new Rectangle(88, 93, 90, 36));
			business.setText("Business");
			fareButtonGroup.add(business);
		}
		return business;
	}

	/**
	 * This method initializes first
	 * 
	 * @return javax.swing.JRadioButton
	 */
	private JRadioButton getFirst() {
		if (first == null) {
			first = new JRadioButton();
			first.setBounds(new Rectangle(180, 97, 61, 29));
			first.setText("First");

			fareButtonGroup.add(first);
		}
		return first;
	}

	/**
	 * This method initializes tourist
	 * 
	 * @return javax.swing.JRadioButton
	 */
	private JRadioButton getTourist() {
		if (tourist == null) {
			tourist = new JRadioButton();
			tourist.setBounds(new Rectangle(239, 99, 121, 27));
			tourist.setSelected(true);
			tourist.setText("Tourist");
			fareButtonGroup.add(tourist);
		}
		return tourist;
	}

	public void setBusinessLogic(FlightManager g) {
		businessLogic = g;
	}

	/**
	 * This method initializes lookForFlights
	 * 
	 * @return javax.swing.JButton
	 */
	private JButton getLookForFlights() {
		if (lookForFlightsButton == null) {
			lookForFlightsButton = new JButton();
			lookForFlightsButton.setBounds(new Rectangle(81, 134, 264, 36));
			lookForFlightsButton.setText("Look for Concrete Flights");
			lookForFlightsButton.addActionListener(new java.awt.event.ActionListener() {
				@Override
				public void actionPerformed(java.awt.event.ActionEvent e) {
					bookFlightButton.setEnabled(true);
					flightInfo.removeAllElements();
					bookFlightButton.setText("");

					Date date = null;
					try {
						date = newDate(Integer.parseInt(year.getText()), months.getSelectedIndex(),
								Integer.parseInt(day.getText()));
					} catch (Exception ex) {
						JOptionPane.showMessageDialog(jFrame, "Introduce correctamente la fecha.", "Fecha incorrecta",
								JOptionPane.ERROR_MESSAGE);
						
						return;
					}

					concreteFlightCollection = businessLogic.getConcreteFlights(departingCity.getText(),
							arrivingCity.getText(), date);

					for (ConcreteFlight f : concreteFlightCollection)
						flightInfo.addElement(f);

					if (concreteFlightCollection.isEmpty()) {
						jLabelResult.setText("No flights in that city in that date");
					} else {
						jLabelResult.setText("Choose an available flight in this list:");
					}

				}
			});
		}
		return lookForFlightsButton;
	}

	/**
	 * This method initializes jList1
	 * 
	 * @return javax.swing.JList
	 */

	private JComboBox<ConcreteFlight> getFlightList() {
		if (flightCombo == null) {
			flightCombo = new JComboBox<ConcreteFlight>();
			flightCombo.setBounds(45, 209, 363, 27);
			flightCombo.setModel(flightInfo);

			flightCombo.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					if (flightCombo.getSelectedIndex() != -1) { // A este mÈtodo se le llama tambiÈn cuando se hace un
																// clear del JList,
						// por lo que podrÌa estar la selecciÛn vacÌa y dar un error
						selectedConcreteFlight = (ConcreteFlight) flightCombo.getSelectedItem();

						if (business.isSelected() && selectedConcreteFlight.getBusinessNumber() == 0
								|| first.isSelected() && selectedConcreteFlight.getFirstNumber() == 0
								|| tourist.isSelected() && selectedConcreteFlight.getTouristNumber() == 0) {

							bookFlightButton.setEnabled(false);
							bookFlightButton.setText("No available tickets for that fare.");

						} else {
							bookFlightButton.setEnabled(true);
							bookFlightButton.setText("Book this concrete flight: " + selectedConcreteFlight);
						}
					}
				}
			});
		}
		;
		return flightCombo;
	}

	/**
	 * This method initializes bookFlight
	 * 
	 * @return javax.swing.JButton
	 */
	private JButton getBookFlight() {
		if (bookFlightButton == null) {
			bookFlightButton = new JButton();
			bookFlightButton.setBounds(new Rectangle(22, 286, 433, 38));
			bookFlightButton.setEnabled(false);
			bookFlightButton.addActionListener(new java.awt.event.ActionListener() {
				@Override
				public void actionPerformed(java.awt.event.ActionEvent e) {
					int num = 0;
					boolean error = false;
					if (business.isSelected()) {
						num = selectedConcreteFlight.getBusinessNumber();
						if (num > 0)
							selectedConcreteFlight.setBusinessNumber(num - 1);
						else
							error = true;
					} else if (first.isSelected()) {
						num = selectedConcreteFlight.getFirstNumber();
						if (num > 0)
							selectedConcreteFlight.setFirstNumber(num - 1);
						else
							error = true;
					} else if (tourist.isSelected()) {
						num = selectedConcreteFlight.getTouristNumber();
						if (num > 0)
							selectedConcreteFlight.setTouristNumber(num - 1);
						else
							error = true;
					}
					if (error)
						bookFlightButton.setText("Error: There were no tickets available!");
					else
						bookFlightButton.setText("Booked. #tickets left: " + (num - 1));
					bookFlightButton.setEnabled(false);
				}
			});
		}
		return bookFlightButton;
	}

	private Date newDate(int year, int month, int day) {

		Calendar calendar = Calendar.getInstance();
		calendar.set(year, month, day, 0, 0, 0);
		calendar.set(Calendar.MILLISECOND, 0);

		return calendar.getTime();
	}

	public static void main(String[] args) {

		FlightBooking p = new FlightBooking();
		p.setBusinessLogic(new FlightManager());
		p.setVisible(true);

	}
} // @jve:decl-index=0:visual-constraint="18,9"
