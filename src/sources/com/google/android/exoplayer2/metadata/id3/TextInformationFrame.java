package com.google.android.exoplayer2.metadata.id3;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.android.internal.logging.nano.MetricsProto;
import com.google.android.exoplayer2.MediaMetadata;
import com.google.android.exoplayer2.util.j0;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.lang3.CharUtils;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class TextInformationFrame extends Id3Frame {
    public static final Parcelable.Creator<TextInformationFrame> CREATOR = new a();

    /* renamed from: c, reason: collision with root package name */
    @Nullable
    public final String f20914c;

    /* renamed from: d, reason: collision with root package name */
    public final String f20915d;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public class a implements Parcelable.Creator<TextInformationFrame> {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public TextInformationFrame createFromParcel(Parcel parcel) {
            return new TextInformationFrame(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public TextInformationFrame[] newArray(int i10) {
            return new TextInformationFrame[i10];
        }
    }

    public TextInformationFrame(String str, @Nullable String str2, String str3) {
        super(str);
        this.f20914c = str2;
        this.f20915d = str3;
    }

    public static List<Integer> a(String str) {
        ArrayList arrayList = new ArrayList();
        try {
            if (str.length() >= 10) {
                arrayList.add(Integer.valueOf(Integer.parseInt(str.substring(0, 4))));
                arrayList.add(Integer.valueOf(Integer.parseInt(str.substring(5, 7))));
                arrayList.add(Integer.valueOf(Integer.parseInt(str.substring(8, 10))));
            } else if (str.length() >= 7) {
                arrayList.add(Integer.valueOf(Integer.parseInt(str.substring(0, 4))));
                arrayList.add(Integer.valueOf(Integer.parseInt(str.substring(5, 7))));
            } else if (str.length() >= 4) {
                arrayList.add(Integer.valueOf(Integer.parseInt(str.substring(0, 4))));
            }
            return arrayList;
        } catch (NumberFormatException unused) {
            return new ArrayList();
        }
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || TextInformationFrame.class != obj.getClass()) {
            return false;
        }
        TextInformationFrame textInformationFrame = (TextInformationFrame) obj;
        return j0.c(this.f20903b, textInformationFrame.f20903b) && j0.c(this.f20914c, textInformationFrame.f20914c) && j0.c(this.f20915d, textInformationFrame.f20915d);
    }

    public int hashCode() {
        int hashCode = (MetricsProto.MetricsEvent.DIALOG_SUPPORT_PHONE + this.f20903b.hashCode()) * 31;
        String str = this.f20914c;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.f20915d;
        return hashCode2 + (str2 != null ? str2.hashCode() : 0);
    }

    @Override // com.google.android.exoplayer2.metadata.id3.Id3Frame, com.google.android.exoplayer2.metadata.Metadata.Entry
    public void populateMediaMetadata(MediaMetadata.Builder builder) {
        String str = this.f20903b;
        str.hashCode();
        char c4 = 65535;
        switch (str.hashCode()) {
            case 82815:
                if (str.equals("TAL")) {
                    c4 = 0;
                    break;
                }
                break;
            case 82878:
                if (str.equals("TCM")) {
                    c4 = 1;
                    break;
                }
                break;
            case 82897:
                if (str.equals("TDA")) {
                    c4 = 2;
                    break;
                }
                break;
            case 83253:
                if (str.equals("TP1")) {
                    c4 = 3;
                    break;
                }
                break;
            case 83254:
                if (str.equals("TP2")) {
                    c4 = 4;
                    break;
                }
                break;
            case 83255:
                if (str.equals("TP3")) {
                    c4 = 5;
                    break;
                }
                break;
            case 83341:
                if (str.equals("TRK")) {
                    c4 = 6;
                    break;
                }
                break;
            case 83378:
                if (str.equals("TT2")) {
                    c4 = 7;
                    break;
                }
                break;
            case 83536:
                if (str.equals("TXT")) {
                    c4 = '\b';
                    break;
                }
                break;
            case 83552:
                if (str.equals("TYE")) {
                    c4 = '\t';
                    break;
                }
                break;
            case 2567331:
                if (str.equals("TALB")) {
                    c4 = '\n';
                    break;
                }
                break;
            case 2569357:
                if (str.equals("TCOM")) {
                    c4 = 11;
                    break;
                }
                break;
            case 2569891:
                if (str.equals("TDAT")) {
                    c4 = '\f';
                    break;
                }
                break;
            case 2570401:
                if (str.equals("TDRC")) {
                    c4 = CharUtils.CR;
                    break;
                }
                break;
            case 2570410:
                if (str.equals("TDRL")) {
                    c4 = 14;
                    break;
                }
                break;
            case 2571565:
                if (str.equals("TEXT")) {
                    c4 = 15;
                    break;
                }
                break;
            case 2575251:
                if (str.equals("TIT2")) {
                    c4 = 16;
                    break;
                }
                break;
            case 2581512:
                if (str.equals("TPE1")) {
                    c4 = 17;
                    break;
                }
                break;
            case 2581513:
                if (str.equals("TPE2")) {
                    c4 = 18;
                    break;
                }
                break;
            case 2581514:
                if (str.equals("TPE3")) {
                    c4 = 19;
                    break;
                }
                break;
            case 2583398:
                if (str.equals("TRCK")) {
                    c4 = 20;
                    break;
                }
                break;
            case 2590194:
                if (str.equals("TYER")) {
                    c4 = 21;
                    break;
                }
                break;
        }
        try {
            switch (c4) {
                case 0:
                case '\n':
                    builder.K(this.f20915d);
                    return;
                case 1:
                case 11:
                    builder.M(this.f20915d);
                    return;
                case 2:
                case '\f':
                    builder.Q(Integer.valueOf(Integer.parseInt(this.f20915d.substring(2, 4)))).P(Integer.valueOf(Integer.parseInt(this.f20915d.substring(0, 2))));
                    return;
                case 3:
                case 17:
                    builder.L(this.f20915d);
                    return;
                case 4:
                case 18:
                    builder.J(this.f20915d);
                    return;
                case 5:
                case 19:
                    builder.N(this.f20915d);
                    return;
                case 6:
                case 20:
                    String[] M0 = j0.M0(this.f20915d, "/");
                    builder.X(Integer.valueOf(Integer.parseInt(M0[0]))).W(M0.length > 1 ? Integer.valueOf(Integer.parseInt(M0[1])) : null);
                    return;
                case 7:
                case 16:
                    builder.V(this.f20915d);
                    return;
                case '\b':
                case 15:
                    builder.Y(this.f20915d);
                    return;
                case '\t':
                case 21:
                    builder.R(Integer.valueOf(Integer.parseInt(this.f20915d)));
                    return;
                case '\r':
                    List<Integer> a10 = a(this.f20915d);
                    int size = a10.size();
                    if (size != 1) {
                        if (size != 2) {
                            if (size != 3) {
                                return;
                            } else {
                                builder.P(a10.get(2));
                            }
                        }
                        builder.Q(a10.get(1));
                    }
                    builder.R(a10.get(0));
                    return;
                case 14:
                    List<Integer> a11 = a(this.f20915d);
                    int size2 = a11.size();
                    if (size2 != 1) {
                        if (size2 != 2) {
                            if (size2 != 3) {
                                return;
                            } else {
                                builder.S(a11.get(2));
                            }
                        }
                        builder.T(a11.get(1));
                    }
                    builder.U(a11.get(0));
                    return;
                default:
                    return;
            }
        } catch (NumberFormatException | StringIndexOutOfBoundsException unused) {
        }
    }

    @Override // com.google.android.exoplayer2.metadata.id3.Id3Frame
    public String toString() {
        String str = this.f20903b;
        String str2 = this.f20914c;
        String str3 = this.f20915d;
        StringBuilder sb2 = new StringBuilder(String.valueOf(str).length() + 22 + String.valueOf(str2).length() + String.valueOf(str3).length());
        sb2.append(str);
        sb2.append(": description=");
        sb2.append(str2);
        sb2.append(": value=");
        sb2.append(str3);
        return sb2.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeString(this.f20903b);
        parcel.writeString(this.f20914c);
        parcel.writeString(this.f20915d);
    }

    public TextInformationFrame(Parcel parcel) {
        super((String) j0.j(parcel.readString()));
        this.f20914c = parcel.readString();
        this.f20915d = (String) j0.j(parcel.readString());
    }
}
