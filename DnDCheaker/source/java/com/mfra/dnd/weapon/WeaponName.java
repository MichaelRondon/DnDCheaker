package com.mfra.dnd.weapon;

import java.math.BigDecimal;
import com.mfra.dice.Dice;
import com.mfra.dice.IDice;
import com.mfra.dnd.util.CoinsBuilder;
import com.mfra.dnd.util.DnDUtil;

/**
 * @author Michael Felipe Rondón Acosta
 */
public enum WeaponName {
    /**
     * 
     */
    GAUNTLET(new CoinsBuilder("2GP"), Dice.getDice("1D2"), Dice.getDice("1D3"), "×2",
            null, DnDUtil.getInstance().pundsToKilograms(1),
            WeaponType1.BLUDGEONING, WeaponType2.UNARMED_ATTACKS,
            WeaponType3.SIMPLE_WEAPONS),
    /**
     * 
     */
    UNARMED_STRIKE(null, Dice.getDice("1D2"), Dice.getDice("1D3"), null, null, null,
            null, WeaponType2.UNARMED_ATTACKS, WeaponType3.SIMPLE_WEAPONS),
    /**
     * 
     */
    DAGGER(new CoinsBuilder("2GP"), Dice.getDice("1D3"), Dice.getDice("1D4"),
            "19–20/×2", DnDUtil.getInstance().feetToMeters(10),
            DnDUtil.getInstance().pundsToKilograms(1),
            WeaponType1.PIERCING_OR_SLASHING, WeaponType2.LIGHT_MELEE_WEAPONS,
            WeaponType3.SIMPLE_WEAPONS),
    /**
     * 
     */
    DAGGER_PUNCHING(new CoinsBuilder("2GP"), Dice.getDice("1D3"), Dice.getDice("1D4"),
            "×3", null, DnDUtil.getInstance().pundsToKilograms(1),
            WeaponType1.PIERCING, WeaponType2.LIGHT_MELEE_WEAPONS,
            WeaponType3.SIMPLE_WEAPONS),
    /**
     * 
     */
    GAUNTLET_SPIKED(new CoinsBuilder("5GP"), Dice.getDice("1D3"), Dice.getDice("1D4"),
            "×2", null, DnDUtil.getInstance().pundsToKilograms(1),
            WeaponType1.PIERCING, WeaponType2.LIGHT_MELEE_WEAPONS,
            WeaponType3.SIMPLE_WEAPONS),
    /**
     * 
     */
    MACE_LIGHT(new CoinsBuilder("5GP"), Dice.getDice("1D4"), Dice.getDice("1D6"), "×2",
            null, DnDUtil.getInstance().pundsToKilograms(4),
            WeaponType1.BLUDGEONING, WeaponType2.LIGHT_MELEE_WEAPONS,
            WeaponType3.SIMPLE_WEAPONS),
    /**
     * 
     */
    SICKLE(new CoinsBuilder("6GP"), Dice.getDice("1D4"), Dice.getDice("1D6"), "×2",
            null, DnDUtil.getInstance().pundsToKilograms(2),
            WeaponType1.SLASHING, WeaponType2.LIGHT_MELEE_WEAPONS,
            WeaponType3.SIMPLE_WEAPONS),
    /**
     * 
     */
    CLUB(null, Dice.getDice("1D4"), Dice.getDice("1D6"), "×2",
            DnDUtil.getInstance().feetToMeters(10),
            DnDUtil.getInstance().pundsToKilograms(3), WeaponType1.BLUDGEONING,
            WeaponType2.ONE_HANDED_MELEE_WEAPONS, WeaponType3.SIMPLE_WEAPONS),
    /**
     * 
     */
    MACE_HEAVY(new CoinsBuilder("12GP"), Dice.getDice("1D6"), Dice.getDice("1D8"),
            "×2", null, DnDUtil.getInstance().pundsToKilograms(8),
            WeaponType1.BLUDGEONING, WeaponType2.ONE_HANDED_MELEE_WEAPONS,
            WeaponType3.SIMPLE_WEAPONS),
    /**
     * 
     */
    MORNINGSTAR(new CoinsBuilder("8GP"), Dice.getDice("1D6"), Dice.getDice("1D8"),
            "×2", null, DnDUtil.getInstance().pundsToKilograms(6),
            WeaponType1.BLUDGEONING_AND_PIERCING,
            WeaponType2.ONE_HANDED_MELEE_WEAPONS, WeaponType3.SIMPLE_WEAPONS),
    /**
     * 
     */
    SHORTSPEAR(new CoinsBuilder("1GP"), Dice.getDice("1D4"), Dice.getDice("1D6"), "×2",
            DnDUtil.getInstance().feetToMeters(20),
            DnDUtil.getInstance().pundsToKilograms(3), WeaponType1.PIERCING,
            WeaponType2.ONE_HANDED_MELEE_WEAPONS, WeaponType3.SIMPLE_WEAPONS),
    /**
     * 
     */
    LONGSPEAR(new CoinsBuilder("5GP"), Dice.getDice("1D6"), Dice.getDice("1D8"), "×3",
            null, DnDUtil.getInstance().pundsToKilograms(9),
            WeaponType1.PIERCING, WeaponType2.TWO_HANDED_MELEE_WEAPONS,
            WeaponType3.SIMPLE_WEAPONS),
    /**
     * 
     */
    QUARTERSTAFF(null, Dice.getDice("1D4"), Dice.getDice("1D6"), "×2", null,
            DnDUtil.getInstance().pundsToKilograms(4), WeaponType1.BLUDGEONING,
            WeaponType2.TWO_HANDED_MELEE_WEAPONS, WeaponType3.SIMPLE_WEAPONS),
    /**
     * 
     */
    SPEAR(new CoinsBuilder("2GP"), Dice.getDice("1D6"), Dice.getDice("1D8"), "×3",
            DnDUtil.getInstance().feetToMeters(20),
            DnDUtil.getInstance().pundsToKilograms(6), WeaponType1.PIERCING,
            WeaponType2.TWO_HANDED_MELEE_WEAPONS, WeaponType3.SIMPLE_WEAPONS),
    /**
     * 
     */
    CROSSBOW_HEAVY(new CoinsBuilder("50GP"), Dice.getDice("1D8"), Dice.getDice("1D10"),
            "19–20/×2", DnDUtil.getInstance().feetToMeters(120),
            DnDUtil.getInstance().pundsToKilograms(8), WeaponType1.PIERCING,
            WeaponType2.RANGED_WEAPONS, WeaponType3.SIMPLE_WEAPONS),
    /**
             * 
             */
    BOLTS_CROSSBOWHEAVY_X10(new CoinsBuilder("1GP"), null, null, null, null,
            DnDUtil.getInstance().pundsToKilograms(1), null,
            WeaponType2.RANGED_WEAPONS, WeaponType3.SIMPLE_WEAPONS),
    /**
     * 
     */
    CROSSBOW_LIGHT(new CoinsBuilder("35GP"), Dice.getDice("1D6"), Dice.getDice("1D8"),
            "19–20/×2", DnDUtil.getInstance().feetToMeters(80),
            DnDUtil.getInstance().pundsToKilograms(4), WeaponType1.PIERCING,
            WeaponType2.RANGED_WEAPONS, WeaponType3.SIMPLE_WEAPONS),
    /**
     * 
     */
    BOLTS_CROSSBOWLIGHT_X10(new CoinsBuilder("1GP"), null, null, null, null,
            DnDUtil.getInstance().pundsToKilograms(1), null,
            WeaponType2.RANGED_WEAPONS, WeaponType3.SIMPLE_WEAPONS),
    /**
     * 
     */
    DART(new CoinsBuilder("5SP"), Dice.getDice("1D3"), Dice.getDice("1D4"), "×2",
            DnDUtil.getInstance().feetToMeters(20),
            DnDUtil.getInstance().pundsToKilograms(new BigDecimal(0.5)),
            WeaponType1.PIERCING, WeaponType2.RANGED_WEAPONS,
            WeaponType3.SIMPLE_WEAPONS),
    /**
     * 
     */
    JAVELIN(new CoinsBuilder("1GP"), Dice.getDice("1D4"), Dice.getDice("1D6"), "×2",
            DnDUtil.getInstance().feetToMeters(30),
            DnDUtil.getInstance().pundsToKilograms(2), WeaponType1.PIERCING,
            WeaponType2.RANGED_WEAPONS, WeaponType3.SIMPLE_WEAPONS),
    /**
     * 
     */
    SLING(null, Dice.getDice("1D3"), Dice.getDice("1D4"), "×2",
            DnDUtil.getInstance().feetToMeters(50),
            DnDUtil.getInstance().pundsToKilograms(0), WeaponType1.BLUDGEONING,
            WeaponType2.RANGED_WEAPONS, WeaponType3.SIMPLE_WEAPONS),
    /**
     * 
     */
    BULLETS_SLING_X10(new CoinsBuilder("1SP"), null, null, null, null,
            DnDUtil.getInstance().pundsToKilograms(5), null,
            WeaponType2.LIGHT_MELEE_WEAPONS, WeaponType3.MARTIAL_WEAPONS),
    /**
     * 
     */
    AXE_THROWING(new CoinsBuilder("8GP"), Dice.getDice("1D4"), Dice.getDice("1D6"),
            "×2", DnDUtil.getInstance().feetToMeters(10),
            DnDUtil.getInstance().pundsToKilograms(2), WeaponType1.SLASHING,
            WeaponType2.LIGHT_MELEE_WEAPONS, WeaponType3.MARTIAL_WEAPONS),
    /**
     * 
     */
    HAMMER_LIGHT(new CoinsBuilder("1GP"), Dice.getDice("1D3"), Dice.getDice("1D4"),
            "×2", DnDUtil.getInstance().feetToMeters(20),
            DnDUtil.getInstance().pundsToKilograms(2), WeaponType1.BLUDGEONING,
            WeaponType2.LIGHT_MELEE_WEAPONS, WeaponType3.MARTIAL_WEAPONS),
    /**
     * 
     */
    HANDAXE(new CoinsBuilder("6GP"), Dice.getDice("1D4"), Dice.getDice("1D6"), "×3",
            null, DnDUtil.getInstance().pundsToKilograms(3),
            WeaponType1.SLASHING, WeaponType2.LIGHT_MELEE_WEAPONS,
            WeaponType3.MARTIAL_WEAPONS),
    /**
     * 
     */
    KUKRI(new CoinsBuilder("8GP"), Dice.getDice("1D3"), Dice.getDice("1D4"),
            "18–20/×2", null, DnDUtil.getInstance().pundsToKilograms(2),
            WeaponType1.SLASHING, WeaponType2.LIGHT_MELEE_WEAPONS,
            WeaponType3.MARTIAL_WEAPONS),
    /**
     * 
     */
    PICK_LIGHT(new CoinsBuilder("4GP"), Dice.getDice("1D3"), Dice.getDice("1D4"), "×4",
            null, DnDUtil.getInstance().pundsToKilograms(3),
            WeaponType1.PIERCING, WeaponType2.LIGHT_MELEE_WEAPONS,
            WeaponType3.MARTIAL_WEAPONS),
    /**
     * 
     */
    SHIELD_LIGHT(null, Dice.getDice("1D2"), Dice.getDice("1D3"), "×2", null, null,
            WeaponType1.BLUDGEONING, WeaponType2.LIGHT_MELEE_WEAPONS,
            WeaponType3.MARTIAL_WEAPONS),
    /**
     * 
     */
    SPIKED_ARMOR(null, Dice.getDice("1D4"), Dice.getDice("1D6"), "×2", null, null,
            WeaponType1.PIERCING, WeaponType2.LIGHT_MELEE_WEAPONS,
            WeaponType3.MARTIAL_WEAPONS),
    /**
     * 
     */
    SPIKED_SHIELD_LIGHT(null, Dice.getDice("1D3"), Dice.getDice("1D4"), "×2", null,
            null, WeaponType1.PIERCING, WeaponType2.LIGHT_MELEE_WEAPONS,
            WeaponType3.MARTIAL_WEAPONS),
    /**
     * 
     */
    SWORD_SHORT(new CoinsBuilder("10GP"), Dice.getDice("1D4"), Dice.getDice("1D6"),
            "19–20/×2", null, DnDUtil.getInstance().pundsToKilograms(2),
            WeaponType1.PIERCING, WeaponType2.LIGHT_MELEE_WEAPONS,
            WeaponType3.MARTIAL_WEAPONS),
    /**
     * 
     */
    BATTLEAXE(new CoinsBuilder("10GP"), Dice.getDice("1D6"), Dice.getDice("1D8"), "×3",
            null, DnDUtil.getInstance().pundsToKilograms(6),
            WeaponType1.SLASHING, WeaponType2.ONE_HANDED_MELEE_WEAPONS,
            WeaponType3.MARTIAL_WEAPONS),
    /**
     * 
     */
    FLAIL(new CoinsBuilder("8GP"), Dice.getDice("1D6"), Dice.getDice("1D8"), "×2",
            null, DnDUtil.getInstance().pundsToKilograms(5),
            WeaponType1.BLUDGEONING, WeaponType2.ONE_HANDED_MELEE_WEAPONS,
            WeaponType3.MARTIAL_WEAPONS),
    /**
     * 
     */
    LONGSWORD(new CoinsBuilder("15GP"), Dice.getDice("1D6"), Dice.getDice("1D8"),
            "19–20/×2", null, DnDUtil.getInstance().pundsToKilograms(4),
            WeaponType1.SLASHING, WeaponType2.ONE_HANDED_MELEE_WEAPONS,
            WeaponType3.MARTIAL_WEAPONS),
    /**
     * 
     */
    PICK_HEAVY(new CoinsBuilder("8GP"), Dice.getDice("1D4"), Dice.getDice("1D6"), "×4",
            null, DnDUtil.getInstance().pundsToKilograms(6),
            WeaponType1.PIERCING, WeaponType2.ONE_HANDED_MELEE_WEAPONS,
            WeaponType3.MARTIAL_WEAPONS),
    /**
     * 
     */
    RAPIER(new CoinsBuilder("20GP"), Dice.getDice("1D4"), Dice.getDice("1D6"),
            "18–20/×2", null, DnDUtil.getInstance().pundsToKilograms(2),
            WeaponType1.PIERCING, WeaponType2.ONE_HANDED_MELEE_WEAPONS,
            WeaponType3.MARTIAL_WEAPONS),
    /**
     * 
     */
    SCIMITAR(new CoinsBuilder("15GP"), Dice.getDice("1D4"), Dice.getDice("1D6"),
            "18–20/×2", null, DnDUtil.getInstance().pundsToKilograms(4),
            WeaponType1.SLASHING, WeaponType2.ONE_HANDED_MELEE_WEAPONS,
            WeaponType3.MARTIAL_WEAPONS),
    /**
     * 
     */
    SHIELD_HEAVY(null, Dice.getDice("1D3"), Dice.getDice("1D4"), "×2", null, null,
            WeaponType1.BLUDGEONING, WeaponType2.ONE_HANDED_MELEE_WEAPONS,
            WeaponType3.MARTIAL_WEAPONS),
    /**
     * 
     */
    SPIKED_SHIELD_HEAVY(null, Dice.getDice("1D4"), Dice.getDice("1D6"), "×2", null,
            null, WeaponType1.PIERCING, WeaponType2.ONE_HANDED_MELEE_WEAPONS,
            WeaponType3.MARTIAL_WEAPONS),
    /**
     * 
     */
    TRIDENT(new CoinsBuilder("15GP"), Dice.getDice("1D6"), Dice.getDice("1D8"), "×2",
            DnDUtil.getInstance().feetToMeters(10),
            DnDUtil.getInstance().pundsToKilograms(4), WeaponType1.PIERCING,
            WeaponType2.ONE_HANDED_MELEE_WEAPONS, WeaponType3.MARTIAL_WEAPONS),
    /**
     * 
     */
    WARHAMMER(new CoinsBuilder("12GP"), Dice.getDice("1D6"), Dice.getDice("1D8"), "×3",
            null, DnDUtil.getInstance().pundsToKilograms(5),
            WeaponType1.BLUDGEONING, WeaponType2.ONE_HANDED_MELEE_WEAPONS,
            WeaponType3.MARTIAL_WEAPONS),
    /**
     * 
     */
    FALCHION(new CoinsBuilder("75GP"), Dice.getDice("1D6"), Dice.getDice("2D4"),
            "18–20/×2", null, DnDUtil.getInstance().pundsToKilograms(8),
            WeaponType1.SLASHING, WeaponType2.TWO_HANDED_MELEE_WEAPONS,
            WeaponType3.MARTIAL_WEAPONS),
    /**
     * 
     */
    GLAIVE(new CoinsBuilder("8GP"), Dice.getDice("1D8"), Dice.getDice("1D10"), "×3",
            null, DnDUtil.getInstance().pundsToKilograms(10),
            WeaponType1.SLASHING, WeaponType2.TWO_HANDED_MELEE_WEAPONS,
            WeaponType3.MARTIAL_WEAPONS),
    /**
     * 
     */
    GREATAXE(new CoinsBuilder("20GP"), Dice.getDice("1D10"), Dice.getDice("1D12"),
            "×3", null, DnDUtil.getInstance().pundsToKilograms(12),
            WeaponType1.SLASHING, WeaponType2.TWO_HANDED_MELEE_WEAPONS,
            WeaponType3.MARTIAL_WEAPONS),
    /**
     * 
     */
    GREATCLUB(new CoinsBuilder("5GP"), Dice.getDice("1D8"), Dice.getDice("1D10"), "×2",
            null, DnDUtil.getInstance().pundsToKilograms(8),
            WeaponType1.BLUDGEONING, WeaponType2.TWO_HANDED_MELEE_WEAPONS,
            WeaponType3.MARTIAL_WEAPONS),
    /**
             * 
             */
    FLAIL_HEAVY(new CoinsBuilder("15GP"), Dice.getDice("1D8"), Dice.getDice("1D10"),
            "19–20/×2", null, DnDUtil.getInstance().pundsToKilograms(10),
            WeaponType1.BLUDGEONING, WeaponType2.TWO_HANDED_MELEE_WEAPONS,
            WeaponType3.MARTIAL_WEAPONS),
    /**
             * 
             */
    GREATSWORD(new CoinsBuilder("50GP"), Dice.getDice("1D10"), Dice.getDice("2D6"),
            "19–20/×2", null, DnDUtil.getInstance().pundsToKilograms(8),
            WeaponType1.SLASHING, WeaponType2.TWO_HANDED_MELEE_WEAPONS,
            WeaponType3.MARTIAL_WEAPONS),
    /**
     * 
     */
    GUISARME4(new CoinsBuilder("9GP"), Dice.getDice("1D6"), Dice.getDice("2D4"), "×3",
            null, DnDUtil.getInstance().pundsToKilograms(12),
            WeaponType1.SLASHING, WeaponType2.TWO_HANDED_MELEE_WEAPONS,
            WeaponType3.MARTIAL_WEAPONS),
    /**
     * 
     */
    HALBERD(new CoinsBuilder("10GP"), Dice.getDice("1D8"), Dice.getDice("1D10"), "×3",
            null, DnDUtil.getInstance().pundsToKilograms(12),
            WeaponType1.PIERCING_OR_SLASHING,
            WeaponType2.TWO_HANDED_MELEE_WEAPONS, WeaponType3.MARTIAL_WEAPONS),
    /**
             * 
             */
    LANCE4(new CoinsBuilder("10GP"), Dice.getDice("1D6"), Dice.getDice("1D8"), "×3",
            null, DnDUtil.getInstance().pundsToKilograms(10),
            WeaponType1.PIERCING, WeaponType2.TWO_HANDED_MELEE_WEAPONS,
            WeaponType3.MARTIAL_WEAPONS),
    /**
     * 
     */
    RANSEUR4(new CoinsBuilder("10GP"), Dice.getDice("1D6"), Dice.getDice("2D4"), "×3",
            null, DnDUtil.getInstance().pundsToKilograms(12),
            WeaponType1.PIERCING, WeaponType2.TWO_HANDED_MELEE_WEAPONS,
            WeaponType3.MARTIAL_WEAPONS),
    /**
     * 
     */
    SCYTHE(new CoinsBuilder("18GP"), Dice.getDice("1D6"), Dice.getDice("2D4"), "×4",
            null, DnDUtil.getInstance().pundsToKilograms(10),
            WeaponType1.PIERCING_OR_SLASHING,
            WeaponType2.TWO_HANDED_MELEE_WEAPONS, WeaponType3.MARTIAL_WEAPONS),
    /**
     * 
     */
    LONGBOW(new CoinsBuilder("75GP"), Dice.getDice("1D6"), Dice.getDice("1D8"), "×3",
            DnDUtil.getInstance().feetToMeters(100),
            DnDUtil.getInstance().pundsToKilograms(3), WeaponType1.PIERCING,
            WeaponType2.RANGED_WEAPONS, WeaponType3.MARTIAL_WEAPONS),
    /**
     * 
     */
    ARROWS_LONGBOW_X20(new CoinsBuilder("1GP"), null, null, null, null,
            DnDUtil.getInstance().pundsToKilograms(3), null,
            WeaponType2.RANGED_WEAPONS, WeaponType3.MARTIAL_WEAPONS),
    /**
     * 
     */
    LONGBOW_COMPOSITE(new CoinsBuilder("100GP"), Dice.getDice("1D6"), Dice.getDice(
            "1D8"), "×3", DnDUtil.getInstance().feetToMeters(110),
            DnDUtil.getInstance().pundsToKilograms(3), WeaponType1.PIERCING,
            WeaponType2.RANGED_WEAPONS, WeaponType3.MARTIAL_WEAPONS),
    /**
     * 
     */
    ARROWS_LONGBOW_COMPOSITE_X20(new CoinsBuilder("1GP"), null, null, null,
            null, DnDUtil.getInstance().pundsToKilograms(3), null,
            WeaponType2.RANGED_WEAPONS, WeaponType3.MARTIAL_WEAPONS),
    /**
     * 
     */
    SHORTBOW(new CoinsBuilder("30GP"), Dice.getDice("1D4"), Dice.getDice("1D6"), "×3",
            DnDUtil.getInstance().feetToMeters(60),
            DnDUtil.getInstance().pundsToKilograms(2), WeaponType1.PIERCING,
            WeaponType2.RANGED_WEAPONS, WeaponType3.MARTIAL_WEAPONS),
    /**
     * 
     */
    ARROWS_SHORTBOW_X20(new CoinsBuilder("1GP"), null, null, null, null,
            DnDUtil.getInstance().pundsToKilograms(3), null,
            WeaponType2.RANGED_WEAPONS, WeaponType3.MARTIAL_WEAPONS),
    /**
     * 
     */
    SHORTBOW_COMPOSITE(new CoinsBuilder("75GP"), Dice.getDice("1D4"), Dice.getDice(
            "1D6"), "×3", DnDUtil.getInstance().feetToMeters(70),
            DnDUtil.getInstance().pundsToKilograms(2), WeaponType1.PIERCING,
            WeaponType2.RANGED_WEAPONS, WeaponType3.MARTIAL_WEAPONS),
    /**
     * 
     */
    ARROWS_SHORTBOW_COMPOSITE_X20(new CoinsBuilder("1GP"), null, null, null,
            null, DnDUtil.getInstance().pundsToKilograms(3), null,
            WeaponType2.RANGED_WEAPONS, WeaponType3.MARTIAL_WEAPONS),
    /**
     * 
     */
    KAMA(new CoinsBuilder("2GP"), Dice.getDice("1D4"), Dice.getDice("1D6"), "×2", null,
            DnDUtil.getInstance().pundsToKilograms(2), WeaponType1.SLASHING,
            WeaponType2.LIGHT_MELEE_WEAPONS, WeaponType3.EXOTIC_WEAPONS),
    /**
     * 
     */
    NUNCHAKU(new CoinsBuilder("2GP"), Dice.getDice("1D4"), Dice.getDice("1D6"), "×2",
            null, DnDUtil.getInstance().pundsToKilograms(2),
            WeaponType1.BLUDGEONING, WeaponType2.LIGHT_MELEE_WEAPONS,
            WeaponType3.EXOTIC_WEAPONS),
    /**
     * 
     */
    SAI(new CoinsBuilder("1GP"), Dice.getDice("1D3"), Dice.getDice("1D4"), "×2",
            DnDUtil.getInstance().feetToMeters(10),
            DnDUtil.getInstance().pundsToKilograms(1), WeaponType1.BLUDGEONING,
            WeaponType2.LIGHT_MELEE_WEAPONS, WeaponType3.EXOTIC_WEAPONS),
    /**
     * 
     */
    SIANGHAM(new CoinsBuilder("3GP"), Dice.getDice("1D4"), Dice.getDice("1D6"), "×2",
            null, DnDUtil.getInstance().pundsToKilograms(1),
            WeaponType1.PIERCING, WeaponType2.LIGHT_MELEE_WEAPONS,
            WeaponType3.EXOTIC_WEAPONS),
    /**
     * 
     */
    SWORD_BASTARD(new CoinsBuilder("35GP"), Dice.getDice("1D8"), Dice.getDice("1D10"),
            "19–20/×2", null, DnDUtil.getInstance().pundsToKilograms(6),
            WeaponType1.SLASHING, WeaponType2.ONE_HANDED_MELEE_WEAPONS,
            WeaponType3.EXOTIC_WEAPONS),
    /**
             * 
             */
    WARAXE_DWARVEN(new CoinsBuilder("30GP"), Dice.getDice("1D8"), Dice.getDice("1D10"),
            "×3", null, DnDUtil.getInstance().pundsToKilograms(8),
            WeaponType1.SLASHING, WeaponType2.ONE_HANDED_MELEE_WEAPONS,
            WeaponType3.EXOTIC_WEAPONS),
    /**
             * 
             */
    WHIP4(new CoinsBuilder("1GP"), Dice.getDice("1D2"), Dice.getDice("1D3"), "×2",
            null, DnDUtil.getInstance().pundsToKilograms(2),
            WeaponType1.SLASHING, WeaponType2.ONE_HANDED_MELEE_WEAPONS,
            WeaponType3.EXOTIC_WEAPONS),
    /**
     * 
     */
    AXE_ORC_DOUBLE5(new CoinsBuilder("60GP"), Dice.getDice("1D6"), Dice.getDice("1D8"),
            "×3", null, DnDUtil.getInstance().pundsToKilograms(15),
            WeaponType1.SLASHING, WeaponType2.TWO_HANDED_MELEE_WEAPONS,
            WeaponType3.EXOTIC_WEAPONS),
    /**
     * 
     */
    CHAIN_SPIKED4(new CoinsBuilder("25GP"), Dice.getDice("1D6"), Dice.getDice("2D4"),
            "×2", null, DnDUtil.getInstance().pundsToKilograms(10),
            WeaponType1.PIERCING, WeaponType2.TWO_HANDED_MELEE_WEAPONS,
            WeaponType3.EXOTIC_WEAPONS),
    /**
     * 
     */
    FLAIL_DIRE5(new CoinsBuilder("90GP"), Dice.getDice("1D6"), Dice.getDice("1D8"),
            "×2", null, DnDUtil.getInstance().pundsToKilograms(10),
            WeaponType1.BLUDGEONING, WeaponType2.TWO_HANDED_MELEE_WEAPONS,
            WeaponType3.EXOTIC_WEAPONS),
    /**
     * 
     */
    HAMMER_GNOME_HOOKED5(new CoinsBuilder("20GP"), Dice.getDice("1D6"), Dice.getDice(
            "1D8"), "×3/×4", null, DnDUtil.getInstance().pundsToKilograms(6),
            WeaponType1.BLUDGEONING_AND_PIERCING,
            WeaponType2.TWO_HANDED_MELEE_WEAPONS, WeaponType3.EXOTIC_WEAPONS),
    /**
     * 
     */
    SWORD_TWO_BLADED5(new CoinsBuilder("100GP"), Dice.getDice("1D6"), Dice.getDice(
            "1D8"), "19–20/×2", null,
            DnDUtil.getInstance().pundsToKilograms(10), WeaponType1.SLASHING,
            WeaponType2.TWO_HANDED_MELEE_WEAPONS, WeaponType3.EXOTIC_WEAPONS),
    /**
     * 
     */
    URGROSH_DWARVEN5(new CoinsBuilder("50GP"), Dice.getDice("1D6"),
            Dice.getDice("1D8"), "×3", null,
            DnDUtil.getInstance().pundsToKilograms(12),
            WeaponType1.SLASHING_OR_PIERCING,
            WeaponType2.TWO_HANDED_MELEE_WEAPONS, WeaponType3.EXOTIC_WEAPONS),
    /**
     * 
     */
    BOLAS(new CoinsBuilder("5GP"), Dice.getDice("1D33"), Dice.getDice("1D43"), "×2",
            DnDUtil.getInstance().feetToMeters(10),
            DnDUtil.getInstance().pundsToKilograms(2), WeaponType1.BLUDGEONING,
            WeaponType2.RANGED_WEAPONS, WeaponType3.EXOTIC_WEAPONS),
    /**
             * 
             */
    CROSSBOW_HAND(new CoinsBuilder("100GP"), Dice.getDice("1D3"), Dice.getDice("1D4"),
            "19–20/×2", DnDUtil.getInstance().feetToMeters(30),
            DnDUtil.getInstance().pundsToKilograms(2), WeaponType1.PIERCING,
            WeaponType2.RANGED_WEAPONS, WeaponType3.EXOTIC_WEAPONS),
    /**
     * 
     */
    CROSSBOW_HAND_BOLTS_X10(new CoinsBuilder("1GP"), null, null, null, null,
            DnDUtil.getInstance().pundsToKilograms(1), null,
            WeaponType2.RANGED_WEAPONS, WeaponType3.EXOTIC_WEAPONS),
    /**
     * 
     */
    CROSSBOW_REPEATING_HEAVY(new CoinsBuilder("400GP"), Dice.getDice("1D8"),
            Dice.getDice("1D10"), "19–20/×2", DnDUtil.getInstance().feetToMeters(
                    120), DnDUtil.getInstance().pundsToKilograms(12),
            WeaponType1.PIERCING, WeaponType2.RANGED_WEAPONS,
            WeaponType3.EXOTIC_WEAPONS),
    /**
             * 
             */
    CROSSBOW_REPEATING_HEAVY_BOLTS_X5(new CoinsBuilder("1GP"), null, null,
            null, null, DnDUtil.getInstance().pundsToKilograms(1), null,
            WeaponType2.RANGED_WEAPONS, WeaponType3.EXOTIC_WEAPONS),
    /**
     * 
     */
    CROSSBOW_REPEATING_LIGHT(new CoinsBuilder("250GP"), Dice.getDice("1D6"),
            Dice.getDice("1D8"), "19–20/×2",
            DnDUtil.getInstance().feetToMeters(80),
            DnDUtil.getInstance().pundsToKilograms(6), WeaponType1.PIERCING,
            WeaponType2.RANGED_WEAPONS, WeaponType3.EXOTIC_WEAPONS),
    /**
     * 
     */
    CROSSBOW_REPEATING_LIGHT_BOLTS_X5(new CoinsBuilder("1GP"), null, null,
            null, null, DnDUtil.getInstance().pundsToKilograms(1), null,
            WeaponType2.RANGED_WEAPONS, WeaponType3.EXOTIC_WEAPONS),
    /**
     * 
     */
    NET(new CoinsBuilder("20GP"), null, null, null,
            DnDUtil.getInstance().feetToMeters(10),
            DnDUtil.getInstance().pundsToKilograms(6), null,
            WeaponType2.RANGED_WEAPONS, WeaponType3.EXOTIC_WEAPONS),
    /**
     * 
     */
    SHURIKEN_X5(new CoinsBuilder("1GP"), Dice.getDice("1"), Dice.getDice("1D2"), "×2",
            DnDUtil.getInstance().feetToMeters(10),
            DnDUtil.getInstance().pundsToKilograms(new BigDecimal(0.5)),
            WeaponType1.PIERCING, WeaponType2.RANGED_WEAPONS,
            WeaponType3.EXOTIC_WEAPONS);

