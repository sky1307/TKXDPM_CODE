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
	
	private int stationID;
	private String nameStation;
	private String address;
	private String area;
	private int available;
	private int current;
	private String imageUrl;
	
	

	public Station() throws SQLException{
		super();
	}
	
	public Station(int id, String name, String address, String area, int available, int current) throws SQLException{
		super();
		this.stationID = id; 
		this.nameStation = name;
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
	
	public int getStationID() {
		return stationID;
	}

	public void setStationID(int stationID) {
		this.stationID = stationID;
	}
	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	public String getNameStation() {
		return nameStation;
	}
	public void setNameStation(String nameStation) {
		this.nameStation = nameStation;
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
