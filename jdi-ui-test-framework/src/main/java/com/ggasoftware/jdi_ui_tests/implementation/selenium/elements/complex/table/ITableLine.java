package com.ggasoftware.jdi_ui_tests.implementation.selenium.elements.complex.table;

import com.ggasoftware.jdi_ui_tests.implementation.selenium.elements.page_objects.annotations.JDIAction;
import com.ggasoftware.jdi_ui_tests.core.utils.map.MapArray;

/**
 * Created by Roman_Iovlev on 7/28/2015.
 */
public interface ITableLine {
    /** Get Columns/Rows count*/
    @JDIAction
    int count();
    /** Get Columns/Rows headers*/
    @JDIAction
    String[] headers();
    /** Get Columns/Rows in following format <br>
     *  For rows: rowName>columnName>cell <br>
     *  For columns: columnName>rowName>cell <br>
     *  e.g. myTable.columns().get().get("Name").get("5")
     *  or   myTable.columns().get().count()
     *  But better to use specified commands like
     *      cell("Name, "5")
     *      myTable.columns().count()
     *  */
    @JDIAction
    MapArray<String, MapArray<String, ICell>> get();
    @JDIAction
    MapArray<String, MapArray<String, String>> getAsText();
}
