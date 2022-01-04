//package io.ionic.starter;
//
//import android.os.Bundle;
//import android.view.WindowManager;
//import android.widget.TextView;
//
//import androidx.appcompat.app.AppCompatActivity;
//
//import com.getcapacitor.BridgeActivity;
//import com.streamaxia.android.CameraPreview;
//import com.streamaxia.android.StreamaxiaPublisher;
//import com.streamaxia.android.handlers.EncoderHandler;
//import com.streamaxia.android.handlers.RecordHandler;
//import com.streamaxia.android.handlers.RtmpHandler;
//
//import java.io.IOException;
//import java.net.SocketException;
//
//public class MainActivity extends AppCompatActivity implements RtmpHandler.RtmpListener, RecordHandler.RecordListener,
//        EncoderHandler.EncodeListener {
//
//    CameraPreview mCameraView;
//    private StreamaxiaPublisher mPublisher;
//
//    @Override
//    public void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
//        setContentView(R.layout.activity_stream);
//
//        mCameraView = findViewById(R.id.preview);
//        mPublisher = new StreamaxiaPublisher(mCameraView, this);
//
//        mPublisher.setEncoderHandler(new EncoderHandler(this));
//        mPublisher.setRtmpHandler(new RtmpHandler(this));
//        mPublisher.setRecordEventHandler(new RecordHandler(this));
//
//        mPublisher.setFramerate(30);
//        mPublisher.setKeyframeInterval(5);
//
//        mCameraView.startCamera();
//
//        TextView textView = findViewById(R.id.start_stop);
//        textView.setOnClickListener(v -> mPublisher.startPublish("rtmp://vp-push-sgc.gvideo.co/in/166119?67db6b1d8d17cc6d7f5ca7583b85365c"));
//    }
//
//    @Override
//    public void onNetworkWeak() {
//
//    }
//
//    @Override
//    public void onNetworkResume() {
//
//    }
//
//    @Override
//    public void onEncodeIllegalArgumentException(IllegalArgumentException e) {
//
//    }
//
//    @Override
//    public void onRecordPause() {
//
//    }
//
//    @Override
//    public void onRecordResume() {
//
//    }
//
//    @Override
//    public void onRecordStarted(String s) {
//
//    }
//
//    @Override
//    public void onRecordFinished(String s) {
//
//    }
//
//    @Override
//    public void onRecordIllegalArgumentException(IllegalArgumentException e) {
//
//    }
//
//    @Override
//    public void onRecordIOException(IOException e) {
//
//    }
//
//    @Override
//    public void onRtmpConnecting(String s) {
//
//    }
//
//    @Override
//    public void onRtmpConnected(String s) {
//
//    }
//
//    @Override
//    public void onRtmpVideoStreaming() {
//
//    }
//
//    @Override
//    public void onRtmpAudioStreaming() {
//
//    }
//
//    @Override
//    public void onRtmpStopped() {
//
//    }
//
//    @Override
//    public void onRtmpDisconnected() {
//
//    }
//
//    @Override
//    public void onRtmpVideoFpsChanged(double v) {
//
//    }
//
//    @Override
//    public void onRtmpVideoBitrateChanged(double v) {
//
//    }
//
//    @Override
//    public void onRtmpAudioBitrateChanged(double v) {
//
//    }
//
//    @Override
//    public void onRtmpBitrateChanged(double v) {
//
//    }
//
//    @Override
//    public void onRtmpSocketException(SocketException e) {
//
//    }
//
//    @Override
//    public void onRtmpIOException(IOException e) {
//
//    }
//
//    @Override
//    public void onRtmpIllegalArgumentException(IllegalArgumentException e) {
//
//    }
//
//    @Override
//    public void onRtmpIllegalStateException(IllegalStateException e) {
//
//    }
//
//    @Override
//    public void onRtmpAuthenticationg(String s) {
//
//    }
//}


package io.ionic.starter;

import android.os.Bundle;

import com.getcapacitor.BridgeActivity;

public class MainActivity extends BridgeActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        registerPlugin(EchoPlugin.class);
        registerPlugin(StreamaxiaPlugin.class);
    }
}
