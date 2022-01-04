package io.ionic.starter;

import android.Manifest;
import android.app.Activity;
import android.graphics.Color;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.webkit.WebView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.getcapacitor.PermissionState;
import com.getcapacitor.Plugin;
import com.getcapacitor.PluginCall;
import com.getcapacitor.PluginMethod;
import com.getcapacitor.annotation.CapacitorPlugin;
import com.getcapacitor.annotation.Permission;
import com.getcapacitor.annotation.PermissionCallback;
import com.streamaxia.android.CameraPreview;
import com.streamaxia.android.StreamaxiaPublisher;
import com.streamaxia.android.handlers.EncoderHandler;
import com.streamaxia.android.handlers.RtmpHandler;
import com.streamaxia.android.utils.Size;

import java.util.List;

@CapacitorPlugin(
        name = "Streamaxia",
        permissions = {
                @Permission(
                        alias = "camera",
                        strings = {Manifest.permission.CAMERA}
                ),
                @Permission(
                        alias = "storage",
                        strings = {
                                Manifest.permission.READ_EXTERNAL_STORAGE,
                                Manifest.permission.WRITE_EXTERNAL_STORAGE
                        }
                )
        })
public class StreamaxiaPlugin extends Plugin {

    private StreamaxiaPublisher mPublisher;
    private CameraPreview mCameraView;
    private RelativeLayout previewPlaceholder;

    @PluginMethod()
    public void startCamera(PluginCall call) {
        if (getPermissionState("camera") != PermissionState.GRANTED) {
            requestAllPermissions(call, "cameraPermsCallback");
        } else {
            loadCamera(call);
        }
    }

    @PluginMethod()
    public void startPublish(PluginCall call) {
        if (mPublisher != null) {
            mPublisher.startPublish("rtmp://rtmp.streamaxia.com/streamaxia/demo");
        }
    }

    @PluginMethod()
    public void stopPublish(PluginCall call) {
        if (mPublisher != null) {
            mPublisher.stopPublish();
        }
    }

    @PluginMethod()
    public void stopCamera(PluginCall call) {
        Activity activity = getActivity();

//        previewPlaceholder.removeAllViews();

        activity.runOnUiThread(() -> {
            ViewGroup rootView = (ViewGroup) previewPlaceholder.getParent();
            rootView.removeView(previewPlaceholder);

            mCameraView = null;
            mPublisher = null;
            previewPlaceholder = null;
        });


    }

    @PermissionCallback
    private void cameraPermsCallback(PluginCall call) {
        if (getPermissionState("camera") == PermissionState.GRANTED) {
            loadCamera(call);
        } else {
            call.reject("Permission is required to take a picture");
        }
    }

    void loadCamera(PluginCall call) {
        Activity activity = getActivity();
        WebView webView = bridge.getWebView();

        activity.runOnUiThread(() -> {

            activity.setContentView(R.layout.activity_stream);
            mCameraView = activity.findViewById(R.id.preview);
            mPublisher = new StreamaxiaPublisher(mCameraView, activity);

            mPublisher.setEncoderHandler(new EncoderHandler(new StreamaxiaEncodeListener()));
            mPublisher.setRtmpHandler(new RtmpHandler(new StreamaxiaRtmpListener()));

            mPublisher.setFramerate(30);
            mPublisher.setKeyframeInterval(5);

            mCameraView.startCamera();

            TextView textView = activity.findViewById(R.id.start_stop);
            textView.setOnClickListener(v -> mPublisher.startPublish("rtmp://vp-push-sgc.gvideo.co/in/166119?67db6b1d8d17cc6d7f5ca7583b85365c"));

        });


//        activity.runOnUiThread(() -> {
//
//            ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(
//                    ViewGroup.LayoutParams.MATCH_PARENT,
//                    ViewGroup.LayoutParams.MATCH_PARENT
//            );
//
//            ViewGroup.LayoutParams cameraLayoutParams = new ViewGroup.LayoutParams(
//                    ViewGroup.LayoutParams.MATCH_PARENT,
//                    ViewGroup.LayoutParams.MATCH_PARENT
//            );
//
//
//            mCameraView = new CameraPreview(activity);
//            mCameraView.setLayoutParams(cameraLayoutParams);
//
//            previewPlaceholder = new RelativeLayout(activity);
//            previewPlaceholder.setLayoutParams(layoutParams);
//            previewPlaceholder.setPadding(0, 400, 0, 0);
//
//
//            previewPlaceholder.addView(mCameraView);
//            activity.addContentView(previewPlaceholder, layoutParams);
//
//
//            mPublisher = new StreamaxiaPublisher(mCameraView, activity);
//            mPublisher.setEncoderHandler(new EncoderHandler(new StreamaxiaEncodeListener()));
//            mPublisher.setRtmpHandler(new RtmpHandler(new StreamaxiaRtmpListener()));
//
//            mPublisher.setFramerate(30);
//            mPublisher.setKeyframeInterval(5);
//
//            mCameraView.startCamera();
//
//            List<Size> sizes = mPublisher.getSupportedPictureSizes(activity.getResources().getConfiguration().orientation);
//            Size resolution = sizes.get(0);
//            mPublisher.setVideoOutputResolution(resolution.width, resolution.height, activity.getResources().getConfiguration().orientation);
//        });
    }

}
