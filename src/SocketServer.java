/* 
 * SocketServer.java
 * �T�[�o�[�N���X�DEV3����̒ʐM��PC���Ŏ󂯎��
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
	static int port= 10000; //�T�[�o���̑Ҏ�|�[�g�ԍ�
	static Socket socket; //�\�P�b�g
	static DataOutputStream dos; //�f�[�^�o��
	static DataInputStream dis; //�f�[�^����
    static InputStream Is; //����
    static OutputStream Os; //�o��
    static ServerSocket ss; //�T�[�o�\�P�b�g

    public double velocity;
    public double yaw;
    
    //�T�[�o�[�̃��C��
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
			
			//��������t�@�C����ǂݍ���
			readFile(); //�t�@�C����ǂݍ��ރ��\�b�h���Ăяo��
			//
			
			//dos.writeInt(6);;
		}catch(Exception e) {
			System.out.println("Exception: " + e);
		}
	}
	
	//�t�@�C���ǂݍ��ݗp�̃��\�b�h
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