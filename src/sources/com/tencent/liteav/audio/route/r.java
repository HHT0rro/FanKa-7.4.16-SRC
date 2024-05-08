package com.tencent.liteav.audio.route;

import com.tencent.liteav.audio.route.b;
import com.tencent.liteav.base.Log;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class r {

    /* renamed from: a, reason: collision with root package name */
    public static final b.a f42709a = b.a.SPEAKERPHONE;

    /* renamed from: b, reason: collision with root package name */
    public final HashMap<b.a, b> f42710b = new HashMap<>();

    /* renamed from: c, reason: collision with root package name */
    public boolean f42711c = false;

    private void b(b.a aVar) {
        int i10;
        b bVar = this.f42710b.get(aVar);
        if (bVar == null) {
            Log.e("AudioRouteSupervisor", "error in promoteRoutePriority, route(%s) is not existed", aVar);
            return;
        }
        int i11 = bVar.f42676c;
        if (i11 == this.f42710b.size() - 1) {
            return;
        }
        bVar.f42676c = this.f42710b.size() - 1;
        Iterator<Map.Entry<b.a, b>> iterator2 = this.f42710b.entrySet().iterator2();
        while (iterator2.hasNext()) {
            b value = iterator2.next().getValue();
            if (aVar != value.f42674a && (i10 = value.f42676c) >= i11) {
                value.f42676c = i10 - 1;
            }
        }
    }

    public final boolean a(b.a aVar, boolean z10) {
        if (!this.f42711c) {
            Log.e("AudioRouteSupervisor", "error in updateRouteAvailability(), it's not been initialized yet", new Object[0]);
            return false;
        }
        b bVar = this.f42710b.get(aVar);
        if (bVar == null) {
            Log.e("AudioRouteSupervisor", "updateRouteAvailability failed, name: %s", aVar);
            return false;
        }
        bVar.f42675b = z10;
        if (z10 && a(aVar)) {
            b(aVar);
        }
        return true;
    }

    private static boolean a(b.a aVar) {
        return aVar == b.a.WIRED_HEADSET || aVar == b.a.BLUETOOTH_HEADSET || aVar == b.a.SOUNDCARD;
    }
}
