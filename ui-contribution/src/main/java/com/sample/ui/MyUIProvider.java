package com.sample.ui;

import com.vaadin.server.UIClassSelectionEvent;
import com.vaadin.ui.UI;

import de.agito.cps.ui.vaadin.bpmo.BPMOUiProvider;

public class MyUIProvider extends BPMOUiProvider {

  private static final long serialVersionUID = -7442916263082101756L;

  @Override
  public Class<? extends UI> getUIClass(UIClassSelectionEvent event) {
    final Class<? extends UI> clazz = super.getUIClass(event);
    return clazz != null ? clazz : MyUI.class;
  }

}