package org.agito.demo.howto.processchoices.signal;


import de.agito.cps.core.bpmo.api.enums.ILanguage;
import java.util.Locale;


/**
 * Languages for SignalBPMO.
 *
 * @author andreas.weise
 */
public enum SignalBPMOLanguage implements ILanguage {

	en("en", new Locale("en"), true);

	private SignalBPMOLanguage(String code, Locale locale, boolean defaultIndicator) { this.code = code; this.locale = locale; this.defaultIndicator = defaultIndicator; }
	private String code;
	private boolean defaultIndicator;
	private Locale locale;
	public String getCode() { return code; }
	public boolean isDefault() { return defaultIndicator; }
	public Locale getLocale() { return locale; }

}

