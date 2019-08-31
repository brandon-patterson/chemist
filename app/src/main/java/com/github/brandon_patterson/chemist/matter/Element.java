package com.github.brandon_patterson.chemist.matter;

import android.content.Context;

import com.github.brandon_patterson.chemist.R;

public enum Element {
    H(R.string.element_symbol_001, R.string.element_name_001, 1),
    HE(R.string.element_symbol_002, R.string.element_name_002, 2),
    LI(R.string.element_symbol_003, R.string.element_name_003, 3),
    BE(R.string.element_symbol_004, R.string.element_name_004, 4),
    B(R.string.element_symbol_005, R.string.element_name_005, 5),
    C(R.string.element_symbol_006, R.string.element_name_006, 6),
    N(R.string.element_symbol_007, R.string.element_name_007, 7),
    O(R.string.element_symbol_008, R.string.element_name_008, 8),
    F(R.string.element_symbol_009, R.string.element_name_009, 9),
    NE(R.string.element_symbol_010, R.string.element_name_010, 10),
    NA(R.string.element_symbol_011, R.string.element_name_011, 11),
    MG(R.string.element_symbol_012, R.string.element_name_012, 12),
    AL(R.string.element_symbol_013, R.string.element_name_013, 13),
    SI(R.string.element_symbol_014, R.string.element_name_014, 14),
    P(R.string.element_symbol_015, R.string.element_name_015, 15),
    S(R.string.element_symbol_016, R.string.element_name_016, 16),
    CL(R.string.element_symbol_017, R.string.element_name_017, 17),
    AR(R.string.element_symbol_018, R.string.element_name_018, 18),
    K(R.string.element_symbol_019, R.string.element_name_019, 19),
    CA(R.string.element_symbol_020, R.string.element_name_020, 20),
    SC(R.string.element_symbol_021, R.string.element_name_021, 21),
    TI(R.string.element_symbol_022, R.string.element_name_022, 22),
    V(R.string.element_symbol_023, R.string.element_name_023, 23),
    CR(R.string.element_symbol_024, R.string.element_name_024, 24),
    MN(R.string.element_symbol_025, R.string.element_name_025, 25),
    FE(R.string.element_symbol_026, R.string.element_name_026, 26),
    CO(R.string.element_symbol_027, R.string.element_name_027, 27),
    NI(R.string.element_symbol_028, R.string.element_name_028, 28),
    CU(R.string.element_symbol_029, R.string.element_name_029, 29),
    ZN(R.string.element_symbol_030, R.string.element_name_030, 30),
    GA(R.string.element_symbol_031, R.string.element_name_031, 31),
    GE(R.string.element_symbol_032, R.string.element_name_032, 32),
    AS(R.string.element_symbol_033, R.string.element_name_033, 33),
    SE(R.string.element_symbol_034, R.string.element_name_034, 34),
    BR(R.string.element_symbol_035, R.string.element_name_035, 35),
    KR(R.string.element_symbol_036, R.string.element_name_036, 36),
    RB(R.string.element_symbol_037, R.string.element_name_037, 37),
    SR(R.string.element_symbol_038, R.string.element_name_038, 38),
    Y(R.string.element_symbol_039, R.string.element_name_039, 39),
    ZR(R.string.element_symbol_040, R.string.element_name_040, 40),
    NB(R.string.element_symbol_041, R.string.element_name_041, 41),
    MO(R.string.element_symbol_042, R.string.element_name_042, 42),
    TC(R.string.element_symbol_043, R.string.element_name_043, 43),
    RU(R.string.element_symbol_044, R.string.element_name_044, 44),
    RH(R.string.element_symbol_045, R.string.element_name_045, 45),
    PD(R.string.element_symbol_046, R.string.element_name_046, 46),
    AG(R.string.element_symbol_047, R.string.element_name_047, 47),
    CD(R.string.element_symbol_048, R.string.element_name_048, 48),
    IN(R.string.element_symbol_049, R.string.element_name_049, 49),
    SN(R.string.element_symbol_050, R.string.element_name_050, 50),
    SB(R.string.element_symbol_051, R.string.element_name_051, 51),
    TE(R.string.element_symbol_052, R.string.element_name_052, 52),
    I(R.string.element_symbol_053, R.string.element_name_053, 53),
    XE(R.string.element_symbol_054, R.string.element_name_054, 54),
    CS(R.string.element_symbol_055, R.string.element_name_055, 55),
    BA(R.string.element_symbol_056, R.string.element_name_056, 56),
    LA(R.string.element_symbol_057, R.string.element_name_057, 57),
    CE(R.string.element_symbol_058, R.string.element_name_058, 58),
    PR(R.string.element_symbol_059, R.string.element_name_059, 59),
    ND(R.string.element_symbol_060, R.string.element_name_060, 60),
    PM(R.string.element_symbol_061, R.string.element_name_061, 61),
    SM(R.string.element_symbol_062, R.string.element_name_062, 62),
    EU(R.string.element_symbol_063, R.string.element_name_063, 63),
    GD(R.string.element_symbol_064, R.string.element_name_064, 64),
    TB(R.string.element_symbol_065, R.string.element_name_065, 65),
    DY(R.string.element_symbol_066, R.string.element_name_066, 66),
    HO(R.string.element_symbol_067, R.string.element_name_067, 67),
    ER(R.string.element_symbol_068, R.string.element_name_068, 68),
    TM(R.string.element_symbol_069, R.string.element_name_069, 69),
    YB(R.string.element_symbol_070, R.string.element_name_070, 70),
    LU(R.string.element_symbol_071, R.string.element_name_071, 71),
    HF(R.string.element_symbol_072, R.string.element_name_072, 72),
    TA(R.string.element_symbol_073, R.string.element_name_073, 73),
    W(R.string.element_symbol_074, R.string.element_name_074, 74),
    RE(R.string.element_symbol_075, R.string.element_name_075, 75),
    OS(R.string.element_symbol_076, R.string.element_name_076, 76),
    IR(R.string.element_symbol_077, R.string.element_name_077, 77),
    PT(R.string.element_symbol_078, R.string.element_name_078, 78),
    AU(R.string.element_symbol_079, R.string.element_name_079, 79),
    HG(R.string.element_symbol_080, R.string.element_name_080, 80),
    TL(R.string.element_symbol_081, R.string.element_name_081, 81),
    PB(R.string.element_symbol_082, R.string.element_name_082, 82),
    BI(R.string.element_symbol_083, R.string.element_name_083, 83),
    PO(R.string.element_symbol_084, R.string.element_name_084, 84),
    AT(R.string.element_symbol_085, R.string.element_name_085, 85),
    RN(R.string.element_symbol_086, R.string.element_name_086, 86),
    FR(R.string.element_symbol_087, R.string.element_name_087, 87),
    RA(R.string.element_symbol_088, R.string.element_name_088, 88),
    AC(R.string.element_symbol_089, R.string.element_name_089, 89),
    TH(R.string.element_symbol_090, R.string.element_name_090, 90),
    PA(R.string.element_symbol_091, R.string.element_name_091, 91),
    U(R.string.element_symbol_092, R.string.element_name_092, 92),
    NP(R.string.element_symbol_093, R.string.element_name_093, 93),
    PU(R.string.element_symbol_094, R.string.element_name_094, 94),
    AM(R.string.element_symbol_095, R.string.element_name_095, 95),
    CM(R.string.element_symbol_096, R.string.element_name_096, 96),
    BK(R.string.element_symbol_097, R.string.element_name_097, 97),
    CF(R.string.element_symbol_098, R.string.element_name_098, 98),
    ES(R.string.element_symbol_099, R.string.element_name_099, 99),
    FM(R.string.element_symbol_100, R.string.element_name_100, 100),
    MD(R.string.element_symbol_101, R.string.element_name_101, 101),
    NO(R.string.element_symbol_102, R.string.element_name_102, 102),
    LR(R.string.element_symbol_103, R.string.element_name_103, 103),
    RF(R.string.element_symbol_104, R.string.element_name_104, 104),
    DB(R.string.element_symbol_105, R.string.element_name_105, 105),
    SG(R.string.element_symbol_106, R.string.element_name_106, 106),
    BH(R.string.element_symbol_107, R.string.element_name_107, 107),
    HS(R.string.element_symbol_108, R.string.element_name_108, 108),
    MT(R.string.element_symbol_109, R.string.element_name_109, 109),
    DS(R.string.element_symbol_110, R.string.element_name_110, 110),
    RG(R.string.element_symbol_111, R.string.element_name_111, 111),
    CN(R.string.element_symbol_112, R.string.element_name_112, 112),
    NH(R.string.element_symbol_113, R.string.element_name_113, 113),
    FL(R.string.element_symbol_114, R.string.element_name_114, 114),
    MC(R.string.element_symbol_115, R.string.element_name_115, 115),
    LV(R.string.element_symbol_116, R.string.element_name_116, 116),
    TS(R.string.element_symbol_117, R.string.element_name_117, 117),
    OG(R.string.element_symbol_118, R.string.element_name_118, 118);

