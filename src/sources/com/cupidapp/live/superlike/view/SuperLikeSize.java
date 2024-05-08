package com.cupidapp.live.superlike.view;

import kotlin.jvm.internal.o;

/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Init of enum field 'SMALL' uses external variables
	at jadx.core.dex.visitors.EnumVisitor.createEnumFieldByConstructor(EnumVisitor.java:451)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByField(EnumVisitor.java:372)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByWrappedInsn(EnumVisitor.java:337)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromFilledArray(EnumVisitor.java:322)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:262)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInvoke(EnumVisitor.java:293)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:266)
	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:151)
	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:100)
 */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* compiled from: SuperLikeTagView.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class SuperLikeSize {
    private static final /* synthetic */ SuperLikeSize[] $VALUES;
    public static final SuperLikeSize BIG;
    public static final SuperLikeSize MEDIUM;
    public static final SuperLikeSize SMALL;
    public static final SuperLikeSize SuperBIG;
    private final float countTxtSize;
    private final int iconSize;
    private final float txtSize;
    private final int value;

    private static final /* synthetic */ SuperLikeSize[] $values() {
        return new SuperLikeSize[]{SMALL, MEDIUM, BIG, SuperBIG};
    }

    static {
        o oVar = new Object() { // from class: kotlin.jvm.internal.o
        };
        SMALL = new SuperLikeSize("SMALL", 0, z0.h.c(oVar, 12.0f), 8.0f, 10.0f, 0);
        MEDIUM = new SuperLikeSize("MEDIUM", 1, z0.h.c(oVar, 15.0f), 10.0f, 12.0f, 1);
        BIG = new SuperLikeSize("BIG", 2, z0.h.c(oVar, 20.0f), 13.0f, 16.0f, 2);
        SuperBIG = new SuperLikeSize("SuperBIG", 3, z0.h.c(oVar, 40.0f), 28.0f, 37.0f, 3);
        $VALUES = $values();
    }

    private SuperLikeSize(String str, int i10, int i11, float f10, float f11, int i12) {
        this.iconSize = i11;
        this.txtSize = f10;
        this.countTxtSize = f11;
        this.value = i12;
    }

    public static SuperLikeSize valueOf(String str) {
        return (SuperLikeSize) Enum.valueOf(SuperLikeSize.class, str);
    }

    public static SuperLikeSize[] values() {
        return (SuperLikeSize[]) $VALUES.clone();
    }

    public final float getCountTxtSize() {
        return this.countTxtSize;
    }

    public final int getIconSize() {
        return this.iconSize;
    }

    public final float getTxtSize() {
        return this.txtSize;
    }

    public final int getValue() {
        return this.value;
    }
}
