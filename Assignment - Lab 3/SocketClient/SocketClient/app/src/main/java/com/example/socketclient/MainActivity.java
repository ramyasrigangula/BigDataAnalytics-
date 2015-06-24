package com.example.socketclient;


import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;



import android.os.AsyncTask;
import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {
 
 TextView textResponse;
 EditText editTextAddress, editTextPort,editText;
 Button buttonConnect, buttonClear,buttonsend;
 String command;
 Boolean checkupdate=false;
 @Override
 protected void onCreate(Bundle savedInstanceState) {
  super.onCreate(savedInstanceState);
  setContentView(R.layout.activity_main);
  
  editTextAddress = (EditText)findViewById(R.id.address);
  editTextPort = (EditText)findViewById(R.id.port);
  buttonConnect = (Button)findViewById(R.id.connect);
  buttonClear = (Button)findViewById(R.id.clear);
  textResponse = (TextView)findViewById(R.id.response);
  buttonsend=(Button) findViewById(R.id.send);
  editText=(EditText)findViewById(R.id.cmd);


  buttonsend.setOnClickListener(new OnClickListener(){

		@Override
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
			command=editText.getText().toString();
			checkupdate=true;
		}
		  
	  });
  buttonConnect.setOnClickListener(buttonConnectOnClickListener);

  buttonClear.setOnClickListener(new OnClickListener(){

   @Override
   public void onClick(View v) {
    textResponse.setText("");
   }});
 }
 
 OnClickListener buttonConnectOnClickListener =
   new OnClickListener(){

    @Override
    public void onClick(View arg0) {
     MyClientTask myClientTask = new MyClientTask(
       editTextAddress.getText().toString(),
       Integer.parseInt(editTextPort.getText().toString()));
     myClientTask.execute();
    }};

 public class MyClientTask extends AsyncTask<Void, Void, Void> {
  
  String dstAddress;
  int dstPort;
  String response = "";
  
  MyClientTask(String addr, int port){
   dstAddress = addr;
   dstPort = port;
  }
  @Override
	protected Void doInBackground(Void... arg0) {

		OutputStream outputStream;
		Socket socket = null;

		try {
			socket = new Socket(dstAddress, dstPort);
			Log.d("MyClient Task", "Destination Address : " + dstAddress);
			Log.d("MyClient Task", "Destination Port : " + dstPort + "");
			outputStream = socket.getOutputStream();
			PrintStream printStream = new PrintStream(outputStream);
			
			while (true) {
				if(checkupdate)
				{
					Log.d("Command", command);
					Log.d("checkUpdate", checkupdate.toString());
					printStream.print(command);
					printStream.flush();
					Log.d("Socekt connection", socket.isClosed()+"");
					checkupdate=false;
				}
			}

		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			response = "UnknownHostException: " + e.toString();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			response = "IOException: " + e.toString();
		} finally {
			if (socket != null) {
				try {
					socket.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return null;
	}


  @Override
  protected void onPostExecute(Void result) {
   textResponse.setText(response);
   super.onPostExecute(result);
  }
  
 }

}
