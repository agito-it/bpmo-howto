package com.sample.bpmo;


import de.agito.cps.core.bpmo.api.enums.ILanguage;
import java.util.Locale;


/**
 * Languages for HelloWorldBPMO.
 *
 * @author andreas.weise
 */
public enum HelloWorldBPMOLanguage implements ILanguage {

	en("en", new Locale("en"), true);

	private HelloWorldBPMOLanguage(String code, Locale locale, boolean defaultIndicator) { this.code = code; this.locale = locale; this.defaultIndicator = defaultIndicator; }
	private String code;
	private boolean defaultIndicator;
	private Locale locale;
	public String getCode() { return code; }
	public boolean isDefault() { return defaultIndicator; }
	public Locale getLocale() { return locale; }

}

