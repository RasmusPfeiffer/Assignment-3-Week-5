package assignment3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class UserService {

	User oUser;
	User[] aUsers = new User[4];
	String sData;
	int iSort = 0;
	int iUser = 0;
	int iGeneralLogins = 0;
	boolean match = false;

	public User createUserArray(String[] aSplit) {

		this.oUser = new User();
		oUser.setUsername(aSplit[0]);
		oUser.setPassword(aSplit[1]);
		oUser.setName(aSplit[2]);
		this.aUsers[iSort] = oUser;
		return oUser;
	}

	public void datasystem(String sFilename) throws IOException {

		BufferedReader reader = new BufferedReader(new FileReader(sFilename));
		try {
			while ((sData = reader.readLine()) != null) {
				String[] aSplit = sData.split(",");
				this.createUserArray(aSplit);
				this.iSort++;
			}
		} finally {
			reader.close();
		}
	}

	public void getInput() {

		Scanner input = new Scanner(System.in);
		try {
			System.out.print("Please enter your Username:\n>");
			String userName = input.nextLine();
			System.out.print("Please enter your Password:\n>");
			String password = input.nextLine();
			User oTemporary = new User();
			oTemporary.setUsername(userName);
			oTemporary.setPassword(password);
			this.checkUser(oTemporary);
		} finally {
			input.close();
		}
	}

	public void checkUser(User oTemporary) {

		for (iUser = 0; iUser < aUsers.length-1; this.iUser++) {
			if (oTemporary.getUsername().equalsIgnoreCase(aUsers[iUser].getUsername())) {
				this.match = true;
				break;
			}
		}
		if (match == true && oTemporary.getPassword().equals(aUsers[iUser].getPassword())) {
			System.out.println("Welcome " + aUsers[iUser].getName());
		} else {
			this.iGeneralLogins++;
			this.iUser = 0;
			switch (iGeneralLogins) {
			case 1, 2, 3, 4:
				System.out.println("Invalid login, please try again.");
				this.getInput();
				break;
			case 5:
				System.out.println("Too many failed login attempts, you are now locked out.");
				break;
			}
		}
	}
}
