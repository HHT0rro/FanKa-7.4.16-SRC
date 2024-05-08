package com.alibaba.wireless.security.open.middletier.fc.ui;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Handler;
import android.os.Message;
import com.alipay.sdk.util.i;
import com.huawei.openalliance.ad.constant.u;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class LocalBroadcastManager {

    /* renamed from: f, reason: collision with root package name */
    private static final Object f4160f = new Object();

    /* renamed from: g, reason: collision with root package name */
    private static LocalBroadcastManager f4161g;

    /* renamed from: a, reason: collision with root package name */
    private final Context f4162a;

    /* renamed from: b, reason: collision with root package name */
    private final HashMap<BroadcastReceiver, ArrayList<IntentFilter>> f4163b = new HashMap<>();

    /* renamed from: c, reason: collision with root package name */
    private final HashMap<String, ArrayList<ReceiverRecord>> f4164c = new HashMap<>();

    /* renamed from: d, reason: collision with root package name */
    private final ArrayList<BroadcastRecord> f4165d = new ArrayList<>();

    /* renamed from: e, reason: collision with root package name */
    private final Handler f4166e;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public static class BroadcastRecord {

        /* renamed from: a, reason: collision with root package name */
        public final Intent f4168a;

        /* renamed from: b, reason: collision with root package name */
        public final ArrayList<ReceiverRecord> f4169b;

        public BroadcastRecord(Intent intent, ArrayList<ReceiverRecord> arrayList) {
            this.f4168a = intent;
            this.f4169b = arrayList;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public static class ReceiverRecord {

        /* renamed from: a, reason: collision with root package name */
        public final IntentFilter f4170a;

        /* renamed from: b, reason: collision with root package name */
        public final BroadcastReceiver f4171b;

        /* renamed from: c, reason: collision with root package name */
        public boolean f4172c;

        public ReceiverRecord(IntentFilter intentFilter, BroadcastReceiver broadcastReceiver) {
            this.f4170a = intentFilter;
            this.f4171b = broadcastReceiver;
        }

        public String toString() {
            StringBuilder sb2 = new StringBuilder(128);
            sb2.append("Receiver{");
            sb2.append((Object) this.f4171b);
            sb2.append(" filter=");
            sb2.append((Object) this.f4170a);
            sb2.append(i.f4738d);
            return sb2.toString();
        }
    }

    private LocalBroadcastManager(Context context) {
        this.f4162a = context;
        this.f4166e = new Handler(context.getMainLooper()) { // from class: com.alibaba.wireless.security.open.middletier.fc.ui.LocalBroadcastManager.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                if (message.what != 1) {
                    super.handleMessage(message);
                } else {
                    LocalBroadcastManager.this.a();
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        int size;
        BroadcastRecord[] broadcastRecordArr;
        while (true) {
            synchronized (this.f4163b) {
                size = this.f4165d.size();
                if (size <= 0) {
                    return;
                }
                broadcastRecordArr = new BroadcastRecord[size];
                this.f4165d.toArray(broadcastRecordArr);
                this.f4165d.clear();
            }
            for (int i10 = 0; i10 < size; i10++) {
                BroadcastRecord broadcastRecord = broadcastRecordArr[i10];
                for (int i11 = 0; i11 < broadcastRecord.f4169b.size(); i11++) {
                    broadcastRecord.f4169b.get(i11).f4171b.onReceive(this.f4162a, broadcastRecord.f4168a);
                }
            }
        }
    }

    public static LocalBroadcastManager getInstance(Context context) {
        LocalBroadcastManager localBroadcastManager;
        synchronized (f4160f) {
            if (f4161g == null) {
                f4161g = new LocalBroadcastManager(context.getApplicationContext());
            }
            localBroadcastManager = f4161g;
        }
        return localBroadcastManager;
    }

    public void registerReceiver(BroadcastReceiver broadcastReceiver, IntentFilter intentFilter) {
        synchronized (this.f4163b) {
            ReceiverRecord receiverRecord = new ReceiverRecord(intentFilter, broadcastReceiver);
            ArrayList<IntentFilter> arrayList = this.f4163b.get(broadcastReceiver);
            if (arrayList == null) {
                arrayList = new ArrayList<>(1);
                this.f4163b.put(broadcastReceiver, arrayList);
            }
            arrayList.add(intentFilter);
            for (int i10 = 0; i10 < intentFilter.countActions(); i10++) {
                String action = intentFilter.getAction(i10);
                ArrayList<ReceiverRecord> arrayList2 = this.f4164c.get(action);
                if (arrayList2 == null) {
                    arrayList2 = new ArrayList<>(1);
                    this.f4164c.put(action, arrayList2);
                }
                arrayList2.add(receiverRecord);
            }
        }
    }

    public boolean sendBroadcast(Intent intent) {
        int i10;
        String str;
        ArrayList arrayList;
        ArrayList<ReceiverRecord> arrayList2;
        String str2;
        synchronized (this.f4163b) {
            String action = intent.getAction();
            String resolveTypeIfNeeded = intent.resolveTypeIfNeeded(this.f4162a.getContentResolver());
            Uri data = intent.getData();
            String scheme = intent.getScheme();
            Set<String> categories = intent.getCategories();
            boolean z10 = (intent.getFlags() & 8) != 0;
            if (z10) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Resolving type ");
                sb2.append(resolveTypeIfNeeded);
                sb2.append(" scheme ");
                sb2.append(scheme);
                sb2.append(" of intent ");
                sb2.append((Object) intent);
            }
            ArrayList<ReceiverRecord> arrayList3 = this.f4164c.get(intent.getAction());
            if (arrayList3 != null) {
                if (z10) {
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append("Action list: ");
                    sb3.append((Object) arrayList3);
                }
                ArrayList arrayList4 = null;
                int i11 = 0;
                while (i11 < arrayList3.size()) {
                    ReceiverRecord receiverRecord = arrayList3.get(i11);
                    if (z10) {
                        StringBuilder sb4 = new StringBuilder();
                        sb4.append("Matching against filter ");
                        sb4.append((Object) receiverRecord.f4170a);
                    }
                    if (receiverRecord.f4172c) {
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
                        int match = receiverRecord.f4170a.match(action, resolveTypeIfNeeded, scheme, data, categories, "LocalBroadcastManager");
                        if (match >= 0) {
                            if (z10) {
                                StringBuilder sb5 = new StringBuilder();
                                sb5.append("  Filter matched!  match=0x");
                                sb5.append(Integer.toHexString(match));
                            }
                            arrayList4 = arrayList == null ? new ArrayList() : arrayList;
                            arrayList4.add(receiverRecord);
                            receiverRecord.f4172c = true;
                            i11 = i10 + 1;
                            action = str;
                            arrayList3 = arrayList2;
                            resolveTypeIfNeeded = str2;
                        } else if (z10) {
                            String str3 = match != -4 ? match != -3 ? match != -2 ? match != -1 ? "unknown reason" : "type" : "data" : "action" : u.ck;
                            StringBuilder sb6 = new StringBuilder();
                            sb6.append("  Filter did not match: ");
                            sb6.append(str3);
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
                        ((ReceiverRecord) arrayList5.get(i12)).f4172c = false;
                    }
                    this.f4165d.add(new BroadcastRecord(intent, arrayList5));
                    if (!this.f4166e.hasMessages(1)) {
                        this.f4166e.sendEmptyMessage(1);
                    }
                    return true;
                }
            }
            return false;
        }
    }

    public void sendBroadcastSync(Intent intent) {
        if (sendBroadcast(intent)) {
            a();
        }
    }

    public void unregisterReceiver(BroadcastReceiver broadcastReceiver) {
        synchronized (this.f4163b) {
            ArrayList<IntentFilter> remove = this.f4163b.remove(broadcastReceiver);
            if (remove == null) {
                return;
            }
            for (int i10 = 0; i10 < remove.size(); i10++) {
                IntentFilter intentFilter = remove.get(i10);
                for (int i11 = 0; i11 < intentFilter.countActions(); i11++) {
                    String action = intentFilter.getAction(i11);
                    ArrayList<ReceiverRecord> arrayList = this.f4164c.get(action);
                    if (arrayList != null) {
                        int i12 = 0;
                        while (i12 < arrayList.size()) {
                            if (arrayList.get(i12).f4171b == broadcastReceiver) {
                                arrayList.remove(i12);
                                i12--;
                            }
                            i12++;
                        }
                        if (arrayList.size() <= 0) {
                            this.f4164c.remove(action);
                        }
                    }
                }
            }
        }
    }
}
