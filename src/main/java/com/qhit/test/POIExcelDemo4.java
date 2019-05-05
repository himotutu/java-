package com.qhit.test;

import com.qhit.utils.CommonUtil;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class POIExcelDemo4 {

	public static void main(String[] args) throws Exception {
		String title = "流程信息表";
		String[] name = {"序号","流程名称","斗轮机","装船机","皮带机","所属企业"};
		//获取数据设备信息
		Connection connection = CommonUtil.getConnection();
		java.sql.Statement statement = connection.createStatement();
		String sql = "SELECT bf.flowid,bf.flowname,bd1.devname AS dljname,bd2.devname AS zcjname,bd3.devname AS pdjname,bc.compname\n" +
				"\t\tFROM base_flow bf LEFT JOIN base_device bd1 ON bf.dljid=bd1.devid\n" +
				"\t\t LEFT JOIN base_device bd2 ON bf.zcjid=bd2.devid\n" +
				"\t\tLEFT JOIN base_device bd3 ON bf.pdjid=bd3.devid\n" +
				"\t\tLEFT JOIN base_company bc ON bf.compid=bc.compid  ";
		ResultSet rs = statement.executeQuery(sql);

		CommonUtil.exportExcel(title,name,rs);
		
	}
}
