package com.huawei.hmf.orb.aidl.client;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.IntentSender;
import java.util.Arrays;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public final class Status {
    private PendingIntent mPendingIntent;
    private int statusCode;
    private String statusMessage;
    public static final Status SUCCESS = new Status(0);
    public static final Status MessageNotFound = new Status(404);
    public static final Status CoreException = new Status(500);

    public Status(int i10) {
        this(i10, null);
    }

    public static boolean equal(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Status)) {
            return false;
        }
        Status status = (Status) obj;
        return this.statusCode == status.statusCode && equal(this.statusMessage, status.statusMessage) && equal(this.mPendingIntent, status.mPendingIntent);
    }

    public PendingIntent getResolution() {
        return this.mPendingIntent;
    }

    public int getStatusCode() {
        return this.statusCode;
    }

    public String getStatusMessage() {
        return this.statusMessage;
    }

    public boolean hasResolution() {
        return this.mPendingIntent != null;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.statusCode), this.statusMessage, this.mPendingIntent});
    }

    public boolean isSuccess() {
        return this.statusCode <= 0;
    }

    public void startResolutionForResult(Activity activity, int i10) throws IntentSender.SendIntentException {
        if (hasResolution()) {
            activity.startIntentSenderForResult(this.mPendingIntent.getIntentSender(), i10, null, 0, 0, 0);
        }
    }

    public String toString() {
        return Status.class.getName() + " {\n\tstatusCode: " + this.statusCode + "\n\tstatusMessage: " + this.statusMessage + "\n\tmPendingIntent: " + ((Object) this.mPendingIntent) + "\n}";
    }

    public Status(int i10, String str) {
        this(i10, str, null);
    }

    public Status(int i10, String str, PendingIntent pendingIntent) {
        this.statusCode = i10;
        this.statusMessage = str;
        this.mPendingIntent = pendingIntent;
    }
}
