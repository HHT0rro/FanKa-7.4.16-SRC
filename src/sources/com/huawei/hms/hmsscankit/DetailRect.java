package com.huawei.hms.hmsscankit;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class DetailRect implements Parcelable {
    public static final String CP_PACKAGE = "PackageName";
    public static final Parcelable.Creator<DetailRect> CREATOR = new a();
    public static final String CUSTOMED_FLAG = "CustomedFlag";
    public static final String DEEPLINK_BACK_COLOR = "DeepLinkColor";
    public static final String DEEPLINK_JUMP_FLAG = "DeepLinkJumpFlag";
    public static final String DEEPLINK_VALUE = "DeepLinkValue";
    public static final int DEFALT_HMS_SCAN_VERSIONU = 0;
    public static final String FORMAT_FLAG = "FormatValue";
    public static int HMSSCAN_SDK_VALUE = 3;
    public static final String NEW_VERSION = "NewVersion";
    public static final String PARSE_RESULT = "ParseResult";
    public static final String PHOTO_MODE = "PhotoMode";
    public static final String RECT_FLAG = "RectValue";
    public static final String RETURN_BITMAP = "return_bitmap";
    public static final String SCAN_CAMERA_PERMISSION = "ScanCameraPermission";
    public static final String SCAN_LOCAL_DECODER = "localdecoder";
    public static final String SCAN_NEW_UI = "localui";
    public static final String SCAN_OFFSCEEN_FLAG = "ScanOffSceenFlag";
    public static final String SCAN_VIEWTYPE_FLAG = "ScanViewTypeFlag";
    public static final String SUPPORT_ROLLBACK = "ROLLBACK";
    public static final String TYPE_TRANS = "TransType";
    public static final String USE_APK = "USEAPK";
    public static final int VALUE_HMS_SCAN_VERSION = 3;
    public int height;
    public int width;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public class a implements Parcelable.Creator<DetailRect> {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public DetailRect createFromParcel(Parcel parcel) {
            return new DetailRect(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public DetailRect[] newArray(int i10) {
            return new DetailRect[i10];
        }
    }

    public DetailRect() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeInt(this.width);
        parcel.writeInt(this.height);
    }

    public DetailRect(int i10, int i11) {
        this.width = i10;
        this.height = i11;
    }

    public DetailRect(Parcel parcel) {
        this.width = parcel.readInt();
        this.height = parcel.readInt();
    }
}
