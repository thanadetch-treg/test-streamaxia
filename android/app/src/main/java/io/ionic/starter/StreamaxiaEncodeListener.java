package io.ionic.starter;

import com.streamaxia.android.handlers.EncoderHandler;

public class StreamaxiaEncodeListener implements EncoderHandler.EncodeListener {

    @Override
    public void onNetworkWeak() {

    }

    @Override
    public void onNetworkResume() {

    }

    @Override
    public void onEncodeIllegalArgumentException(IllegalArgumentException e) {
        System.out.println("=================> onEncodeIllegalArgumentException: ");
        e.printStackTrace();
    }
}
