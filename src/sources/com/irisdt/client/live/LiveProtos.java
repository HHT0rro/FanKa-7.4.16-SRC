package com.irisdt.client.live;

import com.android.internal.logging.nano.MetricsProto;
import com.google.android.material.shadow.ShadowDrawableWrapper;
import com.google.protobuf.AbstractMessage;
import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.AbstractParser;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.Descriptors;
import com.google.protobuf.ExtensionRegistry;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageV3;
import com.google.protobuf.Internal;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Message;
import com.google.protobuf.MessageOrBuilder;
import com.google.protobuf.Parser;
import com.google.protobuf.ProtocolMessageEnum;
import com.google.protobuf.UnknownFieldSet;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Objects;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public final class LiveProtos {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0010LiveProtos.proto\u0012\u0016com.irisdt.client.live\"ê\u0006\n\tLiveProto\u0012,\n\u0005event\u0018\u0001 \u0001(\u000e2\u001d.com.irisdt.client.live.Event\u0012*\n\u0004type\u0018\u0002 \u0001(\u000e2\u001c.com.irisdt.client.live.Type\u0012\u000f\n\u0007live_id\u0018\u0003 \u0001(\t\u0012\u0012\n\nanchor_uid\u0018\u0004 \u0001(\t\u0012\u000b\n\u0003num\u0018\u0005 \u0001(\u0005\u0012\n\n\u0002id\u0018\u0006 \u0001(\t\u0012\u000f\n\u0007is_true\u0018\u0007 \u0001(\b\u0012\f\n\u0004time\u0018\b \u0001(\u0005\u0012\r\n\u0005worth\u0018\t \u0001(\u0002\u0012\u000f\n\u0007content\u0018\n \u0001(\t\u0012\f\n\u0004from\u0018\u000b \u0001(\t\u0012\r\n\u0005count\u0018\f \u0001(\u0005\u0012\r\n\u0005level\u0018\r \u0001(\u0005\u0012\r\n\u0005scene\u0018\u000e \u0001(\t\u0012\u000f\n\u0007is_bool\u0018\u000f \u0001(\b\u0012.\n\u0006result\u0018\u0010 \u0001(\u000e2\u001e.com.irisdt.client.live.Result\u0012\u000e\n\u0006status\u0018\u0011 \u0001(\t\u0012\u000e\n\u0006source\u0018\u0012 \u0001(\t\u00125\n\ncover_type\u0018\u0013 \u0001(\u000e2!.com.irisdt.client.live.CoverType\u0012\u0010\n\btag_type\u0018\u0014 \u0001(\t\u0012\u0011\n\tuser_type\u0018\u0015 \u0001(\t\u0012\r\n\u0005score\u0018\u0016 \u0001(\u0001\u0012\r\n\u0005title\u0018\u0017 \u0001(\t\u0012\f\n\u0004name\u0018\u0018 \u0001(\t\u0012\u0014\n\fconnect_type\u0018\u0019 \u0001(\t\u0012\u0010\n\buser_tag\u0018\u001a \u0001(\t\u0012\u0012\n\ntarget_uid\u0018\u001b \u0001(\t\u0012\u0014\n\fis_live_show\u0018\u001c \u0001(\b\u0012\u0013\n\u000bis_treasure\u0018\u001d \u0001(\b\u0012\u0015\n\ris_red_packet\u0018\u001e \u0001(\b\u0012\u0016\n\u000eis_live_window\u0018\u001f \u0001(\b\u0012\u0017\n\u000fred_packet_type\u0018  \u0001(\t\u0012\u0012\n\nis_trigger\u0018! \u0001(\b\u0012\r\n\u0005times\u0018\" \u0001(\u0005\u0012\u0016\n\u000eactivity_first\u0018# \u0001(\t\u0012\u0017\n\u000factivity_second\u0018$ \u0001(\t\u0012\r\n\u0005index\u0018% \u0001(\u0005\u0012\u000b\n\u0003sku\u0018& \u0001(\t\u0012\u0010\n\bis_first\u0018' \u0001(\b\u0012\r\n\u0005grade\u0018( \u0001(\t\u0012\u000e\n\u0006reason\u0018) \u0001(\t\u0012\u0012\n\nrequest_id\u0018* \u0001(\t*©\u000b\n\u0005Event\u0012\u0011\n\rUNKNOWN_EVENT\u0010\u0000\u0012\u0012\n\u000eLIVE_PAGE_SHOW\u0010\u0001\u0012\u0012\n\u000eLIVE_ROOM_DRAW\u0010\u0002\u0012\u0013\n\u000fLIVE_ROOM_ENTER\u0010\u0003\u0012\u0012\n\u000eLIVE_ROOM_EXIT\u0010\u0004\u0012\u0017\n\u0013LIVE_ROOM_BTN_CLICK\u0010\u0005\u0012\u001d\n\u0019LIVE_ROOM_COMMENT_SUCCESS\u0010\u0006\u0012\u0017\n\u0013LIVE_ROOM_GIFT_SHOW\u0010\u0007\u0012\u001f\n\u001bLIVE_ROOM_GIFT_SEND_SUCCESS\u0010\b\u0012\u001c\n\u0018LIVE_ROOM_CONNECT_LAUNCH\u0010\t\u0012\u001d\n\u0019LIVE_ROOM_CONNECT_SUCCESS\u0010\n\u0012\u0019\n\u0015LIVE_ROOM_CONNECT_END\u0010\u000b\u0012\u0018\n\u0014LIVE_PAGE_OPEN_CLICK\u0010\f\u0012\u0019\n\u0015LIVE_PAGE_START_CLICK\u0010\r\u0012\u001b\n\u0017LIVE_PAGE_START_SUCCESS\u0010\u000e\u0012\u0013\n\u000fLIVE_ROOM_CLOSE\u0010\u000f\u0012\u0014\n\u0010PK_MATCH_SUCCESS\u0010\u0010\u0012\r\n\tPK_FINISH\u0010\u0011\u0012\u0013\n\u000fPK_FINISH_CLICK\u0010\u0012\u0012\u0014\n\u0010ANCHOR_HEARTBEAT\u0010\u0013\u0012\u0016\n\u0012AUDIENCE_HEARTBEAT\u0010\u0014\u0012\r\n\tLAUNCH_PK\u0010\u0015\u0012\u001a\n\u0016ANCHOR_FANS_GROUP_SHOW\u0010\u0018\u0012\u0018\n\u0014LIVE_ROOM_GUIDE_SHOW\u0010\u0019\u0012\u0019\n\u0015LIVE_ROOM_GUIDE_CLICK\u0010\u001a\u0012\u001e\n\u001aLIVE_ROOM_QUICK_CHAT_CLICK\u0010\u001b\u0012\u001d\n\u0019LIVE_PAGE_OPEN_MENU_CLICK\u0010\u001c\u0012\u0019\n\u0015LIVE_PAGE_TOTAL_CLICK\u0010\u001d\u0012\u001e\n\u001aLIVE_PAGE_TOTAL_MENU_CLICK\u0010\u001e\u0012\u0016\n\u0012LIVE_CONNECT_APPLY\u0010\u001f\u0012\u0018\n\u0014LIVE_CONNECT_SUCCESS\u0010 \u0012\u0014\n\u0010LIVE_CONNECT_END\u0010!\u0012\u0013\n\u000fLIVE_POPUP_SHOW\u0010\"\u0012\u0014\n\u0010LIVE_POPUP_CLICK\u0010#\u0012\u0015\n\u0011IN_LIVE_ROOM_SHOW\u0010$\u0012\u0017\n\u0013LIVE_PROP_USE_CLICK\u0010%\u0012\u0019\n\u0015LIVE_BEAUTY_ITEM_SHOW\u0010&\u0012$\n LIVE_BEAUTY_FUNCTION_USE_SUCCESS\u0010'\u0012\u0012\n\u000eLIVE_GIFT_SHOW\u0010(\u0012\u001b\n\u0017LIVE_PASTER_USE_SUCCESS\u0010)\u0012\u0018\n\u0014TEENAGER_MODE_SWITCH\u0010*\u0012\u001c\n\u0018LIVE_PAGE_ACTIVITY_CLICK\u0010+\u0012\u001b\n\u0017LIVE_PAGE_ACTIVITY_SAVE\u0010,\u0012\u0019\n\u0015GIFT_RECHARGE_SUCCESS\u0010-\u0012\u0015\n\u0011CONSULT_ROOM_DRAW\u0010.\u0012\u0016\n\u0012CONSULT_ROOM_ENTER\u0010/\u0012\u0015\n\u0011CONSULT_ROOM_EXIT\u00100\u0012\u001a\n\u0016CONSULT_ROOM_BTN_CLICK\u00101\u0012\u001f\n\u001bCONSULT_ROOM_CONNECT_LAUNCH\u00102\u0012 \n\u001cCONSULT_ROOM_CONNECT_SUCCESS\u00103\u0012\u001c\n\u0018CONSULT_ROOM_CONNECT_END\u00104\u0012\"\n\u001eCONSULT_ROOM_DEDUCTION_REQUEST\u00105\u0012\u0018\n\u0014INVITE_JOIN_MULTI_PK\u00106\u0012\u001a\n\u0016ACCEPT_INVITE_MULTI_PK\u00107\u0012\u0012\n\u000eMULTI_PK_START\u00108\u0012\u0013\n\u000fMULTI_PK_FINISH\u00109*ç\u0007\n\u0004Type\u0012\u0010\n\fUNKNOWN_TYPE\u0010\u0000\u0012\u0007\n\u0003HOT\u0010\u0001\u0012\n\n\u0006NEARBY\u0010\u0002\u0012\u0007\n\u0003NEW\u0010\u0003\u0012\u000b\n\u0007COMMENT\u0010\u0004\u0012\b\n\u0004GIFT\u0010\u0005\u0012\u000b\n\u0007CONNECT\u0010\u0006\u0012\u0006\n\u0002PK\u0010\u0007\u0012\n\n\u0006BEAUTY\u0010\b\u0012\n\n\u0006MIRROR\u0010\t\u0012\b\n\u0004MORE\u0010\n\u0012\u000b\n\u0007REVERSE\u0010\u000b\u0012\u0012\n\u000eCOMMON_COMMENT\u0010\f\u0012\u0011\n\rBULLET_COMMET\u0010\r\u0012\u000e\n\nGIFT_DAILY\u0010\u000e\u0012\u000e\n\nGIFT_LEVEL\u0010\u000f\u0012\r\n\tGIFT_MADE\u0010\u0010\u0012\n\n\u0006FOLLOW\u0010\u0011\u0012\r\n\tRECOMMEND\u0010\u0012\u0012\u0010\n\fRANDOM_MATCH\u0010\u0013\u0012\f\n\bSTART_PK\u0010\u0014\u0012\r\n\tACCEPT_PK\u0010\u0015\u0012\n\n\u0006PK_ING\u0010\u0016\u0012\u000e\n\nPUNISHMENT\u0010\u0017\u0012\u000b\n\u0007CONTENT\u0010\u0018\u0012\u000e\n\nFANS_GROUP\u0010\u0019\u0012\r\n\tLUCK_DRAW\u0010\u001a\u0012\u0010\n\fCOMMENT_GIFT\u0010\u001b\u0012\u0010\n\fDISPLAY_GIFT\u0010\u001c\u0012\u0018\n\u0014COMMENT_FOLLOW_GUIDE\u0010\u001d\u0012\u0017\n\u0013BOTTOM_FOLLOW_GUIDE\u0010\u001e\u0012\u000e\n\nCHAT_GUIDE\u0010\u001f\u0012\u000e\n\nGIFT_GUIDE\u0010 \u0012\u0012\n\u000eTOP_FANS_GROUP\u0010!\u0012\u0012\n\u000eTOP_RED_PACKET\u0010\"\u0012\u0015\n\u0011BOTTOM_RED_PACKET\u0010#\u0012\u0013\n\u000fMORE_RED_PACKET\u0010$\u0012\u000f\n\u000bNEW_CONNECT\u0010%\u0012\u0019\n\u0015MORE_COLLECT_FRAGMENT\u0010&\u0012\u001d\n\u0019PACKSACK_COLLECT_FRAGMENT\u0010'\u0012\u000f\n\u000bANCHOR_TASK\u0010(\u0012\r\n\tPRIVILEGE\u0010)\u0012\u0016\n\u0012MORE_DRESS_UP_MALL\u0010*\u0012\u0014\n\u0010MORE_MY_DRESS_UP\u0010+\u0012\u0011\n\rMORE_NOBILITY\u0010,\u0012\u0011\n\rGIFT_NOBILITY\u0010-\u0012 \n\u001cNOBILITY_FREE_BULLET_COMMENT\u0010.\u0012\u000f\n\u000bMORE_PASTER\u0010/\u0012\u0012\n\u000eMORE_GIFT_WALL\u00100\u0012\u000f\n\u000bMORE_FOLLOW\u00101\u0012\u0015\n\u0011FOLLOW_COUNT_DOWN\u00102\u0012\f\n\bMULTI_PK\u00103\u0012\u0012\n\u000eSTART_MULTI_PK\u00104\u0012\u0017\n\u0013MULTI_PK_PUNISHMENT\u00105\u0012\u000b\n\u0007SILENCE\u00106\u0012\u0013\n\u000fACCEPT_MULTI_PK\u00107\u0012\u0016\n\u0012MULTI_BEFORE_START\u00108*=\n\u0006Result\u0012\u0012\n\u000eUNKNOWN_RESULT\u0010\u0000\u0012\u000b\n\u0007SUCCESS\u0010\u0001\u0012\b\n\u0004FAIL\u0010\u0002\u0012\b\n\u0004DRAW\u0010\u0003*L\n\tCoverType\u0012\u0016\n\u0012UNKNOWN_COVER_TYPE\u0010\u0000\u0012\u000b\n\u0007WITHOUT\u0010\u0001\u0012\b\n\u0004WITH\u0010\u0002\u0012\u0010\n\fHIGH_QUALITY\u0010\u0003B\u0007¢\u0002\u0004LIVEb\u0006proto3"}, new Descriptors.FileDescriptor[0]);
    private static final Descriptors.Descriptor internal_static_com_irisdt_client_live_LiveProto_descriptor;
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_com_irisdt_client_live_LiveProto_fieldAccessorTable;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public enum CoverType implements ProtocolMessageEnum {
        UNKNOWN_COVER_TYPE(0),
        WITHOUT(1),
        WITH(2),
        HIGH_QUALITY(3),
        UNRECOGNIZED(-1);

        public static final int HIGH_QUALITY_VALUE = 3;
        public static final int UNKNOWN_COVER_TYPE_VALUE = 0;
        public static final int WITHOUT_VALUE = 1;
        public static final int WITH_VALUE = 2;
        private final int value;
        private static final Internal.EnumLiteMap<CoverType> internalValueMap = new Internal.EnumLiteMap<CoverType>() { // from class: com.irisdt.client.live.LiveProtos.CoverType.1
            @Override // com.google.protobuf.Internal.EnumLiteMap
            public CoverType findValueByNumber(int i10) {
                return CoverType.forNumber(i10);
            }
        };
        private static final CoverType[] VALUES = values();

        CoverType(int i10) {
            this.value = i10;
        }

        public static CoverType forNumber(int i10) {
            if (i10 == 0) {
                return UNKNOWN_COVER_TYPE;
            }
            if (i10 == 1) {
                return WITHOUT;
            }
            if (i10 == 2) {
                return WITH;
            }
            if (i10 != 3) {
                return null;
            }
            return HIGH_QUALITY;
        }

        public static final Descriptors.EnumDescriptor getDescriptor() {
            return LiveProtos.getDescriptor().getEnumTypes().get(3);
        }

        public static Internal.EnumLiteMap<CoverType> internalGetValueMap() {
            return internalValueMap;
        }

        @Override // com.google.protobuf.ProtocolMessageEnum
        public final Descriptors.EnumDescriptor getDescriptorForType() {
            return getDescriptor();
        }

        @Override // com.google.protobuf.ProtocolMessageEnum, com.google.protobuf.Internal.EnumLite
        public final int getNumber() {
            if (this != UNRECOGNIZED) {
                return this.value;
            }
            throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
        }

        @Override // com.google.protobuf.ProtocolMessageEnum
        public final Descriptors.EnumValueDescriptor getValueDescriptor() {
            if (this != UNRECOGNIZED) {
                return getDescriptor().getValues().get(ordinal());
            }
            throw new IllegalStateException("Can't get the descriptor of an unrecognized enum value.");
        }

        @Deprecated
        public static CoverType valueOf(int i10) {
            return forNumber(i10);
        }

        public static CoverType valueOf(Descriptors.EnumValueDescriptor enumValueDescriptor) {
            if (enumValueDescriptor.getType() == getDescriptor()) {
                if (enumValueDescriptor.getIndex() == -1) {
                    return UNRECOGNIZED;
                }
                return VALUES[enumValueDescriptor.getIndex()];
            }
            throw new IllegalArgumentException("EnumValueDescriptor is not for this type.");
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public enum Event implements ProtocolMessageEnum {
        UNKNOWN_EVENT(0),
        LIVE_PAGE_SHOW(1),
        LIVE_ROOM_DRAW(2),
        LIVE_ROOM_ENTER(3),
        LIVE_ROOM_EXIT(4),
        LIVE_ROOM_BTN_CLICK(5),
        LIVE_ROOM_COMMENT_SUCCESS(6),
        LIVE_ROOM_GIFT_SHOW(7),
        LIVE_ROOM_GIFT_SEND_SUCCESS(8),
        LIVE_ROOM_CONNECT_LAUNCH(9),
        LIVE_ROOM_CONNECT_SUCCESS(10),
        LIVE_ROOM_CONNECT_END(11),
        LIVE_PAGE_OPEN_CLICK(12),
        LIVE_PAGE_START_CLICK(13),
        LIVE_PAGE_START_SUCCESS(14),
        LIVE_ROOM_CLOSE(15),
        PK_MATCH_SUCCESS(16),
        PK_FINISH(17),
        PK_FINISH_CLICK(18),
        ANCHOR_HEARTBEAT(19),
        AUDIENCE_HEARTBEAT(20),
        LAUNCH_PK(21),
        ANCHOR_FANS_GROUP_SHOW(24),
        LIVE_ROOM_GUIDE_SHOW(25),
        LIVE_ROOM_GUIDE_CLICK(26),
        LIVE_ROOM_QUICK_CHAT_CLICK(27),
        LIVE_PAGE_OPEN_MENU_CLICK(28),
        LIVE_PAGE_TOTAL_CLICK(29),
        LIVE_PAGE_TOTAL_MENU_CLICK(30),
        LIVE_CONNECT_APPLY(31),
        LIVE_CONNECT_SUCCESS(32),
        LIVE_CONNECT_END(33),
        LIVE_POPUP_SHOW(34),
        LIVE_POPUP_CLICK(35),
        IN_LIVE_ROOM_SHOW(36),
        LIVE_PROP_USE_CLICK(37),
        LIVE_BEAUTY_ITEM_SHOW(38),
        LIVE_BEAUTY_FUNCTION_USE_SUCCESS(39),
        LIVE_GIFT_SHOW(40),
        LIVE_PASTER_USE_SUCCESS(41),
        TEENAGER_MODE_SWITCH(42),
        LIVE_PAGE_ACTIVITY_CLICK(43),
        LIVE_PAGE_ACTIVITY_SAVE(44),
        GIFT_RECHARGE_SUCCESS(45),
        CONSULT_ROOM_DRAW(46),
        CONSULT_ROOM_ENTER(47),
        CONSULT_ROOM_EXIT(48),
        CONSULT_ROOM_BTN_CLICK(49),
        CONSULT_ROOM_CONNECT_LAUNCH(50),
        CONSULT_ROOM_CONNECT_SUCCESS(51),
        CONSULT_ROOM_CONNECT_END(52),
        CONSULT_ROOM_DEDUCTION_REQUEST(53),
        INVITE_JOIN_MULTI_PK(54),
        ACCEPT_INVITE_MULTI_PK(55),
        MULTI_PK_START(56),
        MULTI_PK_FINISH(57),
        UNRECOGNIZED(-1);

        public static final int ACCEPT_INVITE_MULTI_PK_VALUE = 55;
        public static final int ANCHOR_FANS_GROUP_SHOW_VALUE = 24;
        public static final int ANCHOR_HEARTBEAT_VALUE = 19;
        public static final int AUDIENCE_HEARTBEAT_VALUE = 20;
        public static final int CONSULT_ROOM_BTN_CLICK_VALUE = 49;
        public static final int CONSULT_ROOM_CONNECT_END_VALUE = 52;
        public static final int CONSULT_ROOM_CONNECT_LAUNCH_VALUE = 50;
        public static final int CONSULT_ROOM_CONNECT_SUCCESS_VALUE = 51;
        public static final int CONSULT_ROOM_DEDUCTION_REQUEST_VALUE = 53;
        public static final int CONSULT_ROOM_DRAW_VALUE = 46;
        public static final int CONSULT_ROOM_ENTER_VALUE = 47;
        public static final int CONSULT_ROOM_EXIT_VALUE = 48;
        public static final int GIFT_RECHARGE_SUCCESS_VALUE = 45;
        public static final int INVITE_JOIN_MULTI_PK_VALUE = 54;
        public static final int IN_LIVE_ROOM_SHOW_VALUE = 36;
        public static final int LAUNCH_PK_VALUE = 21;
        public static final int LIVE_BEAUTY_FUNCTION_USE_SUCCESS_VALUE = 39;
        public static final int LIVE_BEAUTY_ITEM_SHOW_VALUE = 38;
        public static final int LIVE_CONNECT_APPLY_VALUE = 31;
        public static final int LIVE_CONNECT_END_VALUE = 33;
        public static final int LIVE_CONNECT_SUCCESS_VALUE = 32;
        public static final int LIVE_GIFT_SHOW_VALUE = 40;
        public static final int LIVE_PAGE_ACTIVITY_CLICK_VALUE = 43;
        public static final int LIVE_PAGE_ACTIVITY_SAVE_VALUE = 44;
        public static final int LIVE_PAGE_OPEN_CLICK_VALUE = 12;
        public static final int LIVE_PAGE_OPEN_MENU_CLICK_VALUE = 28;
        public static final int LIVE_PAGE_SHOW_VALUE = 1;
        public static final int LIVE_PAGE_START_CLICK_VALUE = 13;
        public static final int LIVE_PAGE_START_SUCCESS_VALUE = 14;
        public static final int LIVE_PAGE_TOTAL_CLICK_VALUE = 29;
        public static final int LIVE_PAGE_TOTAL_MENU_CLICK_VALUE = 30;
        public static final int LIVE_PASTER_USE_SUCCESS_VALUE = 41;
        public static final int LIVE_POPUP_CLICK_VALUE = 35;
        public static final int LIVE_POPUP_SHOW_VALUE = 34;
        public static final int LIVE_PROP_USE_CLICK_VALUE = 37;
        public static final int LIVE_ROOM_BTN_CLICK_VALUE = 5;
        public static final int LIVE_ROOM_CLOSE_VALUE = 15;
        public static final int LIVE_ROOM_COMMENT_SUCCESS_VALUE = 6;
        public static final int LIVE_ROOM_CONNECT_END_VALUE = 11;
        public static final int LIVE_ROOM_CONNECT_LAUNCH_VALUE = 9;
        public static final int LIVE_ROOM_CONNECT_SUCCESS_VALUE = 10;
        public static final int LIVE_ROOM_DRAW_VALUE = 2;
        public static final int LIVE_ROOM_ENTER_VALUE = 3;
        public static final int LIVE_ROOM_EXIT_VALUE = 4;
        public static final int LIVE_ROOM_GIFT_SEND_SUCCESS_VALUE = 8;
        public static final int LIVE_ROOM_GIFT_SHOW_VALUE = 7;
        public static final int LIVE_ROOM_GUIDE_CLICK_VALUE = 26;
        public static final int LIVE_ROOM_GUIDE_SHOW_VALUE = 25;
        public static final int LIVE_ROOM_QUICK_CHAT_CLICK_VALUE = 27;
        public static final int MULTI_PK_FINISH_VALUE = 57;
        public static final int MULTI_PK_START_VALUE = 56;
        public static final int PK_FINISH_CLICK_VALUE = 18;
        public static final int PK_FINISH_VALUE = 17;
        public static final int PK_MATCH_SUCCESS_VALUE = 16;
        public static final int TEENAGER_MODE_SWITCH_VALUE = 42;
        public static final int UNKNOWN_EVENT_VALUE = 0;
        private final int value;
        private static final Internal.EnumLiteMap<Event> internalValueMap = new Internal.EnumLiteMap<Event>() { // from class: com.irisdt.client.live.LiveProtos.Event.1
            @Override // com.google.protobuf.Internal.EnumLiteMap
            public Event findValueByNumber(int i10) {
                return Event.forNumber(i10);
            }
        };
        private static final Event[] VALUES = values();

        Event(int i10) {
            this.value = i10;
        }

        public static Event forNumber(int i10) {
            switch (i10) {
                case 0:
                    return UNKNOWN_EVENT;
                case 1:
                    return LIVE_PAGE_SHOW;
                case 2:
                    return LIVE_ROOM_DRAW;
                case 3:
                    return LIVE_ROOM_ENTER;
                case 4:
                    return LIVE_ROOM_EXIT;
                case 5:
                    return LIVE_ROOM_BTN_CLICK;
                case 6:
                    return LIVE_ROOM_COMMENT_SUCCESS;
                case 7:
                    return LIVE_ROOM_GIFT_SHOW;
                case 8:
                    return LIVE_ROOM_GIFT_SEND_SUCCESS;
                case 9:
                    return LIVE_ROOM_CONNECT_LAUNCH;
                case 10:
                    return LIVE_ROOM_CONNECT_SUCCESS;
                case 11:
                    return LIVE_ROOM_CONNECT_END;
                case 12:
                    return LIVE_PAGE_OPEN_CLICK;
                case 13:
                    return LIVE_PAGE_START_CLICK;
                case 14:
                    return LIVE_PAGE_START_SUCCESS;
                case 15:
                    return LIVE_ROOM_CLOSE;
                case 16:
                    return PK_MATCH_SUCCESS;
                case 17:
                    return PK_FINISH;
                case 18:
                    return PK_FINISH_CLICK;
                case 19:
                    return ANCHOR_HEARTBEAT;
                case 20:
                    return AUDIENCE_HEARTBEAT;
                case 21:
                    return LAUNCH_PK;
                case 22:
                case 23:
                default:
                    return null;
                case 24:
                    return ANCHOR_FANS_GROUP_SHOW;
                case 25:
                    return LIVE_ROOM_GUIDE_SHOW;
                case 26:
                    return LIVE_ROOM_GUIDE_CLICK;
                case 27:
                    return LIVE_ROOM_QUICK_CHAT_CLICK;
                case 28:
                    return LIVE_PAGE_OPEN_MENU_CLICK;
                case 29:
                    return LIVE_PAGE_TOTAL_CLICK;
                case 30:
                    return LIVE_PAGE_TOTAL_MENU_CLICK;
                case 31:
                    return LIVE_CONNECT_APPLY;
                case 32:
                    return LIVE_CONNECT_SUCCESS;
                case 33:
                    return LIVE_CONNECT_END;
                case 34:
                    return LIVE_POPUP_SHOW;
                case 35:
                    return LIVE_POPUP_CLICK;
                case 36:
                    return IN_LIVE_ROOM_SHOW;
                case 37:
                    return LIVE_PROP_USE_CLICK;
                case 38:
                    return LIVE_BEAUTY_ITEM_SHOW;
                case 39:
                    return LIVE_BEAUTY_FUNCTION_USE_SUCCESS;
                case 40:
                    return LIVE_GIFT_SHOW;
                case 41:
                    return LIVE_PASTER_USE_SUCCESS;
                case 42:
                    return TEENAGER_MODE_SWITCH;
                case 43:
                    return LIVE_PAGE_ACTIVITY_CLICK;
                case 44:
                    return LIVE_PAGE_ACTIVITY_SAVE;
                case 45:
                    return GIFT_RECHARGE_SUCCESS;
                case 46:
                    return CONSULT_ROOM_DRAW;
                case 47:
                    return CONSULT_ROOM_ENTER;
                case 48:
                    return CONSULT_ROOM_EXIT;
                case 49:
                    return CONSULT_ROOM_BTN_CLICK;
                case 50:
                    return CONSULT_ROOM_CONNECT_LAUNCH;
                case 51:
                    return CONSULT_ROOM_CONNECT_SUCCESS;
                case 52:
                    return CONSULT_ROOM_CONNECT_END;
                case 53:
                    return CONSULT_ROOM_DEDUCTION_REQUEST;
                case 54:
                    return INVITE_JOIN_MULTI_PK;
                case 55:
                    return ACCEPT_INVITE_MULTI_PK;
                case 56:
                    return MULTI_PK_START;
                case 57:
                    return MULTI_PK_FINISH;
            }
        }

        public static final Descriptors.EnumDescriptor getDescriptor() {
            return LiveProtos.getDescriptor().getEnumTypes().get(0);
        }

        public static Internal.EnumLiteMap<Event> internalGetValueMap() {
            return internalValueMap;
        }

        @Override // com.google.protobuf.ProtocolMessageEnum
        public final Descriptors.EnumDescriptor getDescriptorForType() {
            return getDescriptor();
        }

        @Override // com.google.protobuf.ProtocolMessageEnum, com.google.protobuf.Internal.EnumLite
        public final int getNumber() {
            if (this != UNRECOGNIZED) {
                return this.value;
            }
            throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
        }

        @Override // com.google.protobuf.ProtocolMessageEnum
        public final Descriptors.EnumValueDescriptor getValueDescriptor() {
            if (this != UNRECOGNIZED) {
                return getDescriptor().getValues().get(ordinal());
            }
            throw new IllegalStateException("Can't get the descriptor of an unrecognized enum value.");
        }

        @Deprecated
        public static Event valueOf(int i10) {
            return forNumber(i10);
        }

        public static Event valueOf(Descriptors.EnumValueDescriptor enumValueDescriptor) {
            if (enumValueDescriptor.getType() == getDescriptor()) {
                if (enumValueDescriptor.getIndex() == -1) {
                    return UNRECOGNIZED;
                }
                return VALUES[enumValueDescriptor.getIndex()];
            }
            throw new IllegalArgumentException("EnumValueDescriptor is not for this type.");
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public static final class LiveProto extends GeneratedMessageV3 implements LiveProtoOrBuilder {
        public static final int ACTIVITY_FIRST_FIELD_NUMBER = 35;
        public static final int ACTIVITY_SECOND_FIELD_NUMBER = 36;
        public static final int ANCHOR_UID_FIELD_NUMBER = 4;
        public static final int CONNECT_TYPE_FIELD_NUMBER = 25;
        public static final int CONTENT_FIELD_NUMBER = 10;
        public static final int COUNT_FIELD_NUMBER = 12;
        public static final int COVER_TYPE_FIELD_NUMBER = 19;
        public static final int EVENT_FIELD_NUMBER = 1;
        public static final int FROM_FIELD_NUMBER = 11;
        public static final int GRADE_FIELD_NUMBER = 40;
        public static final int ID_FIELD_NUMBER = 6;
        public static final int INDEX_FIELD_NUMBER = 37;
        public static final int IS_BOOL_FIELD_NUMBER = 15;
        public static final int IS_FIRST_FIELD_NUMBER = 39;
        public static final int IS_LIVE_SHOW_FIELD_NUMBER = 28;
        public static final int IS_LIVE_WINDOW_FIELD_NUMBER = 31;
        public static final int IS_RED_PACKET_FIELD_NUMBER = 30;
        public static final int IS_TREASURE_FIELD_NUMBER = 29;
        public static final int IS_TRIGGER_FIELD_NUMBER = 33;
        public static final int IS_TRUE_FIELD_NUMBER = 7;
        public static final int LEVEL_FIELD_NUMBER = 13;
        public static final int LIVE_ID_FIELD_NUMBER = 3;
        public static final int NAME_FIELD_NUMBER = 24;
        public static final int NUM_FIELD_NUMBER = 5;
        public static final int REASON_FIELD_NUMBER = 41;
        public static final int RED_PACKET_TYPE_FIELD_NUMBER = 32;
        public static final int REQUEST_ID_FIELD_NUMBER = 42;
        public static final int RESULT_FIELD_NUMBER = 16;
        public static final int SCENE_FIELD_NUMBER = 14;
        public static final int SCORE_FIELD_NUMBER = 22;
        public static final int SKU_FIELD_NUMBER = 38;
        public static final int SOURCE_FIELD_NUMBER = 18;
        public static final int STATUS_FIELD_NUMBER = 17;
        public static final int TAG_TYPE_FIELD_NUMBER = 20;
        public static final int TARGET_UID_FIELD_NUMBER = 27;
        public static final int TIMES_FIELD_NUMBER = 34;
        public static final int TIME_FIELD_NUMBER = 8;
        public static final int TITLE_FIELD_NUMBER = 23;
        public static final int TYPE_FIELD_NUMBER = 2;
        public static final int USER_TAG_FIELD_NUMBER = 26;
        public static final int USER_TYPE_FIELD_NUMBER = 21;
        public static final int WORTH_FIELD_NUMBER = 9;
        private static final long serialVersionUID = 0;
        private volatile Object activityFirst_;
        private volatile Object activitySecond_;
        private volatile Object anchorUid_;
        private volatile Object connectType_;
        private volatile Object content_;
        private int count_;
        private int coverType_;
        private int event_;
        private volatile Object from_;
        private volatile Object grade_;
        private volatile Object id_;
        private int index_;
        private boolean isBool_;
        private boolean isFirst_;
        private boolean isLiveShow_;
        private boolean isLiveWindow_;
        private boolean isRedPacket_;
        private boolean isTreasure_;
        private boolean isTrigger_;
        private boolean isTrue_;
        private int level_;
        private volatile Object liveId_;
        private byte memoizedIsInitialized;
        private volatile Object name_;
        private int num_;
        private volatile Object reason_;
        private volatile Object redPacketType_;
        private volatile Object requestId_;
        private int result_;
        private volatile Object scene_;
        private double score_;
        private volatile Object sku_;
        private volatile Object source_;
        private volatile Object status_;
        private volatile Object tagType_;
        private volatile Object targetUid_;
        private int time_;
        private int times_;
        private volatile Object title_;
        private int type_;
        private volatile Object userTag_;
        private volatile Object userType_;
        private float worth_;
        private static final LiveProto DEFAULT_INSTANCE = new LiveProto();
        private static final Parser<LiveProto> PARSER = new AbstractParser<LiveProto>() { // from class: com.irisdt.client.live.LiveProtos.LiveProto.1
            @Override // com.google.protobuf.Parser
            public LiveProto parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new LiveProto(codedInputStream, extensionRegistryLite);
            }
        };

        private LiveProto(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = (byte) -1;
        }

        public static LiveProto getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return LiveProtos.internal_static_com_irisdt_client_live_LiveProto_descriptor;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static LiveProto parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (LiveProto) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
        }

        public static LiveProto parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer);
        }

        public static Parser<LiveProto> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof LiveProto)) {
                return super.equals(obj);
            }
            LiveProto liveProto = (LiveProto) obj;
            return this.event_ == liveProto.event_ && this.type_ == liveProto.type_ && getLiveId().equals(liveProto.getLiveId()) && getAnchorUid().equals(liveProto.getAnchorUid()) && getNum() == liveProto.getNum() && getId().equals(liveProto.getId()) && getIsTrue() == liveProto.getIsTrue() && getTime() == liveProto.getTime() && Float.floatToIntBits(getWorth()) == Float.floatToIntBits(liveProto.getWorth()) && getContent().equals(liveProto.getContent()) && getFrom().equals(liveProto.getFrom()) && getCount() == liveProto.getCount() && getLevel() == liveProto.getLevel() && getScene().equals(liveProto.getScene()) && getIsBool() == liveProto.getIsBool() && this.result_ == liveProto.result_ && getStatus().equals(liveProto.getStatus()) && getSource().equals(liveProto.getSource()) && this.coverType_ == liveProto.coverType_ && getTagType().equals(liveProto.getTagType()) && getUserType().equals(liveProto.getUserType()) && Double.doubleToLongBits(getScore()) == Double.doubleToLongBits(liveProto.getScore()) && getTitle().equals(liveProto.getTitle()) && getName().equals(liveProto.getName()) && getConnectType().equals(liveProto.getConnectType()) && getUserTag().equals(liveProto.getUserTag()) && getTargetUid().equals(liveProto.getTargetUid()) && getIsLiveShow() == liveProto.getIsLiveShow() && getIsTreasure() == liveProto.getIsTreasure() && getIsRedPacket() == liveProto.getIsRedPacket() && getIsLiveWindow() == liveProto.getIsLiveWindow() && getRedPacketType().equals(liveProto.getRedPacketType()) && getIsTrigger() == liveProto.getIsTrigger() && getTimes() == liveProto.getTimes() && getActivityFirst().equals(liveProto.getActivityFirst()) && getActivitySecond().equals(liveProto.getActivitySecond()) && getIndex() == liveProto.getIndex() && getSku().equals(liveProto.getSku()) && getIsFirst() == liveProto.getIsFirst() && getGrade().equals(liveProto.getGrade()) && getReason().equals(liveProto.getReason()) && getRequestId().equals(liveProto.getRequestId()) && this.unknownFields.equals(liveProto.unknownFields);
        }

        @Override // com.irisdt.client.live.LiveProtos.LiveProtoOrBuilder
        public String getActivityFirst() {
            Object obj = this.activityFirst_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.activityFirst_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.irisdt.client.live.LiveProtos.LiveProtoOrBuilder
        public ByteString getActivityFirstBytes() {
            Object obj = this.activityFirst_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.activityFirst_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.irisdt.client.live.LiveProtos.LiveProtoOrBuilder
        public String getActivitySecond() {
            Object obj = this.activitySecond_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.activitySecond_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.irisdt.client.live.LiveProtos.LiveProtoOrBuilder
        public ByteString getActivitySecondBytes() {
            Object obj = this.activitySecond_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.activitySecond_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.irisdt.client.live.LiveProtos.LiveProtoOrBuilder
        public String getAnchorUid() {
            Object obj = this.anchorUid_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.anchorUid_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.irisdt.client.live.LiveProtos.LiveProtoOrBuilder
        public ByteString getAnchorUidBytes() {
            Object obj = this.anchorUid_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.anchorUid_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.irisdt.client.live.LiveProtos.LiveProtoOrBuilder
        public String getConnectType() {
            Object obj = this.connectType_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.connectType_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.irisdt.client.live.LiveProtos.LiveProtoOrBuilder
        public ByteString getConnectTypeBytes() {
            Object obj = this.connectType_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.connectType_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.irisdt.client.live.LiveProtos.LiveProtoOrBuilder
        public String getContent() {
            Object obj = this.content_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.content_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.irisdt.client.live.LiveProtos.LiveProtoOrBuilder
        public ByteString getContentBytes() {
            Object obj = this.content_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.content_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.irisdt.client.live.LiveProtos.LiveProtoOrBuilder
        public int getCount() {
            return this.count_;
        }

        @Override // com.irisdt.client.live.LiveProtos.LiveProtoOrBuilder
        public CoverType getCoverType() {
            CoverType valueOf = CoverType.valueOf(this.coverType_);
            return valueOf == null ? CoverType.UNRECOGNIZED : valueOf;
        }

        @Override // com.irisdt.client.live.LiveProtos.LiveProtoOrBuilder
        public int getCoverTypeValue() {
            return this.coverType_;
        }

        @Override // com.irisdt.client.live.LiveProtos.LiveProtoOrBuilder
        public Event getEvent() {
            Event valueOf = Event.valueOf(this.event_);
            return valueOf == null ? Event.UNRECOGNIZED : valueOf;
        }

        @Override // com.irisdt.client.live.LiveProtos.LiveProtoOrBuilder
        public int getEventValue() {
            return this.event_;
        }

        @Override // com.irisdt.client.live.LiveProtos.LiveProtoOrBuilder
        public String getFrom() {
            Object obj = this.from_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.from_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.irisdt.client.live.LiveProtos.LiveProtoOrBuilder
        public ByteString getFromBytes() {
            Object obj = this.from_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.from_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.irisdt.client.live.LiveProtos.LiveProtoOrBuilder
        public String getGrade() {
            Object obj = this.grade_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.grade_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.irisdt.client.live.LiveProtos.LiveProtoOrBuilder
        public ByteString getGradeBytes() {
            Object obj = this.grade_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.grade_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.irisdt.client.live.LiveProtos.LiveProtoOrBuilder
        public String getId() {
            Object obj = this.id_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.id_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.irisdt.client.live.LiveProtos.LiveProtoOrBuilder
        public ByteString getIdBytes() {
            Object obj = this.id_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.id_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.irisdt.client.live.LiveProtos.LiveProtoOrBuilder
        public int getIndex() {
            return this.index_;
        }

        @Override // com.irisdt.client.live.LiveProtos.LiveProtoOrBuilder
        public boolean getIsBool() {
            return this.isBool_;
        }

        @Override // com.irisdt.client.live.LiveProtos.LiveProtoOrBuilder
        public boolean getIsFirst() {
            return this.isFirst_;
        }

        @Override // com.irisdt.client.live.LiveProtos.LiveProtoOrBuilder
        public boolean getIsLiveShow() {
            return this.isLiveShow_;
        }

        @Override // com.irisdt.client.live.LiveProtos.LiveProtoOrBuilder
        public boolean getIsLiveWindow() {
            return this.isLiveWindow_;
        }

        @Override // com.irisdt.client.live.LiveProtos.LiveProtoOrBuilder
        public boolean getIsRedPacket() {
            return this.isRedPacket_;
        }

        @Override // com.irisdt.client.live.LiveProtos.LiveProtoOrBuilder
        public boolean getIsTreasure() {
            return this.isTreasure_;
        }

        @Override // com.irisdt.client.live.LiveProtos.LiveProtoOrBuilder
        public boolean getIsTrigger() {
            return this.isTrigger_;
        }

        @Override // com.irisdt.client.live.LiveProtos.LiveProtoOrBuilder
        public boolean getIsTrue() {
            return this.isTrue_;
        }

        @Override // com.irisdt.client.live.LiveProtos.LiveProtoOrBuilder
        public int getLevel() {
            return this.level_;
        }

        @Override // com.irisdt.client.live.LiveProtos.LiveProtoOrBuilder
        public String getLiveId() {
            Object obj = this.liveId_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.liveId_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.irisdt.client.live.LiveProtos.LiveProtoOrBuilder
        public ByteString getLiveIdBytes() {
            Object obj = this.liveId_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.liveId_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.irisdt.client.live.LiveProtos.LiveProtoOrBuilder
        public String getName() {
            Object obj = this.name_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.name_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.irisdt.client.live.LiveProtos.LiveProtoOrBuilder
        public ByteString getNameBytes() {
            Object obj = this.name_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.name_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.irisdt.client.live.LiveProtos.LiveProtoOrBuilder
        public int getNum() {
            return this.num_;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<LiveProto> getParserForType() {
            return PARSER;
        }

        @Override // com.irisdt.client.live.LiveProtos.LiveProtoOrBuilder
        public String getReason() {
            Object obj = this.reason_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.reason_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.irisdt.client.live.LiveProtos.LiveProtoOrBuilder
        public ByteString getReasonBytes() {
            Object obj = this.reason_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.reason_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.irisdt.client.live.LiveProtos.LiveProtoOrBuilder
        public String getRedPacketType() {
            Object obj = this.redPacketType_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.redPacketType_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.irisdt.client.live.LiveProtos.LiveProtoOrBuilder
        public ByteString getRedPacketTypeBytes() {
            Object obj = this.redPacketType_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.redPacketType_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.irisdt.client.live.LiveProtos.LiveProtoOrBuilder
        public String getRequestId() {
            Object obj = this.requestId_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.requestId_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.irisdt.client.live.LiveProtos.LiveProtoOrBuilder
        public ByteString getRequestIdBytes() {
            Object obj = this.requestId_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.requestId_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.irisdt.client.live.LiveProtos.LiveProtoOrBuilder
        public Result getResult() {
            Result valueOf = Result.valueOf(this.result_);
            return valueOf == null ? Result.UNRECOGNIZED : valueOf;
        }

        @Override // com.irisdt.client.live.LiveProtos.LiveProtoOrBuilder
        public int getResultValue() {
            return this.result_;
        }

        @Override // com.irisdt.client.live.LiveProtos.LiveProtoOrBuilder
        public String getScene() {
            Object obj = this.scene_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.scene_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.irisdt.client.live.LiveProtos.LiveProtoOrBuilder
        public ByteString getSceneBytes() {
            Object obj = this.scene_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.scene_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.irisdt.client.live.LiveProtos.LiveProtoOrBuilder
        public double getScore() {
            return this.score_;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i10 = this.memoizedSize;
            if (i10 != -1) {
                return i10;
            }
            int computeEnumSize = this.event_ != Event.UNKNOWN_EVENT.getNumber() ? 0 + CodedOutputStream.computeEnumSize(1, this.event_) : 0;
            if (this.type_ != Type.UNKNOWN_TYPE.getNumber()) {
                computeEnumSize += CodedOutputStream.computeEnumSize(2, this.type_);
            }
            if (!getLiveIdBytes().isEmpty()) {
                computeEnumSize += GeneratedMessageV3.computeStringSize(3, this.liveId_);
            }
            if (!getAnchorUidBytes().isEmpty()) {
                computeEnumSize += GeneratedMessageV3.computeStringSize(4, this.anchorUid_);
            }
            int i11 = this.num_;
            if (i11 != 0) {
                computeEnumSize += CodedOutputStream.computeInt32Size(5, i11);
            }
            if (!getIdBytes().isEmpty()) {
                computeEnumSize += GeneratedMessageV3.computeStringSize(6, this.id_);
            }
            boolean z10 = this.isTrue_;
            if (z10) {
                computeEnumSize += CodedOutputStream.computeBoolSize(7, z10);
            }
            int i12 = this.time_;
            if (i12 != 0) {
                computeEnumSize += CodedOutputStream.computeInt32Size(8, i12);
            }
            float f10 = this.worth_;
            if (f10 != 0.0f) {
                computeEnumSize += CodedOutputStream.computeFloatSize(9, f10);
            }
            if (!getContentBytes().isEmpty()) {
                computeEnumSize += GeneratedMessageV3.computeStringSize(10, this.content_);
            }
            if (!getFromBytes().isEmpty()) {
                computeEnumSize += GeneratedMessageV3.computeStringSize(11, this.from_);
            }
            int i13 = this.count_;
            if (i13 != 0) {
                computeEnumSize += CodedOutputStream.computeInt32Size(12, i13);
            }
            int i14 = this.level_;
            if (i14 != 0) {
                computeEnumSize += CodedOutputStream.computeInt32Size(13, i14);
            }
            if (!getSceneBytes().isEmpty()) {
                computeEnumSize += GeneratedMessageV3.computeStringSize(14, this.scene_);
            }
            boolean z11 = this.isBool_;
            if (z11) {
                computeEnumSize += CodedOutputStream.computeBoolSize(15, z11);
            }
            if (this.result_ != Result.UNKNOWN_RESULT.getNumber()) {
                computeEnumSize += CodedOutputStream.computeEnumSize(16, this.result_);
            }
            if (!getStatusBytes().isEmpty()) {
                computeEnumSize += GeneratedMessageV3.computeStringSize(17, this.status_);
            }
            if (!getSourceBytes().isEmpty()) {
                computeEnumSize += GeneratedMessageV3.computeStringSize(18, this.source_);
            }
            if (this.coverType_ != CoverType.UNKNOWN_COVER_TYPE.getNumber()) {
                computeEnumSize += CodedOutputStream.computeEnumSize(19, this.coverType_);
            }
            if (!getTagTypeBytes().isEmpty()) {
                computeEnumSize += GeneratedMessageV3.computeStringSize(20, this.tagType_);
            }
            if (!getUserTypeBytes().isEmpty()) {
                computeEnumSize += GeneratedMessageV3.computeStringSize(21, this.userType_);
            }
            double d10 = this.score_;
            if (d10 != ShadowDrawableWrapper.COS_45) {
                computeEnumSize += CodedOutputStream.computeDoubleSize(22, d10);
            }
            if (!getTitleBytes().isEmpty()) {
                computeEnumSize += GeneratedMessageV3.computeStringSize(23, this.title_);
            }
            if (!getNameBytes().isEmpty()) {
                computeEnumSize += GeneratedMessageV3.computeStringSize(24, this.name_);
            }
            if (!getConnectTypeBytes().isEmpty()) {
                computeEnumSize += GeneratedMessageV3.computeStringSize(25, this.connectType_);
            }
            if (!getUserTagBytes().isEmpty()) {
                computeEnumSize += GeneratedMessageV3.computeStringSize(26, this.userTag_);
            }
            if (!getTargetUidBytes().isEmpty()) {
                computeEnumSize += GeneratedMessageV3.computeStringSize(27, this.targetUid_);
            }
            boolean z12 = this.isLiveShow_;
            if (z12) {
                computeEnumSize += CodedOutputStream.computeBoolSize(28, z12);
            }
            boolean z13 = this.isTreasure_;
            if (z13) {
                computeEnumSize += CodedOutputStream.computeBoolSize(29, z13);
            }
            boolean z14 = this.isRedPacket_;
            if (z14) {
                computeEnumSize += CodedOutputStream.computeBoolSize(30, z14);
            }
            boolean z15 = this.isLiveWindow_;
            if (z15) {
                computeEnumSize += CodedOutputStream.computeBoolSize(31, z15);
            }
            if (!getRedPacketTypeBytes().isEmpty()) {
                computeEnumSize += GeneratedMessageV3.computeStringSize(32, this.redPacketType_);
            }
            boolean z16 = this.isTrigger_;
            if (z16) {
                computeEnumSize += CodedOutputStream.computeBoolSize(33, z16);
            }
            int i15 = this.times_;
            if (i15 != 0) {
                computeEnumSize += CodedOutputStream.computeInt32Size(34, i15);
            }
            if (!getActivityFirstBytes().isEmpty()) {
                computeEnumSize += GeneratedMessageV3.computeStringSize(35, this.activityFirst_);
            }
            if (!getActivitySecondBytes().isEmpty()) {
                computeEnumSize += GeneratedMessageV3.computeStringSize(36, this.activitySecond_);
            }
            int i16 = this.index_;
            if (i16 != 0) {
                computeEnumSize += CodedOutputStream.computeInt32Size(37, i16);
            }
            if (!getSkuBytes().isEmpty()) {
                computeEnumSize += GeneratedMessageV3.computeStringSize(38, this.sku_);
            }
            boolean z17 = this.isFirst_;
            if (z17) {
                computeEnumSize += CodedOutputStream.computeBoolSize(39, z17);
            }
            if (!getGradeBytes().isEmpty()) {
                computeEnumSize += GeneratedMessageV3.computeStringSize(40, this.grade_);
            }
            if (!getReasonBytes().isEmpty()) {
                computeEnumSize += GeneratedMessageV3.computeStringSize(41, this.reason_);
            }
            if (!getRequestIdBytes().isEmpty()) {
                computeEnumSize += GeneratedMessageV3.computeStringSize(42, this.requestId_);
            }
            int serializedSize = computeEnumSize + this.unknownFields.getSerializedSize();
            this.memoizedSize = serializedSize;
            return serializedSize;
        }

        @Override // com.irisdt.client.live.LiveProtos.LiveProtoOrBuilder
        public String getSku() {
            Object obj = this.sku_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.sku_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.irisdt.client.live.LiveProtos.LiveProtoOrBuilder
        public ByteString getSkuBytes() {
            Object obj = this.sku_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.sku_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.irisdt.client.live.LiveProtos.LiveProtoOrBuilder
        public String getSource() {
            Object obj = this.source_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.source_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.irisdt.client.live.LiveProtos.LiveProtoOrBuilder
        public ByteString getSourceBytes() {
            Object obj = this.source_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.source_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.irisdt.client.live.LiveProtos.LiveProtoOrBuilder
        public String getStatus() {
            Object obj = this.status_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.status_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.irisdt.client.live.LiveProtos.LiveProtoOrBuilder
        public ByteString getStatusBytes() {
            Object obj = this.status_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.status_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.irisdt.client.live.LiveProtos.LiveProtoOrBuilder
        public String getTagType() {
            Object obj = this.tagType_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.tagType_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.irisdt.client.live.LiveProtos.LiveProtoOrBuilder
        public ByteString getTagTypeBytes() {
            Object obj = this.tagType_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.tagType_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.irisdt.client.live.LiveProtos.LiveProtoOrBuilder
        public String getTargetUid() {
            Object obj = this.targetUid_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.targetUid_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.irisdt.client.live.LiveProtos.LiveProtoOrBuilder
        public ByteString getTargetUidBytes() {
            Object obj = this.targetUid_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.targetUid_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.irisdt.client.live.LiveProtos.LiveProtoOrBuilder
        public int getTime() {
            return this.time_;
        }

        @Override // com.irisdt.client.live.LiveProtos.LiveProtoOrBuilder
        public int getTimes() {
            return this.times_;
        }

        @Override // com.irisdt.client.live.LiveProtos.LiveProtoOrBuilder
        public String getTitle() {
            Object obj = this.title_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.title_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.irisdt.client.live.LiveProtos.LiveProtoOrBuilder
        public ByteString getTitleBytes() {
            Object obj = this.title_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.title_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.irisdt.client.live.LiveProtos.LiveProtoOrBuilder
        public Type getType() {
            Type valueOf = Type.valueOf(this.type_);
            return valueOf == null ? Type.UNRECOGNIZED : valueOf;
        }

        @Override // com.irisdt.client.live.LiveProtos.LiveProtoOrBuilder
        public int getTypeValue() {
            return this.type_;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        @Override // com.irisdt.client.live.LiveProtos.LiveProtoOrBuilder
        public String getUserTag() {
            Object obj = this.userTag_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.userTag_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.irisdt.client.live.LiveProtos.LiveProtoOrBuilder
        public ByteString getUserTagBytes() {
            Object obj = this.userTag_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.userTag_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.irisdt.client.live.LiveProtos.LiveProtoOrBuilder
        public String getUserType() {
            Object obj = this.userType_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.userType_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.irisdt.client.live.LiveProtos.LiveProtoOrBuilder
        public ByteString getUserTypeBytes() {
            Object obj = this.userType_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.userType_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.irisdt.client.live.LiveProtos.LiveProtoOrBuilder
        public float getWorth() {
            return this.worth_;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            int i10 = this.memoizedHashCode;
            if (i10 != 0) {
                return i10;
            }
            int hashCode = ((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((MetricsProto.MetricsEvent.APP_SPECIAL_PERMISSION_PREMIUM_SMS_DENY + getDescriptor().hashCode()) * 37) + 1) * 53) + this.event_) * 37) + 2) * 53) + this.type_) * 37) + 3) * 53) + getLiveId().hashCode()) * 37) + 4) * 53) + getAnchorUid().hashCode()) * 37) + 5) * 53) + getNum()) * 37) + 6) * 53) + getId().hashCode()) * 37) + 7) * 53) + Internal.hashBoolean(getIsTrue())) * 37) + 8) * 53) + getTime()) * 37) + 9) * 53) + Float.floatToIntBits(getWorth())) * 37) + 10) * 53) + getContent().hashCode()) * 37) + 11) * 53) + getFrom().hashCode()) * 37) + 12) * 53) + getCount()) * 37) + 13) * 53) + getLevel()) * 37) + 14) * 53) + getScene().hashCode()) * 37) + 15) * 53) + Internal.hashBoolean(getIsBool())) * 37) + 16) * 53) + this.result_) * 37) + 17) * 53) + getStatus().hashCode()) * 37) + 18) * 53) + getSource().hashCode()) * 37) + 19) * 53) + this.coverType_) * 37) + 20) * 53) + getTagType().hashCode()) * 37) + 21) * 53) + getUserType().hashCode()) * 37) + 22) * 53) + Internal.hashLong(Double.doubleToLongBits(getScore()))) * 37) + 23) * 53) + getTitle().hashCode()) * 37) + 24) * 53) + getName().hashCode()) * 37) + 25) * 53) + getConnectType().hashCode()) * 37) + 26) * 53) + getUserTag().hashCode()) * 37) + 27) * 53) + getTargetUid().hashCode()) * 37) + 28) * 53) + Internal.hashBoolean(getIsLiveShow())) * 37) + 29) * 53) + Internal.hashBoolean(getIsTreasure())) * 37) + 30) * 53) + Internal.hashBoolean(getIsRedPacket())) * 37) + 31) * 53) + Internal.hashBoolean(getIsLiveWindow())) * 37) + 32) * 53) + getRedPacketType().hashCode()) * 37) + 33) * 53) + Internal.hashBoolean(getIsTrigger())) * 37) + 34) * 53) + getTimes()) * 37) + 35) * 53) + getActivityFirst().hashCode()) * 37) + 36) * 53) + getActivitySecond().hashCode()) * 37) + 37) * 53) + getIndex()) * 37) + 38) * 53) + getSku().hashCode()) * 37) + 39) * 53) + Internal.hashBoolean(getIsFirst())) * 37) + 40) * 53) + getGrade().hashCode()) * 37) + 41) * 53) + getReason().hashCode()) * 37) + 42) * 53) + getRequestId().hashCode()) * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = hashCode;
            return hashCode;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return LiveProtos.internal_static_com_irisdt_client_live_LiveProto_fieldAccessorTable.ensureFieldAccessorsInitialized(LiveProto.class, Builder.class);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            byte b4 = this.memoizedIsInitialized;
            if (b4 == 1) {
                return true;
            }
            if (b4 == 0) {
                return false;
            }
            this.memoizedIsInitialized = (byte) 1;
            return true;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unusedPrivateParameter) {
            return new LiveProto();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            if (this.event_ != Event.UNKNOWN_EVENT.getNumber()) {
                codedOutputStream.writeEnum(1, this.event_);
            }
            if (this.type_ != Type.UNKNOWN_TYPE.getNumber()) {
                codedOutputStream.writeEnum(2, this.type_);
            }
            if (!getLiveIdBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 3, this.liveId_);
            }
            if (!getAnchorUidBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 4, this.anchorUid_);
            }
            int i10 = this.num_;
            if (i10 != 0) {
                codedOutputStream.writeInt32(5, i10);
            }
            if (!getIdBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 6, this.id_);
            }
            boolean z10 = this.isTrue_;
            if (z10) {
                codedOutputStream.writeBool(7, z10);
            }
            int i11 = this.time_;
            if (i11 != 0) {
                codedOutputStream.writeInt32(8, i11);
            }
            float f10 = this.worth_;
            if (f10 != 0.0f) {
                codedOutputStream.writeFloat(9, f10);
            }
            if (!getContentBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 10, this.content_);
            }
            if (!getFromBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 11, this.from_);
            }
            int i12 = this.count_;
            if (i12 != 0) {
                codedOutputStream.writeInt32(12, i12);
            }
            int i13 = this.level_;
            if (i13 != 0) {
                codedOutputStream.writeInt32(13, i13);
            }
            if (!getSceneBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 14, this.scene_);
            }
            boolean z11 = this.isBool_;
            if (z11) {
                codedOutputStream.writeBool(15, z11);
            }
            if (this.result_ != Result.UNKNOWN_RESULT.getNumber()) {
                codedOutputStream.writeEnum(16, this.result_);
            }
            if (!getStatusBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 17, this.status_);
            }
            if (!getSourceBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 18, this.source_);
            }
            if (this.coverType_ != CoverType.UNKNOWN_COVER_TYPE.getNumber()) {
                codedOutputStream.writeEnum(19, this.coverType_);
            }
            if (!getTagTypeBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 20, this.tagType_);
            }
            if (!getUserTypeBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 21, this.userType_);
            }
            double d10 = this.score_;
            if (d10 != ShadowDrawableWrapper.COS_45) {
                codedOutputStream.writeDouble(22, d10);
            }
            if (!getTitleBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 23, this.title_);
            }
            if (!getNameBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 24, this.name_);
            }
            if (!getConnectTypeBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 25, this.connectType_);
            }
            if (!getUserTagBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 26, this.userTag_);
            }
            if (!getTargetUidBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 27, this.targetUid_);
            }
            boolean z12 = this.isLiveShow_;
            if (z12) {
                codedOutputStream.writeBool(28, z12);
            }
            boolean z13 = this.isTreasure_;
            if (z13) {
                codedOutputStream.writeBool(29, z13);
            }
            boolean z14 = this.isRedPacket_;
            if (z14) {
                codedOutputStream.writeBool(30, z14);
            }
            boolean z15 = this.isLiveWindow_;
            if (z15) {
                codedOutputStream.writeBool(31, z15);
            }
            if (!getRedPacketTypeBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 32, this.redPacketType_);
            }
            boolean z16 = this.isTrigger_;
            if (z16) {
                codedOutputStream.writeBool(33, z16);
            }
            int i14 = this.times_;
            if (i14 != 0) {
                codedOutputStream.writeInt32(34, i14);
            }
            if (!getActivityFirstBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 35, this.activityFirst_);
            }
            if (!getActivitySecondBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 36, this.activitySecond_);
            }
            int i15 = this.index_;
            if (i15 != 0) {
                codedOutputStream.writeInt32(37, i15);
            }
            if (!getSkuBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 38, this.sku_);
            }
            boolean z17 = this.isFirst_;
            if (z17) {
                codedOutputStream.writeBool(39, z17);
            }
            if (!getGradeBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 40, this.grade_);
            }
            if (!getReasonBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 41, this.reason_);
            }
            if (!getRequestIdBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 42, this.requestId_);
            }
            this.unknownFields.writeTo(codedOutputStream);
        }

        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements LiveProtoOrBuilder {
            private Object activityFirst_;
            private Object activitySecond_;
            private Object anchorUid_;
            private Object connectType_;
            private Object content_;
            private int count_;
            private int coverType_;
            private int event_;
            private Object from_;
            private Object grade_;
            private Object id_;
            private int index_;
            private boolean isBool_;
            private boolean isFirst_;
            private boolean isLiveShow_;
            private boolean isLiveWindow_;
            private boolean isRedPacket_;
            private boolean isTreasure_;
            private boolean isTrigger_;
            private boolean isTrue_;
            private int level_;
            private Object liveId_;
            private Object name_;
            private int num_;
            private Object reason_;
            private Object redPacketType_;
            private Object requestId_;
            private int result_;
            private Object scene_;
            private double score_;
            private Object sku_;
            private Object source_;
            private Object status_;
            private Object tagType_;
            private Object targetUid_;
            private int time_;
            private int times_;
            private Object title_;
            private int type_;
            private Object userTag_;
            private Object userType_;
            private float worth_;

            private Builder() {
                this.event_ = 0;
                this.type_ = 0;
                this.liveId_ = "";
                this.anchorUid_ = "";
                this.id_ = "";
                this.content_ = "";
                this.from_ = "";
                this.scene_ = "";
                this.result_ = 0;
                this.status_ = "";
                this.source_ = "";
                this.coverType_ = 0;
                this.tagType_ = "";
                this.userType_ = "";
                this.title_ = "";
                this.name_ = "";
                this.connectType_ = "";
                this.userTag_ = "";
                this.targetUid_ = "";
                this.redPacketType_ = "";
                this.activityFirst_ = "";
                this.activitySecond_ = "";
                this.sku_ = "";
                this.grade_ = "";
                this.reason_ = "";
                this.requestId_ = "";
                maybeForceBuilderInitialization();
            }

            public static final Descriptors.Descriptor getDescriptor() {
                return LiveProtos.internal_static_com_irisdt_client_live_LiveProto_descriptor;
            }

            private void maybeForceBuilderInitialization() {
                boolean unused = GeneratedMessageV3.alwaysUseFieldBuilders;
            }

            public Builder clearActivityFirst() {
                this.activityFirst_ = LiveProto.getDefaultInstance().getActivityFirst();
                onChanged();
                return this;
            }

            public Builder clearActivitySecond() {
                this.activitySecond_ = LiveProto.getDefaultInstance().getActivitySecond();
                onChanged();
                return this;
            }

            public Builder clearAnchorUid() {
                this.anchorUid_ = LiveProto.getDefaultInstance().getAnchorUid();
                onChanged();
                return this;
            }

            public Builder clearConnectType() {
                this.connectType_ = LiveProto.getDefaultInstance().getConnectType();
                onChanged();
                return this;
            }

            public Builder clearContent() {
                this.content_ = LiveProto.getDefaultInstance().getContent();
                onChanged();
                return this;
            }

            public Builder clearCount() {
                this.count_ = 0;
                onChanged();
                return this;
            }

            public Builder clearCoverType() {
                this.coverType_ = 0;
                onChanged();
                return this;
            }

            public Builder clearEvent() {
                this.event_ = 0;
                onChanged();
                return this;
            }

            public Builder clearFrom() {
                this.from_ = LiveProto.getDefaultInstance().getFrom();
                onChanged();
                return this;
            }

            public Builder clearGrade() {
                this.grade_ = LiveProto.getDefaultInstance().getGrade();
                onChanged();
                return this;
            }

            public Builder clearId() {
                this.id_ = LiveProto.getDefaultInstance().getId();
                onChanged();
                return this;
            }

            public Builder clearIndex() {
                this.index_ = 0;
                onChanged();
                return this;
            }

            public Builder clearIsBool() {
                this.isBool_ = false;
                onChanged();
                return this;
            }

            public Builder clearIsFirst() {
                this.isFirst_ = false;
                onChanged();
                return this;
            }

            public Builder clearIsLiveShow() {
                this.isLiveShow_ = false;
                onChanged();
                return this;
            }

            public Builder clearIsLiveWindow() {
                this.isLiveWindow_ = false;
                onChanged();
                return this;
            }

            public Builder clearIsRedPacket() {
                this.isRedPacket_ = false;
                onChanged();
                return this;
            }

            public Builder clearIsTreasure() {
                this.isTreasure_ = false;
                onChanged();
                return this;
            }

            public Builder clearIsTrigger() {
                this.isTrigger_ = false;
                onChanged();
                return this;
            }

            public Builder clearIsTrue() {
                this.isTrue_ = false;
                onChanged();
                return this;
            }

            public Builder clearLevel() {
                this.level_ = 0;
                onChanged();
                return this;
            }

            public Builder clearLiveId() {
                this.liveId_ = LiveProto.getDefaultInstance().getLiveId();
                onChanged();
                return this;
            }

            public Builder clearName() {
                this.name_ = LiveProto.getDefaultInstance().getName();
                onChanged();
                return this;
            }

            public Builder clearNum() {
                this.num_ = 0;
                onChanged();
                return this;
            }

            public Builder clearReason() {
                this.reason_ = LiveProto.getDefaultInstance().getReason();
                onChanged();
                return this;
            }

            public Builder clearRedPacketType() {
                this.redPacketType_ = LiveProto.getDefaultInstance().getRedPacketType();
                onChanged();
                return this;
            }

            public Builder clearRequestId() {
                this.requestId_ = LiveProto.getDefaultInstance().getRequestId();
                onChanged();
                return this;
            }

            public Builder clearResult() {
                this.result_ = 0;
                onChanged();
                return this;
            }

            public Builder clearScene() {
                this.scene_ = LiveProto.getDefaultInstance().getScene();
                onChanged();
                return this;
            }

            public Builder clearScore() {
                this.score_ = ShadowDrawableWrapper.COS_45;
                onChanged();
                return this;
            }

            public Builder clearSku() {
                this.sku_ = LiveProto.getDefaultInstance().getSku();
                onChanged();
                return this;
            }

            public Builder clearSource() {
                this.source_ = LiveProto.getDefaultInstance().getSource();
                onChanged();
                return this;
            }

            public Builder clearStatus() {
                this.status_ = LiveProto.getDefaultInstance().getStatus();
                onChanged();
                return this;
            }

            public Builder clearTagType() {
                this.tagType_ = LiveProto.getDefaultInstance().getTagType();
                onChanged();
                return this;
            }

            public Builder clearTargetUid() {
                this.targetUid_ = LiveProto.getDefaultInstance().getTargetUid();
                onChanged();
                return this;
            }

            public Builder clearTime() {
                this.time_ = 0;
                onChanged();
                return this;
            }

            public Builder clearTimes() {
                this.times_ = 0;
                onChanged();
                return this;
            }

            public Builder clearTitle() {
                this.title_ = LiveProto.getDefaultInstance().getTitle();
                onChanged();
                return this;
            }

            public Builder clearType() {
                this.type_ = 0;
                onChanged();
                return this;
            }

            public Builder clearUserTag() {
                this.userTag_ = LiveProto.getDefaultInstance().getUserTag();
                onChanged();
                return this;
            }

            public Builder clearUserType() {
                this.userType_ = LiveProto.getDefaultInstance().getUserType();
                onChanged();
                return this;
            }

            public Builder clearWorth() {
                this.worth_ = 0.0f;
                onChanged();
                return this;
            }

            @Override // com.irisdt.client.live.LiveProtos.LiveProtoOrBuilder
            public String getActivityFirst() {
                Object obj = this.activityFirst_;
                if (!(obj instanceof String)) {
                    String stringUtf8 = ((ByteString) obj).toStringUtf8();
                    this.activityFirst_ = stringUtf8;
                    return stringUtf8;
                }
                return (String) obj;
            }

            @Override // com.irisdt.client.live.LiveProtos.LiveProtoOrBuilder
            public ByteString getActivityFirstBytes() {
                Object obj = this.activityFirst_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.activityFirst_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // com.irisdt.client.live.LiveProtos.LiveProtoOrBuilder
            public String getActivitySecond() {
                Object obj = this.activitySecond_;
                if (!(obj instanceof String)) {
                    String stringUtf8 = ((ByteString) obj).toStringUtf8();
                    this.activitySecond_ = stringUtf8;
                    return stringUtf8;
                }
                return (String) obj;
            }

            @Override // com.irisdt.client.live.LiveProtos.LiveProtoOrBuilder
            public ByteString getActivitySecondBytes() {
                Object obj = this.activitySecond_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.activitySecond_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // com.irisdt.client.live.LiveProtos.LiveProtoOrBuilder
            public String getAnchorUid() {
                Object obj = this.anchorUid_;
                if (!(obj instanceof String)) {
                    String stringUtf8 = ((ByteString) obj).toStringUtf8();
                    this.anchorUid_ = stringUtf8;
                    return stringUtf8;
                }
                return (String) obj;
            }

            @Override // com.irisdt.client.live.LiveProtos.LiveProtoOrBuilder
            public ByteString getAnchorUidBytes() {
                Object obj = this.anchorUid_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.anchorUid_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // com.irisdt.client.live.LiveProtos.LiveProtoOrBuilder
            public String getConnectType() {
                Object obj = this.connectType_;
                if (!(obj instanceof String)) {
                    String stringUtf8 = ((ByteString) obj).toStringUtf8();
                    this.connectType_ = stringUtf8;
                    return stringUtf8;
                }
                return (String) obj;
            }

            @Override // com.irisdt.client.live.LiveProtos.LiveProtoOrBuilder
            public ByteString getConnectTypeBytes() {
                Object obj = this.connectType_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.connectType_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // com.irisdt.client.live.LiveProtos.LiveProtoOrBuilder
            public String getContent() {
                Object obj = this.content_;
                if (!(obj instanceof String)) {
                    String stringUtf8 = ((ByteString) obj).toStringUtf8();
                    this.content_ = stringUtf8;
                    return stringUtf8;
                }
                return (String) obj;
            }

            @Override // com.irisdt.client.live.LiveProtos.LiveProtoOrBuilder
            public ByteString getContentBytes() {
                Object obj = this.content_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.content_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // com.irisdt.client.live.LiveProtos.LiveProtoOrBuilder
            public int getCount() {
                return this.count_;
            }

            @Override // com.irisdt.client.live.LiveProtos.LiveProtoOrBuilder
            public CoverType getCoverType() {
                CoverType valueOf = CoverType.valueOf(this.coverType_);
                return valueOf == null ? CoverType.UNRECOGNIZED : valueOf;
            }

            @Override // com.irisdt.client.live.LiveProtos.LiveProtoOrBuilder
            public int getCoverTypeValue() {
                return this.coverType_;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return LiveProtos.internal_static_com_irisdt_client_live_LiveProto_descriptor;
            }

            @Override // com.irisdt.client.live.LiveProtos.LiveProtoOrBuilder
            public Event getEvent() {
                Event valueOf = Event.valueOf(this.event_);
                return valueOf == null ? Event.UNRECOGNIZED : valueOf;
            }

            @Override // com.irisdt.client.live.LiveProtos.LiveProtoOrBuilder
            public int getEventValue() {
                return this.event_;
            }

            @Override // com.irisdt.client.live.LiveProtos.LiveProtoOrBuilder
            public String getFrom() {
                Object obj = this.from_;
                if (!(obj instanceof String)) {
                    String stringUtf8 = ((ByteString) obj).toStringUtf8();
                    this.from_ = stringUtf8;
                    return stringUtf8;
                }
                return (String) obj;
            }

            @Override // com.irisdt.client.live.LiveProtos.LiveProtoOrBuilder
            public ByteString getFromBytes() {
                Object obj = this.from_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.from_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // com.irisdt.client.live.LiveProtos.LiveProtoOrBuilder
            public String getGrade() {
                Object obj = this.grade_;
                if (!(obj instanceof String)) {
                    String stringUtf8 = ((ByteString) obj).toStringUtf8();
                    this.grade_ = stringUtf8;
                    return stringUtf8;
                }
                return (String) obj;
            }

            @Override // com.irisdt.client.live.LiveProtos.LiveProtoOrBuilder
            public ByteString getGradeBytes() {
                Object obj = this.grade_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.grade_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // com.irisdt.client.live.LiveProtos.LiveProtoOrBuilder
            public String getId() {
                Object obj = this.id_;
                if (!(obj instanceof String)) {
                    String stringUtf8 = ((ByteString) obj).toStringUtf8();
                    this.id_ = stringUtf8;
                    return stringUtf8;
                }
                return (String) obj;
            }

            @Override // com.irisdt.client.live.LiveProtos.LiveProtoOrBuilder
            public ByteString getIdBytes() {
                Object obj = this.id_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.id_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // com.irisdt.client.live.LiveProtos.LiveProtoOrBuilder
            public int getIndex() {
                return this.index_;
            }

            @Override // com.irisdt.client.live.LiveProtos.LiveProtoOrBuilder
            public boolean getIsBool() {
                return this.isBool_;
            }

            @Override // com.irisdt.client.live.LiveProtos.LiveProtoOrBuilder
            public boolean getIsFirst() {
                return this.isFirst_;
            }

            @Override // com.irisdt.client.live.LiveProtos.LiveProtoOrBuilder
            public boolean getIsLiveShow() {
                return this.isLiveShow_;
            }

            @Override // com.irisdt.client.live.LiveProtos.LiveProtoOrBuilder
            public boolean getIsLiveWindow() {
                return this.isLiveWindow_;
            }

            @Override // com.irisdt.client.live.LiveProtos.LiveProtoOrBuilder
            public boolean getIsRedPacket() {
                return this.isRedPacket_;
            }

            @Override // com.irisdt.client.live.LiveProtos.LiveProtoOrBuilder
            public boolean getIsTreasure() {
                return this.isTreasure_;
            }

            @Override // com.irisdt.client.live.LiveProtos.LiveProtoOrBuilder
            public boolean getIsTrigger() {
                return this.isTrigger_;
            }

            @Override // com.irisdt.client.live.LiveProtos.LiveProtoOrBuilder
            public boolean getIsTrue() {
                return this.isTrue_;
            }

            @Override // com.irisdt.client.live.LiveProtos.LiveProtoOrBuilder
            public int getLevel() {
                return this.level_;
            }

            @Override // com.irisdt.client.live.LiveProtos.LiveProtoOrBuilder
            public String getLiveId() {
                Object obj = this.liveId_;
                if (!(obj instanceof String)) {
                    String stringUtf8 = ((ByteString) obj).toStringUtf8();
                    this.liveId_ = stringUtf8;
                    return stringUtf8;
                }
                return (String) obj;
            }

            @Override // com.irisdt.client.live.LiveProtos.LiveProtoOrBuilder
            public ByteString getLiveIdBytes() {
                Object obj = this.liveId_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.liveId_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // com.irisdt.client.live.LiveProtos.LiveProtoOrBuilder
            public String getName() {
                Object obj = this.name_;
                if (!(obj instanceof String)) {
                    String stringUtf8 = ((ByteString) obj).toStringUtf8();
                    this.name_ = stringUtf8;
                    return stringUtf8;
                }
                return (String) obj;
            }

            @Override // com.irisdt.client.live.LiveProtos.LiveProtoOrBuilder
            public ByteString getNameBytes() {
                Object obj = this.name_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.name_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // com.irisdt.client.live.LiveProtos.LiveProtoOrBuilder
            public int getNum() {
                return this.num_;
            }

            @Override // com.irisdt.client.live.LiveProtos.LiveProtoOrBuilder
            public String getReason() {
                Object obj = this.reason_;
                if (!(obj instanceof String)) {
                    String stringUtf8 = ((ByteString) obj).toStringUtf8();
                    this.reason_ = stringUtf8;
                    return stringUtf8;
                }
                return (String) obj;
            }

            @Override // com.irisdt.client.live.LiveProtos.LiveProtoOrBuilder
            public ByteString getReasonBytes() {
                Object obj = this.reason_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.reason_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // com.irisdt.client.live.LiveProtos.LiveProtoOrBuilder
            public String getRedPacketType() {
                Object obj = this.redPacketType_;
                if (!(obj instanceof String)) {
                    String stringUtf8 = ((ByteString) obj).toStringUtf8();
                    this.redPacketType_ = stringUtf8;
                    return stringUtf8;
                }
                return (String) obj;
            }

            @Override // com.irisdt.client.live.LiveProtos.LiveProtoOrBuilder
            public ByteString getRedPacketTypeBytes() {
                Object obj = this.redPacketType_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.redPacketType_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // com.irisdt.client.live.LiveProtos.LiveProtoOrBuilder
            public String getRequestId() {
                Object obj = this.requestId_;
                if (!(obj instanceof String)) {
                    String stringUtf8 = ((ByteString) obj).toStringUtf8();
                    this.requestId_ = stringUtf8;
                    return stringUtf8;
                }
                return (String) obj;
            }

            @Override // com.irisdt.client.live.LiveProtos.LiveProtoOrBuilder
            public ByteString getRequestIdBytes() {
                Object obj = this.requestId_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.requestId_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // com.irisdt.client.live.LiveProtos.LiveProtoOrBuilder
            public Result getResult() {
                Result valueOf = Result.valueOf(this.result_);
                return valueOf == null ? Result.UNRECOGNIZED : valueOf;
            }

            @Override // com.irisdt.client.live.LiveProtos.LiveProtoOrBuilder
            public int getResultValue() {
                return this.result_;
            }

            @Override // com.irisdt.client.live.LiveProtos.LiveProtoOrBuilder
            public String getScene() {
                Object obj = this.scene_;
                if (!(obj instanceof String)) {
                    String stringUtf8 = ((ByteString) obj).toStringUtf8();
                    this.scene_ = stringUtf8;
                    return stringUtf8;
                }
                return (String) obj;
            }

            @Override // com.irisdt.client.live.LiveProtos.LiveProtoOrBuilder
            public ByteString getSceneBytes() {
                Object obj = this.scene_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.scene_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // com.irisdt.client.live.LiveProtos.LiveProtoOrBuilder
            public double getScore() {
                return this.score_;
            }

            @Override // com.irisdt.client.live.LiveProtos.LiveProtoOrBuilder
            public String getSku() {
                Object obj = this.sku_;
                if (!(obj instanceof String)) {
                    String stringUtf8 = ((ByteString) obj).toStringUtf8();
                    this.sku_ = stringUtf8;
                    return stringUtf8;
                }
                return (String) obj;
            }

            @Override // com.irisdt.client.live.LiveProtos.LiveProtoOrBuilder
            public ByteString getSkuBytes() {
                Object obj = this.sku_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.sku_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // com.irisdt.client.live.LiveProtos.LiveProtoOrBuilder
            public String getSource() {
                Object obj = this.source_;
                if (!(obj instanceof String)) {
                    String stringUtf8 = ((ByteString) obj).toStringUtf8();
                    this.source_ = stringUtf8;
                    return stringUtf8;
                }
                return (String) obj;
            }

            @Override // com.irisdt.client.live.LiveProtos.LiveProtoOrBuilder
            public ByteString getSourceBytes() {
                Object obj = this.source_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.source_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // com.irisdt.client.live.LiveProtos.LiveProtoOrBuilder
            public String getStatus() {
                Object obj = this.status_;
                if (!(obj instanceof String)) {
                    String stringUtf8 = ((ByteString) obj).toStringUtf8();
                    this.status_ = stringUtf8;
                    return stringUtf8;
                }
                return (String) obj;
            }

            @Override // com.irisdt.client.live.LiveProtos.LiveProtoOrBuilder
            public ByteString getStatusBytes() {
                Object obj = this.status_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.status_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // com.irisdt.client.live.LiveProtos.LiveProtoOrBuilder
            public String getTagType() {
                Object obj = this.tagType_;
                if (!(obj instanceof String)) {
                    String stringUtf8 = ((ByteString) obj).toStringUtf8();
                    this.tagType_ = stringUtf8;
                    return stringUtf8;
                }
                return (String) obj;
            }

            @Override // com.irisdt.client.live.LiveProtos.LiveProtoOrBuilder
            public ByteString getTagTypeBytes() {
                Object obj = this.tagType_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.tagType_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // com.irisdt.client.live.LiveProtos.LiveProtoOrBuilder
            public String getTargetUid() {
                Object obj = this.targetUid_;
                if (!(obj instanceof String)) {
                    String stringUtf8 = ((ByteString) obj).toStringUtf8();
                    this.targetUid_ = stringUtf8;
                    return stringUtf8;
                }
                return (String) obj;
            }

            @Override // com.irisdt.client.live.LiveProtos.LiveProtoOrBuilder
            public ByteString getTargetUidBytes() {
                Object obj = this.targetUid_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.targetUid_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // com.irisdt.client.live.LiveProtos.LiveProtoOrBuilder
            public int getTime() {
                return this.time_;
            }

            @Override // com.irisdt.client.live.LiveProtos.LiveProtoOrBuilder
            public int getTimes() {
                return this.times_;
            }

            @Override // com.irisdt.client.live.LiveProtos.LiveProtoOrBuilder
            public String getTitle() {
                Object obj = this.title_;
                if (!(obj instanceof String)) {
                    String stringUtf8 = ((ByteString) obj).toStringUtf8();
                    this.title_ = stringUtf8;
                    return stringUtf8;
                }
                return (String) obj;
            }

            @Override // com.irisdt.client.live.LiveProtos.LiveProtoOrBuilder
            public ByteString getTitleBytes() {
                Object obj = this.title_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.title_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // com.irisdt.client.live.LiveProtos.LiveProtoOrBuilder
            public Type getType() {
                Type valueOf = Type.valueOf(this.type_);
                return valueOf == null ? Type.UNRECOGNIZED : valueOf;
            }

            @Override // com.irisdt.client.live.LiveProtos.LiveProtoOrBuilder
            public int getTypeValue() {
                return this.type_;
            }

            @Override // com.irisdt.client.live.LiveProtos.LiveProtoOrBuilder
            public String getUserTag() {
                Object obj = this.userTag_;
                if (!(obj instanceof String)) {
                    String stringUtf8 = ((ByteString) obj).toStringUtf8();
                    this.userTag_ = stringUtf8;
                    return stringUtf8;
                }
                return (String) obj;
            }

            @Override // com.irisdt.client.live.LiveProtos.LiveProtoOrBuilder
            public ByteString getUserTagBytes() {
                Object obj = this.userTag_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.userTag_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // com.irisdt.client.live.LiveProtos.LiveProtoOrBuilder
            public String getUserType() {
                Object obj = this.userType_;
                if (!(obj instanceof String)) {
                    String stringUtf8 = ((ByteString) obj).toStringUtf8();
                    this.userType_ = stringUtf8;
                    return stringUtf8;
                }
                return (String) obj;
            }

            @Override // com.irisdt.client.live.LiveProtos.LiveProtoOrBuilder
            public ByteString getUserTypeBytes() {
                Object obj = this.userType_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.userType_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // com.irisdt.client.live.LiveProtos.LiveProtoOrBuilder
            public float getWorth() {
                return this.worth_;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return LiveProtos.internal_static_com_irisdt_client_live_LiveProto_fieldAccessorTable.ensureFieldAccessorsInitialized(LiveProto.class, Builder.class);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return true;
            }

            public Builder setActivityFirst(String str) {
                Objects.requireNonNull(str);
                this.activityFirst_ = str;
                onChanged();
                return this;
            }

            public Builder setActivityFirstBytes(ByteString byteString) {
                Objects.requireNonNull(byteString);
                AbstractMessageLite.checkByteStringIsUtf8(byteString);
                this.activityFirst_ = byteString;
                onChanged();
                return this;
            }

            public Builder setActivitySecond(String str) {
                Objects.requireNonNull(str);
                this.activitySecond_ = str;
                onChanged();
                return this;
            }

            public Builder setActivitySecondBytes(ByteString byteString) {
                Objects.requireNonNull(byteString);
                AbstractMessageLite.checkByteStringIsUtf8(byteString);
                this.activitySecond_ = byteString;
                onChanged();
                return this;
            }

            public Builder setAnchorUid(String str) {
                Objects.requireNonNull(str);
                this.anchorUid_ = str;
                onChanged();
                return this;
            }

            public Builder setAnchorUidBytes(ByteString byteString) {
                Objects.requireNonNull(byteString);
                AbstractMessageLite.checkByteStringIsUtf8(byteString);
                this.anchorUid_ = byteString;
                onChanged();
                return this;
            }

            public Builder setConnectType(String str) {
                Objects.requireNonNull(str);
                this.connectType_ = str;
                onChanged();
                return this;
            }

            public Builder setConnectTypeBytes(ByteString byteString) {
                Objects.requireNonNull(byteString);
                AbstractMessageLite.checkByteStringIsUtf8(byteString);
                this.connectType_ = byteString;
                onChanged();
                return this;
            }

            public Builder setContent(String str) {
                Objects.requireNonNull(str);
                this.content_ = str;
                onChanged();
                return this;
            }

            public Builder setContentBytes(ByteString byteString) {
                Objects.requireNonNull(byteString);
                AbstractMessageLite.checkByteStringIsUtf8(byteString);
                this.content_ = byteString;
                onChanged();
                return this;
            }

            public Builder setCount(int i10) {
                this.count_ = i10;
                onChanged();
                return this;
            }

            public Builder setCoverType(CoverType coverType) {
                Objects.requireNonNull(coverType);
                this.coverType_ = coverType.getNumber();
                onChanged();
                return this;
            }

            public Builder setCoverTypeValue(int i10) {
                this.coverType_ = i10;
                onChanged();
                return this;
            }

            public Builder setEvent(Event event) {
                Objects.requireNonNull(event);
                this.event_ = event.getNumber();
                onChanged();
                return this;
            }

            public Builder setEventValue(int i10) {
                this.event_ = i10;
                onChanged();
                return this;
            }

            public Builder setFrom(String str) {
                Objects.requireNonNull(str);
                this.from_ = str;
                onChanged();
                return this;
            }

            public Builder setFromBytes(ByteString byteString) {
                Objects.requireNonNull(byteString);
                AbstractMessageLite.checkByteStringIsUtf8(byteString);
                this.from_ = byteString;
                onChanged();
                return this;
            }

            public Builder setGrade(String str) {
                Objects.requireNonNull(str);
                this.grade_ = str;
                onChanged();
                return this;
            }

            public Builder setGradeBytes(ByteString byteString) {
                Objects.requireNonNull(byteString);
                AbstractMessageLite.checkByteStringIsUtf8(byteString);
                this.grade_ = byteString;
                onChanged();
                return this;
            }

            public Builder setId(String str) {
                Objects.requireNonNull(str);
                this.id_ = str;
                onChanged();
                return this;
            }

            public Builder setIdBytes(ByteString byteString) {
                Objects.requireNonNull(byteString);
                AbstractMessageLite.checkByteStringIsUtf8(byteString);
                this.id_ = byteString;
                onChanged();
                return this;
            }

            public Builder setIndex(int i10) {
                this.index_ = i10;
                onChanged();
                return this;
            }

            public Builder setIsBool(boolean z10) {
                this.isBool_ = z10;
                onChanged();
                return this;
            }

            public Builder setIsFirst(boolean z10) {
                this.isFirst_ = z10;
                onChanged();
                return this;
            }

            public Builder setIsLiveShow(boolean z10) {
                this.isLiveShow_ = z10;
                onChanged();
                return this;
            }

            public Builder setIsLiveWindow(boolean z10) {
                this.isLiveWindow_ = z10;
                onChanged();
                return this;
            }

            public Builder setIsRedPacket(boolean z10) {
                this.isRedPacket_ = z10;
                onChanged();
                return this;
            }

            public Builder setIsTreasure(boolean z10) {
                this.isTreasure_ = z10;
                onChanged();
                return this;
            }

            public Builder setIsTrigger(boolean z10) {
                this.isTrigger_ = z10;
                onChanged();
                return this;
            }

            public Builder setIsTrue(boolean z10) {
                this.isTrue_ = z10;
                onChanged();
                return this;
            }

            public Builder setLevel(int i10) {
                this.level_ = i10;
                onChanged();
                return this;
            }

            public Builder setLiveId(String str) {
                Objects.requireNonNull(str);
                this.liveId_ = str;
                onChanged();
                return this;
            }

            public Builder setLiveIdBytes(ByteString byteString) {
                Objects.requireNonNull(byteString);
                AbstractMessageLite.checkByteStringIsUtf8(byteString);
                this.liveId_ = byteString;
                onChanged();
                return this;
            }

            public Builder setName(String str) {
                Objects.requireNonNull(str);
                this.name_ = str;
                onChanged();
                return this;
            }

            public Builder setNameBytes(ByteString byteString) {
                Objects.requireNonNull(byteString);
                AbstractMessageLite.checkByteStringIsUtf8(byteString);
                this.name_ = byteString;
                onChanged();
                return this;
            }

            public Builder setNum(int i10) {
                this.num_ = i10;
                onChanged();
                return this;
            }

            public Builder setReason(String str) {
                Objects.requireNonNull(str);
                this.reason_ = str;
                onChanged();
                return this;
            }

            public Builder setReasonBytes(ByteString byteString) {
                Objects.requireNonNull(byteString);
                AbstractMessageLite.checkByteStringIsUtf8(byteString);
                this.reason_ = byteString;
                onChanged();
                return this;
            }

            public Builder setRedPacketType(String str) {
                Objects.requireNonNull(str);
                this.redPacketType_ = str;
                onChanged();
                return this;
            }

            public Builder setRedPacketTypeBytes(ByteString byteString) {
                Objects.requireNonNull(byteString);
                AbstractMessageLite.checkByteStringIsUtf8(byteString);
                this.redPacketType_ = byteString;
                onChanged();
                return this;
            }

            public Builder setRequestId(String str) {
                Objects.requireNonNull(str);
                this.requestId_ = str;
                onChanged();
                return this;
            }

            public Builder setRequestIdBytes(ByteString byteString) {
                Objects.requireNonNull(byteString);
                AbstractMessageLite.checkByteStringIsUtf8(byteString);
                this.requestId_ = byteString;
                onChanged();
                return this;
            }

            public Builder setResult(Result result) {
                Objects.requireNonNull(result);
                this.result_ = result.getNumber();
                onChanged();
                return this;
            }

            public Builder setResultValue(int i10) {
                this.result_ = i10;
                onChanged();
                return this;
            }

            public Builder setScene(String str) {
                Objects.requireNonNull(str);
                this.scene_ = str;
                onChanged();
                return this;
            }

            public Builder setSceneBytes(ByteString byteString) {
                Objects.requireNonNull(byteString);
                AbstractMessageLite.checkByteStringIsUtf8(byteString);
                this.scene_ = byteString;
                onChanged();
                return this;
            }

            public Builder setScore(double d10) {
                this.score_ = d10;
                onChanged();
                return this;
            }

            public Builder setSku(String str) {
                Objects.requireNonNull(str);
                this.sku_ = str;
                onChanged();
                return this;
            }

            public Builder setSkuBytes(ByteString byteString) {
                Objects.requireNonNull(byteString);
                AbstractMessageLite.checkByteStringIsUtf8(byteString);
                this.sku_ = byteString;
                onChanged();
                return this;
            }

            public Builder setSource(String str) {
                Objects.requireNonNull(str);
                this.source_ = str;
                onChanged();
                return this;
            }

            public Builder setSourceBytes(ByteString byteString) {
                Objects.requireNonNull(byteString);
                AbstractMessageLite.checkByteStringIsUtf8(byteString);
                this.source_ = byteString;
                onChanged();
                return this;
            }

            public Builder setStatus(String str) {
                Objects.requireNonNull(str);
                this.status_ = str;
                onChanged();
                return this;
            }

            public Builder setStatusBytes(ByteString byteString) {
                Objects.requireNonNull(byteString);
                AbstractMessageLite.checkByteStringIsUtf8(byteString);
                this.status_ = byteString;
                onChanged();
                return this;
            }

            public Builder setTagType(String str) {
                Objects.requireNonNull(str);
                this.tagType_ = str;
                onChanged();
                return this;
            }

            public Builder setTagTypeBytes(ByteString byteString) {
                Objects.requireNonNull(byteString);
                AbstractMessageLite.checkByteStringIsUtf8(byteString);
                this.tagType_ = byteString;
                onChanged();
                return this;
            }

            public Builder setTargetUid(String str) {
                Objects.requireNonNull(str);
                this.targetUid_ = str;
                onChanged();
                return this;
            }

            public Builder setTargetUidBytes(ByteString byteString) {
                Objects.requireNonNull(byteString);
                AbstractMessageLite.checkByteStringIsUtf8(byteString);
                this.targetUid_ = byteString;
                onChanged();
                return this;
            }

            public Builder setTime(int i10) {
                this.time_ = i10;
                onChanged();
                return this;
            }

            public Builder setTimes(int i10) {
                this.times_ = i10;
                onChanged();
                return this;
            }

            public Builder setTitle(String str) {
                Objects.requireNonNull(str);
                this.title_ = str;
                onChanged();
                return this;
            }

            public Builder setTitleBytes(ByteString byteString) {
                Objects.requireNonNull(byteString);
                AbstractMessageLite.checkByteStringIsUtf8(byteString);
                this.title_ = byteString;
                onChanged();
                return this;
            }

            public Builder setType(Type type) {
                Objects.requireNonNull(type);
                this.type_ = type.getNumber();
                onChanged();
                return this;
            }

            public Builder setTypeValue(int i10) {
                this.type_ = i10;
                onChanged();
                return this;
            }

            public Builder setUserTag(String str) {
                Objects.requireNonNull(str);
                this.userTag_ = str;
                onChanged();
                return this;
            }

            public Builder setUserTagBytes(ByteString byteString) {
                Objects.requireNonNull(byteString);
                AbstractMessageLite.checkByteStringIsUtf8(byteString);
                this.userTag_ = byteString;
                onChanged();
                return this;
            }

            public Builder setUserType(String str) {
                Objects.requireNonNull(str);
                this.userType_ = str;
                onChanged();
                return this;
            }

            public Builder setUserTypeBytes(ByteString byteString) {
                Objects.requireNonNull(byteString);
                AbstractMessageLite.checkByteStringIsUtf8(byteString);
                this.userType_ = byteString;
                onChanged();
                return this;
            }

            public Builder setWorth(float f10) {
                this.worth_ = f10;
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public Builder addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (Builder) super.addRepeatedField(fieldDescriptor, obj);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public LiveProto build() {
                LiveProto buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw AbstractMessage.Builder.newUninitializedMessageException((Message) buildPartial);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public LiveProto buildPartial() {
                LiveProto liveProto = new LiveProto(this);
                liveProto.event_ = this.event_;
                liveProto.type_ = this.type_;
                liveProto.liveId_ = this.liveId_;
                liveProto.anchorUid_ = this.anchorUid_;
                liveProto.num_ = this.num_;
                liveProto.id_ = this.id_;
                liveProto.isTrue_ = this.isTrue_;
                liveProto.time_ = this.time_;
                liveProto.worth_ = this.worth_;
                liveProto.content_ = this.content_;
                liveProto.from_ = this.from_;
                liveProto.count_ = this.count_;
                liveProto.level_ = this.level_;
                liveProto.scene_ = this.scene_;
                liveProto.isBool_ = this.isBool_;
                liveProto.result_ = this.result_;
                liveProto.status_ = this.status_;
                liveProto.source_ = this.source_;
                liveProto.coverType_ = this.coverType_;
                liveProto.tagType_ = this.tagType_;
                liveProto.userType_ = this.userType_;
                liveProto.score_ = this.score_;
                liveProto.title_ = this.title_;
                liveProto.name_ = this.name_;
                liveProto.connectType_ = this.connectType_;
                liveProto.userTag_ = this.userTag_;
                liveProto.targetUid_ = this.targetUid_;
                liveProto.isLiveShow_ = this.isLiveShow_;
                liveProto.isTreasure_ = this.isTreasure_;
                liveProto.isRedPacket_ = this.isRedPacket_;
                liveProto.isLiveWindow_ = this.isLiveWindow_;
                liveProto.redPacketType_ = this.redPacketType_;
                liveProto.isTrigger_ = this.isTrigger_;
                liveProto.times_ = this.times_;
                liveProto.activityFirst_ = this.activityFirst_;
                liveProto.activitySecond_ = this.activitySecond_;
                liveProto.index_ = this.index_;
                liveProto.sku_ = this.sku_;
                liveProto.isFirst_ = this.isFirst_;
                liveProto.grade_ = this.grade_;
                liveProto.reason_ = this.reason_;
                liveProto.requestId_ = this.requestId_;
                onBuilt();
                return liveProto;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public Builder clearField(Descriptors.FieldDescriptor fieldDescriptor) {
                return (Builder) super.clearField(fieldDescriptor);
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public LiveProto getDefaultInstanceForType() {
                return LiveProto.getDefaultInstance();
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public Builder setField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (Builder) super.setField(fieldDescriptor, obj);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public Builder setRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, int i10, Object obj) {
                return (Builder) super.setRepeatedField(fieldDescriptor, i10, obj);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public final Builder setUnknownFields(UnknownFieldSet unknownFieldSet) {
                return (Builder) super.setUnknownFields(unknownFieldSet);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public Builder clearOneof(Descriptors.OneofDescriptor oneofDescriptor) {
                return (Builder) super.clearOneof(oneofDescriptor);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public final Builder mergeUnknownFields(UnknownFieldSet unknownFieldSet) {
                return (Builder) super.mergeUnknownFields(unknownFieldSet);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                super.clear();
                this.event_ = 0;
                this.type_ = 0;
                this.liveId_ = "";
                this.anchorUid_ = "";
                this.num_ = 0;
                this.id_ = "";
                this.isTrue_ = false;
                this.time_ = 0;
                this.worth_ = 0.0f;
                this.content_ = "";
                this.from_ = "";
                this.count_ = 0;
                this.level_ = 0;
                this.scene_ = "";
                this.isBool_ = false;
                this.result_ = 0;
                this.status_ = "";
                this.source_ = "";
                this.coverType_ = 0;
                this.tagType_ = "";
                this.userType_ = "";
                this.score_ = ShadowDrawableWrapper.COS_45;
                this.title_ = "";
                this.name_ = "";
                this.connectType_ = "";
                this.userTag_ = "";
                this.targetUid_ = "";
                this.isLiveShow_ = false;
                this.isTreasure_ = false;
                this.isRedPacket_ = false;
                this.isLiveWindow_ = false;
                this.redPacketType_ = "";
                this.isTrigger_ = false;
                this.times_ = 0;
                this.activityFirst_ = "";
                this.activitySecond_ = "";
                this.index_ = 0;
                this.sku_ = "";
                this.isFirst_ = false;
                this.grade_ = "";
                this.reason_ = "";
                this.requestId_ = "";
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder
            /* renamed from: clone */
            public Builder mo2458clone() {
                return (Builder) super.mo2458clone();
            }

            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public Builder mergeFrom(Message message) {
                if (message instanceof LiveProto) {
                    return mergeFrom((LiveProto) message);
                }
                super.mergeFrom(message);
                return this;
            }

            public Builder mergeFrom(LiveProto liveProto) {
                if (liveProto == LiveProto.getDefaultInstance()) {
                    return this;
                }
                if (liveProto.event_ != 0) {
                    setEventValue(liveProto.getEventValue());
                }
                if (liveProto.type_ != 0) {
                    setTypeValue(liveProto.getTypeValue());
                }
                if (!liveProto.getLiveId().isEmpty()) {
                    this.liveId_ = liveProto.liveId_;
                    onChanged();
                }
                if (!liveProto.getAnchorUid().isEmpty()) {
                    this.anchorUid_ = liveProto.anchorUid_;
                    onChanged();
                }
                if (liveProto.getNum() != 0) {
                    setNum(liveProto.getNum());
                }
                if (!liveProto.getId().isEmpty()) {
                    this.id_ = liveProto.id_;
                    onChanged();
                }
                if (liveProto.getIsTrue()) {
                    setIsTrue(liveProto.getIsTrue());
                }
                if (liveProto.getTime() != 0) {
                    setTime(liveProto.getTime());
                }
                if (liveProto.getWorth() != 0.0f) {
                    setWorth(liveProto.getWorth());
                }
                if (!liveProto.getContent().isEmpty()) {
                    this.content_ = liveProto.content_;
                    onChanged();
                }
                if (!liveProto.getFrom().isEmpty()) {
                    this.from_ = liveProto.from_;
                    onChanged();
                }
                if (liveProto.getCount() != 0) {
                    setCount(liveProto.getCount());
                }
                if (liveProto.getLevel() != 0) {
                    setLevel(liveProto.getLevel());
                }
                if (!liveProto.getScene().isEmpty()) {
                    this.scene_ = liveProto.scene_;
                    onChanged();
                }
                if (liveProto.getIsBool()) {
                    setIsBool(liveProto.getIsBool());
                }
                if (liveProto.result_ != 0) {
                    setResultValue(liveProto.getResultValue());
                }
                if (!liveProto.getStatus().isEmpty()) {
                    this.status_ = liveProto.status_;
                    onChanged();
                }
                if (!liveProto.getSource().isEmpty()) {
                    this.source_ = liveProto.source_;
                    onChanged();
                }
                if (liveProto.coverType_ != 0) {
                    setCoverTypeValue(liveProto.getCoverTypeValue());
                }
                if (!liveProto.getTagType().isEmpty()) {
                    this.tagType_ = liveProto.tagType_;
                    onChanged();
                }
                if (!liveProto.getUserType().isEmpty()) {
                    this.userType_ = liveProto.userType_;
                    onChanged();
                }
                if (liveProto.getScore() != ShadowDrawableWrapper.COS_45) {
                    setScore(liveProto.getScore());
                }
                if (!liveProto.getTitle().isEmpty()) {
                    this.title_ = liveProto.title_;
                    onChanged();
                }
                if (!liveProto.getName().isEmpty()) {
                    this.name_ = liveProto.name_;
                    onChanged();
                }
                if (!liveProto.getConnectType().isEmpty()) {
                    this.connectType_ = liveProto.connectType_;
                    onChanged();
                }
                if (!liveProto.getUserTag().isEmpty()) {
                    this.userTag_ = liveProto.userTag_;
                    onChanged();
                }
                if (!liveProto.getTargetUid().isEmpty()) {
                    this.targetUid_ = liveProto.targetUid_;
                    onChanged();
                }
                if (liveProto.getIsLiveShow()) {
                    setIsLiveShow(liveProto.getIsLiveShow());
                }
                if (liveProto.getIsTreasure()) {
                    setIsTreasure(liveProto.getIsTreasure());
                }
                if (liveProto.getIsRedPacket()) {
                    setIsRedPacket(liveProto.getIsRedPacket());
                }
                if (liveProto.getIsLiveWindow()) {
                    setIsLiveWindow(liveProto.getIsLiveWindow());
                }
                if (!liveProto.getRedPacketType().isEmpty()) {
                    this.redPacketType_ = liveProto.redPacketType_;
                    onChanged();
                }
                if (liveProto.getIsTrigger()) {
                    setIsTrigger(liveProto.getIsTrigger());
                }
                if (liveProto.getTimes() != 0) {
                    setTimes(liveProto.getTimes());
                }
                if (!liveProto.getActivityFirst().isEmpty()) {
                    this.activityFirst_ = liveProto.activityFirst_;
                    onChanged();
                }
                if (!liveProto.getActivitySecond().isEmpty()) {
                    this.activitySecond_ = liveProto.activitySecond_;
                    onChanged();
                }
                if (liveProto.getIndex() != 0) {
                    setIndex(liveProto.getIndex());
                }
                if (!liveProto.getSku().isEmpty()) {
                    this.sku_ = liveProto.sku_;
                    onChanged();
                }
                if (liveProto.getIsFirst()) {
                    setIsFirst(liveProto.getIsFirst());
                }
                if (!liveProto.getGrade().isEmpty()) {
                    this.grade_ = liveProto.grade_;
                    onChanged();
                }
                if (!liveProto.getReason().isEmpty()) {
                    this.reason_ = liveProto.reason_;
                    onChanged();
                }
                if (!liveProto.getRequestId().isEmpty()) {
                    this.requestId_ = liveProto.requestId_;
                    onChanged();
                }
                mergeUnknownFields(liveProto.unknownFields);
                onChanged();
                return this;
            }

            private Builder(GeneratedMessageV3.BuilderParent builderParent) {
                super(builderParent);
                this.event_ = 0;
                this.type_ = 0;
                this.liveId_ = "";
                this.anchorUid_ = "";
                this.id_ = "";
                this.content_ = "";
                this.from_ = "";
                this.scene_ = "";
                this.result_ = 0;
                this.status_ = "";
                this.source_ = "";
                this.coverType_ = 0;
                this.tagType_ = "";
                this.userType_ = "";
                this.title_ = "";
                this.name_ = "";
                this.connectType_ = "";
                this.userTag_ = "";
                this.targetUid_ = "";
                this.redPacketType_ = "";
                this.activityFirst_ = "";
                this.activitySecond_ = "";
                this.sku_ = "";
                this.grade_ = "";
                this.reason_ = "";
                this.requestId_ = "";
                maybeForceBuilderInitialization();
            }

            /* JADX WARN: Removed duplicated region for block: B:11:0x0023  */
            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public com.irisdt.client.live.LiveProtos.LiveProto.Builder mergeFrom(com.google.protobuf.CodedInputStream r3, com.google.protobuf.ExtensionRegistryLite r4) throws java.io.IOException {
                /*
                    r2 = this;
                    r0 = 0
                    com.google.protobuf.Parser r1 = com.irisdt.client.live.LiveProtos.LiveProto.q0()     // Catch: java.lang.Throwable -> L11 com.google.protobuf.InvalidProtocolBufferException -> L13
                    java.lang.Object r3 = r1.parsePartialFrom(r3, r4)     // Catch: java.lang.Throwable -> L11 com.google.protobuf.InvalidProtocolBufferException -> L13
                    com.irisdt.client.live.LiveProtos$LiveProto r3 = (com.irisdt.client.live.LiveProtos.LiveProto) r3     // Catch: java.lang.Throwable -> L11 com.google.protobuf.InvalidProtocolBufferException -> L13
                    if (r3 == 0) goto L10
                    r2.mergeFrom(r3)
                L10:
                    return r2
                L11:
                    r3 = move-exception
                    goto L21
                L13:
                    r3 = move-exception
                    com.google.protobuf.MessageLite r4 = r3.getUnfinishedMessage()     // Catch: java.lang.Throwable -> L11
                    com.irisdt.client.live.LiveProtos$LiveProto r4 = (com.irisdt.client.live.LiveProtos.LiveProto) r4     // Catch: java.lang.Throwable -> L11
                    java.io.IOException r3 = r3.unwrapIOException()     // Catch: java.lang.Throwable -> L1f
                    throw r3     // Catch: java.lang.Throwable -> L1f
                L1f:
                    r3 = move-exception
                    r0 = r4
                L21:
                    if (r0 == 0) goto L26
                    r2.mergeFrom(r0)
                L26:
                    throw r3
                */
                throw new UnsupportedOperationException("Method not decompiled: com.irisdt.client.live.LiveProtos.LiveProto.Builder.mergeFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):com.irisdt.client.live.LiveProtos$LiveProto$Builder");
            }
        }

        public static Builder newBuilder(LiveProto liveProto) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(liveProto);
        }

        public static LiveProto parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
        }

        private LiveProto() {
            this.memoizedIsInitialized = (byte) -1;
            this.event_ = 0;
            this.type_ = 0;
            this.liveId_ = "";
            this.anchorUid_ = "";
            this.id_ = "";
            this.content_ = "";
            this.from_ = "";
            this.scene_ = "";
            this.result_ = 0;
            this.status_ = "";
            this.source_ = "";
            this.coverType_ = 0;
            this.tagType_ = "";
            this.userType_ = "";
            this.title_ = "";
            this.name_ = "";
            this.connectType_ = "";
            this.userTag_ = "";
            this.targetUid_ = "";
            this.redPacketType_ = "";
            this.activityFirst_ = "";
            this.activitySecond_ = "";
            this.sku_ = "";
            this.grade_ = "";
            this.reason_ = "";
            this.requestId_ = "";
        }

        public static LiveProto parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (LiveProto) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static LiveProto parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public LiveProto getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder toBuilder() {
            return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
        }

        public static LiveProto parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static LiveProto parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        public Builder newBuilderForType(GeneratedMessageV3.BuilderParent builderParent) {
            return new Builder(builderParent);
        }

        public static LiveProto parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        public static LiveProto parseFrom(InputStream inputStream) throws IOException {
            return (LiveProto) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
        }

        public static LiveProto parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (LiveProto) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static LiveProto parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (LiveProto) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
        }

        public static LiveProto parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (LiveProto) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
        }

        /* JADX WARN: Failed to find 'out' block for switch in B:5:0x0012. Please report as an issue. */
        private LiveProto(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            this();
            Objects.requireNonNull(extensionRegistryLite);
            UnknownFieldSet.Builder newBuilder = UnknownFieldSet.newBuilder();
            boolean z10 = false;
            while (!z10) {
                try {
                    try {
                        try {
                            int readTag = codedInputStream.readTag();
                            switch (readTag) {
                                case 0:
                                    z10 = true;
                                case 8:
                                    this.event_ = codedInputStream.readEnum();
                                case 16:
                                    this.type_ = codedInputStream.readEnum();
                                case 26:
                                    this.liveId_ = codedInputStream.readStringRequireUtf8();
                                case 34:
                                    this.anchorUid_ = codedInputStream.readStringRequireUtf8();
                                case 40:
                                    this.num_ = codedInputStream.readInt32();
                                case 50:
                                    this.id_ = codedInputStream.readStringRequireUtf8();
                                case 56:
                                    this.isTrue_ = codedInputStream.readBool();
                                case 64:
                                    this.time_ = codedInputStream.readInt32();
                                case 77:
                                    this.worth_ = codedInputStream.readFloat();
                                case 82:
                                    this.content_ = codedInputStream.readStringRequireUtf8();
                                case 90:
                                    this.from_ = codedInputStream.readStringRequireUtf8();
                                case 96:
                                    this.count_ = codedInputStream.readInt32();
                                case 104:
                                    this.level_ = codedInputStream.readInt32();
                                case 114:
                                    this.scene_ = codedInputStream.readStringRequireUtf8();
                                case 120:
                                    this.isBool_ = codedInputStream.readBool();
                                case 128:
                                    this.result_ = codedInputStream.readEnum();
                                case 138:
                                    this.status_ = codedInputStream.readStringRequireUtf8();
                                case 146:
                                    this.source_ = codedInputStream.readStringRequireUtf8();
                                case 152:
                                    this.coverType_ = codedInputStream.readEnum();
                                case 162:
                                    this.tagType_ = codedInputStream.readStringRequireUtf8();
                                case 170:
                                    this.userType_ = codedInputStream.readStringRequireUtf8();
                                case 177:
                                    this.score_ = codedInputStream.readDouble();
                                case 186:
                                    this.title_ = codedInputStream.readStringRequireUtf8();
                                case 194:
                                    this.name_ = codedInputStream.readStringRequireUtf8();
                                case 202:
                                    this.connectType_ = codedInputStream.readStringRequireUtf8();
                                case 210:
                                    this.userTag_ = codedInputStream.readStringRequireUtf8();
                                case 218:
                                    this.targetUid_ = codedInputStream.readStringRequireUtf8();
                                case 224:
                                    this.isLiveShow_ = codedInputStream.readBool();
                                case 232:
                                    this.isTreasure_ = codedInputStream.readBool();
                                case 240:
                                    this.isRedPacket_ = codedInputStream.readBool();
                                case 248:
                                    this.isLiveWindow_ = codedInputStream.readBool();
                                case 258:
                                    this.redPacketType_ = codedInputStream.readStringRequireUtf8();
                                case 264:
                                    this.isTrigger_ = codedInputStream.readBool();
                                case 272:
                                    this.times_ = codedInputStream.readInt32();
                                case 282:
                                    this.activityFirst_ = codedInputStream.readStringRequireUtf8();
                                case 290:
                                    this.activitySecond_ = codedInputStream.readStringRequireUtf8();
                                case 296:
                                    this.index_ = codedInputStream.readInt32();
                                case 306:
                                    this.sku_ = codedInputStream.readStringRequireUtf8();
                                case 312:
                                    this.isFirst_ = codedInputStream.readBool();
                                case 322:
                                    this.grade_ = codedInputStream.readStringRequireUtf8();
                                case 330:
                                    this.reason_ = codedInputStream.readStringRequireUtf8();
                                case 338:
                                    this.requestId_ = codedInputStream.readStringRequireUtf8();
                                default:
                                    if (!parseUnknownField(codedInputStream, newBuilder, extensionRegistryLite, readTag)) {
                                        z10 = true;
                                    }
                            }
                        } catch (InvalidProtocolBufferException e2) {
                            throw e2.setUnfinishedMessage(this);
                        }
                    } catch (IOException e10) {
                        throw new InvalidProtocolBufferException(e10).setUnfinishedMessage(this);
                    }
                } finally {
                    this.unknownFields = newBuilder.build();
                    makeExtensionsImmutable();
                }
            }
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public interface LiveProtoOrBuilder extends MessageOrBuilder {
        String getActivityFirst();

        ByteString getActivityFirstBytes();

        String getActivitySecond();

        ByteString getActivitySecondBytes();

        String getAnchorUid();

        ByteString getAnchorUidBytes();

        String getConnectType();

        ByteString getConnectTypeBytes();

        String getContent();

        ByteString getContentBytes();

        int getCount();

        CoverType getCoverType();

        int getCoverTypeValue();

        Event getEvent();

        int getEventValue();

        String getFrom();

        ByteString getFromBytes();

        String getGrade();

        ByteString getGradeBytes();

        String getId();

        ByteString getIdBytes();

        int getIndex();

        boolean getIsBool();

        boolean getIsFirst();

        boolean getIsLiveShow();

        boolean getIsLiveWindow();

        boolean getIsRedPacket();

        boolean getIsTreasure();

        boolean getIsTrigger();

        boolean getIsTrue();

        int getLevel();

        String getLiveId();

        ByteString getLiveIdBytes();

        String getName();

        ByteString getNameBytes();

        int getNum();

        String getReason();

        ByteString getReasonBytes();

        String getRedPacketType();

        ByteString getRedPacketTypeBytes();

        String getRequestId();

        ByteString getRequestIdBytes();

        Result getResult();

        int getResultValue();

        String getScene();

        ByteString getSceneBytes();

        double getScore();

        String getSku();

        ByteString getSkuBytes();

        String getSource();

        ByteString getSourceBytes();

        String getStatus();

        ByteString getStatusBytes();

        String getTagType();

        ByteString getTagTypeBytes();

        String getTargetUid();

        ByteString getTargetUidBytes();

        int getTime();

        int getTimes();

        String getTitle();

        ByteString getTitleBytes();

        Type getType();

        int getTypeValue();

        String getUserTag();

        ByteString getUserTagBytes();

        String getUserType();

        ByteString getUserTypeBytes();

        float getWorth();
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public enum Result implements ProtocolMessageEnum {
        UNKNOWN_RESULT(0),
        SUCCESS(1),
        FAIL(2),
        DRAW(3),
        UNRECOGNIZED(-1);

        public static final int DRAW_VALUE = 3;
        public static final int FAIL_VALUE = 2;
        public static final int SUCCESS_VALUE = 1;
        public static final int UNKNOWN_RESULT_VALUE = 0;
        private final int value;
        private static final Internal.EnumLiteMap<Result> internalValueMap = new Internal.EnumLiteMap<Result>() { // from class: com.irisdt.client.live.LiveProtos.Result.1
            @Override // com.google.protobuf.Internal.EnumLiteMap
            public Result findValueByNumber(int i10) {
                return Result.forNumber(i10);
            }
        };
        private static final Result[] VALUES = values();

        Result(int i10) {
            this.value = i10;
        }

        public static Result forNumber(int i10) {
            if (i10 == 0) {
                return UNKNOWN_RESULT;
            }
            if (i10 == 1) {
                return SUCCESS;
            }
            if (i10 == 2) {
                return FAIL;
            }
            if (i10 != 3) {
                return null;
            }
            return DRAW;
        }

        public static final Descriptors.EnumDescriptor getDescriptor() {
            return LiveProtos.getDescriptor().getEnumTypes().get(2);
        }

        public static Internal.EnumLiteMap<Result> internalGetValueMap() {
            return internalValueMap;
        }

        @Override // com.google.protobuf.ProtocolMessageEnum
        public final Descriptors.EnumDescriptor getDescriptorForType() {
            return getDescriptor();
        }

        @Override // com.google.protobuf.ProtocolMessageEnum, com.google.protobuf.Internal.EnumLite
        public final int getNumber() {
            if (this != UNRECOGNIZED) {
                return this.value;
            }
            throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
        }

        @Override // com.google.protobuf.ProtocolMessageEnum
        public final Descriptors.EnumValueDescriptor getValueDescriptor() {
            if (this != UNRECOGNIZED) {
                return getDescriptor().getValues().get(ordinal());
            }
            throw new IllegalStateException("Can't get the descriptor of an unrecognized enum value.");
        }

        @Deprecated
        public static Result valueOf(int i10) {
            return forNumber(i10);
        }

        public static Result valueOf(Descriptors.EnumValueDescriptor enumValueDescriptor) {
            if (enumValueDescriptor.getType() == getDescriptor()) {
                if (enumValueDescriptor.getIndex() == -1) {
                    return UNRECOGNIZED;
                }
                return VALUES[enumValueDescriptor.getIndex()];
            }
            throw new IllegalArgumentException("EnumValueDescriptor is not for this type.");
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public enum Type implements ProtocolMessageEnum {
        UNKNOWN_TYPE(0),
        HOT(1),
        NEARBY(2),
        NEW(3),
        COMMENT(4),
        GIFT(5),
        CONNECT(6),
        PK(7),
        BEAUTY(8),
        MIRROR(9),
        MORE(10),
        REVERSE(11),
        COMMON_COMMENT(12),
        BULLET_COMMET(13),
        GIFT_DAILY(14),
        GIFT_LEVEL(15),
        GIFT_MADE(16),
        FOLLOW(17),
        RECOMMEND(18),
        RANDOM_MATCH(19),
        START_PK(20),
        ACCEPT_PK(21),
        PK_ING(22),
        PUNISHMENT(23),
        CONTENT(24),
        FANS_GROUP(25),
        LUCK_DRAW(26),
        COMMENT_GIFT(27),
        DISPLAY_GIFT(28),
        COMMENT_FOLLOW_GUIDE(29),
        BOTTOM_FOLLOW_GUIDE(30),
        CHAT_GUIDE(31),
        GIFT_GUIDE(32),
        TOP_FANS_GROUP(33),
        TOP_RED_PACKET(34),
        BOTTOM_RED_PACKET(35),
        MORE_RED_PACKET(36),
        NEW_CONNECT(37),
        MORE_COLLECT_FRAGMENT(38),
        PACKSACK_COLLECT_FRAGMENT(39),
        ANCHOR_TASK(40),
        PRIVILEGE(41),
        MORE_DRESS_UP_MALL(42),
        MORE_MY_DRESS_UP(43),
        MORE_NOBILITY(44),
        GIFT_NOBILITY(45),
        NOBILITY_FREE_BULLET_COMMENT(46),
        MORE_PASTER(47),
        MORE_GIFT_WALL(48),
        MORE_FOLLOW(49),
        FOLLOW_COUNT_DOWN(50),
        MULTI_PK(51),
        START_MULTI_PK(52),
        MULTI_PK_PUNISHMENT(53),
        SILENCE(54),
        ACCEPT_MULTI_PK(55),
        MULTI_BEFORE_START(56),
        UNRECOGNIZED(-1);

        public static final int ACCEPT_MULTI_PK_VALUE = 55;
        public static final int ACCEPT_PK_VALUE = 21;
        public static final int ANCHOR_TASK_VALUE = 40;
        public static final int BEAUTY_VALUE = 8;
        public static final int BOTTOM_FOLLOW_GUIDE_VALUE = 30;
        public static final int BOTTOM_RED_PACKET_VALUE = 35;
        public static final int BULLET_COMMET_VALUE = 13;
        public static final int CHAT_GUIDE_VALUE = 31;
        public static final int COMMENT_FOLLOW_GUIDE_VALUE = 29;
        public static final int COMMENT_GIFT_VALUE = 27;
        public static final int COMMENT_VALUE = 4;
        public static final int COMMON_COMMENT_VALUE = 12;
        public static final int CONNECT_VALUE = 6;
        public static final int CONTENT_VALUE = 24;
        public static final int DISPLAY_GIFT_VALUE = 28;
        public static final int FANS_GROUP_VALUE = 25;
        public static final int FOLLOW_COUNT_DOWN_VALUE = 50;
        public static final int FOLLOW_VALUE = 17;
        public static final int GIFT_DAILY_VALUE = 14;
        public static final int GIFT_GUIDE_VALUE = 32;
        public static final int GIFT_LEVEL_VALUE = 15;
        public static final int GIFT_MADE_VALUE = 16;
        public static final int GIFT_NOBILITY_VALUE = 45;
        public static final int GIFT_VALUE = 5;
        public static final int HOT_VALUE = 1;
        public static final int LUCK_DRAW_VALUE = 26;
        public static final int MIRROR_VALUE = 9;
        public static final int MORE_COLLECT_FRAGMENT_VALUE = 38;
        public static final int MORE_DRESS_UP_MALL_VALUE = 42;
        public static final int MORE_FOLLOW_VALUE = 49;
        public static final int MORE_GIFT_WALL_VALUE = 48;
        public static final int MORE_MY_DRESS_UP_VALUE = 43;
        public static final int MORE_NOBILITY_VALUE = 44;
        public static final int MORE_PASTER_VALUE = 47;
        public static final int MORE_RED_PACKET_VALUE = 36;
        public static final int MORE_VALUE = 10;
        public static final int MULTI_BEFORE_START_VALUE = 56;
        public static final int MULTI_PK_PUNISHMENT_VALUE = 53;
        public static final int MULTI_PK_VALUE = 51;
        public static final int NEARBY_VALUE = 2;
        public static final int NEW_CONNECT_VALUE = 37;
        public static final int NEW_VALUE = 3;
        public static final int NOBILITY_FREE_BULLET_COMMENT_VALUE = 46;
        public static final int PACKSACK_COLLECT_FRAGMENT_VALUE = 39;
        public static final int PK_ING_VALUE = 22;
        public static final int PK_VALUE = 7;
        public static final int PRIVILEGE_VALUE = 41;
        public static final int PUNISHMENT_VALUE = 23;
        public static final int RANDOM_MATCH_VALUE = 19;
        public static final int RECOMMEND_VALUE = 18;
        public static final int REVERSE_VALUE = 11;
        public static final int SILENCE_VALUE = 54;
        public static final int START_MULTI_PK_VALUE = 52;
        public static final int START_PK_VALUE = 20;
        public static final int TOP_FANS_GROUP_VALUE = 33;
        public static final int TOP_RED_PACKET_VALUE = 34;
        public static final int UNKNOWN_TYPE_VALUE = 0;
        private final int value;
        private static final Internal.EnumLiteMap<Type> internalValueMap = new Internal.EnumLiteMap<Type>() { // from class: com.irisdt.client.live.LiveProtos.Type.1
            @Override // com.google.protobuf.Internal.EnumLiteMap
            public Type findValueByNumber(int i10) {
                return Type.forNumber(i10);
            }
        };
        private static final Type[] VALUES = values();

        Type(int i10) {
            this.value = i10;
        }

        public static Type forNumber(int i10) {
            switch (i10) {
                case 0:
                    return UNKNOWN_TYPE;
                case 1:
                    return HOT;
                case 2:
                    return NEARBY;
                case 3:
                    return NEW;
                case 4:
                    return COMMENT;
                case 5:
                    return GIFT;
                case 6:
                    return CONNECT;
                case 7:
                    return PK;
                case 8:
                    return BEAUTY;
                case 9:
                    return MIRROR;
                case 10:
                    return MORE;
                case 11:
                    return REVERSE;
                case 12:
                    return COMMON_COMMENT;
                case 13:
                    return BULLET_COMMET;
                case 14:
                    return GIFT_DAILY;
                case 15:
                    return GIFT_LEVEL;
                case 16:
                    return GIFT_MADE;
                case 17:
                    return FOLLOW;
                case 18:
                    return RECOMMEND;
                case 19:
                    return RANDOM_MATCH;
                case 20:
                    return START_PK;
                case 21:
                    return ACCEPT_PK;
                case 22:
                    return PK_ING;
                case 23:
                    return PUNISHMENT;
                case 24:
                    return CONTENT;
                case 25:
                    return FANS_GROUP;
                case 26:
                    return LUCK_DRAW;
                case 27:
                    return COMMENT_GIFT;
                case 28:
                    return DISPLAY_GIFT;
                case 29:
                    return COMMENT_FOLLOW_GUIDE;
                case 30:
                    return BOTTOM_FOLLOW_GUIDE;
                case 31:
                    return CHAT_GUIDE;
                case 32:
                    return GIFT_GUIDE;
                case 33:
                    return TOP_FANS_GROUP;
                case 34:
                    return TOP_RED_PACKET;
                case 35:
                    return BOTTOM_RED_PACKET;
                case 36:
                    return MORE_RED_PACKET;
                case 37:
                    return NEW_CONNECT;
                case 38:
                    return MORE_COLLECT_FRAGMENT;
                case 39:
                    return PACKSACK_COLLECT_FRAGMENT;
                case 40:
                    return ANCHOR_TASK;
                case 41:
                    return PRIVILEGE;
                case 42:
                    return MORE_DRESS_UP_MALL;
                case 43:
                    return MORE_MY_DRESS_UP;
                case 44:
                    return MORE_NOBILITY;
                case 45:
                    return GIFT_NOBILITY;
                case 46:
                    return NOBILITY_FREE_BULLET_COMMENT;
                case 47:
                    return MORE_PASTER;
                case 48:
                    return MORE_GIFT_WALL;
                case 49:
                    return MORE_FOLLOW;
                case 50:
                    return FOLLOW_COUNT_DOWN;
                case 51:
                    return MULTI_PK;
                case 52:
                    return START_MULTI_PK;
                case 53:
                    return MULTI_PK_PUNISHMENT;
                case 54:
                    return SILENCE;
                case 55:
                    return ACCEPT_MULTI_PK;
                case 56:
                    return MULTI_BEFORE_START;
                default:
                    return null;
            }
        }

        public static final Descriptors.EnumDescriptor getDescriptor() {
            return LiveProtos.getDescriptor().getEnumTypes().get(1);
        }

        public static Internal.EnumLiteMap<Type> internalGetValueMap() {
            return internalValueMap;
        }

        @Override // com.google.protobuf.ProtocolMessageEnum
        public final Descriptors.EnumDescriptor getDescriptorForType() {
            return getDescriptor();
        }

        @Override // com.google.protobuf.ProtocolMessageEnum, com.google.protobuf.Internal.EnumLite
        public final int getNumber() {
            if (this != UNRECOGNIZED) {
                return this.value;
            }
            throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
        }

        @Override // com.google.protobuf.ProtocolMessageEnum
        public final Descriptors.EnumValueDescriptor getValueDescriptor() {
            if (this != UNRECOGNIZED) {
                return getDescriptor().getValues().get(ordinal());
            }
            throw new IllegalStateException("Can't get the descriptor of an unrecognized enum value.");
        }

        @Deprecated
        public static Type valueOf(int i10) {
            return forNumber(i10);
        }

        public static Type valueOf(Descriptors.EnumValueDescriptor enumValueDescriptor) {
            if (enumValueDescriptor.getType() == getDescriptor()) {
                if (enumValueDescriptor.getIndex() == -1) {
                    return UNRECOGNIZED;
                }
                return VALUES[enumValueDescriptor.getIndex()];
            }
            throw new IllegalArgumentException("EnumValueDescriptor is not for this type.");
        }
    }

    static {
        Descriptors.Descriptor descriptor2 = getDescriptor().getMessageTypes().get(0);
        internal_static_com_irisdt_client_live_LiveProto_descriptor = descriptor2;
        internal_static_com_irisdt_client_live_LiveProto_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(descriptor2, new String[]{com.huawei.hianalytics.core.storage.Event.TAG, "Type", "LiveId", "AnchorUid", "Num", "Id", "IsTrue", "Time", "Worth", "Content", "From", "Count", "Level", "Scene", "IsBool", "Result", "Status", "Source", "CoverType", "TagType", "UserType", "Score", "Title", "Name", "ConnectType", "UserTag", "TargetUid", "IsLiveShow", "IsTreasure", "IsRedPacket", "IsLiveWindow", "RedPacketType", "IsTrigger", "Times", "ActivityFirst", "ActivitySecond", "Index", "Sku", "IsFirst", "Grade", "Reason", "RequestId"});
    }

    private LiveProtos() {
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    public static void registerAllExtensions(ExtensionRegistry extensionRegistry) {
        registerAllExtensions((ExtensionRegistryLite) extensionRegistry);
    }

    public static void registerAllExtensions(ExtensionRegistryLite extensionRegistryLite) {
    }
}
