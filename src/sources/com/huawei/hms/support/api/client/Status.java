package com.huawei.hms.support.api.client;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.IntentSender;
import android.os.Parcel;
import android.os.Parcelable;
import com.huawei.hms.core.aidl.annotation.Packed;
import java.util.Arrays;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public final class Status extends Result implements Parcelable {

    @Packed
    private Intent intent;

    @Packed
    private PendingIntent pendingIntent;

    @Packed
    private int statusCode;

    @Packed
    private String statusMessage;
    public static final Status SUCCESS = new Status(0);
    public static final Status FAILURE = new Status(1);

    @Deprecated
    public static final Status RESULT_CANCELED = new Status(16);

    @Deprecated
    public static final Status RESULT_DEAD_CLIENT = new Status(18);

    @Deprecated
    public static final Status RESULT_INTERNAL_ERROR = new Status(8);

    @Deprecated
    public static final Status RESULT_INTERRUPTED = new Status(14);

    @Deprecated
    public static final Status RESULT_TIMEOUT = new Status(15);
    public static final Status MessageNotFound = new Status(404);
    public static final Status CoreException = new Status(500);
    public static final Parcelable.Creator<Status> CREATOR = new a();

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public class a implements Parcelable.Creator {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Status createFromParcel(Parcel parcel) {
            return new Status(parcel.readInt(), parcel.readString(), PendingIntent.readPendingIntentOrNullFromParcel(parcel));
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Status[] newArray(int i10) {
            return new Status[i10];
        }
    }

    public Status(int i10) {
        this(i10, null);
    }

    private static boolean equal(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Status)) {
            return false;
        }
        Status status = (Status) obj;
        return this.statusCode == status.statusCode && equal(this.statusMessage, status.statusMessage) && equal(this.pendingIntent, status.pendingIntent) && equal(this.intent, status.intent);
    }

    public String getErrorString() {
        return getStatusMessage();
    }

    public PendingIntent getResolution() {
        return this.pendingIntent;
    }

    public Intent getResolutionIntent() {
        return this.intent;
    }

    @Override // com.huawei.hms.support.api.client.Result
    public Status getStatus() {
        return this;
    }

    public int getStatusCode() {
        return this.statusCode;
    }

    public String getStatusMessage() {
        return this.statusMessage;
    }

    public boolean hasResolution() {
        return (this.pendingIntent == null && this.intent == null) ? false : true;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.statusCode), this.statusMessage, this.pendingIntent, this.intent});
    }

    public boolean isCanceled() {
        return false;
    }

    public boolean isInterrupted() {
        return false;
    }

    public boolean isSuccess() {
        return this.statusCode <= 0;
    }

    public void setIntent(Intent intent) {
        this.intent = intent;
    }

    public void setPendingIntent(PendingIntent pendingIntent) {
        this.pendingIntent = pendingIntent;
    }

    public void startResolutionForResult(Activity activity, int i10) throws IntentSender.SendIntentException {
        if (activity != null && hasResolution()) {
            PendingIntent pendingIntent = this.pendingIntent;
            if (pendingIntent != null) {
                activity.startIntentSenderForResult(pendingIntent.getIntentSender(), i10, null, 0, 0, 0);
            } else {
                activity.startActivityForResult(this.intent, i10);
            }
        }
    }

    public String toString() {
        return "{statusCode: " + this.statusCode + ", statusMessage: " + this.statusMessage + ", pendingIntent: " + ((Object) this.pendingIntent) + ", intent: " + ((Object) this.intent) + ",}";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        if (parcel == null) {
            return;
        }
        parcel.writeInt(this.statusCode);
        parcel.writeString(this.statusMessage);
        PendingIntent pendingIntent = this.pendingIntent;
        if (pendingIntent != null) {
            pendingIntent.writeToParcel(parcel, i10);
        }
        PendingIntent.writePendingIntentOrNullToParcel(this.pendingIntent, parcel);
        Intent intent = this.intent;
        if (intent != null) {
            intent.writeToParcel(parcel, i10);
        }
    }

    public Status(int i10, String str) {
        this.statusCode = i10;
        this.statusMessage = str;
    }

    public Status(int i10, String str, PendingIntent pendingIntent) {
        this.statusCode = i10;
        this.statusMessage = str;
        this.pendingIntent = pendingIntent;
    }

    public Status(int i10, String str, Intent intent) {
        this.statusCode = i10;
        this.statusMessage = str;
        this.intent = intent;
    }
}
