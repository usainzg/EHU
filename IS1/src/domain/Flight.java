package domain;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

public class Flight {

	String flightCode;
	String departingCity;
	String arrivingCity;
	Collection<ConcreteFlight> concreteFlights;

	public Flight(String flightCode, String departingCity, String arrivingCity) {
		super();

		this.flightCode = flightCode;
		this.departingCity = departingCity;
		this.arrivingCity = arrivingCity;
		concreteFlights = new ArrayList<ConcreteFlight>();
	}

	public String getFlightCode() {
		return flightCode;
	}

	public void setFlightCode(String flightCode) {
		this.flightCode = flightCode;
	}

	public String getDepartingCity() {
		return departingCity;
	}

	public void setDepartingCity(String departingCity) {
		this.departingCity = departingCity;
	}

	public String getArrivingCity() {
		return arrivingCity;
	}

	public void setArrivingCity(String arrivingCity) {
		this.arrivingCity = arrivingCity;
	}

	public void addConcreteFlight(String concreteFlighCode, Date date, int businessNumber, int touristNumber,
			int firstNumber, String time) {
		ConcreteFlight cf = new ConcreteFlight(concreteFlighCode, date, businessNumber, touristNumber, firstNumber,
				time, this);
		concreteFlights.add(cf);
	}

	public Collection<ConcreteFlight> getConcreteFlights() {
		return concreteFlights;
	}

	public void setConcreteFlights(Collection<ConcreteFlight> concreteFlights) {
		this.concreteFlights = concreteFlights;
	}

	@Override
	public String toString() {
		return flightCode + "/" + departingCity + "/" + arrivingCity;
	}
}
