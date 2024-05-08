package com.android.internal.app;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.location.LocationManagerInternal;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import com.android.internal.app.AlertController;
import com.android.internal.location.GpsNetInitiatedHandler;
import com.android.server.LocalServices;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public class NetInitiatedActivity extends AlertActivity implements DialogInterface.OnClickListener {
    private static final boolean DEBUG = true;
    private static final int GPS_NO_RESPONSE_TIME_OUT = 1;
    private static final int NEGATIVE_BUTTON = -2;
    private static final int POSITIVE_BUTTON = -1;
    private static final String TAG = "NetInitiatedActivity";
    private int notificationId = -1;
    private int timeout = -1;
    private int default_response = -1;
    private int default_response_timeout = 6;
    private final Handler mHandler = new Handler() { // from class: com.android.internal.app.NetInitiatedActivity.1
        @Override // android.os.Handler
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 1:
                    if (NetInitiatedActivity.this.notificationId != -1) {
                        NetInitiatedActivity netInitiatedActivity = NetInitiatedActivity.this;
                        netInitiatedActivity.sendUserResponse(netInitiatedActivity.default_response);
                    }
                    NetInitiatedActivity.this.finish();
                    return;
                default:
                    return;
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.android.internal.app.AlertActivity, android.app.Activity
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().addSystemFlags(524288);
        Intent intent = getIntent();
        AlertController.AlertParams p10 = this.mAlertParams;
        Context context = getApplicationContext();
        p10.mTitle = intent.getStringExtra("title");
        p10.mMessage = intent.getStringExtra("message");
        p10.mPositiveButtonText = String.format(context.getString(17040465), new Object[0]);
        p10.mPositiveButtonListener = this;
        p10.mNegativeButtonText = String.format(context.getString(17040464), new Object[0]);
        p10.mNegativeButtonListener = this;
        this.notificationId = intent.getIntExtra("notif_id", -1);
        this.timeout = intent.getIntExtra("timeout", this.default_response_timeout);
        this.default_response = intent.getIntExtra(GpsNetInitiatedHandler.NI_INTENT_KEY_DEFAULT_RESPONSE, 1);
        Log.d(TAG, "onCreate() : notificationId: " + this.notificationId + " timeout: " + this.timeout + " default_response:" + this.default_response);
        Handler handler = this.mHandler;
        handler.sendMessageDelayed(handler.obtainMessage(1), this.timeout * 1000);
        setupAlert();
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume");
    }

    @Override // android.app.Activity
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause");
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialog, int which) {
        if (which == -1) {
            sendUserResponse(1);
        }
        if (which == -2) {
            sendUserResponse(2);
        }
        finish();
        this.notificationId = -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendUserResponse(int response) {
        Log.d(TAG, "sendUserResponse, response: " + response);
        LocationManagerInternal lm = (LocationManagerInternal) LocalServices.getService(LocationManagerInternal.class);
        lm.sendNiResponse(this.notificationId, response);
    }
}
