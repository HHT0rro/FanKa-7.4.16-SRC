package com.autonavi.aps.amapapi.restruct;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.telephony.CellIdentityCdma;
import android.telephony.CellIdentityGsm;
import android.telephony.CellIdentityLte;
import android.telephony.CellIdentityWcdma;
import android.telephony.CellInfo;
import android.telephony.CellInfoCdma;
import android.telephony.CellInfoGsm;
import android.telephony.CellInfoLte;
import android.telephony.CellInfoNr;
import android.telephony.CellInfoWcdma;
import android.telephony.CellLocation;
import android.telephony.PhoneStateListener;
import android.telephony.ServiceState;
import android.telephony.SignalStrength;
import android.telephony.TelephonyManager;
import android.telephony.cdma.CdmaCellLocation;
import android.telephony.gsm.GsmCellLocation;
import android.text.TextUtils;
import com.alimm.tanx.core.utils.LandingPageUtHelper;
import com.amap.api.col.p0003l.jd;
import com.amap.api.col.p0003l.kl;
import com.amap.api.col.p0003l.km;
import com.amap.api.col.p0003l.kn;
import com.amap.api.col.p0003l.ko;
import com.amap.api.col.p0003l.kp;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: CgiManager.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class e {

    /* renamed from: b, reason: collision with root package name */
    public TelephonyManager f9450b;

    /* renamed from: d, reason: collision with root package name */
    public SignalStrength f9452d;

    /* renamed from: h, reason: collision with root package name */
    private Context f9456h;

    /* renamed from: m, reason: collision with root package name */
    private c f9461m;

    /* renamed from: q, reason: collision with root package name */
    private TelephonyManager.CellInfoCallback f9465q;

    /* renamed from: u, reason: collision with root package name */
    private com.autonavi.aps.amapapi.c f9469u;

    /* renamed from: i, reason: collision with root package name */
    private boolean f9457i = false;

    /* renamed from: j, reason: collision with root package name */
    private boolean f9458j = false;

    /* renamed from: a, reason: collision with root package name */
    public ArrayList<d> f9449a = new ArrayList<>();

    /* renamed from: k, reason: collision with root package name */
    private String f9459k = null;

    /* renamed from: l, reason: collision with root package name */
    private ArrayList<d> f9460l = new ArrayList<>();

    /* renamed from: n, reason: collision with root package name */
    private long f9462n = 0;

    /* renamed from: c, reason: collision with root package name */
    public PhoneStateListener f9451c = null;

    /* renamed from: o, reason: collision with root package name */
    private boolean f9463o = false;

    /* renamed from: p, reason: collision with root package name */
    private Object f9464p = new Object();

    /* renamed from: r, reason: collision with root package name */
    private boolean f9466r = false;

    /* renamed from: e, reason: collision with root package name */
    public boolean f9453e = false;

    /* renamed from: f, reason: collision with root package name */
    public StringBuilder f9454f = null;

    /* renamed from: s, reason: collision with root package name */
    private String f9467s = null;

    /* renamed from: t, reason: collision with root package name */
    private String f9468t = null;

    /* renamed from: g, reason: collision with root package name */
    public String f9455g = null;

    /* compiled from: CgiManager.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public class a extends TelephonyManager.CellInfoCallback {
        public a() {
        }

        @Override // android.telephony.TelephonyManager.CellInfoCallback
        public final void onCellInfo(List<CellInfo> list) {
            try {
                if (com.autonavi.aps.amapapi.utils.j.b() - e.this.f9462n < 500) {
                    return;
                }
                e.b(e.this);
                e.this.a(e.this.t());
                e.this.a(list);
                e.this.f9462n = com.autonavi.aps.amapapi.utils.j.b();
            } catch (SecurityException e2) {
                e.this.f9455g = e2.getMessage();
            } catch (Throwable th) {
                com.autonavi.aps.amapapi.utils.b.a(th, "Cgi", "cellInfo");
            }
        }
    }

    /* compiled from: CgiManager.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public class b extends PhoneStateListener {
        public b() {
        }

        @Override // android.telephony.PhoneStateListener
        public final void onCellInfoChanged(List<CellInfo> list) {
            try {
                com.autonavi.aps.amapapi.utils.d.b();
                if (e.this.f9469u != null) {
                    e.this.f9469u.c();
                }
                if (com.autonavi.aps.amapapi.utils.j.b() - e.this.f9462n < 500) {
                    return;
                }
                e.this.a(e.this.t());
                e.this.a(list);
                e.this.f9462n = com.autonavi.aps.amapapi.utils.j.b();
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }

        @Override // android.telephony.PhoneStateListener
        public final void onCellLocationChanged(CellLocation cellLocation) {
            com.autonavi.aps.amapapi.utils.d.b();
            if (com.autonavi.aps.amapapi.utils.j.b() - e.this.f9462n < 500) {
                return;
            }
            try {
                e.this.a(cellLocation);
                e.this.a(e.this.u());
                e.this.f9462n = com.autonavi.aps.amapapi.utils.j.b();
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }

        @Override // android.telephony.PhoneStateListener
        public final void onDataConnectionStateChanged(int i10) {
            super.onDataConnectionStateChanged(i10);
        }

        @Override // android.telephony.PhoneStateListener
        public final void onServiceStateChanged(ServiceState serviceState) {
            try {
                int state = serviceState.getState();
                if (state == 0) {
                    e.this.a(false, false);
                } else {
                    if (state != 1) {
                        return;
                    }
                    e.this.j();
                }
            } catch (Throwable unused) {
            }
        }

        @Override // android.telephony.PhoneStateListener
        public final void onSignalStrengthChanged(int i10) {
            super.onSignalStrengthChanged(i10);
        }

        @Override // android.telephony.PhoneStateListener
        public final void onSignalStrengthsChanged(SignalStrength signalStrength) {
            if (signalStrength == null) {
                return;
            }
            e eVar = e.this;
            eVar.f9452d = signalStrength;
            try {
                if (eVar.f9469u != null) {
                    e.this.f9469u.c();
                }
            } catch (Throwable unused) {
            }
        }
    }

    public e(Context context, Handler handler) {
        this.f9450b = null;
        this.f9461m = null;
        this.f9456h = context;
        this.f9450b = (TelephonyManager) com.autonavi.aps.amapapi.utils.j.a(context, "phone");
        o();
        c cVar = new c(context, "cellAge", handler);
        this.f9461m = cVar;
        cVar.a();
    }

    public static boolean a(int i10) {
        return i10 > 0 && i10 <= 15;
    }

    private static int b(int i10) {
        return (i10 * 2) - 113;
    }

    public static /* synthetic */ boolean b(e eVar) {
        eVar.f9466r = true;
        return true;
    }

    private void o() {
        if (this.f9450b == null) {
            return;
        }
        p();
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0036 A[Catch: Exception -> 0x007a, TryCatch #0 {Exception -> 0x007a, blocks: (B:2:0x0000, B:4:0x0004, B:5:0x000b, B:8:0x001b, B:10:0x0023, B:13:0x0036, B:16:0x0045, B:21:0x0053, B:22:0x0055, B:25:0x005f, B:28:0x0065, B:29:0x0070, B:31:0x0074, B:40:0x006b, B:41:0x0029, B:42:0x002f), top: B:1:0x0000 }] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0074 A[Catch: Exception -> 0x007a, TRY_LEAVE, TryCatch #0 {Exception -> 0x007a, blocks: (B:2:0x0000, B:4:0x0004, B:5:0x000b, B:8:0x001b, B:10:0x0023, B:13:0x0036, B:16:0x0045, B:21:0x0053, B:22:0x0055, B:25:0x005f, B:28:0x0065, B:29:0x0070, B:31:0x0074, B:40:0x006b, B:41:0x0029, B:42:0x002f), top: B:1:0x0000 }] */
    /* JADX WARN: Removed duplicated region for block: B:35:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x006b A[Catch: Exception -> 0x007a, TryCatch #0 {Exception -> 0x007a, blocks: (B:2:0x0000, B:4:0x0004, B:5:0x000b, B:8:0x001b, B:10:0x0023, B:13:0x0036, B:16:0x0045, B:21:0x0053, B:22:0x0055, B:25:0x005f, B:28:0x0065, B:29:0x0070, B:31:0x0074, B:40:0x006b, B:41:0x0029, B:42:0x002f), top: B:1:0x0000 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void p() {
        /*
            r8 = this;
            android.telephony.PhoneStateListener r0 = r8.f9451c     // Catch: java.lang.Exception -> L7a
            if (r0 != 0) goto Lb
            com.autonavi.aps.amapapi.restruct.e$b r0 = new com.autonavi.aps.amapapi.restruct.e$b     // Catch: java.lang.Exception -> L7a
            r0.<init>()     // Catch: java.lang.Exception -> L7a
            r8.f9451c = r0     // Catch: java.lang.Exception -> L7a
        Lb:
            r0 = 320(0x140, float:4.48E-43)
            int r1 = android.os.Build.VERSION.SDK_INT     // Catch: java.lang.Exception -> L7a
            java.lang.String r2 = "hasFineLocPerm"
            java.lang.String r3 = "hasNoFineLocPerm"
            java.lang.String r4 = "android.permission.ACCESS_FINE_LOCATION"
            r5 = 336(0x150, float:4.71E-43)
            r6 = 31
            if (r1 < r6) goto L2f
            android.content.Context r7 = r8.f9456h     // Catch: java.lang.Exception -> L7a
            int r7 = r7.checkSelfPermission(r4)     // Catch: java.lang.Exception -> L7a
            if (r7 != 0) goto L29
            r8.f9468t = r2     // Catch: java.lang.Exception -> L7a
            com.autonavi.aps.amapapi.utils.d.b()     // Catch: java.lang.Exception -> L7a
            goto L32
        L29:
            r8.f9468t = r3     // Catch: java.lang.Exception -> L7a
            com.autonavi.aps.amapapi.utils.d.b()     // Catch: java.lang.Exception -> L7a
            goto L34
        L2f:
            com.autonavi.aps.amapapi.utils.d.b()     // Catch: java.lang.Exception -> L7a
        L32:
            r0 = 336(0x150, float:4.71E-43)
        L34:
            if (r1 < r6) goto L6b
            android.content.Context r1 = r8.f9456h     // Catch: java.lang.Exception -> L7a
            java.lang.String r5 = "android.permission.READ_PHONE_STATE"
            int r1 = r1.checkSelfPermission(r5)     // Catch: java.lang.Exception -> L7a
            r5 = 1
            r6 = 0
            if (r1 != 0) goto L44
            r1 = 1
            goto L45
        L44:
            r1 = 0
        L45:
            android.content.Context r7 = r8.f9456h     // Catch: java.lang.Exception -> L7a
            int r4 = r7.checkSelfPermission(r4)     // Catch: java.lang.Exception -> L7a
            if (r4 != 0) goto L4e
            goto L4f
        L4e:
            r5 = 0
        L4f:
            if (r1 == 0) goto L55
            if (r5 == 0) goto L55
            r0 = r0 | 1024(0x400, float:1.435E-42)
        L55:
            com.autonavi.aps.amapapi.utils.d.b()     // Catch: java.lang.Exception -> L7a
            if (r1 == 0) goto L5d
            java.lang.String r1 = "hasReadPhoneStatePerm"
            goto L5f
        L5d:
            java.lang.String r1 = "hasNoReadPhoneStatePerm"
        L5f:
            r8.f9467s = r1     // Catch: java.lang.Exception -> L7a
            if (r5 == 0) goto L64
            goto L65
        L64:
            r2 = r3
        L65:
            r8.f9468t = r2     // Catch: java.lang.Exception -> L7a
            com.autonavi.aps.amapapi.utils.d.b()     // Catch: java.lang.Exception -> L7a
            goto L70
        L6b:
            com.autonavi.aps.amapapi.utils.d.b()     // Catch: java.lang.Exception -> L7a
            r0 = r0 | 1024(0x400, float:1.435E-42)
        L70:
            android.telephony.PhoneStateListener r1 = r8.f9451c     // Catch: java.lang.Exception -> L7a
            if (r1 == 0) goto L79
            android.telephony.TelephonyManager r2 = r8.f9450b     // Catch: java.lang.Exception -> L7a
            r2.listen(r1, r0)     // Catch: java.lang.Exception -> L7a
        L79:
            return
        L7a:
            r0 = move-exception
            r0.printStackTrace()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.autonavi.aps.amapapi.restruct.e.p():void");
    }

    private int q() {
        d e2 = e();
        if (e2 != null) {
            return e2.f9440l;
        }
        return 0;
    }

    private CellLocation r() {
        TelephonyManager telephonyManager = this.f9450b;
        if (telephonyManager != null) {
            try {
                CellLocation cellLocation = telephonyManager.getCellLocation();
                this.f9455g = null;
                return cellLocation;
            } catch (SecurityException e2) {
                this.f9455g = e2.getMessage();
            } catch (Throwable th) {
                this.f9455g = null;
                com.autonavi.aps.amapapi.utils.b.a(th, "CgiManager", "getCellLocation");
            }
        }
        return null;
    }

    private boolean s() {
        return !this.f9453e && com.autonavi.aps.amapapi.utils.j.b() - this.f9462n >= 45000;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public CellLocation t() {
        if (this.f9450b == null) {
            return null;
        }
        return r();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<CellInfo> u() {
        TelephonyManager telephonyManager;
        List<CellInfo> list;
        try {
            if (com.autonavi.aps.amapapi.utils.j.c() < 18 || (telephonyManager = this.f9450b) == null) {
                return null;
            }
            try {
                list = telephonyManager.getAllCellInfo();
            } catch (SecurityException e2) {
                e = e2;
                list = null;
            }
            try {
                this.f9455g = null;
            } catch (SecurityException e10) {
                e = e10;
                this.f9455g = e.getMessage();
                return list;
            }
            return list;
        } catch (Throwable th) {
            com.autonavi.aps.amapapi.utils.b.a(th, "Cgi", "getNewCells");
            return null;
        }
    }

    public final synchronized d f() {
        if (this.f9453e) {
            return null;
        }
        ArrayList<d> arrayList = this.f9460l;
        if (arrayList.size() <= 0) {
            return null;
        }
        Iterator<d> iterator2 = arrayList.iterator2();
        while (iterator2.hasNext()) {
            d next = iterator2.next();
            if (next.f9442n) {
                return next.clone();
            }
        }
        return arrayList.get(0).clone();
    }

    public final int g() {
        return q() | (this.f9457i ? 4 : 0) | (this.f9458j ? 8 : 0);
    }

    public final int h() {
        return q() & 3;
    }

    public final TelephonyManager i() {
        return this.f9450b;
    }

    public final synchronized void j() {
        this.f9455g = null;
        this.f9449a.clear();
        this.f9460l.clear();
        this.f9457i = false;
        this.f9458j = false;
    }

    public final String k() {
        return this.f9455g;
    }

    public final String l() {
        return this.f9459k;
    }

    public final synchronized String m() {
        if (this.f9453e) {
            j();
        }
        StringBuilder sb2 = this.f9454f;
        if (sb2 == null) {
            this.f9454f = new StringBuilder();
        } else {
            sb2.delete(0, sb2.length());
        }
        if (h() == 1) {
            for (int i10 = 1; i10 < this.f9449a.size(); i10++) {
                StringBuilder sb3 = this.f9454f;
                sb3.append("#");
                sb3.append(this.f9449a.get(i10).f9430b);
                StringBuilder sb4 = this.f9454f;
                sb4.append("|");
                sb4.append(this.f9449a.get(i10).f9431c);
                StringBuilder sb5 = this.f9454f;
                sb5.append("|");
                sb5.append(this.f9449a.get(i10).f9432d);
            }
        }
        for (int i11 = 1; i11 < this.f9460l.size(); i11++) {
            d dVar = this.f9460l.get(i11);
            int i12 = dVar.f9440l;
            if (i12 != 1 && i12 != 3 && i12 != 4 && i12 != 5) {
                if (i12 == 2) {
                    StringBuilder sb6 = this.f9454f;
                    sb6.append("#");
                    sb6.append(dVar.f9440l);
                    StringBuilder sb7 = this.f9454f;
                    sb7.append("|");
                    sb7.append(dVar.f9429a);
                    StringBuilder sb8 = this.f9454f;
                    sb8.append("|");
                    sb8.append(dVar.f9436h);
                    StringBuilder sb9 = this.f9454f;
                    sb9.append("|");
                    sb9.append(dVar.f9437i);
                    StringBuilder sb10 = this.f9454f;
                    sb10.append("|");
                    sb10.append(dVar.f9438j);
                }
            }
            StringBuilder sb11 = this.f9454f;
            sb11.append("#");
            sb11.append(dVar.f9440l);
            StringBuilder sb12 = this.f9454f;
            sb12.append("|");
            sb12.append(dVar.f9429a);
            StringBuilder sb13 = this.f9454f;
            sb13.append("|");
            sb13.append(dVar.f9430b);
            StringBuilder sb14 = this.f9454f;
            sb14.append("|");
            sb14.append(dVar.f9431c);
            StringBuilder sb15 = this.f9454f;
            sb15.append("|");
            sb15.append(dVar.a());
        }
        if (this.f9454f.length() > 0) {
            this.f9454f.deleteCharAt(0);
        }
        return this.f9454f.toString();
    }

    public final boolean n() {
        try {
            TelephonyManager telephonyManager = this.f9450b;
            if (telephonyManager != null) {
                if (!TextUtils.isEmpty(telephonyManager.getSimOperator())) {
                    return true;
                }
                if (!TextUtils.isEmpty(this.f9450b.getSimCountryIso())) {
                    return true;
                }
            }
        } catch (Throwable unused) {
        }
        try {
            int a10 = com.autonavi.aps.amapapi.utils.j.a(com.autonavi.aps.amapapi.utils.j.c(this.f9456h));
            return a10 == 0 || a10 == 4 || a10 == 2 || a10 == 5 || a10 == 3;
        } catch (Throwable unused2) {
            return false;
        }
    }

    public final void b() {
        boolean z10 = false;
        try {
            if (Build.VERSION.SDK_INT >= 31) {
                String str = this.f9456h.checkSelfPermission(com.kuaishou.weapon.p0.g.f36121g) == 0 ? "hasFineLocPerm" : "hasNoFineLocPerm";
                String str2 = this.f9456h.checkSelfPermission(com.kuaishou.weapon.p0.g.f36117c) == 0 ? "hasReadPhoneStatePerm" : "hasNoReadPhoneStatePerm";
                boolean z11 = true;
                if (!TextUtils.isEmpty(this.f9468t) && !this.f9468t.equals(str)) {
                    z10 = true;
                }
                if (TextUtils.isEmpty(this.f9467s) || this.f9467s.equals(str2)) {
                    z11 = z10;
                }
                if (z11) {
                    com.autonavi.aps.amapapi.utils.d.b();
                    p();
                }
            }
        } catch (Throwable unused) {
            com.autonavi.aps.amapapi.utils.d.b();
        }
    }

    public final synchronized ArrayList<d> c() {
        ArrayList<d> arrayList;
        arrayList = new ArrayList<>();
        ArrayList<d> arrayList2 = this.f9449a;
        if (arrayList2 != null) {
            Iterator<d> iterator2 = arrayList2.iterator2();
            while (iterator2.hasNext()) {
                arrayList.add(iterator2.next().clone());
            }
        }
        return arrayList;
    }

    public final synchronized ArrayList<d> d() {
        ArrayList<d> arrayList;
        arrayList = new ArrayList<>();
        ArrayList<d> arrayList2 = this.f9460l;
        if (arrayList2 != null) {
            Iterator<d> iterator2 = arrayList2.iterator2();
            while (iterator2.hasNext()) {
                arrayList.add(iterator2.next().clone());
            }
        }
        return arrayList;
    }

    public final synchronized d e() {
        if (this.f9453e) {
            return null;
        }
        ArrayList<d> arrayList = this.f9449a;
        if (arrayList.size() <= 0) {
            return null;
        }
        return arrayList.get(0).clone();
    }

    public final List<kl> a() {
        ArrayList arrayList = new ArrayList();
        List<CellInfo> allCellInfo = this.f9450b.getAllCellInfo();
        if (allCellInfo != null) {
            for (CellInfo cellInfo : allCellInfo) {
                if (cellInfo instanceof CellInfoCdma) {
                    CellInfoCdma cellInfoCdma = (CellInfoCdma) cellInfo;
                    CellIdentityCdma cellIdentity = cellInfoCdma.getCellIdentity();
                    km kmVar = new km(cellInfo.isRegistered(), true);
                    kmVar.f6656m = cellIdentity.getLatitude();
                    kmVar.f6657n = cellIdentity.getLongitude();
                    kmVar.f6653j = cellIdentity.getSystemId();
                    kmVar.f6654k = cellIdentity.getNetworkId();
                    kmVar.f6655l = cellIdentity.getBasestationId();
                    kmVar.f6647d = cellInfoCdma.getCellSignalStrength().getAsuLevel();
                    kmVar.f6646c = cellInfoCdma.getCellSignalStrength().getCdmaDbm();
                    arrayList.add(kmVar);
                } else if (cellInfo instanceof CellInfoGsm) {
                    CellInfoGsm cellInfoGsm = (CellInfoGsm) cellInfo;
                    CellIdentityGsm cellIdentity2 = cellInfoGsm.getCellIdentity();
                    kn knVar = new kn(cellInfo.isRegistered(), true);
                    knVar.f6644a = String.valueOf(cellIdentity2.getMcc());
                    knVar.f6645b = String.valueOf(cellIdentity2.getMnc());
                    knVar.f6658j = cellIdentity2.getLac();
                    knVar.f6659k = cellIdentity2.getCid();
                    knVar.f6646c = cellInfoGsm.getCellSignalStrength().getDbm();
                    knVar.f6647d = cellInfoGsm.getCellSignalStrength().getAsuLevel();
                    if (Build.VERSION.SDK_INT >= 24) {
                        knVar.f6661m = cellIdentity2.getArfcn();
                        knVar.f6662n = cellIdentity2.getBsic();
                    }
                    arrayList.add(knVar);
                } else if (cellInfo instanceof CellInfoLte) {
                    CellInfoLte cellInfoLte = (CellInfoLte) cellInfo;
                    CellIdentityLte cellIdentity3 = cellInfoLte.getCellIdentity();
                    ko koVar = new ko(cellInfo.isRegistered());
                    koVar.f6644a = String.valueOf(cellIdentity3.getMcc());
                    koVar.f6645b = String.valueOf(cellIdentity3.getMnc());
                    koVar.f6666l = cellIdentity3.getPci();
                    koVar.f6647d = cellInfoLte.getCellSignalStrength().getAsuLevel();
                    koVar.f6665k = cellIdentity3.getCi();
                    koVar.f6664j = cellIdentity3.getTac();
                    koVar.f6668n = cellInfoLte.getCellSignalStrength().getTimingAdvance();
                    koVar.f6646c = cellInfoLte.getCellSignalStrength().getDbm();
                    if (Build.VERSION.SDK_INT >= 24) {
                        koVar.f6667m = cellIdentity3.getEarfcn();
                    }
                    arrayList.add(koVar);
                } else {
                    int i10 = Build.VERSION.SDK_INT;
                    if (cellInfo instanceof CellInfoWcdma) {
                        CellInfoWcdma cellInfoWcdma = (CellInfoWcdma) cellInfo;
                        CellIdentityWcdma cellIdentity4 = cellInfoWcdma.getCellIdentity();
                        kp kpVar = new kp(cellInfo.isRegistered(), true);
                        kpVar.f6644a = String.valueOf(cellIdentity4.getMcc());
                        kpVar.f6645b = String.valueOf(cellIdentity4.getMnc());
                        kpVar.f6669j = cellIdentity4.getLac();
                        kpVar.f6670k = cellIdentity4.getCid();
                        kpVar.f6671l = cellIdentity4.getPsc();
                        kpVar.f6647d = cellInfoWcdma.getCellSignalStrength().getAsuLevel();
                        kpVar.f6646c = cellInfoWcdma.getCellSignalStrength().getDbm();
                        if (i10 >= 24) {
                            kpVar.f6672m = cellIdentity4.getUarfcn();
                        }
                        arrayList.add(kpVar);
                    }
                }
            }
        }
        return arrayList;
    }

    private void b(boolean z10, boolean z11) {
        if (!this.f9453e && this.f9450b != null && Build.VERSION.SDK_INT >= 29 && this.f9456h.getApplicationInfo().targetSdkVersion >= 29) {
            if (this.f9465q == null) {
                this.f9465q = new a();
            }
            try {
                this.f9450b.requestCellInfoUpdate(jd.a().d(), this.f9465q);
            } catch (Throwable th) {
                com.autonavi.aps.amapapi.utils.b.a(th, "Cgi", "refreshCgi");
            }
            if (z11 || z10) {
                for (int i10 = 0; !this.f9466r && i10 < 20; i10++) {
                    try {
                        Thread.sleep(5L);
                    } catch (Throwable unused) {
                    }
                }
            }
        }
        this.f9458j = false;
        TelephonyManager telephonyManager = this.f9450b;
        if (telephonyManager != null) {
            String networkOperator = telephonyManager.getNetworkOperator();
            this.f9459k = networkOperator;
            if (!TextUtils.isEmpty(networkOperator)) {
                this.f9458j = true;
            }
        }
        this.f9462n = com.autonavi.aps.amapapi.utils.j.b();
    }

    public final void a(boolean z10, boolean z11) {
        try {
            this.f9453e = com.autonavi.aps.amapapi.utils.j.a(this.f9456h);
            if (s()) {
                b(z10, z11);
                a(t());
                a(u());
            }
            if (this.f9453e) {
                j();
            }
        } catch (SecurityException e2) {
            this.f9455g = e2.getMessage();
        } catch (Throwable th) {
            com.autonavi.aps.amapapi.utils.b.a(th, "CgiManager", "refresh");
        }
    }

    public final void a(boolean z10) {
        PhoneStateListener phoneStateListener;
        this.f9461m.a(z10);
        this.f9462n = 0L;
        synchronized (this.f9464p) {
            this.f9463o = true;
        }
        TelephonyManager telephonyManager = this.f9450b;
        if (telephonyManager != null && (phoneStateListener = this.f9451c) != null) {
            try {
                telephonyManager.listen(phoneStateListener, 0);
            } catch (Throwable th) {
                com.autonavi.aps.amapapi.utils.b.a(th, "CgiManager", LandingPageUtHelper.XAD_UT_LP_DESTROY);
            }
        }
        this.f9451c = null;
        this.f9452d = null;
        this.f9450b = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void a(CellLocation cellLocation) {
        String[] a10 = com.autonavi.aps.amapapi.utils.j.a(this.f9450b);
        this.f9449a.clear();
        if (cellLocation instanceof GsmCellLocation) {
            GsmCellLocation gsmCellLocation = (GsmCellLocation) cellLocation;
            d dVar = new d(1, true);
            dVar.f9429a = com.autonavi.aps.amapapi.utils.j.e(a10[0]);
            dVar.f9430b = com.autonavi.aps.amapapi.utils.j.e(a10[1]);
            dVar.f9431c = gsmCellLocation.getLac();
            dVar.f9432d = gsmCellLocation.getCid();
            SignalStrength signalStrength = this.f9452d;
            if (signalStrength != null) {
                int gsmSignalStrength = signalStrength.getGsmSignalStrength();
                dVar.f9447s = gsmSignalStrength == 99 ? Integer.MAX_VALUE : b(gsmSignalStrength);
            }
            dVar.f9446r = false;
            this.f9461m.a((c) dVar);
            this.f9449a.add(dVar);
            return;
        }
        if (cellLocation instanceof CdmaCellLocation) {
            CdmaCellLocation cdmaCellLocation = (CdmaCellLocation) cellLocation;
            d dVar2 = new d(2, true);
            dVar2.f9429a = Integer.parseInt(a10[0]);
            dVar2.f9430b = Integer.parseInt(a10[1]);
            dVar2.f9434f = cdmaCellLocation.getBaseStationLatitude();
            dVar2.f9435g = cdmaCellLocation.getBaseStationLongitude();
            dVar2.f9436h = cdmaCellLocation.getSystemId();
            dVar2.f9437i = cdmaCellLocation.getNetworkId();
            dVar2.f9438j = cdmaCellLocation.getBaseStationId();
            SignalStrength signalStrength2 = this.f9452d;
            if (signalStrength2 != null) {
                dVar2.f9447s = signalStrength2.getCdmaDbm();
            }
            dVar2.f9446r = false;
            this.f9461m.a((c) dVar2);
            this.f9449a.add(dVar2);
        }
    }

    public final synchronized void a(List<CellInfo> list) {
        ArrayList<d> arrayList = this.f9460l;
        if (arrayList != null) {
            arrayList.clear();
        }
        if (list != null && list.size() > 0) {
            for (int i10 = 0; i10 < list.size(); i10++) {
                CellInfo cellInfo = list.get(i10);
                if (cellInfo != null) {
                    d dVar = null;
                    boolean isRegistered = cellInfo.isRegistered();
                    if (cellInfo instanceof CellInfoCdma) {
                        dVar = a((CellInfoCdma) cellInfo, isRegistered);
                    } else if (cellInfo instanceof CellInfoGsm) {
                        dVar = a((CellInfoGsm) cellInfo, isRegistered);
                    } else if (cellInfo instanceof CellInfoWcdma) {
                        dVar = a((CellInfoWcdma) cellInfo, isRegistered);
                    } else if (cellInfo instanceof CellInfoLte) {
                        dVar = a((CellInfoLte) cellInfo, isRegistered);
                    } else if (Build.VERSION.SDK_INT >= 29 && (cellInfo instanceof CellInfoNr)) {
                        dVar = a((CellInfoNr) cellInfo, isRegistered);
                    }
                    if (dVar != null) {
                        this.f9461m.a((c) dVar);
                        dVar.f9441m = (short) Math.min(65535L, this.f9461m.e((c) dVar));
                        dVar.f9446r = true;
                        this.f9460l.add(dVar);
                    }
                }
            }
            this.f9457i = false;
            ArrayList<d> arrayList2 = this.f9460l;
            if (arrayList2 != null && arrayList2.size() > 0) {
                this.f9457i = true;
            }
        }
    }

    private static d a(CellInfoGsm cellInfoGsm, boolean z10) {
        if (cellInfoGsm == null || cellInfoGsm.getCellIdentity() == null) {
            return null;
        }
        CellIdentityGsm cellIdentity = cellInfoGsm.getCellIdentity();
        d a10 = a(1, z10, cellIdentity.getMcc(), cellIdentity.getMnc(), cellIdentity.getLac(), cellIdentity.getCid(), cellInfoGsm.getCellSignalStrength().getDbm());
        a10.f9443o = cellInfoGsm.getCellIdentity().getBsic();
        a10.f9444p = cellInfoGsm.getCellIdentity().getArfcn();
        a10.f9445q = cellInfoGsm.getCellSignalStrength().getTimingAdvance();
        a10.f9447s = cellInfoGsm.getCellSignalStrength().getDbm();
        return a10;
    }

    private static d a(CellInfoWcdma cellInfoWcdma, boolean z10) {
        if (cellInfoWcdma == null || cellInfoWcdma.getCellIdentity() == null) {
            return null;
        }
        CellIdentityWcdma cellIdentity = cellInfoWcdma.getCellIdentity();
        d a10 = a(4, z10, cellIdentity.getMcc(), cellIdentity.getMnc(), cellIdentity.getLac(), cellIdentity.getCid(), cellInfoWcdma.getCellSignalStrength().getDbm());
        a10.f9443o = cellIdentity.getPsc();
        a10.f9444p = cellInfoWcdma.getCellIdentity().getUarfcn();
        a10.f9447s = cellInfoWcdma.getCellSignalStrength().getDbm();
        return a10;
    }

    private static d a(CellInfoLte cellInfoLte, boolean z10) {
        if (cellInfoLte == null || cellInfoLte.getCellIdentity() == null) {
            return null;
        }
        CellIdentityLte cellIdentity = cellInfoLte.getCellIdentity();
        d a10 = a(3, z10, cellIdentity.getMcc(), cellIdentity.getMnc(), cellIdentity.getTac(), cellIdentity.getCi(), cellInfoLte.getCellSignalStrength().getDbm());
        a10.f9443o = cellIdentity.getPci();
        if (Build.VERSION.SDK_INT >= 24) {
            a10.f9444p = cellIdentity.getEarfcn();
        }
        a10.f9445q = cellInfoLte.getCellSignalStrength().getTimingAdvance();
        a10.f9447s = cellInfoLte.getCellSignalStrength().getDbm();
        return a10;
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0070  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0073  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static com.autonavi.aps.amapapi.restruct.d a(android.telephony.CellInfoNr r14, boolean r15) {
        /*
            if (r14 == 0) goto L93
            android.telephony.CellIdentity r0 = r14.getCellIdentity()
            if (r0 != 0) goto La
            goto L93
        La:
            android.telephony.CellIdentity r0 = r14.getCellIdentity()
            android.telephony.CellIdentityNr r0 = (android.telephony.CellIdentityNr) r0
            int r1 = r0.getTac()
            r2 = 2147483647(0x7fffffff, float:NaN)
            r3 = 0
            if (r1 != r2) goto L31
            java.lang.String r2 = android.os.Build.MANUFACTURER
            java.lang.String r4 = "HUAWEI"
            boolean r2 = r4.equals(r2)
            if (r2 == 0) goto L31
            java.lang.String r2 = "getHwTac"
            java.lang.Object[] r4 = new java.lang.Object[r3]     // Catch: java.lang.Throwable -> L2d
            int r1 = com.autonavi.aps.amapapi.utils.f.b(r0, r2, r4)     // Catch: java.lang.Throwable -> L2d
            goto L31
        L2d:
            r2 = move-exception
            r2.printStackTrace()
        L31:
            long r4 = r0.getNci()
            java.lang.String r2 = r0.getMccString()     // Catch: java.lang.Throwable -> L4a
            int r2 = java.lang.Integer.parseInt(r2)     // Catch: java.lang.Throwable -> L4a
            java.lang.String r6 = r0.getMncString()     // Catch: java.lang.Throwable -> L48
            int r3 = java.lang.Integer.parseInt(r6)     // Catch: java.lang.Throwable -> L48
            r9 = r2
            r10 = r3
            goto L51
        L48:
            r6 = move-exception
            goto L4c
        L4a:
            r6 = move-exception
            r2 = 0
        L4c:
            r6.printStackTrace()
            r9 = r2
            r10 = 0
        L51:
            android.telephony.CellSignalStrength r2 = r14.getCellSignalStrength()
            android.telephony.CellSignalStrengthNr r2 = (android.telephony.CellSignalStrengthNr) r2
            int r13 = r2.getSsRsrp()
            r7 = 5
            int r11 = r0.getTac()
            r12 = 0
            r8 = r15
            com.autonavi.aps.amapapi.restruct.d r15 = a(r7, r8, r9, r10, r11, r12, r13)
            r15.f9433e = r4
            r2 = 16777215(0xffffff, float:2.3509886E-38)
            r3 = 65535(0xffff, float:9.1834E-41)
            if (r1 <= r2) goto L73
            r15.f9431c = r3
            goto L7c
        L73:
            if (r1 <= r3) goto L7a
            r15.f9431c = r3
            r15.f9445q = r1
            goto L7c
        L7a:
            r15.f9431c = r1
        L7c:
            int r1 = r0.getPci()
            r15.f9443o = r1
            int r0 = r0.getNrarfcn()
            r15.f9444p = r0
            android.telephony.CellSignalStrength r14 = r14.getCellSignalStrength()
            int r14 = r14.getDbm()
            r15.f9447s = r14
            return r15
        L93:
            r14 = 0
            return r14
        */
        throw new UnsupportedOperationException("Method not decompiled: com.autonavi.aps.amapapi.restruct.e.a(android.telephony.CellInfoNr, boolean):com.autonavi.aps.amapapi.restruct.d");
    }

    private d a(CellInfoCdma cellInfoCdma, boolean z10) {
        int i10;
        int i11;
        int i12;
        if (cellInfoCdma != null && cellInfoCdma.getCellIdentity() != null) {
            CellIdentityCdma cellIdentity = cellInfoCdma.getCellIdentity();
            if (cellIdentity.getSystemId() > 0 && cellIdentity.getNetworkId() >= 0 && cellIdentity.getBasestationId() >= 0) {
                CellIdentityCdma cellIdentity2 = cellInfoCdma.getCellIdentity();
                String[] a10 = com.autonavi.aps.amapapi.utils.j.a(this.f9450b);
                try {
                    i10 = Integer.parseInt(a10[0]);
                    try {
                        i12 = Integer.parseInt(a10[1]);
                        i11 = i10;
                    } catch (Throwable unused) {
                        i11 = i10;
                        i12 = 0;
                        d a11 = a(2, z10, i11, i12, 0, 0, cellInfoCdma.getCellSignalStrength().getCdmaDbm());
                        a11.f9436h = cellIdentity2.getSystemId();
                        a11.f9437i = cellIdentity2.getNetworkId();
                        a11.f9438j = cellIdentity2.getBasestationId();
                        a11.f9434f = cellIdentity2.getLatitude();
                        a11.f9435g = cellIdentity2.getLongitude();
                        a11.f9447s = cellInfoCdma.getCellSignalStrength().getCdmaDbm();
                        return a11;
                    }
                } catch (Throwable unused2) {
                    i10 = 0;
                }
                d a112 = a(2, z10, i11, i12, 0, 0, cellInfoCdma.getCellSignalStrength().getCdmaDbm());
                a112.f9436h = cellIdentity2.getSystemId();
                a112.f9437i = cellIdentity2.getNetworkId();
                a112.f9438j = cellIdentity2.getBasestationId();
                a112.f9434f = cellIdentity2.getLatitude();
                a112.f9435g = cellIdentity2.getLongitude();
                a112.f9447s = cellInfoCdma.getCellSignalStrength().getCdmaDbm();
                return a112;
            }
        }
        return null;
    }

    private static d a(int i10, boolean z10, int i11, int i12, int i13, int i14, int i15) {
        d dVar = new d(i10, z10);
        dVar.f9429a = i11;
        dVar.f9430b = i12;
        dVar.f9431c = i13;
        dVar.f9432d = i14;
        dVar.f9439k = i15;
        return dVar;
    }

    public final void a(com.autonavi.aps.amapapi.c cVar) {
        this.f9469u = cVar;
    }
}
