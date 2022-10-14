package com.apirestiagodev.apirestreact.repository;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class firebaseRepository {
    // Path path = Paths.get("..//addons//key.json");

    @PostConstruct
    public void initialize() {
       
        Path path 
        = Paths.get( "..\\addons\\key.json"); 

        boolean isresult2 = Files.isReadable(path);
        boolean result = Files.exists(path); 

      
        

        System.out.println("File " + path 
                           + " is Executable = "
                           + result ); 
        try {

            // File fileObj = new File("aaa.txt");  
            // PrintWriter printWriter1 = new PrintWriter(new FileWriter(fileObj), true);  
            // printWriter1.println("Hello world");  
            // printWriter1.close();  

            // FileInputStream serviceAccount =
            //         new FileInputStream(filename);

                    

            // FirebaseOptions options = new FirebaseOptions.Builder()
            //         .setCredentials(GoogleCredentials.fromStream(serviceAccount))
            //         .build();

            // FirebaseApp.initializeApp(options);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}

// final String[] serviceAccount  = 
//                 {
//                     "type : service_account",
//                     "project_id: gym-react-cd899",
//                     "private_key_id: -----BEGIN PRIVATE KEY-----\nMIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQDzhOft8pQ9/Gw/\ncP6b0SiiF9v0JM/OJnfq82WYyS8VpGZzBOLZd63CxDlPfsempdTIQU+RfqK+2alW\nQBGphTlq5y8ppA81nLlVnkm5pHoU3ebJZipiCePh5eOhsNFGhjwMfgNUBErkUq1r\n+UMCd3xdYJV+9sJwx2Olk1sMQdeo/xWo51ik9ciV5a0H8aqe2KZ7SQZzpXCwNzPB\n3bLjK/elPa21TxW/OosEeOemSd9SfYQffeQdS80Eb4Juk9PlVzVZZs5mSnXYh7t2\nGOTmSttziW3Erna4LVakTo3hByO6RNxKayNuGPWTYPgP0RaWeH6i4AjuuD2hqPMu\nx4uWKGavAgMBAAECggEAJE9w9b3x9Lwqt9r1W+54DJNaLLFAexCpWNMqFvoIl0WI\nMSZNXPfHZP81PHE++85GSAXVA3DKe4KhCUdMWuaOhS4rjh30Vp4j1GxhudiYi3v6\n6ZTeRPgMjqZkprtiuQ1S7tnrTR/GuvzI9wyXvUprtNCt+dx5aa+RYCL0tIMs0PnN\nnOhV6kF1ThF4uRLQgRF5FgdXyqkxENlfrIdBtYCTmqVnyDnBCEjl5Pt34mR4YxEb\nD8czZsrUsNkzPZySsdmZa8o9g6j+QS6YUCo0Ub9DUuMAQLfYbR1DB6Pd8uwANfwc\nYGJnBL9+euYrVuBXtGqqRy7rTga1BE2HOlsLeL+7YQKBgQD9uEKbyogRSUBIABNR\ndEpYD+9J4CKUyB4jBIVKnt+Kk5tJmRLMNmg5rLefaX/FaiwX549vxFrrAXw3lWMH\nT9xEzBzq18w9W+wcsqWOuWEJg+9ZZjDvFzJDK75Dz60uyM8Q218J3M+YFHMIU5NN\n/5ct8DYjClBHpBaiXx8qCc+qhQKBgQD1tS1PEjFec1hoAMFHxjiIRqm/dTOKbpVU\n6FZAvctL+dIcfx3CuN6FX67r3pMebPErpSrVpPWcpkRlmcxMXP28VJtGoyz1eC86\nnhRiirXr3gqKeVBV7wEmagbeeyMsvmtb0gAQk/H9wrYGcnpjjX3ni8FpEEKTg71l\ndSpFky3EowKBgEld6ezw4O3Wt77aPrvUG9dhLDm5lWZeg9BuczjDvjJtQn9Cw1vH\n89WRqztun2Lvs7Zp4GFab0v7jvbnvM4VesVuHIKQSmAH37vgsN0XoAbHXwQD9+x7\nUa54zLkBKbwYlz/xn4bTkjgQ2b6zpCnu2cGP76esSNCek2j6hqF6WtGdAoGAA2hw\n6XDaKHI3HrIr/B/ett0sC5DHlzrzbUsPrzQytqoPZP/KXOINjBIIrhLXPYvLSIyw\n7GeuVG7l8fbRI5oClvMheDhZLkptdUWuCLPd1BivUr5eA+Mdw/eigsF4em1ltc9S\n2ugCaj+iILLDyc+zmFuS4i8sjTk9jkOyw2ZIMzsCgYEAqn1jRnAtrCrHL4V3NVKC\n6R52Dm0MkHUFMN8z8E1j6j8DgjnRBlv4NngRjy2f2dpuloNX6yamKV7JB/Cas5Gv\nLJAWD1nIVJeJcFeQkRhOYdsIlz94Q2kcxDICyy8lXU+Z3Fk9ykTtoMcaeKUoqHOG\nmnLqKfTTh+LS3kGOSUI3ZnA=\n-----END PRIVATE KEY-----\n",
//                     "client_email: firebase-adminsdk-xj6ti@gym-react-cd899.iam.gserviceaccount.com",
//                     "client_id: 105315606942203493948",
//                     "auth_uri: https://accounts.google.com/o/oauth2/auth",
//                     "token_uri: https://oauth2.googleapis.com/token",
//                     "auth_provider_x509_cert_url: https://www.googleapis.com/oauth2/v1/certs",
//                     "client_x509_cert_url: https://www.googleapis.com/robot/v1/metadata/x509/firebase-adminsdk-xj6ti%40gym-react-cd899.iam.gserviceaccount.com"

//                 };
            