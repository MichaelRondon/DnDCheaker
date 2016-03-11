package com.mfra.dnd.dndclass;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import com.mfra.dnd.checker.ACheckeable;
import com.mfra.dnd.checker.Skill;
import com.mfra.dnd.checker.Skill.SkillName;
import com.mfra.dnd.language.Language;

/**
 * @author Michael Felipe Rondón Acosta
 */
public class Druid extends ADnDClass {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    /**
     * @param dnDClassName
     * @param checkProperties
     * @param descProperties
     */
    public Druid(DnDClassName dnDClassName,
            HashMap<Enum<?>, ACheckeable> checkProperties,
            HashMap<String, Object> descProperties) {
        super(dnDClassName, checkProperties, descProperties);
    }

    @Override
    public Set<Language> getSetOfBonusLenguages() {
        Set<Language> hashSet = new HashSet<Language>();
        hashSet.add(Language.SYLVAN);
        return hashSet;
    }

    @Override
    protected List<SkillName> getClassSkills() {
        List<SkillName> skillNames = new ArrayList<Skill.SkillName>();
        skillNames.add(Skill.SkillName.CONCENTRATION);
        skillNames.add(Skill.SkillName.CRAFT);
        skillNames.add(Skill.SkillName.DIPLOMACY);
        skillNames.add(Skill.SkillName.HANDLE_ANIMAL);
        skillNames.add(Skill.SkillName.HEAL);
        skillNames.add(Skill.SkillName.KNOWLEDGE_NATURE);
        skillNames.add(Skill.SkillName.LISTEN);
        skillNames.add(Skill.SkillName.PROFESSION);
        skillNames.add(Skill.SkillName.RIDE);
        skillNames.add(Skill.SkillName.SPELLCRAFT);
        skillNames.add(Skill.SkillName.SPOT);
        skillNames.add(Skill.SkillName.SURVIVAL);
        skillNames.add(Skill.SkillName.SWIM);
        return skillNames;
    }

}
