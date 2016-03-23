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
public class Monk extends ADnDClass {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * @param dnDClassName
	 * @param checkProperties
	 * @param descProperties
	 */
	public Monk(DnDClassName dnDClassName, HashMap<Enum<?>, ACheckeable> checkProperties,
			HashMap<String, Object> descProperties) {
		super(dnDClassName, checkProperties, descProperties);
	}

	@Override
	protected List<SkillName> getClassSkills() {
		// TODO Auto-generated method stub
		return new ArrayList<Skill.SkillName>();
	}

	@Override
	public Set<Language> getSetOfBonusLenguages() {
		return new HashSet<Language>();
	}

}
