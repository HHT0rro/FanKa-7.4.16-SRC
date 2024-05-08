package com.tencent.cloud.huiyansdkface.okhttp3.internal.http2;

import com.tencent.cloud.huiyansdkface.okio.BufferedSink;
import com.tencent.cloud.huiyansdkface.okio.ByteString;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
class Huffman {

    /* renamed from: a, reason: collision with root package name */
    private static final int[] f41975a = {8184, 8388568, 268435426, 268435427, 268435428, 268435429, 268435430, 268435431, 268435432, 16777194, 1073741820, 268435433, 268435434, 1073741821, 268435435, 268435436, 268435437, 268435438, 268435439, 268435440, 268435441, 268435442, 1073741822, 268435443, 268435444, 268435445, 268435446, 268435447, 268435448, 268435449, 268435450, 268435451, 20, 1016, 1017, 4090, 8185, 21, 248, 2042, 1018, 1019, 249, 2043, 250, 22, 23, 24, 0, 1, 2, 25, 26, 27, 28, 29, 30, 31, 92, 251, 32764, 32, 4091, 1020, 8186, 33, 93, 94, 95, 96, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 252, 115, 253, 8187, 524272, 8188, 16380, 34, 32765, 3, 35, 4, 36, 5, 37, 38, 39, 6, 116, 117, 40, 41, 42, 7, 43, 118, 44, 8, 9, 45, 119, 120, 121, 122, 123, 32766, 2044, 16381, 8189, 268435452, 1048550, 4194258, 1048551, 1048552, 4194259, 4194260, 4194261, 8388569, 4194262, 8388570, 8388571, 8388572, 8388573, 8388574, 16777195, 8388575, 16777196, 16777197, 4194263, 8388576, 16777198, 8388577, 8388578, 8388579, 8388580, 2097116, 4194264, 8388581, 4194265, 8388582, 8388583, 16777199, 4194266, 2097117, 1048553, 4194267, 4194268, 8388584, 8388585, 2097118, 8388586, 4194269, 4194270, 16777200, 2097119, 4194271, 8388587, 8388588, 2097120, 2097121, 4194272, 2097122, 8388589, 4194273, 8388590, 8388591, 1048554, 4194274, 4194275, 4194276, 8388592, 4194277, 4194278, 8388593, 67108832, 67108833, 1048555, 524273, 4194279, 8388594, 4194280, 33554412, 67108834, 67108835, 67108836, 134217694, 134217695, 67108837, 16777201, 33554413, 524274, 2097123, 67108838, 134217696, 134217697, 67108839, 134217698, 16777202, 2097124, 2097125, 67108840, 67108841, 268435453, 134217699, 134217700, 134217701, 1048556, 16777203, 1048557, 2097126, 4194281, 2097127, 2097128, 8388595, 4194282, 4194283, 33554414, 33554415, 16777204, 16777205, 67108842, 8388596, 67108843, 134217702, 67108844, 67108845, 134217703, 134217704, 134217705, 134217706, 134217707, 268435454, 134217708, 134217709, 134217710, 134217711, 134217712, 67108846};

    /* renamed from: b, reason: collision with root package name */
    private static final byte[] f41976b = {13, 23, 28, 28, 28, 28, 28, 28, 28, 24, 30, 28, 28, 30, 28, 28, 28, 28, 28, 28, 28, 28, 30, 28, 28, 28, 28, 28, 28, 28, 28, 28, 6, 10, 10, 12, 13, 6, 8, 11, 10, 10, 8, 11, 8, 6, 6, 6, 5, 5, 5, 6, 6, 6, 6, 6, 6, 6, 7, 8, 15, 6, 12, 10, 13, 6, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 8, 7, 8, 13, 19, 13, 14, 6, 15, 5, 6, 5, 6, 5, 6, 6, 6, 5, 7, 7, 6, 6, 6, 5, 6, 7, 6, 5, 5, 6, 7, 7, 7, 7, 7, 15, 11, 14, 13, 28, 20, 22, 20, 20, 22, 22, 22, 23, 22, 23, 23, 23, 23, 23, 24, 23, 24, 24, 22, 23, 24, 23, 23, 23, 23, 21, 22, 23, 22, 23, 23, 24, 22, 21, 20, 22, 22, 23, 23, 21, 23, 22, 22, 24, 21, 22, 23, 23, 21, 21, 22, 21, 23, 22, 23, 23, 20, 22, 22, 22, 23, 22, 22, 23, Character.CURRENCY_SYMBOL, Character.CURRENCY_SYMBOL, 20, 19, 22, 23, 22, Character.MATH_SYMBOL, Character.CURRENCY_SYMBOL, Character.CURRENCY_SYMBOL, Character.CURRENCY_SYMBOL, 27, 27, Character.CURRENCY_SYMBOL, 24, Character.MATH_SYMBOL, 19, 21, Character.CURRENCY_SYMBOL, 27, 27, Character.CURRENCY_SYMBOL, 27, 24, 21, 21, Character.CURRENCY_SYMBOL, Character.CURRENCY_SYMBOL, 28, 27, 27, 27, 20, 24, 20, 21, 22, 21, 21, 23, 22, 22, Character.MATH_SYMBOL, Character.MATH_SYMBOL, 24, 24, Character.CURRENCY_SYMBOL, 23, Character.CURRENCY_SYMBOL, 27, Character.CURRENCY_SYMBOL, Character.CURRENCY_SYMBOL, 27, 27, 27, 27, 27, 28, 27, 27, 27, 27, 27, Character.CURRENCY_SYMBOL};

