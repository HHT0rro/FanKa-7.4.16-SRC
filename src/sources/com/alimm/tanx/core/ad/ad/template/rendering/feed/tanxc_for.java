package com.alimm.tanx.core.ad.ad.template.rendering.feed;

import android.content.Context;
import com.alimm.tanx.core.ad.ad.template.rendering.feed.view.TanxFeedAdInteractionView;
import com.alimm.tanx.core.ad.ad.template.rendering.feed.view.TanxFeedAdNativeView;
import com.alimm.tanx.core.ad.ad.template.rendering.feed.view.TanxFeedAdView;
import com.alimm.tanx.core.ad.ad.template.rendering.feed.view.TanxFeedAdWebView;
import com.alimm.tanx.core.view.feed.ITanxFeedCacheContext;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: TanxFeedViewCache.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class tanxc_for {
    public List<WeakReference<TanxFeedAdNativeView>> tanxc_do;
    public List<WeakReference<TanxFeedAdWebView>> tanxc_for;
    public List<WeakReference<TanxFeedAdInteractionView>> tanxc_if;

    public TanxFeedAdView tanxc_do(ITanxFeedCacheContext iTanxFeedCacheContext, Context context) {
        TanxFeedAdNativeView tanxFeedAdNativeView = null;
        if (iTanxFeedCacheContext == null) {
            return null;
        }
        if (this.tanxc_do == null) {
            this.tanxc_do = new ArrayList();
        }
        iTanxFeedCacheContext.remove();
        Iterator<WeakReference<TanxFeedAdNativeView>> iterator2 = this.tanxc_do.iterator2();
        while (iterator2.hasNext()) {
            TanxFeedAdNativeView tanxFeedAdNativeView2 = iterator2.next().get();
            if (tanxFeedAdNativeView2 == null) {
                iterator2.remove();
            } else if (tanxFeedAdNativeView == null && tanxFeedAdNativeView2.getParent() == null) {
                tanxFeedAdNativeView = tanxFeedAdNativeView2;
            }
        }
        if (tanxFeedAdNativeView != null) {
            return tanxFeedAdNativeView;
        }
        TanxFeedAdNativeView tanxFeedAdNativeView3 = new TanxFeedAdNativeView(context);
        this.tanxc_do.add(new WeakReference<>(tanxFeedAdNativeView3));
        return tanxFeedAdNativeView3;
    }

    public TanxFeedAdView tanxc_for(ITanxFeedCacheContext iTanxFeedCacheContext, Context context) {
        TanxFeedAdWebView tanxFeedAdWebView = null;
        if (iTanxFeedCacheContext == null) {
            return null;
        }
        if (this.tanxc_for == null) {
            this.tanxc_for = new ArrayList();
        }
        iTanxFeedCacheContext.remove();
        Iterator<WeakReference<TanxFeedAdWebView>> iterator2 = this.tanxc_for.iterator2();
        while (iterator2.hasNext()) {
            TanxFeedAdWebView tanxFeedAdWebView2 = iterator2.next().get();
            if (tanxFeedAdWebView2 == null) {
                iterator2.remove();
            } else if (tanxFeedAdWebView == null && tanxFeedAdWebView2.getParent() == null) {
                tanxFeedAdWebView = tanxFeedAdWebView2;
            }
        }
        if (tanxFeedAdWebView != null) {
            return tanxFeedAdWebView;
        }
        TanxFeedAdWebView tanxFeedAdWebView3 = new TanxFeedAdWebView(context);
        this.tanxc_for.add(new WeakReference<>(tanxFeedAdWebView3));
        return tanxFeedAdWebView3;
    }

    public TanxFeedAdView tanxc_if(ITanxFeedCacheContext iTanxFeedCacheContext, Context context) {
        TanxFeedAdInteractionView tanxFeedAdInteractionView = null;
        if (iTanxFeedCacheContext == null) {
            return null;
        }
        if (this.tanxc_if == null) {
            this.tanxc_if = new ArrayList();
        }
        iTanxFeedCacheContext.remove();
        Iterator<WeakReference<TanxFeedAdInteractionView>> iterator2 = this.tanxc_if.iterator2();
        while (iterator2.hasNext()) {
            TanxFeedAdInteractionView tanxFeedAdInteractionView2 = iterator2.next().get();
            if (tanxFeedAdInteractionView2 == null) {
                iterator2.remove();
            } else if (tanxFeedAdInteractionView == null && tanxFeedAdInteractionView2.getParent() == null) {
                tanxFeedAdInteractionView = tanxFeedAdInteractionView2;
            }
        }
        if (tanxFeedAdInteractionView != null) {
            return tanxFeedAdInteractionView;
        }
        TanxFeedAdInteractionView tanxFeedAdInteractionView3 = new TanxFeedAdInteractionView(context);
        this.tanxc_if.add(new WeakReference<>(tanxFeedAdInteractionView3));
        return tanxFeedAdInteractionView3;
    }
}
