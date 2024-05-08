package com.android.ims.internal.uce.presence;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public class PresRlmiInfo implements Parcelable {
    public static final Parcelable.Creator<PresRlmiInfo> CREATOR = new Parcelable.Creator<PresRlmiInfo>() { // from class: com.android.ims.internal.uce.presence.PresRlmiInfo.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public PresRlmiInfo createFromParcel(Parcel source) {
            return new PresRlmiInfo(source);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public PresRlmiInfo[] newArray(int size) {
            return new PresRlmiInfo[size];
        }
    };
    private boolean mFullState;
    private String mListName;
    private PresSubscriptionState mPresSubscriptionState;
    private int mRequestId;
    private int mSubscriptionExpireTime;
    private String mSubscriptionTerminatedReason;
    private String mUri;
    private int mVersion;

    public String getUri() {
        return this.mUri;
    }

    public void setUri(String uri) {
        this.mUri = uri;
    }

    public int getVersion() {
        return this.mVersion;
    }

    public void setVersion(int version) {
        this.mVersion = version;
    }

    public boolean isFullState() {
        return this.mFullState;
    }

    public void setFullState(boolean fullState) {
        this.mFullState = fullState;
    }

    public String getListName() {
        return this.mListName;
    }

    public void setListName(String listName) {
        this.mListName = listName;
    }

    public int getRequestId() {
        return this.mRequestId;
    }

    public void setRequestId(int requestId) {
        this.mRequestId = requestId;
    }

    public PresSubscriptionState getPresSubscriptionState() {
        return this.mPresSubscriptionState;
    }

    public void setPresSubscriptionState(PresSubscriptionState presSubscriptionState) {
        this.mPresSubscriptionState = presSubscriptionState;
    }

    public int getSubscriptionExpireTime() {
        return this.mSubscriptionExpireTime;
    }

    public void setSubscriptionExpireTime(int subscriptionExpireTime) {
        this.mSubscriptionExpireTime = subscriptionExpireTime;
    }

    public String getSubscriptionTerminatedReason() {
        return this.mSubscriptionTerminatedReason;
    }

    public void setSubscriptionTerminatedReason(String subscriptionTerminatedReason) {
        this.mSubscriptionTerminatedReason = subscriptionTerminatedReason;
    }

    public PresRlmiInfo() {
        this.mUri = "";
        this.mListName = "";
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeString(this.mUri);
        parcel.writeInt(this.mVersion);
        parcel.writeInt(this.mFullState ? 1 : 0);
        parcel.writeString(this.mListName);
        parcel.writeInt(this.mRequestId);
        parcel.writeParcelable(this.mPresSubscriptionState, i10);
        parcel.writeInt(this.mSubscriptionExpireTime);
        parcel.writeString(this.mSubscriptionTerminatedReason);
    }

    private PresRlmiInfo(Parcel source) {
        this.mUri = "";
        this.mListName = "";
        readFromParcel(source);
    }

    public void readFromParcel(Parcel source) {
        this.mUri = source.readString();
        this.mVersion = source.readInt();
        this.mFullState = source.readInt() != 0;
        this.mListName = source.readString();
        this.mRequestId = source.readInt();
        this.mPresSubscriptionState = (PresSubscriptionState) source.readParcelable(PresSubscriptionState.class.getClassLoader(), PresSubscriptionState.class);
        this.mSubscriptionExpireTime = source.readInt();
        this.mSubscriptionTerminatedReason = source.readString();
    }
}
