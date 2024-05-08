package com.cupidapp.live.maskparty.model;

import com.cupidapp.live.R$mipmap;
import kotlin.d;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: MaskPartyChatMessageModel.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public enum DicePoint {
    PointOne(1, R$mipmap.icon_point_one),
    PointTwo(2, R$mipmap.icon_point_two),
    PointThree(3, R$mipmap.icon_point_three),
    PointFour(4, R$mipmap.icon_point_four),
    PointFive(5, R$mipmap.icon_point_five),
    PointSix(6, R$mipmap.icon_point_six);


    @NotNull
    public static final a Companion = new a(null);
    private final int icon;
    private final int point;

    /* compiled from: MaskPartyChatMessageModel.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Nullable
        public final DicePoint a(int i10) {
            DicePoint dicePoint = DicePoint.PointOne;
            if (i10 == dicePoint.getPoint()) {
                return dicePoint;
            }
            DicePoint dicePoint2 = DicePoint.PointTwo;
            if (i10 == dicePoint2.getPoint()) {
                return dicePoint2;
            }
            DicePoint dicePoint3 = DicePoint.PointThree;
            if (i10 == dicePoint3.getPoint()) {
                return dicePoint3;
            }
            DicePoint dicePoint4 = DicePoint.PointFour;
            if (i10 == dicePoint4.getPoint()) {
                return dicePoint4;
            }
            DicePoint dicePoint5 = DicePoint.PointFive;
            if (i10 == dicePoint5.getPoint()) {
                return dicePoint5;
            }
            DicePoint dicePoint6 = DicePoint.PointSix;
            if (i10 == dicePoint6.getPoint()) {
                return dicePoint6;
            }
            return null;
        }
    }

    DicePoint(int i10, int i11) {
        this.point = i10;
        this.icon = i11;
    }

    public final int getIcon() {
        return this.icon;
    }

    public final int getPoint() {
        return this.point;
    }
}
