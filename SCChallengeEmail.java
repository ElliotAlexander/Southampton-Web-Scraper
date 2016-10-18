import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

public class SCChallengeEmail {

    private String emailID, line, nameLine;
    private BufferedReader br;

    public static void main(String[] args) throws IOException {
        SCChallengeEmail mainObject = new SCChallengeEmail();
        mainObject.run();
    }

    private void run() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter your email ID:");
        emailID = br.readLine();
        br = new BufferedReader(new InputStreamReader((new URL("http://www.ecs.soton.ac.uk/people/" + emailID).openStream())));
        while ((line = br.readLine()) != null) {
            if (line.contains("property=\"name\"")) {
                nameLine = line.split("name\">")[1].split("<")[0];
                System.out.println("Name: " + nameLine);
            }
        }
        if (nameLine == null) {
            System.out.println("User not found. ");
        }
    }
}

