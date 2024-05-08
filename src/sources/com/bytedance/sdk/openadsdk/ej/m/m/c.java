package com.bytedance.sdk.openadsdk.ej.m.m;

import android.app.Activity;
import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bytedance.sdk.openadsdk.ComplianceInfo;
import com.bytedance.sdk.openadsdk.DislikeInfo;
import com.bytedance.sdk.openadsdk.DownloadStatusController;
import com.bytedance.sdk.openadsdk.TTAdDislike;
import com.bytedance.sdk.openadsdk.TTAppDownloadListener;
import com.bytedance.sdk.openadsdk.TTDislikeDialogAbstract;
import com.bytedance.sdk.openadsdk.TTFeedAd;
import com.bytedance.sdk.openadsdk.TTImage;
import com.bytedance.sdk.openadsdk.TTNativeAd;
import com.bytedance.sdk.openadsdk.mediation.ad.IMediationViewBinder;
import com.bytedance.sdk.openadsdk.mediation.manager.MediationNativeManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import o0.a;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class c implements TTFeedAd {

    /* renamed from: m, reason: collision with root package name */
    private final Bridge f11182m;

    public c(Bridge bridge) {
        this.f11182m = bridge == null ? a.f52239c : bridge;
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public void destroy() {
        this.f11182m.call(140114, a.c(0).a(), Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public Bitmap getAdLogo() {
        return (Bitmap) this.f11182m.values().objectValue(140002, Bitmap.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public View getAdView() {
        return (View) this.f11182m.values().objectValue(140016, View.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTFeedAd
    public int getAdViewHeight() {
        return this.f11182m.values().intValue(160004);
    }

    @Override // com.bytedance.sdk.openadsdk.TTFeedAd
    public int getAdViewWidth() {
        return this.f11182m.values().intValue(160003);
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public int getAppCommentNum() {
        return this.f11182m.values().intValue(140006);
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public int getAppScore() {
        return this.f11182m.values().intValue(140005);
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public int getAppSize() {
        return this.f11182m.values().intValue(140007);
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public String getButtonText() {
        return (String) this.f11182m.values().objectValue(140018, String.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public ComplianceInfo getComplianceInfo() {
        return new ej((Bridge) this.f11182m.values().objectValue(140014, Bridge.class));
    }

    @Override // com.bytedance.sdk.openadsdk.TTFeedAd
    public TTFeedAd.CustomizeVideo getCustomVideo() {
        return new com.bytedance.sdk.openadsdk.w.m.m.m.m((Bridge) this.f11182m.values().objectValue(160002, Bridge.class));
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public String getDescription() {
        return (String) this.f11182m.values().objectValue(140004, String.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public TTAdDislike getDislikeDialog(Activity activity) {
        a c4 = a.c(1);
        c4.h(0, activity);
        return new e((Bridge) this.f11182m.call(140101, c4.a(), Bridge.class));
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public DislikeInfo getDislikeInfo() {
        return new l((Bridge) this.f11182m.values().objectValue(140013, Bridge.class));
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public DownloadStatusController getDownloadStatusController() {
        return new np((Bridge) this.f11182m.values().objectValue(140015, Bridge.class));
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public TTImage getIcon() {
        return new sy((Bridge) this.f11182m.values().objectValue(140009, Bridge.class));
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public List<TTImage> getImageList() {
        Iterable iterable = (List) this.f11182m.values().objectValue(140010, List.class);
        if (iterable == null) {
            iterable = new ArrayList(0);
        }
        ArrayList arrayList = new ArrayList();
        Iterator iterator2 = iterable.iterator2();
        while (iterator2.hasNext()) {
            arrayList.add(new sy((Bridge) iterator2.next()));
        }
        return arrayList;
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public int getImageMode() {
        return this.f11182m.values().intValue(140012);
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public int getInteractionType() {
        return this.f11182m.values().intValue(140011);
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public Map<String, Object> getMediaExtraInfo() {
        return (Map) this.f11182m.values().objectValue(140017, Map.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public MediationNativeManager getMediationManager() {
        return new com.bytedance.sdk.openadsdk.mediation.manager.m.m.m.l((Bridge) this.f11182m.call(140116, a.c(0).a(), Bridge.class));
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public String getSource() {
        return (String) this.f11182m.values().objectValue(140008, String.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public String getTitle() {
        return (String) this.f11182m.values().objectValue(140003, String.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public TTImage getVideoCoverImage() {
        return new sy((Bridge) this.f11182m.values().objectValue(140001, Bridge.class));
    }

    @Override // com.bytedance.sdk.openadsdk.TTFeedAd
    public double getVideoDuration() {
        return this.f11182m.values().doubleValue(160001);
    }

    @Override // com.bytedance.sdk.openadsdk.TTClientBidding
    public void loss(Double d10, String str, String str2) {
        a c4 = a.c(3);
        c4.h(0, d10);
        c4.i(1, str);
        c4.i(2, str2);
        this.f11182m.call(210102, c4.a(), Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public void registerViewForInteraction(ViewGroup viewGroup, View view, TTNativeAd.AdInteractionListener adInteractionListener) {
        a c4 = a.c(3);
        c4.h(0, viewGroup);
        c4.h(1, view);
        c4.h(2, new com.bytedance.sdk.openadsdk.c.m.m.m.m(adInteractionListener));
        this.f11182m.call(140103, c4.a(), Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public void render() {
        this.f11182m.call(140110, a.c(0).a(), Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public void setActivityForDownloadApp(Activity activity) {
        a c4 = a.c(1);
        c4.h(0, activity);
        this.f11182m.call(140109, c4.a(), Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public void setDislikeCallback(Activity activity, TTAdDislike.DislikeInteractionCallback dislikeInteractionCallback) {
        a c4 = a.c(2);
        c4.h(0, activity);
        c4.h(1, new com.bytedance.sdk.openadsdk.n.m.m.m.m(dislikeInteractionCallback));
        this.f11182m.call(140112, c4.a(), Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public void setDislikeDialog(TTDislikeDialogAbstract tTDislikeDialogAbstract) {
        a c4 = a.c(1);
        c4.h(0, tTDislikeDialogAbstract);
        this.f11182m.call(140113, c4.a(), Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public void setDownloadListener(TTAppDownloadListener tTAppDownloadListener) {
        a c4 = a.c(1);
        c4.h(0, new com.bytedance.sdk.openadsdk.ej.m.dk.m(tTAppDownloadListener));
        this.f11182m.call(140108, c4.a(), Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public void setExpressRenderListener(TTNativeAd.ExpressRenderListener expressRenderListener) {
        a c4 = a.c(1);
        c4.h(0, new com.bytedance.sdk.openadsdk.c.m.m.m.dk(expressRenderListener));
        this.f11182m.call(140111, c4.a(), Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTClientBidding
    public void setPrice(Double d10) {
        a c4 = a.c(1);
        c4.h(0, d10);
        this.f11182m.call(210103, c4.a(), Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTFeedAd
    public void setVideoAdListener(TTFeedAd.VideoAdListener videoAdListener) {
        a c4 = a.c(1);
        c4.h(0, new com.bytedance.sdk.openadsdk.w.m.m.dk.m(videoAdListener));
        this.f11182m.call(160101, c4.a(), Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTFeedAd
    public void setVideoRewardListener(TTFeedAd.VideoRewardListener videoRewardListener) {
        a c4 = a.c(1);
        c4.h(0, new com.bytedance.sdk.openadsdk.w.m.m.dk.dk(videoRewardListener));
        this.f11182m.call(160102, c4.a(), Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public void showInteractionExpressAd(Activity activity) {
        a c4 = a.c(1);
        c4.h(0, activity);
        this.f11182m.call(140115, c4.a(), Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTClientBidding
    public void win(Double d10) {
        a c4 = a.c(1);
        c4.h(0, d10);
        this.f11182m.call(210101, c4.a(), Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public TTAdDislike getDislikeDialog(TTDislikeDialogAbstract tTDislikeDialogAbstract) {
        a c4 = a.c(1);
        c4.h(0, tTDislikeDialogAbstract);
        return new e((Bridge) this.f11182m.call(140102, c4.a(), Bridge.class));
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public void registerViewForInteraction(ViewGroup viewGroup, List<View> list, List<View> list2, TTNativeAd.AdInteractionListener adInteractionListener) {
        a c4 = a.c(4);
        c4.h(0, viewGroup);
        c4.h(1, list);
        c4.h(2, list2);
        c4.h(3, new com.bytedance.sdk.openadsdk.c.m.m.m.m(adInteractionListener));
        this.f11182m.call(140104, c4.a(), Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public void registerViewForInteraction(ViewGroup viewGroup, List<View> list, List<View> list2, View view, TTNativeAd.AdInteractionListener adInteractionListener) {
        a c4 = a.c(5);
        c4.h(0, viewGroup);
        c4.h(1, list);
        c4.h(2, list2);
        c4.h(3, view);
        c4.h(4, new com.bytedance.sdk.openadsdk.c.m.m.m.m(adInteractionListener));
        this.f11182m.call(140105, c4.a(), Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public void registerViewForInteraction(ViewGroup viewGroup, List<View> list, List<View> list2, List<View> list3, View view, TTNativeAd.AdInteractionListener adInteractionListener) {
        a c4 = a.c(6);
        c4.h(0, viewGroup);
        c4.h(1, list);
        c4.h(2, list2);
        c4.h(3, list3);
        c4.h(4, view);
        c4.h(5, new com.bytedance.sdk.openadsdk.c.m.m.m.m(adInteractionListener));
        this.f11182m.call(140106, c4.a(), Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public void registerViewForInteraction(ViewGroup viewGroup, List<View> list, List<View> list2, List<View> list3, List<View> list4, View view, TTNativeAd.AdInteractionListener adInteractionListener) {
        a c4 = a.c(7);
        c4.h(0, viewGroup);
        c4.h(1, list);
        c4.h(2, list2);
        c4.h(3, list3);
        c4.h(4, list4);
        c4.h(5, view);
        c4.h(6, new com.bytedance.sdk.openadsdk.c.m.m.m.m(adInteractionListener));
        this.f11182m.call(140107, c4.a(), Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public void registerViewForInteraction(Activity activity, ViewGroup viewGroup, List<View> list, List<View> list2, List<View> list3, TTNativeAd.AdInteractionListener adInteractionListener, IMediationViewBinder iMediationViewBinder) {
        a c4 = a.c(7);
        c4.h(0, activity);
        c4.h(1, viewGroup);
        c4.h(2, list);
        c4.h(3, list2);
        c4.h(4, list3);
        c4.h(5, new com.bytedance.sdk.openadsdk.c.m.m.m.m(adInteractionListener));
        c4.h(6, new com.bytedance.sdk.openadsdk.mediation.ad.m.m.dk.np(iMediationViewBinder));
        this.f11182m.call(140117, c4.a(), Void.class);
    }
}
