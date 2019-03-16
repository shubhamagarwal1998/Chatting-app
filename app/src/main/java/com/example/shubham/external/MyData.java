package com.example.shubham.external;

import android.os.StrictMode;
import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
/**
 * Created by SHUBHAM on 24-06-2018.
 */
public class MyData {

    public static String save(String email,String password,String name)
    {
        final String SERVER_URL = "http://192.168.43.214:8080/WA/save.jsp";
        final String CHAR_SET = "UTF-8";
        OutputStream output = null;
        String response = "";
        try
        {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
            Log.i("HTTP :", "Preparing data");
            String data = URLEncoder.encode("email", CHAR_SET) + "=" + URLEncoder.encode(email, CHAR_SET);
            data += "&" + URLEncoder.encode("password", CHAR_SET) + "=" + URLEncoder.encode(password, CHAR_SET);
            data += "&" + URLEncoder.encode("name", CHAR_SET) + "=" + URLEncoder.encode(name, CHAR_SET);
            URLConnection connection = new URL(SERVER_URL).openConnection();
            connection.setDoOutput(true); // This means POST method to be used
            connection.setRequestProperty("Accept-Charset", CHAR_SET); //For servers to know what encoding is used for the parameters
            connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded;charset=" + CHAR_SET);

            output = null;
            output = connection.getOutputStream(); //open a Output stream from the connection for posting data
            output.write(data.getBytes(CHAR_SET)); //Post data
            output.flush();
            output.close();
            //------------------------------------------------------ END: PREPARE CONNETION AND REQUEST --------------------------------- //

            Log.i("HTTP :", "sending data");
            InputStream responseStream = connection.getInputStream(); //This is when the request is actually fired



            //------------------------------------------------------ START: READ RESPONSE ------------------------------------------------ //

            Log.i("HTTP :", "Reading response");
            BufferedReader rd = new BufferedReader(new InputStreamReader(responseStream,CHAR_SET)); // Connect a BufferReader to the inputStream
            String line = null;

            while ((line = rd.readLine()) != null) // Read the response line-by-line from the bufferedReader
            {
                response += line;
            }

            //------------------------------------------------------ END: READ RESPONSE ------------------------------------------------- //
            Log.i("response :",response);


        }

        catch(IOException io)
        {
            response=response+io.getMessage();
            //Log and check exp
            Log.i("Error2 :",io.getMessage());
        }




        return response;

    }
    public static String check(String email,String password)
    {
        final String SERVER_URL = "http://192.168.43.214:8080/WA/login.jsp";
        final String CHAR_SET = "UTF-8";
        OutputStream output = null;
        String response = "";
        try
        {

            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
            Log.i("HTTP :", "Preparing data");
            String data = URLEncoder.encode("email", CHAR_SET) + "=" + URLEncoder.encode(email, CHAR_SET);
            data += "&" + URLEncoder.encode("password", CHAR_SET) + "=" + URLEncoder.encode(password, CHAR_SET);
            URLConnection connection = new URL(SERVER_URL).openConnection();
            connection.setDoOutput(true); // This means POST method to be used
            connection.setRequestProperty("Accept-Charset", CHAR_SET); //For servers to know what encoding is used for the parameters
            connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded;charset=" + CHAR_SET);

            output = null;
            output = connection.getOutputStream(); //open a Output stream from the connection for posting data
            output.write(data.getBytes(CHAR_SET)); //Post data
            output.flush();
            output.close();
            //------------------------------------------------------ END: PREPARE CONNETION AND REQUEST --------------------------------- //

            Log.i("HTTP :", "sending data");
            InputStream responseStream = connection.getInputStream(); //This is when the request is actually fired



            //------------------------------------------------------ START: READ RESPONSE ------------------------------------------------ //

            Log.i("HTTP :", "Reading response");
            BufferedReader rd = new BufferedReader(new InputStreamReader(responseStream,CHAR_SET)); // Connect a BufferReader to the inputStream
            String line = null;

            while ((line = rd.readLine()) != null) // Read the response line-by-line from the bufferedReader
            {
                response += line;
            }

            //------------------------------------------------------ END: READ RESPONSE ------------------------------------------------- //
            Log.i("response :",response);


        }
        catch (UnsupportedEncodingException e)
        {
            response=response+e.getMessage();
            Log.i("Error1 :",e.getMessage());
            e.printStackTrace();

        }
        catch(IOException io)
        {response=response+io.getMessage();
            //Log and check exp
            Log.i("Error2 :",io.getMessage());
        }
        finally
        {
            if (output != null) try {
                output.close();
            } catch (IOException ignoreIO) {
                Log.i("Error3 :", ignoreIO.getMessage());
            }
        }


        return response;

    }
    public static String dispuser()
    {
        final String SERVER_URL = "http://192.168.43.214:8080/WA/dispuser.jsp";
        final String CHAR_SET = "UTF-8";
        OutputStream output = null;
        String response = "";
        try
        {

            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
            Log.i("HTTP :", "Preparing data");
            String data ="";
            URLConnection connection = new URL(SERVER_URL).openConnection();
            connection.setDoOutput(true); // This means POST method to be used
            connection.setRequestProperty("Accept-Charset", CHAR_SET); //For servers to know what encoding is used for the parameters
            connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded;charset=" + CHAR_SET);
            output = null;
            output = connection.getOutputStream(); //open a Output stream from the connection for posting data
            output.write(data.getBytes(CHAR_SET)); //Post data
            output.flush();
            output.close();
            Log.i("HTTP :", "sending data");
            InputStream responseStream = connection.getInputStream();
            Log.i("HTTP :", "Reading response");
            BufferedReader rd = new BufferedReader(new InputStreamReader(responseStream,CHAR_SET)); // Connect a BufferReader to the inputStream
            String line = null;

            while ((line = rd.readLine()) != null) // Read the response line-by-line from the bufferedReader
            {
                response += line;
            }

            //------------------------------------------------------ END: READ RESPONSE ------------------------------------------------- //
            Log.i("response :",response);


        }
        catch (UnsupportedEncodingException e)
        {
            response=response+e.getMessage();
            Log.i("Error1 :",e.getMessage());
            e.printStackTrace();

        }
        catch(IOException io)
        {response=response+io.getMessage();
            //Log and check exp
            Log.i("Error2 :",io.getMessage());
        }
        finally
        {
            if (output != null) try {
                output.close();
            } catch (IOException ignoreIO) {
                Log.i("Error3 :", ignoreIO.getMessage());
            }
        }


        return response;

    }
    public static String savechat(String sender,String rec,String msg)
    {
        final String SERVER_URL = "http://192.168.43.214:8080/WA/chat.jsp";
        final String CHAR_SET = "UTF-8";
        OutputStream output = null;
        String response = "";
        try
        {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
            Log.i("HTTP :", "Preparing data");
            String data = URLEncoder.encode("sadd", CHAR_SET) + "=" + URLEncoder.encode(sender, CHAR_SET);
            data += "&" + URLEncoder.encode("radd", CHAR_SET) + "=" + URLEncoder.encode(rec, CHAR_SET);
            data += "&" + URLEncoder.encode("msg", CHAR_SET) + "=" + URLEncoder.encode(msg, CHAR_SET);
            URLConnection connection = new URL(SERVER_URL).openConnection();
            connection.setDoOutput(true); // This means POST method to be used
            connection.setRequestProperty("Accept-Charset", CHAR_SET); //For servers to know what encoding is used for the parameters
            connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded;charset=" + CHAR_SET);
            output = null;
            output = connection.getOutputStream(); //open a Output stream from the connection for posting data
            output.write(data.getBytes(CHAR_SET)); //Post data
            output.flush();
            output.close();
            Log.i("HTTP :", "sending data");
            InputStream responseStream = connection.getInputStream(); //This is when the request is actually fired
            Log.i("HTTP :", "Reading response");
            BufferedReader rd = new BufferedReader(new InputStreamReader(responseStream,CHAR_SET)); // Connect a BufferReader to the inputStream
            String line = null;
            while ((line = rd.readLine()) != null) // Read the response line-by-line from the bufferedReader
            {
                response += line;
            }
            Log.i("response :",response);
        }
        catch(IOException io)
        {
            response=response+io.getMessage();
            //Log and check exp
            Log.i("Error2 :",io.getMessage());
        }
        return response;
    }
    public static String dispchat(String sender,String rec)
    {
        final String SERVER_URL = "http://192.168.43.214:8080/WA/dispchat.jsp";
        final String CHAR_SET = "UTF-8";
        OutputStream output = null;
        String response = "";
        try
        {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
            Log.i("HTTP :", "Preparing data");
            String data = URLEncoder.encode("sadd", CHAR_SET) + "=" + URLEncoder.encode(sender, CHAR_SET);
            data += "&" + URLEncoder.encode("radd", CHAR_SET) + "=" + URLEncoder.encode(rec, CHAR_SET);
            URLConnection connection = new URL(SERVER_URL).openConnection();
            connection.setDoOutput(true); // This means POST method to be used
            connection.setRequestProperty("Accept-Charset", CHAR_SET); //For servers to know what encoding is used for the parameters
            connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded;charset=" + CHAR_SET);
            output = null;
            output = connection.getOutputStream(); //open a Output stream from the connection for posting data
            output.write(data.getBytes(CHAR_SET)); //Post data
            output.flush();
            output.close();
            Log.i("HTTP :", "sending data");
            InputStream responseStream = connection.getInputStream(); //This is when the request is actually fired
            Log.i("HTTP :", "Reading response");
            BufferedReader rd = new BufferedReader(new InputStreamReader(responseStream,CHAR_SET)); // Connect a BufferReader to the inputStream
            String line = null;
            while ((line = rd.readLine()) != null) // Read the response line-by-line from the bufferedReader
            {
                response += line;
            }
            Log.i("response :",response);
        }
        catch(IOException io)
        {
            response=response+io.getMessage();
            //Log and check exp
            Log.i("Error2 :",io.getMessage());
        }
        return response;
    }
}
