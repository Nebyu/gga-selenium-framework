package com.ggasoftware.jdi_ui_tests.implementation.selenium.elements.interfaces.common;

import com.ggasoftware.jdi_ui_tests.implementation.selenium.elements.interfaces.base.IElement;
import com.ggasoftware.jdi_ui_tests.implementation.selenium.elements.interfaces.base.IHasValue;
import com.ggasoftware.jdi_ui_tests.implementation.selenium.elements.page_objects.annotations.JDIAction;

/**
 * Created by Roman_Iovlev on 6/10/2015.
 */
public interface IText extends IHasValue, IElement {
    /** Get webElement’s text */
    String getText();
    /** Wait while webElement’s text contains expected text. Returns webElement’s text */
    @JDIAction
    String waitText(String text);
    /** Wait while webElement’s text matches regEx. Returns webElement’s text */
    @JDIAction
    String waitMatchText(String regEx);
}