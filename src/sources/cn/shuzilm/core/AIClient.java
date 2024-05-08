package cn.shuzilm.core;

import android.content.ComponentName;
import android.content.ContentProviderClient;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.net.Uri;
import android.os.Binder;
import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.text.TextUtils;
import android.util.Base64;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import java.io.File;
import java.io.ObjectStreamConstants;
import java.lang.reflect.Method;
import java.security.MessageDigest;
import java.util.concurrent.LinkedBlockingQueue;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class AIClient {

    /* renamed from: a, reason: collision with root package name */
    public static int f1626a;
    private static long am;
    private static long an;
    public static boolean isf;
    private Context ao;
    private String ap = null;
    private final int aq = 0;

    /* renamed from: ar, reason: collision with root package name */
    private final int f1657ar = 1;
    private final int as = 2;
    private final int at = 3;
    private final int au = 4;
    private final int av = 5;
    private final int aw = 6;
    private final int ax = 7;
    private final int ay = 8;

    /* renamed from: b, reason: collision with root package name */
    private static int[] f1632b = {245, 252, 251, 246, 252, 247, 228, 188, 246, 251, 253, 224, 246, 252, 243, 188, 255, 253, 241, 0};

    /* renamed from: c, reason: collision with root package name */
    private static int[] f1633c = {230, 224, 243, 230, 225, 156, 215, 209, 219, 196, 192, 215, 193, 156, 192, 215, 219, 212, 219, 198, 220, 215, 214, 219, 156, 193, 214, 211, 156, 193, 223, 213, 156, 214, 219, 221, 192, 214, 220, 211, 156, 215, 222, 213, 221, 221, 213, 156, 223, 221, 209, 0};

    /* renamed from: d, reason: collision with root package name */
    private static int[] f1634d = {230, 248, 242, 187, 241, 252, 250, 231, 241, 251, 244, 187, 240, 249, 242, 250, 250, 242, 187, 248, 250, 246, 0};

    /* renamed from: e, reason: collision with root package name */
    private static int[] f1635e = {166, 160, 170, 181, 177, 166, 144, 167, 138, 164, 173, 170, 176, 170, 183, 177, 166, 181, 167, 130, 138, 237, 175, 162, 173, 177, 166, 183, 173, 170, 237, 177, 166, 170, 165, 170, 183, 173, 166, 167, 170, 237, 176, 167, 162, 237, 176, 174, 164, 237, 167, 170, 172, 177, 167, 173, 162, 237, 166, 175, 164, 172, 172, 164, 237, 174, 172, 160, 0};

    /* renamed from: f, reason: collision with root package name */
    private static int[] f1636f = {218, 171, 169, 172, 218, 222, 170, 172, 168, 218, 222, 222, 171, 166, 170, 217, 168, 221, 174, 166, 168, 217, 169, 217, 175, 218, 173, 219, 173, 217, 173, 218, 0};

    /* renamed from: g, reason: collision with root package name */
    private static int[] f1637g = {246, 227, 224, 247, 245, 218, 0};

    /* renamed from: h, reason: collision with root package name */
    private static int[] f1638h = {234, 231, 249, 230, 160, 231, 235, 249, 239, 251, 230, 160, 227, 225, 237, 0};

    /* renamed from: i, reason: collision with root package name */
    private static int[] f1639i = {230, 224, 234, 245, 241, 230, 240, 252, 240, 231, 234, 237, 230, 243, 236, 141, 198, 192, 202, 213, 198, 199, 205, 198, 211, 204, 141, 208, 202, 199, 204, 214, 141, 206, 204, 192, 0};

    /* renamed from: j, reason: collision with root package name */
    private static int[] f1640j = {209, 215, 221, 194, 198, 209, 231, 198, 209, 221, 210, 221, 192, 218, 209, 208, 253, 209, 215, 221, 194, 209, 240, 218, 209, 196, 251, 154, 216, 208, 221, 213, 154, 209, 215, 221, 194, 209, 208, 218, 209, 196, 219, 154, 199, 221, 208, 219, 193, 154, 217, 219, 215, 0};

    /* renamed from: k, reason: collision with root package name */
    private static int[] f1641k = {219, 220, 218, 170, 167, 218, 170, 170, 221, 170, 219, 170, 167, 172, 167, 219, 173, 175, 173, 221, 217, 219, 220, 171, 222, 173, 168, 217, 218, 219, 217, 174, 0};

    /* renamed from: l, reason: collision with root package name */
    private static int[] f1642l = {243, 245, 255, 224, 228, 243, 229, 242, 255, 243, 245, 255, 224, 243, 242, 184, 255, 227, 236, 184, 251, 249, 245, 0};

    /* renamed from: m, reason: collision with root package name */
    private static int[] f1643m = {195, 197, 207, 208, 212, 195, 245, 194, 207, 195, 197, 207, 208, 195, 226, 136, 195, 197, 207, 208, 212, 195, 213, 194, 207, 195, 197, 207, 208, 195, 194, 136, 207, 211, 220, 136, 203, 201, 197, 0};

    /* renamed from: n, reason: collision with root package name */
    private static int[] f1644n = {204, 202, 200, 207, 219, 204, 221, 199, 224, 205, 192, 204, 202, 192, 223, 204, 237, 224, 135, 204, 202, 192, 223, 219, 204, 218, 205, 192, 204, 202, 192, 223, 204, 205, 135, 192, 220, 211, 135, 196, 198, 202, 0};

    /* renamed from: o, reason: collision with root package name */
    private static int[] f1645o = {221, 174, 175, 171, 167, 219, 220, 170, 168, 220, 167, 222, 219, 166, 221, 220, 219, 166, 217, 168, 172, 168, 222, 219, 217, 173, 219, 222, 219, 174, 174, 174, 0};

    /* renamed from: p, reason: collision with root package name */
    private static int[] f1646p = {222, 167, 217, 167, 172, 217, 220, 222, 219, 166, 170, 221, 168, 168, 170, 220, 172, 174, 171, 173, 174, 217, 175, 174, 221, 221, 219, 218, 222, 221, 168, 219, 0};

    /* renamed from: q, reason: collision with root package name */
    private static int[] f1647q = {197, 196, 213, 211, 206, 209, 209, 212, 210, 143, 197, 200, 211, 196, 200, 199, 200, 213, 207, 196, 197, 200, 143, 210, 216, 210, 143, 213, 210, 200, 210, 211, 196, 209, 0};

    /* renamed from: r, reason: collision with root package name */
    private static int[] f1648r = {233, 255, 243, 238, 232, 255, 234, 245, 232, 202, 247, 255, 238, 233, 227, 201, 180, 233, 245, 180, 254, 243, 245, 232, 254, 244, 251, 0};

    /* renamed from: s, reason: collision with root package name */
    private static int[] f1649s = {244, 249, 254, 245, 224, 255, 190, 224, 241, 228, 233, 245, 248, 190, 253, 255, 243, 0};

    /* renamed from: t, reason: collision with root package name */
    private static int[] f1650t = {197, 195, 201, 214, 210, 197, 243, 217, 198, 201, 212, 206, 197, 196, 233, 142, 196, 201, 206, 197, 208, 207, 142, 208, 193, 212, 217, 197, 200, 142, 205, 207, 195, 0};

    /* renamed from: u, reason: collision with root package name */
    private static int[] f1651u = {199, 202, 214, 204, 0};

    /* renamed from: v, reason: collision with root package name */
    private static int[] f1652v = {220, 209, 246, 253, 232, 215, 209, 182, 252, 241, 246, 253, 232, 247, 182, 232, 249, 236, 225, 253, 240, 182, 245, 247, 251, 0};

    /* renamed from: w, reason: collision with root package name */
    private static int[] f1653w = {222, 174, 168, 169, 219, 170, 175, 221, 218, 221, 170, 218, 170, 168, 173, 169, 217, 169, 174, 166, 175, 171, 220, 168, 172, 220, 222, 166, 175, 167, 170, 170, 0};

    /* renamed from: x, reason: collision with root package name */
    private static int[] f1654x = {226, 228, 238, 241, 245, 226, 244, 248, 227, 238, 248, 233, 226, 247, 232, 137, 195, 206, 201, 194, 215, 200, 137, 215, 198, 211, 222, 194, 207, 137, 202, 200, 196, 137, 201, 200, 206, 211, 196, 198, 0};

    /* renamed from: y, reason: collision with root package name */
    private static int[] f1655y = {173, 169, 167, 217, 219, 219, 218, 221, 220, 167, 218, 220, 217, 167, 222, 169, 172, 172, 220, 217, 219, 217, 172, 168, 221, 168, 221, 173, 167, 175, 171, 166, 0};

    /* renamed from: z, reason: collision with root package name */
    private static int[] f1656z = {234, 248, 230, 165, 248, 254, 248, 234, 165, 230, 228, 232, 0};
    private static int[] A = {217, 212, 217, 194, 206, 206, 216, 222, 222, 220, 179, 243, 242, 244, 233, 254, 252, 179, 252, 238, 240, 179, 238, 232, 238, 252, 179, 240, 242, 254, 0};
    private static int[] B = {216, 213, 216, 229, 238, 253, 232, 242, 249, 241, 249, 240, 236, 236, 233, 207, 178, 253, 239, 241, 178, 239, 233, 239, 253, 178, 241, 243, 255, 0};
    private static int[] C = {209, 215, 221, 194, 198, 209, 231, 240, 253, 240, 205, 198, 213, 192, 218, 209, 217, 209, 216, 196, 196, 193, 231, 154, 240, 253, 240, 205, 198, 213, 192, 218, 209, 217, 209, 216, 196, 196, 193, 231, 154, 213, 199, 217, 154, 199, 193, 199, 213, 154, 217, 219, 215, 0};
    private static int[] D = {203, 205, 207, 200, 220, 203, 218, 192, 231, 194, 202, 199, 239, 202, 199, 234, 231, 128, 234, 231, 234, 215, 220, 207, 218, 192, 203, 195, 203, 194, 222, 222, 219, 253, 128, 207, 221, 195, 128, 221, 219, 221, 207, 128, 195, 193, 205, 0};
    private static int[] E = {217, 170, 217, 218, 166, 174, 221, 222, 174, 167, 171, 174, 173, 217, 221, 170, 171, 169, 217, 221, 171, 166, 167, 171, 173, 218, 170, 217, 172, 167, 170, 171, 0};
    private static int[] F = {199, 193, 203, 212, 208, 199, 209, 198, 203, 199, 193, 203, 212, 199, 198, 140, 198, 203, 205, 208, 198, 204, 195, 140, 197, 204, 215, 209, 207, 195, 209, 140, 207, 205, 193, 0};
    private static int[] G = {215, 209, 219, 196, 192, 215, 225, 214, 251, 215, 209, 219, 196, 215, 246, 156, 215, 209, 219, 196, 192, 215, 193, 214, 219, 215, 209, 219, 196, 215, 214, 156, 214, 219, 221, 192, 214, 220, 211, 156, 213, 220, 199, 193, 223, 211, 193, 156, 223, 221, 209, 0};
    private static int[] H = {214, 208, 218, 197, 193, 214, 224, 215, 250, 214, 208, 218, 197, 214, 247, 250, 157, 214, 208, 218, 197, 193, 214, 192, 215, 218, 214, 208, 218, 197, 214, 215, 157, 215, 218, 220, 193, 215, 221, 210, 157, 212, 221, 198, 192, 222, 210, 192, 157, 222, 220, 208, 0};
    private static int[] I = {175, 220, 167, 172, 175, 219, 170, 173, 173, 222, 175, 219, 168, 219, 217, 170, 221, 167, 218, 175, 172, 218, 217, 218, 221, 219, 217, 217, 172, 173, 221, 174, 0};
    private static int[] J = {140, 200, 199, 208, 199, 202, 205, 198, 211, 204, 141, 198, 206, 218, 207, 197, 141, 214, 217, 202, 198, 206, 141, 206, 204, 192, 140, 140, 153, 215, 205, 198, 215, 205, 204, 192, 0};
    private static int[] K = {243, 252, 235, 252, 241, 246, 253, 232, 247, 182, 253, 245, 225, 244, 254, 182, 237, 226, 241, 253, 245, 182, 245, 247, 251, 0};
    private static int[] L = {175, 166, 222, 169, 175, 167, 172, 222, 218, 174, 174, 218, 168, 175, 169, 217, 167, 171, 222, 170, 217, 169, 173, 219, 221, 219, 168, 172, 172, 221, 172, 175, 0};
    private static int[] M = {218, 215, 202, 215, 205, 198, 199, 202, 140, 218, 215, 202, 215, 205, 198, 199, 202, 141, 194, 202, 193, 214, 205, 141, 205, 192, 140, 140, 153, 215, 205, 198, 215, 205, 204, 192, 0};
    private static int[] N = {220, 174, 168, 218, 174, 217, 220, 219, 218, 168, 170, 167, 169, 221, 169, 222, 166, 218, 220, 222, 217, 172, 170, 167, 219, 172, 221, 218, 172, 173, 221, 170, 0};
    private static int[] O = {205, 209, 204, 232, 211, 196, 197, 200, 215, 206, 211, 241, 197, 232, 143, 205, 209, 204, 200, 143, 197, 200, 143, 197, 200, 206, 211, 197, 207, 192, 143, 204, 206, 194, 0};
    private static int[] P = {204, 200, 202, 196, 204, 221, 0};
    private static int[] Q = {194, 219, 200, 193, 218, 194, 202, 200, 197, 203, 0};
    private static int[] R = {234, 248, 230, 165, 239, 226, 239, 230, 165, 230, 228, 232, 0};
    private static int[] S = {197, 195, 201, 214, 210, 197, 243, 204, 235, 193, 211, 237, 142, 197, 195, 201, 214, 210, 197, 211, 142, 193, 211, 205, 142, 196, 201, 196, 205, 142, 205, 207, 195, 0};
    private static int[] T = {250, 252, 246, 233, 237, 250, 236, 177, 235, 237, 254, 235, 236, 177, 241, 240, 246, 235, 252, 254, 177, 254, 236, 242, 177, 241, 234, 253, 177, 242, 240, 252, 0};
    private static int[] U = {253, 245, 249, 246, 255, 243, 232, 182, 245, 249, 234, 249, 232, 182, 249, 235, 245, 182, 246, 237, 250, 182, 245, 247, 251, 0};
    private static int[] V = {220, 170, 221, 175, 218, 175, 173, 175, 217, 172, 175, 220, 169, 222, 217, 175, 175, 172, 166, 222, 174, 222, 173, 218, 217, 171, 166, 172, 221, 218, 218, 174, 0};
    private static int[] W = {237, 252, 234, 247, 240, 247, 236, 235, 183, 244, 248, 235, 248, 233, 183, 248, 234, 244, 183, 247, 236, 251, 183, 244, 246, 250, 0};
    private static int[] X = {197, 195, 201, 214, 210, 197, 243, 196, 233, 193, 211, 237, 142, 197, 195, 201, 214, 210, 197, 211, 142, 193, 211, 205, 142, 196, 201, 196, 205, 142, 205, 207, 195, 0};
    private static int[] Y = {197, 195, 201, 214, 210, 197, 211, 142, 207, 212, 196, 206, 201, 194, 142, 206, 207, 201, 212, 195, 193, 142, 193, 211, 205, 142, 206, 213, 194, 142, 205, 207, 195, 0};
    private static int[] Z = {252, 250, 248, 255, 235, 252, 237, 247, 208, 253, 208, 248, 234, 212, 183, 251, 240, 245, 183, 247, 236, 251, 183, 244, 246, 250, 0};

    /* renamed from: aa, reason: collision with root package name */
    private static int[] f1627aa = {250, 237, 251, 234, 225, 252, 254, 160, 231, 251, 253, 253, 160, 225, 252, 0};

    /* renamed from: ab, reason: collision with root package name */
    private static int[] f1628ab = {202, 214, 208, 208, 0};

    /* renamed from: ac, reason: collision with root package name */
    private static int[] f1629ac = {167, 222, 222, 171, 171, 167, 168, 217, 174, 219, 166, 175, 174, 168, 166, 169, 217, 174, 220, 218, 168, 168, 217, 174, 175, 174, 220, 217, 175, 222, 222, 220, 0};

    /* renamed from: ad, reason: collision with root package name */
    private static int[] f1630ad = {212, 200, 194, 202, 194, 194, 213, 193, 0};

    /* renamed from: ae, reason: collision with root package name */
    private static int[] f1631ae = {248, 241, 246, 245, 248, 186, 241, 249, 241, 241, 230, 242, 186, 240, 248, 253, 225, 246, 186, 251, 230, 0};
    private static int[] af = {169, 172, 222, 170, 172, 170, 171, 173, 173, 218, 167, 173, 170, 173, 217, 171, 166, 171, 218, 222, 168, 169, 166, 217, 171, 217, 166, 171, 220, 168, 168, 166, 0};
    private static int[] ag = {168, 170, 173, 221, 172, 171, 169, 167, 172, 222, 222, 217, 217, 222, 172, 175, 221, 167, 173, 173, 172, 222, 217, 172, 220, 219, 172, 174, 218, 169, 222, 217, 0};
    private static int[] ah = {238, 232, 245, 234, 234, 239, 233, 254, 243, 255, 249, 243, 236, 255, 254, 180, 254, 251, 234, 246, 245, 245, 249, 180, 247, 245, 249, 0};
    private static int[] ai = {207, 201, 195, 220, 216, 207, 249, 206, 227, 207, 201, 195, 220, 207, 238, 132, 222, 216, 197, 218, 218, 223, 217, 206, 195, 207, 201, 195, 220, 207, 206, 132, 206, 203, 218, 198, 197, 197, 201, 132, 199, 197, 201, 0};
    private static int[] aj = {217, 206, 204, 202, 197, 202, 230, 207, 226, 206, 200, 194, 221, 206, 239, 226, 133, 223, 217, 196, 219, 219, 222, 216, 207, 194, 206, 200, 194, 221, 206, 207, 133, 207, 202, 219, 199, 196, 196, 200, 133, 198, 196, 200, 0};
    private static int[] ak = {169, 166, 222, 217, 167, 168, 217, 220, 217, 168, 172, 172, 174, 169, 170, 168, 171, 219, 219, 221, 219, 172, 222, 167, 220, 217, 168, 173, 174, 166, 173, 166, 0};
    private static int[] al = {204, 202, 192, 223, 219, 204, 250, 237, 224, 232, 230, 224, 135, 205, 192, 200, 198, 135, 204, 202, 192, 223, 219, 204, 218, 205, 220, 198, 197, 202, 135, 219, 198, 199, 198, 193, 192, 193, 135, 196, 198, 202, 0};

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public final class AC implements ServiceConnection {

        /* renamed from: a, reason: collision with root package name */
        public boolean f1660a;

        /* renamed from: b, reason: collision with root package name */
        private final LinkedBlockingQueue f1661b;

        private AC() {
            this.f1660a = false;
            this.f1661b = new LinkedBlockingQueue(1);
        }

        public IBinder getBinder() {
            if (this.f1660a) {
                throw new IllegalStateException();
            }
            this.f1660a = true;
            return (IBinder) this.f1661b.take();
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            AIClient.b(this.f1661b, iBinder);
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public final class AI implements IInterface {

        /* renamed from: b, reason: collision with root package name */
        private IBinder f1663b;

        /* renamed from: c, reason: collision with root package name */
        private String f1664c;

        /* renamed from: d, reason: collision with root package name */
        private int f1665d;

        public AI(IBinder iBinder, String str, int i10) {
            this.f1663b = iBinder;
            this.f1664c = str;
            this.f1665d = i10;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this.f1663b;
        }

        public String getId() {
            String str;
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            String str2 = null;
            try {
                str = this.f1664c;
            } catch (Throwable unused) {
                obtain2.recycle();
                obtain.recycle();
            }
            if (str != null && this.f1665d >= 0) {
                obtain.writeInterfaceToken(str);
                this.f1663b.transact(this.f1665d, obtain, obtain2, 0);
                obtain2.readException();
                str2 = obtain2.readString();
                obtain2.recycle();
                obtain.recycle();
                return str2;
            }
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public final class AIO implements IInterface {

        /* renamed from: b, reason: collision with root package name */
        private IBinder f1667b;

        /* renamed from: c, reason: collision with root package name */
        private String f1668c;

        public AIO(IBinder iBinder, String str) {
            this.f1667b = iBinder;
            this.f1668c = str;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this.f1667b;
        }

        public String getId(String str, String str2, String str3) {
            String str4;
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            String str5 = null;
            try {
                str4 = this.f1668c;
            } catch (Throwable unused) {
                obtain2.recycle();
                obtain.recycle();
            }
            if (str4 == null) {
                return null;
            }
            obtain.writeInterfaceToken(str4);
            obtain.writeString(str);
            obtain.writeString(str2);
            obtain.writeString(str3);
            this.f1667b.transact(1, obtain, obtain2, 0);
            obtain2.readException();
            str5 = obtain2.readString();
            obtain2.recycle();
            obtain.recycle();
            return str5;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    class AO {

        /* renamed from: b, reason: collision with root package name */
        private int[] f1670b;

        /* renamed from: c, reason: collision with root package name */
        private int[] f1671c;

        /* renamed from: d, reason: collision with root package name */
        private Context f1672d;

        /* renamed from: e, reason: collision with root package name */
        private int[] f1673e;

        private AO(Context context) {
            this.f1670b = new int[]{246, 251, 243, 253, 157, 214, 251, 192, 215, 219, 212, 219, 198, 220, 215, 214, 251, 157, 192, 215, 214, 219, 196, 221, 192, 226, 214, 251, 156, 193, 223, 196, 156, 221, 196, 219, 196, 156, 223, 221, 209, 157, 157, 136, 198, 220, 215, 198, 220, 221, 209, 0};
            this.f1671c = new int[]{231, 234, 226, 236, 0};
            this.f1673e = new int[]{194, 207, 199, 201, 242, 227, 225, 0};
            this.f1672d = context;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public String a() {
            try {
                Uri parse = Uri.parse(AIClient.this.a(AIClient.M));
                int i10 = Build.VERSION.SDK_INT;
                ContentProviderClient acquireContentProviderClient = this.f1672d.getContentResolver().acquireContentProviderClient(parse);
                if (acquireContentProviderClient == null) {
                    return null;
                }
                Bundle call = acquireContentProviderClient.call(AIClient.this.a(this.f1673e), null, null);
                if (i10 >= 24) {
                    acquireContentProviderClient.close();
                } else {
                    acquireContentProviderClient.release();
                }
                if (call != null && call.getInt("code", -1) == 0) {
                    return call.getString("id");
                }
                return null;
            } catch (Throwable unused) {
                return null;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Removed duplicated region for block: B:12:0x0061 A[Catch: all -> 0x006e, TryCatch #0 {all -> 0x006e, blocks: (B:4:0x0004, B:6:0x000a, B:8:0x0055, B:10:0x005b, B:12:0x0061, B:13:0x006b, B:20:0x0028), top: B:2:0x0002 }] */
        /* JADX WARN: Removed duplicated region for block: B:8:0x0055 A[Catch: all -> 0x006e, TryCatch #0 {all -> 0x006e, blocks: (B:4:0x0004, B:6:0x000a, B:8:0x0055, B:10:0x005b, B:12:0x0061, B:13:0x006b, B:20:0x0028), top: B:2:0x0002 }] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public java.lang.String a(int r9) {
            /*
                r8 = this;
                r0 = 0
                r1 = 4
                if (r9 != r1) goto L25
                int r9 = android.os.Build.VERSION.SDK_INT     // Catch: java.lang.Throwable -> L6e
                r1 = 27
                if (r9 <= r1) goto L52
                cn.shuzilm.core.AIClient r9 = cn.shuzilm.core.AIClient.this     // Catch: java.lang.Throwable -> L6e
                int[] r1 = r8.f1670b     // Catch: java.lang.Throwable -> L6e
                java.lang.String r9 = cn.shuzilm.core.AIClient.a(r9, r1)     // Catch: java.lang.Throwable -> L6e
                android.net.Uri r2 = android.net.Uri.parse(r9)     // Catch: java.lang.Throwable -> L6e
                android.content.Context r9 = r8.f1672d     // Catch: java.lang.Throwable -> L6e
                android.content.ContentResolver r1 = r9.getContentResolver()     // Catch: java.lang.Throwable -> L6e
                r3 = 0
                r4 = 0
                r5 = 0
                r6 = 0
                android.database.Cursor r9 = r1.query(r2, r3, r4, r5, r6)     // Catch: java.lang.Throwable -> L6e
                goto L53
            L25:
                r1 = 5
                if (r9 != r1) goto L52
                cn.shuzilm.core.AIClient r9 = cn.shuzilm.core.AIClient.this     // Catch: java.lang.Throwable -> L6e
                int[] r1 = cn.shuzilm.core.AIClient.a()     // Catch: java.lang.Throwable -> L6e
                java.lang.String r9 = cn.shuzilm.core.AIClient.a(r9, r1)     // Catch: java.lang.Throwable -> L6e
                android.net.Uri r2 = android.net.Uri.parse(r9)     // Catch: java.lang.Throwable -> L6e
                android.content.Context r9 = r8.f1672d     // Catch: java.lang.Throwable -> L6e
                android.content.ContentResolver r1 = r9.getContentResolver()     // Catch: java.lang.Throwable -> L6e
                r3 = 0
                r4 = 0
                r9 = 1
                java.lang.String[] r5 = new java.lang.String[r9]     // Catch: java.lang.Throwable -> L6e
                r9 = 0
                cn.shuzilm.core.AIClient r6 = cn.shuzilm.core.AIClient.this     // Catch: java.lang.Throwable -> L6e
                int[] r7 = r8.f1671c     // Catch: java.lang.Throwable -> L6e
                java.lang.String r6 = cn.shuzilm.core.AIClient.a(r6, r7)     // Catch: java.lang.Throwable -> L6e
                r5[r9] = r6     // Catch: java.lang.Throwable -> L6e
                r6 = 0
                android.database.Cursor r9 = r1.query(r2, r3, r4, r5, r6)     // Catch: java.lang.Throwable -> L6e
                goto L53
            L52:
                r9 = r0
            L53:
                if (r9 == 0) goto L6e
                boolean r1 = r9.isClosed()     // Catch: java.lang.Throwable -> L6e
                if (r1 != 0) goto L6e
                boolean r1 = r9.moveToNext()     // Catch: java.lang.Throwable -> L6e
                if (r1 == 0) goto L6b
                java.lang.String r1 = "value"
                int r1 = r9.getColumnIndex(r1)     // Catch: java.lang.Throwable -> L6e
                java.lang.String r0 = r9.getString(r1)     // Catch: java.lang.Throwable -> L6e
            L6b:
                r9.close()     // Catch: java.lang.Throwable -> L6e
            L6e:
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: cn.shuzilm.core.AIClient.AO.a(int):java.lang.String");
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    interface HI {

        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
        public abstract class u extends Binder implements HI {

            /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
            public class d implements HI {

                /* renamed from: a, reason: collision with root package name */
                private IBinder f1674a;

                public d(IBinder iBinder) {
                    this.f1674a = iBinder;
                }

                @Override // cn.shuzilm.core.AIClient.HI
                public void b(HII.OI oi) {
                    Parcel obtain = Parcel.obtain();
                    Parcel obtain2 = Parcel.obtain();
                    try {
                        obtain.writeInterfaceToken("com.hihonor.cloudservice.oaid.IOAIDService");
                        obtain.writeStrongBinder(oi);
                        this.f1674a.transact(2, obtain, obtain2, 0);
                        obtain2.readException();
                    } finally {
                        try {
                        } finally {
                        }
                    }
                }
            }
        }

        void b(HII.OI oi);
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public interface HII extends IInterface {

        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
        public abstract class OI extends Binder implements HII {

            /* renamed from: a, reason: collision with root package name */
            public String f1675a = "com.hihonor.cloudservice.oaid.IOAIDCallBack";

            public OI() {
                attachInterface(this, "com.hihonor.cloudservice.oaid.IOAIDCallBack");
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this;
            }

            @Override // android.os.Binder
            public boolean onTransact(int i10, Parcel parcel, Parcel parcel2, int i11) {
                if (i10 == 2) {
                    try {
                        parcel.enforceInterface(this.f1675a);
                        go(parcel.readInt(), parcel.readInt() == 0 ? null : (Bundle) Bundle.CREATOR.createFromParcel(parcel));
                        parcel2.writeNoException();
                        return true;
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                }
                return super.onTransact(i10, parcel, parcel2, i11);
            }
        }

        void go(int i10, Bundle bundle);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public final class HNO implements IInterface {

        /* renamed from: b, reason: collision with root package name */
        private IBinder f1677b;

        public HNO(IBinder iBinder) {
            this.f1677b = iBinder;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this.f1677b;
        }

        public void getID() {
            try {
                IBinder iBinder = this.f1677b;
                if (iBinder == null) {
                    return;
                }
                Object queryLocalInterface = iBinder.queryLocalInterface(AIClient.this.a(AIClient.al));
                ((queryLocalInterface == null || !(queryLocalInterface instanceof HI.u.d)) ? new HI.u.d(this.f1677b) : (HI.u.d) queryLocalInterface).b(new gid());
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public class gid extends HII.OI {
        public gid() {
        }

        @Override // cn.shuzilm.core.AIClient.HII
        public void go(int i10, Bundle bundle) {
            try {
                String string = bundle.getString(AIClient.this.a(new int[]{238, 232, 229, 239, 214, 237, 224, 214, 232, 230, 0}));
                AIClient aIClient = AIClient.this;
                aIClient.a(string, aIClient.a(new int[]{169, 174, 171, 221, 166, 167, 166, 220, 174, 168, 169, 219, 169, 166, 168, 217, 172, 169, 171, 175, 169, 171, 218, 174, 221, 166, 169, 168, 166, 218, 220, 166, 0}));
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public AIClient(Context context) {
        this.ao = context;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized String a(int[] iArr) {
        String str = null;
        if (iArr == null) {
            return null;
        }
        try {
            int length = iArr.length;
            StringBuilder sb2 = new StringBuilder();
            int i10 = length + 126;
            for (int i11 = 0; i11 < length; i11++) {
                if (i11 != 0) {
                    sb2.append(Character.toString((char) (iArr[(length - i11) - 1] ^ i10)));
                }
            }
            str = sb2.toString();
        } catch (Exception unused) {
        }
        return str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, String str2) {
        if (str == null || str2 == null) {
            return;
        }
        try {
            byte[] bArr = new byte[3];
            byte[] encode = Base64.encode(str.getBytes(), 0);
            bArr[1] = ObjectStreamConstants.TC_OBJECT;
            if (encode != null) {
                try {
                    byte[] bArr2 = new byte[encode.length];
                    int i10 = 0;
                    for (int i11 = 0; i11 < encode.length; i11++) {
                        byte b4 = encode[i11];
                        if (33 < b4 && b4 < 126) {
                            bArr2[i10] = encode[i11];
                            i10++;
                        }
                    }
                    bArr[0] = 75;
                    byte[] bArr3 = new byte[i10];
                    System.arraycopy((Object) bArr2, 0, (Object) bArr3, 0, i10);
                    bArr[2] = 90;
                    if (i10 < 256) {
                        str = new String(bArr, "UTF-8") + new String(bArr3, "UTF-8");
                    }
                } catch (Exception unused) {
                }
            }
            SharedPreferences sharedPreferences = this.ao.getSharedPreferences(this.ao.getPackageName() + a(f1637g), 0);
            if (sharedPreferences != null) {
                String string = sharedPreferences.getString(str2, "a");
                if (string == null || !string.equals(str)) {
                    SharedPreferences.Editor edit = sharedPreferences.edit();
                    edit.putString(str2, str);
                    edit.apply();
                }
            }
        } catch (Exception unused2) {
        }
    }

    private void a(String str, String str2, String str3, String str4) {
        IBinder iBinder;
        try {
            Method declaredMethod = Class.forName(str).getDeclaredMethod(str2, String.class);
            if (declaredMethod == null || (iBinder = (IBinder) declaredMethod.invoke(null, str3)) == null) {
                return;
            }
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                iBinder.transact(4, obtain, obtain2, 0);
                String readString = obtain2.readString();
                if (readString != null && !readString.isEmpty()) {
                    a(readString, str4);
                }
            } catch (Exception unused) {
            } catch (Throwable th) {
                obtain.recycle();
                obtain2.recycle();
                throw th;
            }
            obtain.recycle();
            obtain2.recycle();
        } catch (Throwable unused2) {
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:32:0x00f3, code lost:
    
        if (r10 == null) goto L42;
     */
    /* JADX WARN: Removed duplicated region for block: B:36:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0090 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void a(java.lang.String r10, java.lang.String r11, java.lang.String r12, java.lang.String r13, java.lang.String r14, int r15) {
        /*
            Method dump skipped, instructions count: 254
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.shuzilm.core.AIClient.a(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, int):void");
    }

    private boolean a(String str) {
        SharedPreferences sharedPreferences = this.ao.getSharedPreferences(this.ao.getPackageName() + a(f1637g), 0);
        if (sharedPreferences != null) {
            return sharedPreferences.contains(str);
        }
        return false;
    }

    private boolean a(String str, int i10) {
        return true;
    }

    private String b(String str) {
        if (str == null) {
            return null;
        }
        try {
            Class<?> cls = Class.forName(a(f1648r));
            return (String) cls.getMethod(MonitorConstants.CONNECT_TYPE_GET, String.class, String.class).invoke(cls, str, "unknown");
        } catch (Exception unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(final LinkedBlockingQueue linkedBlockingQueue, final IBinder iBinder) {
        try {
            new Thread(new Runnable() { // from class: cn.shuzilm.core.AIClient.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        LinkedBlockingQueue.this.put(iBinder);
                    } catch (Exception unused) {
                    }
                }
            }).start();
        } catch (Exception unused) {
        }
    }

    private boolean b(String str, int i10) {
        String str2;
        String absolutePath;
        int lastIndexOf;
        try {
            File externalFilesDir = this.ao.getExternalFilesDir(null);
            if (externalFilesDir == null || (lastIndexOf = (absolutePath = externalFilesDir.getAbsolutePath()).lastIndexOf("/data/")) == -1) {
                str2 = "";
            } else {
                str2 = absolutePath.substring(0, lastIndexOf) + "/data/";
            }
            return new File(str2 + str).exists();
        } catch (Exception unused) {
            return false;
        }
    }

    private synchronized String c(String str) {
        String str2 = null;
        if (str == null) {
            return null;
        }
        try {
            byte[] bytes = str.getBytes();
            int length = bytes.length;
            for (int i10 = 0; i10 < length; i10++) {
                bytes[i10] = (byte) (bytes[i10] + 17);
            }
            str2 = new String(bytes);
        } catch (Exception unused) {
        }
        return str2;
    }

    private String d() {
        Signature[] signatureArr;
        if (this.ap == null) {
            try {
                signatureArr = this.ao.getPackageManager().getPackageInfo(this.ao.getPackageName(), 64).signatures;
            } catch (Exception unused) {
                signatureArr = null;
            }
            if (signatureArr != null && signatureArr.length > 0) {
                byte[] byteArray = signatureArr[0].toByteArray();
                try {
                    MessageDigest messageDigest = MessageDigest.getInstance("SHA1");
                    if (messageDigest != null) {
                        byte[] digest = messageDigest.digest(byteArray);
                        StringBuilder sb2 = new StringBuilder();
                        for (byte b4 : digest) {
                            sb2.append(Integer.toHexString((b4 & 255) | 256).substring(1, 3));
                        }
                        this.ap = sb2.toString();
                    }
                } catch (Exception unused2) {
                }
            }
        }
        return this.ap;
    }

    private boolean d(String str) {
        if (str == null) {
            return false;
        }
        try {
            String str2 = Build.MANUFACTURER;
            if (str2 == null) {
                return false;
            }
            String upperCase = str2.toUpperCase();
            String c4 = c(str);
            if (c4 != null) {
                return upperCase.equals(c4);
            }
            return false;
        } catch (Exception unused) {
            return false;
        }
    }

    private void e() {
        try {
            int[] iArr = {226, 239, 231, 201, 242, 227, 225, 0};
            int[] iArr2 = {170, 174, 171, 173, 167, 171, 218, 220, 172, 218, 219, 219, 217, 170, 168, 174, 220, 169, 169, 167, 175, 171, 167, 220, 171, 218, 174, 217, 173, 221, 166, 172, 0};
            Object systemService = this.ao.getSystemService(a(new int[]{255, 232, 251, 255, 232, 254, 236, 254, 224, 210, 224, 248, 251, 226, 0}));
            if (systemService == null) {
                return;
            }
            String str = (String) systemService.getClass().getDeclaredMethod(a(iArr), new Class[0]).invoke(systemService, new Object[0]);
            if (f1640j == null) {
                return;
            }
            a(str, a(iArr2));
        } catch (Exception unused) {
        }
    }

    private boolean f() {
        long j10 = am;
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        if (j10 == 0) {
            am = currentTimeMillis;
            return true;
        }
        if (currentTimeMillis - am <= 10) {
            return false;
        }
        am = System.currentTimeMillis() / 1000;
        return true;
    }

    private boolean g() {
        long j10 = an;
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        if (j10 == 0) {
            an = currentTimeMillis;
            return true;
        }
        if (currentTimeMillis - an <= 5) {
            return false;
        }
        an = System.currentTimeMillis() / 1000;
        return true;
    }

    private boolean h() {
        String b4 = b(a(f1647q));
        return !TextUtils.isEmpty(b4) && b4.equals("1");
    }

    private boolean i() {
        String b4 = b(a(f1631ae));
        return !TextUtils.isEmpty(b4) && b4.equalsIgnoreCase(a(f1630ad));
    }

    private boolean j() {
        String b4 = b(a(f1627aa));
        return (TextUtils.isEmpty(b4) || b4.equalsIgnoreCase("unknown")) ? false : true;
    }

    private boolean k() {
        PackageManager packageManager;
        try {
            if (d("<48ID") && (packageManager = this.ao.getPackageManager()) != null) {
                return packageManager.resolveContentProvider(a(K), 0) != null;
            }
            return false;
        } catch (Exception unused) {
            return false;
        }
    }

    private boolean l() {
        if (!d("=D180")) {
            return false;
        }
        int i10 = Build.VERSION.SDK_INT;
        ContentProviderClient acquireUnstableContentProviderClient = this.ao.getContentResolver().acquireUnstableContentProviderClient(Uri.parse(a(M)));
        Bundle call = acquireUnstableContentProviderClient.call("isSupport", null, null);
        if (call != null) {
            if (i10 >= 24) {
                acquireUnstableContentProviderClient.close();
            } else {
                acquireUnstableContentProviderClient.release();
            }
            if (call.getInt("code", -1) == 0) {
                return call.getBoolean("isSupport", true);
            }
        }
        return false;
    }

    private void m() {
        Intent intent = new Intent();
        intent.setClassName(a(R), a(S));
        intent.setAction(a(T));
        intent.putExtra(a(U), this.ao.getApplicationInfo().packageName);
        try {
            intent.putExtra(a(W), true);
            this.ao.startService(intent);
        } catch (Exception unused) {
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(34:5|(1:9)|(3:10|11|(1:15))|(3:17|18|(1:22))|(3:24|25|(1:159))|29|(3:30|31|(1:35))|(3:37|38|(1:40))|(3:42|43|(1:47))|49|(1:51)|52|(1:54)|(3:55|56|(1:60))|(3:62|63|(1:150))|(3:67|68|(1:145))|(3:72|73|(1:77))|79|(3:80|81|(1:139))|85|(1:89)|90|91|92|(14:96|97|98|99|100|101|102|103|(1:105)|107|108|(4:112|(3:119|120|121)|123|(2:125|(3:127|120|121)))|128|129)|135|102|103|(0)|107|108|(5:110|112|(5:114|116|119|120|121)|123|(0))|128|129) */
    /* JADX WARN: Can't wrap try/catch for region: R(50:5|(1:9)|10|11|(1:15)|17|18|(1:22)|24|25|(1:159)|29|(3:30|31|(1:35))|37|38|(1:40)|(3:42|43|(1:47))|49|(1:51)|52|(1:54)|55|56|(1:60)|62|63|(1:150)|67|68|(1:145)|72|73|(1:77)|79|(3:80|81|(1:139))|85|(1:89)|90|91|92|(14:96|97|98|99|100|101|102|103|(1:105)|107|108|(4:112|(3:119|120|121)|123|(2:125|(3:127|120|121)))|128|129)|135|102|103|(0)|107|108|(5:110|112|(5:114|116|119|120|121)|123|(0))|128|129) */
    /* JADX WARN: Removed duplicated region for block: B:105:0x0553 A[Catch: Exception -> 0x0577, TRY_LEAVE, TryCatch #3 {Exception -> 0x0577, blocks: (B:103:0x0547, B:105:0x0553), top: B:102:0x0547 }] */
    /* JADX WARN: Removed duplicated region for block: B:125:0x05d2 A[Catch: Exception -> 0x0607, TryCatch #12 {Exception -> 0x0607, blocks: (B:108:0x0577, B:110:0x0583, B:112:0x0589, B:114:0x0591, B:116:0x0599, B:119:0x05a2, B:121:0x0601, B:123:0x05c6, B:125:0x05d2, B:127:0x05e2), top: B:107:0x0577 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void asynAI() {
        /*
            Method dump skipped, instructions count: 1552
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.shuzilm.core.AIClient.asynAI():void");
    }

    public String cm(String str) {
        return j() ? a(f1628ab) : i() ? a(f1630ad) : str;
    }

    public boolean m(String str) {
        if (!str.equals(a(P)) && !str.equals(a(Q))) {
            return true;
        }
        try {
            return Class.forName(a(O)).newInstance() != null;
        } catch (Exception unused) {
            return false;
        }
    }
}