    private int symbol_id;
    private int name_id;
    private int atomicNumber;

    Element(int symbol_id, int name_id, int atomicNumber)
    {
        this.symbol_id = symbol_id;
        this.name_id = name_id;
        this.atomicNumber = atomicNumber;
    }

    public int getAtomicNumber()
    {
        return atomicNumber;
    }

    public String getName(Context context)
    {
        return context.getResources().getString(name_id);
    }

    public String getSymbol(Context context)
    {
        return context.getResources().getString(symbol_id);
    }

    public static Element fromAtomicNumber(int atomicNumber) throws NoSuchElementException
    {
        for (Element e : Element.values())
        {
            if (e.atomicNumber == atomicNumber)
            {
                return e;
            }
        }
        String message = String.format("No element found with atomic number %s", atomicNumber);
        throw new NoSuchElementException(message);
    }

    public static Element fromName(String name, Context context) throws NoSuchElementException
    {
        for (Element e : Element.values())
        {
            if (name.equalsIgnoreCase(e.getName(context)))
            {
                return e;
            }
        }
        String message = String.format("No element found with name %s", name);
        throw new NoSuchElementException(message);
    }

    public static Element fromSymbol(String symbol, Context context) throws NoSuchElementException
    {
        for (Element e : Element.values())
        {
            if (symbol.equalsIgnoreCase(e.getSymbol(context)))
            {
                return e;
            }
        }
        String message = String.format("No element found with symbol %s", symbol);
        throw new NoSuchElementException(message);
    }
}

