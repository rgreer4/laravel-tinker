package nl.deschepers.laraveltinker.settings

import at.favre.lib.crypto.bcrypt.BCrypt

/** ==========
 * Before you place a bug: I am aware this is insecure.
 * I just don't want to bother actual Patreon supporters with my donation message
 * Just note that decoding this does not give you any extra features - it JUST removes the "Please support me" message.
 * Consider supporting me to get a legit key:
 * see https://www.patreon.com/roboroads
 * ========== */

object PatreonSupport {
    private val KEY = object : Any() {
        var t = 0
        override fun toString(): String {
            val buf = ByteArray(237)
            t = -201911662
            buf[0] = (t ushr 1).toByte()
            t = 986482749
            buf[1] = (t ushr 5).toByte()
            t = 1456563283
            buf[2] = (t ushr 20).toByte()
            t = 181758622
            buf[3] = (t ushr 3).toByte()
            t = 2134549888
            buf[4] = (t ushr 15).toByte()
            t = -1916779236
            buf[5] = (t ushr 18).toByte()
            t = 1718622616
            buf[6] = (t ushr 16).toByte()
            t = 1130661631
            buf[7] = (t ushr 4).toByte()
            t = -1819106682
            buf[8] = (t ushr 19).toByte()
            t = 505421070
            buf[9] = (t ushr 6).toByte()
            t = -1380543795
            buf[10] = (t ushr 12).toByte()
            t = 798193625
            buf[11] = (t ushr 11).toByte()
            t = -1393194839
            buf[12] = (t ushr 21).toByte()
            t = 353989584
            buf[13] = (t ushr 22).toByte()
            t = 677947252
            buf[14] = (t ushr 16).toByte()
            t = -1403938007
            buf[15] = (t ushr 3).toByte()
            t = -1091935413
            buf[16] = (t ushr 11).toByte()
            t = -1429532768
            buf[17] = (t ushr 11).toByte()
            t = 1845517489
            buf[18] = (t ushr 6).toByte()
            t = -1425465224
            buf[19] = (t ushr 19).toByte()
            t = 353037810
            buf[20] = (t ushr 9).toByte()
            t = 241516162
            buf[21] = (t ushr 16).toByte()
            t = -551875317
            buf[22] = (t ushr 14).toByte()
            t = 827616899
            buf[23] = (t ushr 16).toByte()
            t = 1677879753
            buf[24] = (t ushr 8).toByte()
            t = -1414697221
            buf[25] = (t ushr 8).toByte()
            t = -32557585
            buf[26] = (t ushr 7).toByte()
            t = 1511608236
            buf[27] = (t ushr 14).toByte()
            t = 174053092
            buf[28] = (t ushr 1).toByte()
            t = 1532521792
            buf[29] = (t ushr 2).toByte()
            t = 442971693
            buf[30] = (t ushr 7).toByte()
            t = -396540465
            buf[31] = (t ushr 14).toByte()
            t = 1221474271
            buf[32] = (t ushr 17).toByte()
            t = -1934311384
            buf[33] = (t ushr 15).toByte()
            t = 927124793
            buf[34] = (t ushr 23).toByte()
            t = 101729614
            buf[35] = (t ushr 14).toByte()
            t = 1328399400
            buf[36] = (t ushr 13).toByte()
            t = -1167842114
            buf[37] = (t ushr 16).toByte()
            t = -994475863
            buf[38] = (t ushr 1).toByte()
            t = 932839822
            buf[39] = (t ushr 14).toByte()
            t = -1847661391
            buf[40] = (t ushr 5).toByte()
            t = -942274104
            buf[41] = (t ushr 2).toByte()
            t = -703386241
            buf[42] = (t ushr 11).toByte()
            t = 1495610232
            buf[43] = (t ushr 7).toByte()
            t = -1147376193
            buf[44] = (t ushr 2).toByte()
            t = 2073523547
            buf[45] = (t ushr 19).toByte()
            t = -1520761258
            buf[46] = (t ushr 4).toByte()
            t = 1050964984
            buf[47] = (t ushr 12).toByte()
            t = -1061232739
            buf[48] = (t ushr 9).toByte()
            t = 958014372
            buf[49] = (t ushr 3).toByte()
            t = 9784244
            buf[50] = (t ushr 12).toByte()
            t = 190947457
            buf[51] = (t ushr 10).toByte()
            t = -1687538518
            buf[52] = (t ushr 7).toByte()
            t = 2076499160
            buf[53] = (t ushr 6).toByte()
            t = 2015816032
            buf[54] = (t ushr 5).toByte()
            t = -1578701110
            buf[55] = (t ushr 1).toByte()
            t = 1705109398
            buf[56] = (t ushr 4).toByte()
            t = 19558709
            buf[57] = (t ushr 15).toByte()
            t = 1276898950
            buf[58] = (t ushr 14).toByte()
            t = -1723332859
            buf[59] = (t ushr 18).toByte()
            t = -1380608927
            buf[60] = (t ushr 10).toByte()
            t = -2096617713
            buf[61] = (t ushr 4).toByte()
            t = 119585336
            buf[62] = (t ushr 20).toByte()
            t = 191174389
            buf[63] = (t ushr 16).toByte()
            t = 243209357
            buf[64] = (t ushr 21).toByte()
            t = -489070204
            buf[65] = (t ushr 14).toByte()
            t = -1120243991
            buf[66] = (t ushr 8).toByte()
            t = 9890024
            buf[67] = (t ushr 1).toByte()
            t = 2053894655
            buf[68] = (t ushr 19).toByte()
            t = 651640024
            buf[69] = (t ushr 7).toByte()
            t = 317871313
            buf[70] = (t ushr 6).toByte()
            t = 123301177
            buf[71] = (t ushr 20).toByte()
            t = 1340310418
            buf[72] = (t ushr 11).toByte()
            t = 1022382978
            buf[73] = (t ushr 3).toByte()
            t = 980563388
            buf[74] = (t ushr 2).toByte()
            t = 395938707
            buf[75] = (t ushr 3).toByte()
            t = -1172714173
            buf[76] = (t ushr 23).toByte()
            t = 2088553563
            buf[77] = (t ushr 1).toByte()
            t = -1526043493
            buf[78] = (t ushr 18).toByte()
            t = -581622387
            buf[79] = (t ushr 16).toByte()
            t = 2057824438
            buf[80] = (t ushr 19).toByte()
            t = 361467060
            buf[81] = (t ushr 2).toByte()
            t = 1393216353
            buf[82] = (t ushr 24).toByte()
            t = -1227623136
            buf[83] = (t ushr 17).toByte()
            t = -842943056
            buf[84] = (t ushr 21).toByte()
            t = 418562887
            buf[85] = (t ushr 22).toByte()
            t = -1842159002
            buf[86] = (t ushr 15).toByte()
            t = 187478889
            buf[87] = (t ushr 21).toByte()
            t = 233695899
            buf[88] = (t ushr 21).toByte()
            t = -748965937
            buf[89] = (t ushr 11).toByte()
            t = -1723725672
            buf[90] = (t ushr 11).toByte()
            t = -1270534590
            buf[91] = (t ushr 5).toByte()
            t = 1053595221
            buf[92] = (t ushr 4).toByte()
            t = 1655248653
            buf[93] = (t ushr 15).toByte()
            t = -117155027
            buf[94] = (t ushr 3).toByte()
            t = 371677255
            buf[95] = (t ushr 6).toByte()
            t = 1496668705
            buf[96] = (t ushr 22).toByte()
            t = -1823537200
            buf[97] = (t ushr 19).toByte()
            t = 1855582627
            buf[98] = (t ushr 24).toByte()
            t = 1029817978
            buf[99] = (t ushr 4).toByte()
            t = -1446161596
            buf[100] = (t ushr 10).toByte()
            t = -1881642837
            buf[101] = (t ushr 8).toByte()
            t = -359846071
            buf[102] = (t ushr 13).toByte()
            t = 1558232800
            buf[103] = (t ushr 22).toByte()
            t = 351679081
            buf[104] = (t ushr 22).toByte()
            t = 1397207972
            buf[105] = (t ushr 3).toByte()
            t = -515449677
            buf[106] = (t ushr 6).toByte()
            t = 1515627522
            buf[107] = (t ushr 22).toByte()
            t = -1915114834
            buf[108] = (t ushr 21).toByte()
            t = -1113367140
            buf[109] = (t ushr 2).toByte()
            t = -395369783
            buf[110] = (t ushr 3).toByte()
            t = 1706554541
            buf[111] = (t ushr 15).toByte()
            t = -1549174571
            buf[112] = (t ushr 19).toByte()
            t = 585263620
            buf[113] = (t ushr 5).toByte()
            t = -876239064
            buf[114] = (t ushr 4).toByte()
            t = 2000140434
            buf[115] = (t ushr 15).toByte()
            t = -1521506780
            buf[116] = (t ushr 4).toByte()
            t = -2073971123
            buf[117] = (t ushr 16).toByte()
            t = -2029317056
            buf[118] = (t ushr 11).toByte()
            t = 1628880998
            buf[119] = (t ushr 12).toByte()
            t = -840676091
            buf[120] = (t ushr 18).toByte()
            t = 1642694698
            buf[121] = (t ushr 5).toByte()
            t = -1190015772
            buf[122] = (t ushr 23).toByte()
            t = 1026083427
            buf[123] = (t ushr 9).toByte()
            t = -1793169082
            buf[124] = (t ushr 22).toByte()
            t = -2122332380
            buf[125] = (t ushr 4).toByte()
            t = -1892038251
            buf[126] = (t ushr 21).toByte()
            t = 1777809094
            buf[127] = (t ushr 24).toByte()
            t = -996739349
            buf[128] = (t ushr 4).toByte()
            t = -1768297235
            buf[129] = (t ushr 5).toByte()
            t = -1442654809
            buf[130] = (t ushr 23).toByte()
            t = 468096079
            buf[131] = (t ushr 22).toByte()
            t = -250444233
            buf[132] = (t ushr 9).toByte()
            t = -1446314122
            buf[133] = (t ushr 18).toByte()
            t = -1372393773
            buf[134] = (t ushr 15).toByte()
            t = 1259023556
            buf[135] = (t ushr 19).toByte()
            t = -1659633546
            buf[136] = (t ushr 22).toByte()
            t = 1035547351
            buf[137] = (t ushr 7).toByte()
            t = 575390980
            buf[138] = (t ushr 2).toByte()
            t = -775383186
            buf[139] = (t ushr 9).toByte()
            t = -1235595305
            buf[140] = (t ushr 20).toByte()
            t = -1411932885
            buf[141] = (t ushr 12).toByte()
            t = -1940801974
            buf[142] = (t ushr 14).toByte()
            t = -138707046
            buf[143] = (t ushr 11).toByte()
            t = 18657850
            buf[144] = (t ushr 14).toByte()
            t = -361288463
            buf[145] = (t ushr 7).toByte()
            t = 467619962
            buf[146] = (t ushr 22).toByte()
            t = 784184601
            buf[147] = (t ushr 21).toByte()
            t = -100346074
            buf[148] = (t ushr 4).toByte()
            t = -162816148
            buf[149] = (t ushr 11).toByte()
            t = 1395519627
            buf[150] = (t ushr 19).toByte()
            t = -1381536576
            buf[151] = (t ushr 8).toByte()
            t = 1753638598
            buf[152] = (t ushr 12).toByte()
            t = 1641155300
            buf[153] = (t ushr 5).toByte()
            t = -2039109718
            buf[154] = (t ushr 10).toByte()
            t = -145874199
            buf[155] = (t ushr 20).toByte()
            t = 958452070
            buf[156] = (t ushr 9).toByte()
            t = 595331683
            buf[157] = (t ushr 19).toByte()
            t = 831436247
            buf[158] = (t ushr 2).toByte()
            t = -1365519888
            buf[159] = (t ushr 21).toByte()
            t = 348659963
            buf[160] = (t ushr 22).toByte()
            t = -1701925831
            buf[161] = (t ushr 13).toByte()
            t = 386124598
            buf[162] = (t ushr 20).toByte()
            t = 1884419768
            buf[163] = (t ushr 24).toByte()
            t = -2106138855
            buf[164] = (t ushr 9).toByte()
            t = -651436871
            buf[165] = (t ushr 6).toByte()
            t = -925635673
            buf[166] = (t ushr 3).toByte()
            t = 1686431380
            buf[167] = (t ushr 4).toByte()
            t = -1555449350
            buf[168] = (t ushr 10).toByte()
            t = -899310022
            buf[169] = (t ushr 10).toByte()
            t = -1363863025
            buf[170] = (t ushr 3).toByte()
            t = -777685267
            buf[171] = (t ushr 4).toByte()
            t = 540747006
            buf[172] = (t ushr 11).toByte()
            t = 748746838
            buf[173] = (t ushr 23).toByte()
            t = -448203019
            buf[174] = (t ushr 4).toByte()
            t = -573225838
            buf[175] = (t ushr 18).toByte()
            t = 472507685
            buf[176] = (t ushr 15).toByte()
            t = -363186706
            buf[177] = (t ushr 14).toByte()
            t = -1460282395
            buf[178] = (t ushr 6).toByte()
            t = -1696318548
            buf[179] = (t ushr 3).toByte()
            t = -1886992489
            buf[180] = (t ushr 12).toByte()
            t = 1825531108
            buf[181] = (t ushr 8).toByte()
            t = -290946008
            buf[182] = (t ushr 4).toByte()
            t = 1499803318
            buf[183] = (t ushr 22).toByte()
            t = -661583348
            buf[184] = (t ushr 3).toByte()
            t = 1513381327
            buf[185] = (t ushr 2).toByte()
            t = -1694489790
            buf[186] = (t ushr 3).toByte()
            t = -778536877
            buf[187] = (t ushr 14).toByte()
            t = 1049470373
            buf[188] = (t ushr 13).toByte()
            t = 815778603
            buf[189] = (t ushr 3).toByte()
            t = 1722206459
            buf[190] = (t ushr 9).toByte()
            t = 1252755943
            buf[191] = (t ushr 5).toByte()
            t = 1039617217
            buf[192] = (t ushr 5).toByte()
            t = -1966178602
            buf[193] = (t ushr 19).toByte()
            t = -1831178353
            buf[194] = (t ushr 8).toByte()
            t = 1103686549
            buf[195] = (t ushr 9).toByte()
            t = -1351759320
            buf[196] = (t ushr 10).toByte()
            t = 658304756
            buf[197] = (t ushr 20).toByte()
            t = 794839446
            buf[198] = (t ushr 2).toByte()
            t = 1791678528
            buf[199] = (t ushr 9).toByte()
            t = 478653236
            buf[200] = (t ushr 3).toByte()
            t = -526320932
            buf[201] = (t ushr 18).toByte()
            t = -646563388
            buf[202] = (t ushr 12).toByte()
            t = 1932053074
            buf[203] = (t ushr 6).toByte()
            t = -534670749
            buf[204] = (t ushr 11).toByte()
            t = -1887894774
            buf[205] = (t ushr 4).toByte()
            t = -2041977214
            buf[206] = (t ushr 21).toByte()
            t = -1290563112
            buf[207] = (t ushr 20).toByte()
            t = 86942167
            buf[208] = (t ushr 20).toByte()
            t = 606020031
            buf[209] = (t ushr 2).toByte()
            t = 743810107
            buf[210] = (t ushr 21).toByte()
            t = -164011421
            buf[211] = (t ushr 8).toByte()
            t = 419654965
            buf[212] = (t ushr 5).toByte()
            t = -1683067661
            buf[213] = (t ushr 22).toByte()
            t = -91663496
            buf[214] = (t ushr 8).toByte()
            t = -1056383802
            buf[215] = (t ushr 1).toByte()
            t = -635084470
            buf[216] = (t ushr 22).toByte()
            t = 1120947386
            buf[217] = (t ushr 5).toByte()
            t = 672367013
            buf[218] = (t ushr 11).toByte()
            t = 677736673
            buf[219] = (t ushr 16).toByte()
            t = -2103385023
            buf[220] = (t ushr 9).toByte()
            t = 1462226554
            buf[221] = (t ushr 5).toByte()
            t = -1970999918
            buf[222] = (t ushr 19).toByte()
            t = 1882042891
            buf[223] = (t ushr 10).toByte()
            t = 1801282926
            buf[224] = (t ushr 8).toByte()
            t = 909172579
            buf[225] = (t ushr 15).toByte()
            t = 1134099442
            buf[226] = (t ushr 19).toByte()
            t = -376144602
            buf[227] = (t ushr 18).toByte()
            t = 603884070
            buf[228] = (t ushr 3).toByte()
            t = -2089037016
            buf[229] = (t ushr 19).toByte()
            t = 384582111
            buf[230] = (t ushr 20).toByte()
            t = -174528424
            buf[231] = (t ushr 9).toByte()
            t = 1112319588
            buf[232] = (t ushr 9).toByte()
            t = 1087271936
            buf[233] = (t ushr 8).toByte()
            t = 528165716
            buf[234] = (t ushr 11).toByte()
            t = 1633207626
            buf[235] = (t ushr 24).toByte()
            t = 727810118
            buf[236] = (t ushr 19).toByte()
            return String(buf)
        }
    }.toString()

    fun hasValidKey(): Boolean {
        val pluginSettings = GlobalSettingsState.getInstance()
        if (pluginSettings.patreonKey.isEmpty()) return false

        var actualKey = ""
        for (i in 0..KEY.length step 6) {
            actualKey += KEY[i]
        }

        return BCrypt.verifyer().verify(actualKey.toCharArray(), pluginSettings.patreonKey.toCharArray()).verified
    }
}
