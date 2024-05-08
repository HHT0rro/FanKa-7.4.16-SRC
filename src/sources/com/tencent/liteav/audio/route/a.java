package com.tencent.liteav.audio.route;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public enum a {
    STOPPED(1),
    VOICE_PLAY_AND_RECORD(2),
    MEDIA_PLAY_AND_RECORD(3),
    MEDIA_PLAYBACK(4),
    VOICE_PLAYBACK(5);

    public int mValue;

    /* renamed from: com.tencent.liteav.audio.route.a$1, reason: invalid class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f42673a;

        static {
            int[] iArr = new int[a.values().length];
            f42673a = iArr;
            try {
                iArr[a.VOICE_PLAY_AND_RECORD.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f42673a[a.VOICE_PLAYBACK.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f42673a[a.MEDIA_PLAY_AND_RECORD.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f42673a[a.MEDIA_PLAYBACK.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    a(int i10) {
        this.mValue = i10;
    }

    public static a a(int i10) {
        for (a aVar : values()) {
            if (aVar.mValue == i10) {
                return aVar;
            }
        }
        return STOPPED;
    }

    public static int a(a aVar) {
        int i10 = AnonymousClass1.f42673a[aVar.ordinal()];
        return (i10 == 1 || i10 == 2) ? 3 : 0;
    }

    public final boolean a() {
        return this == VOICE_PLAY_AND_RECORD || this == VOICE_PLAYBACK;
    }
}
