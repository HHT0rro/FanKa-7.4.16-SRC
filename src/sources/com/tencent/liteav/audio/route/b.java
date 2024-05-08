package com.tencent.liteav.audio.route;

import java.util.HashMap;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public final a f42674a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f42675b;

    /* renamed from: c, reason: collision with root package name */
    public int f42676c;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public enum a {
        NONE(-1),
        SPEAKERPHONE(0),
        EARPHONE(1),
        WIRED_HEADSET(2),
        BLUETOOTH_HEADSET(3),
        SOUNDCARD(4);


        /* renamed from: g, reason: collision with root package name */
        private static final HashMap<String, a> f42683g = new HashMap<String, a>() { // from class: com.tencent.liteav.audio.route.b.a.1
            {
                put("NONE", a.NONE);
                put("EARPHONE", a.EARPHONE);
                put("SPEAKERPHONE", a.SPEAKERPHONE);
                put("WIRED_HEADSET", a.WIRED_HEADSET);
                put("BLUETOOTH_HEADSET", a.BLUETOOTH_HEADSET);
                put("SOUNDCARD", a.SOUNDCARD);
            }
        };
        public int value;

        a(int i10) {
            this.value = i10;
        }

        public static a a(String str) {
            a aVar = f42683g.get(str);
            return aVar == null ? NONE : aVar;
        }
    }

    public b(a aVar, int i10, boolean z10) {
        this.f42674a = aVar;
        this.f42676c = i10;
        this.f42675b = z10;
    }
}
