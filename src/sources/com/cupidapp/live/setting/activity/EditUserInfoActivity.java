package com.cupidapp.live.setting.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.lifecycle.Lifecycle;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.R$mipmap;
import com.cupidapp.live.R$string;
import com.cupidapp.live.base.activity.FKBaseActivity;
import com.cupidapp.live.base.network.NetworkClient;
import com.cupidapp.live.base.network.ObservableExtensionKt$handle$disposed$2;
import com.cupidapp.live.base.network.model.ConstantsResult;
import com.cupidapp.live.base.network.model.ConstantsUrlModel;
import com.cupidapp.live.base.network.model.ImageModel;
import com.cupidapp.live.base.network.model.ProfileResult;
import com.cupidapp.live.base.network.model.VideoModel;
import com.cupidapp.live.base.permission.FKRxPermissionAlertDialog;
import com.cupidapp.live.base.router.j;
import com.cupidapp.live.base.sensorslog.SensorPosition;
import com.cupidapp.live.base.sensorslog.SensorsLogKeyButtonClick;
import com.cupidapp.live.base.utils.m0;
import com.cupidapp.live.base.view.FKItemLayout;
import com.cupidapp.live.base.view.FKTitleBarLayout;
import com.cupidapp.live.base.view.dialog.FKActionSheetDialog;
import com.cupidapp.live.base.view.dialog.FKActionSheetItemModel;
import com.cupidapp.live.base.view.dialog.FKAlertDialog;
import com.cupidapp.live.main.model.UserModifyResult;
import com.cupidapp.live.profile.activity.EditUserDescriptionActivity;
import com.cupidapp.live.profile.activity.EditUserNameActivity;
import com.cupidapp.live.profile.activity.FKBaseProfileSpecActivity;
import com.cupidapp.live.profile.model.ProfileSpecListModel;
import com.cupidapp.live.profile.model.User;
import com.cupidapp.live.setting.adapter.EditUserAvatarAdapter;
import com.cupidapp.live.setting.helper.AvatarsTouchHelperCallback;
import com.cupidapp.live.setting.holder.AddNewAvatarViewVipModel;
import com.cupidapp.live.setting.holder.EditUserAvatarUiModel;
import com.cupidapp.live.setting.holder.EditUserAvatarViewHolder;
import com.cupidapp.live.setting.model.AvatarMoveEndEvent;
import com.cupidapp.live.setting.model.AvatarProfileModel;
import com.cupidapp.live.setting.view.EditInfoFriendPraiseLayout;
import com.cupidapp.live.setting.view.FKStoryLabelListLayout;
import com.cupidapp.live.track.group.GroupOthersLog;
import com.cupidapp.live.vip.PurchaseDialogManager;
import com.cupidapp.live.vip.wrapper.VipPurchaseEntranceType;
import com.huawei.hms.mlsdk.common.AgConnectInfo;
import com.huawei.quickcard.base.Attributes;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.i0;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Ref$ObjectRef;
import org.greenrobot.eventbus.ThreadMode;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import x2.a;

