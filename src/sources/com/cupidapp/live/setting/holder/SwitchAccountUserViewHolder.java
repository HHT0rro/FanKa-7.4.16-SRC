package com.cupidapp.live.setting.holder;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.cupidapp.live.R$drawable;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.R$string;
import com.cupidapp.live.base.imageloader.ImageLoaderView;
import com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder;
import com.cupidapp.live.base.sensorslog.SensorPosition;
import com.cupidapp.live.setting.model.SwitchAccountStatus;
import com.cupidapp.live.setting.model.SwitchAccountUserModel;
import kotlin.d;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.z;

/* compiled from: SwitchAccountUserViewHolder.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class SwitchAccountUserViewHolder extends FKBaseRecyclerViewHolder {

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    public static final a f18196c = new a(null);

    /* compiled from: SwitchAccountUserViewHolder.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final SwitchAccountUserViewHolder a(@NotNull ViewGroup parent) {
            s.i(parent, "parent");
            return new SwitchAccountUserViewHolder(z.b(parent, R$layout.view_holder_switch_account_user, false, 2, null));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SwitchAccountUserViewHolder(@NotNull View itemView) {
        super(itemView);
        s.i(itemView, "itemView");
    }

    @Override // com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder
    public void n(@Nullable Object obj) {
        if (obj instanceof SwitchAccountUserModel) {
            ImageLoaderView imageLoaderView = (ImageLoaderView) this.itemView.findViewById(R$id.account_user_avatar_img);
            s.h(imageLoaderView, "itemView.account_user_avatar_img");
            SwitchAccountUserModel switchAccountUserModel = (SwitchAccountUserModel) obj;
            ImageLoaderView.g(imageLoaderView, switchAccountUserModel.getAvatar(), null, null, 6, null);
            ((TextView) this.itemView.findViewById(R$id.account_user_name_text)).setText(switchAccountUserModel.getUserName());
            String noticeMsg = switchAccountUserModel.getNoticeMsg();
            if (noticeMsg == null || noticeMsg.length() == 0) {
                this.itemView.findViewById(R$id.account_content_red_dot).setVisibility(8);
                ((TextView) this.itemView.findViewById(R$id.account_user_content_text)).setText(switchAccountUserModel.getInfoMsg());
            } else {
                this.itemView.findViewById(R$id.account_content_red_dot).setVisibility(0);
                ((TextView) this.itemView.findViewById(R$id.account_user_content_text)).setText(switchAccountUserModel.getNoticeMsg());
            }
            Boolean used = switchAccountUserModel.getUsed();
            Boolean bool = Boolean.TRUE;
            if (s.d(used, bool)) {
                if (switchAccountUserModel.isRemoveState()) {
                    ((ConstraintLayout) this.itemView.findViewById(R$id.account_holder_root_layout)).setBackgroundResource(R$drawable.shape_e9e9e9_bg_twelve_corners);
                } else {
                    ((ConstraintLayout) this.itemView.findViewById(R$id.account_holder_root_layout)).setBackgroundResource(R$drawable.shape_white_bg_twelve_corners);
                }
                ((TextView) this.itemView.findViewById(R$id.account_current_use_text)).setVisibility(0);
            } else {
                ((ConstraintLayout) this.itemView.findViewById(R$id.account_holder_root_layout)).setBackgroundResource(R$drawable.shape_white_bg_twelve_corners);
                ((TextView) this.itemView.findViewById(R$id.account_current_use_text)).setVisibility(8);
            }
            if (s.d(switchAccountUserModel.getUsed(), bool)) {
                View view = this.itemView;
                int i10 = R$id.account_status_text;
                ((TextView) view.findViewById(i10)).setVisibility(8);
                ((TextView) this.itemView.findViewById(i10)).setText((CharSequence) null);
            } else {
                int status = switchAccountUserModel.getStatus();
                if (status == SwitchAccountStatus.Ban.getValue()) {
                    View view2 = this.itemView;
                    int i11 = R$id.account_status_text;
                    ((TextView) view2.findViewById(i11)).setVisibility(0);
                    ((TextView) this.itemView.findViewById(i11)).setText(R$string.account_ban);
                    ((TextView) this.itemView.findViewById(i11)).setTextColor(-49088);
                } else if (status == SwitchAccountStatus.Close.getValue()) {
                    View view3 = this.itemView;
                    int i12 = R$id.account_status_text;
                    ((TextView) view3.findViewById(i12)).setVisibility(0);
                    ((TextView) this.itemView.findViewById(i12)).setText(R$string.account_close);
                    ((TextView) this.itemView.findViewById(i12)).setTextColor(-3750202);
                } else {
                    View view4 = this.itemView;
                    int i13 = R$id.account_status_text;
                    ((TextView) view4.findViewById(i13)).setVisibility(8);
                    ((TextView) this.itemView.findViewById(i13)).setText((CharSequence) null);
                }
            }
            if (s.d(switchAccountUserModel.getUsed(), Boolean.FALSE) && switchAccountUserModel.isRemoveState()) {
                ((TextView) this.itemView.findViewById(R$id.account_remove_user_btn)).setVisibility(0);
            } else {
                ((TextView) this.itemView.findViewById(R$id.account_remove_user_btn)).setVisibility(8);
            }
            if (switchAccountUserModel.getSensorPosition() == SensorPosition.SwitchAccount) {
                this.itemView.findViewById(R$id.account_divider_line).setVisibility(8);
            } else {
                this.itemView.findViewById(R$id.account_divider_line).setVisibility(0);
            }
        }
    }
}
