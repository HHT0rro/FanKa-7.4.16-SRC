package com.cupidapp.live.appdialog.model;

import com.baidu.mobads.sdk.api.IAdInterListener;
import kotlin.d;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: AppDialogModel.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public enum BottomTabName {
    Match("match", 0),
    Live("live", 1),
    Feed(IAdInterListener.AdProdType.PRODUCT_FEEDS, 2),
    Inbox("inbox", 3),
    Profile("profile", 4);


    @NotNull
    public static final a Companion = new a(null);
    private final int index;

    @NotNull
    private final String tabName;

    /* compiled from: AppDialogModel.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Nullable
        public final BottomTabName a(int i10) {
            BottomTabName bottomTabName = BottomTabName.Match;
            if (i10 == bottomTabName.getIndex()) {
                return bottomTabName;
            }
            BottomTabName bottomTabName2 = BottomTabName.Live;
            if (i10 == bottomTabName2.getIndex()) {
                return bottomTabName2;
            }
            BottomTabName bottomTabName3 = BottomTabName.Feed;
            if (i10 == bottomTabName3.getIndex()) {
                return bottomTabName3;
            }
            BottomTabName bottomTabName4 = BottomTabName.Inbox;
            if (i10 == bottomTabName4.getIndex()) {
                return bottomTabName4;
            }
            BottomTabName bottomTabName5 = BottomTabName.Profile;
            if (i10 == bottomTabName5.getIndex()) {
                return bottomTabName5;
            }
            return null;
        }
    }

    BottomTabName(String str, int i10) {
        this.tabName = str;
        this.index = i10;
    }

    public final int getIndex() {
        return this.index;
    }

    @NotNull
    public final String getTabName() {
        return this.tabName;
    }
}
