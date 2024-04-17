package de.pamlights.grandMA3Remote;

import android.os.AsyncTask;

import com.illposed.osc.OSCMessage;
import com.illposed.osc.transport.udp.OSCPortOut;

import java.net.InetAddress;
import java.util.Collections;

public class SendOSCMessageTask extends AsyncTask<String, Void, Void> {
    private static final String TARGET_IP = "192.168.1.196";
    private static final int TARGET_PORT = 9003;

    private OSCPortOut oscPortOut;

    @Override
    protected Void doInBackground(String... params) {


        try {
            oscPortOut = new OSCPortOut(InetAddress.getByName(TARGET_IP), TARGET_PORT);
        } catch (Exception e) {
            e.printStackTrace();
        }

        String address = params[0];
        String message = params[1];
        sendOSCMessage(address, message);
        return null;
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
    }


    private void sendOSCMessage(String address, String message) {
        if (oscPortOut != null) {
            try {
                OSCMessage msg = new OSCMessage(address, Collections.singletonList(message));

                oscPortOut.send(msg);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }
}
