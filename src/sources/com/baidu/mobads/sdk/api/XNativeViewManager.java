package com.baidu.mobads.sdk.api;

import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class XNativeViewManager {
    private static XNativeViewManager sInstance;
    private final ArrayList<XNativeView> mViewList = new ArrayList<>();

    private XNativeViewManager() {
    }

    public static XNativeViewManager getInstance() {
        if (sInstance == null) {
            synchronized (XNativeViewManager.class) {
                if (sInstance == null) {
                    sInstance = new XNativeViewManager();
                }
            }
        }
        return sInstance;
    }

    public void addItem(XNativeView xNativeView) {
        this.mViewList.add(xNativeView);
    }

    public void removeNativeView(XNativeView xNativeView) {
        if (this.mViewList.size() == 0) {
            return;
        }
        this.mViewList.remove(xNativeView);
    }

    public void resetAllPlayer(XNativeView xNativeView) {
        if (this.mViewList.size() == 0) {
            return;
        }
        Iterator<XNativeView> iterator2 = this.mViewList.iterator2();
        while (iterator2.hasNext()) {
            XNativeView next = iterator2.next();
            if (next != xNativeView) {
                next.stop();
                next.handleCover();
            }
        }
    }
}
