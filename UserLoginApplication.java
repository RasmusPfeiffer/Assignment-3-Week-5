package assignment3;

import java.io.IOException;

public class UserLoginApplication {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		UserService service = new UserService();
		service.datasystem("data.txt");
		service.getInput();
		
	}

}
