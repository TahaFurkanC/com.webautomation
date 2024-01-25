package autoCompleteTest;

import baseTest.Hooks;
import org.junit.jupiter.api.Test;
import utils.BrowserUtils;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AccentFoldingTest extends Hooks {
    @Test
    public void accentFoldingTest(){
        pages.getHomePage().clickOnWebAutomationLink();

        pages.getWebAutomationPage().clickOnAutocompleteLink();

        pages.getWebAutomationPage().clickOnAccentFoldingLink();

        pages.getAccentFolding().sendKeysToInputSection("jo");

        List<String> names = pages.getAccentFolding().getElementList();

        assertTrue(names.get(0).startsWith("Jörn"));
        assertTrue(names.get(1).startsWith("John"));

        pages.getAccentFolding().cleanInput();

        pages.getAccentFolding().sendKeysToInputSection("jö");
        BrowserUtils.wait(1);
        names = pages.getAccentFolding().getElementList();

        assertEquals(1,names.size(),"There should be only one name");
        assertTrue(names.get(0).startsWith("Jörn"),"The name must start with Jörn");

    }
}
