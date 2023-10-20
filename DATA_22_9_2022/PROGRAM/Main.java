import java.math.BigInteger;

public class Main{
    public static void main(String[] args) {

        //BazaDesetAnaliza analiza = new BazaDesetAnaliza();
        int[] list = {5,7,9,11,17,25,27,31,35,37,39,41,47,49,51,61,67,69,75,77,79,81,95,101,111,115,117,119,121,125,135,137,139,145,147,159,161,165,179,181,185,189,195,199,207,209,215,217,221,235,237,245,247,249,255,257,261,265,271,275,291,297,299,301,311,315,317,321,339,341,347,359,367,369,375,377,385,389,391,397,401,405,411,415,419,425,431,437,441,445,447,451,455,457,459,467,469,475,481,485,501,507,511,517,525,529,535,537,545,551,555,557,567,569,579,581,587,601,605,609,619,625,627,629,639,647,649,651,671,675,677,685,689,691,697,705,707,709,711,717,719,731,745,755,759,765,777,781,801,805,811,815,817,819,829,831,839,845,847,849,875,881,885,891,895,899,907,909,915,919,921,931,937,941,947,949,959,961,969,971,985,997,1001,1005,1015,1017,1021,1027,1031,1039,1045,1047,1049,1057,1061,1067,1069,1087,1091,1097,1101,1119,1127,1129,1131,1141,1145,1147,1151,1159,1167,1181,1185,1195,1197,1199,1207,1221,1229,1235,1237,1239,1249,1251,1257,1259,1265,1271,1277,1281,1291,1299,1305,1309,1315,1321,1325,1327,1329,1339,1351,1357,1367,1375,1377,1379,1391,1395,1399,1411,1425,1427,1441,1445,1455,1461,1465,1469,1477,1479,1481,1487,1489,1491,1511,1515,1519,1521,1525,1529,1537,1545,1547,1557,1559,1565,1575,1587,1599,1601,1607,1609,1615,1617,1635,1637,1641,1647,1659,1661,1665,1675,1677,1689,1691,1697,1699,1701,1707,1717,1727,1729,1739,1741,1749,1767,1769,1771,1775,1777,1785,1799,1815,1819,1831,1841,1845,1851,1855,1859,1861,1881,1885,1887,1895,1901,1927,1929,1931,1937,1939,1941,1949,1965,1971,1977,1981,1985,1987,1997,1999,2005,2007,2011,2015,2019,2025,2035,2041,2049,2051,2055,2065,2071,2077,2109,2117,2119,2121,2127,2135,2137,2139,2141,2159,2161,2165,2167,2179,2187,2189,2191,2195,2205,2207,2225,2235,2239,2261,2279,2285,2289,2301,2305,2321,2329,2335,2337,2341,2347,2349,2351,2355,2357,2361,2365,2369,2377,2387,2389,2391,2399,2407,2417,2421,2427,2429,2445,2449,2455,2457,2459,2461,2475,2477,2487,2495,2505,2517,2519,2527,2531,2547,2555,2557,2559,2575,2579,2581,2597,2611,2625,2631,2641,2651,2655,2657,2659,2667,2669,2677,2679,2687,2709,2719,2737,2755,2761,2769,2791,2795,2797,2799,2805,2807,2825,2845,2847,2849,2851,2855,2861,2867,2869,2875,2887,2889,2891,2895,2901,2907,2917,2937,2939,2949,2951,2961,2965,2967,2971,2985,2987,2995,3005,3007,3027,3029,3031,3041,3051,3059,3065,3075,3077,3085,3089,3091,3105,3107,3111,3117,3119,3121,3125,3155,3157,3159,3161,3171,3175,3177,3181,3185,3195,3197,3199,3201,3205,3209,3215,3225,3229,3231,3237,3241,3247,3257,3261,3265,3267,3271,3275,3281,3287,3289,3297,3307,3315,3317,3329,3335,3345,3349,3357,3369,3377,3381,3391,3395,3405,3407,3411,3427,3429,3437,3439,3449,3461,3465,3469,3471,3481,3499,3505,3521,3525,3527,3539,3551,3559,3565,3569,3575,3577,3589,3595,3597,3605,3609,3611,3615,3619,3621,3635,3639,3645,3649,3657,3665,3671,3675,3677,3687,3689,3699,3705,3719,3721,3731,3735,3745,3747,3749,3751,3757,3759,3771,3797,3807,3811,3817,3819,3835,3839,3845,3855,3859,3861,3869,3885,3887,3895,3899,3901,3917,3925,3939,3947,3955,3979,3985,3989,4001,4007,4011,4017,4021,4027,4031,4035,4051,4055,4059,4065,4071,4077,4079,4087,4097,4105,4109,4111,4121,4125,4129,4147,4149,4151,4161,4165,4167,4171,4175,4177,4185,4189,4191,4207,4209,4211,4217,4221,4235,4239,4241,4249,4259,4295,4297,4301,4315,4317,4325,4329,4331,4345,4349,4351,4359,4367,4375,4379,4389,4401,4409,4415,4419,4427,4431,4449,4455,4457,4459,4471,4497,4501,4505,4511,4529,4535,4539,4541,4545,4549,4555,4557,4561,4581,4585,4587,4589,4599,4605,4609,4627,4629,4655,4657,4661,4665,4669,4675,4687,4701,4709,4711,4715,4717,4721,4731,4739,4741,4745,4755,4759,4767,4771,4785,4791,4799,4801,4807,4827,4857,4865,4867,4877,4885,4891,4895,4897,4899,4909,4919,4939,4961,4965,4967,4975,4979,4991,4995,4997,5001,5007,5029,5045,5049,5075,5077,5085,5091,5095,5105,5109,5117,5127,5157,5161,5175,5177,5185,5187,5197,5201,5207,5215,5227,5229,5239,5247,5255,5269,5277,5281,5285,5287,5289,5295,5305,5309,5311,5319,5331,5339,5347,5351,5355,5361,5371,5379,5385,5387,5397,5399,5407,5409,5415,5417,5421,5425,5429,5445,5451,5467,5485,5491,5511,5515,5519,5527,5537,5547,5549,5551,5555,5561,5567,5569,5581,5585,5607,5611,5617,5621,5641,5647,5649,5651,5655,5659,5667,5679,5689,5691,5701,5705,5707,5721,5731,5735,5737,5747,5759,5775,5777,5779,5781,5787,5795,5799,5819,5821,5841,5849,5857,5861,5865,5871,5885,5887,5889,5891,5899,5907,5911,5915,5919,5925,5929,5931,5945,5955,5957,5959,5969,5975,5977,5987,5989,5991,6015,6017,6031,6037,6041,6045,6047,6055,6061,6065,6067,6075,6079,6081,6089,6101,6109,6117,6135,6139,6149,6157,6167,6179,6185,6187,6191,6201,6205,6211,6215,6221,6227,6235,6237,6239,6241,6249,6257,6265,6267,6271,6275,6279,6281,6289,6297,6309,6325,6327,6349,6355,6365,6367,6375,6381,6397,6409,6411,6417,6421,6429,6451,6457,6459,6461,6471,6479,6485,6491,6495,6505,6509,6521,6527,6537,6547,6557,6559,6565,6569,6579,6585,6587,6601,6605,6611,6629,6659,6671,6677,6681,6691,6697,6699,6705,6711,6737,6739,6745,6751,6755,6757,6767,6769,6771,6781,6789,6795,6807,6811,6815,6827,6845,6851,6859,6869,6871,6879,6881,6887,6891,6895,6897,6905,6915,6925,6941,6949,6965,6967,6975,6977,6981,6997,6999,7009,7011,7027,7031,7035,7037,7041,7047,7049,7055,7067,7077,7079,7081,7087,7089,7095,7101,7111,7115,7125,7137,7145,7165,7177,7179,7181,7185,7191,7209,7217,7219,7241,7245,7249,7251,7255,7269,7271,7285,7287,7289,7291,7301,7307,7317,7341,7345,7367,7371,7375,7385,7389,7395,7397,7405,7411,7415,7417,7427,7431,7437,7439,7445,7447,7451,7459,7469,7475,7489,7495,7499,7509,7517,7525,7527,7529,7531,7541,7549,7551,7555,7579,7581,7587,7597,7599,7605,7629,7635,7639,7641,7647,7661,7667,7669,7675,7679,7681,7685,7709,7749,7759,7761,7777,7779,7789,7791,7801,7811,7817,7825,7829,7839,7847,7849,7851,7859,7865,7877,7887,7889,7899,7905,7907,7915,7921,7927,7929,7935,7945,7955,7961,7969,7979,7987,7989,7991,7997,8005,8019,8025,8031,8035,8041,8047,8055,8061,8075,8081,8085,8091,8097,8099,8101,8111,8127,8145,8165,8179,8187,8189,8197,8211,8217,8231,8237,8239,8241,8245,8251,8255,8257,8265,8269,8279,8281,8295,8301,8307,8309,8311,8319,8321,8325,8327,8329,8335,8355,8357,8371,8377,8395,8397,8409,8421,8435,8437,8441,8445,8449,8459,8461,8497,8501,8505,8507,8509,8511,8517,8531,8537,8559,8561,8567,8571,8577,8585,8591,8609,8617,8619,8621,8627,8629,8635,8637,8649,8655,8659,8665,8685,8701,8721,8727,8731,8739,8747,8767,8769,8785,8795,8809,8815,8825,8837,8839,8847,8851,8855,8867,8875,8889,8897,8901,8915,8917,8921,8927,8939,8951,8957,8959,8965,8967,8971,8979,8985,8991,8995,8999,9005,9011,9025,9037,9039,9047,9049,9051,9061,9069,9071,9081,9089,9091,9095,9105,9117,9127,9137,9141,9149,9155,9165,9177,9179,9189,9225,9229,9231,9245,9247,9251,9257,9265,9267,9271,9285,9291,9295,9299,9307,9315,9319,9341,9347,9357,9359,9361,9369,9377,9385,9387,9389,9399,9411,9417,9421,9429,9435,9441,9447,9455,9461,9467,9471,9485,9487,9495,9511,9519,9537,9545,9557,9559,9565,9571,9579,9585,9595,9597,9599,9607,9615,9621,9631,9641,9651,9659,9671,9687,9695,9715,9725,9727,9729,9735,9737,9739,9747,9749,9755,9757,9775,9777,9791,9807,9825,9835,9851,9859,9861,9867,9869,9875,9891,9897,9901,9919,9935,9937,9939,9947,9957,9979,9989,9991,9999,10001,10021,10035,10045,10049,10057,10059,10061,10065,10069,10079,10101,10111,10115,10127,10129,10139,10145,10155,10157,10175,10177,10195,10197,10201,10217,10219,10227,10231,10245,10247,10257,10261,10265,10267,10269,10287,10297,10301,10307,10309,10327,10329,10345,10349,10359,10365,10369,10371,10381,10385,10387,10395,10401,10421,10435,10439,10441,10451,10457,10467,10469,10475,10477,10479,10481,10489,10505,10507,10511,10517,10521,10525,10531,10539,10545,10555,10565,10567,10577,10591,10605,10607,10609,10619,10635,10637,10645,10651,10657,10659,10661,10667,10687,10689,10699,10717,10719,10721,10741,10745,10749,10751,10761,10775,10787,10791,10797,10819,10821,10825,10827,10829,10839,10857,10859,10881,10891,10905,10909,10917,10919,10925,10931,10941,10971,10975,10979,10989,10995,11009,11015,11025,11027,11029,11031,11039,11041,11049,11059,11079,11091,11097,11101,11107,11119,11135,11141,11151,11155,11157,11161,11165,11167,11169,11171,11177,11179,11189,11221,11235,11239,11245,11247,11255,11261,11265,11269,11281,11287,11289,11295,11311,11315,11319,11331,11335,11337,11345,11347,11349,11359,11367,11371,11379,11387,11389,11401,11405,11409,11419,11427,11429,11431,11435,11437,11441,11455,11465,11471,11477,11489,11497,11507,11517,11519,11521,11525,11535,11541,11545,11555,11561,11569,11575,11587,11609,11617,11625,11629,11631,11645,11657,11661,11669,11671,11689,11695,11707,11709,11711,11727,11735,11739,11741,11759,11765,11799,11801,11805,11807,11809,11811,11827,11837,11847,11851,11855,11861,11865,11867,11885,11895,11897,11899,11911,11917,11919,11925,11931,11939,11941,11961,11969,11975,11977,11981,11987,11997,12001,12007,12009,12021,12025,12047,12049,12051,12059,12071,12079,12081,12089,12101,12105,12107,12127,12129,12141,12145,12147,12151,12169,12171,12179,12185,12191,12199,12201,12205,12211,12221,12225,12229,12247,12257,12269,12271,12277,12281,12285,12287,12325,12331,12337,12339,12345,12347,12357,12359,12367,12371,12375,12379,12381,12411,12415,12417,12435,12439,12457,12459,12471,12477,12481,12485,12501,12505,12521,12527,12529,12537,12547,12549,12557,12565,12575,12579,12581,12597,12611,12625,12637,12639,12661,12665,12667,12675,12689,12691,12705,12717,12721,12731,12735,12739,12751,12761,12765,12767,12775,12789,12791,12795,12809,12829,12835,12845,12851,12855,12865,12871,12875,12877,12885,12887,12899,12901,12919,12927,12929,12949,12955,12969,12977,12981,12987,12995,12999,13005,13015,13025,13027,13029,13037,13057,13059,13069,13075,13079,13081,13085,13099,13109,13115,13117,13135,13139,13157,13159,13187,13191,13205,13207,13211,13237,13255,13257,13269,13285,13291,13295,13297,13299,13311,13317,13319,13325,13339,13341,13345,13347,13351,13355,13361,13365,13369,13377,13381,13401,13407,13425,13431,13447,13449,13477,13479,13481,13495,13501,13509,13515,13521,13541,13547,13555,13557,13559,13575,13579,13585,13589,13599,13605,13611,13615,13649,13659,13667,13677,13681,13691,13699,13701,13709,13711,13715,13737,13741,13751,13759,13775,13795,13797,13811,13817,13829,13831,13835,13841,13855,13865,13869,13879,13887,13891,13895,13901,13911,13919,13921,13949,13965,13971,13977,13985,13989,14009,14011,14017,14025,14027,14039,14047,14051,14055,14061,14065,14067,14077,14087,14105,14107,14115,14117,14125,14139,14147,14161,14177,14179,14185,14187,14191,14201,14205,14217,14235,14245,14247,14249,14251,14257,14261,14271,14275,14279,14285,14289,14307,14315,14325,14327,14329,14339,14347,14355,14359,14389,14391,14395,14399,14401,14405,14415,14419,14427,14441,14445,14447,14451,14461,14465,14467,14485,14489,14499,14509,14515,14517,14521,14551,14557,14567,14591,14597,14609,14611,14627,14635,14637,14639,14649,14655,14661,14667,14669,14679,14689,14707,14719,14725,14727,14737,14741,14747,14749,14751,14791,14795,14807,14809,14817,14821,14851,14857,14867,14875,14885,14887,14889,14895,14899,14907,14919,14921,14927,14929,14945,14955,14965,14991,14999,15001};

        //analiza.getIntervalMogucihProstih(1,15000);
        MersenePrimes mersenePrimes1 = new MersenePrimes(1,10000,6,list);
        mersenePrimes1.K_L_ANALIZA();

        //MersenePrimes mersenePrimes2 = new MersenePrimes(1,100000,6,list);
        //mersenePrimes2.K_L_ANALIZA();

        /*MersenePrimes mersenePrimes1 = new MersenePrimes(1300,1500,6,list);
        mersenePrimes1.start();
        MersenePrimes mersenePrimes2 = new MersenePrimes(1500,1700,6,list);
        mersenePrimes2.start();
        MersenePrimes mersenePrimes3 = new MersenePrimes(1700,list.length,6,list);
        mersenePrimes3.start();
        //MersenePrimes mersenePrimes1 = new MersenePrimes(1,1000,10);
        //BigInteger y = new BigInteger("0");
        //MersenePrimes mersenePrimes1 = new MersenePrimes(1,100000,5);
        //MersenePrimes mersenePrimes2 = new MersenePrimes(5900,6000,5);

        //mersenePrimes1.K_L_ANALIZA();
        /*BigInteger x = new BigInteger("10").pow(5996);
        System.out.println("GOTOVO"); //EUREKA
        y = x.subtract(BigInteger.TWO).subtract(BigInteger.ONE);
        System.out.println("GOTOVO");
        x = x.multiply(BigInteger.TEN);
        System.out.println("GOTOVO2");
        System.out.println("GOTOVO");
        System.out.println(y.isProbablePrime(1));
        System.out.println("GOTOVOOOOOOOO");
        //mersenePrimes1.K_L_ANALIZA();
        //mersenePrimes2.start();
        /*System.out.println(mersenePrimes1.provjeraValjanostiIndexa(4985));
        System.out.println(mersenePrimes1.provjeraValjanostiIndexa(7116));

        //BigInteger x = new BigInteger("10").pow(1000000).subtract(new BigInteger("3"));
        //System.out.println(x);
        //System.out.println(mersenePrimes1.konstrukcijaBroja(20));
        //mersenePrimes1.start();
        //mersenePrimes1.K_L_ANALIZA();
        //System.out.println(new BigInteger("").isProbablePrime(1));

        //BigInteger x = new BigInteger("10").pow(8258933).subtract(new BigInteger("3"));
        //System.out.println(x);

        /*MersenePrimes mersenePrimes1 = new MersenePrimes(1,2000,10);
        MersenePrimes mersenePrimes2 = new MersenePrimes(2000,3500,10);
        MersenePrimes mersenePrimes3 = new MersenePrimes(3500,4400,10);
        MersenePrimes mersenePrimes4 = new MersenePrimes(4400,5000,10);

        MersenePrimes mersenePrimes5 = new MersenePrimes(100000015,100000016,10);
        MersenePrimes mersenePrimes6 = new MersenePrimes(100000015,100000016,5);
        mersenePrimes5.start();
        mersenePrimes6.start();

        MersenePrimes mersenePrimes1 = new MersenePrimes(6700,7000,5);
        MersenePrimes mersenePrimes2 = new MersenePrimes(7000,7500,5);
        MersenePrimes mersenePrimes3 = new MersenePrimes(7500,7900,5);
        MersenePrimes mersenePrimes4 = new MersenePrimes(7900,8200,5);
        MersenePrimes mersenePrimes5 = new MersenePrimes(8200,8500,5);
        MersenePrimes mersenePrimes6 = new MersenePrimes(8500,9000,5);

        mersenePrimes1.start();
        mersenePrimes2.start();
        mersenePrimes3.start();
        mersenePrimes4.start();
        mersenePrimes5.start();
        mersenePrimes6.start();

        /*MersenePrimes mersenePrimes1 = new MersenePrimes(20000,22500);
        MersenePrimes mersenePrimes2 = new MersenePrimes(22500,24000);
        MersenePrimes mersenePrimes3 = new MersenePrimes(24000,25500);
        MersenePrimes mersenePrimes4 = new MersenePrimes(25500,27000);
        MersenePrimes mersenePrimes5 = new MersenePrimes(27000,28500);
        MersenePrimes mersenePrimes6 = new MersenePrimes(28500,30000);


        mersenePrimes1.start();
        mersenePrimes2.start();
        mersenePrimes3.start();
        mersenePrimes4.start();
        mersenePrimes5.start();
        mersenePrimes6.start();/* */
        
    }
}