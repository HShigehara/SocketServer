/* 
 * SocketServer.java
 * �T�[�o�[�N���X�DEV3����̒ʐM��PC���Ŏ󂯎��
 */
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketServer {
	static int port= 10000; //�T�[�o���̑Ҏ�|�[�g�ԍ�
	static Socket socket; //�\�P�b�g
	static DataOutputStream dos; //�f�[�^�o��
	static DataInputStream dis; //�f�[�^����
    static InputStream Is; //����
    static OutputStream Os; //�o��
    static ServerSocket ss; //�T�[�o�\�P�b�g

	public static void main(String arg[]) {
		try {
			System.out.println("Server Starting...");
			ss = new ServerSocket(port);
			socket = ss.accept(); //�N���C�A���g����̒ʐM�J�n�v��������܂őҋ@
			System.out.println("IP:"+socket.getInetAddress()); //�ڑ�����IP�A�h���X��\��
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