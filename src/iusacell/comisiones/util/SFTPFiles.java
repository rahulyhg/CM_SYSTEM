package iusacell.comisiones.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.io.IOUtils;

import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;
import com.jcraft.jsch.SftpException;

public class SFTPFiles {
	
	   public static void main(String args[]) {
//	        JSch jsch = new JSch();
//	        Session session = null;
//	        try {
//	            session = jsch.getSession("usrdes09", "10.188.31.74", 22);
//	            session.setConfig("StrictHostKeyChecking", "no");
//	            session.setPassword("S1st3m45@RH!2015.");
//	            session.connect();
//
//	            Channel channel = session.openChannel("sftp");
//	            channel.connect();
//	            ChannelSftp sftpChannel = (ChannelSftp) channel;
//	            sftpChannel.cd("Sistemas_RH");
//	            sftpChannel.cd("PRH");
//	            sftpChannel.get("prueba.txt","localfile.txt");
//	            sftpChannel.exit();
//	            session.disconnect();
//	        } catch (JSchException e) {
//	            e.printStackTrace();  
//	        } catch (SftpException e) {
//	            e.printStackTrace();
//	        }
//		   File file=new File("c:\\vcredist.bmp");
//		   saveFileSFTP(file,"holi.bmp");
		   
		   File file = getFileSFTP("SAEO_MOV.xls");
		   saveFileSFTP(file, "SAEO_MOV_2016_03_15.xls");
	    }

	   public static boolean saveFileSFTP(File file,String fileName){
		   boolean res=false;
	        JSch jsch = new JSch();
	        Session session = null;
	        try {
	        	session = jsch.getSession("1232749P", "70.42.227.183", 22);
	            session.setConfig("StrictHostKeyChecking", "no");
	            session.setPassword("N7RbXcowvi");
	            session.connect();

	            Channel channel = session.openChannel("sftp");
	            channel.connect();
	            ChannelSftp sftpChannel = (ChannelSftp) channel;
	            sftpChannel.cd("outgoing");
	            sftpChannel.cd("INT_SAEO");
	            InputStream is = new FileInputStream(file);
	            sftpChannel.put(is, fileName);
	            sftpChannel.exit();
	            session.disconnect();
	            res=true;
	        } catch (JSchException e) {
	            e.printStackTrace();  
	        } catch (SftpException e) {
	            e.printStackTrace();
	        } catch (IOException e) {
				e.printStackTrace();
			}
	        System.out.println("terminado");
		   return res;
	   }
	   
	   public static File getFileSFTP(String fileName){
		   File res=new File(fileName);
		   OutputStream os = null;
	        JSch jsch = new JSch();
	        Session session = null;
	        try {
	        	os = new FileOutputStream(res);
	            session = jsch.getSession("1232749P", "70.42.227.183", 22);
	            session.setConfig("StrictHostKeyChecking", "no");
	            session.setPassword("N7RbXcowvi");
	            session.connect();

	            Channel channel = session.openChannel("sftp");
	            channel.connect();
	            ChannelSftp sftpChannel = (ChannelSftp) channel;
	            sftpChannel.cd("outgoing");
	            sftpChannel.cd("INT_SAEO");
//	            sftpChannel.get(fileName,"reporte.xls");
	            sftpChannel.get(fileName, os);
	            sftpChannel.exit();
	            session.disconnect();
	        } catch (JSchException e) {
	            e.printStackTrace();  
	        } catch (SftpException e) {
	            e.printStackTrace();
	        } catch (FileNotFoundException e) {
				e.printStackTrace();
			}finally{
				if (os != null) {
					try {
						IOUtils.closeQuietly(os);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
//			System.out.println(new Date(res.lastModified()));
		   return res;
	   }
}
