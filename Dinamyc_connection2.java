package qr;

import java.io.File;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

public class Dinamyc_connection2 {
	public static void main(String args[]) {
		try {
			Integer i = 0;
			connect_postgresql2 obj_connect_postgresql2 = new connect_postgresql2();
			Connection connection = obj_connect_postgresql2.getConnection();
			String query = "select * from users";
			Statement stmt = null;
			stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while(rs.next()) {
				String name1 = rs.getString(2);
                String name2 = rs.getString(3);
                String name3 = rs.getString(4);
                String name4 = rs.getString(5);
                String name5 = rs.getString(6);
                String name6 = rs.getString(7);
                String name7 = rs.getString(8);
		String name8 = rs.getString(9);
                
                name1 = name1.concat(name2);
                name1 = name1.concat(name3);
                name1 = name1.concat(name4);
                name1 = name1.concat(name5);
                name1 = name1.concat(name6);
                name1 = name1.concat(name7);
		name1 = name1.concat(name8);
               
                Dinamyc_connection2.generate_qr(i, name1);
                i++;
			}			
		} catch(Exception e) {
			System.out.println(e);		
		}
	}
	public static void generate_qr(Integer image_name, String qrCodeData) {
		try {
			String filePath = "D:\\zxing_jars\\qr_sql\\" + image_name + ".png";
			String charset = "UTF-8";
			 Map < EncodeHintType, ErrorCorrectionLevel > hintMap = new HashMap < EncodeHintType, ErrorCorrectionLevel > ();
	            hintMap.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.L);
	            BitMatrix matrix = new MultiFormatWriter().encode(
	                new String(qrCodeData.getBytes(charset), charset),
	                BarcodeFormat.QR_CODE, 200, 200, hintMap);
	            MatrixToImageWriter.writeToFile(matrix, filePath.substring(filePath
	                .lastIndexOf('.') + 1), new File(filePath));
	            System.out.println("QR Code image created successfully!");
	        } catch (Exception e) {
	            System.err.println(e);
	        }
	}
}
