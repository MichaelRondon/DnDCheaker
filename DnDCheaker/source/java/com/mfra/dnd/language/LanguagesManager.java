package com.mfra.dnd.language;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import com.mfra.dnd.checker.ACheckeable;
import com.mfra.dnd.checker.Ability;
import com.mfra.dnd.checker.Skill;
import com.mfra.dnd.dndclass.ADnDClass;
import com.mfra.dnd.race.ACharacterElement;
import com.mfra.dnd.race.ARace;
import com.mfra.dnd.util.DnDUtil;
import com.mfra.exceptions.GeneralException;

/**
 * @author Michael Felipe Rondón Acosta
 */
public class LanguagesManager extends
        ACharacterElement<LanguagesManager.LanguagesManagerName> {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    private Set<Language> languages            = new HashSet<Language>();
    private int           bonusLanguagesPoints = -1;

    /**
     * @param nameElement
     * @param checkProperties
     * @param descProperties
     */
    public LanguagesManager(LanguagesManagerName nameElement,
            HashMap<Enum<?>, ACheckeable> checkProperties,
            HashMap<String, Object> descProperties) {
        super(nameElement, checkProperties, descProperties);
    }

    /**
     * @param language
     */
    public void addBonusLanguage(Language language) {
        if ((language != null)
                && (this.bonusLanguagesPoints > 0)
                && (((ADnDClass) this.descProperties.get(ADnDClass.KEY_NAME)).getSetOfBonusLenguages().contains(
                        language) || ((ARace) this.descProperties.get(ARace.KEY_NAME)).getSetOfBonusLenguages().contains(
                        language))) {
            this.languages.add(language);
            --this.bonusLanguagesPoints;
        }
        else {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("You can't learn this Language: ");
            stringBuilder.append(language);
            throw new GeneralException(stringBuilder.toString());
        }

    }

    /**
     * @param language
     */
    public void addLanguage(Language language) {
        DnDUtil.getInstance().validIsClassSet(this.descProperties);
        if (language.equals(Language.DRUIDIC)
                && !((ADnDClass) this.descProperties.get(ADnDClass.KEY_NAME)).getName().equals(
                        ADnDClass.DnDClassName.DRUID)) {
            throw new GeneralException("This Language is restricted");
        }

        this.languages.add(language);
        Integer skillPoints = (Integer) this.descProperties.get(Skill.SKILL_POINTS);
        skillPoints -= 1;
        this.descProperties.put(Skill.SKILL_POINTS, skillPoints);

    }

    @Override
    public void setElement() {
        super.setElement();
        this.addAutoLanguages();
        this.bonusLanguagesPoints = ((Ability) this.checkProperties.get(Ability.AbilityName.INTELLIGENCE)).getAbilityModifier();
    }

    @Override
    public String toString() {
        return this.languages.toString();
    }

    private void addAutoLanguages() {
        Set<Language> setOfAutoLenguages = ((ARace) this.descProperties.get(ARace.KEY_NAME)).getSetOfAutoLenguages();
        this.languages.addAll(setOfAutoLenguages);
    }

    @Override
    protected String getKeyName() {
        return LanguagesManagerName.LANGUAGES.toString();
    }

    /**
     * 
     */
    protected void preValidation() {
        super.preValidation();
        DnDUtil.getInstance().validIsClassSet(this.descProperties);
        DnDUtil.getInstance().validIsRaceSet(this.descProperties);
    }

    /**
     * @author Michael Felipe Rondón Acosta
     */
    public enum LanguagesManagerName {
        /**
        * 
        */
        LANGUAGES
    }
}
