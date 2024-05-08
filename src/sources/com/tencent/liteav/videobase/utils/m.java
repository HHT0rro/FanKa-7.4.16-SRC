package com.tencent.liteav.videobase.utils;

import com.tencent.liteav.base.util.LiteavLog;
import com.tencent.liteav.videobase.frame.PixelFrame;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class m implements k {

    /* renamed from: a, reason: collision with root package name */
    private final Deque<PixelFrame> f43531a = new LinkedList();

    /* renamed from: b, reason: collision with root package name */
    private int f43532b = 1;

    @Override // com.tencent.liteav.videobase.utils.k
    public final PixelFrame a() {
        PixelFrame pollFirst;
        synchronized (this) {
            pollFirst = this.f43531a.pollFirst();
        }
        return pollFirst;
    }

    @Override // com.tencent.liteav.videobase.utils.k
    public final void b() {
        ArrayList arrayList;
        synchronized (this) {
            arrayList = new ArrayList(this.f43531a);
            this.f43531a.clear();
        }
        LiteavLog.i("RingFrameQueue", "evictAll pixelFrame.");
        PixelFrame.releasePixelFrames(arrayList);
    }

    public final int c() {
        int size;
        synchronized (this) {
            size = this.f43531a.size();
        }
        return size;
    }

    @Override // com.tencent.liteav.videobase.utils.k
    public final void a(PixelFrame pixelFrame) {
        PixelFrame removeFirst;
        pixelFrame.retain();
        synchronized (this) {
            removeFirst = this.f43531a.size() >= this.f43532b ? this.f43531a.removeFirst() : null;
            this.f43531a.addLast(pixelFrame);
        }
        if (removeFirst != null) {
            removeFirst.release();
        }
    }

    public final boolean b(PixelFrame pixelFrame) {
        boolean removeFirstOccurrence;
        if (pixelFrame == null) {
            return false;
        }
        synchronized (this) {
            removeFirstOccurrence = this.f43531a.size() > 0 ? this.f43531a.removeFirstOccurrence(pixelFrame) : false;
        }
        if (removeFirstOccurrence) {
            pixelFrame.release();
        }
        return removeFirstOccurrence;
    }
}
