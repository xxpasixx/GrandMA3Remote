package de.pamlights.grandMA3Remote.ui.settings;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class SettingsViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    private final MutableLiveData<String> sendIpAddress;

    private final MutableLiveData<Integer> sendPort;

    public SettingsViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is Settings fragment");

        sendIpAddress = new MutableLiveData<>();
        sendPort = new MutableLiveData<>();

        setSendPort(8000);
        setSendIpAddress("192.168.1.196");
    }

    public LiveData<String> getText() {
        return mText;
    }

    public MutableLiveData<String> getSendIpAddress() {
        return sendIpAddress;
    }

    public void setSendIpAddress(String sendIpAddress) {
        this.sendIpAddress.setValue(sendIpAddress);
    }

    public MutableLiveData<Integer> getSendPort() {
        return sendPort;
    }

    public void setSendPort(Integer sendPort) {
        this.sendPort.setValue(sendPort);
    }
}