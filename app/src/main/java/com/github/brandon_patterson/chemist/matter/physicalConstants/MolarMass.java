package com.github.brandon_patterson.chemist.matter.physicalConstants;

import com.github.brandon_patterson.chemist.matter.Chemical;
import com.github.brandon_patterson.chemist.matter.ChemicalVisitor;
import com.github.brandon_patterson.chemist.matter.Element;
import com.github.brandon_patterson.chemist.matter.NoSuchElementException;

public class MolarMass {

    public static double getMass(Element element) throws NoSuchElementException {
        switch (element)
        {
            case H:
                return 1.008;
            case HE:
                return 4.002602;
            case LI:
                return 6.94;
            case BE:
                return 9.0121831;
            case B:
                return 10.81;
            case C:
                return 12.011;
            case N:
                return 14.007;
            case O:
                return 15.999;
            case F:
                return 18.998403163;
            case NE:
                return 20.1797;
            case NA:
                return 22.98976928;
            case MG:
                return 24.305;
            case AL:
                return 26.9815384;
            case SI:
                return 28.085;
            case P:
                return 30.973761998;
            case S:
                return 32.06;
            case CL:
                return 35.45;
            case AR:
                return 39.948;
            case K:
                return 39.0983;
            case CA:
                return 40.078;
            case SC:
                return 44.955908;
            case TI:
                return 47.867;
            case V:
                return 50.9415;
            case CR:
                return 51.9961;
            case MN:
                return 54.938043;
            case FE:
                return 55.845;
            case CO:
                return 58.933194;
            case NI:
                return 58.6934;
            case CU:
                return 63.546;
            case ZN:
                return 65.38;
            case GA:
                return 69.723;
            case GE:
                return 72.630;
            case AS:
                return 74.921595;
            case SE:
                return 78.971;
            case BR:
                return 79.904;
            case KR:
                return 83.798;
            case RB:
                return 85.4678;
            case SR:
                return 87.62;
            case Y:
                return 88.90584;
            case ZR:
                return 91.224;
            case NB:
                return 92.90637;
            case MO:
                return 95.95;
            case TC:
                return 98;
            case RU:
                return 101.07;
            case RH:
                return 102.90549;
            case PD:
                return 106.42;
            case AG:
                return 107.8682;
            case CD:
                return 112.414;
            case IN:
                return 114.818;
            case SN:
                return 118.710;
            case SB:
                return 121.760;
            case TE:
                return 127.60;
            case I:
                return 126.90447;
            case XE:
                return 131.293;
            case CS:
                return 132.90545196;
            case BA:
                return 137.327;
            case LA:
                return 138.90547;
            case CE:
                return 140.116;
            case PR:
                return 140.90766;
            case ND:
                return 144.242;
            case PM:
                return 145;
            case SM:
                return 150.36;
            case EU:
                return 151.964;
            case GD:
                return 157.25;
            case TB:
                return 158.925354;
            case DY:
                return 162.500;
            case HO:
                return 164.930328;
            case ER:
                return 167.259;
            case TM:
                return 168.934218;
            case YB:
                return 173.045;
            case LU:
                return 174.9668;
            case HF:
                return 178.49;
            case TA:
                return 180.94788;
            case W:
                return 183.84;
            case RE:
                return 186.207;
            case OS:
                return 190.23;
            case IR:
                return 192.217;
            case PT:
                return 195.084;
            case AU:
                return 196.966570;
            case HG:
                return 200.592;
            case TL:
                return 204.38;
            case PB:
                return 207.2;
            case BI:
                return 208.98040;
            case PO:
                return 209;
            case AT:
                return 210;
            case RN:
                return 222;
            case FR:
                return 223;
            case RA:
                return 226;
            case AC:
                return 227;
            case TH:
                return 232.0377;
            case PA:
                return 231.03588;
            case U:
                return 238.02891;
            case NP:
                return 237;
            case PU:
                return 244;
            case AM:
                return 243;
            case CM:
                return 247;
            case BK:
                return 247;
            case CF:
                return 251;
            case ES:
                return 252;
            case FM:
                return 257;
            case MD:
                return 258;
            case NO:
                return 259;
            case LR:
                return 266;
            case RF:
                return 267;
            case DB:
                return 268;
            case SG:
                return 269;
            case BH:
                return 270;
            case HS:
                return 270;
            case MT:
                return 278;
            case DS:
                return 281;
            case RG:
                return 282;
            case CN:
                return 285;
            case NH:
                return 286;
            case FL:
                return 289;
            case MC:
                return 290;
            case LV:
                return 293;
            case TS:
                return 294;
            case OG:
                return 294;
            default:
                throw new NoSuchElementException();
        }
    }

    public static double getMass(Chemical chemical) throws NoSuchElementException
    {
        final double[] molarMass = {0};
        final boolean[] hasError = {false};
        ChemicalVisitor visitor = new ChemicalVisitor() {
            int multiplier = 1;

            @Override
            public void visit(Element element, int count)
            {
                try
                {
                    molarMass[0] += getMass(element) * count * multiplier;
                }
                catch (NoSuchElementException ex)
                {
                    hasError[0] = true;
                }
            }

            @Override
            public void visit(Chemical polyatom, int count)
            {
                multiplier *= count;
                polyatom.accept(this);
                multiplier /= count;
            }
        };

        chemical.accept(visitor);
        if (hasError[0])
        {
            throw new NoSuchElementException();
        }
        return molarMass[0];
    }

    private MolarMass() { /*cannot be instantiated*/ }
}
