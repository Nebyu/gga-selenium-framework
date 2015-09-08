package com.ggasoftware.jdi_ui_tests.implementation.selenium.elements.complex;

import com.ggasoftware.jdi_ui_tests.implementation.selenium.elements.BaseElement;
import com.ggasoftware.jdi_ui_tests.implementation.selenium.elements.base.Element;
import com.ggasoftware.jdi_ui_tests.implementation.selenium.elements.interfaces.complex.IGroup;
import com.ggasoftware.jdi_ui_tests.core.utils.usefulUtils.TryCatchUtil;
import org.openqa.selenium.By;

import static com.ggasoftware.jdi_ui_tests.core.settings.JDISettings.asserter;
import static com.ggasoftware.jdi_ui_tests.core.utils.common.EnumUtils.getEnumValue;
import static com.ggasoftware.jdi_ui_tests.core.utils.common.WebDriverByUtils.fillByTemplate;
import static java.lang.String.format;


/**
 * Created by Roman_Iovlev on 7/8/2015.
 */
public class ElementsGroup<TEnum extends Enum, TType extends Element> extends BaseElement implements IGroup<TEnum, TType> {
    public ElementsGroup() { }
    public ElementsGroup(By byLocator, Class<TType> clazz) {
        super(byLocator);
        this.clazz = clazz;
    }
    private Class<TType> clazz;

    public TType get(TEnum name) {
        return get(getEnumValue(name));
    }
    public TType get(String name) {
        TType instance = TryCatchUtil.tryGetResult(clazz::newInstance);
        if (instance == null)
            throw asserter.exception(format("Can't get instace of '%s' webElement from Elements Group '%s'", name, toString()));
        instance.setAvatar(fillByTemplate(getLocator(), name), getAvatar());
        return instance;
    }
}