    private CoinsBuilder cost;
    private IDice         dmgs;
    private IDice         dmgl;
    private String       critical;
    private BigDecimal   rangeIncrement;
    private BigDecimal   weight;
    private WeaponType1  weaponType1;
    private WeaponType2  weaponType2;
    private WeaponType3  weaponType3;

    private WeaponName(CoinsBuilder cost, IDice dmgs, IDice dmgl,
            String critical, BigDecimal rangeIncrement, BigDecimal weight,
            WeaponType1 weaponType1, WeaponType2 weaponType2,
            WeaponType3 weaponType3) {
        this.cost = cost;
        this.dmgs = dmgs;
        this.dmgl = dmgl;
        this.critical = critical;
        this.rangeIncrement = rangeIncrement;
        this.weight = weight;
        this.weaponType1 = weaponType1;
        this.weaponType2 = weaponType2;
        this.weaponType3 = weaponType3;
    }

    /**
     * @return cost
     */
    public CoinsBuilder getCost() {
        return this.cost;
    }

    /**
     * @return critical
     */
    public String getCritical() {
        return this.critical;
    }

    /**
     * @return dmgl
     */
    public IDice getDmgl() {
        return this.dmgl;
    }

    /**
     * @return dmgs
     */
    public IDice getDmgs() {
        return this.dmgs;
    }

    /**
     * @return rangeIncrement
     */
    public BigDecimal getRangeIncrement() {
        return this.rangeIncrement;
    }

    /**
     * @return weaponType1
     */
    public WeaponType1 getWeaponType1() {
        return this.weaponType1;
    }

    /**
     * @return weaponType2
     */
    public WeaponType2 getWeaponType2() {
        return this.weaponType2;
    }

    /**
     * @return weaponType3
     */
    public WeaponType3 getWeaponType3() {
        return this.weaponType3;
    }

    /**
     * @return weight
     */
    public BigDecimal getWeight() {
        return this.weight;
    }

}
