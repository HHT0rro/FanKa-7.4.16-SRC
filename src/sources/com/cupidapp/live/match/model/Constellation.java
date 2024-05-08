package com.cupidapp.live.match.model;

import com.cupidapp.live.R$mipmap;
import kotlin.d;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

/* compiled from: MatchModel.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public enum Constellation {
    Aries("白羊座", R$mipmap.icon_aries, 5),
    Taurus("金牛座", R$mipmap.icon_taurus, 6),
    Gemini("双子座", R$mipmap.icon_gemini, 7),
    Cancer("巨蟹座", R$mipmap.icon_cancer, 8),
    Leo("狮子座", R$mipmap.icon_leo, 9),
    Virgo("处女座", R$mipmap.icon_virgo, 10),
    Libra("天秤座", R$mipmap.icon_libra, 11),
    Scorpio("天蝎座", R$mipmap.icon_scorpio, 12),
    Sagittarius("射手座", R$mipmap.icon_sagittarius, 13),
    Capricorn("摩羯座", R$mipmap.icon_capricorn, 14),
    Aquarius("水瓶座", R$mipmap.icon_aquarius, 15),
    Pisces("双鱼座", R$mipmap.icon_pisces, 16);


    @NotNull
    public static final a Companion = new a(null);

    @NotNull
    private final String constellationName;
    private final int icon;
    private final int type;

    /* compiled from: MatchModel.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final int a(int i10) {
            Constellation constellation = Constellation.Aquarius;
            if (i10 == constellation.getType()) {
                return constellation.getIcon();
            }
            Constellation constellation2 = Constellation.Pisces;
            if (i10 == constellation2.getType()) {
                return constellation2.getIcon();
            }
            Constellation constellation3 = Constellation.Aries;
            if (i10 == constellation3.getType()) {
                return constellation3.getIcon();
            }
            Constellation constellation4 = Constellation.Taurus;
            if (i10 == constellation4.getType()) {
                return constellation4.getIcon();
            }
            Constellation constellation5 = Constellation.Gemini;
            if (i10 == constellation5.getType()) {
                return constellation5.getIcon();
            }
            Constellation constellation6 = Constellation.Cancer;
            if (i10 == constellation6.getType()) {
                return constellation6.getIcon();
            }
            Constellation constellation7 = Constellation.Leo;
            if (i10 == constellation7.getType()) {
                return constellation7.getIcon();
            }
            Constellation constellation8 = Constellation.Virgo;
            if (i10 == constellation8.getType()) {
                return constellation8.getIcon();
            }
            Constellation constellation9 = Constellation.Libra;
            if (i10 == constellation9.getType()) {
                return constellation9.getIcon();
            }
            Constellation constellation10 = Constellation.Scorpio;
            if (i10 == constellation10.getType()) {
                return constellation10.getIcon();
            }
            Constellation constellation11 = Constellation.Sagittarius;
            if (i10 == constellation11.getType()) {
                return constellation11.getIcon();
            }
            Constellation constellation12 = Constellation.Capricorn;
            if (i10 == constellation12.getType()) {
                return constellation12.getIcon();
            }
            return 0;
        }
    }

    Constellation(String str, int i10, int i11) {
        this.constellationName = str;
        this.icon = i10;
        this.type = i11;
    }

    public final int getIcon() {
        return this.icon;
    }

    public final int getType() {
        return this.type;
    }
}
