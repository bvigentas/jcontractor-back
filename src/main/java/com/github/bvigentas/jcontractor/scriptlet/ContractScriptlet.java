package com.github.bvigentas.jcontractor.scriptlet;

import net.sf.jasperreports.engine.JRDefaultScriptlet;
import org.w3c.dom.Document;

import javax.xml.xpath.XPath;
import java.util.ArrayList;
import java.util.List;

public class ContractScriptlet extends JRDefaultScriptlet {

    public String boldKeyWords(String text) {
        text = text.replace("contratada", "<b>contratada</b>");
        text = text.replace("contratante", "<b>contratante</b>");

        return text;
    }

}
