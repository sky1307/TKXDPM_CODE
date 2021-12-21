package entity;

import java.sql.ResultSet;



import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import entity.BaseEntity;

public class Home extends BaseEntity {
	public Home() {
		super();
	}
	
	public ArrayList<Station> getAllStation() throws SQLException {
		ArrayList<Station> list = new ArrayList<Station>();
		String sql = "";
		ResultSet res = connectDatabase(sql);
		if(res.next()) {
			int id_station = res.getInt("ID");
			String name_station = res.getString("name");
			String address = res.getString("address");
			String area = res.getString("area");
			int available = res.getInt("available");
			int current = res.getInt("current");
			
			list.add(new Station(id_station, name_station, address, area, available, current));
		}else {
			throw new SQLException();
		}
		return list;
	}
	
	public Station getStation(String keyWord) throws SQLException {
		String sql = "";
		ResultSet res = connectDatabase(sql);
		if(res.next()) {
			int id_station = res.getInt("ID");
			String name_station = res.getString("name");
			String address = res.getString("address");
			String area = res.getString("area");
			int available = res.getInt("available");
			int current = res.getInt("current");
			
			return new Station(id_station, name_station, address, area, available, current);
		}else {
			throw new SQLException();
		}
	}
	
	public Station getStation(int ID) throws SQLException {
		String sql = "";
		ResultSet res = connectDatabase(sql);
		if(res.next()) {
			//int id_station = res.getInt("ID");
			String name_station = res.getString("name");
			String address = res.getString("address");
			String area = res.getString("area");
			int available = res.getInt("available");
			int current = res.getInt("current");
			
			return new Station(ID, name_station, address, area, available, current);
		}else {
			throw new SQLException();
		}
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
	
	public boolean checkValidKeyWord(String str) {
		return false;
	}
}
