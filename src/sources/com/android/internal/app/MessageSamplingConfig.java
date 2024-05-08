package com.android.internal.app;

import android.annotation.IntRange;
import android.os.Parcel;
import android.os.Parcelable;
import com.android.internal.util.AnnotationValidations;
import com.huawei.hms.push.constant.RemoteMessageConst;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public final class MessageSamplingConfig implements Parcelable {
    public static final Parcelable.Creator<MessageSamplingConfig> CREATOR = new Parcelable.Creator<MessageSamplingConfig>() { // from class: com.android.internal.app.MessageSamplingConfig.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public MessageSamplingConfig[] newArray(int size) {
            return new MessageSamplingConfig[size];
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public MessageSamplingConfig createFromParcel(Parcel in) {
            return new MessageSamplingConfig(in);
        }
    };
    private final int mAcceptableLeftDistance;
    private final long mExpirationTimeSinceBootMillis;
    private final int mSampledOpCode;

    public MessageSamplingConfig(int sampledOpCode, int acceptableLeftDistance, long expirationTimeSinceBootMillis) {
        this.mSampledOpCode = sampledOpCode;
        AnnotationValidations.validate(IntRange.class, (IntRange) null, sampledOpCode, RemoteMessageConst.FROM, -1L, RemoteMessageConst.TO, 135L);
        this.mAcceptableLeftDistance = acceptableLeftDistance;
        AnnotationValidations.validate(IntRange.class, (IntRange) null, acceptableLeftDistance, RemoteMessageConst.FROM, 0L, RemoteMessageConst.TO, 135L);
        this.mExpirationTimeSinceBootMillis = expirationTimeSinceBootMillis;
        AnnotationValidations.validate(IntRange.class, (IntRange) null, expirationTimeSinceBootMillis, RemoteMessageConst.FROM, 0L);
    }

    public int getSampledOpCode() {
        return this.mSampledOpCode;
    }

    public int getAcceptableLeftDistance() {
        return this.mAcceptableLeftDistance;
    }

    public long getExpirationTimeSinceBootMillis() {
        return this.mExpirationTimeSinceBootMillis;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.mSampledOpCode);
        dest.writeInt(this.mAcceptableLeftDistance);
        dest.writeLong(this.mExpirationTimeSinceBootMillis);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    MessageSamplingConfig(Parcel in) {
        int sampledOpCode = in.readInt();
        int acceptableLeftDistance = in.readInt();
        long expirationTimeSinceBootMillis = in.readLong();
        this.mSampledOpCode = sampledOpCode;
        AnnotationValidations.validate(IntRange.class, (IntRange) null, sampledOpCode, RemoteMessageConst.FROM, -1L, RemoteMessageConst.TO, 135L);
        this.mAcceptableLeftDistance = acceptableLeftDistance;
        AnnotationValidations.validate(IntRange.class, (IntRange) null, acceptableLeftDistance, RemoteMessageConst.FROM, 0L, RemoteMessageConst.TO, 135L);
        this.mExpirationTimeSinceBootMillis = expirationTimeSinceBootMillis;
        AnnotationValidations.validate(IntRange.class, (IntRange) null, expirationTimeSinceBootMillis, RemoteMessageConst.FROM, 0L);
    }

    @Deprecated
    private void __metadata() {
    }
}