/* compiled from: EditUserInfoActivity.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class EditUserInfoActivity extends FKBaseActivity {

    /* renamed from: y, reason: collision with root package name */
    @NotNull
    public static final a f17947y = new a(null);

    /* renamed from: w, reason: collision with root package name */
    public boolean f17954w;

    /* renamed from: x, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f17955x = new LinkedHashMap();

    /* renamed from: q, reason: collision with root package name */
    @NotNull
    public final Lazy f17948q = kotlin.c.b(new Function0<xb.b>() { // from class: com.cupidapp.live.setting.activity.EditUserInfoActivity$rxPermissions$2
        {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        @NotNull
        public final xb.b invoke() {
            return new xb.b(EditUserInfoActivity.this);
        }
    });

    /* renamed from: r, reason: collision with root package name */
    @NotNull
    public final Lazy f17949r = kotlin.c.b(new Function0<m0>() { // from class: com.cupidapp.live.setting.activity.EditUserInfoActivity$regionNodeUtils$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        @NotNull
        public final m0 invoke() {
            return new m0(EditUserInfoActivity.this);
        }
    });

    /* renamed from: s, reason: collision with root package name */
    @NotNull
    public final Lazy f17950s = kotlin.c.b(new Function0<ItemTouchHelper>() { // from class: com.cupidapp.live.setting.activity.EditUserInfoActivity$itemTouchHelper$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        @NotNull
        public final ItemTouchHelper invoke() {
            return new ItemTouchHelper(new AvatarsTouchHelperCallback());
        }
    });

    /* renamed from: t, reason: collision with root package name */
    @NotNull
    public final Lazy f17951t = kotlin.c.b(new Function0<PurchaseDialogManager>() { // from class: com.cupidapp.live.setting.activity.EditUserInfoActivity$purchaseDialogManager$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        @NotNull
        public final PurchaseDialogManager invoke() {
            EditUserInfoActivity editUserInfoActivity = EditUserInfoActivity.this;
            Lifecycle lifecycle = editUserInfoActivity.getLifecycle();
            kotlin.jvm.internal.s.h(lifecycle, "lifecycle");
            return new PurchaseDialogManager(editUserInfoActivity, lifecycle);
        }
    });

    /* renamed from: u, reason: collision with root package name */
    @NotNull
    public final Lazy f17952u = kotlin.c.b(new Function0<EditUserAvatarAdapter>() { // from class: com.cupidapp.live.setting.activity.EditUserInfoActivity$editUserAvatarAdapter$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        @NotNull
        public final EditUserAvatarAdapter invoke() {
            final EditUserAvatarAdapter editUserAvatarAdapter = new EditUserAvatarAdapter();
            final EditUserInfoActivity editUserInfoActivity = EditUserInfoActivity.this;
            editUserAvatarAdapter.l().j(i0.h(kotlin.f.a(Integer.valueOf(R$id.user_avatar_del), new Function1<Object, kotlin.p>() { // from class: com.cupidapp.live.setting.activity.EditUserInfoActivity$editUserAvatarAdapter$2$1$1
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ kotlin.p invoke(Object obj) {
                    invoke2(obj);
                    return kotlin.p.f51048a;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@Nullable Object obj) {
                    EditUserInfoActivity.this.y1(obj);
                }
            })));
            editUserAvatarAdapter.l().g(new Function1<Object, kotlin.p>() { // from class: com.cupidapp.live.setting.activity.EditUserInfoActivity$editUserAvatarAdapter$2$1$2
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ kotlin.p invoke(Object obj) {
                    invoke2(obj);
                    return kotlin.p.f51048a;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@Nullable Object obj) {
                    EditUserInfoActivity.this.v1(obj);
                }
            });
            editUserAvatarAdapter.l().h(new Function1<Object, kotlin.p>() { // from class: com.cupidapp.live.setting.activity.EditUserInfoActivity$editUserAvatarAdapter$2$1$3
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ kotlin.p invoke(Object obj) {
                    invoke2(obj);
                    return kotlin.p.f51048a;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@Nullable Object obj) {
                    EditUserAvatarViewHolder L1;
                    ItemTouchHelper D1;
                    List<Object> j10 = EditUserAvatarAdapter.this.j();
                    ArrayList arrayList = new ArrayList();
                    for (Object obj2 : j10) {
                        if (obj2 instanceof EditUserAvatarUiModel) {
                            arrayList.add(obj2);
                        }
                    }
                    if (!(obj instanceof EditUserAvatarUiModel) || arrayList.size() <= 1) {
                        return;
                    }
                    L1 = editUserInfoActivity.L1(EditUserAvatarAdapter.this.j().indexOf(obj));
                    if (L1 != null) {
                        D1 = editUserInfoActivity.D1();
                        D1.startDrag(L1);
                    }
                }
            });
            return editUserAvatarAdapter;
        }
    });

    /* renamed from: v, reason: collision with root package name */
    @NotNull
    public final List<String> f17953v = new ArrayList();

    /* compiled from: EditUserInfoActivity.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ void b(a aVar, Context context, String str, boolean z10, int i10, Object obj) {
            if ((i10 & 2) != 0) {
                str = null;
            }
            if ((i10 & 4) != 0) {
                z10 = false;
            }
            aVar.a(context, str, z10);
        }

        public final void a(@Nullable Context context, @Nullable String str, boolean z10) {
            if (context == null) {
                return;
            }
            Intent intent = new Intent(context, (Class<?>) EditUserInfoActivity.class);
            intent.putExtra("EDIT_USER_INFO_SCENE", str);
            intent.putExtra("SCROLL_TO_BOTTOM", z10);
            context.startActivity(intent);
            FKBaseActivity.a.c(FKBaseActivity.f11750o, context, 0, 0, 6, null);
        }
    }

    public static final void N1(EditUserInfoActivity this$0) {
        ScrollView scrollView;
        kotlin.jvm.internal.s.i(this$0, "this$0");
        if (!this$0.f17954w || (scrollView = (ScrollView) this$0.k1(R$id.edit_user_scroll)) == null) {
            return;
        }
        scrollView.fullScroll(130);
    }

    public final void A1() {
        String str;
        Object obj;
        ImageModel avatarImage;
        VideoModel avatarVideo;
        e1();
        List<Object> j10 = C1().j();
        ArrayList arrayList = new ArrayList();
        for (Object obj2 : j10) {
            if (obj2 instanceof EditUserAvatarUiModel) {
                arrayList.add(obj2);
            }
        }
        ArrayList arrayList2 = new ArrayList(kotlin.collections.t.t(arrayList, 10));
        Iterator<E> iterator2 = arrayList.iterator2();
        while (iterator2.hasNext()) {
            arrayList2.add(((EditUserAvatarUiModel) iterator2.next()).getAvatarModel());
        }
        ArrayList arrayList3 = new ArrayList(kotlin.collections.t.t(arrayList2, 10));
        Iterator<E> iterator22 = arrayList2.iterator2();
        while (true) {
            str = null;
            if (!iterator22.hasNext()) {
                break;
            }
            ImageModel avatarImage2 = ((AvatarProfileModel) iterator22.next()).getAvatarImage();
            if (avatarImage2 != null) {
                str = avatarImage2.getImageId();
            }
            arrayList3.add(str);
        }
        Iterator<E> iterator23 = arrayList2.iterator2();
        while (true) {
            if (iterator23.hasNext()) {
                obj = iterator23.next();
                if (((AvatarProfileModel) obj).getAvatarVideo() != null) {
                    break;
                }
            } else {
                obj = null;
                break;
            }
        }
        AvatarProfileModel avatarProfileModel = (AvatarProfileModel) obj;
        String videoId = (avatarProfileModel == null || (avatarVideo = avatarProfileModel.getAvatarVideo()) == null) ? null : avatarVideo.getVideoId();
        if (avatarProfileModel != null && (avatarImage = avatarProfileModel.getAvatarImage()) != null) {
            str = avatarImage.getImageId();
        }
        Disposable disposed = NetworkClient.f11868a.N().A0(arrayList3, videoId, str).flatMap(new com.cupidapp.live.base.network.i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new com.cupidapp.live.base.network.e(new Function1<UserModifyResult, kotlin.p>() { // from class: com.cupidapp.live.setting.activity.EditUserInfoActivity$editAvatarOrder$$inlined$handle$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ kotlin.p invoke(UserModifyResult userModifyResult) {
                m2782invoke(userModifyResult);
                return kotlin.p.f51048a;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m2782invoke(UserModifyResult userModifyResult) {
                UserModifyResult userModifyResult2 = userModifyResult;
                EditUserInfoActivity.this.V0();
                p1.g gVar = p1.g.f52734a;
                gVar.B2(true);
                gVar.A2(userModifyResult2.getUser());
                EditUserInfoActivity.this.w1(userModifyResult2.getUser().getAvatarTip());
            }
        }), new com.cupidapp.live.base.network.e(new ObservableExtensionKt$handle$disposed$2(new Function1<Throwable, Boolean>() { // from class: com.cupidapp.live.setting.activity.EditUserInfoActivity$editAvatarOrder$2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final Boolean invoke(@NotNull Throwable it) {
                kotlin.jvm.internal.s.i(it, "it");
                EditUserInfoActivity.this.V0();
                return Boolean.FALSE;
            }
        }, this)));
        if (disposed != null) {
            kotlin.jvm.internal.s.h(disposed, "disposed");
            H(disposed);
        }
        kotlin.jvm.internal.s.h(disposed, "disposed");
    }

    public final void B1(User user) {
        if (user == null) {
            return;
        }
        List<Object> j10 = C1().j();
        ArrayList arrayList = new ArrayList();
        for (Object obj : j10) {
            if (obj instanceof EditUserAvatarUiModel) {
                arrayList.add(obj);
            }
        }
        boolean d10 = kotlin.jvm.internal.s.d(arrayList, user.getAvatarProfile());
        int i10 = 0;
        if (!d10) {
            C1().j().clear();
            boolean z10 = user.getAvatarProfile().size() > 1;
            EditUserAvatarAdapter C1 = C1();
            List<AvatarProfileModel> avatarProfile = user.getAvatarProfile();
            ArrayList arrayList2 = new ArrayList(kotlin.collections.t.t(avatarProfile, 10));
            Iterator<AvatarProfileModel> iterator2 = avatarProfile.iterator2();
            while (iterator2.hasNext()) {
                arrayList2.add(new EditUserAvatarUiModel(iterator2.next(), z10, user.isVideoAvatarValid(), user.getOnlyDefaultAvatar()));
            }
            C1.e(arrayList2);
            int size = 6 - user.getAvatarProfile().size();
            for (int i11 = 0; i11 < size; i11++) {
                C1().d(new AddNewAvatarViewVipModel());
            }
            C1().notifyDataSetChanged();
        }
        w1(user.getAvatarTip());
        ((FKItemLayout) k1(R$id.nicknameItemLayout)).setFkValueText(user.getName());
        ((FKItemLayout) k1(R$id.descriptionItemLayout)).setFkValueText(user.getSummary());
        if (user.getShowStoryLabel()) {
            int i12 = R$id.story_label_layout;
            ((FKStoryLabelListLayout) k1(i12)).setVisibility(0);
            ((FKStoryLabelListLayout) k1(i12)).k(user.getStoryLabelList());
        } else {
            ((FKStoryLabelListLayout) k1(R$id.story_label_layout)).setVisibility(8);
        }
        if (user.getPraise() != null) {
            int i13 = R$id.edit_friend_praise_layout;
            ((EditInfoFriendPraiseLayout) k1(i13)).setVisibility(0);
            ((EditInfoFriendPraiseLayout) k1(i13)).c(user.getPraise());
        } else {
            ((EditInfoFriendPraiseLayout) k1(R$id.edit_friend_praise_layout)).setVisibility(8);
        }
        List<ProfileSpecListModel> profileSpecList = user.getProfileSpecList();
        if (profileSpecList != null) {
            ArrayList arrayList3 = new ArrayList();
            for (ProfileSpecListModel profileSpecListModel : profileSpecList) {
                if (!kotlin.jvm.internal.s.d(profileSpecListModel.getType(), "text")) {
                    arrayList3.add(profileSpecListModel);
                }
            }
            for (Object obj2 : arrayList3) {
                int i14 = i10 + 1;
                if (i10 < 0) {
                    kotlin.collections.s.s();
                }
                ProfileSpecListModel profileSpecListModel2 = (ProfileSpecListModel) obj2;
                String itemId = profileSpecListModel2.getItemId();
                if (this.f17953v.contains(itemId)) {
                    View childAt = ((LinearLayout) k1(R$id.profileSpecListLayout)).getChildAt(this.f17953v.indexOf(itemId));
                    FKItemLayout fKItemLayout = childAt instanceof FKItemLayout ? (FKItemLayout) childAt : null;
                    if (fKItemLayout != null) {
                        String F1 = F1(profileSpecListModel2);
                        if (!kotlin.jvm.internal.s.d(fKItemLayout.getFkValueText(), F1)) {
                            fKItemLayout.setFkValueText(F1);
                        }
                        fKItemLayout.setFkValueRedTip(Boolean.valueOf(profileSpecListModel2.getRedDot()));
                    }
                } else {
                    ((LinearLayout) k1(R$id.profileSpecListLayout)).addView(x1(profileSpecListModel2), i10);
                    this.f17953v.add(i10, itemId);
                }
                i10 = i14;
            }
        }
    }

    public final EditUserAvatarAdapter C1() {
        return (EditUserAvatarAdapter) this.f17952u.getValue();
    }

    public final ItemTouchHelper D1() {
        return (ItemTouchHelper) this.f17950s.getValue();
    }

    public final String E1(ProfileSpecListModel profileSpecListModel) {
        List<String> labelList;
        List<String> labelList2 = profileSpecListModel.getLabelList();
        String str = labelList2 != null ? (String) CollectionsKt___CollectionsKt.V(labelList2) : null;
        if ((str == null || str.length() == 0) || (labelList = profileSpecListModel.getLabelList()) == null) {
            return null;
        }
        return (String) CollectionsKt___CollectionsKt.V(labelList);
    }

    public final String F1(ProfileSpecListModel profileSpecListModel) {
        String type = profileSpecListModel.getType();
        String str = null;
        switch (type.hashCode()) {
            case -934795532:
                if (type.equals(AgConnectInfo.AgConnectKey.REGION)) {
                    str = H1(E1(profileSpecListModel));
                    break;
                }
                break;
            case -906021636:
                if (type.equals("select")) {
                    str = E1(profileSpecListModel);
                    break;
                }
                break;
            case 3076014:
                if (type.equals("date")) {
                    str = E1(profileSpecListModel);
                    break;
                }
                break;
            case 108280125:
                if (type.equals(Attributes.Style.RANGE)) {
                    String E1 = E1(profileSpecListModel);
                    if (!(E1 == null || E1.length() == 0)) {
                        str = E1(profileSpecListModel) + profileSpecListModel.getUnit();
                        break;
                    }
                }
                break;
            case 1536891843:
                if (type.equals(Attributes.InputType.CHECK_BOX)) {
                    List<String> labelList = profileSpecListModel.getLabelList();
                    if (!(labelList == null || labelList.isEmpty())) {
                        Iterator<String> iterator2 = profileSpecListModel.getLabelList().iterator2();
                        if (iterator2.hasNext()) {
                            String next = iterator2.next();
                            while (iterator2.hasNext()) {
                                next = next + "," + iterator2.next();
                            }
                            str = next;
                            break;
                        } else {
                            throw new UnsupportedOperationException("Empty collection can't be reduced.");
                        }
                    }
                }
                break;
        }
        if (str != null) {
            return str;
        }
        String string = getString(R$string.not_filled_in);
        kotlin.jvm.internal.s.h(string, "getString(R.string.not_filled_in)");
        return string;
    }

    public final PurchaseDialogManager G1() {
        return (PurchaseDialogManager) this.f17951t.getValue();
    }

    public final String H1(String str) {
        if (str == null) {
            return null;
        }
        List<String> b4 = I1().b(str, 10);
        if (b4 == null || b4.isEmpty()) {
            return null;
        }
        return b4.get(0);
    }

    public final m0 I1() {
        return (m0) this.f17949r.getValue();
    }

    public final xb.b J1() {
        return (xb.b) this.f17948q.getValue();
    }

    public final void K1() {
        User X = p1.g.f52734a.X();
        if (X == null) {
            return;
        }
        Disposable disposed = a.C0836a.z(NetworkClient.f11868a.N(), X.userId(), Boolean.TRUE, null, false, null, 28, null).flatMap(new com.cupidapp.live.base.network.i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new com.cupidapp.live.base.network.e(new Function1<ProfileResult, kotlin.p>() { // from class: com.cupidapp.live.setting.activity.EditUserInfoActivity$getUserData$$inlined$handle$default$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ kotlin.p invoke(ProfileResult profileResult) {
                m2783invoke(profileResult);
                return kotlin.p.f51048a;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m2783invoke(ProfileResult profileResult) {
                ProfileResult profileResult2 = profileResult;
                EditUserInfoActivity.this.B1(profileResult2.getUser());
                p1.g.f52734a.A2(profileResult2.getUser());
            }
        }), new com.cupidapp.live.base.network.e(new ObservableExtensionKt$handle$disposed$2(null, this)));
        if (disposed != null) {
            kotlin.jvm.internal.s.h(disposed, "disposed");
            H(disposed);
        }
        kotlin.jvm.internal.s.h(disposed, "disposed");
    }

    public final EditUserAvatarViewHolder L1(int i10) {
        RecyclerView.ViewHolder findViewHolderForLayoutPosition = ((RecyclerView) k1(R$id.editUserAvatarRecyclerView)).findViewHolderForLayoutPosition(i10);
        if (findViewHolderForLayoutPosition instanceof EditUserAvatarViewHolder) {
            return (EditUserAvatarViewHolder) findViewHolderForLayoutPosition;
        }
        return null;
    }

    public final void M1() {
        int i10 = R$id.editUserAvatarRecyclerView;
        RecyclerView recyclerView = (RecyclerView) k1(i10);
        recyclerView.setAdapter(C1());
        recyclerView.setLayoutManager(new GridLayoutManager(this, 3));
        D1().attachToRecyclerView((RecyclerView) k1(i10));
        ((TextView) k1(R$id.avatarAndCoverTextView)).getPaint().setFakeBoldText(true);
        ((TextView) k1(R$id.basicInfoTextView)).getPaint().setFakeBoldText(true);
        ((TextView) k1(R$id.detailedInfoTextView)).getPaint().setFakeBoldText(true);
    }

    public final void O1(final String str, final boolean z10) {
        FKRxPermissionAlertDialog.f12016a.m(this, J1(), (r16 & 4) != 0 ? null : new Function0<kotlin.p>() { // from class: com.cupidapp.live.setting.activity.EditUserInfoActivity$openChangeAvatarActivity$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ kotlin.p invoke() {
                invoke2();
                return kotlin.p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                String string;
                if (kotlin.jvm.internal.s.d(EditUserInfoActivity.this.getIntent().getStringExtra("EDIT_USER_INFO_SCENE"), "NewUserActivity")) {
                    string = EditUserInfoActivity.this.getString(R$string.new_user_upload_avatar_success);
                } else {
                    string = EditUserInfoActivity.this.getString(R$string.upload_success);
                }
                kotlin.jvm.internal.s.h(string, "if (intent.getStringExtr…uccess)\n                }");
                ChangeAvatarActivity.f17927x.a(EditUserInfoActivity.this, new ChangeAvatarModel(str, EditUserInfoActivity.this.Q0(), string, z10));
            }
        }, (r16 & 8) != 0 ? null : null, (r16 & 16) != 0 ? null : null, (r16 & 32) != 0 ? R$string.need_access_media_upload_better : 0);
    }

    @Override // com.cupidapp.live.base.activity.FKBaseActivity
    @NotNull
    public SensorPosition Q0() {
        return SensorPosition.EditProfile;
    }

    @Nullable
    public View k1(int i10) {
        Map<Integer, View> map = this.f17955x;
        View view = map.get(Integer.valueOf(i10));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i10);
        if (findViewById == null) {
            return null;
        }
        map.put(Integer.valueOf(i10), findViewById);
        return findViewById;
    }

    @Override // com.cupidapp.live.base.activity.FKBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R$layout.activity_edit_user_info);
        M1();
        B1(p1.g.f52734a.X());
        u1();
        j1.c.b(j1.c.f50228a, Q0(), null, null, 6, null);
        this.f17954w = getIntent().getBooleanExtra("SCROLL_TO_BOTTOM", false);
        ((ScrollView) k1(R$id.edit_user_scroll)).postDelayed(new Runnable() { // from class: com.cupidapp.live.setting.activity.e
            @Override // java.lang.Runnable
            public final void run() {
                EditUserInfoActivity.N1(EditUserInfoActivity.this);
            }
        }, 200L);
        FKItemLayout personal_display_item_layout = (FKItemLayout) k1(R$id.personal_display_item_layout);
        kotlin.jvm.internal.s.h(personal_display_item_layout, "personal_display_item_layout");
        personal_display_item_layout.setVisibility(0);
    }

    @he.j(threadMode = ThreadMode.MAIN)
    public final void onEvent(@NotNull AvatarMoveEndEvent event) {
        kotlin.jvm.internal.s.i(event, "event");
        A1();
    }

    @Override // com.cupidapp.live.base.activity.FKBaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        K1();
    }

    public final void u1() {
        ((FKTitleBarLayout) k1(R$id.editUserInfoTitleLayout)).setLeftImageClickEvent(new Function1<View, kotlin.p>() { // from class: com.cupidapp.live.setting.activity.EditUserInfoActivity$bindClickEvent$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ kotlin.p invoke(View view) {
                invoke2(view);
                return kotlin.p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable View view) {
                EditUserInfoActivity.this.finish();
            }
        });
        FKItemLayout nicknameItemLayout = (FKItemLayout) k1(R$id.nicknameItemLayout);
        kotlin.jvm.internal.s.h(nicknameItemLayout, "nicknameItemLayout");
        z0.y.d(nicknameItemLayout, new Function1<View, kotlin.p>() { // from class: com.cupidapp.live.setting.activity.EditUserInfoActivity$bindClickEvent$2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ kotlin.p invoke(View view) {
                invoke2(view);
                return kotlin.p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable View view) {
                EditUserNameActivity.f17607r.a(EditUserInfoActivity.this);
            }
        });
        FKItemLayout descriptionItemLayout = (FKItemLayout) k1(R$id.descriptionItemLayout);
        kotlin.jvm.internal.s.h(descriptionItemLayout, "descriptionItemLayout");
        z0.y.d(descriptionItemLayout, new Function1<View, kotlin.p>() { // from class: com.cupidapp.live.setting.activity.EditUserInfoActivity$bindClickEvent$3
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ kotlin.p invoke(View view) {
                invoke2(view);
                return kotlin.p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable View view) {
                EditUserDescriptionActivity.f17605r.a(EditUserInfoActivity.this);
            }
        });
        FKItemLayout personal_display_item_layout = (FKItemLayout) k1(R$id.personal_display_item_layout);
        kotlin.jvm.internal.s.h(personal_display_item_layout, "personal_display_item_layout");
        z0.y.d(personal_display_item_layout, new Function1<View, kotlin.p>() { // from class: com.cupidapp.live.setting.activity.EditUserInfoActivity$bindClickEvent$4
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ kotlin.p invoke(View view) {
                invoke2(view);
                return kotlin.p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable View view) {
                ConstantsUrlModel urlModel;
                SensorsLogKeyButtonClick.EditProfile.EDIT_PROFILE_PERSONAL_SHOW.click();
                j.a aVar = com.cupidapp.live.base.router.j.f12156c;
                EditUserInfoActivity editUserInfoActivity = EditUserInfoActivity.this;
                ConstantsResult q10 = p1.g.f52734a.q();
                j.a.b(aVar, editUserInfoActivity, (q10 == null || (urlModel = q10.getUrlModel()) == null) ? null : urlModel.getIndividuationFrameConfigJumpUrl(), null, 4, null);
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void v1(Object obj) {
        final Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
        if (obj instanceof EditUserAvatarUiModel) {
            SensorsLogKeyButtonClick.EditProfile.ReplacePhoto.click();
            ImageModel avatarImage = ((EditUserAvatarUiModel) obj).getAvatarModel().getAvatarImage();
            ref$ObjectRef.element = avatarImage != null ? avatarImage.getImageId() : 0;
        }
        if (obj instanceof AddNewAvatarViewVipModel) {
            SensorsLogKeyButtonClick.EditProfile.NewAddPhoto.click();
            ref$ObjectRef.element = null;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(new FKActionSheetItemModel(R$string.video_avatar, null, null, Integer.valueOf(R$mipmap.aplus_logo), Integer.valueOf(R$string.show_every_frame_beauty), new Function0<kotlin.p>() { // from class: com.cupidapp.live.setting.activity.EditUserInfoActivity$changeAvatar$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ kotlin.p invoke() {
                invoke2();
                return kotlin.p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                PurchaseDialogManager G1;
                SensorsLogKeyButtonClick.EditProfile.UPLOAD_DYNAMIC_AVATAR.click();
                if (com.cupidapp.live.profile.logic.c.f17839a.f()) {
                    EditUserInfoActivity.this.O1(ref$ObjectRef.element, true);
                } else {
                    G1 = EditUserInfoActivity.this.G1();
                    PurchaseDialogManager.j(G1, VipPurchaseEntranceType.VideoAvatarEdit, null, null, false, 14, null);
                }
            }
        }, 6, null));
        arrayList.add(new FKActionSheetItemModel(R$string.photo, null, null, null, null, new Function0<kotlin.p>() { // from class: com.cupidapp.live.setting.activity.EditUserInfoActivity$changeAvatar$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ kotlin.p invoke() {
                invoke2();
                return kotlin.p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                SensorsLogKeyButtonClick.EditProfile.UPLOAD_AVATAR.click();
                EditUserInfoActivity.this.O1(ref$ObjectRef.element, false);
            }
        }, 30, null));
        FKActionSheetDialog.f12692f.a(this).f(arrayList).h();
    }

    public final void w1(String str) {
        if (str == null || str.length() == 0) {
            ((RelativeLayout) k1(R$id.edit_user_avatar_tip_rl)).setVisibility(8);
            return;
        }
        int i10 = R$id.edit_user_avatar_tip_text;
        if (!kotlin.jvm.internal.s.d(str, ((TextView) k1(i10)).getText())) {
            GroupOthersLog.f18702a.w(str);
        }
        ((RelativeLayout) k1(R$id.edit_user_avatar_tip_rl)).setVisibility(0);
        ((TextView) k1(i10)).setText(str);
    }

    public final FKItemLayout x1(final ProfileSpecListModel profileSpecListModel) {
        FKItemLayout fKItemLayout = new FKItemLayout(this);
        fKItemLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, z0.h.c(fKItemLayout, 52.0f)));
        Boolean bool = Boolean.TRUE;
        fKItemLayout.setFkTitleBold(bool);
        fKItemLayout.setFkTitleText(profileSpecListModel.getName());
        fKItemLayout.setFkValueBold(bool);
        fKItemLayout.setFkNextIndicator(bool);
        fKItemLayout.setFkBottomLine(bool);
        fKItemLayout.setFkValueText(F1(profileSpecListModel));
        fKItemLayout.setFkValueRedTip(Boolean.valueOf(profileSpecListModel.getRedDot()));
        z0.y.d(fKItemLayout, new Function1<View, kotlin.p>() { // from class: com.cupidapp.live.setting.activity.EditUserInfoActivity$createProfileSpecItemLayout$1$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ kotlin.p invoke(View view) {
                invoke2(view);
                return kotlin.p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable View view) {
                FKBaseProfileSpecActivity.f17612t.a(EditUserInfoActivity.this, profileSpecListModel.getType(), profileSpecListModel.getItemId());
            }
        });
        return fKItemLayout;
    }

    public final void y1(final Object obj) {
        if (obj instanceof EditUserAvatarUiModel) {
            FKAlertDialog.G(FKAlertDialog.r(FKAlertDialog.w(FKAlertDialog.a.c(FKAlertDialog.f12698l, this, false, 2, null).D(R$string.confirm_delete), R$string.delete, null, new Function0<kotlin.p>() { // from class: com.cupidapp.live.setting.activity.EditUserInfoActivity$delAvatarConfirmDialog$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ kotlin.p invoke() {
                    invoke2();
                    return kotlin.p.f51048a;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    EditUserInfoActivity.this.z1(obj);
                }
            }, 2, null), 0, null, 3, null), null, 1, null);
        }
    }

    public final void z1(Object obj) {
        if (obj instanceof EditUserAvatarUiModel) {
            C1().j().remove(obj);
            C1().j().add(new AddNewAvatarViewVipModel());
            List<Object> j10 = C1().j();
            ArrayList<EditUserAvatarUiModel> arrayList = new ArrayList();
            for (Object obj2 : j10) {
                if (obj2 instanceof EditUserAvatarUiModel) {
                    arrayList.add(obj2);
                }
            }
            for (EditUserAvatarUiModel editUserAvatarUiModel : arrayList) {
                boolean z10 = true;
                if (arrayList.size() <= 1) {
                    z10 = false;
                }
                editUserAvatarUiModel.setCanDel(z10);
            }
            C1().notifyDataSetChanged();
            A1();
        }
    }
}
