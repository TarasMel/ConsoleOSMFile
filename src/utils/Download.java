package utils;


import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

public class Download implements Runnable {

    private String link;
    private File out;

    public Download(String link, File out){
        this.link = link;
        this.out = out;
    }


    @Override
    public void run() {
        try {
            URL url = new URL(link);
            HttpURLConnection httpURLConnection = (HttpURLConnection)url.openConnection();
            BufferedInputStream inputStream = new BufferedInputStream(httpURLConnection.getInputStream());
            FileOutputStream fileOutputStream = new FileOutputStream(this.out);
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream, 1024);
            byte[] buffer =  new byte[1024];
            int read;
            while((read = inputStream.read(buffer, 0, 1024)) >= 0){
                bufferedOutputStream.write(buffer, 0, read);
                System.out.println("Downloading...please wait");
            }
            bufferedOutputStream.close();
            inputStream.close();
            System.out.println("Download complete");
        }
        catch (IOException ex){
            ex.printStackTrace();
        }
    }
}
