package simpleserver;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.lang.String;

class SimpleServer {

    public static void main(String[] args) throws IOException {
        ServerSocket ding;
        Socket dong = null;
        //String resource = null;
        try {
            ding = new ServerSocket(1299);
            System.out.println("Opened socket " + 1299);
            while (true) {

                String parceString[];
<<<<<<< HEAD
                String request = null;
=======
                String resource = null;
>>>>>>> a5eb7a9efcef76bdbd8628791670e95f52c57761
                // keeps listening for new clients, one at a time
                try {
                    dong = ding.accept(); // waits for client here
                } catch (IOException e) {
                    System.out.println("Error opening socket");
                    System.exit(1);
                }

                InputStream stream = dong.getInputStream();
                BufferedReader in = new BufferedReader(new InputStreamReader(stream));
                try {

                    // read the first line to get the request method, URI and HTTP version
                    String line = in.readLine();

                    System.out.println("----------REQUEST START---------");

<<<<<<< HEAD
                    //Cut string here
                    parceString = line.split(" ");
                    //Taking only the necessary URL;
                    request = parceString[1].substring(1);
=======
                    parceString = line.split(" ");
                    resource = parceString[1].substring(1);
>>>>>>> a5eb7a9efcef76bdbd8628791670e95f52c57761

                    System.out.println(line);
                    // read only headers
                    line = in.readLine();
                    while (line != null && line.trim().length() > 0) {
                        int index = line.indexOf(": ");
                        if (index > 0) {
                            System.out.println(line);
                        } else {
                            break;
                        }
                        line = in.readLine();
                    }
                    System.out.println("----------REQUEST END---------\n\n");
                } catch (IOException e) {
                    System.out.println("Error reading");
                    System.exit(1);
                }

                BufferedOutputStream out = new BufferedOutputStream(dong.getOutputStream());
                PrintWriter writer = new PrintWriter(out, true);  // char output to the client

                // every response will always have the status-line, date, and server name
                writer.println("HTTP/1.1 200 OK");
                writer.println("Server: TEST");
                writer.println("Connection: close");
                writer.println("Content-type: text/html");
                writer.println("");

                // Body of our response
<<<<<<< HEAD
                Processor response = new Processor(request);
                if (request.equals("hello"))
                    writer.println("<h1>Hello World</h1>");
                else
                writer.println("<h1>Try sending \"hello\" request </h1>");
=======
                if (resource.equals("hello"))
                    writer.println("<h1>Hello World</h1>");
                else
                writer.println("<h1>Some cool response!</h1>");
>>>>>>> a5eb7a9efcef76bdbd8628791670e95f52c57761

                dong.close();
            }
        } catch (IOException e) {
            System.out.println("Error opening socket");
            System.exit(1);
        }
    }
}