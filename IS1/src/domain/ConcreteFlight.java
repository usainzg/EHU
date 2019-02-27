package domain;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class ConcreteFlight {

	String concreteFlightCode;
	Date date;
	int businessNumber;
	int touristNumber;
	int firstNumber;
	String time;
	Flight flight;

	public ConcreteFlight(String concreteFlightCode, Date date, int businessNumber, int firstNumber, int touristNumber,
			String time, Flight flight) {
		super();
		this.concreteFlightCode = concreteFlightCode;
		this.date = date;
		this.businessNumber = businessNumber;
		this.firstNumber = firstNumber;
		this.touristNumber = touristNumber;
		this.flight = flight;
		this.time = time;
		this.flight = flight;
	}

	public String getConcreteFlightCode() {
		return concreteFlightCode;
	}

	public void setConcreteFlightCode(String concreteFlightCode) {
		this.concreteFlightCode = concreteFlightCode;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public int getBusinessNumber() {
		return businessNumber;
	}

	public void setBusinessNumber(int businessNumber) {
		this.businessNumber = businessNumber;
	}

	public int getTouristNumber() {
		return touristNumber;
	}

	public void setTouristNumber(int touristNumber) {
		this.touristNumber = touristNumber;
	}

	public int getFirstNumber() {
		return firstNumber;
	}

	public void setFirstNumber(int firstNumber) {
		this.firstNumber = firstNumber;
	}

	@Override
	public String toString() {
		Calendar calendar = new GregorianCalendar();
		calendar.setTime(date);
		int year = calendar.get(Calendar.YEAR);
		// Add one to month {0 - 11}
		int month = calendar.get(Calendar.MONTH) + 1;
		int day = calendar.get(Calendar.DAY_OF_MONTH);

		return flight.toString() + "/" + (year) + "-" + (month) + "-" + day + "/" + time;
	}

	public Flight getFlight() {
		return flight;
	}

	public void setFlight(Flight flight) {
		this.flight = flight;
	}
}
