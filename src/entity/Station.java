package entity;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import entity.db.EcoBikeDB;
import utils.Utils;
import entity.Bike;
import entity.Home;

public class Station extends BaseEntity {
	
	private int station_id;
	private String name_station;
	private String address;
	private String area;
	private int available;
	private int current;
	
	public Station() throws SQLException{
		super();
	}
	
	public Station(int id, String name, String address, String area, int available, int current) throws SQLException{
		super();
		this.station_id = id; 
		this.name_station = name;
		this.address = address;
		this.area = area;
		this.available = available;
		this.current = current;
	}
	
	public ArrayList<Bike> getAllBike() throws SQLException {
		ArrayList<Bike> list = new ArrayList<Bike>();
		String sql = "";
		ResultSet res = this.connectDatabase(sql);
		if(res.next()) {
			int id_bike = res.getInt("ID");
			int deposit = res.getInt("deposit");
			int value = res.getInt("value");
			int station_id = res.getInt("station_id");
			String fullInfo = res.getString("fullInfo");
			String type = res.getString("type");
			boolean status = res.getBoolean("status");
			String barCode = res.getString("barCode");
			
			list.add(new Bike(id_bike, deposit, value, station_id, fullInfo, type, status, barCode));
		}else {
			throw new SQLException();
		}
		return list;
	}
	
	public Bike getBike(int id) throws SQLException {
		String sql = "";
		ResultSet res = this.connectDatabase(sql);
		if(res.next()) {
			//int id_bike = res.getInt("ID");
			int deposit = res.getInt("deposit");
			int value = res.getInt("value");
			int station_id = res.getInt("station_id");
			String fullInfo = res.getString("fullInfo");
			String type = res.getString("type");
			boolean status = res.getBoolean("status");
			String barCode = res.getString("barCode");
			
			return new Bike(id, deposit, value, station_id, fullInfo, type, status, barCode);
		}else {
			throw new SQLException();
		}
	}
	
	public Bike getBike(String barCode) throws SQLException {
		String sql = "";
		ResultSet res = this.connectDatabase(sql);
		if(res.next()) {
			int id_bike = res.getInt("ID");
			int deposit = res.getInt("deposit");
			int value = res.getInt("value");
			int station_id = res.getInt("station_id");
			String fullInfo = res.getString("fullInfo");
			String type = res.getString("type");
			boolean status = res.getBoolean("status");
			//String barCode = res.getString("barCode");
			
			return new Bike(id_bike, deposit, value, station_id, fullInfo, type, status, barCode);
		}else {
			throw new SQLException();
		}
	}

	
	public boolean checkID(int id) {
		return false;
	}
	
	public int getId_station() {
		return station_id;
	}
	public void setId_station(int station_id) {
		this.station_id = station_id;
	}
	public String getName_station() {
		return name_station;
	}
	public void setName_station(String name_station) {
		this.name_station = name_station;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public int getAvailable() {
		return available;
	}
	public void setAvailable(int available) {
		this.available = available;
	}
	public int getCurrent() {
		return current;
	}
	public void setCurrent(int current) {
		this.current = current;
	}

}
