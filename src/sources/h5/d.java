package h5;

import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.extractor.i;
import d5.o;

/* compiled from: StartOffsetExtractorOutput.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class d implements d5.e {

    /* renamed from: b, reason: collision with root package name */
    public final long f49517b;

    /* renamed from: c, reason: collision with root package name */
    public final d5.e f49518c;

    /* compiled from: StartOffsetExtractorOutput.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public class a implements i {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ i f49519a;

        public a(i iVar) {
            this.f49519a = iVar;
        }

        @Override // com.google.android.exoplayer2.extractor.i
        public i.a d(long j10) {
            i.a d10 = this.f49519a.d(j10);
            o oVar = d10.f20077a;
            o oVar2 = new o(oVar.f48644a, oVar.f48645b + d.this.f49517b);
            o oVar3 = d10.f20078b;
            return new i.a(oVar2, new o(oVar3.f48644a, oVar3.f48645b + d.this.f49517b));
        }

        @Override // com.google.android.exoplayer2.extractor.i
        public boolean e() {
            return this.f49519a.e();
        }

        @Override // com.google.android.exoplayer2.extractor.i
        public long i() {
            return this.f49519a.i();
        }
    }

    public d(long j10, d5.e eVar) {
        this.f49517b = j10;
        this.f49518c = eVar;
    }

    @Override // d5.e
    public TrackOutput c(int i10, int i11) {
        return this.f49518c.c(i10, i11);
    }

    @Override // d5.e
    public void l() {
        this.f49518c.l();
    }

    @Override // d5.e
    public void r(i iVar) {
        this.f49518c.r(new a(iVar));
    }
}
