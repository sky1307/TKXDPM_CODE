package entity;

import java.sql.ResultSet;


import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import entity.db.EcoBikeDB;
import utils.Utils;
import entity.Home;

public class Bike extends BaseEntity {
	public Bike() throws SQLException {
		super();
	}
	
	public Bike(int id_bike, int deposit, int value, int station_id, String fullInfo, String type, boolean status, String barCode) throws SQLException {
		super();
		this.id_bike = id_bike;
		this.deposit = deposit;
		this.value = value;
		this.station_id = station_id;
		this.fullInfo = fullInfo;
		this.type = type;
		this.status = status;
		this.barCode = barCode;
	}
	
	public Bike(String barcode) throws SQLException {
		super();
		String sql ="";
		ResultSet res = super.connectDatabase(sql);
	}
	
	
	private int id_bike;
	private int deposit;
	private int value;
	private int station_id;
	private String fullInfo;
	private String type;
	private boolean status;
	private String barCode;
	public int getId_bike() {
		return id_bike;
	}
	public void setId_bike(int id_bike) {
		this.id_bike = id_bike;
	}
	public int getDeposit() {
		return deposit;
	}
	public void setDeposit(int deposit) {
		this.deposit = deposit;
	}
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	public int getStation_id() {
		return station_id;
	}
	public void setStation_id(int station_id) {
		this.station_id = station_id;
	}
	public String getFullInfo() {
		return fullInfo;
	}
	public void setFullInfo(String fullInfo) {
		this.fullInfo = fullInfo;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public boolean getStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public String getBarCode() {
		return barCode;
	}
	public void setBarCode(String barCode) {
		this.barCode = barCode;
	}
	
	
}
