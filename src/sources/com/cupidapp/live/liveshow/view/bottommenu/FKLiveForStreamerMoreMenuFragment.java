package com.cupidapp.live.liveshow.view.bottommenu;

import android.view.View;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.cupidapp.live.R$mipmap;
import com.cupidapp.live.R$string;
import com.cupidapp.live.base.sensorslog.AppSetting;
import com.cupidapp.live.base.sensorslog.SensorsLogKeyButtonClick;
import com.cupidapp.live.base.sensorslog.SensorsLogLiveShow;
import com.cupidapp.live.liveshow.activity.FKLiveForStreamerBeautyActivity;
import com.cupidapp.live.liveshow.constants.FKLiveConstantsData;
import com.cupidapp.live.liveshow.entity.FKLiveUtil;
import com.cupidapp.live.liveshow.model.LiveMenuBtnModel;
import com.cupidapp.live.liveshow.model.LiveShowModel;
import com.cupidapp.live.liveshow.model.LiveShowResult;
import com.cupidapp.live.track.group.GroupOthersLog;
import com.irisdt.client.live.LiveProtos;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import r2.i;

/* compiled from: FKLiveForStreamerMoreMenuFragment.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class FKLiveForStreamerMoreMenuFragment extends BaseLiveMoreMenuFragment {

    /* renamed from: i, reason: collision with root package name */
    @NotNull
    public static final a f15321i = new a(null);

    /* renamed from: h, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f15322h = new LinkedHashMap();

    /* compiled from: FKLiveForStreamerMoreMenuFragment.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(@Nullable FragmentManager fragmentManager, @NotNull Function1<? super MenuType, p> clickCallback) {
            s.i(clickCallback, "clickCallback");
            if (fragmentManager == null) {
                return;
            }
            FKLiveForStreamerMoreMenuFragment fKLiveForStreamerMoreMenuFragment = new FKLiveForStreamerMoreMenuFragment();
            fKLiveForStreamerMoreMenuFragment.c1(clickCallback);
            fKLiveForStreamerMoreMenuFragment.show(fragmentManager, FKLiveForStreamerMoreMenuFragment.class.getSimpleName());
        }
    }

    /* compiled from: FKLiveForStreamerMoreMenuFragment.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public /* synthetic */ class b {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f15323a;

        static {
            int[] iArr = new int[MenuType.values().length];
            try {
                iArr[MenuType.MagicRefine.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[MenuType.FanClub.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[MenuType.Share.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[MenuType.Mall.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[MenuType.Mirror.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[MenuType.ChangeCamera.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[MenuType.GiftWall.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr[MenuType.Music.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr[MenuType.Administrator.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                iArr[MenuType.GiftEffects.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                iArr[MenuType.Sticker.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            f15323a = iArr;
        }
    }

    @Override // com.cupidapp.live.liveshow.view.bottommenu.BaseLiveMoreMenuFragment, com.cupidapp.live.base.fragment.BaseBottomSheetDialogFragment
    public void O0() {
        this.f15322h.clear();
    }

    @Override // com.cupidapp.live.liveshow.view.bottommenu.BaseLiveMoreMenuFragment
    @Nullable
    public View V0(int i10) {
        View findViewById;
        Map<Integer, View> map = this.f15322h;
        View view = map.get(Integer.valueOf(i10));
        if (view != null) {
            return view;
        }
        View view2 = getView();
        if (view2 == null || (findViewById = view2.findViewById(i10)) == null) {
            return null;
        }
        map.put(Integer.valueOf(i10), findViewById);
        return findViewById;
    }

    @Override // com.cupidapp.live.liveshow.view.bottommenu.BaseLiveMoreMenuFragment
    public void W0() {
        FKLiveConstantsData fKLiveConstantsData = FKLiveConstantsData.INSTANCE;
        LiveShowResult fkLiveShowResult = fKLiveConstantsData.getFkLiveShowResult();
        LiveMenuBtnModel magicRefine = fkLiveShowResult != null ? fkLiveShowResult.getMagicRefine() : null;
        if (magicRefine != null) {
            Y0().d(new LiveMoreMenuModel(MenuType.MagicRefine, null, magicRefine.getIconImage(), getString(R$string.magic_refine), null, magicRefine.getUnread(), 18, null));
        }
        Y0().d(new LiveMoreMenuModel(MenuType.FanClub, Integer.valueOf(R$mipmap.icon_fan_club), null, getString(R$string.fan_club), null, false, 52, null));
        Y0().d(new LiveMoreMenuModel(MenuType.Share, Integer.valueOf(R$mipmap.icon_live_share_button), null, getString(R$string.share), null, false, 52, null));
        Y0().d(new LiveMoreMenuModel(MenuType.Mall, Integer.valueOf(R$mipmap.icon_live_show_mall), null, getString(R$string.mall), null, false, 52, null));
        LiveMoreMenuAdapter Y0 = Y0();
        MenuType menuType = MenuType.Mirror;
        p1.g gVar = p1.g.f52734a;
        Y0.d(new LiveMoreMenuModel(menuType, Integer.valueOf(gVar.T() ? R$mipmap.icon_live_mirror_selected_button : R$mipmap.icon_live_mirror_unselected_button), null, getString(R$string.mirror), null, false, 52, null));
        Y0().d(new LiveMoreMenuModel(MenuType.ChangeCamera, Integer.valueOf(R$mipmap.icon_live_exchange_button), null, getString(R$string.edit_change_camera), null, false, 52, null));
        LiveShowResult fkLiveShowResult2 = fKLiveConstantsData.getFkLiveShowResult();
        LiveMenuBtnModel giftWall = fkLiveShowResult2 != null ? fkLiveShowResult2.getGiftWall() : null;
        if (giftWall != null) {
            Y0().d(new LiveMoreMenuModel(MenuType.GiftWall, Integer.valueOf(R$mipmap.icon_live_gift_wall), null, getString(R$string.gift_wall), null, giftWall.getUnread(), 20, null));
        }
        Y0().d(new LiveMoreMenuModel(MenuType.Music, Integer.valueOf(R$mipmap.icon_live_music_button), null, getString(R$string.music), null, false, 52, null));
        LiveShowResult fkLiveShowResult3 = fKLiveConstantsData.getFkLiveShowResult();
        String adminListWebUrl = fkLiveShowResult3 != null ? fkLiveShowResult3.getAdminListWebUrl() : null;
        if (!(adminListWebUrl == null || adminListWebUrl.length() == 0)) {
            Y0().d(new LiveMoreMenuModel(MenuType.Administrator, Integer.valueOf(R$mipmap.icon_administrator), null, getString(R$string.administrator), null, false, 52, null));
        }
        Y0().d(new LiveMoreMenuModel(MenuType.GiftEffects, Integer.valueOf(s.d(gVar.Y0(), Boolean.TRUE) ? R$mipmap.icon_open_gift_effects : R$mipmap.icon_close_gift_effects), null, getString(R$string.gift_effects), null, false, 52, null));
        LiveShowResult fkLiveShowResult4 = fKLiveConstantsData.getFkLiveShowResult();
        LiveMenuBtnModel stickerEntryInfo = fkLiveShowResult4 != null ? fkLiveShowResult4.getStickerEntryInfo() : null;
        if (stickerEntryInfo != null) {
            Y0().d(new LiveMoreMenuModel(MenuType.Sticker, Integer.valueOf(R$mipmap.ic_live_more_menu_sticker), null, getString(R$string.live_beauty_sticker), null, stickerEntryInfo.getUnread(), 20, null));
        }
        Y0().notifyDataSetChanged();
    }

    @Override // com.cupidapp.live.liveshow.view.bottommenu.BaseLiveMoreMenuFragment
    public void a1(@NotNull LiveMoreMenuModel model) {
        LiveMenuBtnModel magicRefine;
        String url;
        String storeUrl;
        LiveMenuBtnModel giftWall;
        String url2;
        String adminListWebUrl;
        LiveMenuBtnModel stickerEntryInfo;
        String url3;
        s.i(model, "model");
        switch (b.f15323a[model.getType().ordinal()]) {
            case 1:
                FKLiveConstantsData fKLiveConstantsData = FKLiveConstantsData.INSTANCE;
                LiveShowResult fkLiveShowResult = fKLiveConstantsData.getFkLiveShowResult();
                if (fkLiveShowResult != null && (magicRefine = fkLiveShowResult.getMagicRefine()) != null && (url = magicRefine.getUrl()) != null) {
                    if (model.getShowRedDot()) {
                        LiveShowResult fkLiveShowResult2 = fKLiveConstantsData.getFkLiveShowResult();
                        LiveMenuBtnModel magicRefine2 = fkLiveShowResult2 != null ? fkLiveShowResult2.getMagicRefine() : null;
                        if (magicRefine2 != null) {
                            magicRefine2.setUnread(false);
                        }
                    }
                    b1(url);
                    break;
                }
                break;
            case 2:
                SensorsLogKeyButtonClick.AnchorLiveShowRoom.FanClub.click();
                break;
            case 3:
                FragmentActivity activity = getActivity();
                FKLiveForStreamerBeautyActivity fKLiveForStreamerBeautyActivity = activity instanceof FKLiveForStreamerBeautyActivity ? (FKLiveForStreamerBeautyActivity) activity : null;
                if (fKLiveForStreamerBeautyActivity != null) {
                    fKLiveForStreamerBeautyActivity.A1();
                    break;
                }
                break;
            case 4:
                LiveShowModel liveShowModel = FKLiveConstantsData.INSTANCE.getLiveShowModel();
                if (liveShowModel != null && (storeUrl = liveShowModel.getStoreUrl()) != null) {
                    b1(storeUrl);
                    SensorsLogKeyButtonClick.AnchorLiveShowRoom.Mall.click();
                    break;
                }
                break;
            case 5:
                f1();
                g1(LiveProtos.Type.MIRROR);
                break;
            case 6:
                d1();
                g1(LiveProtos.Type.REVERSE);
                break;
            case 7:
                FKLiveConstantsData fKLiveConstantsData2 = FKLiveConstantsData.INSTANCE;
                LiveShowResult fkLiveShowResult3 = fKLiveConstantsData2.getFkLiveShowResult();
                if (fkLiveShowResult3 != null && (giftWall = fkLiveShowResult3.getGiftWall()) != null && (url2 = giftWall.getUrl()) != null) {
                    if (model.getShowRedDot()) {
                        LiveShowResult fkLiveShowResult4 = fKLiveConstantsData2.getFkLiveShowResult();
                        LiveMenuBtnModel giftWall2 = fkLiveShowResult4 != null ? fkLiveShowResult4.getGiftWall() : null;
                        if (giftWall2 != null) {
                            giftWall2.setUnread(false);
                        }
                    }
                    b1(url2);
                }
                g1(LiveProtos.Type.MORE_GIFT_WALL);
                break;
            case 8:
                SensorsLogKeyButtonClick.AnchorLiveShowRoom.Music.click();
                break;
            case 9:
                LiveShowResult fkLiveShowResult5 = FKLiveConstantsData.INSTANCE.getFkLiveShowResult();
                if (fkLiveShowResult5 != null && (adminListWebUrl = fkLiveShowResult5.getAdminListWebUrl()) != null) {
                    b1(adminListWebUrl);
                    break;
                }
                break;
            case 10:
                e1(model);
                GroupOthersLog groupOthersLog = GroupOthersLog.f18702a;
                AppSetting appSetting = AppSetting.GIFT_SPECIAL_EFFECT;
                Boolean Y0 = p1.g.f52734a.Y0();
                GroupOthersLog.l0(groupOthersLog, appSetting, Y0 != null ? Y0.booleanValue() : false, null, null, 12, null);
                break;
            case 11:
                FKLiveConstantsData fKLiveConstantsData3 = FKLiveConstantsData.INSTANCE;
                LiveShowResult fkLiveShowResult6 = fKLiveConstantsData3.getFkLiveShowResult();
                if (fkLiveShowResult6 != null && (stickerEntryInfo = fkLiveShowResult6.getStickerEntryInfo()) != null && (url3 = stickerEntryInfo.getUrl()) != null) {
                    if (model.getShowRedDot()) {
                        LiveShowResult fkLiveShowResult7 = fKLiveConstantsData3.getFkLiveShowResult();
                        LiveMenuBtnModel stickerEntryInfo2 = fkLiveShowResult7 != null ? fkLiveShowResult7.getStickerEntryInfo() : null;
                        if (stickerEntryInfo2 != null) {
                            stickerEntryInfo2.setUnread(false);
                        }
                    }
                    b1(url3);
                    g1(LiveProtos.Type.MORE_PASTER);
                    break;
                }
                break;
        }
        Function1<MenuType, p> X0 = X0();
        if (X0 != null) {
            X0.invoke(model.getType());
        }
        if (model.getType() != MenuType.GiftEffects) {
            dismiss();
        }
    }

    public final void d1() {
        FKLiveUtil.f14913a.r(p1.g.f52734a.T());
        i.f53231b.l();
    }

    public final void e1(LiveMoreMenuModel liveMoreMenuModel) {
        p1.g gVar = p1.g.f52734a;
        gVar.p3(Boolean.valueOf(!(gVar.Y0() != null ? r1.booleanValue() : false)));
        Boolean Y0 = gVar.Y0();
        Boolean bool = Boolean.TRUE;
        int i10 = s.d(Y0, bool) ? R$mipmap.icon_open_gift_effects : R$mipmap.icon_close_gift_effects;
        if (Y0().j().contains(liveMoreMenuModel)) {
            int indexOf = Y0().j().indexOf(liveMoreMenuModel);
            liveMoreMenuModel.setIcon(Integer.valueOf(i10));
            Y0().notifyItemChanged(indexOf);
        }
        com.cupidapp.live.base.view.h.f12779a.b(s.d(gVar.Y0(), bool) ? R$string.gift_effects_opened : R$string.gift_effects_closed);
    }

    public final void f1() {
        p1.g gVar = p1.g.f52734a;
        gVar.x2(!gVar.T());
        com.cupidapp.live.base.view.h.f12779a.r(getContext(), gVar.T() ? R$string.camera_mirror_open_tip : R$string.camera_mirror_close_tip);
        FKLiveUtil.f14913a.r(gVar.T());
    }

    public final void g1(LiveProtos.Type type) {
        LiveShowModel liveShowModel = FKLiveConstantsData.INSTANCE.getLiveShowModel();
        if (liveShowModel != null) {
            SensorsLogLiveShow.f12212a.f(liveShowModel.getItemId(), liveShowModel.getUser().userId(), type, (r13 & 8) != 0 ? null : null, (r13 & 16) != 0 ? null : null);
        }
    }

    @Override // com.cupidapp.live.liveshow.view.bottommenu.BaseLiveMoreMenuFragment, com.cupidapp.live.base.fragment.BaseBottomSheetDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        O0();
    }
}
