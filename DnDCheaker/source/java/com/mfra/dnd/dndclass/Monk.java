package com.mfra.dnd.dndclass;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.mfra.dnd.checker.Skill;
import com.mfra.dnd.checker.Skill.SkillName;
import com.mfra.dnd.language.Language;
import com.mfra.dnd.util.IBasicData;

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
	 * @param iBasicData
	 */
	public Monk(DnDClassName dnDClassName, IBasicData iBasicData) {
		super(dnDClassName, iBasicData);
	}

	@Override
	public Set<Language> getSetOfBonusLenguages() {
		return new HashSet<Language>();
	}

	@Override
	protected List<SkillName> getClassSkills() {
		// TODO Auto-generated method stub
		return new ArrayList<Skill.SkillName>();
	}

}
