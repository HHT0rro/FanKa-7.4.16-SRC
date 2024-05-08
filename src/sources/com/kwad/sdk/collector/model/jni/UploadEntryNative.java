package com.kwad.sdk.collector.model.jni;

import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import com.kwad.sdk.collector.AppStatusNative;
import com.kwad.sdk.collector.model.e;
import com.kwad.sdk.utils.t;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class UploadEntryNative extends NativeObject implements e {
    public UploadEntryNative(long j10) {
        this.mPtr = j10;
    }

    private String AE() {
        try {
            String uploadEntryGetPackageName = AppStatusNative.uploadEntryGetPackageName(this);
            String uploadEntryGetOriginFilePath = AppStatusNative.uploadEntryGetOriginFilePath(this);
            return uploadEntryGetOriginFilePath.substring(uploadEntryGetOriginFilePath.indexOf(uploadEntryGetPackageName)).replaceFirst(uploadEntryGetPackageName, "");
        } catch (Throwable unused) {
            return null;
        }
    }

    private static String a(UploadEntryNative uploadEntryNative) {
        return AppStatusNative.uploadEntryGetPackageName(uploadEntryNative);
    }

    @Override // com.kwad.sdk.collector.model.e
    @Nullable
    @WorkerThread
    public final JSONObject AC() {
        try {
            JSONObject jSONObject = new JSONObject();
            t.putValue(jSONObject, "packageName", AppStatusNative.uploadEntryGetPackageName(this));
            t.putValue(jSONObject, "content", com.kwad.sdk.collector.e.cs(AppStatusNative.uploadEntryGetOriginFilePath(this)));
            t.putValue(jSONObject, "fileName", AE());
            return jSONObject;
        } catch (Throwable unused) {
            return null;
        }
    }

    @Override // com.kwad.sdk.collector.model.jni.NativeObject
    public void destroy() {
        long j10 = this.mPtr;
        if (j10 != 0) {
            AppStatusNative.nativeDeleteUploadEntry(j10);
            this.mPtr = 0L;
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            UploadEntryNative uploadEntryNative = (UploadEntryNative) obj;
            String uploadEntryGetPackageName = AppStatusNative.uploadEntryGetPackageName(this);
            String uploadEntryGetOriginFilePath = AppStatusNative.uploadEntryGetOriginFilePath(this);
            if (uploadEntryGetPackageName == null ? a(uploadEntryNative) != null : !uploadEntryGetPackageName.equals(a(uploadEntryNative))) {
                return false;
            }
            if (uploadEntryGetOriginFilePath != null) {
                return uploadEntryGetOriginFilePath.equals(AppStatusNative.uploadEntryGetOriginFilePath(uploadEntryNative));
            }
            if (AppStatusNative.uploadEntryGetOriginFilePath(uploadEntryNative) == null) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        String uploadEntryGetPackageName = AppStatusNative.uploadEntryGetPackageName(this);
        String uploadEntryGetOriginFilePath = AppStatusNative.uploadEntryGetOriginFilePath(this);
        return ((uploadEntryGetPackageName != null ? uploadEntryGetPackageName.hashCode() : 0) * 31) + (uploadEntryGetOriginFilePath != null ? uploadEntryGetOriginFilePath.hashCode() : 0);
    }

    @Override // com.kwad.sdk.core.b
    public void parseJson(@Nullable JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        String optString = jSONObject.optString("packageName");
        String optString2 = jSONObject.optString("originFilePath");
        AppStatusNative.uploadEntrySetPackageName(this, optString);
        AppStatusNative.uploadEntrySetOriginFilePath(this, optString2);
    }

    @Override // com.kwad.sdk.core.b
    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        t.putValue(jSONObject, "packageName", AppStatusNative.uploadEntryGetPackageName(this));
        t.putValue(jSONObject, "originFilePath", AppStatusNative.uploadEntryGetOriginFilePath(this));
        return jSONObject;
    }

    public String toString() {
        return "UploadEntry{packageName='" + AppStatusNative.uploadEntryGetPackageName(this) + "', originFile=" + AppStatusNative.uploadEntryGetOriginFilePath(this) + '}';
    }

    public UploadEntryNative() {
        this.mPtr = AppStatusNative.nativeCreateUploadEntry();
    }
}
