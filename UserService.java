package assignment3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class UserService {

	String[] users;
	POJO oUser;
	POJO[] aUsers = new POJO[4];
	String sData;
	int i = 0;
	int u = 0;
	int l = 0;
	boolean match = false;

	public POJO createUserArray() {

		this.oUser = new POJO();
		String[] aSplit = sData.split(",");
		oUser.setUsername(aSplit[0]);
		oUser.setPassword(aSplit[1]);
		oUser.setName(aSplit[2]);
		this.aUsers[i] = oUser;
		return oUser;
	}

	public void datasystem(String sFilename) throws IOException {

		BufferedReader reader = new BufferedReader(new FileReader(sFilename));
		this.sData = reader.readLine();
		this.createUserArray();
		this.i++;
		while ((sData = reader.readLine()) != null) {
			this.createUserArray();
			this.i++;
		}
		reader.close();
	}

	public void getInput() {

		Scanner input = new Scanner(System.in);
		System.out.print("Please enter your Username:\n>");
		String userName = input.nextLine();
		System.out.print("Please enter your Password:\n>");
		String password = input.nextLine();
		POJO oTemporary = new POJO();
		oTemporary.setUsername(userName);
		oTemporary.setPassword(password);
		this.checkUser(oTemporary);
		input.close();
	}

	public void checkUser(POJO oTemporary) {

		switch (aUsers[u].getUnsuccesfullLogins()) {
		case 0, 1, 2, 3:
			for (u = 0; u <= 3; this.u++) {
				if (oTemporary.getUsername().equalsIgnoreCase(aUsers[u].getUsername())) {
					this.match = true;
					break;
				} else if (match = false){
					System.out.println("Invalid login, please try again.");
				}
			}
			if (match = true) {
				if (oTemporary.getPassword().equals(aUsers[u].getPassword())) {
					System.out.println("Welcome " + aUsers[u].getName());
				} else {
					System.out.println("Invalid login, please try again.");
					this.l++;
					aUsers[u].setUnsuccesfullLogins(l);
					this.getInput();
				}
			}
			break;

		case 4:
			System.out.println("Too many failed login attempts, you are now locked out.");
			break;
		}
	}
}