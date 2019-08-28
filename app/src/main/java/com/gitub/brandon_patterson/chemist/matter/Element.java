package com.gitub.brandon_patterson.chemist.matter;

public enum Element {
    H("Hydrogen",1),
    HE("Helium",2),
    LI("Lithium",3),
    BE("Beryllium",4),
    B("Boron",5),
    C("Carbon",6),
    N("Nitrogen",7),
    O("Oxygen",8),
    F("Fluorine",9),
    NE("Neon",10),
    NA("Sodium",11),
    MG("Magnesium",12),
    AL("Aluminium",13),
    SI("Silicon",14),
    P("Phosphorus",15),
    S("Sulfur",16),
    CL("Chlorine",17),
    AR("Argon",18),
    K("Potassium",19),
    CA("Calcium",20),
    SC("Scandium",21),
    TI("Titanium",22),
    V("Vanadium",23),
    CR("Chromium",24),
    MN("Manganese",25),
    FE("Iron",26),
    CO("Cobalt",27),
    NI("Nickel",28),
    CU("Copper",29),
    ZN("Zinc",30),
    GA("Gallium",31),
    GE("Germanium",32),
    AS("Arsenic",33),
    SE("Selenium",34),
    BR("Bromine",35),
    KR("Krypton",36),
    RB("Rubidium",37),
    SR("Strontium",38),
    Y("Yttrium",39),
    ZR("Zirconium",40),
    NB("Niobium",41),
    MO("Molybdenum",42),
    TC("Technetium",43),
    RU("Ruthenium",44),
    RH("Rhodium",45),
    PD("Palladium",46),
    AG("Silver",47),
    CD("Cadmium",48),
    IN("Indium",49),
    SN("Tin",50),
    SB("Antimony",51),
    TE("Tellurium",52),
    I("Iodine",53),
    XE("Xenon",54),
    CS("Caesium",55),
    BA("Barium",56),
    LA("Lanthanum",57),
    CE("Cerium",58),
    PR("Praseodymium",59),
    ND("Neodymium",60),
    PM("Promethium",61),
    SM("Samarium",62),
    EU("Europium",63),
    GD("Gadolinium",64),
    TB("Terbium",65),
    DY("Dysprosium",66),
    HO("Holmium",67),
    ER("Erbium",68),
    TM("Thulium",69),
    YB("Ytterbium",70),
    LU("Lutetium",71),
    HF("Hafnium",72),
    TA("Tantalum",73),
    W("Tungsten",74),
    RE("Rhenium",75),
    OS("Osmium",76),
    IR("Iridium",77),
    PT("Platinum",78),
    AU("Gold",79),
    HG("Mercury",80),
    TL("Thallium",81),
    PB("Lead",82),
    BI("Bismuth",83),
    PO("Polonium",84),
    AT("Astatine",85),
    RN("Radon",86),
    FR("Francium",87),
    RA("Radium",88),
    AC("Actinium",89),
    TH("Thorium",90),
    PA("Protactinium",91),
    U("Uranium",92),
    NP("Neptunium",93),
    PU("Plutonium",94),
    AM("Americium",95),
    CM("Curium",96),
    BK("Berkelium",97),
    CF("Californium",98),
    ES("Einsteinium",99),
    FM("Fermium",100),
    MD("Mendelevium",101),
    NO("Nobelium",102),
    LR("Lawrencium",103),
    RF("Rutherfordium",104),
    DB("Dubnium",105),
    SG("Seaborgium",106),
    BH("Bohrium",107),
    HS("Hassium",108),
    MT("Meitnerium",109),
    DS("Darmstadtium",110),
    RG("Roentgenium",111),
    CN("Copernicium",112),
    NH("Nihonium",113),
    FL("Flerovium",114),
    MC("Moscovium",115),
    LV("Livermorium",116),
    TS("Tennessine",117),
    OG("Oganesson",118);

    private String name;
    private int atomicNumber;

    Element(String name, int atomicNumber)
    {
        this.name = name;
        this.atomicNumber = atomicNumber;
    }

    public int getAtomicNumber()
    {
        return atomicNumber;
    }

    public String getName()
    {
        return name;
    }

    public String getSymbol()
    {
        String allCapsSymbol = name();
        String titleCaseSymbol = allCapsSymbol.charAt(0) + allCapsSymbol.substring(1).toLowerCase();
        return titleCaseSymbol;
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

    public static Element fromName(String name) throws NoSuchElementException
    {
        for (Element e : Element.values())
        {
            if (name.equalsIgnoreCase(e.name))
            {
                return e;
            }
        }
        String message = String.format("No element found with name %s", name);
        throw new NoSuchElementException(message);
    }

    public static Element fromSymbol(String abbreviation) throws NoSuchElementException
    {
        try
        {
            return Element.valueOf(abbreviation.toUpperCase());
        }
        catch (Exception ex)
        {
            String message = String.format("No element found with abbreviation %s", abbreviation);
            throw new NoSuchElementException(message);
        }
    }
}

