package com.google.android.gms.internal.vision;

import com.google.android.gms.internal.vision.x4;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-vision-face-contour-internal@@16.1.0 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class zzmt extends x4.c<zzmt, b> {
    private static final zzmt zzs;
    private static volatile o6<zzmt> zzt;
    private int zzd;
    private a zze;
    private float zzg;
    private float zzh;
    private float zzi;
    private float zzj;
    private float zzk;
    private long zzn;
    private long zzo;
    private long zzp;
    private float zzq;
    private byte zzr = 2;
    private g5<zze> zzf = x4.w();
    private g5<c> zzl = x4.w();
    private g5<zza> zzm = x4.w();

    /* compiled from: com.google.android.gms:play-services-vision-face-contour-internal@@16.1.0 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class a extends x4<a, C0219a> implements e6 {
        private static final a zzh;
        private static volatile o6<a> zzi;
        private int zzc;
        private float zzd;
        private float zze;
        private float zzf;
        private float zzg;

        /* compiled from: com.google.android.gms:play-services-vision-face-contour-internal@@16.1.0 */
        /* renamed from: com.google.android.gms.internal.vision.zzmt$a$a, reason: collision with other inner class name */
        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
        public static final class C0219a extends x4.b<a, C0219a> implements e6 {
            public C0219a() {
                super(a.zzh);
            }

            public /* synthetic */ C0219a(a8 a8Var) {
                this();
            }
        }

        static {
            a aVar = new a();
            zzh = aVar;
            x4.q(a.class, aVar);
        }

        public static a B() {
            return zzh;
        }

        public final float A() {
            return this.zzg;
        }

        /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.vision.x4$a, com.google.android.gms.internal.vision.o6<com.google.android.gms.internal.vision.zzmt$a>] */
        @Override // com.google.android.gms.internal.vision.x4
        public final Object n(int i10, Object obj, Object obj2) {
            o6<a> o6Var;
            a8 a8Var = null;
            switch (a8.f25431a[i10 - 1]) {
                case 1:
                    return new a();
                case 2:
                    return new C0219a(a8Var);
                case 3:
                    return x4.o(zzh, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001ခ\u0000\u0002ခ\u0001\u0003ခ\u0002\u0004ခ\u0003", new Object[]{"zzc", "zzd", "zze", "zzf", "zzg"});
                case 4:
                    return zzh;
                case 5:
                    o6<a> o6Var2 = zzi;
                    o6<a> o6Var3 = o6Var2;
                    if (o6Var2 == null) {
                        synchronized (a.class) {
                            o6<a> o6Var4 = zzi;
                            o6Var = o6Var4;
                            if (o6Var4 == null) {
                                ?? aVar = new x4.a(zzh);
                                zzi = aVar;
                                o6Var = aVar;
                            }
                        }
                        o6Var3 = o6Var;
                    }
                    return o6Var3;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        public final float x() {
            return this.zzd;
        }

        public final float y() {
            return this.zze;
        }

        public final float z() {
            return this.zzf;
        }
    }

    /* compiled from: com.google.android.gms:play-services-vision-face-contour-internal@@16.1.0 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class b extends x4.d<zzmt, b> {
        public b() {
            super(zzmt.zzs);
        }

        public /* synthetic */ b(a8 a8Var) {
            this();
        }
    }

    /* compiled from: com.google.android.gms:play-services-vision-face-contour-internal@@16.1.0 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class c extends x4<c, a> implements e6 {
        private static final c zzh;
        private static volatile o6<c> zzi;
        private int zzc;
        private int zzd;
        private zzht zze = zzht.zza;
        private String zzf = "";
        private float zzg;

        /* compiled from: com.google.android.gms:play-services-vision-face-contour-internal@@16.1.0 */
        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
        public static final class a extends x4.b<c, a> implements e6 {
            public a() {
                super(c.zzh);
            }

            public /* synthetic */ a(a8 a8Var) {
                this();
            }
        }

        static {
            c cVar = new c();
            zzh = cVar;
            x4.q(c.class, cVar);
        }

        /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.vision.o6<com.google.android.gms.internal.vision.zzmt$c>, com.google.android.gms.internal.vision.x4$a] */
        @Override // com.google.android.gms.internal.vision.x4
        public final Object n(int i10, Object obj, Object obj2) {
            o6<c> o6Var;
            a8 a8Var = null;
            switch (a8.f25431a[i10 - 1]) {
                case 1:
                    return new c();
                case 2:
                    return new a(a8Var);
                case 3:
                    return x4.o(zzh, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001င\u0000\u0002ည\u0001\u0003ဈ\u0002\u0004ခ\u0003", new Object[]{"zzc", "zzd", "zze", "zzf", "zzg"});
                case 4:
                    return zzh;
                case 5:
                    o6<c> o6Var2 = zzi;
                    o6<c> o6Var3 = o6Var2;
                    if (o6Var2 == null) {
                        synchronized (c.class) {
                            o6<c> o6Var4 = zzi;
                            o6Var = o6Var4;
                            if (o6Var4 == null) {
                                ?? aVar = new x4.a(zzh);
                                zzi = aVar;
                                o6Var = aVar;
                            }
                        }
                        o6Var3 = o6Var;
                    }
                    return o6Var3;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }
    }

    /* compiled from: com.google.android.gms:play-services-vision-face-contour-internal@@16.1.0 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class zza extends x4<zza, a> implements e6 {
        private static final zza zzh;
        private static volatile o6<zza> zzi;
        private int zzc;
        private int zzd;
        private String zze = "";
        private float zzf;
        private float zzg;

        /* compiled from: com.google.android.gms:play-services-vision-face-contour-internal@@16.1.0 */
        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
        public static final class a extends x4.b<zza, a> implements e6 {
            public a() {
                super(zza.zzh);
            }

            public /* synthetic */ a(a8 a8Var) {
                this();
            }
        }

        /* compiled from: com.google.android.gms:play-services-vision-face-contour-internal@@16.1.0 */
        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
        public enum zzb implements a5 {
            TYPE_UNKNOWN(0),
            FREE_FORM(1),
            FEMALE(2),
            MALE(3),
            AGE(5),
            NON_HUMAN(6),
            GLASSES(7),
            DARK_GLASSES(8),
            HEADWEAR(9),
            EYES_VISIBLE(10),
            LEFT_EYELID_CLOSED(16),
            RIGHT_EYELID_CLOSED(17),
            MOUTH_OPEN(11),
            FACIAL_HAIR(12),
            LONG_HAIR(13),
            FRONTAL_GAZE(14),
            SMILING(15),
            UNDER_EXPOSED(18),
            BLURRED(19),
            LEFT_EYE_VISIBLE(20),
            RIGHT_EYE_VISIBLE(21),
            LEFT_EAR_VISIBLE(22),
            RIGHT_EAR_VISIBLE(23),
            NOSE_TIP_VISIBLE(24),
            MOUTH_CENTER_VISIBLE(25);

            private static final d5<zzb> zzz = new b8();
            private final int zzaa;

            zzb(int i10) {
                this.zzaa = i10;
            }

            public static c5 zzb() {
                return c8.f25451a;
            }

            @Override // java.lang.Enum
            public final String toString() {
                return "<" + zzb.class.getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.zzaa + " name=" + name() + '>';
            }

            @Override // com.google.android.gms.internal.vision.a5
            public final int zza() {
                return this.zzaa;
            }

            public static zzb zza(int i10) {
                switch (i10) {
                    case 0:
                        return TYPE_UNKNOWN;
                    case 1:
                        return FREE_FORM;
                    case 2:
                        return FEMALE;
                    case 3:
                        return MALE;
                    case 4:
                    default:
                        return null;
                    case 5:
                        return AGE;
                    case 6:
                        return NON_HUMAN;
                    case 7:
                        return GLASSES;
                    case 8:
                        return DARK_GLASSES;
                    case 9:
                        return HEADWEAR;
                    case 10:
                        return EYES_VISIBLE;
                    case 11:
                        return MOUTH_OPEN;
                    case 12:
                        return FACIAL_HAIR;
                    case 13:
                        return LONG_HAIR;
                    case 14:
                        return FRONTAL_GAZE;
                    case 15:
                        return SMILING;
                    case 16:
                        return LEFT_EYELID_CLOSED;
                    case 17:
                        return RIGHT_EYELID_CLOSED;
                    case 18:
                        return UNDER_EXPOSED;
                    case 19:
                        return BLURRED;
                    case 20:
                        return LEFT_EYE_VISIBLE;
                    case 21:
                        return RIGHT_EYE_VISIBLE;
                    case 22:
                        return LEFT_EAR_VISIBLE;
                    case 23:
                        return RIGHT_EAR_VISIBLE;
                    case 24:
                        return NOSE_TIP_VISIBLE;
                    case 25:
                        return MOUTH_CENTER_VISIBLE;
                }
            }
        }

        static {
            zza zzaVar = new zza();
            zzh = zzaVar;
            x4.q(zza.class, zzaVar);
        }

        /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.vision.o6<com.google.android.gms.internal.vision.zzmt$zza>, com.google.android.gms.internal.vision.x4$a] */
        @Override // com.google.android.gms.internal.vision.x4
        public final Object n(int i10, Object obj, Object obj2) {
            o6<zza> o6Var;
            a8 a8Var = null;
            switch (a8.f25431a[i10 - 1]) {
                case 1:
                    return new zza();
                case 2:
                    return new a(a8Var);
                case 3:
                    return x4.o(zzh, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001ဌ\u0000\u0002ဈ\u0001\u0003ခ\u0002\u0004ခ\u0003", new Object[]{"zzc", "zzd", zzb.zzb(), "zze", "zzf", "zzg"});
                case 4:
                    return zzh;
                case 5:
                    o6<zza> o6Var2 = zzi;
                    o6<zza> o6Var3 = o6Var2;
                    if (o6Var2 == null) {
                        synchronized (zza.class) {
                            o6<zza> o6Var4 = zzi;
                            o6Var = o6Var4;
                            if (o6Var4 == null) {
                                ?? aVar = new x4.a(zzh);
                                zzi = aVar;
                                o6Var = aVar;
                            }
                        }
                        o6Var3 = o6Var;
                    }
                    return o6Var3;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        public final String x() {
            return this.zze;
        }

        public final float y() {
            return this.zzf;
        }
    }

    /* compiled from: com.google.android.gms:play-services-vision-face-contour-internal@@16.1.0 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class zze extends x4<zze, a> implements e6 {
        private static final zze zzj;
        private static volatile o6<zze> zzk;
        private int zzc;
        private float zzd;
        private float zze;
        private float zzf;
        private int zzg = 15000;
        private int zzh;
        private float zzi;

        /* compiled from: com.google.android.gms:play-services-vision-face-contour-internal@@16.1.0 */
        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
        public static final class a extends x4.b<zze, a> implements e6 {
            public a() {
                super(zze.zzj);
            }

            public /* synthetic */ a(a8 a8Var) {
                this();
            }
        }

        /* compiled from: com.google.android.gms:play-services-vision-face-contour-internal@@16.1.0 */
        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
        public enum zzb implements a5 {
            LEFT_EYE(0),
            RIGHT_EYE(1),
            LEFT_OF_LEFT_EYEBROW(2),
            RIGHT_OF_LEFT_EYEBROW(3),
            LEFT_OF_RIGHT_EYEBROW(4),
            RIGHT_OF_RIGHT_EYEBROW(5),
            MIDPOINT_BETWEEN_EYES(6),
            NOSE_TIP(9),
            UPPER_LIP(10),
            LOWER_LIP(11),
            MOUTH_LEFT(12),
            MOUTH_RIGHT(13),
            MOUTH_CENTER(45),
            NOSE_BOTTOM_RIGHT(43),
            NOSE_BOTTOM_LEFT(44),
            NOSE_BOTTOM_CENTER(200),
            LEFT_EYE_TOP_BOUNDARY(220),
            LEFT_EYE_RIGHT_CORNER(221),
            LEFT_EYE_BOTTOM_BOUNDARY(222),
            LEFT_EYE_LEFT_CORNER(223),
            RIGHT_EYE_TOP_BOUNDARY(224),
            RIGHT_EYE_RIGHT_CORNER(225),
            RIGHT_EYE_BOTTOM_BOUNDARY(226),
            RIGHT_EYE_LEFT_CORNER(227),
            LEFT_EYEBROW_UPPER_MIDPOINT(300),
            RIGHT_EYEBROW_UPPER_MIDPOINT(302),
            LEFT_EAR_TRAGION(240),
            RIGHT_EAR_TRAGION(241),
            LEFT_EYE_PUPIL(304),
            RIGHT_EYE_PUPIL(305),
            FOREHEAD_GLABELLA(312),
            CHIN_GNATHION(314),
            CHIN_LEFT_GONION(315),
            CHIN_RIGHT_GONION(316),
            LEFT_CHEEK_CENTER(238),
            RIGHT_CHEEK_CENTER(239),
            LEFT_EAR_TOP(242),
            RIGHT_EAR_TOP(243),
            LANDMARK_UNKNOWN(15000);

            private static final d5<zzb> zzan = new d8();
            private final int zzao;

            zzb(int i10) {
                this.zzao = i10;
            }

            public static c5 zzb() {
                return e8.f25459a;
            }

            @Override // java.lang.Enum
            public final String toString() {
                return "<" + zzb.class.getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.zzao + " name=" + name() + '>';
            }

            @Override // com.google.android.gms.internal.vision.a5
            public final int zza() {
                return this.zzao;
            }

            public static zzb zza(int i10) {
                if (i10 == 200) {
                    return NOSE_BOTTOM_CENTER;
                }
                if (i10 == 300) {
                    return LEFT_EYEBROW_UPPER_MIDPOINT;
                }
                if (i10 == 302) {
                    return RIGHT_EYEBROW_UPPER_MIDPOINT;
                }
                if (i10 == 312) {
                    return FOREHEAD_GLABELLA;
                }
                if (i10 == 15000) {
                    return LANDMARK_UNKNOWN;
                }
                if (i10 == 304) {
                    return LEFT_EYE_PUPIL;
                }
                if (i10 != 305) {
                    switch (i10) {
                        case 0:
                            return LEFT_EYE;
                        case 1:
                            return RIGHT_EYE;
                        case 2:
                            return LEFT_OF_LEFT_EYEBROW;
                        case 3:
                            return RIGHT_OF_LEFT_EYEBROW;
                        case 4:
                            return LEFT_OF_RIGHT_EYEBROW;
                        case 5:
                            return RIGHT_OF_RIGHT_EYEBROW;
                        case 6:
                            return MIDPOINT_BETWEEN_EYES;
                        default:
                            switch (i10) {
                                case 9:
                                    return NOSE_TIP;
                                case 10:
                                    return UPPER_LIP;
                                case 11:
                                    return LOWER_LIP;
                                case 12:
                                    return MOUTH_LEFT;
                                case 13:
                                    return MOUTH_RIGHT;
                                default:
                                    switch (i10) {
                                        case 43:
                                            return NOSE_BOTTOM_RIGHT;
                                        case 44:
                                            return NOSE_BOTTOM_LEFT;
                                        case 45:
                                            return MOUTH_CENTER;
                                        default:
                                            switch (i10) {
                                                case 220:
                                                    return LEFT_EYE_TOP_BOUNDARY;
                                                case 221:
                                                    return LEFT_EYE_RIGHT_CORNER;
                                                case 222:
                                                    return LEFT_EYE_BOTTOM_BOUNDARY;
                                                case 223:
                                                    return LEFT_EYE_LEFT_CORNER;
                                                case 224:
                                                    return RIGHT_EYE_TOP_BOUNDARY;
                                                case 225:
                                                    return RIGHT_EYE_RIGHT_CORNER;
                                                case 226:
                                                    return RIGHT_EYE_BOTTOM_BOUNDARY;
                                                case 227:
                                                    return RIGHT_EYE_LEFT_CORNER;
                                                default:
                                                    switch (i10) {
                                                        case 238:
                                                            return LEFT_CHEEK_CENTER;
                                                        case 239:
                                                            return RIGHT_CHEEK_CENTER;
                                                        case 240:
                                                            return LEFT_EAR_TRAGION;
                                                        case 241:
                                                            return RIGHT_EAR_TRAGION;
                                                        case 242:
                                                            return LEFT_EAR_TOP;
                                                        case 243:
                                                            return RIGHT_EAR_TOP;
                                                        default:
                                                            switch (i10) {
                                                                case 314:
                                                                    return CHIN_GNATHION;
                                                                case 315:
                                                                    return CHIN_LEFT_GONION;
                                                                case 316:
                                                                    return CHIN_RIGHT_GONION;
                                                                default:
                                                                    return null;
                                                            }
                                                    }
                                            }
                                    }
                            }
                    }
                }
                return RIGHT_EYE_PUPIL;
            }
        }

        /* compiled from: com.google.android.gms:play-services-vision-face-contour-internal@@16.1.0 */
        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
        public enum zzc implements a5 {
            VISIBILITY_UNKNOWN(0),
            VISIBLE(1),
            OCCLUDED_SELF(2),
            OCCLUDED_OTHER(3);

            private static final d5<zzc> zze = new g8();
            private final int zzf;

            zzc(int i10) {
                this.zzf = i10;
            }

            public static c5 zzb() {
                return f8.f25469a;
            }

            @Override // java.lang.Enum
            public final String toString() {
                return "<" + zzc.class.getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.zzf + " name=" + name() + '>';
            }

            @Override // com.google.android.gms.internal.vision.a5
            public final int zza() {
                return this.zzf;
            }

            public static zzc zza(int i10) {
                if (i10 == 0) {
                    return VISIBILITY_UNKNOWN;
                }
                if (i10 == 1) {
                    return VISIBLE;
                }
                if (i10 == 2) {
                    return OCCLUDED_SELF;
                }
                if (i10 != 3) {
                    return null;
                }
                return OCCLUDED_OTHER;
            }
        }

        static {
            zze zzeVar = new zze();
            zzj = zzeVar;
            x4.q(zze.class, zzeVar);
        }

        /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.vision.x4$a, com.google.android.gms.internal.vision.o6<com.google.android.gms.internal.vision.zzmt$zze>] */
        @Override // com.google.android.gms.internal.vision.x4
        public final Object n(int i10, Object obj, Object obj2) {
            o6<zze> o6Var;
            a8 a8Var = null;
            switch (a8.f25431a[i10 - 1]) {
                case 1:
                    return new zze();
                case 2:
                    return new a(a8Var);
                case 3:
                    return x4.o(zzj, "\u0001\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0000\u0000\u0001ခ\u0000\u0002ခ\u0001\u0003ခ\u0002\u0004ဌ\u0003\u0005ဌ\u0004\u0006ခ\u0005", new Object[]{"zzc", "zzd", "zze", "zzf", "zzg", zzb.zzb(), "zzh", zzc.zzb(), "zzi"});
                case 4:
                    return zzj;
                case 5:
                    o6<zze> o6Var2 = zzk;
                    o6<zze> o6Var3 = o6Var2;
                    if (o6Var2 == null) {
                        synchronized (zze.class) {
                            o6<zze> o6Var4 = zzk;
                            o6Var = o6Var4;
                            if (o6Var4 == null) {
                                ?? aVar = new x4.a(zzj);
                                zzk = aVar;
                                o6Var = aVar;
                            }
                        }
                        o6Var3 = o6Var;
                    }
                    return o6Var3;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        public final float x() {
            return this.zzd;
        }

        public final float y() {
            return this.zze;
        }

        public final zzb z() {
            zzb zza = zzb.zza(this.zzg);
            return zza == null ? zzb.LANDMARK_UNKNOWN : zza;
        }
    }

    static {
        zzmt zzmtVar = new zzmt();
        zzs = zzmtVar;
        x4.q(zzmt.class, zzmtVar);
    }

    public static zzmt I() {
        return zzs;
    }

    public final List<zze> A() {
        return this.zzf;
    }

    public final boolean B() {
        return (this.zzd & 2) != 0;
    }

    public final float C() {
        return this.zzg;
    }

    public final float D() {
        return this.zzh;
    }

    public final float E() {
        return this.zzi;
    }

    public final float F() {
        return this.zzj;
    }

    public final List<zza> G() {
        return this.zzm;
    }

    public final long H() {
        return this.zzo;
    }

    /* JADX WARN: Type inference failed for: r3v14, types: [com.google.android.gms.internal.vision.x4$a, com.google.android.gms.internal.vision.o6<com.google.android.gms.internal.vision.zzmt>] */
    @Override // com.google.android.gms.internal.vision.x4
    public final Object n(int i10, Object obj, Object obj2) {
        o6<zzmt> o6Var;
        a8 a8Var = null;
        switch (a8.f25431a[i10 - 1]) {
            case 1:
                return new zzmt();
            case 2:
                return new b(a8Var);
            case 3:
                return x4.o(zzs, "\u0001\r\u0000\u0001\u0001\r\r\u0000\u0003\u0000\u0001ဉ\u0000\u0002\u001b\u0003ခ\u0001\u0004ခ\u0002\u0005ခ\u0003\u0006ခ\u0004\u0007\u001b\b\u001b\tဃ\u0007\nခ\t\u000bဃ\b\fဃ\u0006\rခ\u0005", new Object[]{"zzd", "zze", "zzf", zze.class, "zzg", "zzh", "zzi", "zzj", "zzl", c.class, "zzm", zza.class, "zzo", "zzq", "zzp", "zzn", "zzk"});
            case 4:
                return zzs;
            case 5:
                o6<zzmt> o6Var2 = zzt;
                o6<zzmt> o6Var3 = o6Var2;
                if (o6Var2 == null) {
                    synchronized (zzmt.class) {
                        o6<zzmt> o6Var4 = zzt;
                        o6Var = o6Var4;
                        if (o6Var4 == null) {
                            ?? aVar = new x4.a(zzs);
                            zzt = aVar;
                            o6Var = aVar;
                        }
                    }
                    o6Var3 = o6Var;
                }
                return o6Var3;
            case 6:
                return Byte.valueOf(this.zzr);
            case 7:
                this.zzr = (byte) (obj == null ? 0 : 1);
                return null;
            default:
                throw new UnsupportedOperationException();
        }
    }

    public final a z() {
        a aVar = this.zze;
        return aVar == null ? a.B() : aVar;
    }
}
