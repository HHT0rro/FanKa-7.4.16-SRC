package com.kwad.sdk.utils.a;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.alimm.tanx.core.view.player.cache.videocache.HttpProxyCacheServer;
import com.kwad.sdk.utils.a.a;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteOrder;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executor;
import org.apache.commons.io.IOUtils;
import sun.security.util.DerValue;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class c {
    private static final int PAGE_SIZE;
    private static final int[] aRp = {0, 1, 4, 4, 8, 8};
    private static final byte[] aRq = new byte[0];
    private static final int aRr;
    private static final int aRs;
    private static final int aRt;
    private final String VM;
    private MappedByteBuffer aRA;
    private MappedByteBuffer aRB;
    private com.kwad.sdk.utils.a.b aRC;
    private int aRD;
    private long aRE;
    private int aRH;
    private int aRI;
    private int aRJ;
    private boolean aRK;
    private String aRL;
    private int aRM;
    private int aRO;
    private final Map<String, b> aRu;
    private FileChannel aRw;
    private FileChannel aRx;
    private RandomAccessFile aRy;
    private RandomAccessFile aRz;
    private final String name;
    private final d aRv = com.kwad.sdk.utils.a.d.aRZ;
    private final Map<String, a.b> aRF = new HashMap();
    private boolean aRG = false;
    private final ArrayList<e> aRN = new ArrayList<>();
    private boolean aRP = true;
    private final Executor aRQ = new f();

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static class a {
        public static int aRS = 11;
        public static final C0547c aRT = new C0547c(11);
        private final String VM;
        private int aRO = 0;
        private b[] aRU;
        private final String name;

        public a(String str, String str2) {
            if (str != null && !str.isEmpty()) {
                if (str2 != null && !str2.isEmpty()) {
                    if (!str.endsWith("/")) {
                        str = str + IOUtils.DIR_SEPARATOR_UNIX;
                    }
                    this.VM = str;
                    this.name = str2;
                    return;
                }
                throw new IllegalArgumentException("name is empty");
            }
            throw new IllegalArgumentException("path is empty");
        }

        public final c NM() {
            String str = this.VM + this.name;
            c hj = C0547c.hj(str);
            if (hj == null) {
                synchronized (a.class) {
                    hj = C0547c.hj(str);
                    if (hj == null) {
                        hj = new c(this.VM, this.name, this.aRU, this.aRO);
                        C0547c.b(str, hj);
                    }
                }
            }
            Integer num = C0547c.aRY.get(str);
            if (num != null) {
                C0547c.aRY.put(str, Integer.valueOf(num.intValue() + 1));
            } else {
                C0547c.aRY.put(str, 1);
            }
            return hj;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public interface b<T> {
        String NN();

        T g(byte[] bArr, int i10, int i11);

        byte[] m(T t2);
    }

    /* renamed from: com.kwad.sdk.utils.a.c$c, reason: collision with other inner class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static class C0547c {
        private static Map<String, c> aRV;
        private static List<String> aRW;
        private static int aRX;
        public static Map<String, Integer> aRY;

        public C0547c(int i10) {
            int size = getSize(i10);
            aRV = new ConcurrentHashMap(size);
            aRY = new HashMap(size);
            aRW = new CopyOnWriteArrayList();
            aRX = i10;
        }

        public static void b(String str, c cVar) {
            if (aRV == null) {
                aRV = new ConcurrentHashMap(getSize(aRX));
            }
            if (aRW == null) {
                aRW = new CopyOnWriteArrayList();
            }
            if (aRV.containsKey(str)) {
                aRW.remove(str);
                aRW.add(str);
            } else {
                aRW.add(str);
            }
            aRV.put(str, cVar);
            if (aRV.size() > aRX) {
                Integer num = aRY.get(aRW.get(0));
                if (num != null && num.intValue() != 2) {
                    ep(aRX + 1);
                    return;
                }
                c cVar2 = aRV.get(aRW.get(0));
                if (cVar2 != null) {
                    cVar2.release();
                }
                aRV.remove(aRW.get(0));
                aRW.remove(0);
            }
        }

        private static void ep(int i10) {
            com.kwad.sdk.utils.a.d.aRZ.i("Ks_UnionKv", "reSize:" + i10);
            aRX = i10;
        }

        private static int getSize(int i10) {
            return (int) ((i10 / 0.75f) + 1.0f);
        }

        public static c hj(String str) {
            if (aRV == null) {
                aRV = new ConcurrentHashMap(getSize(aRX));
            }
            if (aRW == null) {
                aRW = new CopyOnWriteArrayList();
            }
            c cVar = aRV.get(str);
            if (cVar == null) {
                return null;
            }
            aRW.remove(str);
            aRW.add(str);
            return cVar;
        }

        public static void remove(String str) {
            List<String> list = aRW;
            if (list != null) {
                list.remove(str);
            }
            Map<String, c> map = aRV;
            if (map != null) {
                map.remove(str);
            }
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public interface d {
        void a(String str, Exception exc);

        void e(String str, Throwable th);

        void i(String str, String str2);
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static class e implements Comparable<e> {
        public int end;
        public int start;

        public e(int i10, int i11) {
            this.start = i10;
            this.end = i11;
        }

        /* JADX INFO: Access modifiers changed from: private */
        @Override // java.lang.Comparable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compareTo(e eVar) {
            return this.start - eVar.start;
        }
    }

    static {
        int NQ = h.NQ();
        PAGE_SIZE = NQ;
        aRr = NQ - 192;
        int max = Math.max(NQ << 1, 16384);
        aRs = max;
        aRt = max << 1;
    }

    public c(String str, String str2, b[] bVarArr, int i10) {
        this.VM = str;
        this.name = str2;
        this.aRO = i10;
        HashMap hashMap = new HashMap();
        g gVar = g.aSg;
        hashMap.put(gVar.NN(), gVar);
        if (bVarArr != null && bVarArr.length > 0) {
            for (b bVar : bVarArr) {
                String NN = bVar.NN();
                if (hashMap.containsKey(NN)) {
                    hi("duplicate encoder tag:" + NN);
                } else {
                    hashMap.put(NN, bVar);
                }
            }
        }
        this.aRu = hashMap;
        synchronized (this.aRF) {
            com.kwad.sdk.utils.a.d.getExecutor().execute(new Runnable() { // from class: com.kwad.sdk.utils.a.c.1
                @Override // java.lang.Runnable
                public final void run() {
                    c.this.Nu();
                }
            });
            while (!this.aRG) {
                try {
                    this.aRF.wait();
                } catch (InterruptedException unused) {
                }
            }
        }
    }

    private int E(int i10, int i11) {
        if (i11 > 536870912) {
            IllegalStateException illegalStateException = new IllegalStateException("data size out of limit");
            if (!com.kwad.library.a.a.f36641md.booleanValue()) {
                u(illegalStateException);
            } else {
                throw illegalStateException;
            }
        }
        int i12 = PAGE_SIZE;
        if (i11 <= i12) {
            return i12;
        }
        while (i10 < i11) {
            int i13 = aRs;
            i10 = i10 <= i13 ? i10 << 1 : i10 + i13;
        }
        return i10;
    }

    private void F(int i10, int i11) {
        this.aRM += i11 - i10;
        ArrayList<e> arrayList = this.aRN;
        if (arrayList != null) {
            arrayList.add(new e(i10, i11));
        }
    }

    private boolean NA() {
        int i10 = this.aRO;
        if (i10 == 1) {
            Executor executor = this.aRQ;
            if (executor != null) {
                executor.execute(new Runnable() { // from class: com.kwad.sdk.utils.a.c.2
                    @Override // java.lang.Runnable
                    public final void run() {
                        c.this.NB();
                    }
                });
            }
        } else if (i10 == 2) {
            return NB();
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized boolean NB() {
        try {
            File file = new File(this.VM, this.name + ".tmp");
            if (h.ae(file)) {
                RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
                randomAccessFile.setLength(this.aRD);
                randomAccessFile.write(this.aRC.aRo, 0, this.aRD);
                randomAccessFile.close();
                File file2 = new File(this.VM, this.name + ".kvc");
                if (!file2.exists() || file2.delete()) {
                    if (file.renameTo(file2)) {
                        return true;
                    }
                    g(new Exception("rename failed"));
                }
            }
        } catch (Exception e2) {
            u(e2);
        }
        return false;
    }

    private void NC() {
        try {
            h.h(new File(this.VM, this.name + ".kvc"));
            h.h(new File(this.VM, this.name + ".tmp"));
        } catch (Exception e2) {
            u(e2);
        }
    }

    private void ND() {
        this.aRO = 1;
        h.closeQuietly(this.aRw);
        h.closeQuietly(this.aRx);
        this.aRw = null;
        this.aRx = null;
        this.aRA = null;
        this.aRB = null;
    }

    private void NE() {
        if (this.aRO == 0) {
            try {
                a(this.aRA);
                a(this.aRB);
            } catch (Throwable unused) {
                ND();
            }
        }
        NF();
        h.h(new File(this.VM + this.name));
    }

    private void NF() {
        this.aRD = 12;
        this.aRE = 0L;
        NL();
        this.aRF.clear();
        com.kwad.sdk.utils.a.b bVar = this.aRC;
        if (bVar != null && bVar.aRo.length == PAGE_SIZE) {
            bVar.B(0, 0);
            this.aRC.f(4, 0L);
        } else {
            this.aRC = new com.kwad.sdk.utils.a.b(PAGE_SIZE);
        }
    }

    private void NG() {
        com.kwad.sdk.utils.a.b bVar;
        com.kwad.sdk.utils.a.b bVar2 = this.aRC;
        if (bVar2 != null) {
            this.aRE ^= bVar2.D(this.aRH, this.aRI);
        }
        if (this.aRO == 0) {
            MappedByteBuffer mappedByteBuffer = this.aRA;
            if (mappedByteBuffer != null) {
                mappedByteBuffer.putInt(0, -1);
                b(this.aRA);
                this.aRA.putInt(0, this.aRD - 12);
            }
            MappedByteBuffer mappedByteBuffer2 = this.aRB;
            if (mappedByteBuffer2 != null) {
                b(mappedByteBuffer2);
            }
        } else {
            if (this.aRK && (bVar = this.aRC) != null) {
                bVar.B(0, this.aRD - 12);
            }
            com.kwad.sdk.utils.a.b bVar3 = this.aRC;
            if (bVar3 != null) {
                bVar3.f(4, this.aRE);
            }
        }
        this.aRK = false;
        this.aRJ = 0;
        this.aRI = 0;
    }

    private int NH() {
        int i10 = this.aRD;
        if (i10 <= 16384) {
            return 4096;
        }
        return i10 <= 65536 ? 8192 : 16384;
    }

    private void NI() {
        em(this.aRI);
        int i10 = this.aRD;
        this.aRH = i10;
        this.aRD = this.aRI + i10;
        com.kwad.sdk.utils.a.b bVar = this.aRC;
        if (bVar != null) {
            bVar.position = i10;
        }
        this.aRK = true;
    }

    private void NJ() {
        if (this.aRM < (NH() << 1)) {
            if (this.aRN.size() < (this.aRD < 16384 ? 80 : 160)) {
                return;
            }
        }
        en(0);
    }

    private void NK() {
        ArrayList<e> arrayList = this.aRN;
        if (arrayList == null) {
            return;
        }
        int size = arrayList.size() - 1;
        e eVar = this.aRN.get(size);
        while (size > 0) {
            size--;
            e eVar2 = this.aRN.get(size);
            if (eVar.start == eVar2.end) {
                eVar2.end = eVar.end;
                this.aRN.remove(size + 1);
            }
            eVar = eVar2;
        }
    }

    private void NL() {
        this.aRM = 0;
        ArrayList<e> arrayList = this.aRN;
        if (arrayList != null) {
            arrayList.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void Nu() {
        synchronized (this.aRF) {
            this.aRG = true;
            this.aRF.notify();
        }
        long nanoTime = System.nanoTime();
        if (!Nx() && this.aRO == 0) {
            Nv();
        }
        if (this.aRC == null) {
            this.aRC = new com.kwad.sdk.utils.a.b(PAGE_SIZE);
        }
        if (this.aRv != null) {
            info("loading finish, data len:" + this.aRD + ", get keys:" + this.aRF.size() + ", use time:" + ((System.nanoTime() - nanoTime) / 1000000) + " ms");
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x0113  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0132  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x019e A[Catch: all -> 0x01c0, TryCatch #0 {all -> 0x01c0, blocks: (B:3:0x0038, B:5:0x003e, B:8:0x0046, B:10:0x0070, B:13:0x0081, B:16:0x009e, B:17:0x00a9, B:20:0x00bc, B:23:0x00c0, B:25:0x00df, B:27:0x00e6, B:29:0x0106, B:31:0x010c, B:35:0x0117, B:38:0x011d, B:41:0x0134, B:43:0x013c, B:45:0x0155, B:46:0x0162, B:48:0x017e, B:50:0x0184, B:52:0x019e, B:58:0x0099, B:59:0x007e, B:61:0x01a8, B:63:0x01b2), top: B:2:0x0038, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:54:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void Nv() {
        /*
            Method dump skipped, instructions count: 459
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.sdk.utils.a.c.Nv():void");
    }

    private boolean Nw() {
        com.kwad.sdk.utils.a.b bVar = new com.kwad.sdk.utils.a.b(this.aRD);
        MappedByteBuffer mappedByteBuffer = this.aRB;
        if (mappedByteBuffer != null) {
            mappedByteBuffer.rewind();
            this.aRB.get(bVar.aRo, 0, this.aRD);
        }
        com.kwad.sdk.utils.a.b bVar2 = this.aRC;
        if (bVar2 == null) {
            return true;
        }
        byte[] bArr = bVar2.aRo;
        byte[] bArr2 = bVar.aRo;
        for (int i10 = 0; i10 < this.aRD; i10++) {
            if (bArr[i10] != bArr2[i10]) {
                return false;
            }
        }
        return true;
    }

    private boolean Nx() {
        File file = new File(this.VM, this.name + ".kvc");
        File file2 = new File(this.VM, this.name + ".tmp");
        boolean z10 = true;
        try {
            if (!file.exists()) {
                file = file2.exists() ? file2 : null;
            }
            if (file != null) {
                if (ad(file)) {
                    if (this.aRO == 0) {
                        if (a(this.aRC)) {
                            info("recover from c file");
                            try {
                                NC();
                                return true;
                            } catch (Exception e2) {
                                e = e2;
                                u(e);
                                return z10;
                            }
                        }
                        this.aRO = 1;
                    }
                } else {
                    NF();
                    NC();
                }
            } else if (this.aRO != 0) {
                File file3 = new File(this.VM, this.name + ".kva");
                File file4 = new File(this.VM, this.name + ".kvb");
                if (file3.exists() && file4.exists()) {
                    h(file3, file4);
                }
            }
            return false;
        } catch (Exception e10) {
            e = e10;
            z10 = false;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:101:0x016f, code lost:
    
        throw new java.lang.Exception("parse dara failed");
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private int Ny() {
        /*
            Method dump skipped, instructions count: 385
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.sdk.utils.a.c.Ny():int");
    }

    private void Nz() {
        if (this.aRO == 0 || !this.aRP) {
            return;
        }
        NA();
    }

    private boolean ad(File file) {
        long length = file.length();
        if (length != 0 && length <= HttpProxyCacheServer.Builder.DEFAULT_MAX_SIZE) {
            int i10 = (int) length;
            int E = E(PAGE_SIZE, i10);
            com.kwad.sdk.utils.a.b bVar = this.aRC;
            if (bVar != null && bVar.aRo.length == E) {
                bVar.position = 0;
            } else {
                bVar = new com.kwad.sdk.utils.a.b(new byte[E]);
                this.aRC = bVar;
            }
            h.a(file, bVar.aRo, i10);
            int i11 = bVar.getInt();
            long j10 = bVar.getLong();
            this.aRD = i11 + 12;
            if (i11 >= 0 && i11 <= i10 - 12 && j10 == bVar.D(12, i11) && Ny() == 0) {
                this.aRE = j10;
                return true;
            }
        }
        return false;
    }

    private static long e(long j10, int i10) {
        int i11 = (i10 & 7) << 3;
        return (j10 >>> (64 - i11)) | (j10 << i11);
    }

    private static void e(int i10, boolean z10) {
        if (z10) {
            if (i10 != 32) {
                throw new IllegalStateException("name size not match");
            }
        } else if (i10 < 0 || i10 >= 2048) {
            throw new IllegalStateException("value size out of bound");
        }
    }

    private static void el(int i10) {
        if (i10 > 255) {
            throw new IllegalArgumentException("key's length must less than 256");
        }
    }

    private void em(int i10) {
        if (this.aRC == null) {
            this.aRC = new com.kwad.sdk.utils.a.b(PAGE_SIZE);
        }
        int length = this.aRC.aRo.length;
        int i11 = this.aRD + i10;
        if (i11 >= length) {
            int i12 = this.aRM;
            if (i12 > i10 && i12 > NH()) {
                en(i10);
                return;
            }
            int E = E(length, i11);
            byte[] bArr = new byte[E];
            System.arraycopy((Object) this.aRC.aRo, 0, (Object) bArr, 0, this.aRD);
            this.aRC.aRo = bArr;
            if (this.aRO == 0) {
                try {
                    long j10 = E;
                    MappedByteBuffer map = this.aRw.map(FileChannel.MapMode.READ_WRITE, 0L, j10);
                    this.aRA = map;
                    ByteOrder byteOrder = ByteOrder.LITTLE_ENDIAN;
                    map.order(byteOrder);
                    MappedByteBuffer map2 = this.aRx.map(FileChannel.MapMode.READ_WRITE, 0L, j10);
                    this.aRB = map2;
                    map2.order(byteOrder);
                } catch (Throwable th) {
                    u(new Exception("map failed", th));
                    this.aRC.B(0, this.aRD - 12);
                    this.aRC.f(4, this.aRE);
                    ND();
                }
            }
        }
    }

    private void en(int i10) {
        int i11;
        ArrayList<e> arrayList = this.aRN;
        if (arrayList == null || this.aRC == null) {
            return;
        }
        Collections.sort(arrayList);
        NK();
        e eVar = this.aRN.get(0);
        int i12 = eVar.start;
        int i13 = this.aRD;
        int i14 = i13 - this.aRM;
        int i15 = i14 - 12;
        int i16 = i14 - i12;
        int i17 = i13 - i12;
        boolean z10 = i15 < i17 + i16;
        if (!z10) {
            this.aRE ^= this.aRC.D(i12, i17);
        }
        int size = this.aRN.size();
        int i18 = size - 1;
        int i19 = this.aRD - this.aRN.get(i18).end;
        int[] iArr = new int[(i19 > 0 ? size : i18) << 1];
        int i20 = eVar.start;
        int i21 = eVar.end;
        for (int i22 = 1; i22 < size; i22++) {
            e eVar2 = this.aRN.get(i22);
            int i23 = eVar2.start - i21;
            byte[] bArr = this.aRC.aRo;
            System.arraycopy((Object) bArr, i21, (Object) bArr, i20, i23);
            int i24 = (i22 - 1) << 1;
            iArr[i24] = i21;
            iArr[i24 + 1] = i21 - i20;
            i20 += i23;
            i21 = eVar2.end;
        }
        if (i19 > 0) {
            byte[] bArr2 = this.aRC.aRo;
            System.arraycopy((Object) bArr2, i21, (Object) bArr2, i20, i19);
            int i25 = i18 << 1;
            iArr[i25] = i21;
            iArr[i25 + 1] = i21 - i20;
        }
        NL();
        if (z10) {
            this.aRE = this.aRC.D(12, i15);
        } else {
            this.aRE ^= this.aRC.D(i12, i16);
        }
        this.aRD = i14;
        if (this.aRO == 0) {
            MappedByteBuffer mappedByteBuffer = this.aRA;
            if (mappedByteBuffer != null) {
                i11 = 0;
                mappedByteBuffer.putInt(0, -1);
                this.aRA.putLong(4, this.aRE);
                this.aRA.position(i12);
                this.aRA.put(this.aRC.aRo, i12, i16);
                this.aRA.putInt(0, i15);
            } else {
                i11 = 0;
            }
            MappedByteBuffer mappedByteBuffer2 = this.aRB;
            if (mappedByteBuffer2 != null) {
                mappedByteBuffer2.putInt(i11, i15);
                this.aRB.putLong(4, this.aRE);
                this.aRB.position(i12);
                this.aRB.put(this.aRC.aRo, i12, i16);
            }
        } else {
            this.aRC.B(0, i15);
            this.aRC.f(4, this.aRE);
        }
        a(i12, iArr);
        int i26 = i14 + i10;
        if (this.aRC.aRo.length - i26 > aRt) {
            eo(i26);
        }
        info("gc finish");
    }

    private void eo(int i10) {
        int i11 = PAGE_SIZE;
        int E = E(i11, i10 + i11);
        com.kwad.sdk.utils.a.b bVar = this.aRC;
        if (bVar != null) {
            byte[] bArr = bVar.aRo;
            if (E >= bArr.length) {
                return;
            }
            byte[] bArr2 = new byte[E];
            System.arraycopy((Object) bArr, 0, (Object) bArr2, 0, this.aRD);
            this.aRC.aRo = bArr2;
        }
        if (this.aRO == 0) {
            try {
                long j10 = E;
                this.aRw.truncate(j10);
                MappedByteBuffer map = this.aRw.map(FileChannel.MapMode.READ_WRITE, 0L, j10);
                this.aRA = map;
                ByteOrder byteOrder = ByteOrder.LITTLE_ENDIAN;
                map.order(byteOrder);
                this.aRx.truncate(j10);
                MappedByteBuffer map2 = this.aRx.map(FileChannel.MapMode.READ_WRITE, 0L, j10);
                this.aRB = map2;
                map2.order(byteOrder);
            } catch (Throwable th) {
                u(new Exception("map failed", th));
                ND();
            }
        }
        info("truncate finish");
    }

    private void g(Exception exc) {
        d dVar = this.aRv;
        if (dVar != null) {
            dVar.a(this.name, exc);
        }
    }

    private void h(File file, File file2) {
        try {
            if (ad(file)) {
                return;
            }
        } catch (IOException e2) {
            g(e2);
        }
        NF();
        try {
            if (ad(file2)) {
                return;
            }
        } catch (Exception e10) {
            g(e10);
        }
        NF();
    }

    private static void hh(String str) {
        if (str == null || str.isEmpty()) {
            throw new IllegalArgumentException("key is empty");
        }
    }

    private void hi(String str) {
        d dVar = this.aRv;
        if (dVar != null) {
            dVar.e(this.name, new Exception(str));
        }
    }

    private void info(String str) {
        d dVar = this.aRv;
        if (dVar != null) {
            dVar.i(this.name, str);
        }
    }

    private synchronized void putDouble(String str, double d10) {
        hh(str);
        a.d dVar = (a.d) this.aRF.get(str);
        if (dVar != null) {
            if (dVar.value != d10) {
                long doubleToRawLongBits = Double.doubleToRawLongBits(d10);
                long doubleToRawLongBits2 = Double.doubleToRawLongBits(dVar.value) ^ doubleToRawLongBits;
                dVar.value = d10;
                b(doubleToRawLongBits, doubleToRawLongBits2, dVar.offset);
                Nz();
            }
            return;
        }
        a(str, (byte) 5);
        com.kwad.sdk.utils.a.b bVar = this.aRC;
        if (bVar != null) {
            int i10 = bVar.position;
            bVar.aH(Double.doubleToRawLongBits(d10));
            NG();
            Map<String, a.b> map = this.aRF;
            if (map != null) {
                map.put(str, new a.d(i10, d10));
            }
        }
        Nz();
    }

    private synchronized void putFloat(String str, float f10) {
        hh(str);
        a.e eVar = (a.e) this.aRF.get(str);
        if (eVar != null) {
            if (eVar.value != f10) {
                eVar.value = f10;
                a(Float.floatToRawIntBits(f10), (Float.floatToRawIntBits(eVar.value) ^ r6) & 4294967295L, eVar.offset);
                Nz();
            }
            return;
        }
        a(str, (byte) 3);
        com.kwad.sdk.utils.a.b bVar = this.aRC;
        if (bVar != null) {
            int i10 = bVar.position;
            bVar.ee(Float.floatToRawIntBits(f10));
            NG();
            Map<String, a.b> map = this.aRF;
            if (map != null) {
                map.put(str, new a.e(i10, f10));
            }
        }
        Nz();
    }

    private synchronized void putStringSet(String str, Set<String> set) {
        if (set == null) {
            remove(str);
        } else {
            a(str, (String) set, (b<String>) g.aSg);
        }
    }

    private void u(String str, int i10) {
        com.kwad.sdk.utils.a.b bVar = this.aRC;
        if (bVar == null) {
            return;
        }
        bVar.e((byte) i10);
        if (i10 == str.length()) {
            com.kwad.sdk.utils.a.b bVar2 = this.aRC;
            a(str, 0, i10, bVar2.aRo, bVar2.position);
            this.aRC.position += i10;
            return;
        }
        this.aRC.hd(str);
    }

    private void updateBytes(int i10, byte[] bArr) {
        int length = bArr.length;
        com.kwad.sdk.utils.a.b bVar = this.aRC;
        if (bVar != null) {
            this.aRE ^= bVar.D(i10, length);
            com.kwad.sdk.utils.a.b bVar2 = this.aRC;
            bVar2.position = i10;
            bVar2.n(bArr);
            this.aRE ^= this.aRC.D(i10, length);
        }
        if (this.aRO == 0) {
            MappedByteBuffer mappedByteBuffer = this.aRA;
            if (mappedByteBuffer != null) {
                mappedByteBuffer.putInt(0, -1);
                this.aRA.putLong(4, this.aRE);
                this.aRA.position(i10);
                this.aRA.put(bArr);
                this.aRA.putInt(0, this.aRD - 12);
            }
            MappedByteBuffer mappedByteBuffer2 = this.aRB;
            if (mappedByteBuffer2 != null) {
                mappedByteBuffer2.putLong(4, this.aRE);
                this.aRB.position(i10);
                this.aRB.put(bArr);
                return;
            }
            return;
        }
        com.kwad.sdk.utils.a.b bVar3 = this.aRC;
        if (bVar3 != null) {
            bVar3.f(4, this.aRE);
        }
    }

    private void v(String str, int i10) {
        com.kwad.sdk.utils.a.b bVar = this.aRC;
        if (bVar == null) {
            return;
        }
        bVar.a((short) i10);
        if (i10 == str.length()) {
            com.kwad.sdk.utils.a.b bVar2 = this.aRC;
            a(str, 0, i10, bVar2.aRo, bVar2.position);
        } else {
            this.aRC.hd(str);
        }
    }

    public final synchronized boolean contains(String str) {
        return this.aRF.containsKey(str);
    }

    public final synchronized Map<String, Object> getAll() {
        Object valueOf;
        int size = this.aRF.size();
        if (size == 0) {
            return new HashMap();
        }
        HashMap hashMap = new HashMap(((size * 4) / 3) + 1);
        for (Map.Entry<String, a.b> entry : this.aRF.entrySet()) {
            String key = entry.getKey();
            a.b value = entry.getValue();
            Object obj = null;
            switch (value.Ns()) {
                case 1:
                    valueOf = Boolean.valueOf(((a.c) value).value);
                    break;
                case 2:
                    valueOf = Integer.valueOf(((a.f) value).value);
                    break;
                case 3:
                    valueOf = Float.valueOf(((a.e) value).value);
                    break;
                case 4:
                    valueOf = Long.valueOf(((a.g) value).value);
                    break;
                case 5:
                    valueOf = Double.valueOf(((a.d) value).value);
                    break;
                case 6:
                    a.i iVar = (a.i) value;
                    if (iVar.aRm) {
                        valueOf = a(iVar);
                        break;
                    } else {
                        valueOf = iVar.value;
                        break;
                    }
                case 7:
                    a.C0546a c0546a = (a.C0546a) value;
                    if (c0546a.aRm) {
                        valueOf = a(c0546a);
                        break;
                    } else {
                        valueOf = c0546a.value;
                        break;
                    }
                case 8:
                    a.h hVar = (a.h) value;
                    if (hVar.aRm) {
                        valueOf = a(hVar);
                        break;
                    } else {
                        valueOf = ((a.h) value).value;
                        break;
                    }
                default:
                    continue;
            }
            obj = valueOf;
            hashMap.put(key, obj);
        }
        return hashMap;
    }

    public final synchronized boolean getBoolean(String str, boolean z10) {
        a.c cVar = (a.c) this.aRF.get(str);
        if (cVar == null) {
            return z10;
        }
        return cVar.value;
    }

    public final synchronized int getInt(String str, int i10) {
        a.f fVar = (a.f) this.aRF.get(str);
        if (fVar == null) {
            return i10;
        }
        return fVar.value;
    }

    public final synchronized long getLong(String str, long j10) {
        a.g gVar = (a.g) this.aRF.get(str);
        if (gVar == null) {
            return j10;
        }
        return gVar.value;
    }

    public final synchronized String getString(String str, String str2) {
        a.i iVar = (a.i) this.aRF.get(str);
        if (iVar == null) {
            return str2;
        }
        if (iVar.aRm) {
            return a(iVar);
        }
        return (String) iVar.value;
    }

    public final void putAll(Map<String, Object> map) {
        a(map, (Map<Class, b>) null);
    }

    public final synchronized void putBoolean(String str, boolean z10) {
        hh(str);
        a.c cVar = (a.c) this.aRF.get(str);
        if (cVar == null) {
            a(str, (byte) 1);
            com.kwad.sdk.utils.a.b bVar = this.aRC;
            if (bVar != null) {
                int i10 = bVar.position;
                bVar.e((byte) (z10 ? 1 : 0));
                NG();
                Map<String, a.b> map = this.aRF;
                if (map != null) {
                    map.put(str, new a.c(i10, z10));
                }
            }
            Nz();
            return;
        }
        if (cVar.value != z10) {
            cVar.value = z10;
            a((byte) (z10 ? 1 : 0), cVar.offset);
            Nz();
        }
    }

    public final synchronized void putInt(String str, int i10) {
        hh(str);
        a.f fVar = (a.f) this.aRF.get(str);
        if (fVar == null) {
            a(str, (byte) 2);
            com.kwad.sdk.utils.a.b bVar = this.aRC;
            if (bVar != null) {
                int i11 = bVar.position;
                bVar.ee(i10);
                NG();
                Map<String, a.b> map = this.aRF;
                if (map != null) {
                    map.put(str, new a.f(i11, i10));
                }
            }
            Nz();
            return;
        }
        if (fVar.value != i10) {
            fVar.value = i10;
            a(i10, (r6 ^ i10) & 4294967295L, fVar.offset);
            Nz();
        }
    }

    public final synchronized void putLong(String str, long j10) {
        hh(str);
        a.g gVar = (a.g) this.aRF.get(str);
        if (gVar == null) {
            a(str, (byte) 4);
            com.kwad.sdk.utils.a.b bVar = this.aRC;
            if (bVar != null) {
                int i10 = bVar.position;
                bVar.aH(j10);
                NG();
                Map<String, a.b> map = this.aRF;
                if (map != null) {
                    map.put(str, new a.g(i10, j10));
                }
            }
            Nz();
            return;
        }
        long j11 = gVar.value;
        if (j11 != j10) {
            gVar.value = j10;
            b(j10, j10 ^ j11, gVar.offset);
            Nz();
        }
    }

    public final synchronized void putString(String str, String str2) {
        byte[] hg;
        byte[] bArr;
        byte[] bArr2;
        hh(str);
        if (str2 == null) {
            remove(str);
            return;
        }
        a.i iVar = (a.i) this.aRF.get(str);
        if (str2.length() * 3 < 2048) {
            a(str, str2, iVar);
            return;
        }
        if (str2.isEmpty()) {
            hg = aRq;
        } else {
            if (iVar == null && str2.length() < 2048) {
                int he2 = com.kwad.sdk.utils.a.b.he(str2);
                bArr = new byte[he2];
                if (he2 == str2.length()) {
                    a(str2, 0, he2, bArr, 0);
                    bArr2 = bArr;
                } else {
                    hg = com.kwad.sdk.utils.a.b.hg(str2);
                }
            } else if (iVar != null && !iVar.aRm) {
                int he3 = com.kwad.sdk.utils.a.b.he(str2);
                bArr = new byte[he3];
                if (he3 == str2.length()) {
                    a(str2, 0, he3, bArr, 0);
                    bArr2 = bArr;
                } else {
                    hg = com.kwad.sdk.utils.a.b.hg(str2);
                }
            } else {
                hg = com.kwad.sdk.utils.a.b.hg(str2);
            }
            a(str, str2, bArr2, iVar, (byte) 6);
        }
        bArr2 = hg;
        a(str, str2, bArr2, iVar, (byte) 6);
    }

    public final void release() {
        h.closeQuietly(this.aRy);
        h.closeQuietly(this.aRz);
        h.closeQuietly(this.aRw);
        h.closeQuietly(this.aRx);
        this.aRw = null;
        this.aRx = null;
        this.aRA = null;
        this.aRB = null;
        String str = this.VM + this.name;
        C0547c c0547c = a.aRT;
        C0547c.remove(str);
    }

    public final synchronized void remove(String str) {
        a.b bVar = this.aRF.get(str);
        if (bVar != null) {
            this.aRF.remove(str);
            byte Ns = bVar.Ns();
            String str2 = null;
            if (Ns <= 5) {
                int he2 = com.kwad.sdk.utils.a.b.he(str);
                int i10 = bVar.offset;
                a(Ns, i10 - (he2 + 2), i10 + aRp[Ns]);
            } else {
                a.j jVar = (a.j) bVar;
                a(Ns, jVar.start, jVar.offset + jVar.aRl);
                if (jVar.aRm) {
                    str2 = (String) jVar.value;
                }
            }
            byte b4 = (byte) (Ns | Byte.MIN_VALUE);
            if (this.aRO == 0) {
                MappedByteBuffer mappedByteBuffer = this.aRA;
                if (mappedByteBuffer != null) {
                    mappedByteBuffer.putLong(4, this.aRE);
                    this.aRA.put(this.aRJ, b4);
                }
                MappedByteBuffer mappedByteBuffer2 = this.aRB;
                if (mappedByteBuffer2 != null) {
                    mappedByteBuffer2.putLong(4, this.aRE);
                    this.aRB.put(this.aRJ, b4);
                }
            } else {
                com.kwad.sdk.utils.a.b bVar2 = this.aRC;
                if (bVar2 != null) {
                    bVar2.f(4, this.aRE);
                }
            }
            this.aRJ = 0;
            if (str2 != null) {
                h.h(new File(this.VM + this.name, str2));
            }
            NJ();
            Nz();
        }
    }

    public final synchronized String toString() {
        return "FastKV: path:" + this.VM + " name:" + this.name;
    }

    private boolean a(com.kwad.sdk.utils.a.b bVar) {
        int length = bVar.aRo.length;
        File file = new File(this.VM, this.name + ".kva");
        File file2 = new File(this.VM, this.name + ".kvb");
        try {
            if (h.ae(file) && h.ae(file2)) {
                RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
                RandomAccessFile randomAccessFile2 = new RandomAccessFile(file2, "rw");
                long j10 = length;
                randomAccessFile.setLength(j10);
                randomAccessFile2.setLength(j10);
                this.aRw = randomAccessFile.getChannel();
                this.aRx = randomAccessFile2.getChannel();
                MappedByteBuffer map = this.aRw.map(FileChannel.MapMode.READ_WRITE, 0L, j10);
                this.aRA = map;
                ByteOrder byteOrder = ByteOrder.LITTLE_ENDIAN;
                map.order(byteOrder);
                MappedByteBuffer map2 = this.aRx.map(FileChannel.MapMode.READ_WRITE, 0L, j10);
                this.aRB = map2;
                map2.order(byteOrder);
                this.aRA.put(bVar.aRo, 0, this.aRD);
                this.aRB.put(bVar.aRo, 0, this.aRD);
                return true;
            }
            throw new Exception("open file failed");
        } catch (Exception e2) {
            u(e2);
            return false;
        }
    }

    private synchronized void b(String str, byte[] bArr) {
        hh(str);
        if (bArr == null) {
            remove(str);
        } else {
            a(str, bArr, bArr, (a.C0546a) this.aRF.get(str), (byte) 7);
        }
    }

    private void b(MappedByteBuffer mappedByteBuffer) {
        if (mappedByteBuffer == null) {
            return;
        }
        if (this.aRK && mappedByteBuffer != this.aRA) {
            mappedByteBuffer.putInt(0, this.aRD - 12);
        }
        mappedByteBuffer.putLong(4, this.aRE);
        int i10 = this.aRJ;
        if (i10 != 0) {
            mappedByteBuffer.put(i10, this.aRC.aRo[i10]);
        }
        if (this.aRI != 0) {
            mappedByteBuffer.position(this.aRH);
            mappedByteBuffer.put(this.aRC.aRo, this.aRH, this.aRI);
        }
    }

    private void u(Throwable th) {
        d dVar = this.aRv;
        if (dVar != null) {
            dVar.e(this.name, th);
        }
    }

    private void b(long j10, long j11, int i10) {
        long e2 = e(j11, i10) ^ this.aRE;
        this.aRE = e2;
        if (this.aRO == 0) {
            MappedByteBuffer mappedByteBuffer = this.aRA;
            if (mappedByteBuffer != null) {
                mappedByteBuffer.putLong(4, e2);
                this.aRA.putLong(i10, j10);
            }
            MappedByteBuffer mappedByteBuffer2 = this.aRB;
            if (mappedByteBuffer2 != null) {
                mappedByteBuffer2.putLong(4, this.aRE);
                this.aRB.putLong(i10, j10);
            }
        } else {
            com.kwad.sdk.utils.a.b bVar = this.aRC;
            if (bVar != null) {
                bVar.f(4, e2);
            }
        }
        com.kwad.sdk.utils.a.b bVar2 = this.aRC;
        if (bVar2 != null) {
            bVar2.f(i10, j10);
        }
    }

    private void a(MappedByteBuffer mappedByteBuffer, MappedByteBuffer mappedByteBuffer2, int i10) {
        if (mappedByteBuffer.capacity() != mappedByteBuffer2.capacity()) {
            try {
                MappedByteBuffer map = (mappedByteBuffer2 == this.aRB ? this.aRx : this.aRw).map(FileChannel.MapMode.READ_WRITE, 0L, mappedByteBuffer.capacity());
                map.order(ByteOrder.LITTLE_ENDIAN);
                if (mappedByteBuffer2 == this.aRB) {
                    this.aRB = map;
                } else {
                    this.aRA = map;
                }
                mappedByteBuffer2 = map;
            } catch (Exception e2) {
                u(e2);
                ND();
                return;
            }
        }
        mappedByteBuffer.rewind();
        mappedByteBuffer2.rewind();
        mappedByteBuffer.limit(i10);
        mappedByteBuffer2.put(mappedByteBuffer);
        mappedByteBuffer.limit(mappedByteBuffer.capacity());
    }

    private int b(String str, byte[] bArr, byte b4) {
        a(str, b4, bArr.length + 2);
        com.kwad.sdk.utils.a.b bVar = this.aRC;
        if (bVar == null) {
            return 0;
        }
        bVar.a((short) bArr.length);
        com.kwad.sdk.utils.a.b bVar2 = this.aRC;
        int i10 = bVar2.position;
        bVar2.n(bArr);
        return i10;
    }

    private String a(a.i iVar) {
        byte[] bytes;
        try {
            byte[] af = h.af(new File(this.VM + this.name, (String) iVar.value));
            String str = new String(af);
            return (af == null || TextUtils.isEmpty(str) || (bytes = com.kwad.sdk.utils.a.b.j(af, com.kwad.sdk.utils.a.b.he(str)).getBytes()) == null || bytes.length == 0) ? "" : new String(bytes, com.kwad.sdk.utils.a.b.UTF_8);
        } catch (Exception e2) {
            u(e2);
        }
        return "";
    }

    private byte[] a(a.C0546a c0546a) {
        try {
            byte[] af = h.af(new File(this.VM + this.name, (String) c0546a.value));
            return af != null ? af : aRq;
        } catch (Exception e2) {
            u(e2);
            return aRq;
        }
    }

    private Object a(a.h hVar) {
        try {
            byte[] af = h.af(new File(this.VM + this.name, (String) hVar.value));
            if (af != null) {
                int i10 = af[0] & 255;
                String str = new String(af, 1, i10, com.kwad.sdk.utils.a.b.UTF_8);
                b bVar = this.aRu.get(str);
                if (bVar != null) {
                    int i11 = i10 + 1;
                    return bVar.g(af, i11, af.length - i11);
                }
                g(new Exception("No encoder for tag:" + str));
                return null;
            }
            g(new Exception("Read object data failed"));
            return null;
        } catch (Exception e2) {
            u(e2);
            return null;
        }
    }

    private synchronized <T> void a(String str, T t2, b<T> bVar) {
        hh(str);
        if (bVar == null) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Encoder is null");
            if (!com.kwad.library.a.a.f36641md.booleanValue()) {
                u(illegalArgumentException);
                return;
            }
            throw illegalArgumentException;
        }
        String NN = bVar.NN();
        if (!NN.isEmpty() && NN.length() <= 50) {
            if (!this.aRu.containsKey(NN)) {
                IllegalArgumentException illegalArgumentException2 = new IllegalArgumentException("Encoder hasn't been registered");
                if (!com.kwad.library.a.a.f36641md.booleanValue()) {
                    u(illegalArgumentException2);
                    return;
                }
                throw illegalArgumentException2;
            }
            if (t2 == null) {
                remove(str);
                return;
            }
            byte[] bArr = null;
            try {
                bArr = bVar.m(t2);
            } catch (Exception e2) {
                u(e2);
            }
            if (bArr == null) {
                remove(str);
                return;
            }
            int he2 = com.kwad.sdk.utils.a.b.he(NN);
            com.kwad.sdk.utils.a.b bVar2 = new com.kwad.sdk.utils.a.b(he2 + 1 + bArr.length);
            bVar2.e((byte) he2);
            bVar2.hd(NN);
            bVar2.n(bArr);
            a(str, t2, bVar2.aRo, (a.h) this.aRF.get(str), (byte) 8);
            return;
        }
        IllegalArgumentException illegalArgumentException3 = new IllegalArgumentException("Invalid encoder tag:" + NN);
        if (!com.kwad.library.a.a.f36641md.booleanValue()) {
            u(illegalArgumentException3);
            return;
        }
        throw illegalArgumentException3;
    }

    private synchronized void a(Map<String, Object> map, Map<Class, b> map2) {
        if (map == null) {
            return;
        }
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();
            if (key != null && !key.isEmpty()) {
                if (value instanceof String) {
                    putString(key, (String) value);
                } else if (value instanceof Boolean) {
                    putBoolean(key, ((Boolean) value).booleanValue());
                } else if (value instanceof Integer) {
                    putInt(key, ((Integer) value).intValue());
                } else if (value instanceof Long) {
                    putLong(key, ((Long) value).longValue());
                } else if (value instanceof Float) {
                    putFloat(key, ((Float) value).floatValue());
                } else if (value instanceof Double) {
                    putDouble(key, ((Double) value).doubleValue());
                } else if (value instanceof Set) {
                    Set set = (Set) value;
                    if (!set.isEmpty() && (set.iterator2().next() instanceof String)) {
                        putStringSet(key, (Set) value);
                    }
                } else if (value instanceof byte[]) {
                    b(key, (byte[]) value);
                } else {
                    g(new Exception("missing encoders"));
                }
            }
        }
    }

    private void a(MappedByteBuffer mappedByteBuffer) {
        if (mappedByteBuffer == null) {
            return;
        }
        int capacity = mappedByteBuffer.capacity();
        int i10 = PAGE_SIZE;
        if (capacity != i10) {
            FileChannel fileChannel = mappedByteBuffer == this.aRA ? this.aRw : this.aRx;
            if (fileChannel == null) {
                return;
            }
            fileChannel.truncate(i10);
            MappedByteBuffer map = fileChannel.map(FileChannel.MapMode.READ_WRITE, 0L, i10);
            map.order(ByteOrder.LITTLE_ENDIAN);
            if (mappedByteBuffer == this.aRA) {
                this.aRA = map;
            } else {
                this.aRB = map;
            }
            mappedByteBuffer = map;
        }
        mappedByteBuffer.putInt(0, 0);
        mappedByteBuffer.putLong(4, 0L);
    }

    private void a(String str, byte b4) {
        a(str, b4, aRp[b4]);
    }

    private void a(String str, byte b4, int i10) {
        int he2 = com.kwad.sdk.utils.a.b.he(str);
        el(he2);
        this.aRI = he2 + 2 + i10;
        NI();
        com.kwad.sdk.utils.a.b bVar = this.aRC;
        if (bVar != null) {
            bVar.e(b4);
        }
        u(str, he2);
    }

    private void a(byte b4, int i10) {
        long e2 = this.aRE ^ e(1L, i10);
        this.aRE = e2;
        if (this.aRO == 0) {
            MappedByteBuffer mappedByteBuffer = this.aRA;
            if (mappedByteBuffer != null) {
                mappedByteBuffer.putLong(4, e2);
                this.aRA.put(i10, b4);
            }
            MappedByteBuffer mappedByteBuffer2 = this.aRB;
            if (mappedByteBuffer2 != null) {
                mappedByteBuffer2.putLong(4, this.aRE);
                this.aRB.put(i10, b4);
            }
        } else {
            com.kwad.sdk.utils.a.b bVar = this.aRC;
            if (bVar != null) {
                bVar.f(4, e2);
            }
        }
        com.kwad.sdk.utils.a.b bVar2 = this.aRC;
        if (bVar2 != null) {
            bVar2.aRo[i10] = b4;
        }
    }

    private void a(int i10, long j10, int i11) {
        long e2 = e(j10, i11) ^ this.aRE;
        this.aRE = e2;
        if (this.aRO == 0) {
            MappedByteBuffer mappedByteBuffer = this.aRA;
            if (mappedByteBuffer != null) {
                mappedByteBuffer.putLong(4, e2);
                this.aRA.putInt(i11, i10);
            }
            MappedByteBuffer mappedByteBuffer2 = this.aRB;
            if (mappedByteBuffer2 != null) {
                mappedByteBuffer2.putLong(4, this.aRE);
                this.aRB.putInt(i11, i10);
            }
        } else {
            com.kwad.sdk.utils.a.b bVar = this.aRC;
            if (bVar != null) {
                bVar.f(4, e2);
            }
        }
        com.kwad.sdk.utils.a.b bVar2 = this.aRC;
        if (bVar2 != null) {
            bVar2.B(i11, i10);
        }
    }

    private static void a(String str, int i10, int i11, byte[] bArr, int i12) {
        int i13;
        if (i11 <= str.length() && i11 >= 0) {
            int i14 = 0;
            while (i14 < i11) {
                int i15 = i14 + 1;
                char charAt = str.charAt(i14);
                if (charAt < 128) {
                    i13 = i12 + 1;
                    bArr[i12] = (byte) (((byte) charAt) ^ 1);
                } else {
                    i13 = i12 + 1;
                    bArr[i12] = (byte) charAt;
                }
                i14 = i15;
                i12 = i13;
            }
        }
    }

    private void a(String str, String str2, a.i iVar) {
        int he2 = com.kwad.sdk.utils.a.b.he(str2);
        if (iVar == null) {
            int he3 = com.kwad.sdk.utils.a.b.he(str);
            el(he3);
            int i10 = he3 + 4;
            this.aRI = i10 + he2;
            NI();
            com.kwad.sdk.utils.a.b bVar = this.aRC;
            if (bVar != null) {
                bVar.e((byte) 6);
            }
            u(str, he3);
            v(str2, he2);
            Map<String, a.b> map = this.aRF;
            int i11 = this.aRH;
            map.put(str, new a.i(i11, i11 + i10, str2, he2, false));
            NG();
        } else {
            int i12 = iVar.offset;
            int i13 = i12 - iVar.start;
            int i14 = iVar.aRl;
            boolean z10 = true;
            if (i14 == he2) {
                this.aRE = this.aRC.D(i12, i14) ^ this.aRE;
                if (he2 == str2.length()) {
                    a(str2, 0, he2, this.aRC.aRo, iVar.offset);
                } else {
                    com.kwad.sdk.utils.a.b bVar2 = this.aRC;
                    if (bVar2 != null) {
                        bVar2.position = iVar.offset;
                        bVar2.hd(str2);
                    }
                }
                this.aRH = iVar.offset;
                this.aRI = he2;
                z10 = false;
            } else {
                this.aRI = i13 + he2;
                NI();
                com.kwad.sdk.utils.a.b bVar3 = this.aRC;
                if (bVar3 != null) {
                    bVar3.e((byte) 6);
                }
                int i15 = i13 - 3;
                com.kwad.sdk.utils.a.b bVar4 = this.aRC;
                if (bVar4 != null) {
                    byte[] bArr = bVar4.aRo;
                    System.arraycopy((Object) bArr, iVar.start + 1, (Object) bArr, bVar4.position, i15);
                }
                com.kwad.sdk.utils.a.b bVar5 = this.aRC;
                if (bVar5 != null) {
                    bVar5.position += i15;
                }
                v(str2, he2);
                a((byte) 6, iVar.start, iVar.offset + iVar.aRl);
                r10 = iVar.aRm ? (String) iVar.value : null;
                iVar.aRm = false;
                int i16 = this.aRH;
                iVar.start = i16;
                iVar.offset = i16 + i13;
                iVar.aRl = he2;
            }
            iVar.value = str2;
            NG();
            if (z10) {
                NJ();
            }
            if (r10 != null) {
                h.h(new File(this.VM + this.name, r10));
            }
        }
        Nz();
    }

    private void a(String str, Object obj, byte[] bArr, a.j jVar, byte b4) {
        if (jVar == null) {
            a(str, obj, bArr, b4);
        } else if (!jVar.aRm && jVar.aRl == bArr.length) {
            updateBytes(jVar.offset, bArr);
            jVar.value = obj;
        } else {
            a(str, obj, bArr, jVar);
        }
        Nz();
    }

    private void a(String str, Object obj, byte[] bArr, byte b4) {
        Object obj2;
        int length;
        a.b hVar;
        int a10 = a(str, bArr, b4);
        if (a10 != 0) {
            String str2 = this.aRL;
            boolean z10 = str2 != null;
            if (z10) {
                this.aRL = null;
                obj2 = str2;
                length = 32;
            } else {
                obj2 = obj;
                length = bArr.length;
            }
            if (b4 == 6) {
                hVar = new a.i(this.aRH, a10, (String) obj2, length, z10);
            } else if (b4 == 7) {
                hVar = new a.C0546a(this.aRH, a10, obj2, length, z10);
            } else {
                hVar = new a.h(this.aRH, a10, obj2, length, z10);
            }
            this.aRF.put(str, hVar);
            NG();
        }
    }

    private void a(String str, Object obj, byte[] bArr, @NonNull a.j jVar) {
        int a10 = a(str, bArr, jVar.Ns());
        if (a10 != 0) {
            String str2 = jVar.aRm ? (String) jVar.value : null;
            a(jVar.Ns(), jVar.start, jVar.offset + jVar.aRl);
            String str3 = this.aRL;
            boolean z10 = str3 != null;
            jVar.start = this.aRH;
            jVar.offset = a10;
            jVar.aRm = z10;
            if (z10) {
                jVar.value = str3;
                jVar.aRl = 32;
                this.aRL = null;
            } else {
                jVar.value = obj;
                jVar.aRl = bArr.length;
            }
            NG();
            NJ();
            if (str2 != null) {
                h.h(new File(this.VM + this.name, str2));
            }
        }
    }

    private int a(String str, byte[] bArr, byte b4) {
        this.aRL = null;
        if (bArr.length < 2048) {
            return b(str, bArr, b4);
        }
        info("large value, key: " + str + ", size: " + bArr.length);
        String NP = h.NP();
        if (h.a(new File(this.VM + this.name, NP), bArr)) {
            this.aRL = NP;
            byte[] bArr2 = new byte[32];
            NP.getBytes(0, 32, bArr2, 0);
            return b(str, bArr2, (byte) (b4 | DerValue.TAG_APPLICATION));
        }
        hi("save large value failed");
        return 0;
    }

    private void a(byte b4, int i10, int i11) {
        byte[] bArr;
        F(i10, i11);
        byte b10 = (byte) (b4 | Byte.MIN_VALUE);
        com.kwad.sdk.utils.a.b bVar = this.aRC;
        if (bVar != null && (bArr = bVar.aRo) != null) {
            this.aRE = (((bArr[i10] ^ b10) & 255) << ((i10 & 7) << 3)) ^ this.aRE;
            bArr[i10] = b10;
        }
        this.aRJ = i10;
    }

    private void a(int i10, int[] iArr) {
        Map<String, a.b> map = this.aRF;
        if (map == null) {
            return;
        }
        for (a.b bVar : map.values()) {
            int i11 = bVar.offset;
            if (i11 > i10) {
                int i12 = iArr[(h.binarySearch(iArr, i11) << 1) + 1];
                bVar.offset -= i12;
                if (bVar.Ns() >= 6) {
                    ((a.j) bVar).start -= i12;
                }
            }
        }
    }
}
