/****************************************************************************
 * Copyright (C) 2014 GGA Software Services LLC
 *
 * This file may be distributed and/or modified under the terms of the
 * GNU General Public License version 3 as published by the Free Software
 * Foundation.
 *
 * This file is provided AS IS with NO WARRANTY OF ANY KIND, INCLUDING THE
 * WARRANTY OF DESIGN, MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, see <http://www.gnu.org/licenses>.
 ***************************************************************************/
package com.ggasoftware.uitest.control.simple;

import com.ggasoftware.uitest.control.base.Element;
import com.ggasoftware.uitest.control.interfaces.ICheckBox;
import org.openqa.selenium.By;

/**
 * Checkbox control implementation
 *
 * @author Alexeenko Yan
 * @author Belousov Andrey
 */
public class CheckBox extends Element implements ICheckBox {
    public CheckBox() { }
    public CheckBox(By byLocator) { super(byLocator); }

    protected void checkAction() {
        if (!isCheckedAction())
            clickAction();
    }
    protected void uncheckAction() {
        if (isCheckedAction())
            clickAction();
    }
    protected boolean isCheckedAction() { return getWebElement().isSelected(); }
    protected String getValueAction() { return isChecked().toString(); }
    protected void setValueAction(String value) {
        if (value.toLowerCase().equals("true") || value.toLowerCase().equals("1"))
            check();
        if (value.toLowerCase().equals("false") || value.toLowerCase().equals("0"))
            uncheck();
    }
    protected void clickAction() { getWebElement().click(); }

    public final void check() {
        doJAction("Check Checkbox", this::checkAction);
    }
    public final void uncheck() {
        doJAction("Uncheck Checkbox", this::uncheckAction);
    }
    public final Boolean isChecked() {
        return doJActionResult("IsChecked",
                this::isCheckedAction,
                result -> "Checkbox is " + (result ? "checked" : "unchecked"));
    }
    public final void click() {
        doJAction("Click on element", this::clickAction);
    }

    public final String getValue() { return doJActionResult("Get value", this::getValueAction); }
    public final void setValue(String value) { doJAction("Set value", () -> setValueAction(value)); }
}