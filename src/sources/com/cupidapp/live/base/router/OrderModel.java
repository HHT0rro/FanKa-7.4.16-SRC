package com.cupidapp.live.base.router;

import com.cupidapp.live.profile.model.User;
import java.io.Serializable;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: AliypayHelper.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class OrderModel implements Serializable {
    private final long createTime;

    @NotNull
    private final String itemId;

    @NotNull
    private final GoodsModel purchaseItem;

    @NotNull
    private final String receiptType;

    @NotNull
    private final String status;

    @NotNull
    private final User user;

    public OrderModel(@NotNull String itemId, @NotNull User user, @NotNull String status, long j10, @NotNull GoodsModel purchaseItem, @NotNull String receiptType) {
        s.i(itemId, "itemId");
        s.i(user, "user");
        s.i(status, "status");
        s.i(purchaseItem, "purchaseItem");
        s.i(receiptType, "receiptType");
        this.itemId = itemId;
        this.user = user;
        this.status = status;
        this.createTime = j10;
        this.purchaseItem = purchaseItem;
        this.receiptType = receiptType;
    }

    public static /* synthetic */ OrderModel copy$default(OrderModel orderModel, String str, User user, String str2, long j10, GoodsModel goodsModel, String str3, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = orderModel.itemId;
        }
        if ((i10 & 2) != 0) {
            user = orderModel.user;
        }
        User user2 = user;
        if ((i10 & 4) != 0) {
            str2 = orderModel.status;
        }
        String str4 = str2;
        if ((i10 & 8) != 0) {
            j10 = orderModel.createTime;
        }
        long j11 = j10;
        if ((i10 & 16) != 0) {
            goodsModel = orderModel.purchaseItem;
        }
        GoodsModel goodsModel2 = goodsModel;
        if ((i10 & 32) != 0) {
            str3 = orderModel.receiptType;
        }
        return orderModel.copy(str, user2, str4, j11, goodsModel2, str3);
    }

    @NotNull
    public final String component1() {
        return this.itemId;
    }

    @NotNull
    public final User component2() {
        return this.user;
    }

    @NotNull
    public final String component3() {
        return this.status;
    }

    public final long component4() {
        return this.createTime;
    }

    @NotNull
    public final GoodsModel component5() {
        return this.purchaseItem;
    }

    @NotNull
    public final String component6() {
        return this.receiptType;
    }

    @NotNull
    public final OrderModel copy(@NotNull String itemId, @NotNull User user, @NotNull String status, long j10, @NotNull GoodsModel purchaseItem, @NotNull String receiptType) {
        s.i(itemId, "itemId");
        s.i(user, "user");
        s.i(status, "status");
        s.i(purchaseItem, "purchaseItem");
        s.i(receiptType, "receiptType");
        return new OrderModel(itemId, user, status, j10, purchaseItem, receiptType);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof OrderModel)) {
            return false;
        }
        OrderModel orderModel = (OrderModel) obj;
        return s.d(this.itemId, orderModel.itemId) && s.d(this.user, orderModel.user) && s.d(this.status, orderModel.status) && this.createTime == orderModel.createTime && s.d(this.purchaseItem, orderModel.purchaseItem) && s.d(this.receiptType, orderModel.receiptType);
    }

    public final long getCreateTime() {
        return this.createTime;
    }

    @NotNull
    public final String getItemId() {
        return this.itemId;
    }

    @NotNull
    public final GoodsModel getPurchaseItem() {
        return this.purchaseItem;
    }

    @NotNull
    public final String getReceiptType() {
        return this.receiptType;
    }

    @NotNull
    public final String getStatus() {
        return this.status;
    }

    @NotNull
    public final User getUser() {
        return this.user;
    }

    public int hashCode() {
        return (((((((((this.itemId.hashCode() * 31) + this.user.hashCode()) * 31) + this.status.hashCode()) * 31) + b2.a.a(this.createTime)) * 31) + this.purchaseItem.hashCode()) * 31) + this.receiptType.hashCode();
    }

    @NotNull
    public String toString() {
        String str = this.itemId;
        User user = this.user;
        String str2 = this.status;
        long j10 = this.createTime;
        GoodsModel goodsModel = this.purchaseItem;
        return "OrderModel(itemId=" + str + ", user=" + ((Object) user) + ", status=" + str2 + ", createTime=" + j10 + ", purchaseItem=" + ((Object) goodsModel) + ", receiptType=" + this.receiptType + ")";
    }
}
