package com.amap.api.fence;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.amap.api.location.AMapLocation;
import com.amap.api.location.DPoint;
import com.autonavi.aps.amapapi.utils.j;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class GeoFence implements Parcelable {
    public static final int ADDGEOFENCE_SUCCESS = 0;
    public static final String BUNDLE_KEY_CUSTOMID = "customId";
    public static final String BUNDLE_KEY_FENCE = "fence";
    public static final String BUNDLE_KEY_FENCEID = "fenceid";
    public static final String BUNDLE_KEY_FENCESTATUS = "event";
    public static final String BUNDLE_KEY_LOCERRORCODE = "location_errorcode";
    public static final Parcelable.Creator<GeoFence> CREATOR = new Parcelable.Creator<GeoFence>() { // from class: com.amap.api.fence.GeoFence.1
        private static GeoFence a(Parcel parcel) {
            return new GeoFence(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ GeoFence createFromParcel(Parcel parcel) {
            return a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ GeoFence[] newArray(int i10) {
            return a(i10);
        }

        private static GeoFence[] a(int i10) {
            return new GeoFence[i10];
        }
    };
    public static final int ERROR_CODE_EXISTS = 17;
    public static final int ERROR_CODE_FAILURE_AUTH = 7;
    public static final int ERROR_CODE_FAILURE_CONNECTION = 4;
    public static final int ERROR_CODE_FAILURE_PARSER = 5;
    public static final int ERROR_CODE_INVALID_PARAMETER = 1;
    public static final int ERROR_CODE_UNKNOWN = 8;
    public static final int ERROR_NO_VALIDFENCE = 16;
    public static final int STATUS_IN = 1;
    public static final int STATUS_LOCFAIL = 4;
    public static final int STATUS_OUT = 2;
    public static final int STATUS_STAYED = 3;
    public static final int STATUS_UNKNOWN = 0;
    public static final int TYPE_AMAPPOI = 2;
    public static final int TYPE_DISTRICT = 3;
    public static final int TYPE_POLYGON = 1;
    public static final int TYPE_ROUND = 0;

    /* renamed from: a, reason: collision with root package name */
    private String f8026a;

    /* renamed from: b, reason: collision with root package name */
    private String f8027b;

    /* renamed from: c, reason: collision with root package name */
    private String f8028c;

    /* renamed from: d, reason: collision with root package name */
    private PendingIntent f8029d;

    /* renamed from: e, reason: collision with root package name */
    private int f8030e;

    /* renamed from: f, reason: collision with root package name */
    private PoiItem f8031f;

    /* renamed from: g, reason: collision with root package name */
    private List<DistrictItem> f8032g;

    /* renamed from: h, reason: collision with root package name */
    private List<List<DPoint>> f8033h;

    /* renamed from: i, reason: collision with root package name */
    private float f8034i;

    /* renamed from: j, reason: collision with root package name */
    private long f8035j;

    /* renamed from: k, reason: collision with root package name */
    private int f8036k;

    /* renamed from: l, reason: collision with root package name */
    private float f8037l;

    /* renamed from: m, reason: collision with root package name */
    private float f8038m;

    /* renamed from: n, reason: collision with root package name */
    private DPoint f8039n;

    /* renamed from: o, reason: collision with root package name */
    private int f8040o;

    /* renamed from: p, reason: collision with root package name */
    private long f8041p;

    /* renamed from: q, reason: collision with root package name */
    private boolean f8042q;

    /* renamed from: r, reason: collision with root package name */
    private AMapLocation f8043r;

    public GeoFence() {
        this.f8029d = null;
        this.f8030e = 0;
        this.f8031f = null;
        this.f8032g = null;
        this.f8034i = 0.0f;
        this.f8035j = -1L;
        this.f8036k = 1;
        this.f8037l = 0.0f;
        this.f8038m = 0.0f;
        this.f8039n = null;
        this.f8040o = 0;
        this.f8041p = -1L;
        this.f8042q = true;
        this.f8043r = null;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof GeoFence)) {
            return false;
        }
        GeoFence geoFence = (GeoFence) obj;
        if (TextUtils.isEmpty(this.f8027b)) {
            if (!TextUtils.isEmpty(geoFence.f8027b)) {
                return false;
            }
        } else if (!this.f8027b.equals(geoFence.f8027b)) {
            return false;
        }
        DPoint dPoint = this.f8039n;
        if (dPoint == null) {
            if (geoFence.f8039n != null) {
                return false;
            }
        } else if (!dPoint.equals(geoFence.f8039n)) {
            return false;
        }
        if (this.f8034i != geoFence.f8034i) {
            return false;
        }
        List<List<DPoint>> list = this.f8033h;
        return list == null ? geoFence.f8033h == null : list.equals(geoFence.f8033h);
    }

    public int getActivatesAction() {
        return this.f8036k;
    }

    public DPoint getCenter() {
        return this.f8039n;
    }

    public AMapLocation getCurrentLocation() {
        return this.f8043r;
    }

    public String getCustomId() {
        return this.f8027b;
    }

    public List<DistrictItem> getDistrictItemList() {
        return this.f8032g;
    }

    public long getEnterTime() {
        return this.f8041p;
    }

    public long getExpiration() {
        return this.f8035j;
    }

    public String getFenceId() {
        return this.f8026a;
    }

    public float getMaxDis2Center() {
        return this.f8038m;
    }

    public float getMinDis2Center() {
        return this.f8037l;
    }

    public PendingIntent getPendingIntent() {
        return this.f8029d;
    }

    public String getPendingIntentAction() {
        return this.f8028c;
    }

    public PoiItem getPoiItem() {
        return this.f8031f;
    }

    public List<List<DPoint>> getPointList() {
        return this.f8033h;
    }

    public float getRadius() {
        return this.f8034i;
    }

    public int getStatus() {
        return this.f8040o;
    }

    public int getType() {
        return this.f8030e;
    }

    public int hashCode() {
        return this.f8027b.hashCode() + this.f8033h.hashCode() + this.f8039n.hashCode() + ((int) (this.f8034i * 100.0f));
    }

    public boolean isAble() {
        return this.f8042q;
    }

    public void setAble(boolean z10) {
        this.f8042q = z10;
    }

    public void setActivatesAction(int i10) {
        this.f8036k = i10;
    }

    public void setCenter(DPoint dPoint) {
        this.f8039n = dPoint;
    }

    public void setCurrentLocation(AMapLocation aMapLocation) {
        this.f8043r = aMapLocation.m1956clone();
    }

    public void setCustomId(String str) {
        this.f8027b = str;
    }

    public void setDistrictItemList(List<DistrictItem> list) {
        this.f8032g = list;
    }

    public void setEnterTime(long j10) {
        this.f8041p = j10;
    }

    public void setExpiration(long j10) {
        if (j10 < 0) {
            this.f8035j = -1L;
        } else {
            this.f8035j = j10 + j.b();
        }
    }

    public void setFenceId(String str) {
        this.f8026a = str;
    }

    public void setMaxDis2Center(float f10) {
        this.f8038m = f10;
    }

    public void setMinDis2Center(float f10) {
        this.f8037l = f10;
    }

    public void setPendingIntent(PendingIntent pendingIntent) {
        this.f8029d = pendingIntent;
    }

    public void setPendingIntentAction(String str) {
        this.f8028c = str;
    }

    public void setPoiItem(PoiItem poiItem) {
        this.f8031f = poiItem;
    }

    public void setPointList(List<List<DPoint>> list) {
        this.f8033h = list;
    }

    public void setRadius(float f10) {
        this.f8034i = f10;
    }

    public void setStatus(int i10) {
        this.f8040o = i10;
    }

    public void setType(int i10) {
        this.f8030e = i10;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeString(this.f8026a);
        parcel.writeString(this.f8027b);
        parcel.writeString(this.f8028c);
        parcel.writeParcelable(this.f8029d, i10);
        parcel.writeInt(this.f8030e);
        parcel.writeParcelable(this.f8031f, i10);
        parcel.writeTypedList(this.f8032g);
        parcel.writeFloat(this.f8034i);
        parcel.writeLong(this.f8035j);
        parcel.writeInt(this.f8036k);
        parcel.writeFloat(this.f8037l);
        parcel.writeFloat(this.f8038m);
        parcel.writeParcelable(this.f8039n, i10);
        parcel.writeInt(this.f8040o);
        parcel.writeLong(this.f8041p);
        List<List<DPoint>> list = this.f8033h;
        if (list != null && !list.isEmpty()) {
            parcel.writeInt(this.f8033h.size());
            Iterator<List<DPoint>> iterator2 = this.f8033h.iterator2();
            while (iterator2.hasNext()) {
                parcel.writeTypedList(iterator2.next());
            }
        }
        parcel.writeByte(this.f8042q ? (byte) 1 : (byte) 0);
        parcel.writeParcelable(this.f8043r, i10);
    }

    public GeoFence(Parcel parcel) {
        this.f8029d = null;
        this.f8030e = 0;
        this.f8031f = null;
        this.f8032g = null;
        this.f8034i = 0.0f;
        this.f8035j = -1L;
        this.f8036k = 1;
        this.f8037l = 0.0f;
        this.f8038m = 0.0f;
        this.f8039n = null;
        this.f8040o = 0;
        this.f8041p = -1L;
        this.f8042q = true;
        this.f8043r = null;
        this.f8026a = parcel.readString();
        this.f8027b = parcel.readString();
        this.f8028c = parcel.readString();
        this.f8029d = (PendingIntent) parcel.readParcelable(PendingIntent.class.getClassLoader());
        this.f8030e = parcel.readInt();
        this.f8031f = (PoiItem) parcel.readParcelable(PoiItem.class.getClassLoader());
        this.f8032g = parcel.createTypedArrayList(DistrictItem.CREATOR);
        this.f8034i = parcel.readFloat();
        this.f8035j = parcel.readLong();
        this.f8036k = parcel.readInt();
        this.f8037l = parcel.readFloat();
        this.f8038m = parcel.readFloat();
        this.f8039n = (DPoint) parcel.readParcelable(DPoint.class.getClassLoader());
        this.f8040o = parcel.readInt();
        this.f8041p = parcel.readLong();
        int readInt = parcel.readInt();
        if (readInt != 0) {
            this.f8033h = new ArrayList();
            for (int i10 = 0; i10 < readInt; i10++) {
                this.f8033h.add(parcel.createTypedArrayList(DPoint.CREATOR));
            }
        }
        this.f8042q = parcel.readByte() != 0;
        this.f8043r = (AMapLocation) parcel.readParcelable(AMapLocation.class.getClassLoader());
    }
}
