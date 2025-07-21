package chapter17;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

/**
 * 멀티 채팅 서버 구현
 * */
public class Server {
	
	public final static int PORT = 9000;
	public static ArrayList<ClientHandler> list = new ArrayList<ClientHandler>();
	
	public static void main(String[] args) {
		try {
			ServerSocket server = new ServerSocket(PORT);
			System.out.println("서버 실행 중 : " + PORT);
			System.out.println("클라이언트 접속 대기중 ~");
			
			while(true) {
				Socket s = server.accept();	// 클라이언트 접속 대기중
				System.out.println("✅클라이언트 접속 !");
				
				// 클라이언트 별로 접속하고 별도 종료 진행!!
				ClientHandler ch = new ClientHandler(s);
				list.add(ch);
				ch.start();
				
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	} // main

}// class

class ClientHandler extends Thread{
	Socket s;
	DataOutputStream output;
	DataInputStream input;
	
	public ClientHandler(Socket s) {
		try {
			this.s = s;
			this.output = new DataOutputStream(s.getOutputStream());	// 전송
			this.input = new DataInputStream(s.getInputStream());	// 수신	
			String str = "[서버] 환영합니다 ~ ";
			output.writeUTF(str);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public void run() {
		try {
			boolean flag = true;
			while(flag) {
				String receievedMsg = input.readUTF();
//				output.writeUTF("[서버] " + receievedMsg);	// 현재 접속한 클라이언트에게 전송!
				if(receievedMsg.equals("exit")) {
					System.out.println("클라이언트 종료!");
					flag = false;
				} else {
					
					Server.list.forEach(ch -> {
						try {
							ch.output.writeUTF(receievedMsg);
						} catch (Exception e) {
							e.printStackTrace();
						}
					});
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
