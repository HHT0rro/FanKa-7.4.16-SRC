package com.tencent.liteav.videoconsumer.consumer;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final /* synthetic */ class c implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final b f43728a;

    private c(b bVar) {
        this.f43728a = bVar;
    }

    public static Runnable a(b bVar) {
        return new c(bVar);
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0042, code lost:
    
        if (r3 == 270) goto L16;
     */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void run() {
        /*
            r8 = this;
            com.tencent.liteav.videoconsumer.consumer.b r0 = r8.f43728a
            com.tencent.liteav.videobase.utils.m r1 = r0.f43717z
            com.tencent.liteav.videobase.frame.PixelFrame r1 = r1.a()
            if (r1 == 0) goto Ld2
        La:
            java.util.PriorityQueue<com.tencent.liteav.videoconsumer.consumer.b$a> r2 = r0.A
            boolean r2 = r2.isEmpty()
            if (r2 != 0) goto L60
            java.util.PriorityQueue<com.tencent.liteav.videoconsumer.consumer.b$a> r2 = r0.A
            java.lang.Object r2 = r2.peek()
            com.tencent.liteav.videoconsumer.consumer.b$a r2 = (com.tencent.liteav.videoconsumer.consumer.b.a) r2
            if (r2 == 0) goto L60
            long r3 = com.tencent.liteav.videoconsumer.consumer.b.a.a(r2)
            long r5 = r1.getTimestamp()
            int r7 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r7 > 0) goto L60
            long r3 = com.tencent.liteav.videoconsumer.consumer.b.a.a(r2)
            long r5 = r1.getTimestamp()
            int r7 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r7 != 0) goto L5a
            int r3 = com.tencent.liteav.videoconsumer.consumer.b.a.b(r2)
            r4 = 90
            if (r3 == r4) goto L44
            int r3 = com.tencent.liteav.videoconsumer.consumer.b.a.b(r2)
            r4 = 270(0x10e, float:3.78E-43)
            if (r3 != r4) goto L47
        L44:
            r1.swapWidthHeight()
        L47:
            int r2 = com.tencent.liteav.videoconsumer.consumer.b.a.b(r2)
            int r2 = r2 % 360
            com.tencent.liteav.base.util.Rotation r2 = com.tencent.liteav.base.util.Rotation.a(r2)
            r1.setRotation(r2)
            java.util.PriorityQueue<com.tencent.liteav.videoconsumer.consumer.b$a> r2 = r0.A
            r2.poll()
            goto L60
        L5a:
            java.util.PriorityQueue<com.tencent.liteav.videoconsumer.consumer.b$a> r2 = r0.A
            r2.poll()
            goto La
        L60:
            int r2 = r0.f43712u
            int r3 = r1.getWidth()
            if (r2 != r3) goto L70
            int r2 = r0.f43713v
            int r3 = r1.getHeight()
            if (r2 == r3) goto L9d
        L70:
            int r2 = r1.getWidth()
            r0.f43712u = r2
            int r2 = r1.getHeight()
            r0.f43713v = r2
            com.tencent.liteav.videobase.videobase.IVideoReporter r2 = r0.f43694c
            com.tencent.liteav.videobase.videobase.h$b r3 = com.tencent.liteav.videobase.videobase.h.b.EVT_VIDEO_RENDER_RESOLUTION_CHANGE
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            java.lang.String r5 = "resolution change to "
            r4.<init>(r5)
            int r5 = r0.f43712u
            r4.append(r5)
            java.lang.String r5 = "x"
            r4.append(r5)
            int r5 = r0.f43713v
            r4.append(r5)
            java.lang.String r4 = r4.toString()
            r2.notifyEvent(r3, r1, r4)
        L9d:
            r2 = 0
            java.util.List r3 = r0.a()
            java.util.Iterator r3 = r3.iterator2()
        La6:
            boolean r4 = r3.hasNext()
            if (r4 == 0) goto Lb9
            java.lang.Object r4 = r3.next()
            com.tencent.liteav.videoconsumer.renderer.r r4 = (com.tencent.liteav.videoconsumer.renderer.r) r4
            if (r4 == 0) goto La6
            r4.a(r1)
            r2 = 1
            goto La6
        Lb9:
            if (r2 != 0) goto Lc6
            com.tencent.liteav.videobase.videobase.IVideoReporter r2 = r0.f43694c
            com.tencent.liteav.videobase.videobase.i r3 = com.tencent.liteav.videobase.videobase.i.STATUS_CONSUMER_FINISH_HANDLE_FRAME
            com.tencent.liteav.videobase.utils.ConsumerChainTimestamp r4 = r1.getConsumerChainTimestamp()
            r2.updateStatus(r3, r4)
        Lc6:
            java.util.concurrent.atomic.AtomicLong r0 = r0.f43716y
            long r2 = r1.getTimestamp()
            r0.getAndSet(r2)
            r1.release()
        Ld2:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.liteav.videoconsumer.consumer.c.run():void");
    }
}
