package io.ionic.starter;

import com.streamaxia.android.handlers.RtmpHandler;

import java.io.IOException;
import java.net.SocketException;

public class StreamaxiaRtmpListener implements RtmpHandler.RtmpListener {

    @Override
    public void onRtmpConnecting(String s) {
        System.out.println("=================> onRtmpConnecting: " + s);
    }

    @Override
    public void onRtmpConnected(String s) {
        System.out.println("=================> onRtmpConnected: " + s);
    }

    @Override
    public void onRtmpVideoStreaming() {

    }

    @Override
    public void onRtmpAudioStreaming() {

    }

    @Override
    public void onRtmpStopped() {

    }

    @Override
    public void onRtmpDisconnected() {

    }

    @Override
    public void onRtmpVideoFpsChanged(double v) {

    }

    @Override
    public void onRtmpVideoBitrateChanged(double v) {

    }

    @Override
    public void onRtmpAudioBitrateChanged(double v) {

    }

    @Override
    public void onRtmpBitrateChanged(double v) {

    }

    @Override
    public void onRtmpSocketException(SocketException e) {
        System.out.println("=================> onRtmpSocketException: ");
        e.printStackTrace();
    }

    @Override
    public void onRtmpIOException(IOException e) {
        System.out.println("=================> onRtmpIOException: ");
        e.printStackTrace();
    }

    @Override
    public void onRtmpIllegalArgumentException(IllegalArgumentException e) {
        System.out.println("=================> onRtmpIllegalArgumentException: ");
        e.printStackTrace();
    }

    @Override
    public void onRtmpIllegalStateException(IllegalStateException e) {
        System.out.println("=================> onRtmpIllegalStateException: ");
        e.printStackTrace();

    }

    @Override
    public void onRtmpAuthenticationg(String msg) {
        System.out.println("=================> onRtmpAuthenticationg: " + "[" + msg + "]");
    }


}
