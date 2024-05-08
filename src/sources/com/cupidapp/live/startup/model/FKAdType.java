package com.cupidapp.live.startup.model;

import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.hailiang.advlib.core.ADEvent;
import com.huawei.quickcard.base.Attributes;
import com.wangmai.common.utils.ConstantInfo;
import kotlin.d;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: StartupModel.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public enum FKAdType {
    Image("PHOTO", Attributes.Component.IMAGE),
    Video("VIDEO", "video"),
    GDT("WIDECLICK", "gdt"),
    GDT_CUSTOM("GDT_CUSTOM", "gdtCustom"),
    CSJ("PANGOLIN", "csj"),
    JD("JD", ConstantInfo.THIRD_PARTY_JD),
    KS("KUAISHOU", MediationConstant.ADN_KS),
    BD("BAIDU", "baidu"),
    XiaoMi("XIAOMI", ADEvent.XIAOMI),
    HUAWEI("HUAWEI", "huawei"),
    WM("WANGMAI", "wangmai"),
    HUAWEI_JH("HUAWEI_JH", "huawei_jh"),
    APIAD("api", "api"),
    Unknow("未知", "unknow");


    @NotNull
    public static final a Companion = new a(null);

    @NotNull
    private final String source;

    @NotNull
    private final String type;

    /* compiled from: StartupModel.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final FKAdType a(@Nullable String str) {
            FKAdType fKAdType = FKAdType.Image;
            if (s.d(str, fKAdType.getSource())) {
                return fKAdType;
            }
            FKAdType fKAdType2 = FKAdType.Video;
            if (s.d(str, fKAdType2.getSource())) {
                return fKAdType2;
            }
            FKAdType fKAdType3 = FKAdType.GDT;
            if (s.d(str, fKAdType3.getSource())) {
                return fKAdType3;
            }
            FKAdType fKAdType4 = FKAdType.GDT_CUSTOM;
            if (s.d(str, fKAdType4.getSource())) {
                return fKAdType4;
            }
            FKAdType fKAdType5 = FKAdType.CSJ;
            if (s.d(str, fKAdType5.getSource())) {
                return fKAdType5;
            }
            FKAdType fKAdType6 = FKAdType.JD;
            if (s.d(str, fKAdType6.getSource())) {
                return fKAdType6;
            }
            FKAdType fKAdType7 = FKAdType.KS;
            if (s.d(str, fKAdType7.getSource())) {
                return fKAdType7;
            }
            FKAdType fKAdType8 = FKAdType.BD;
            if (s.d(str, fKAdType8.getSource())) {
                return fKAdType8;
            }
            FKAdType fKAdType9 = FKAdType.XiaoMi;
            if (s.d(str, fKAdType9.getSource())) {
                return fKAdType9;
            }
            FKAdType fKAdType10 = FKAdType.HUAWEI;
            if (s.d(str, fKAdType10.getSource())) {
                return fKAdType10;
            }
            FKAdType fKAdType11 = FKAdType.WM;
            if (s.d(str, fKAdType11.getSource())) {
                return fKAdType11;
            }
            FKAdType fKAdType12 = FKAdType.HUAWEI_JH;
            if (s.d(str, fKAdType12.getSource())) {
                return fKAdType12;
            }
            FKAdType fKAdType13 = FKAdType.APIAD;
            return s.d(str, fKAdType13.getSource()) ? fKAdType13 : FKAdType.Unknow;
        }
    }

    FKAdType(String str, String str2) {
        this.type = str;
        this.source = str2;
    }

    @NotNull
    public final String getSource() {
        return this.source;
    }

    @NotNull
    public final String getType() {
        return this.type;
    }
}
