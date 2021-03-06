package com.navercorp.utilsettest.network;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.widget.TextView;

import com.navercorp.utilset.network.NetworkMonitor;
import com.navercorp.utilsettest.R;

public class NetworkMonitorTestActivity extends FragmentActivity {
	NetworkMonitor networkUtils;
	TextView textView;
	AsyncTask<Void, Void, String> networkUtilsTask;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_networkutils);
		
		networkUtils = NetworkMonitor.getInstance(this);
		textView = (TextView) findViewById(R.id.textViewNetworkUtils);
	}
	
	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		
		NetworkMonitor.destroy();
	}

	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		
		networkUtilsTask = new AsyncTask<Void, Void, String>() {
			@Override
			protected String doInBackground(Void... params) {
				// TODO Auto-generated method stub
				return networkUtils();
			}

			@Override
			protected void onPostExecute(String result) {
				// TODO Auto-generated method stub
				textView.setText(result);
			}
		};
		
		networkUtilsTask.execute();
	}
	
	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		
		networkUtilsTask.cancel(true);
		networkUtilsTask = null;
	}


	public String networkUtils() {
		String result = "*************** NetworkUtils Test ***************\n";
		
		result += "isWifiConnected : " + networkUtils.isWifiConnected() + "\n";
		result += "isWifiEnabled : " + networkUtils.isWifiEnabled() + "\n";
		result += "isMobileConnected : " + networkUtils.isMobileConnected() + "\n";
		result += "getMobileState : " + networkUtils.getMobileState() + "\n";
		result += "isNetworkConnected : " + networkUtils.isNetworkConnected() + "\n";
		result += "isAirplaneModeOn : " + networkUtils.isAirplaneModeOn() + "\n";
		result += "getSimState : " + networkUtils.getSimState() + "\n";
		result += "getWifiConnectedPreviously : " + networkUtils.getWifiConnectedPreviously() + "\n";
		result += "getIpAddress(IPv4) : " + networkUtils.getIpAddress(false) + "\n";
		result += "getIpAddress(IPv6) : " + networkUtils.getIpAddress(true) + "\n";
		result += "getWifiMacAddress : " + networkUtils.getWifiMacAddress() + "\n";
		result += "isWifiStpuid : " + networkUtils.isWifiFake("173.194.72.105", 80) + "\n";
		result += "***************************************\n";
		
		return result;
	}
}
