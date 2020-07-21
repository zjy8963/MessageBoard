package org.sql;

import java.sql.*;

public class SQLUtil {
	public static String getHtmlTable(ResultSet results) {
		try {
			StringBuilder htmlTable = new StringBuilder();
			ResultSetMetaData metaData = results.getMetaData();
			int columnCount = metaData.getColumnCount();
			int rowCount = 0;
			
			
			htmlTable.append("<table>");
			
			//header row
			htmlTable.append("<tr>");
			for(int i = 1; i <= columnCount; i++) {
				htmlTable.append("<th>");
				htmlTable.append(metaData.getColumnName(i));
				htmlTable.append("</th>");
			}
			htmlTable.append("</tr>");
			
			//body row
			while(results.next()) {
				rowCount++;
				htmlTable.append("<tr>");
				for(int i = 1; i <= columnCount; i++) {
					htmlTable.append("<td>");
					htmlTable.append(results.getString(i));
					htmlTable.append("</td>");
				}
				htmlTable.append("</tr>");
			}
			
			if(rowCount == 0) {
				return "Empty";
			}
			
			htmlTable.append("</table>");
			return htmlTable.toString();
			
		}catch(SQLException e) {
			e.printStackTrace();
			return "SQLException occurs!";
		}catch(Exception e) {
			e.printStackTrace();
			return "Exception occurs!";
		}
	}
}
