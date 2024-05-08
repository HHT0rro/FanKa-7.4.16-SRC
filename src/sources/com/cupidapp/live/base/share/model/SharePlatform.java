package com.cupidapp.live.base.share.model;

import com.tencent.connect.common.Constants;
import kotlin.d;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FKShareModel.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public enum SharePlatform implements ShareBaseType {
    Wechat("Wechat"),
    WechatMoments("WechatMoments"),
    QQ(Constants.SOURCE_QQ),
    QZone("QZone"),
    Weibo("Weibo"),
    Copylink("Copylink");


    @NotNull
    public static final a Companion = new a(null);

    @NotNull
    private final String value;

    /* compiled from: FKShareModel.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Nullable
        public final SharePlatform a(@Nullable String str) {
            SharePlatform sharePlatform = SharePlatform.Wechat;
            if (s.d(str, sharePlatform.getValue())) {
                return sharePlatform;
            }
            SharePlatform sharePlatform2 = SharePlatform.WechatMoments;
            if (s.d(str, sharePlatform2.getValue())) {
                return sharePlatform2;
            }
            SharePlatform sharePlatform3 = SharePlatform.QQ;
            if (s.d(str, sharePlatform3.getValue())) {
                return sharePlatform3;
            }
            SharePlatform sharePlatform4 = SharePlatform.QZone;
            if (s.d(str, sharePlatform4.getValue())) {
                return sharePlatform4;
            }
            SharePlatform sharePlatform5 = SharePlatform.Weibo;
            if (s.d(str, sharePlatform5.getValue())) {
                return sharePlatform5;
            }
            SharePlatform sharePlatform6 = SharePlatform.Copylink;
            if (s.d(str, sharePlatform6.getValue())) {
                return sharePlatform6;
            }
            return null;
        }
    }

    SharePlatform(String str) {
        this.value = str;
    }

    @NotNull
    public final String getValue() {
        return this.value;
    }
}
