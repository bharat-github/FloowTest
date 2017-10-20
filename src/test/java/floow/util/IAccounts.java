package floow.util;

import java.util.Random;

public interface IAccounts {
	public String createNewUsername(Random randomGenerator);

	public String createPassword(Random randomGenerator, int length, PasswordTestType testType);

}
