package com.android.internal.org.bouncycastle.math.ec;

import android.support.v4.media.session.PlaybackStateCompat;
import com.android.internal.logging.nano.MetricsProto;
import com.android.internal.org.bouncycastle.util.Arrays;
import com.huawei.hms.ml.scan.HmsScanBase;
import com.ss.android.socialbase.downloader.constants.DownloadErrorCode;
import java.math.BigInteger;
import java.util.Calendar;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public class LongArray implements Cloneable {
    private static final String ZEROES = "0000000000000000000000000000000000000000000000000000000000000000";
    private long[] m_ints;
    private static final short[] INTERLEAVE2_TABLE = {0, 1, 4, 5, 16, 17, 20, 21, 64, 65, 68, 69, 80, 81, 84, 85, 256, 257, 260, 261, 272, 273, 276, 277, 320, 321, 324, 325, 336, 337, 340, 341, 1024, 1025, 1028, 1029, 1040, 1041, 1044, 1045, 1088, 1089, 1092, 1093, 1104, 1105, 1108, 1109, 1280, 1281, 1284, 1285, 1296, 1297, 1300, 1301, 1344, 1345, 1348, 1349, 1360, 1361, 1364, 1365, 4096, 4097, 4100, 4101, 4112, 4113, 4116, 4117, 4160, 4161, 4164, 4165, 4176, 4177, 4180, 4181, 4352, 4353, 4356, 4357, 4368, 4369, 4372, 4373, 4416, 4417, 4420, 4421, 4432, 4433, 4436, 4437, 5120, 5121, 5124, 5125, 5136, 5137, 5140, 5141, 5184, 5185, 5188, 5189, 5200, 5201, 5204, 5205, 5376, 5377, 5380, 5381, 5392, 5393, 5396, 5397, 5440, 5441, 5444, 5445, 5456, 5457, 5460, 5461, 16384, 16385, 16388, 16389, 16400, 16401, 16404, 16405, 16448, 16449, 16452, 16453, 16464, 16465, 16468, 16469, 16640, 16641, 16644, 16645, 16656, 16657, 16660, 16661, 16704, 16705, 16708, 16709, 16720, 16721, 16724, 16725, 17408, 17409, 17412, 17413, 17424, 17425, 17428, 17429, 17472, 17473, 17476, 17477, 17488, 17489, 17492, 17493, 17664, 17665, 17668, 17669, 17680, 17681, 17684, 17685, 17728, 17729, 17732, 17733, 17744, 17745, 17748, 17749, 20480, 20481, 20484, 20485, 20496, 20497, 20500, 20501, 20544, 20545, 20548, 20549, 20560, 20561, 20564, 20565, 20736, 20737, 20740, 20741, 20752, 20753, 20756, 20757, 20800, 20801, 20804, 20805, 20816, 20817, 20820, 20821, 21504, 21505, 21508, 21509, 21520, 21521, 21524, 21525, 21568, 21569, 21572, 21573, 21584, 21585, 21588, 21589, 21760, 21761, 21764, 21765, 21776, 21777, 21780, 21781, 21824, 21825, 21828, 21829, 21840, 21841, 21844, 21845};
    private static final int[] INTERLEAVE3_TABLE = {0, 1, 8, 9, 64, 65, 72, 73, 512, 513, MetricsProto.MetricsEvent.PROVISIONING_PREPROVISIONING_ACTIVITY_TIME_MS, MetricsProto.MetricsEvent.PROVISIONING_ENCRYPT_DEVICE_ACTIVITY_TIME_MS, MetricsProto.MetricsEvent.DIALOG_WIFI_P2P_CANCEL_CONNECT, MetricsProto.MetricsEvent.DIALOG_WIFI_P2P_RENAME, MetricsProto.MetricsEvent.DIALOG_ACCESSIBILITY_SERVICE_DISABLE, MetricsProto.MetricsEvent.DIALOG_ACCOUNT_SYNC_REMOVE, 4096, 4097, 4104, 4105, 4160, 4161, 4168, 4169, 4608, 4609, 4616, 4617, 4672, 4673, 4680, 4681, 32768, Calendar.SHORT_STANDALONE, 32776, 32777, 32832, 32833, 32840, 32841, 33280, 33281, 33288, 33289, 33344, 33345, 33352, 33353, 36864, 36865, 36872, 36873, 36928, 36929, 36936, 36937, 37376, 37377, 37384, 37385, 37440, 37441, 37448, 37449, 262144, 262145, 262152, 262153, 262208, 262209, 262216, 262217, 262656, 262657, 262664, 262665, 262720, 262721, 262728, 262729, 266240, 266241, 266248, 266249, 266304, 266305, 266312, 266313, 266752, 266753, 266760, 266761, 266816, 266817, 266824, 266825, 294912, 294913, 294920, 294921, 294976, 294977, 294984, 294985, 295424, 295425, 295432, 295433, 295488, 295489, 295496, 295497, 299008, 299009, 299016, 299017, 299072, 299073, 299080, 299081, 299520, 299521, 299528, 299529, 299584, 299585, 299592, 299593};
    private static final int[] INTERLEAVE4_TABLE = {0, 1, 16, 17, 256, 257, 272, 273, 4096, 4097, 4112, 4113, 4352, 4353, 4368, 4369, 65536, 65537, 65552, 65553, 65792, 65793, 65808, 65809, 69632, 69633, 69648, 69649, 69888, 69889, 69904, 69905, 1048576, 1048577, 1048592, 1048593, 1048832, 1048833, 1048848, 1048849, 1052672, 1052673, 1052688, 1052689, 1052928, 1052929, 1052944, 1052945, 1114112, 1114113, 1114128, 1114129, 1114368, 1114369, 1114384, 1114385, 1118208, 1118209, 1118224, 1118225, 1118464, 1118465, 1118480, 1118481, 16777216, 16777217, 16777232, 16777233, 16777472, 16777473, 16777488, 16777489, 16781312, 16781313, 16781328, 16781329, 16781568, 16781569, 16781584, 16781585, 16842752, 16842753, 16842768, 16842769, 16843008, 16843009, 16843024, 16843025, 16846848, 16846849, 16846864, 16846865, 16847104, 16847105, 16847120, 16847121, 17825792, 17825793, 17825808, 17825809, 17826048, 17826049, 17826064, 17826065, 17829888, 17829889, 17829904, 17829905, 17830144, 17830145, 17830160, 17830161, 17891328, 17891329, 17891344, 17891345, 17891584, 17891585, 17891600, 17891601, 17895424, 17895425, 17895440, 17895441, 17895680, 17895681, 17895696, 17895697, 268435456, 268435457, 268435472, 268435473, 268435712, 268435713, 268435728, 268435729, 268439552, 268439553, 268439568, 268439569, 268439808, 268439809, 268439824, 268439825, 268500992, 268500993, 268501008, 268501009, 268501248, 268501249, 268501264, 268501265, 268505088, 268505089, 268505104, 268505105, 268505344, 268505345, 268505360, 268505361, 269484032, 269484033, 269484048, 269484049, 269484288, 269484289, 269484304, 269484305, 269488128, 269488129, 269488144, 269488145, 269488384, 269488385, 269488400, 269488401, 269549568, 269549569, 269549584, 269549585, 269549824, 269549825, 269549840, 269549841, 269553664, 269553665, 269553680, 269553681, 269553920, 269553921, 269553936, 269553937, 285212672, 285212673, 285212688, 285212689, 285212928, 285212929, 285212944, 285212945, 285216768, 285216769, 285216784, 285216785, 285217024, 285217025, 285217040, 285217041, 285278208, 285278209, 285278224, 285278225, 285278464, 285278465, 285278480, 285278481, 285282304, 285282305, 285282320, 285282321, 285282560, 285282561, 285282576, 285282577, 286261248, 286261249, 286261264, 286261265, 286261504, 286261505, 286261520, 286261521, 286265344, 286265345, 286265360, 286265361, 286265600, 286265601, 286265616, 286265617, 286326784, 286326785, 286326800, 286326801, 286327040, 286327041, 286327056, 286327057, 286330880, 286330881, 286330896, 286330897, 286331136, 286331137, 286331152, 286331153};
    private static final int[] INTERLEAVE5_TABLE = {0, 1, 32, 33, 1024, 1025, DownloadErrorCode.ERROR_NO_ROUTE_TO_HOST, DownloadErrorCode.ERROR_UNKNOWN_SERVICE, 32768, Calendar.SHORT_STANDALONE, 32800, 32801, 33792, 33793, 33824, 33825, 1048576, 1048577, 1048608, 1048609, 1049600, 1049601, 1049632, 1049633, 1081344, 1081345, 1081376, 1081377, 1082368, 1082369, 1082400, 1082401, 33554432, 33554433, 33554464, 33554465, 33555456, 33555457, 33555488, 33555489, 33587200, 33587201, 33587232, 33587233, 33588224, 33588225, 33588256, 33588257, 34603008, 34603009, 34603040, 34603041, 34604032, 34604033, 34604064, 34604065, 34635776, 34635777, 34635808, 34635809, 34636800, 34636801, 34636832, 34636833, 1073741824, 1073741825, 1073741856, 1073741857, 1073742848, 1073742849, 1073742880, 1073742881, 1073774592, 1073774593, 1073774624, 1073774625, 1073775616, 1073775617, 1073775648, 1073775649, 1074790400, 1074790401, 1074790432, 1074790433, 1074791424, 1074791425, 1074791456, 1074791457, 1074823168, 1074823169, 1074823200, 1074823201, 1074824192, 1074824193, 1074824224, 1074824225, 1107296256, 1107296257, 1107296288, 1107296289, 1107297280, 1107297281, 1107297312, 1107297313, 1107329024, 1107329025, 1107329056, 1107329057, 1107330048, 1107330049, 1107330080, 1107330081, 1108344832, 1108344833, 1108344864, 1108344865, 1108345856, 1108345857, 1108345888, 1108345889, 1108377600, 1108377601, 1108377632, 1108377633, 1108378624, 1108378625, 1108378656, 1108378657};
    private static final long[] INTERLEAVE7_TABLE = {0, 1, 128, 129, 16384, 16385, 16512, 16513, PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE, 2097153, 2097280, 2097281, 2113536, 2113537, 2113664, 2113665, 268435456, 268435457, 268435584, 268435585, 268451840, 268451841, 268451968, 268451969, 270532608, 270532609, 270532736, 270532737, 270548992, 270548993, 270549120, 270549121, 34359738368L, 34359738369L, 34359738496L, 34359738497L, 34359754752L, 34359754753L, 34359754880L, 34359754881L, 34361835520L, 34361835521L, 34361835648L, 34361835649L, 34361851904L, 34361851905L, 34361852032L, 34361852033L, 34628173824L, 34628173825L, 34628173952L, 34628173953L, 34628190208L, 34628190209L, 34628190336L, 34628190337L, 34630270976L, 34630270977L, 34630271104L, 34630271105L, 34630287360L, 34630287361L, 34630287488L, 34630287489L, 4398046511104L, 4398046511105L, 4398046511232L, 4398046511233L, 4398046527488L, 4398046527489L, 4398046527616L, 4398046527617L, 4398048608256L, 4398048608257L, 4398048608384L, 4398048608385L, 4398048624640L, 4398048624641L, 4398048624768L, 4398048624769L, 4398314946560L, 4398314946561L, 4398314946688L, 4398314946689L, 4398314962944L, 4398314962945L, 4398314963072L, 4398314963073L, 4398317043712L, 4398317043713L, 4398317043840L, 4398317043841L, 4398317060096L, 4398317060097L, 4398317060224L, 4398317060225L, 4432406249472L, 4432406249473L, 4432406249600L, 4432406249601L, 4432406265856L, 4432406265857L, 4432406265984L, 4432406265985L, 4432408346624L, 4432408346625L, 4432408346752L, 4432408346753L, 4432408363008L, 4432408363009L, 4432408363136L, 4432408363137L, 4432674684928L, 4432674684929L, 4432674685056L, 4432674685057L, 4432674701312L, 4432674701313L, 4432674701440L, 4432674701441L, 4432676782080L, 4432676782081L, 4432676782208L, 4432676782209L, 4432676798464L, 4432676798465L, 4432676798592L, 4432676798593L, 562949953421312L, 562949953421313L, 562949953421440L, 562949953421441L, 562949953437696L, 562949953437697L, 562949953437824L, 562949953437825L, 562949955518464L, 562949955518465L, 562949955518592L, 562949955518593L, 562949955534848L, 562949955534849L, 562949955534976L, 562949955534977L, 562950221856768L, 562950221856769L, 562950221856896L, 562950221856897L, 562950221873152L, 562950221873153L, 562950221873280L, 562950221873281L, 562950223953920L, 562950223953921L, 562950223954048L, 562950223954049L, 562950223970304L, 562950223970305L, 562950223970432L, 562950223970433L, 562984313159680L, 562984313159681L, 562984313159808L, 562984313159809L, 562984313176064L, 562984313176065L, 562984313176192L, 562984313176193L, 562984315256832L, 562984315256833L, 562984315256960L, 562984315256961L, 562984315273216L, 562984315273217L, 562984315273344L, 562984315273345L, 562984581595136L, 562984581595137L, 562984581595264L, 562984581595265L, 562984581611520L, 562984581611521L, 562984581611648L, 562984581611649L, 562984583692288L, 562984583692289L, 562984583692416L, 562984583692417L, 562984583708672L, 562984583708673L, 562984583708800L, 562984583708801L, 567347999932416L, 567347999932417L, 567347999932544L, 567347999932545L, 567347999948800L, 567347999948801L, 567347999948928L, 567347999948929L, 567348002029568L, 567348002029569L, 567348002029696L, 567348002029697L, 567348002045952L, 567348002045953L, 567348002046080L, 567348002046081L, 567348268367872L, 567348268367873L, 567348268368000L, 567348268368001L, 567348268384256L, 567348268384257L, 567348268384384L, 567348268384385L, 567348270465024L, 567348270465025L, 567348270465152L, 567348270465153L, 567348270481408L, 567348270481409L, 567348270481536L, 567348270481537L, 567382359670784L, 567382359670785L, 567382359670912L, 567382359670913L, 567382359687168L, 567382359687169L, 567382359687296L, 567382359687297L, 567382361767936L, 567382361767937L, 567382361768064L, 567382361768065L, 567382361784320L, 567382361784321L, 567382361784448L, 567382361784449L, 567382628106240L, 567382628106241L, 567382628106368L, 567382628106369L, 567382628122624L, 567382628122625L, 567382628122752L, 567382628122753L, 567382630203392L, 567382630203393L, 567382630203520L, 567382630203521L, 567382630219776L, 567382630219777L, 567382630219904L, 567382630219905L, 72057594037927936L, 72057594037927937L, 72057594037928064L, 72057594037928065L, 72057594037944320L, 72057594037944321L, 72057594037944448L, 72057594037944449L, 72057594040025088L, 72057594040025089L, 72057594040025216L, 72057594040025217L, 72057594040041472L, 72057594040041473L, 72057594040041600L, 72057594040041601L, 72057594306363392L, 72057594306363393L, 72057594306363520L, 72057594306363521L, 72057594306379776L, 72057594306379777L, 72057594306379904L, 72057594306379905L, 72057594308460544L, 72057594308460545L, 72057594308460672L, 72057594308460673L, 72057594308476928L, 72057594308476929L, 72057594308477056L, 72057594308477057L, 72057628397666304L, 72057628397666305L, 72057628397666432L, 72057628397666433L, 72057628397682688L, 72057628397682689L, 72057628397682816L, 72057628397682817L, 72057628399763456L, 72057628399763457L, 72057628399763584L, 72057628399763585L, 72057628399779840L, 72057628399779841L, 72057628399779968L, 72057628399779969L, 72057628666101760L, 72057628666101761L, 72057628666101888L, 72057628666101889L, 72057628666118144L, 72057628666118145L, 72057628666118272L, 72057628666118273L, 72057628668198912L, 72057628668198913L, 72057628668199040L, 72057628668199041L, 72057628668215296L, 72057628668215297L, 72057628668215424L, 72057628668215425L, 72061992084439040L, 72061992084439041L, 72061992084439168L, 72061992084439169L, 72061992084455424L, 72061992084455425L, 72061992084455552L, 72061992084455553L, 72061992086536192L, 72061992086536193L, 72061992086536320L, 72061992086536321L, 72061992086552576L, 72061992086552577L, 72061992086552704L, 72061992086552705L, 72061992352874496L, 72061992352874497L, 72061992352874624L, 72061992352874625L, 72061992352890880L, 72061992352890881L, 72061992352891008L, 72061992352891009L, 72061992354971648L, 72061992354971649L, 72061992354971776L, 72061992354971777L, 72061992354988032L, 72061992354988033L, 72061992354988160L, 72061992354988161L, 72062026444177408L, 72062026444177409L, 72062026444177536L, 72062026444177537L, 72062026444193792L, 72062026444193793L, 72062026444193920L, 72062026444193921L, 72062026446274560L, 72062026446274561L, 72062026446274688L, 72062026446274689L, 72062026446290944L, 72062026446290945L, 72062026446291072L, 72062026446291073L, 72062026712612864L, 72062026712612865L, 72062026712612992L, 72062026712612993L, 72062026712629248L, 72062026712629249L, 72062026712629376L, 72062026712629377L, 72062026714710016L, 72062026714710017L, 72062026714710144L, 72062026714710145L, 72062026714726400L, 72062026714726401L, 72062026714726528L, 72062026714726529L, 72620543991349248L, 72620543991349249L, 72620543991349376L, 72620543991349377L, 72620543991365632L, 72620543991365633L, 72620543991365760L, 72620543991365761L, 72620543993446400L, 72620543993446401L, 72620543993446528L, 72620543993446529L, 72620543993462784L, 72620543993462785L, 72620543993462912L, 72620543993462913L, 72620544259784704L, 72620544259784705L, 72620544259784832L, 72620544259784833L, 72620544259801088L, 72620544259801089L, 72620544259801216L, 72620544259801217L, 72620544261881856L, 72620544261881857L, 72620544261881984L, 72620544261881985L, 72620544261898240L, 72620544261898241L, 72620544261898368L, 72620544261898369L, 72620578351087616L, 72620578351087617L, 72620578351087744L, 72620578351087745L, 72620578351104000L, 72620578351104001L, 72620578351104128L, 72620578351104129L, 72620578353184768L, 72620578353184769L, 72620578353184896L, 72620578353184897L, 72620578353201152L, 72620578353201153L, 72620578353201280L, 72620578353201281L, 72620578619523072L, 72620578619523073L, 72620578619523200L, 72620578619523201L, 72620578619539456L, 72620578619539457L, 72620578619539584L, 72620578619539585L, 72620578621620224L, 72620578621620225L, 72620578621620352L, 72620578621620353L, 72620578621636608L, 72620578621636609L, 72620578621636736L, 72620578621636737L, 72624942037860352L, 72624942037860353L, 72624942037860480L, 72624942037860481L, 72624942037876736L, 72624942037876737L, 72624942037876864L, 72624942037876865L, 72624942039957504L, 72624942039957505L, 72624942039957632L, 72624942039957633L, 72624942039973888L, 72624942039973889L, 72624942039974016L, 72624942039974017L, 72624942306295808L, 72624942306295809L, 72624942306295936L, 72624942306295937L, 72624942306312192L, 72624942306312193L, 72624942306312320L, 72624942306312321L, 72624942308392960L, 72624942308392961L, 72624942308393088L, 72624942308393089L, 72624942308409344L, 72624942308409345L, 72624942308409472L, 72624942308409473L, 72624976397598720L, 72624976397598721L, 72624976397598848L, 72624976397598849L, 72624976397615104L, 72624976397615105L, 72624976397615232L, 72624976397615233L, 72624976399695872L, 72624976399695873L, 72624976399696000L, 72624976399696001L, 72624976399712256L, 72624976399712257L, 72624976399712384L, 72624976399712385L, 72624976666034176L, 72624976666034177L, 72624976666034304L, 72624976666034305L, 72624976666050560L, 72624976666050561L, 72624976666050688L, 72624976666050689L, 72624976668131328L, 72624976668131329L, 72624976668131456L, 72624976668131457L, 72624976668147712L, 72624976668147713L, 72624976668147840L, 72624976668147841L};
    static final byte[] bitLengths = {0, 1, 2, 2, 3, 3, 3, 3, 4, 4, 4, 4, 4, 4, 4, 4, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8};

    public LongArray(int intLen) {
        this.m_ints = new long[intLen];
    }

    public LongArray(long[] ints) {
        this.m_ints = ints;
    }

    public LongArray(long[] ints, int off, int len) {
        if (off == 0 && len == ints.length) {
            this.m_ints = ints;
            return;
        }
        long[] jArr = new long[len];
        this.m_ints = jArr;
        System.arraycopy((Object) ints, off, (Object) jArr, 0, len);
    }

    public LongArray(BigInteger bigInt) {
        if (bigInt == null || bigInt.signum() < 0) {
            throw new IllegalArgumentException("invalid F2m field value");
        }
        if (bigInt.signum() == 0) {
            this.m_ints = new long[]{0};
            return;
        }
        byte[] barr = bigInt.toByteArray();
        int barrLen = barr.length;
        int barrStart = 0;
        if (barr[0] == 0) {
            barrLen--;
            barrStart = 1;
        }
        int intLen = (barrLen + 7) / 8;
        this.m_ints = new long[intLen];
        int iarrJ = intLen - 1;
        int rem = (barrLen % 8) + barrStart;
        long temp = 0;
        int barrI = barrStart;
        if (barrStart < rem) {
            while (barrI < rem) {
                int barrBarrI = barr[barrI] & 255;
                temp = (temp << 8) | barrBarrI;
                barrI++;
            }
            this.m_ints[iarrJ] = temp;
            iarrJ--;
        }
        while (iarrJ >= 0) {
            long temp2 = 0;
            int i10 = 0;
            while (i10 < 8) {
                int barrI2 = barrI + 1;
                int barrBarrI2 = barr[barrI] & 255;
                temp2 = (temp2 << 8) | barrBarrI2;
                i10++;
                barrI = barrI2;
            }
            this.m_ints[iarrJ] = temp2;
            iarrJ--;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void copyTo(long[] z10, int zOff) {
        long[] jArr = this.m_ints;
        System.arraycopy((Object) jArr, 0, (Object) z10, zOff, jArr.length);
    }

    public boolean isOne() {
        long[] a10 = this.m_ints;
        if (a10[0] != 1) {
            return false;
        }
        for (int i10 = 1; i10 < a10.length; i10++) {
            if (a10[i10] != 0) {
                return false;
            }
        }
        return true;
    }

    public boolean isZero() {
        long[] a10 = this.m_ints;
        for (long j10 : a10) {
            if (j10 != 0) {
                return false;
            }
        }
        return true;
    }

    public int getUsedLength() {
        return getUsedLengthFrom(this.m_ints.length);
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x001f, code lost:
    
        return r8 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0020, code lost:
    
        r8 = r8 - 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0026, code lost:
    
        if (r0[r8] == 0) goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x002b, code lost:
    
        if (r8 > 0) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x002d, code lost:
    
        return 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x002a, code lost:
    
        return r8 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:6:0x0012, code lost:
    
        if (r0[0] != 0) goto L7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x0014, code lost:
    
        r8 = r8 - 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x001a, code lost:
    
        if (r0[r8] != 0) goto L18;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public int getUsedLengthFrom(int r8) {
        /*
            r7 = this;
            long[] r0 = r7.m_ints
            int r1 = r0.length
            int r8 = java.lang.Math.min(r8, r1)
            r1 = 1
            r2 = 0
            if (r8 >= r1) goto Lc
            return r2
        Lc:
            r3 = r0[r2]
            r5 = 0
            int r1 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r1 == 0) goto L20
        L14:
            int r8 = r8 + (-1)
            r1 = r0[r8]
            int r1 = (r1 > r5 ? 1 : (r1 == r5 ? 0 : -1))
            if (r1 != 0) goto L1d
            goto L14
        L1d:
            int r1 = r8 + 1
            return r1
        L20:
            int r8 = r8 + (-1)
            r3 = r0[r8]
            int r1 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r1 == 0) goto L2b
            int r1 = r8 + 1
            return r1
        L2b:
            if (r8 > 0) goto L20
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.android.internal.org.bouncycastle.math.ec.LongArray.getUsedLengthFrom(int):int");
    }

    public int degree() {
        int i10 = this.m_ints.length;
        while (i10 != 0) {
            i10--;
            long w3 = this.m_ints[i10];
            if (w3 != 0) {
                return (i10 << 6) + bitLength(w3);
            }
        }
        return 0;
    }

    private int degreeFrom(int limit) {
        int i10 = (limit + 62) >>> 6;
        while (i10 != 0) {
            i10--;
            long w3 = this.m_ints[i10];
            if (w3 != 0) {
                return (i10 << 6) + bitLength(w3);
            }
        }
        return 0;
    }

    private static int bitLength(long w3) {
        int b4;
        int i10;
        int u10 = (int) (w3 >>> 32);
        if (u10 == 0) {
            u10 = (int) w3;
            b4 = 0;
        } else {
            b4 = 32;
        }
        int t2 = u10 >>> 16;
        if (t2 == 0) {
            int t10 = u10 >>> 8;
            byte[] bArr = bitLengths;
            i10 = t10 == 0 ? bArr[u10] : bArr[t10] + 8;
        } else {
            int k10 = t2 >>> 8;
            byte[] bArr2 = bitLengths;
            i10 = k10 == 0 ? bArr2[t2] + 16 : bArr2[k10] + 24;
        }
        return b4 + i10;
    }

    private long[] resizedInts(int newLen) {
        long[] newInts = new long[newLen];
        long[] jArr = this.m_ints;
        System.arraycopy((Object) jArr, 0, (Object) newInts, 0, Math.min(jArr.length, newLen));
        return newInts;
    }

    public BigInteger toBigInteger() {
        int usedLen = getUsedLength();
        if (usedLen == 0) {
            return ECConstants.ZERO;
        }
        long highestInt = this.m_ints[usedLen - 1];
        byte[] temp = new byte[8];
        int barrI = 0;
        boolean trailingZeroBytesDone = false;
        for (int j10 = 7; j10 >= 0; j10--) {
            byte thisByte = (byte) (highestInt >>> (j10 * 8));
            if (trailingZeroBytesDone || thisByte != 0) {
                trailingZeroBytesDone = true;
                temp[barrI] = thisByte;
                barrI++;
            }
        }
        int j11 = usedLen - 1;
        int barrLen = (j11 * 8) + barrI;
        byte[] barr = new byte[barrLen];
        for (int j12 = 0; j12 < barrI; j12++) {
            barr[j12] = temp[j12];
        }
        for (int iarrJ = usedLen - 2; iarrJ >= 0; iarrJ--) {
            long mi = this.m_ints[iarrJ];
            int j13 = 7;
            while (j13 >= 0) {
                barr[barrI] = (byte) (mi >>> (j13 * 8));
                j13--;
                barrI++;
            }
        }
        return new BigInteger(1, barr);
    }

    private static long shiftUp(long[] x10, int xOff, int count, int shift) {
        int shiftInv = 64 - shift;
        long prev = 0;
        for (int i10 = 0; i10 < count; i10++) {
            long next = x10[xOff + i10];
            x10[xOff + i10] = (next << shift) | prev;
            prev = next >>> shiftInv;
        }
        return prev;
    }

    private static long shiftUp(long[] x10, int xOff, long[] z10, int zOff, int count, int shift) {
        int shiftInv = 64 - shift;
        long prev = 0;
        for (int i10 = 0; i10 < count; i10++) {
            long next = x10[xOff + i10];
            z10[zOff + i10] = (next << shift) | prev;
            prev = next >>> shiftInv;
        }
        return prev;
    }

    public LongArray addOne() {
        if (this.m_ints.length == 0) {
            return new LongArray(new long[]{1});
        }
        int resultLen = Math.max(1, getUsedLength());
        long[] ints = resizedInts(resultLen);
        ints[0] = 1 ^ ints[0];
        return new LongArray(ints);
    }

    private void addShiftedByBitsSafe(LongArray other, int otherDegree, int bits) {
        int otherLen = (otherDegree + 63) >>> 6;
        int words = bits >>> 6;
        int shift = bits & 63;
        if (shift == 0) {
            add(this.m_ints, words, other.m_ints, 0, otherLen);
            return;
        }
        long carry = addShiftedUp(this.m_ints, words, other.m_ints, 0, otherLen, shift);
        if (carry != 0) {
            long[] jArr = this.m_ints;
            int i10 = otherLen + words;
            jArr[i10] = jArr[i10] ^ carry;
        }
    }

    private static long addShiftedUp(long[] x10, int xOff, long[] y10, int yOff, int count, int shift) {
        int shiftInv = 64 - shift;
        long prev = 0;
        for (int i10 = 0; i10 < count; i10++) {
            long next = y10[yOff + i10];
            int i11 = xOff + i10;
            x10[i11] = x10[i11] ^ ((next << shift) | prev);
            prev = next >>> shiftInv;
        }
        return prev;
    }

    private static long addShiftedDown(long[] x10, int xOff, long[] y10, int yOff, int count, int shift) {
        int shiftInv = 64 - shift;
        long prev = 0;
        int i10 = count;
        while (true) {
            i10--;
            if (i10 >= 0) {
                long next = y10[yOff + i10];
                int i11 = xOff + i10;
                x10[i11] = x10[i11] ^ ((next >>> shift) | prev);
                prev = next << shiftInv;
            } else {
                return prev;
            }
        }
    }

    public void addShiftedByWords(LongArray other, int words) {
        int otherUsedLen = other.getUsedLength();
        if (otherUsedLen == 0) {
            return;
        }
        int minLen = otherUsedLen + words;
        if (minLen > this.m_ints.length) {
            this.m_ints = resizedInts(minLen);
        }
        add(this.m_ints, words, other.m_ints, 0, otherUsedLen);
    }

    private static void add(long[] x10, int xOff, long[] y10, int yOff, int count) {
        for (int i10 = 0; i10 < count; i10++) {
            int i11 = xOff + i10;
            x10[i11] = x10[i11] ^ y10[yOff + i10];
        }
    }

    private static void add(long[] x10, int xOff, long[] y10, int yOff, long[] z10, int zOff, int count) {
        for (int i10 = 0; i10 < count; i10++) {
            z10[zOff + i10] = x10[xOff + i10] ^ y10[yOff + i10];
        }
    }

    private static void addBoth(long[] x10, int xOff, long[] y1, int y1Off, long[] y22, int y2Off, int count) {
        for (int i10 = 0; i10 < count; i10++) {
            int i11 = xOff + i10;
            x10[i11] = x10[i11] ^ (y1[y1Off + i10] ^ y22[y2Off + i10]);
        }
    }

    private static void distribute(long[] x10, int src, int dst1, int dst2, int count) {
        for (int i10 = 0; i10 < count; i10++) {
            long v2 = x10[src + i10];
            int i11 = dst1 + i10;
            x10[i11] = x10[i11] ^ v2;
            int i12 = dst2 + i10;
            x10[i12] = x10[i12] ^ v2;
        }
    }

    public int getLength() {
        return this.m_ints.length;
    }

    private static void flipWord(long[] buf, int off, int bit, long word) {
        int n10 = (bit >>> 6) + off;
        int shift = bit & 63;
        if (shift == 0) {
            buf[n10] = buf[n10] ^ word;
            return;
        }
        buf[n10] = buf[n10] ^ (word << shift);
        long word2 = word >>> (64 - shift);
        if (word2 != 0) {
            int n11 = n10 + 1;
            buf[n11] = buf[n11] ^ word2;
        }
    }

    public boolean testBitZero() {
        long[] jArr = this.m_ints;
        return jArr.length > 0 && (jArr[0] & 1) != 0;
    }

    private static boolean testBit(long[] buf, int off, int n10) {
        int theInt = n10 >>> 6;
        int theBit = n10 & 63;
        long tester = 1 << theBit;
        return (buf[off + theInt] & tester) != 0;
    }

    private static void flipBit(long[] buf, int off, int n10) {
        int theInt = n10 >>> 6;
        int theBit = n10 & 63;
        long flipper = 1 << theBit;
        int i10 = off + theInt;
        buf[i10] = buf[i10] ^ flipper;
    }

    private static void multiplyWord(long a10, long[] b4, int bLen, long[] c4, int cOff) {
        if ((a10 & 1) != 0) {
            add(c4, cOff, b4, 0, bLen);
        }
        int k10 = 1;
        long a11 = a10;
        while (true) {
            long a12 = a11 >>> 1;
            if (a12 != 0) {
                if ((a12 & 1) != 0) {
                    long carry = addShiftedUp(c4, cOff, b4, 0, bLen, k10);
                    if (carry != 0) {
                        int i10 = cOff + bLen;
                        c4[i10] = c4[i10] ^ carry;
                    }
                }
                k10++;
                a11 = a12;
            } else {
                return;
            }
        }
    }

    public LongArray modMultiplyLD(LongArray other, int m10, int[] ks) {
        int aDeg = degree();
        if (aDeg == 0) {
            return this;
        }
        int bDeg = other.degree();
        if (bDeg == 0) {
            return other;
        }
        LongArray A = this;
        LongArray B = other;
        if (aDeg > bDeg) {
            A = other;
            B = this;
            aDeg = bDeg;
            bDeg = aDeg;
        }
        int tmp = aDeg + 63;
        int aLen = tmp >>> 6;
        int bLen = (bDeg + 63) >>> 6;
        int cLen = ((aDeg + bDeg) + 62) >>> 6;
        if (aLen == 1) {
            long a02 = A.m_ints[0];
            if (a02 == 1) {
                return B;
            }
            long[] c02 = new long[cLen];
            multiplyWord(a02, B.m_ints, bLen, c02, 0);
            return reduceResult(c02, 0, cLen, m10, ks);
        }
        int bMax = ((bDeg + 7) + 63) >>> 6;
        int[] ti = new int[16];
        long[] T0 = new long[bMax << 4];
        int tOff = bMax;
        ti[1] = tOff;
        System.arraycopy((Object) B.m_ints, 0, (Object) T0, tOff, bLen);
        for (int i10 = 2; i10 < 16; i10++) {
            int i11 = tOff + bMax;
            tOff = i11;
            ti[i10] = i11;
            if ((i10 & 1) == 0) {
                shiftUp(T0, tOff >>> 1, T0, tOff, bMax, 1);
            } else {
                add(T0, bMax, T0, tOff - bMax, T0, tOff, bMax);
            }
        }
        int i12 = T0.length;
        long[] T1 = new long[i12];
        shiftUp(T0, 0, T1, 0, T0.length, 4);
        long[] a10 = A.m_ints;
        long[] c4 = new long[cLen];
        int k10 = 56;
        while (k10 >= 0) {
            int j10 = 1;
            while (j10 < aLen) {
                int bDeg2 = bDeg;
                LongArray A2 = A;
                int aVal = (int) (a10[j10] >>> k10);
                int u10 = aVal & 15;
                int v2 = (aVal >>> 4) & 15;
                addBoth(c4, j10 - 1, T0, ti[u10], T1, ti[v2], bMax);
                j10 += 2;
                bDeg = bDeg2;
                A = A2;
            }
            shiftUp(c4, 0, cLen, 8);
            k10 -= 8;
            bDeg = bDeg;
            A = A;
        }
        int k11 = 56;
        while (k11 >= 0) {
            int j11 = 0;
            while (j11 < aLen) {
                LongArray B2 = B;
                int aLen2 = aLen;
                int aVal2 = (int) (a10[j11] >>> k11);
                int u11 = aVal2 & 15;
                int v10 = (aVal2 >>> 4) & 15;
                addBoth(c4, j11, T0, ti[u11], T1, ti[v10], bMax);
                j11 += 2;
                B = B2;
                aLen = aLen2;
            }
            LongArray B3 = B;
            int aLen3 = aLen;
            if (k11 > 0) {
                shiftUp(c4, 0, cLen, 8);
            }
            k11 -= 8;
            B = B3;
            aLen = aLen3;
        }
        return reduceResult(c4, 0, cLen, m10, ks);
    }

    public LongArray modMultiply(LongArray other, int m10, int[] ks) {
        int bDeg;
        LongArray A;
        int aDeg = degree();
        if (aDeg == 0) {
            return this;
        }
        int bDeg2 = other.degree();
        if (bDeg2 == 0) {
            return other;
        }
        LongArray A2 = this;
        LongArray B = other;
        if (aDeg > bDeg2) {
            A2 = other;
            B = this;
            aDeg = bDeg2;
            bDeg2 = aDeg;
        }
        int tmp = aDeg + 63;
        int aLen = tmp >>> 6;
        int bLen = (bDeg2 + 63) >>> 6;
        int cLen = ((aDeg + bDeg2) + 62) >>> 6;
        if (aLen == 1) {
            long a02 = A2.m_ints[0];
            if (a02 == 1) {
                return B;
            }
            long[] c02 = new long[cLen];
            multiplyWord(a02, B.m_ints, bLen, c02, 0);
            return reduceResult(c02, 0, cLen, m10, ks);
        }
        int bMax = ((bDeg2 + 7) + 63) >>> 6;
        int[] ti = new int[16];
        long[] T0 = new long[bMax << 4];
        ti[1] = bMax;
        System.arraycopy((Object) B.m_ints, 0, (Object) T0, bMax, bLen);
        int tOff = bMax;
        for (int i10 = 2; i10 < 16; i10++) {
            int i11 = tOff + bMax;
            tOff = i11;
            ti[i10] = i11;
            if ((i10 & 1) == 0) {
                shiftUp(T0, tOff >>> 1, T0, tOff, bMax, 1);
            } else {
                add(T0, bMax, T0, tOff - bMax, T0, tOff, bMax);
            }
        }
        int i12 = T0.length;
        long[] T1 = new long[i12];
        shiftUp(T0, 0, T1, 0, T0.length, 4);
        long[] a10 = A2.m_ints;
        long[] c4 = new long[cLen << 3];
        int aPos = 0;
        while (aPos < aLen) {
            long aVal = a10[aPos];
            int cOff = aPos;
            int cLen2 = cLen;
            long aVal2 = aVal;
            while (true) {
                bDeg = bDeg2;
                int u10 = ((int) aVal2) & 15;
                long aVal3 = aVal2 >>> 4;
                A = A2;
                int v2 = ((int) aVal3) & 15;
                addBoth(c4, cOff, T0, ti[u10], T1, ti[v2], bMax);
                aVal2 = aVal3 >>> 4;
                if (aVal2 == 0) {
                    break;
                }
                cOff += cLen2;
                bDeg2 = bDeg;
                A2 = A;
            }
            aPos++;
            cLen = cLen2;
            bDeg2 = bDeg;
            A2 = A;
        }
        int cLen3 = cLen;
        int cOff2 = c4.length;
        while (true) {
            int i13 = cOff2 - cLen3;
            cOff2 = i13;
            if (i13 == 0) {
                return reduceResult(c4, 0, cLen3, m10, ks);
            }
            long[] c10 = c4;
            addShiftedUp(c4, cOff2 - cLen3, c10, cOff2, cLen3, 8);
            a10 = a10;
            c4 = c10;
            T0 = T0;
            ti = ti;
            bMax = bMax;
        }
    }

    public LongArray modMultiplyAlt(LongArray other, int m10, int[] ks) {
        int banks;
        int ciPos;
        int bTotal;
        int[] ci;
        int width;
        int width2;
        int cTotal;
        int cTotal2;
        int cTotal3;
        int aDeg = degree();
        if (aDeg == 0) {
            return this;
        }
        int bDeg = other.degree();
        if (bDeg == 0) {
            return other;
        }
        LongArray A = this;
        LongArray B = other;
        if (aDeg > bDeg) {
            A = other;
            B = this;
            aDeg = bDeg;
            bDeg = aDeg;
        }
        int tmp = aDeg + 63;
        int aLen = tmp >>> 6;
        int bLen = (bDeg + 63) >>> 6;
        int cLen = ((aDeg + bDeg) + 62) >>> 6;
        if (aLen == 1) {
            long a02 = A.m_ints[0];
            if (a02 == 1) {
                return B;
            }
            long[] c02 = new long[cLen];
            multiplyWord(a02, B.m_ints, bLen, c02, 0);
            return reduceResult(c02, 0, cLen, m10, ks);
        }
        int bMax = 4;
        int shifts = 64 < 64 ? 16 : 16 - 1;
        int bMax2 = ((bDeg + shifts) + 63) >>> 6;
        int bTotal2 = bMax2 * 8;
        int stride = 4 * 8;
        int[] ci2 = new int[1 << 4];
        ci2[0] = aLen;
        int cTotal4 = aLen + bTotal2;
        ci2[1] = cTotal4;
        for (int i10 = 2; i10 < ci2.length; i10++) {
            cTotal4 += cLen;
            ci2[i10] = cTotal4;
        }
        int cTotal5 = cTotal4 + cLen + 1;
        long[] c4 = new long[cTotal5];
        int bTotal3 = bTotal2;
        int bMax3 = bMax2;
        int[] ci3 = ci2;
        int banks2 = 8;
        interleave(A.m_ints, 0, c4, 0, aLen, 4);
        int bOff = aLen;
        long[] c10 = c4;
        System.arraycopy((Object) B.m_ints, 0, (Object) c10, bOff, bLen);
        int bank = 1;
        while (true) {
            banks = banks2;
            if (bank >= banks) {
                break;
            }
            int bOff2 = bOff + bMax3;
            int bank2 = bank;
            shiftUp(c10, aLen, c10, bOff2, bMax3, bank2);
            bank = bank2 + 1;
            banks2 = banks;
            c10 = c10;
            bOff = bOff2;
            B = B;
            bLen = bLen;
        }
        long[] c11 = c10;
        int MASK = (1 << 4) - 1;
        int k10 = 0;
        int MASK2 = MASK;
        while (true) {
            int aPos = 0;
            while (true) {
                long aVal = c11[aPos] >>> k10;
                int bank3 = 0;
                int bOff3 = aLen;
                while (true) {
                    ciPos = cTotal5;
                    int index = ((int) aVal) & MASK2;
                    if (index == 0) {
                        bTotal = bTotal3;
                        ci = ci3;
                        width = bMax;
                        width2 = bMax3;
                    } else {
                        bTotal = bTotal3;
                        ci = ci3;
                        width = bMax;
                        width2 = bMax3;
                        add(c11, aPos + ci[index], c11, bOff3, width2);
                    }
                    bank3++;
                    if (bank3 == banks) {
                        break;
                    }
                    bOff3 += width2;
                    aVal >>>= width;
                    bMax3 = width2;
                    cTotal5 = ciPos;
                    bMax = width;
                    ci3 = ci;
                    bTotal3 = bTotal;
                }
                aPos++;
                if (aPos >= aLen) {
                    break;
                }
                bMax3 = width2;
                cTotal5 = ciPos;
                bMax = width;
                ci3 = ci;
                bTotal3 = bTotal;
            }
            int i11 = k10 + stride;
            k10 = i11;
            if (i11 < 64) {
                cTotal = ciPos;
            } else {
                if (k10 >= 64) {
                    break;
                }
                cTotal = ciPos;
                k10 = 64 - width;
                MASK2 &= MASK2 << (64 - k10);
            }
            int bTotal4 = bTotal;
            shiftUp(c11, aLen, bTotal4, banks);
            bMax3 = width2;
            cTotal5 = cTotal;
            bMax = width;
            ci3 = ci;
            bTotal3 = bTotal4;
        }
        int ciPos2 = ci.length;
        while (true) {
            int ciPos3 = ciPos2 - 1;
            if (ciPos3 <= 1) {
                return reduceResult(c11, ci[1], cLen, m10, ks);
            }
            if ((ciPos3 & 1) == 0) {
                cTotal2 = ciPos;
                cTotal3 = ciPos3;
                addShiftedUp(c11, ci[ciPos3 >>> 1], c11, ci[ciPos3], cLen, 16);
            } else {
                cTotal2 = ciPos;
                cTotal3 = ciPos3;
                distribute(c11, ci[cTotal3], ci[cTotal3 - 1], ci[1], cLen);
            }
            ciPos2 = cTotal3;
            ciPos = cTotal2;
        }
    }

    public LongArray modReduce(int m10, int[] ks) {
        long[] buf = Arrays.clone(this.m_ints);
        int rLen = reduceInPlace(buf, 0, buf.length, m10, ks);
        return new LongArray(buf, 0, rLen);
    }

    public LongArray multiply(LongArray other, int m10, int[] ks) {
        int aDeg;
        int bDeg;
        int aDeg2 = degree();
        if (aDeg2 == 0) {
            return this;
        }
        int bDeg2 = other.degree();
        if (bDeg2 == 0) {
            return other;
        }
        LongArray A = this;
        LongArray B = other;
        if (aDeg2 > bDeg2) {
            A = other;
            B = this;
            aDeg2 = bDeg2;
            bDeg2 = aDeg2;
        }
        int tmp = aDeg2 + 63;
        int aLen = tmp >>> 6;
        int bLen = (bDeg2 + 63) >>> 6;
        int cLen = ((aDeg2 + bDeg2) + 62) >>> 6;
        if (aLen == 1) {
            long a02 = A.m_ints[0];
            if (a02 == 1) {
                return B;
            }
            long[] c02 = new long[cLen];
            multiplyWord(a02, B.m_ints, bLen, c02, 0);
            return new LongArray(c02, 0, cLen);
        }
        int bMax = ((bDeg2 + 7) + 63) >>> 6;
        int[] ti = new int[16];
        long[] T0 = new long[bMax << 4];
        ti[1] = bMax;
        System.arraycopy((Object) B.m_ints, 0, (Object) T0, bMax, bLen);
        int tOff = bMax;
        for (int i10 = 2; i10 < 16; i10++) {
            int i11 = tOff + bMax;
            tOff = i11;
            ti[i10] = i11;
            if ((i10 & 1) == 0) {
                shiftUp(T0, tOff >>> 1, T0, tOff, bMax, 1);
            } else {
                add(T0, bMax, T0, tOff - bMax, T0, tOff, bMax);
            }
        }
        int i12 = T0.length;
        long[] T1 = new long[i12];
        shiftUp(T0, 0, T1, 0, T0.length, 4);
        long[] a10 = A.m_ints;
        long[] c4 = new long[cLen << 3];
        int aPos = 0;
        while (aPos < aLen) {
            long aVal = a10[aPos];
            int cOff = aPos;
            long aVal2 = aVal;
            while (true) {
                aDeg = aDeg2;
                int u10 = ((int) aVal2) & 15;
                long aVal3 = aVal2 >>> 4;
                bDeg = bDeg2;
                int v2 = ((int) aVal3) & 15;
                addBoth(c4, cOff, T0, ti[u10], T1, ti[v2], bMax);
                aVal2 = aVal3 >>> 4;
                if (aVal2 == 0) {
                    break;
                }
                cOff += cLen;
                aDeg2 = aDeg;
                bDeg2 = bDeg;
            }
            aPos++;
            aDeg2 = aDeg;
            bDeg2 = bDeg;
        }
        int cOff2 = c4.length;
        while (true) {
            int i13 = cOff2 - cLen;
            cOff2 = i13;
            if (i13 == 0) {
                return new LongArray(c4, 0, cLen);
            }
            addShiftedUp(c4, cOff2 - cLen, c4, cOff2, cLen, 8);
            a10 = a10;
            T0 = T0;
            ti = ti;
        }
    }

    public void reduce(int m10, int[] ks) {
        long[] buf = this.m_ints;
        int rLen = reduceInPlace(buf, 0, buf.length, m10, ks);
        if (rLen < buf.length) {
            long[] jArr = new long[rLen];
            this.m_ints = jArr;
            System.arraycopy((Object) buf, 0, (Object) jArr, 0, rLen);
        }
    }

    private static LongArray reduceResult(long[] buf, int off, int len, int m10, int[] ks) {
        int rLen = reduceInPlace(buf, off, len, m10, ks);
        return new LongArray(buf, off, rLen);
    }

    private static int reduceInPlace(long[] buf, int off, int len, int m10, int[] ks) {
        int numBits;
        int numBits2;
        int len2;
        int vectorWiseWords;
        int mLen = (m10 + 63) >>> 6;
        if (len < mLen) {
            return len;
        }
        int numBits3 = Math.min(len << 6, (m10 << 1) - 1);
        int len3 = len;
        int excessBits = (len << 6) - numBits3;
        while (excessBits >= 64) {
            len3--;
            excessBits -= 64;
        }
        int kLen = ks.length;
        int kMax = ks[kLen - 1];
        int kNext = kLen > 1 ? ks[kLen - 2] : 0;
        int wordWiseLimit = Math.max(m10, kMax + 64);
        int vectorableWords = (Math.min(numBits3 - wordWiseLimit, m10 - kNext) + excessBits) >> 6;
        if (vectorableWords > 1) {
            int vectorWiseWords2 = len3 - vectorableWords;
            int vectorWiseWords3 = vectorWiseWords2;
            numBits = wordWiseLimit;
            reduceVectorWise(buf, off, len3, vectorWiseWords2, m10, ks);
            while (true) {
                vectorWiseWords = vectorWiseWords3;
                if (len3 <= vectorWiseWords) {
                    break;
                }
                len3--;
                buf[off + len3] = 0;
                vectorWiseWords3 = vectorWiseWords;
            }
            numBits2 = len3;
            len2 = vectorWiseWords << 6;
        } else {
            numBits = wordWiseLimit;
            numBits2 = len3;
            len2 = numBits3;
        }
        if (len2 > numBits) {
            reduceWordWise(buf, off, numBits2, numBits, m10, ks);
            len2 = numBits;
        }
        if (len2 > m10) {
            reduceBitWise(buf, off, len2, m10, ks);
        }
        return mLen;
    }

    private static void reduceBitWise(long[] buf, int off, int bitlength, int m10, int[] ks) {
        while (true) {
            bitlength--;
            if (bitlength >= m10) {
                if (testBit(buf, off, bitlength)) {
                    reduceBit(buf, off, bitlength, m10, ks);
                }
            } else {
                return;
            }
        }
    }

    private static void reduceBit(long[] buf, int off, int bit, int m10, int[] ks) {
        flipBit(buf, off, bit);
        int n10 = bit - m10;
        int j10 = ks.length;
        while (true) {
            j10--;
            if (j10 >= 0) {
                flipBit(buf, off, ks[j10] + n10);
            } else {
                flipBit(buf, off, n10);
                return;
            }
        }
    }

    private static void reduceWordWise(long[] buf, int off, int len, int toBit, int m10, int[] ks) {
        int toPos = toBit >>> 6;
        int len2 = len;
        while (true) {
            int len3 = len2 - 1;
            if (len3 <= toPos) {
                break;
            }
            long word = buf[off + len3];
            if (word != 0) {
                buf[off + len3] = 0;
                reduceWord(buf, off, len3 << 6, word, m10, ks);
            }
            len2 = len3;
        }
        int partial = toBit & 63;
        long word2 = buf[off + toPos] >>> partial;
        if (word2 != 0) {
            int i10 = off + toPos;
            buf[i10] = buf[i10] ^ (word2 << partial);
            reduceWord(buf, off, toBit, word2, m10, ks);
        }
    }

    private static void reduceWord(long[] buf, int off, int bit, long word, int m10, int[] ks) {
        int offset = bit - m10;
        int j10 = ks.length;
        while (true) {
            j10--;
            if (j10 >= 0) {
                flipWord(buf, off, ks[j10] + offset, word);
            } else {
                flipWord(buf, off, offset, word);
                return;
            }
        }
    }

    private static void reduceVectorWise(long[] buf, int off, int len, int words, int m10, int[] ks) {
        int baseBit = (words << 6) - m10;
        int j10 = ks.length;
        while (true) {
            int j11 = j10 - 1;
            if (j11 >= 0) {
                flipVector(buf, off, buf, off + words, len - words, baseBit + ks[j11]);
                j10 = j11;
            } else {
                flipVector(buf, off, buf, off + words, len - words, baseBit);
                return;
            }
        }
    }

    private static void flipVector(long[] x10, int xOff, long[] y10, int yOff, int yLen, int bits) {
        int xOff2 = xOff + (bits >>> 6);
        int bits2 = bits & 63;
        if (bits2 == 0) {
            add(x10, xOff2, y10, yOff, yLen);
        } else {
            long carry = addShiftedDown(x10, xOff2 + 1, y10, yOff, yLen, 64 - bits2);
            x10[xOff2] = x10[xOff2] ^ carry;
        }
    }

    public LongArray modSquare(int m10, int[] ks) {
        int len = getUsedLength();
        if (len == 0) {
            return this;
        }
        int _2len = len << 1;
        long[] r10 = new long[_2len];
        int pos = 0;
        while (pos < _2len) {
            long mi = this.m_ints[pos >>> 1];
            int pos2 = pos + 1;
            r10[pos] = interleave2_32to64((int) mi);
            pos = pos2 + 1;
            r10[pos2] = interleave2_32to64((int) (mi >>> 32));
        }
        return new LongArray(r10, 0, reduceInPlace(r10, 0, r10.length, m10, ks));
    }

    public LongArray modSquareN(int n10, int m10, int[] ks) {
        int len = getUsedLength();
        if (len == 0) {
            return this;
        }
        int mLen = (m10 + 63) >>> 6;
        long[] r10 = new long[mLen << 1];
        System.arraycopy((Object) this.m_ints, 0, (Object) r10, 0, len);
        while (true) {
            n10--;
            if (n10 >= 0) {
                squareInPlace(r10, len, m10, ks);
                len = reduceInPlace(r10, 0, r10.length, m10, ks);
            } else {
                return new LongArray(r10, 0, len);
            }
        }
    }

    public LongArray square(int m10, int[] ks) {
        int len = getUsedLength();
        if (len == 0) {
            return this;
        }
        int _2len = len << 1;
        long[] r10 = new long[_2len];
        int pos = 0;
        while (pos < _2len) {
            long mi = this.m_ints[pos >>> 1];
            int pos2 = pos + 1;
            r10[pos] = interleave2_32to64((int) mi);
            pos = pos2 + 1;
            r10[pos2] = interleave2_32to64((int) (mi >>> 32));
        }
        return new LongArray(r10, 0, r10.length);
    }

    private static void squareInPlace(long[] x10, int xLen, int m10, int[] ks) {
        int pos = xLen << 1;
        while (true) {
            xLen--;
            if (xLen >= 0) {
                long xVal = x10[xLen];
                int pos2 = pos - 1;
                x10[pos2] = interleave2_32to64((int) (xVal >>> 32));
                pos = pos2 - 1;
                x10[pos] = interleave2_32to64((int) xVal);
            } else {
                return;
            }
        }
    }

    private static void interleave(long[] x10, int xOff, long[] z10, int zOff, int count, int width) {
        switch (width) {
            case 3:
                interleave3(x10, xOff, z10, zOff, count);
                return;
            case 4:
            case 6:
            default:
                interleave2_n(x10, xOff, z10, zOff, count, bitLengths[width] - 1);
                return;
            case 5:
                interleave5(x10, xOff, z10, zOff, count);
                return;
            case 7:
                interleave7(x10, xOff, z10, zOff, count);
                return;
        }
    }

    private static void interleave3(long[] x10, int xOff, long[] z10, int zOff, int count) {
        for (int i10 = 0; i10 < count; i10++) {
            z10[zOff + i10] = interleave3(x10[xOff + i10]);
        }
    }

    private static long interleave3(long x10) {
        long z10 = Long.MIN_VALUE & x10;
        return (interleave3_21to63(((int) (x10 >>> 42)) & 2097151) << 2) | interleave3_21to63(((int) x10) & 2097151) | z10 | (interleave3_21to63(((int) (x10 >>> 21)) & 2097151) << 1);
    }

    private static long interleave3_21to63(int x10) {
        int[] iArr = INTERLEAVE3_TABLE;
        int r00 = iArr[x10 & 127];
        int r21 = iArr[(x10 >>> 7) & 127];
        int r42 = iArr[x10 >>> 14];
        return ((r42 & 4294967295L) << 42) | ((r21 & 4294967295L) << 21) | (4294967295L & r00);
    }

    private static void interleave5(long[] x10, int xOff, long[] z10, int zOff, int count) {
        for (int i10 = 0; i10 < count; i10++) {
            z10[zOff + i10] = interleave5(x10[xOff + i10]);
        }
    }

    private static long interleave5(long x10) {
        return interleave3_13to65(((int) x10) & HmsScanBase.ALL_SCAN_TYPE) | (interleave3_13to65(((int) (x10 >>> 13)) & HmsScanBase.ALL_SCAN_TYPE) << 1) | (interleave3_13to65(((int) (x10 >>> 26)) & HmsScanBase.ALL_SCAN_TYPE) << 2) | (interleave3_13to65(((int) (x10 >>> 39)) & HmsScanBase.ALL_SCAN_TYPE) << 3) | (interleave3_13to65(((int) (x10 >>> 52)) & HmsScanBase.ALL_SCAN_TYPE) << 4);
    }

    private static long interleave3_13to65(int x10) {
        int[] iArr = INTERLEAVE5_TABLE;
        int r00 = iArr[x10 & 127];
        int r35 = iArr[x10 >>> 7];
        return ((r35 & 4294967295L) << 35) | (4294967295L & r00);
    }

    private static void interleave7(long[] x10, int xOff, long[] z10, int zOff, int count) {
        for (int i10 = 0; i10 < count; i10++) {
            z10[zOff + i10] = interleave7(x10[xOff + i10]);
        }
    }

    private static long interleave7(long x10) {
        long z10 = Long.MIN_VALUE & x10;
        long[] jArr = INTERLEAVE7_TABLE;
        return jArr[((int) x10) & 511] | z10 | (jArr[((int) (x10 >>> 9)) & 511] << 1) | (jArr[((int) (x10 >>> 18)) & 511] << 2) | (jArr[((int) (x10 >>> 27)) & 511] << 3) | (jArr[((int) (x10 >>> 36)) & 511] << 4) | (jArr[((int) (x10 >>> 45)) & 511] << 5) | (jArr[((int) (x10 >>> 54)) & 511] << 6);
    }

    private static void interleave2_n(long[] x10, int xOff, long[] z10, int zOff, int count, int rounds) {
        for (int i10 = 0; i10 < count; i10++) {
            z10[zOff + i10] = interleave2_n(x10[xOff + i10], rounds);
        }
    }

    private static long interleave2_n(long x10, int rounds) {
        while (rounds > 1) {
            rounds -= 2;
            x10 = (interleave4_16to64(((int) (x10 >>> 16)) & 65535) << 1) | interleave4_16to64(((int) x10) & 65535) | (interleave4_16to64(((int) (x10 >>> 32)) & 65535) << 2) | (interleave4_16to64(((int) (x10 >>> 48)) & 65535) << 3);
        }
        if (rounds > 0) {
            return interleave2_32to64((int) x10) | (interleave2_32to64((int) (x10 >>> 32)) << 1);
        }
        return x10;
    }

    private static long interleave4_16to64(int x10) {
        int[] iArr = INTERLEAVE4_TABLE;
        int r00 = iArr[x10 & 255];
        int r32 = iArr[x10 >>> 8];
        return ((r32 & 4294967295L) << 32) | (4294967295L & r00);
    }

    private static long interleave2_32to64(int x10) {
        short[] sArr = INTERLEAVE2_TABLE;
        int r00 = sArr[x10 & 255] | (sArr[(x10 >>> 8) & 255] << 16);
        int r32 = (sArr[x10 >>> 24] << 16) | sArr[(x10 >>> 16) & 255];
        return ((r32 & 4294967295L) << 32) | (4294967295L & r00);
    }

    public LongArray modInverse(int m10, int[] ks) {
        int uzDegree = degree();
        if (uzDegree == 0) {
            throw new IllegalStateException();
        }
        if (uzDegree == 1) {
            return this;
        }
        LongArray uz = (LongArray) clone();
        int t2 = (m10 + 63) >>> 6;
        LongArray vz = new LongArray(t2);
        reduceBit(vz.m_ints, 0, m10, m10, ks);
        LongArray g1z = new LongArray(t2);
        g1z.m_ints[0] = 1;
        LongArray g2z = new LongArray(t2);
        int[] uvDeg = {uzDegree, m10 + 1};
        LongArray[] uv = {uz, vz};
        int[] ggDeg = {1, 0};
        LongArray[] gg = {g1z, g2z};
        int b4 = 1;
        int duv1 = uvDeg[1];
        int dgg1 = ggDeg[1];
        int j10 = duv1 - uvDeg[1 - 1];
        while (true) {
            if (j10 < 0) {
                j10 = -j10;
                uvDeg[b4] = duv1;
                ggDeg[b4] = dgg1;
                b4 = 1 - b4;
                duv1 = uvDeg[b4];
                dgg1 = ggDeg[b4];
            }
            int uzDegree2 = uzDegree;
            LongArray uz2 = uz;
            uv[b4].addShiftedByBitsSafe(uv[1 - b4], uvDeg[1 - b4], j10);
            int duv2 = uv[b4].degreeFrom(duv1);
            if (duv2 == 0) {
                return gg[1 - b4];
            }
            int dgg2 = ggDeg[1 - b4];
            int[] ggDeg2 = ggDeg;
            gg[b4].addShiftedByBitsSafe(gg[1 - b4], dgg2, j10);
            int dgg22 = dgg2 + j10;
            if (dgg22 > dgg1) {
                dgg1 = dgg22;
            } else if (dgg22 == dgg1) {
                dgg1 = gg[b4].degreeFrom(dgg1);
            }
            j10 += duv2 - duv1;
            duv1 = duv2;
            uzDegree = uzDegree2;
            uz = uz2;
            ggDeg = ggDeg2;
        }
    }

    public boolean equals(Object o10) {
        if (!(o10 instanceof LongArray)) {
            return false;
        }
        LongArray other = (LongArray) o10;
        int usedLen = getUsedLength();
        if (other.getUsedLength() != usedLen) {
            return false;
        }
        for (int i10 = 0; i10 < usedLen; i10++) {
            if (this.m_ints[i10] != other.m_ints[i10]) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        int usedLen = getUsedLength();
        int hash = 1;
        for (int i10 = 0; i10 < usedLen; i10++) {
            long mi = this.m_ints[i10];
            hash = (((hash * 31) ^ ((int) mi)) * 31) ^ ((int) (mi >>> 32));
        }
        return hash;
    }

    public Object clone() {
        return new LongArray(Arrays.clone(this.m_ints));
    }

    public String toString() {
        int i10 = getUsedLength();
        if (i10 == 0) {
            return "0";
        }
        int i11 = i10 - 1;
        StringBuffer sb2 = new StringBuffer(Long.toBinaryString(this.m_ints[i11]));
        while (true) {
            i11--;
            if (i11 >= 0) {
                String s2 = Long.toBinaryString(this.m_ints[i11]);
                int len = s2.length();
                if (len < 64) {
                    sb2.append(ZEROES.substring(len));
                }
                sb2.append(s2);
            } else {
                return sb2.toString();
            }
        }
    }
}
