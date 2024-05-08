package com.tencent.rtmp.video;

import android.app.Activity;
import android.content.Intent;
import android.media.projection.MediaProjection;
import android.media.projection.MediaProjectionManager;
import android.os.Bundle;
import com.tencent.liteav.base.util.LiteavLog;
import com.tencent.liteav.videoproducer.capture.VirtualDisplayManager;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class TXScreenCapture {

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static class TXScreenCaptureAssistantActivity extends Activity {
        private static final int REQUEST_CODE = 100;
        private static final String TAG = "TXScreenCaptureAssistantActivity";
        private MediaProjectionManager mMediaProjectionManager;

        @Override // android.app.Activity
        public void onActivityResult(int i10, int i11, Intent intent) {
            MediaProjection mediaProjection;
            LiteavLog.i(TAG, "onActivityResult ".concat(String.valueOf(this)));
            try {
                mediaProjection = this.mMediaProjectionManager.getMediaProjection(i11, intent);
            } catch (Throwable th) {
                LiteavLog.e(TAG, "onActivityResult mMediaProjectionManager.getMediaProjection fail.", th);
                mediaProjection = null;
            }
            VirtualDisplayManager.a(this).a(mediaProjection);
            finish();
        }

        @Override // android.app.Activity
        public void onCreate(Bundle bundle) {
            super.onCreate(bundle);
            LiteavLog.i(TAG, "onCreate ".concat(String.valueOf(this)));
            requestWindowFeature(1);
            MediaProjectionManager mediaProjectionManager = (MediaProjectionManager) getApplicationContext().getSystemService("media_projection");
            this.mMediaProjectionManager = mediaProjectionManager;
            try {
                startActivityForResult(mediaProjectionManager.createScreenCaptureIntent(), 100);
            } catch (Throwable th) {
                LiteavLog.e(TAG, "Start permission activity failed. ".concat(String.valueOf(th)));
                VirtualDisplayManager.a(this).a((MediaProjection) null);
                finish();
            }
        }

        @Override // android.app.Activity
        public void onDestroy() {
            super.onDestroy();
            LiteavLog.i(TAG, "onDestroy ".concat(String.valueOf(this)));
        }
    }
}
