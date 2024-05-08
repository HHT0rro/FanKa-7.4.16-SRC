package com.amap.api.services.nearby;

import android.content.Context;
import com.amap.api.col.s.bn;
import com.amap.api.col.s.n;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.core.LatLonPoint;
import com.amap.api.services.interfaces.INearbySearch;
import com.huawei.hms.push.constant.RemoteMessageConst;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class NearbySearch {
    public static final int AMAP = 1;
    public static final int GPS = 0;

    /* renamed from: a, reason: collision with root package name */
    private static NearbySearch f8591a;

    /* renamed from: b, reason: collision with root package name */
    private INearbySearch f8592b;

    /* renamed from: com.amap.api.services.nearby.NearbySearch$1, reason: invalid class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f8593a;

        static {
            int[] iArr = new int[NearbySearchFunctionType.values().length];
            f8593a = iArr;
            try {
                iArr[NearbySearchFunctionType.DISTANCE_SEARCH.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f8593a[NearbySearchFunctionType.DRIVING_DISTANCE_SEARCH.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public interface NearbyListener {
        void onNearbyInfoSearched(NearbySearchResult nearbySearchResult, int i10);

        void onNearbyInfoUploaded(int i10);

        void onUserInfoCleared(int i10);
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static class NearbyQuery {

        /* renamed from: a, reason: collision with root package name */
        private LatLonPoint f8594a;

        /* renamed from: b, reason: collision with root package name */
        private NearbySearchFunctionType f8595b = NearbySearchFunctionType.DISTANCE_SEARCH;

        /* renamed from: c, reason: collision with root package name */
        private int f8596c = 1000;

        /* renamed from: d, reason: collision with root package name */
        private int f8597d = AMapException.CODE_AMAP_CLIENT_ERRORCODE_MISSSING;

        /* renamed from: e, reason: collision with root package name */
        private int f8598e = 1;

        public LatLonPoint getCenterPoint() {
            return this.f8594a;
        }

        public int getCoordType() {
            return this.f8598e;
        }

        public int getRadius() {
            return this.f8596c;
        }

        public int getTimeRange() {
            return this.f8597d;
        }

        public int getType() {
            int i10 = AnonymousClass1.f8593a[this.f8595b.ordinal()];
            return (i10 == 1 || i10 != 2) ? 0 : 1;
        }

        public void setCenterPoint(LatLonPoint latLonPoint) {
            this.f8594a = latLonPoint;
        }

        public void setCoordType(int i10) {
            if (i10 != 0 && i10 != 1) {
                this.f8598e = 1;
            } else {
                this.f8598e = i10;
            }
        }

        public void setRadius(int i10) {
            if (i10 > 10000) {
                i10 = 10000;
            }
            this.f8596c = i10;
        }

        public void setTimeRange(int i10) {
            if (i10 < 5) {
                i10 = 5;
            } else if (i10 > 86400) {
                i10 = RemoteMessageConst.DEFAULT_TTL;
            }
            this.f8597d = i10;
        }

        public void setType(NearbySearchFunctionType nearbySearchFunctionType) {
            this.f8595b = nearbySearchFunctionType;
        }
    }

    private NearbySearch(Context context) throws AMapException {
        if (this.f8592b == null) {
            try {
                this.f8592b = new bn(context);
            } catch (Exception e2) {
                e2.printStackTrace();
                if (e2 instanceof AMapException) {
                    throw ((AMapException) e2);
                }
            }
        }
    }

    private void a() {
        INearbySearch iNearbySearch = this.f8592b;
        if (iNearbySearch != null) {
            iNearbySearch.destroy();
        }
        this.f8592b = null;
    }

    public static synchronized void destroy() {
        synchronized (NearbySearch.class) {
            NearbySearch nearbySearch = f8591a;
            if (nearbySearch != null) {
                try {
                    nearbySearch.a();
                } catch (Throwable th) {
                    n.a(th, "NearbySearch", "destryoy");
                }
            }
            f8591a = null;
        }
    }

    public static synchronized NearbySearch getInstance(Context context) throws AMapException {
        NearbySearch nearbySearch;
        synchronized (NearbySearch.class) {
            if (f8591a == null) {
                try {
                    f8591a = new NearbySearch(context);
                } catch (AMapException e2) {
                    throw e2;
                }
            }
            nearbySearch = f8591a;
        }
        return nearbySearch;
    }

    public synchronized void addNearbyListener(NearbyListener nearbyListener) {
        INearbySearch iNearbySearch = this.f8592b;
        if (iNearbySearch != null) {
            iNearbySearch.addNearbyListener(nearbyListener);
        }
    }

    public void clearUserInfoAsyn() {
        INearbySearch iNearbySearch = this.f8592b;
        if (iNearbySearch != null) {
            iNearbySearch.clearUserInfoAsyn();
        }
    }

    public synchronized void removeNearbyListener(NearbyListener nearbyListener) {
        INearbySearch iNearbySearch = this.f8592b;
        if (iNearbySearch != null) {
            iNearbySearch.removeNearbyListener(nearbyListener);
        }
    }

    public NearbySearchResult searchNearbyInfo(NearbyQuery nearbyQuery) throws AMapException {
        INearbySearch iNearbySearch = this.f8592b;
        if (iNearbySearch != null) {
            return iNearbySearch.searchNearbyInfo(nearbyQuery);
        }
        return null;
    }

    public void searchNearbyInfoAsyn(NearbyQuery nearbyQuery) {
        INearbySearch iNearbySearch = this.f8592b;
        if (iNearbySearch != null) {
            iNearbySearch.searchNearbyInfoAsyn(nearbyQuery);
        }
    }

    public void setUserID(String str) {
        INearbySearch iNearbySearch = this.f8592b;
        if (iNearbySearch != null) {
            iNearbySearch.setUserID(str);
        }
    }

    public synchronized void startUploadNearbyInfoAuto(UploadInfoCallback uploadInfoCallback, int i10) {
        INearbySearch iNearbySearch = this.f8592b;
        if (iNearbySearch != null) {
            iNearbySearch.startUploadNearbyInfoAuto(uploadInfoCallback, i10);
        }
    }

    public synchronized void stopUploadNearbyInfoAuto() {
        INearbySearch iNearbySearch = this.f8592b;
        if (iNearbySearch != null) {
            iNearbySearch.stopUploadNearbyInfoAuto();
        }
    }

    public void uploadNearbyInfoAsyn(UploadInfo uploadInfo) {
        INearbySearch iNearbySearch = this.f8592b;
        if (iNearbySearch != null) {
            iNearbySearch.uploadNearbyInfoAsyn(uploadInfo);
        }
    }
}
