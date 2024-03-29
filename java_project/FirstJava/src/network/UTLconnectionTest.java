package network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class UTLconnectionTest {

	public static void main(String[] args) {

		
		try {
			// url 인스턴스 생성
			String urlpath = "http://www.ctware.net";
			URL url = new URL(urlpath);
			
			// urlconnection 인스턴스
			URLConnection conn = url.openConnection();
			
			// 연결된 파일(자원)을 읽을 스트림 생성
			BufferedReader in = null;
			
			// URLConnection 인스턴스에서 InputStream을 얻을 수 있다.
			InputStream is = conn.getInputStream(); 
			
			Reader reader = new InputStreamReader(is);
			
			in = new BufferedReader(reader);
			
			// 한줄씩 읽어올 임시 변수
			String str=null;
			
			while(true) {
				str=in.readLine();
				System.out.println(str);
				if(str==null) {
					break;
				}
			}
			
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}

	}

}
