package controller;

import java.sql.SQLException;

import controller.BaseController;
import entity.Bike;
import entity.Station;
import entity.Home;
import java.util.*;

public class RentalBikeController extends BaseController {
	private Home home;
	public RentalBikeController() {
		home = new Home();
	}
	
	public ArrayList<Station>  getAllStation() throws SQLException {
		ArrayList<Station> res = home.getAllStation();
		return res;
	}
	
	public Station getStation(String keyword) throws SQLException {
		Station res = home.getStation(keyword);
		return res;
	}
	
	public Station getStation(int ID) throws SQLException {
		Station res = home.getStation(ID);
		return res;
	}
	
	public ArrayList<Bike> getBikeInStation(int station_id) throws SQLException {
		Station station = getStation(station_id);
		ArrayList<Bike> res = station.getAllBike();
		return res;
	}
	
	public Bike getBike(int id) throws SQLException {
		Bike res = home.getBike(id);
		return res;
	}
	
	public boolean checkTheAvailabilityOfBike(int id) throws SQLException {
		Bike bike = home.getBike(id);
		return bike.getStatus();
	}
}