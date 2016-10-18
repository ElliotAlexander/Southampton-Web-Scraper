import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

public class SCChallengeEmail {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter your email ID:");
        String emailID = br.readLine();
        br = new BufferedReader(new InputStreamReader((new URL("http://www.ecs.soton.ac.uk/people/" + emailID).openStream())));
        String line, nameLine;
        while ((line = br.readLine()) != null) {
            if (line.contains("property=\"name\"")) {
                nameLine = line.split("name\">")[1].split("<")[0];
                System.out.println("Name: " + nameLine);
                System.exit(0);
            }
        }
        System.out.println("User not found.");
    }
}

