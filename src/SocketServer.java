/* 
 * SocketServer.java
 * サーバークラス．EV3からの通信をPC側で受け取る
 */
import java.io.DataInputStream;
import java.io.DataOutputStream;
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
			
			//dos.writeInt(6);;
		}catch(Exception e) {
			System.out.println("Exception: " + e);
		}
	}
}