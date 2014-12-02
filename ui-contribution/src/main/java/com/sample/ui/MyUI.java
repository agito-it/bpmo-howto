package com.sample.ui;

import com.vaadin.annotations.PreserveOnRefresh;
import com.vaadin.navigator.Navigator;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewProvider;
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.MenuBar.Command;
import com.vaadin.ui.MenuBar.MenuItem;
import com.vaadin.ui.UI;

import de.agito.cps.ui.vaadin.common.IPageWrapper;
import de.agito.cps.ui.vaadin.common.UserMenuItem;
import de.agito.cps.ui.vaadin.common.component.ICommonMenuBar;
import de.agito.cps.ui.vaadin.common.component.ICommonMenuBar.IItemManager;
import de.agito.cps.ui.vaadin.common.resources.UIDataTypeFactory;

/**
 * UI for contributing to the agito BPM Center.
 */
@PreserveOnRefresh
public class MyUI extends UI {

  private static final long serialVersionUID = -6493486229466837051L;

  private final Navigator navigator = new Navigator(this, this);
  private IPageWrapper pageWrapper;
  private MyContribution myContribution;

  @Override
  protected void init(VaadinRequest request) {
    // create the center page wrapper
    if (pageWrapper == null) {
      pageWrapper = UIDataTypeFactory.getInstance().createCenterPageWrapper();

      // contribute custom items to the user menu
      contributeToUserMenu();
    }

    // add a view provider to the vaadin navigator
    navigator.addProvider(new ViewProvider() {

      private static final long serialVersionUID = -8939402545748500020L;

      @Override
      public String getViewName(final String viewAndParameters) {

        // default view
        MyView viewName = MyView.MyContribution;

        // resolve view by parameter
        try {
          viewName = MyView.valueOf(viewAndParameters);
        } catch (IllegalArgumentException e) {
          // unknown view
        }

        return viewName.name();

      }

      @Override
      public View getView(final String viewName) {

        switch (MyView.valueOf(viewName)) {
        case MyContribution:
          // build my contribution component
          if (myContribution == null)
            myContribution = new MyContribution();

          // set my contribution component as view.
          pageWrapper.setView(myContribution, viewName);
        }

        // return page wrapper
        return pageWrapper;

      }
    });

  }

  private void contributeToUserMenu() {
    final IItemManager itemManager = pageWrapper.getPageHeader().getUserMenuBar().getItemManager();
    ICommonMenuBar.IItem item = itemManager.getItemById(UserMenuItem.Seperator_1);
    if (item == null) // can be null if no theme selection is diabled
      item = itemManager.getItemById(UserMenuItem.Logout);

    itemManager.addItemBefore(itemManager.getItemById(UserMenuItem.Root).getMenuItem(), "MyPersonalizationDialog",
        "My Personalization", new Command() {

          private static final long serialVersionUID = -2478818831803636515L;

          @Override
          public void menuSelected(MenuItem selectedItem) {
            // TODO open a custom window
          }
        }, null, item.getMenuItem());
  }

  /**
   * Available Views enumeration.
   */
  public enum MyView {

    MyContribution
  }

}
