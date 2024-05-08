package com.google.android.gms.common;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.IntentSender;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RecentlyNonNull;
import androidx.annotation.RecentlyNullable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.huawei.hms.framework.network.grs.GrsBaseInfo;
import com.huawei.hms.mlsdk.common.internal.client.event.MonitorResult;

/* compiled from: com.google.android.gms:play-services-basement@@17.4.0 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class ConnectionResult extends AbstractSafeParcelable {

    @RecentlyNonNull
    public static final int API_UNAVAILABLE = 16;

    @RecentlyNonNull
    public static final int CANCELED = 13;

    @RecentlyNonNull
    public static final int DEVELOPER_ERROR = 10;

    @RecentlyNonNull
    @Deprecated
    public static final int DRIVE_EXTERNAL_STORAGE_REQUIRED = 1500;

    @RecentlyNonNull
    public static final int INTERNAL_ERROR = 8;

    @RecentlyNonNull
    public static final int INTERRUPTED = 15;

    @RecentlyNonNull
    public static final int INVALID_ACCOUNT = 5;

    @RecentlyNonNull
    public static final int LICENSE_CHECK_FAILED = 11;

    @RecentlyNonNull
    public static final int NETWORK_ERROR = 7;

    @RecentlyNonNull
    public static final int RESOLUTION_ACTIVITY_NOT_FOUND = 22;

    @RecentlyNonNull
    public static final int RESOLUTION_REQUIRED = 6;

    @RecentlyNonNull
    public static final int RESTRICTED_PROFILE = 20;

    @RecentlyNonNull
    public static final int SERVICE_DISABLED = 3;

    @RecentlyNonNull
    public static final int SERVICE_INVALID = 9;

    @RecentlyNonNull
    public static final int SERVICE_MISSING = 1;

    @RecentlyNonNull
    public static final int SERVICE_MISSING_PERMISSION = 19;

    @RecentlyNonNull
    public static final int SERVICE_UPDATING = 18;

    @RecentlyNonNull
    public static final int SERVICE_VERSION_UPDATE_REQUIRED = 2;

    @RecentlyNonNull
    public static final int SIGN_IN_FAILED = 17;

    @RecentlyNonNull
    public static final int SIGN_IN_REQUIRED = 4;

    @RecentlyNonNull
    public static final int SUCCESS = 0;

    @RecentlyNonNull
    public static final int TIMEOUT = 14;

    @RecentlyNonNull
    public static final int UNKNOWN = -1;
    private final int zza;
    private final int zzb;

    @Nullable
    private final PendingIntent zzc;

    @Nullable
    private final String zzd;

    @RecentlyNonNull
    public static final ConnectionResult RESULT_SUCCESS = new ConnectionResult(0);

    @RecentlyNonNull
    public static final Parcelable.Creator<ConnectionResult> CREATOR = new f();

    public ConnectionResult(int i10, int i11, @Nullable PendingIntent pendingIntent, @Nullable String str) {
        this.zza = i10;
        this.zzb = i11;
        this.zzc = pendingIntent;
        this.zzd = str;
    }

    @NonNull
    public static String zza(int i10) {
        if (i10 == 99) {
            return "UNFINISHED";
        }
        if (i10 == 1500) {
            return "DRIVE_EXTERNAL_STORAGE_REQUIRED";
        }
        switch (i10) {
            case -1:
                return GrsBaseInfo.CountryCodeSource.UNKNOWN;
            case 0:
                return MonitorResult.SUCCESS;
            case 1:
                return "SERVICE_MISSING";
            case 2:
                return "SERVICE_VERSION_UPDATE_REQUIRED";
            case 3:
                return "SERVICE_DISABLED";
            case 4:
                return "SIGN_IN_REQUIRED";
            case 5:
                return "INVALID_ACCOUNT";
            case 6:
                return "RESOLUTION_REQUIRED";
            case 7:
                return "NETWORK_ERROR";
            case 8:
                return "INTERNAL_ERROR";
            case 9:
                return "SERVICE_INVALID";
            case 10:
                return "DEVELOPER_ERROR";
            case 11:
                return "LICENSE_CHECK_FAILED";
            default:
                switch (i10) {
                    case 13:
                        return "CANCELED";
                    case 14:
                        return "TIMEOUT";
                    case 15:
                        return "INTERRUPTED";
                    case 16:
                        return "API_UNAVAILABLE";
                    case 17:
                        return "SIGN_IN_FAILED";
                    case 18:
                        return "SERVICE_UPDATING";
                    case 19:
                        return "SERVICE_MISSING_PERMISSION";
                    case 20:
                        return "RESTRICTED_PROFILE";
                    case 21:
                        return "API_VERSION_UPDATE_REQUIRED";
                    case 22:
                        return "RESOLUTION_ACTIVITY_NOT_FOUND";
                    default:
                        StringBuilder sb2 = new StringBuilder(31);
                        sb2.append("UNKNOWN_ERROR_CODE(");
                        sb2.append(i10);
                        sb2.append(")");
                        return sb2.toString();
                }
        }
    }

    @RecentlyNonNull
    public final boolean equals(@Nullable Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ConnectionResult)) {
            return false;
        }
        ConnectionResult connectionResult = (ConnectionResult) obj;
        return this.zzb == connectionResult.zzb && com.google.android.gms.common.internal.g.a(this.zzc, connectionResult.zzc) && com.google.android.gms.common.internal.g.a(this.zzd, connectionResult.zzd);
    }

    @RecentlyNonNull
    public final int getErrorCode() {
        return this.zzb;
    }

    @RecentlyNullable
    public final String getErrorMessage() {
        return this.zzd;
    }

    @RecentlyNullable
    public final PendingIntent getResolution() {
        return this.zzc;
    }

    @RecentlyNonNull
    public final boolean hasResolution() {
        return (this.zzb == 0 || this.zzc == null) ? false : true;
    }

    @RecentlyNonNull
    public final int hashCode() {
        return com.google.android.gms.common.internal.g.b(Integer.valueOf(this.zzb), this.zzc, this.zzd);
    }

    @RecentlyNonNull
    public final boolean isSuccess() {
        return this.zzb == 0;
    }

    public final void startResolutionForResult(@RecentlyNonNull Activity activity, @RecentlyNonNull int i10) throws IntentSender.SendIntentException {
        if (hasResolution()) {
            activity.startIntentSenderForResult(((PendingIntent) com.google.android.gms.common.internal.h.h(this.zzc)).getIntentSender(), i10, null, 0, 0, 0);
        }
    }

    @RecentlyNonNull
    public final String toString() {
        return com.google.android.gms.common.internal.g.c(this).a("statusCode", zza(this.zzb)).a("resolution", this.zzc).a("message", this.zzd).toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(@RecentlyNonNull Parcel parcel, @RecentlyNonNull int i10) {
        int a10 = w6.a.a(parcel);
        w6.a.j(parcel, 1, this.zza);
        w6.a.j(parcel, 2, getErrorCode());
        w6.a.n(parcel, 3, getResolution(), i10, false);
        w6.a.o(parcel, 4, getErrorMessage(), false);
        w6.a.b(parcel, a10);
    }

    public ConnectionResult(@RecentlyNonNull int i10) {
        this(i10, null, null);
    }

    public ConnectionResult(@RecentlyNonNull int i10, @Nullable PendingIntent pendingIntent) {
        this(i10, pendingIntent, null);
    }

    public ConnectionResult(@RecentlyNonNull int i10, @Nullable PendingIntent pendingIntent, @Nullable String str) {
        this(1, i10, pendingIntent, str);
    }
}
