package com.tencent.liteav.videobase.utils;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Handler;
import android.os.Message;
import androidx.annotation.NonNull;
import com.huawei.openalliance.ad.constant.u;
import com.tencent.liteav.base.ContextUtils;
import com.tencent.liteav.base.util.LiteavLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class i {

    /* renamed from: f, reason: collision with root package name */
    private static final Object f43514f = new Object();

    /* renamed from: g, reason: collision with root package name */
    private static i f43515g;

    /* renamed from: a, reason: collision with root package name */
    public final Context f43516a;

    /* renamed from: e, reason: collision with root package name */
    private final Handler f43520e;

    /* renamed from: b, reason: collision with root package name */
    public final HashMap<BroadcastReceiver, ArrayList<b>> f43517b = new HashMap<>();

    /* renamed from: d, reason: collision with root package name */
    private final HashMap<String, ArrayList<b>> f43519d = new HashMap<>();

    /* renamed from: c, reason: collision with root package name */
    public final ArrayList<a> f43518c = new ArrayList<>();

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public final Intent f43522a;

        /* renamed from: b, reason: collision with root package name */
        public final ArrayList<b> f43523b;

        public a(Intent intent, ArrayList<b> arrayList) {
            this.f43522a = intent;
            this.f43523b = arrayList;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        public final IntentFilter f43524a;

        /* renamed from: b, reason: collision with root package name */
        public final BroadcastReceiver f43525b;

        /* renamed from: c, reason: collision with root package name */
        public boolean f43526c;

        /* renamed from: d, reason: collision with root package name */
        public boolean f43527d;

        public b(IntentFilter intentFilter, BroadcastReceiver broadcastReceiver) {
            this.f43524a = intentFilter;
            this.f43525b = broadcastReceiver;
        }

        @NonNull
        public final String toString() {
            StringBuilder sb2 = new StringBuilder(128);
            sb2.append("Receiver{");
            sb2.append((Object) this.f43525b);
            sb2.append(" filter=");
            sb2.append((Object) this.f43524a);
            if (this.f43527d) {
                sb2.append(" DEAD");
            }
            sb2.append(com.alipay.sdk.util.i.f4738d);
            return sb2.toString();
        }
    }

    private i(Context context) {
        this.f43516a = context;
        this.f43520e = new Handler(context.getMainLooper()) { // from class: com.tencent.liteav.videobase.utils.i.1
            @Override // android.os.Handler
            public final void handleMessage(Message message) {
                int size;
                a[] aVarArr;
                if (message.what == 1) {
                    i iVar = i.this;
                    while (true) {
                        synchronized (iVar.f43517b) {
                            size = iVar.f43518c.size();
                            if (size <= 0) {
                                return;
                            }
                            aVarArr = new a[size];
                            iVar.f43518c.toArray(aVarArr);
                            iVar.f43518c.clear();
                        }
                        for (int i10 = 0; i10 < size; i10++) {
                            a aVar = aVarArr[i10];
                            int size2 = aVar.f43523b.size();
                            for (int i11 = 0; i11 < size2; i11++) {
                                b bVar = aVar.f43523b.get(i11);
                                if (!bVar.f43527d) {
                                    bVar.f43525b.onReceive(iVar.f43516a, aVar.f43522a);
                                }
                            }
                        }
                    }
                } else {
                    super.handleMessage(message);
                }
            }
        };
    }

    @NonNull
    public static i a() {
        i iVar;
        synchronized (f43514f) {
            if (f43515g == null) {
                f43515g = new i(ContextUtils.getApplicationContext());
            }
            iVar = f43515g;
        }
        return iVar;
    }

    public final void a(@NonNull BroadcastReceiver broadcastReceiver, @NonNull IntentFilter intentFilter) {
        synchronized (this.f43517b) {
            b bVar = new b(intentFilter, broadcastReceiver);
            ArrayList<b> arrayList = this.f43517b.get(broadcastReceiver);
            if (arrayList == null) {
                arrayList = new ArrayList<>(1);
                this.f43517b.put(broadcastReceiver, arrayList);
            }
            arrayList.add(bVar);
            for (int i10 = 0; i10 < intentFilter.countActions(); i10++) {
                String action = intentFilter.getAction(i10);
                ArrayList<b> arrayList2 = this.f43519d.get(action);
                if (arrayList2 == null) {
                    arrayList2 = new ArrayList<>(1);
                    this.f43519d.put(action, arrayList2);
                }
                arrayList2.add(bVar);
            }
        }
    }

    public final void a(@NonNull BroadcastReceiver broadcastReceiver) {
        synchronized (this.f43517b) {
            ArrayList<b> remove = this.f43517b.remove(broadcastReceiver);
            if (remove == null) {
                return;
            }
            for (int size = remove.size() - 1; size >= 0; size--) {
                b bVar = remove.get(size);
                bVar.f43527d = true;
                for (int i10 = 0; i10 < bVar.f43524a.countActions(); i10++) {
                    String action = bVar.f43524a.getAction(i10);
                    ArrayList<b> arrayList = this.f43519d.get(action);
                    if (arrayList != null) {
                        for (int size2 = arrayList.size() - 1; size2 >= 0; size2--) {
                            b bVar2 = arrayList.get(size2);
                            if (bVar2.f43525b == broadcastReceiver) {
                                bVar2.f43527d = true;
                                arrayList.remove(size2);
                            }
                        }
                        if (arrayList.size() <= 0) {
                            this.f43519d.remove(action);
                        }
                    }
                }
            }
        }
    }

    public final boolean a(@NonNull Intent intent) {
        int i10;
        String str;
        ArrayList arrayList;
        ArrayList<b> arrayList2;
        String str2;
        synchronized (this.f43517b) {
            String action = intent.getAction();
            String resolveTypeIfNeeded = intent.resolveTypeIfNeeded(this.f43516a.getContentResolver());
            Uri data = intent.getData();
            String scheme = intent.getScheme();
            Set<String> categories = intent.getCategories();
            boolean z10 = (intent.getFlags() & 8) != 0;
            if (z10) {
                LiteavLog.v("LocalBroadcastManager", "Resolving type " + resolveTypeIfNeeded + " scheme " + scheme + " of intent " + ((Object) intent));
            }
            ArrayList<b> arrayList3 = this.f43519d.get(intent.getAction());
            if (arrayList3 != null) {
                if (z10) {
                    LiteavLog.v("LocalBroadcastManager", "Action list: ".concat(String.valueOf(arrayList3)));
                }
                ArrayList arrayList4 = null;
                int i11 = 0;
                while (i11 < arrayList3.size()) {
                    b bVar = arrayList3.get(i11);
                    if (z10) {
                        LiteavLog.v("LocalBroadcastManager", "Matching against filter " + ((Object) bVar.f43524a));
                    }
                    if (bVar.f43526c) {
                        if (z10) {
                            LiteavLog.v("LocalBroadcastManager", "  Filter's target already added");
                        }
                        i10 = i11;
                        arrayList2 = arrayList3;
                        str = action;
                        str2 = resolveTypeIfNeeded;
                        arrayList = arrayList4;
                    } else {
                        i10 = i11;
                        str = action;
                        arrayList = arrayList4;
                        arrayList2 = arrayList3;
                        str2 = resolveTypeIfNeeded;
                        int match = bVar.f43524a.match(action, resolveTypeIfNeeded, scheme, data, categories, "LocalBroadcastManager");
                        if (match >= 0) {
                            if (z10) {
                                LiteavLog.v("LocalBroadcastManager", "  Filter matched!  match=0x" + Integer.toHexString(match));
                            }
                            arrayList4 = arrayList == null ? new ArrayList() : arrayList;
                            arrayList4.add(bVar);
                            bVar.f43526c = true;
                            i11 = i10 + 1;
                            action = str;
                            arrayList3 = arrayList2;
                            resolveTypeIfNeeded = str2;
                        } else if (z10) {
                            LiteavLog.v("LocalBroadcastManager", "  Filter did not match: ".concat(match != -4 ? match != -3 ? match != -2 ? match != -1 ? "unknown reason" : "type" : "data" : "action" : u.ck));
                        }
                    }
                    arrayList4 = arrayList;
                    i11 = i10 + 1;
                    action = str;
                    arrayList3 = arrayList2;
                    resolveTypeIfNeeded = str2;
                }
                ArrayList arrayList5 = arrayList4;
                if (arrayList5 != null) {
                    for (int i12 = 0; i12 < arrayList5.size(); i12++) {
                        ((b) arrayList5.get(i12)).f43526c = false;
                    }
                    this.f43518c.add(new a(intent, arrayList5));
                    if (!this.f43520e.hasMessages(1)) {
                        this.f43520e.sendEmptyMessage(1);
                    }
                    return true;
                }
            }
            return false;
        }
    }
}
