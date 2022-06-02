package testSuite;

import com.revature.Pi2a1000Places.util.ConnectionFactory;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import java.sql.Connection;

public class ConnectionFactoryTestSuite {

    @Test
    public void test_getConnection_givenProvidedCredentials_returnValidConnection() {

        try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
            System.out.println(conn);

            Assertions.assertNotNull(conn);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


}
