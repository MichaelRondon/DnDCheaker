package com.mfra.dnd.race;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import com.mfra.dnd.checker.ACheckeable;
import com.mfra.dnd.checker.Ability;
import com.mfra.dnd.checker.AbilityManager;
import com.mfra.dnd.checker.Skill.SkillName;
import com.mfra.dnd.feat.AFeat;
import com.mfra.dnd.feat.MartialWeaponProficiency;
import com.mfra.dnd.language.Language;
import com.mfra.dnd.weapon.WeaponName;

/**
 * @author Michael Felipe Rondón Acosta
 */
public class Elf extends ARace {

    /**
	 * 
	 */
    private static final long serialVersionUID = 1L;

    /**
     * @param raceName
     * @param checkProperties
     * @param descProperties
     */
    public Elf(RaceName raceName,
            HashMap<Enum<?>, ACheckeable> checkProperties,
            HashMap<String, Object> descProperties) {
        super(raceName, checkProperties, descProperties);

        HashSet<String> specials = new HashSet<String>();
        specials.add("SleepImmunity");
        specials.add("+2RacialSavingThrowAgainstEnchantments");
        specials.add("Low-lightVision");
        specials.add("AutoSearchAt1_5meters");
        super.setSpecials(specials);
    }

    @Override
    public Set<Language> getSetOfAutoLenguages() {
        Set<Language> hashSet = new HashSet<Language>();
        hashSet.add(Language.COMMON);
        hashSet.add(Language.ELVEN);
        return hashSet;
    }

    @Override
    public Set<Language> getSetOfBonusLenguages() {
        Set<Language> hashSet = new HashSet<Language>();
        hashSet.add(Language.DRACONIC);
        hashSet.add(Language.GNOLL);
        hashSet.add(Language.GNOME);
        hashSet.add(Language.GOBLIN);
        hashSet.add(Language.ORC);
        hashSet.add(Language.SYLVAN);
        return null;
    }

    @Override
    protected void updateAbilities() {
        AbilityManager abilityManager = new AbilityManager(this.iBasicData);
        abilityManager.addToAbility(Ability.AbilityName.DEXTERITY, 2);
        abilityManager.addToAbility(Ability.AbilityName.CONSTITUTION, -2);

    }

    @Override
    protected void updateFeats() {
        MartialWeaponProficiency martialWeaponProficiency = new MartialWeaponProficiency(
                AFeat.FeatName.MARTIAL_WEAPON_PROFICIENCY, this.iBasicData);
        martialWeaponProficiency.setElement(WeaponName.LONGSWORD, true);
        martialWeaponProficiency.setElement(WeaponName.RAPIER, true);
        martialWeaponProficiency.setElement(WeaponName.LONGBOW, true);
        martialWeaponProficiency.setElement(WeaponName.LONGBOW_COMPOSITE, true);
        martialWeaponProficiency.setElement(WeaponName.SHORTBOW, true);
        martialWeaponProficiency
                .setElement(WeaponName.SHORTBOW_COMPOSITE, true);
    }

    @Override
    protected void updateSkillPoints() {
        this.skillManager.setRacialModifier(SkillName.LISTEN, 2);
        this.skillManager.setRacialModifier(SkillName.SPOT, 2);
        this.skillManager.setRacialModifier(SkillName.SEARCH, 2);
    }
}