    /* renamed from: c, reason: collision with root package name */
    private static final Huffman f41977c = new Huffman();

    /* renamed from: d, reason: collision with root package name */
    private final Node f41978d = new Node();

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static final class Node {

        /* renamed from: a, reason: collision with root package name */
        public final Node[] f41979a;

        /* renamed from: b, reason: collision with root package name */
        public final int f41980b;

        /* renamed from: c, reason: collision with root package name */
        public final int f41981c;

        public Node() {
            this.f41979a = new Node[256];
            this.f41980b = 0;
            this.f41981c = 0;
        }

        public Node(int i10, int i11) {
            this.f41979a = null;
            this.f41980b = i10;
            int i12 = i11 & 7;
            this.f41981c = i12 == 0 ? 8 : i12;
        }
    }

    private Huffman() {
        a();
    }

    private void a() {
        int i10 = 0;
        while (true) {
            byte[] bArr = f41976b;
            if (i10 >= bArr.length) {
                return;
            }
            a(i10, f41975a[i10], bArr[i10]);
            i10++;
        }
    }

    private void a(int i10, int i11, byte b4) {
        Node node = new Node(i10, b4);
        Node node2 = this.f41978d;
        while (b4 > 8) {
            b4 = (byte) (b4 - 8);
            int i12 = (i11 >>> b4) & 255;
            Node[] nodeArr = node2.f41979a;
            if (nodeArr == null) {
                throw new IllegalStateException("invalid dictionary: prefix not unique");
            }
            if (nodeArr[i12] == null) {
                nodeArr[i12] = new Node();
            }
            node2 = node2.f41979a[i12];
        }
        int i13 = 8 - b4;
        int i14 = (i11 << i13) & 255;
        int i15 = 1 << i13;
        for (int i16 = i14; i16 < i14 + i15; i16++) {
            node2.f41979a[i16] = node;
        }
    }

    public static Huffman get() {
        return f41977c;
    }

    public int a(ByteString byteString) {
        long j10 = 0;
        for (int i10 = 0; i10 < byteString.size(); i10++) {
            j10 += f41976b[byteString.getByte(i10) & 255];
        }
        return (int) ((j10 + 7) >> 3);
    }

    public void a(ByteString byteString, BufferedSink bufferedSink) throws IOException {
        long j10 = 0;
        int i10 = 0;
        for (int i11 = 0; i11 < byteString.size(); i11++) {
            int i12 = byteString.getByte(i11) & 255;
            int i13 = f41975a[i12];
            byte b4 = f41976b[i12];
            j10 = (j10 << b4) | i13;
            i10 += b4;
            while (i10 >= 8) {
                i10 -= 8;
                bufferedSink.writeByte((int) (j10 >> i10));
            }
        }
        if (i10 > 0) {
            bufferedSink.writeByte((int) ((255 >>> i10) | (j10 << (8 - i10))));
        }
    }

    public byte[] a(byte[] bArr) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        Node node = this.f41978d;
        int i10 = 0;
        int i11 = 0;
        for (byte b4 : bArr) {
            i10 = (i10 << 8) | (b4 & 255);
            i11 += 8;
            while (i11 >= 8) {
                node = node.f41979a[(i10 >>> (i11 - 8)) & 255];
                if (node.f41979a == null) {
                    byteArrayOutputStream.write(node.f41980b);
                    i11 -= node.f41981c;
                    node = this.f41978d;
                } else {
                    i11 -= 8;
                }
            }
        }
        while (i11 > 0) {
            Node node2 = node.f41979a[(i10 << (8 - i11)) & 255];
            if (node2.f41979a != null || node2.f41981c > i11) {
                break;
            }
            byteArrayOutputStream.write(node2.f41980b);
            i11 -= node2.f41981c;
            node = this.f41978d;
        }
        return byteArrayOutputStream.toByteArray();
    }
}
