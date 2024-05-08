package z5;

import android.net.Uri;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.offline.StreamKey;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/* compiled from: DashManifest.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public class c implements u5.d<c> {

    /* renamed from: a, reason: collision with root package name */
    public final long f54889a;

    /* renamed from: b, reason: collision with root package name */
    public final long f54890b;

    /* renamed from: c, reason: collision with root package name */
    public final long f54891c;

    /* renamed from: d, reason: collision with root package name */
    public final boolean f54892d;

    /* renamed from: e, reason: collision with root package name */
    public final long f54893e;

    /* renamed from: f, reason: collision with root package name */
    public final long f54894f;

    /* renamed from: g, reason: collision with root package name */
    public final long f54895g;

    /* renamed from: h, reason: collision with root package name */
    public final long f54896h;

    /* renamed from: i, reason: collision with root package name */
    @Nullable
    public final o f54897i;

    /* renamed from: j, reason: collision with root package name */
    @Nullable
    public final l f54898j;

    /* renamed from: k, reason: collision with root package name */
    @Nullable
    public final Uri f54899k;

    /* renamed from: l, reason: collision with root package name */
    @Nullable
    public final h f54900l;

    /* renamed from: m, reason: collision with root package name */
    public final List<g> f54901m;

    public c(long j10, long j11, long j12, boolean z10, long j13, long j14, long j15, long j16, @Nullable h hVar, @Nullable o oVar, @Nullable l lVar, @Nullable Uri uri, List<g> list) {
        this.f54889a = j10;
        this.f54890b = j11;
        this.f54891c = j12;
        this.f54892d = z10;
        this.f54893e = j13;
        this.f54894f = j14;
        this.f54895g = j15;
        this.f54896h = j16;
        this.f54900l = hVar;
        this.f54897i = oVar;
        this.f54899k = uri;
        this.f54898j = lVar;
        this.f54901m = list == null ? Collections.emptyList() : list;
    }

    public static ArrayList<a> c(List<a> list, LinkedList<StreamKey> linkedList) {
        StreamKey poll = linkedList.poll();
        int i10 = poll.f21019b;
        ArrayList<a> arrayList = new ArrayList<>();
        do {
            int i11 = poll.f21020c;
            a aVar = list.get(i11);
            List<j> list2 = aVar.f54881c;
            ArrayList arrayList2 = new ArrayList();
            do {
                arrayList2.add(list2.get(poll.f21021d));
                poll = linkedList.poll();
                if (poll.f21019b != i10) {
                    break;
                }
            } while (poll.f21020c == i11);
            arrayList.add(new a(aVar.f54879a, aVar.f54880b, arrayList2, aVar.f54882d, aVar.f54883e, aVar.f54884f));
        } while (poll.f21019b == i10);
        linkedList.addFirst(poll);
        return arrayList;
    }

    @Override // u5.d
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public final c a(List<StreamKey> list) {
        LinkedList linkedList = new LinkedList(list);
        Collections.sort(linkedList);
        linkedList.add(new StreamKey(-1, -1, -1));
        ArrayList arrayList = new ArrayList();
        long j10 = 0;
        int i10 = 0;
        while (true) {
            if (i10 >= e()) {
                break;
            }
            if (((StreamKey) linkedList.peek()).f21019b != i10) {
                long f10 = f(i10);
                if (f10 != -9223372036854775807L) {
                    j10 += f10;
                }
            } else {
                g d10 = d(i10);
                arrayList.add(new g(d10.f54922a, d10.f54923b - j10, c(d10.f54924c, linkedList), d10.f54925d));
            }
            i10++;
        }
        long j11 = this.f54890b;
        return new c(this.f54889a, j11 != -9223372036854775807L ? j11 - j10 : -9223372036854775807L, this.f54891c, this.f54892d, this.f54893e, this.f54894f, this.f54895g, this.f54896h, this.f54900l, this.f54897i, this.f54898j, this.f54899k, arrayList);
    }

    public final g d(int i10) {
        return this.f54901m.get(i10);
    }

    public final int e() {
        return this.f54901m.size();
    }

    public final long f(int i10) {
        if (i10 == this.f54901m.size() - 1) {
            long j10 = this.f54890b;
            if (j10 == -9223372036854775807L) {
                return -9223372036854775807L;
            }
            return j10 - this.f54901m.get(i10).f54923b;
        }
        return this.f54901m.get(i10 + 1).f54923b - this.f54901m.get(i10).f54923b;
    }

    public final long g(int i10) {
        return com.google.android.exoplayer2.h.d(f(i10));
    }
}
