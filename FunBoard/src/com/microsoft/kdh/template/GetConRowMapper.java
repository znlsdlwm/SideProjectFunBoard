package com.microsoft.kdh.template;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

@FunctionalInterface
public interface GetConRowMapper<T> {
	public T getConMapRow(Connection con, ResultSet rs) throws SQLException;
}
