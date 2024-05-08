package com.cupidapp.live.liveshow.view.bottommenu;

import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.FragmentManager;
import com.cupidapp.live.R$mipmap;
import com.cupidapp.live.R$string;
import com.cupidapp.live.base.sensorslog.AppSetting;
import com.cupidapp.live.base.sensorslog.SensorsLogKeyButtonClick;
import com.cupidapp.live.base.sensorslog.SensorsLogLiveShow;
import com.cupidapp.live.liveshow.constants.FKLiveConstantsData;
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

/* compiled from: FKLiveForViewerMoreMenuFragment.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class FKLiveForViewerMoreMenuFragment extends BaseLiveMoreMenuFragment {

    /* renamed from: i, reason: collision with root package name */
    @NotNull
    public static final a f15330i = new a(null);

    /* renamed from: h, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f15331h = new LinkedHashMap();

    /* compiled from: FKLiveForViewerMoreMenuFragment.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(@Nullable FragmentManager fragmentManager, boolean z10, @Nullable String str, @NotNull Function1<? super MenuType, p> clickCallback) {
            s.i(clickCallback, "clickCallback");
            if (fragmentManager == null) {
                return;
            }
            FKLiveForViewerMoreMenuFragment fKLiveForViewerMoreMenuFragment = new FKLiveForViewerMoreMenuFragment();
            Bundle bundle = new Bundle();
            bundle.putBoolean("SHOW_FAN_CLUB", z10);
            bundle.putString("ENTER_SOURCE", str);
            fKLiveForViewerMoreMenuFragment.setArguments(bundle);
            fKLiveForViewerMoreMenuFragment.c1(clickCallback);
            fKLiveForViewerMoreMenuFragment.show(fragmentManager, FKLiveForViewerMoreMenuFragment.class.getSimpleName());
        }
    }

    /* compiled from: FKLiveForViewerMoreMenuFragment.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public /* synthetic */ class b {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f15332a;

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
                iArr[MenuType.RedEnvelope.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[MenuType.Noble.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[MenuType.GiftFragments.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[MenuType.LiveTask.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[MenuType.DressUpMall.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr[MenuType.MyOutfit.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr[MenuType.Report.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                iArr[MenuType.GiftEffects.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                iArr[MenuType.GiftWall.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                iArr[MenuType.FollowLive.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            f15332a = iArr;
        }
    }

    @Override // com.cupidapp.live.liveshow.view.bottommenu.BaseLiveMoreMenuFragment, com.cupidapp.live.base.fragment.BaseBottomSheetDialogFragment
    public void O0() {
        this.f15331h.clear();
    }

    @Override // com.cupidapp.live.liveshow.view.bottommenu.BaseLiveMoreMenuFragment
    @Nullable
    public View V0(int i10) {
        View findViewById;
        Map<Integer, View> map = this.f15331h;
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

    /* JADX WARN: Removed duplicated region for block: B:20:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0084  */
    @Override // com.cupidapp.live.liveshow.view.bottommenu.BaseLiveMoreMenuFragment
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void W0() {
        /*
            Method dump skipped, instructions count: 744
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cupidapp.live.liveshow.view.bottommenu.FKLiveForViewerMoreMenuFragment.W0():void");
    }

    @Override // com.cupidapp.live.liveshow.view.bottommenu.BaseLiveMoreMenuFragment
    public void a1(@NotNull LiveMoreMenuModel model) {
        LiveMenuBtnModel magicRefine;
        String url;
        LiveMenuBtnModel magicRefine2;
        String redPacketCreateUrl;
        LiveMenuBtnModel liveNobility;
        String url2;
        LiveMenuBtnModel fragmentBtn;
        String url3;
        String viewerMissionUrl;
        LiveMenuBtnModel dressUpStoreBtn;
        String url4;
        LiveMenuBtnModel dressUpBtn;
        String url5;
        Integer valueOf;
        LiveMenuBtnModel giftWall;
        String url6;
        LiveMenuBtnModel streamFollowBtn;
        String url7;
        s.i(model, "model");
        switch (b.f15332a[model.getType().ordinal()]) {
            case 1:
                FKLiveConstantsData fKLiveConstantsData = FKLiveConstantsData.INSTANCE;
                LiveShowResult fkLiveShowResult = fKLiveConstantsData.getFkLiveShowResult();
                if (fkLiveShowResult != null && (magicRefine = fkLiveShowResult.getMagicRefine()) != null && (url = magicRefine.getUrl()) != null) {
                    if (model.getShowRedDot()) {
                        LiveShowResult fkLiveShowResult2 = fKLiveConstantsData.getFkLiveShowResult();
                        magicRefine2 = fkLiveShowResult2 != null ? fkLiveShowResult2.getMagicRefine() : null;
                        if (magicRefine2 != null) {
                            magicRefine2.setUnread(false);
                        }
                    }
                    b1(url);
                    break;
                }
                break;
            case 2:
                SensorsLogKeyButtonClick.LiveShowRoom.FanClub.click();
                d1(LiveProtos.Type.FANS_GROUP);
                break;
            case 3:
                LiveShowResult fkLiveShowResult3 = FKLiveConstantsData.INSTANCE.getFkLiveShowResult();
                if (fkLiveShowResult3 != null && (redPacketCreateUrl = fkLiveShowResult3.getRedPacketCreateUrl()) != null) {
                    b1(redPacketCreateUrl);
                    d1(LiveProtos.Type.MORE_RED_PACKET);
                    break;
                }
                break;
            case 4:
                FKLiveConstantsData fKLiveConstantsData2 = FKLiveConstantsData.INSTANCE;
                LiveShowResult fkLiveShowResult4 = fKLiveConstantsData2.getFkLiveShowResult();
                if (fkLiveShowResult4 != null && (liveNobility = fkLiveShowResult4.getLiveNobility()) != null && (url2 = liveNobility.getUrl()) != null) {
                    if (model.getShowRedDot()) {
                        LiveShowResult fkLiveShowResult5 = fKLiveConstantsData2.getFkLiveShowResult();
                        magicRefine2 = fkLiveShowResult5 != null ? fkLiveShowResult5.getLiveNobility() : null;
                        if (magicRefine2 != null) {
                            magicRefine2.setUnread(false);
                        }
                    }
                    b1(url2);
                    d1(LiveProtos.Type.MORE_NOBILITY);
                    break;
                }
                break;
            case 5:
                LiveShowResult fkLiveShowResult6 = FKLiveConstantsData.INSTANCE.getFkLiveShowResult();
                if (fkLiveShowResult6 != null && (fragmentBtn = fkLiveShowResult6.getFragmentBtn()) != null && (url3 = fragmentBtn.getUrl()) != null) {
                    b1(url3);
                    d1(LiveProtos.Type.MORE_COLLECT_FRAGMENT);
                    break;
                }
                break;
            case 6:
                LiveShowModel liveShowModel = FKLiveConstantsData.INSTANCE.getLiveShowModel();
                if (liveShowModel != null && (viewerMissionUrl = liveShowModel.getViewerMissionUrl()) != null) {
                    b1(viewerMissionUrl);
                    SensorsLogKeyButtonClick.LiveShowRoom.Task.click();
                    break;
                }
                break;
            case 7:
                FKLiveConstantsData fKLiveConstantsData3 = FKLiveConstantsData.INSTANCE;
                LiveShowResult fkLiveShowResult7 = fKLiveConstantsData3.getFkLiveShowResult();
                if (fkLiveShowResult7 != null && (dressUpStoreBtn = fkLiveShowResult7.getDressUpStoreBtn()) != null && (url4 = dressUpStoreBtn.getUrl()) != null) {
                    if (model.getShowRedDot()) {
                        LiveShowResult fkLiveShowResult8 = fKLiveConstantsData3.getFkLiveShowResult();
                        magicRefine2 = fkLiveShowResult8 != null ? fkLiveShowResult8.getDressUpStoreBtn() : null;
                        if (magicRefine2 != null) {
                            magicRefine2.setUnread(false);
                        }
                    }
                    b1(url4);
                    d1(LiveProtos.Type.MORE_DRESS_UP_MALL);
                    break;
                }
                break;
            case 8:
                FKLiveConstantsData fKLiveConstantsData4 = FKLiveConstantsData.INSTANCE;
                LiveShowResult fkLiveShowResult9 = fKLiveConstantsData4.getFkLiveShowResult();
                if (fkLiveShowResult9 != null && (dressUpBtn = fkLiveShowResult9.getDressUpBtn()) != null && (url5 = dressUpBtn.getUrl()) != null) {
                    if (model.getShowRedDot()) {
                        LiveShowResult fkLiveShowResult10 = fKLiveConstantsData4.getFkLiveShowResult();
                        magicRefine2 = fkLiveShowResult10 != null ? fkLiveShowResult10.getDressUpBtn() : null;
                        if (magicRefine2 != null) {
                            magicRefine2.setUnread(false);
                        }
                    }
                    b1(url5);
                    d1(LiveProtos.Type.MORE_MY_DRESS_UP);
                    break;
                }
                break;
            case 9:
                ReportLiveShowHelper.f15334a.c(getContext());
                break;
            case 10:
                p1.g gVar = p1.g.f52734a;
                gVar.p3(Boolean.valueOf(!(gVar.Y0() != null ? r1.booleanValue() : false)));
                Boolean Y0 = gVar.Y0();
                Boolean bool = Boolean.TRUE;
                if (s.d(Y0, bool)) {
                    valueOf = Integer.valueOf(R$mipmap.icon_open_gift_effects);
                } else {
                    valueOf = Integer.valueOf(R$mipmap.icon_close_gift_effects);
                }
                model.setIcon(valueOf);
                Y0().notifyItemChanged(Y0().j().indexOf(model));
                com.cupidapp.live.base.view.h.f12779a.b(s.d(gVar.Y0(), bool) ? R$string.gift_effects_opened : R$string.gift_effects_closed);
                GroupOthersLog groupOthersLog = GroupOthersLog.f18702a;
                AppSetting appSetting = AppSetting.GIFT_SPECIAL_EFFECT;
                Boolean Y02 = gVar.Y0();
                GroupOthersLog.l0(groupOthersLog, appSetting, Y02 != null ? Y02.booleanValue() : false, null, null, 12, null);
                break;
            case 11:
                FKLiveConstantsData fKLiveConstantsData5 = FKLiveConstantsData.INSTANCE;
                LiveShowResult fkLiveShowResult11 = fKLiveConstantsData5.getFkLiveShowResult();
                if (fkLiveShowResult11 != null && (giftWall = fkLiveShowResult11.getGiftWall()) != null && (url6 = giftWall.getUrl()) != null) {
                    if (model.getShowRedDot()) {
                        LiveShowResult fkLiveShowResult12 = fKLiveConstantsData5.getFkLiveShowResult();
                        magicRefine2 = fkLiveShowResult12 != null ? fkLiveShowResult12.getGiftWall() : null;
                        if (magicRefine2 != null) {
                            magicRefine2.setUnread(false);
                        }
                    }
                    b1(url6);
                    d1(LiveProtos.Type.MORE_GIFT_WALL);
                    break;
                }
                break;
            case 12:
                FKLiveConstantsData fKLiveConstantsData6 = FKLiveConstantsData.INSTANCE;
                LiveShowResult fkLiveShowResult13 = fKLiveConstantsData6.getFkLiveShowResult();
                if (fkLiveShowResult13 != null && (streamFollowBtn = fkLiveShowResult13.getStreamFollowBtn()) != null && (url7 = streamFollowBtn.getUrl()) != null) {
                    if (model.getShowRedDot()) {
                        LiveShowResult fkLiveShowResult14 = fKLiveConstantsData6.getFkLiveShowResult();
                        magicRefine2 = fkLiveShowResult14 != null ? fkLiveShowResult14.getStreamFollowBtn() : null;
                        if (magicRefine2 != null) {
                            magicRefine2.setUnread(false);
                        }
                    }
                    b1(url7);
                    d1(LiveProtos.Type.MORE_FOLLOW);
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

    public final void d1(LiveProtos.Type type) {
        LiveShowModel liveShowModel = FKLiveConstantsData.INSTANCE.getLiveShowModel();
        if (liveShowModel != null) {
            SensorsLogLiveShow sensorsLogLiveShow = SensorsLogLiveShow.f12212a;
            String itemId = liveShowModel.getItemId();
            String userId = liveShowModel.getUser().userId();
            Bundle arguments = getArguments();
            sensorsLogLiveShow.f(itemId, userId, type, (r13 & 8) != 0 ? null : arguments != null ? arguments.getString("ENTER_SOURCE") : null, (r13 & 16) != 0 ? null : null);
        }
    }

    @Override // com.cupidapp.live.liveshow.view.bottommenu.BaseLiveMoreMenuFragment, com.cupidapp.live.base.fragment.BaseBottomSheetDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        O0();
    }

    @Override // com.cupidapp.live.liveshow.view.bottommenu.BaseLiveMoreMenuFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        R0(3, true);
    }
}
