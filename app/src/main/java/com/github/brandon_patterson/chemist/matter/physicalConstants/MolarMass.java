package com.github.brandon_patterson.chemist.matter.physicalConstants;

import com.github.brandon_patterson.chemist.matter.Chemical;
import com.github.brandon_patterson.chemist.matter.ChemicalVisitor;
import com.github.brandon_patterson.chemist.matter.Element;
import com.github.brandon_patterson.chemist.matter.NoSuchElementException;
import com.github.brandon_patterson.chemist.measures.Measure;

public class MolarMass {

    public static Measure getMass(Element element) throws NoSuchElementException {
        switch (element)
        {
            case H:
            return new Measure(1.008, 4);
            case HE:
                return new Measure(4.002602, 7);
            case LI:
                return new Measure(6.94, 3);
            case BE:
                return new Measure(9.0121831, 8);
            case B:
                return new Measure(10.81, 4);
            case C:
                return new Measure(12.011, 5);
            case N:
                return new Measure(14.007, 5);
            case O:
                return new Measure(15.999, 5);
            case F:
                return new Measure(18.998403163, 11);
            case NE:
                return new Measure(20.1797, 6);
            case NA:
                return new Measure(22.98976928, 10);
            case MG:
                return new Measure(24.305, 5);
            case AL:
                return new Measure(26.9815384, 9);
            case SI:
                return new Measure(28.085, 5);
            case P:
                return new Measure(30.973761998, 11);
            case S:
                return new Measure(32.06, 4);
            case CL:
                return new Measure(35.45, 4);
            case AR:
                return new Measure(39.948, 5);
            case K:
                return new Measure(39.0983, 6);
            case CA:
                return new Measure(40.078, 5);
            case SC:
                return new Measure(44.955908, 8);
            case TI:
                return new Measure(47.867, 5);
            case V:
                return new Measure(50.9415, 6);
            case CR:
                return new Measure(51.9961, 6);
            case MN:
                return new Measure(54.938043, 8);
            case FE:
                return new Measure(55.845, 5);
            case CO:
                return new Measure(58.933194, 8);
            case NI:
                return new Measure(58.6934, 6);
            case CU:
                return new Measure(63.546, 5);
            case ZN:
                return new Measure(65.38, 4);
            case GA:
                return new Measure(69.723, 5);
            case GE:
                return new Measure(72.630, 5);
            case AS:
                return new Measure(74.921595, 8);
            case SE:
                return new Measure(78.971, 5);
            case BR:
                return new Measure(79.904, 5);
            case KR:
                return new Measure(83.798, 5);
            case RB:
                return new Measure(85.4678, 6);
            case SR:
                return new Measure(87.62, 4);
            case Y:
                return new Measure(88.90584, 7);
            case ZR:
                return new Measure(91.224, 5);
            case NB:
                return new Measure(92.90637, 7);
            case MO:
                return new Measure(95.95, 4);
            case TC:
                return new Measure(98, 2);
            case RU:
                return new Measure(101.07, 5);
            case RH:
                return new Measure(102.90549, 8);
            case PD:
                return new Measure(106.42, 5);
            case AG:
                return new Measure(107.8682, 7);
            case CD:
                return new Measure(112.414, 6);
            case IN:
                return new Measure(114.818, 6);
            case SN:
                return new Measure(118.710, 6);
            case SB:
                return new Measure(121.760, 6);
            case TE:
                return new Measure(127.60, 5);
            case I:
                return new Measure(126.90447, 8);
            case XE:
                return new Measure(131.293, 6);
            case CS:
                return new Measure(132.90545196, 11);
            case BA:
                return new Measure(137.327, 6);
            case LA:
                return new Measure(138.90547, 8);
            case CE:
                return new Measure(140.116, 6);
            case PR:
                return new Measure(140.90766, 8);
            case ND:
                return new Measure(144.242, 6);
            case PM:
                return new Measure(145, 3);
            case SM:
                return new Measure(150.36, 5);
            case EU:
                return new Measure(151.964, 6);
            case GD:
                return new Measure(157.25, 5);
            case TB:
                return new Measure(158.925354, 9);
            case DY:
                return new Measure(162.500, 6);
            case HO:
                return new Measure(164.930328, 9);
            case ER:
                return new Measure(167.259, 6);
            case TM:
                return new Measure(168.934218, 9);
            case YB:
                return new Measure(173.045, 6);
            case LU:
                return new Measure(174.9668, 7);
            case HF:
                return new Measure(178.49, 5);
            case TA:
                return new Measure(180.94788, 8);
            case W:
                return new Measure(183.84, 5);
            case RE:
                return new Measure(186.207, 6);
            case OS:
                return new Measure(190.23, 5);
            case IR:
                return new Measure(192.217, 6);
            case PT:
                return new Measure(195.084, 6);
            case AU:
                return new Measure(196.966570, 9);
            case HG:
                return new Measure(200.592, 6);
            case TL:
                return new Measure(204.38, 5);
            case PB:
                return new Measure(207.2, 4);
            case BI:
                return new Measure(208.98040, 8);
            case PO:
                return new Measure(209, 3);
            case AT:
                return new Measure(210, 3);
            case RN:
                return new Measure(222, 3);
            case FR:
                return new Measure(223, 3);
            case RA:
                return new Measure(226, 3);
            case AC:
                return new Measure(227, 3);
            case TH:
                return new Measure(232.0377, 7);
            case PA:
                return new Measure(231.03588, 8);
            case U:
                return new Measure(238.02891, 8);
            case NP:
                return new Measure(237, 3);
            case PU:
                return new Measure(244, 3);
            case AM:
                return new Measure(243, 3);
            case CM:
                return new Measure(247, 3);
            case BK:
                return new Measure(247, 3);
            case CF:
                return new Measure(251, 3);
            case ES:
                return new Measure(252, 3);
            case FM:
                return new Measure(257, 3);
            case MD:
                return new Measure(258, 3);
            case NO:
                return new Measure(259, 3);
            case LR:
                return new Measure(266, 3);
            case RF:
                return new Measure(267, 3);
            case DB:
                return new Measure(268, 3);
            case SG:
                return new Measure(269, 3);
            case BH:
                return new Measure(270, 3);
            case HS:
                return new Measure(270, 3);
            case MT:
                return new Measure(278, 3);
            case DS:
                return new Measure(281, 3);
            case RG:
                return new Measure(282, 3);
            case CN:
                return new Measure(285, 3);
            case NH:
                return new Measure(286, 3);
            case FL:
                return new Measure(289, 3);
            case MC:
                return new Measure(290, 3);
            case LV:
                return new Measure(293, 3);
            case TS:
                return new Measure(294, 3);
            case OG:
                return new Measure(294, 3);
            default:
                throw new NoSuchElementException();

        }
    }

    public static Measure getMass(Chemical chemical) throws NoSuchElementException
    {
        final Measure[] molarMass = {new Measure(0,Integer.MAX_VALUE)};
        final boolean[] hasError = {false};
        ChemicalVisitor visitor = new ChemicalVisitor() {
            int multiplier = 1;

            @Override
            public void visit(Element element, int count)
            {
                try
                {
                    Measure totalCount = new Measure(count * multiplier, Integer.MAX_VALUE);
                    Measure newMass = getMass(element).multiply(totalCount);
                    molarMass[0] = molarMass[0].add(newMass);
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
