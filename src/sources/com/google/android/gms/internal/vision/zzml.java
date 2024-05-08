package com.google.android.gms.internal.vision;

/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Init of enum field 'zzc' uses external variables
	at jadx.core.dex.visitors.EnumVisitor.createEnumFieldByConstructor(EnumVisitor.java:451)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByRegister(EnumVisitor.java:395)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromFilledArray(EnumVisitor.java:324)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:262)
	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:151)
	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:100)
 */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* compiled from: com.google.android.gms:play-services-vision-common@@19.1.3 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public class zzml {
    public static final zzml zza;
    public static final zzml zzb;
    public static final zzml zzc;
    public static final zzml zzd;
    public static final zzml zze;
    public static final zzml zzf;
    public static final zzml zzg;
    public static final zzml zzh;
    public static final zzml zzi;
    public static final zzml zzj;
    public static final zzml zzk;
    public static final zzml zzl;
    public static final zzml zzm;
    public static final zzml zzn;
    public static final zzml zzo;
    public static final zzml zzp;
    public static final zzml zzq;
    public static final zzml zzr;
    private static final /* synthetic */ zzml[] zzu;
    private final zzmo zzs;
    private final int zzt;

    static {
        zzml zzmlVar = new zzml("DOUBLE", 0, zzmo.DOUBLE, 1);
        zza = zzmlVar;
        zzml zzmlVar2 = new zzml("FLOAT", 1, zzmo.FLOAT, 5);
        zzb = zzmlVar2;
        zzmo zzmoVar = zzmo.LONG;
        final int i10 = 2;
        zzml zzmlVar3 = new zzml("INT64", 2, zzmoVar, 0);
        zzc = zzmlVar3;
        final int i11 = 3;
        zzml zzmlVar4 = new zzml("UINT64", 3, zzmoVar, 0);
        zzd = zzmlVar4;
        zzmo zzmoVar2 = zzmo.INT;
        zzml zzmlVar5 = new zzml("INT32", 4, zzmoVar2, 0);
        zze = zzmlVar5;
        zzml zzmlVar6 = new zzml("FIXED64", 5, zzmoVar, 1);
        zzf = zzmlVar6;
        zzml zzmlVar7 = new zzml("FIXED32", 6, zzmoVar2, 5);
        zzg = zzmlVar7;
        zzml zzmlVar8 = new zzml("BOOL", 7, zzmo.BOOLEAN, 0);
        zzh = zzmlVar8;
        final zzmo zzmoVar3 = zzmo.STRING;
        final String str = "STRING";
        final int i12 = 8;
        zzml zzmlVar9 = new zzml(str, i12, zzmoVar3, i10) { // from class: com.google.android.gms.internal.vision.zzmk
            {
                int i13 = 8;
                int i14 = 2;
            }
        };
        zzi = zzmlVar9;
        final zzmo zzmoVar4 = zzmo.MESSAGE;
        final String str2 = "GROUP";
        final int i13 = 9;
        zzml zzmlVar10 = new zzml(str2, i13, zzmoVar4, i11) { // from class: com.google.android.gms.internal.vision.zzmn
            {
                int i14 = 9;
                int i15 = 3;
            }
        };
        zzj = zzmlVar10;
        final String str3 = "MESSAGE";
        final int i14 = 10;
        final int i15 = 2;
        zzml zzmlVar11 = new zzml(str3, i14, zzmoVar4, i15) { // from class: com.google.android.gms.internal.vision.zzmm
            {
                int i16 = 10;
                int i17 = 2;
            }
        };
        zzk = zzmlVar11;
        final zzmo zzmoVar5 = zzmo.BYTE_STRING;
        final String str4 = "BYTES";
        final int i16 = 11;
        zzml zzmlVar12 = new zzml(str4, i16, zzmoVar5, i15) { // from class: com.google.android.gms.internal.vision.zzmp
            {
                int i17 = 11;
                int i18 = 2;
            }
        };
        zzl = zzmlVar12;
        zzml zzmlVar13 = new zzml("UINT32", 12, zzmoVar2, 0);
        zzm = zzmlVar13;
        zzml zzmlVar14 = new zzml("ENUM", 13, zzmo.ENUM, 0);
        zzn = zzmlVar14;
        zzml zzmlVar15 = new zzml("SFIXED32", 14, zzmoVar2, 5);
        zzo = zzmlVar15;
        zzml zzmlVar16 = new zzml("SFIXED64", 15, zzmoVar, 1);
        zzp = zzmlVar16;
        zzml zzmlVar17 = new zzml("SINT32", 16, zzmoVar2, 0);
        zzq = zzmlVar17;
        zzml zzmlVar18 = new zzml("SINT64", 17, zzmoVar, 0);
        zzr = zzmlVar18;
        zzu = new zzml[]{zzmlVar, zzmlVar2, zzmlVar3, zzmlVar4, zzmlVar5, zzmlVar6, zzmlVar7, zzmlVar8, zzmlVar9, zzmlVar10, zzmlVar11, zzmlVar12, zzmlVar13, zzmlVar14, zzmlVar15, zzmlVar16, zzmlVar17, zzmlVar18};
    }

    private zzml(String str, int i10, zzmo zzmoVar, int i11) {
        this.zzs = zzmoVar;
        this.zzt = i11;
    }

    public static zzml[] values() {
        return (zzml[]) zzu.clone();
    }

    public final zzmo zza() {
        return this.zzs;
    }

    public final int zzb() {
        return this.zzt;
    }
}
