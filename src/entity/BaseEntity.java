package entity;

import java.sql.ResultSet;


import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import entity.db.EcoBikeDB;
import utils.Utils;
import entity.Station;

public class BaseEntity {
	private static Logger LOGGER = Utils.getLogger(Station.class.getName());
	
	public BaseEntity() {
		
	}
	
	public ResultSet connectDatabase(String sql) throws SQLException{
		Statement stm = EcoBikeDB.getConnection().createStatement();
		ResultSet res = stm.executeQuery(sql);
		return res;
	}
	
}
