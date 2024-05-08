package com.tencent.liteav.videobase.a;

import android.opengl.GLES20;
import com.tencent.liteav.base.util.Rotation;
import com.tencent.liteav.base.util.Size;
import com.tencent.liteav.videobase.utils.OpenGlUtils;
import java.lang.reflect.Array;
import java.nio.FloatBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public abstract class k extends b {

    /* renamed from: a, reason: collision with root package name */
    public final a f43263a;

    /* renamed from: b, reason: collision with root package name */
    private final FloatBuffer f43264b;

    /* renamed from: c, reason: collision with root package name */
    private final FloatBuffer f43265c;

    /* renamed from: d, reason: collision with root package name */
    private final List<a> f43266d;

    /* renamed from: e, reason: collision with root package name */
    private final Map<a, Integer> f43267e;

    /* renamed from: f, reason: collision with root package name */
    private a f43268f;

    /* renamed from: g, reason: collision with root package name */
    private int[] f43269g;

    /* renamed from: h, reason: collision with root package name */
    private int f43270h;

    /* renamed from: i, reason: collision with root package name */
    private com.tencent.liteav.videobase.frame.d f43271i;

    /* renamed from: j, reason: collision with root package name */
    private FloatBuffer f43272j;

    /* renamed from: k, reason: collision with root package name */
    private FloatBuffer f43273k;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public final b f43274a;

        /* renamed from: b, reason: collision with root package name */
        public final Map<String, a> f43275b;

        /* renamed from: c, reason: collision with root package name */
        public com.tencent.liteav.videobase.frame.d f43276c;

        /* renamed from: d, reason: collision with root package name */
        public int f43277d;

        public /* synthetic */ a(b bVar, byte b4) {
            this(bVar);
        }

        public final void a(a aVar) {
            aVar.f43277d++;
            this.f43275b.put("input-texture-name-for-on-draw", aVar);
        }

        private a(b bVar) {
            this.f43275b = new HashMap();
            this.f43276c = null;
            this.f43277d = 0;
            this.f43274a = bVar;
        }

        public final void a(String str, a aVar) {
            aVar.f43277d++;
            this.f43275b.put(str, aVar);
        }
    }

    public k() {
        ArrayList arrayList = new ArrayList();
        this.f43266d = arrayList;
        this.f43267e = new HashMap();
        this.f43264b = OpenGlUtils.createNormalCubeVerticesBuffer();
        this.f43265c = OpenGlUtils.createTextureCoordsBuffer(Rotation.NORMAL, false, false);
        a aVar = new a(null, (byte) 0);
        this.f43263a = aVar;
        arrayList.add(aVar);
    }

    public final a a(b bVar) {
        a aVar = new a(bVar, (byte) 0);
        this.f43266d.add(aVar);
        return aVar;
    }

    @Override // com.tencent.liteav.videobase.a.b
    public void onDraw(int i10, com.tencent.liteav.videobase.frame.d dVar, FloatBuffer floatBuffer, FloatBuffer floatBuffer2) {
        if (isInitialized()) {
            runPendingOnDrawTasks();
            this.f43270h = i10;
            this.f43271i = dVar;
            this.f43272j = floatBuffer;
            this.f43273k = floatBuffer2;
            Arrays.fill(this.f43269g, 0);
            a(this.f43268f);
            Iterator<a> iterator2 = this.f43266d.iterator2();
            while (iterator2.hasNext()) {
                iterator2.next();
            }
        }
    }

    @Override // com.tencent.liteav.videobase.a.b
    public void onInit(com.tencent.liteav.videobase.frame.e eVar) {
        super.onInit(eVar);
        Iterator<a> iterator2 = this.f43266d.iterator2();
        while (iterator2.hasNext()) {
            b bVar = iterator2.next().f43274a;
            if (bVar != null) {
                bVar.initialize(eVar);
            }
        }
        for (int i10 = 0; i10 < this.f43266d.size(); i10++) {
            this.f43267e.put(this.f43266d.get(i10), Integer.valueOf(i10));
        }
        int size = this.f43266d.size();
        ArrayList arrayList = new ArrayList();
        for (int i11 = 0; i11 < size; i11++) {
            arrayList.add(Integer.valueOf(i11));
        }
        boolean[][] zArr = (boolean[][]) Array.newInstance((Class<?>) boolean.class, size, size);
        for (int i12 = 0; i12 < this.f43266d.size(); i12++) {
            Arrays.fill(zArr[i12], false);
        }
        for (a aVar : this.f43266d) {
            int intValue = this.f43267e.get(aVar).intValue();
            Iterator<a> iterator22 = aVar.f43275b.values().iterator2();
            while (iterator22.hasNext()) {
                zArr[this.f43267e.get(iterator22.next()).intValue()][intValue] = true;
            }
        }
        int[] iArr = new int[size];
        int[] iArr2 = new int[size];
        ArrayList arrayList2 = new ArrayList();
        while (arrayList.size() > 1) {
            Arrays.fill(iArr, 0);
            Arrays.fill(iArr2, 0);
            arrayList2.clear();
            for (int i13 = 0; i13 < size; i13++) {
                for (int i14 = 0; i14 < size; i14++) {
                    if (zArr[i13][i14]) {
                        iArr2[i13] = iArr2[i13] + 1;
                        iArr[i14] = iArr[i14] + 1;
                    }
                }
            }
            Iterator iterator23 = arrayList.iterator2();
            while (iterator23.hasNext()) {
                int intValue2 = ((Integer) iterator23.next()).intValue();
                if (iArr[intValue2] == 0 && iArr2[intValue2] != 0) {
                    arrayList2.add(Integer.valueOf(intValue2));
                }
            }
            if (arrayList2.isEmpty()) {
                break;
            }
            arrayList.removeAll(arrayList2);
            Iterator<E> iterator24 = arrayList2.iterator2();
            while (iterator24.hasNext()) {
                Arrays.fill(zArr[((Integer) iterator24.next()).intValue()], false);
            }
        }
        a aVar2 = arrayList.size() == 1 ? this.f43266d.get(((Integer) arrayList.get(0)).intValue()) : null;
        this.f43268f = aVar2;
        if (aVar2 != null) {
            this.f43269g = new int[this.f43266d.size()];
            return;
        }
        throw new RuntimeException("Directed acyclic graph can't find a final node.");
    }

    @Override // com.tencent.liteav.videobase.a.b
    public void onOutputSizeChanged(int i10, int i11) {
        super.onOutputSizeChanged(i10, i11);
        Iterator<a> iterator2 = this.f43266d.iterator2();
        while (iterator2.hasNext()) {
            b bVar = iterator2.next().f43274a;
            if (bVar != null) {
                bVar.onOutputSizeChanged(i10, i11);
            }
        }
    }

    @Override // com.tencent.liteav.videobase.a.b
    public void onUninit() {
        super.onUninit();
        Iterator<a> iterator2 = this.f43266d.iterator2();
        while (iterator2.hasNext()) {
            b bVar = iterator2.next().f43274a;
            if (bVar != null) {
                bVar.uninitialize();
            }
        }
    }

    private void a(a aVar) {
        for (a aVar2 : aVar.f43275b.values()) {
            if (aVar2 != this.f43263a && aVar2.f43276c == null) {
                a(aVar2);
            }
        }
        b bVar = aVar.f43274a;
        if (bVar instanceof j) {
            j jVar = (j) bVar;
            for (Map.Entry<String, a> entry : aVar.f43275b.entrySet()) {
                if (!"input-texture-name-for-on-draw".equals(entry.getKey())) {
                    if (entry.getValue() == this.f43263a) {
                        jVar.a(entry.getKey(), this.f43270h);
                    } else {
                        jVar.a(entry.getKey(), entry.getValue().f43276c.a());
                    }
                }
            }
        }
        com.tencent.liteav.videobase.frame.d dVar = this.f43271i;
        Size size = this.mOutputSize;
        int i10 = size.width;
        int i11 = size.height;
        if (aVar != this.f43268f) {
            i10 = aVar.f43274a.getOutputSize().width;
            i11 = aVar.f43274a.getOutputSize().height;
            dVar = this.mTexturePool.a(i10, i11);
            aVar.f43276c = dVar;
        }
        a aVar3 = aVar.f43275b.get("input-texture-name-for-on-draw");
        GLES20.glViewport(0, 0, i10, i11);
        if (aVar3 == this.f43263a) {
            aVar.f43274a.onDraw(this.f43270h, dVar, this.f43272j, this.f43273k);
        } else {
            aVar.f43274a.onDraw(aVar3.f43276c.a(), dVar, this.f43264b, this.f43265c);
        }
        for (a aVar4 : aVar.f43275b.values()) {
            int intValue = this.f43267e.get(aVar4).intValue();
            int[] iArr = this.f43269g;
            iArr[intValue] = iArr[intValue] + 1;
            com.tencent.liteav.videobase.frame.d dVar2 = aVar4.f43276c;
            if (dVar2 != null && iArr[intValue] == aVar4.f43277d) {
                dVar2.release();
                aVar4.f43276c = null;
            }
        }
    }
}
