/* 
 * SocketServer.java
 * サーバークラス．EV3からの通信をPC側で受け取る
 */
import java.io.*;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketServer {
	static int port= 10000; //サーバ側の待受ポート番号
	static Socket socket; //ソケット
	static DataOutputStream dos; //データ出力
	static DataInputStream dis; //データ入力
    static InputStream Is; //入力
    static OutputStream Os; //出力
    static ServerSocket ss; //サーバソケット

    public double velocity;
    public double yaw;
    
    //サーバーのメイン
	public static void main(String arg[]) {
		try {
			System.out.println("Server Starting...");
			ss = new ServerSocket(port);
			socket = ss.accept(); //クライアントからの通信開始要求が来るまで待機
			System.out.println("IP:"+socket.getInetAddress()); //接続したIPアドレスを表示
			Is = socket.getInputStream();
			dis = new DataInputStream(Is);
			Os =socket.getOutputStream();
			dos = new DataOutputStream(Os);
			System.out.println("Socket Connected!");
			
			//ここからファイルを読み込む
			readFile(); //ファイルを読み込むメソッドを呼び出す
			//
			
			//dos.writeInt(6);;
		}catch(Exception e) {
			System.out.println("Exception: " + e);
		}
	}
	
	//ファイル読み込み用のメソッド
	public static void readFile(){
		try{
			SocketServer ss = new SocketServer();
			FileReader fr = new FileReader("test.dat");
			StreamTokenizer st = new StreamTokenizer(fr);
			st.nextToken();
			ss.velocity = st.nval;
			st.nextToken();
			ss.yaw = st.nval;
			System.out.println("v = " + ss.velocity + "Yaw = " + ss.yaw);
			fr.close();
		}catch(IOException e){
			System.out.println("Exception: " + e);
		}
	}
}