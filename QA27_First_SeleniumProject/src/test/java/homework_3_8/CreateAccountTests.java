package homework_3_8;

import com.seleniumProject.models.NewUser;
import com.seleniumProject.models.User;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CreateAccountTests extends TestBase {


  @BeforeMethod
  public void ensurePrecondition() {
    if (!app.getUser().isLoginLinkPresent()) {
      app.getUser().clickOnSignOutButton();
    }
  }

  @Test
  public void registerNewUserPositiveTest() {

    app.getUser().clickOnLoginLink();
    app.getUser().clickOnRegisterLink();

    app.getUser().fillGenderOnRegisterForm();

    app.getUser().fillFirstNameOnRegisterForm("edi");

    app.getUser().fillLastNameOnRegisterForm("edi");

    app.getUser().fillLoginRegisterForm(new User()
        .setMail("ssd1@gm.com")
        .setPassword("Ssdir123$"));
    app.getUser().clickOnConfirmPassword("Ssdir123$");

    app.getUser().clickOnRegisterButton();
    app.getUser().clickOnContinueButton();

    // assert: Log out button is present
    Assert.assertTrue(app.getUser().isLogoutLinkPresent());

  }

  @DataProvider
  public Iterator<Object[]> addNewUserFromCSV() throws IOException {
    List<Object[]> list = new ArrayList<>();
    BufferedReader reader = new BufferedReader(new FileReader("src/test/resources/newUser.csv"));

    String line = reader.readLine();

    while (line != null) {
      String[] split = line.split(",");

      list.add(new Object[]{
          new NewUser().setName(split[0]).setLastname(split[1]).
              setMail(split[2]).setPassword(split[3])});
      line = reader.readLine();
    }

    return list.iterator();
  }

  @Test(dataProvider = "addNewUserFromCSV")
  public void addUserPositiveFromDataProviderWithCSVTest(NewUser user) {
    app.getUser().clickOnLoginLink();
    app.getUser().clickOnRegisterLink();

    // app.getUser().fillGenderOnRegisterForm();

    app.getContact().fillLoginRegisterForm1(user);

    app.getUser().clickOnRegisterButton();
    app.getUser().clickOnContinueButton();

  }

}
