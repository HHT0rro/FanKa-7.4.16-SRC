package com.cupidapp.live.profile.fragment;

import com.cupidapp.live.R$mipmap;
import com.cupidapp.live.R$string;

/* compiled from: RelationUserListFragment.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public enum UserListOrder {
    Newest(0, R$string.order_by_newest, R$mipmap.user_order_add_time),
    Location(1, R$string.order_by_location, R$mipmap.user_order_location),
    Active(2, R$string.order_by_activity, R$mipmap.user_order_act_time);

    private final int imageRes;
    private final int index;
    private final int textRes;

    UserListOrder(int i10, int i11, int i12) {
        this.index = i10;
        this.textRes = i11;
        this.imageRes = i12;
    }

    public final int getImageRes() {
        return this.imageRes;
    }

    public final int getIndex() {
        return this.index;
    }

    public final int getTextRes() {
        return this.textRes;
    }
}
