/*
 * Copyright (c) 2002, 2003 Gargoyle Software Inc. All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * 1. Redistributions of source code must retain the above copyright notice,
 *    this list of conditions and the following disclaimer.
 * 2. Redistributions in binary form must reproduce the above copyright notice,
 *    this list of conditions and the following disclaimer in the documentation
 *    and/or other materials provided with the distribution.
 * 3. The end-user documentation included with the redistribution, if any, must
 *    include the following acknowledgment:
 *
 *       "This product includes software developed by Gargoyle Software Inc.
 *        (http://www.GargoyleSoftware.com/)."
 *
 *    Alternately, this acknowledgment may appear in the software itself, if
 *    and wherever such third-party acknowledgments normally appear.
 * 4. The name "Gargoyle Software" must not be used to endorse or promote
 *    products derived from this software without prior written permission.
 *    For written permission, please contact info@GargoyleSoftware.com.
 * 5. Products derived from this software may not be called "HtmlUnit", nor may
 *    "HtmlUnit" appear in their name, without prior written permission of
 *    Gargoyle Software Inc.
 *
 * THIS SOFTWARE IS PROVIDED ``AS IS'' AND ANY EXPRESSED OR IMPLIED WARRANTIES,
 * INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND
 * FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL GARGOYLE
 * SOFTWARE INC. OR ITS CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT,
 * INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT
 * LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA,
 * OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF
 * LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
 * NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE,
 * EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package com.gargoylesoftware.htmlunit.javascript.host;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.gargoylesoftware.htmlunit.WebTestCase;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

/**
 * Tests for NodeImpl
 * 
 * @author yourgod
 * @version $Revision$
 *
 */
public class NodeImplTest extends WebTestCase {

    /**
     * @param name The name of the test case
     */
    public NodeImplTest(String name) {
        super(name);
    }

    /**
     * @throws Exception on test failure
     */
    public void test_hasChildNodes_true() throws Exception {
        final String content = "<html><head><title>test_hasChildNodes</title>"
                + "<script>"
                + "function doTest(){"
                + "    alert(document.getElementById('myNode').hasChildNodes());"
                + "}"
                + "</script>"
                + "</head><body onload='doTest()'>"
                + "<p id='myNode'>hello world<span>Child Node</span></p>"
                + "</body></html>";

        final List collectedAlerts = new ArrayList();
        final HtmlPage page = loadPage(content, collectedAlerts);
        assertEquals("test_hasChildNodes", page.getTitleText());

        final List expectedAlerts = Arrays.asList(new String[]{
            "true"
        });

        assertEquals(expectedAlerts, collectedAlerts);
    }
    /**
     * @throws Exception on test failure
     */
    public void test_hasChildNodes_false() throws Exception {
        final String content = "<html><head><title>test_hasChildNodes</title>"
                + "<script>"
                + "function doTest(){"
                + "    alert(document.getElementById('myNode').hasChildNodes());"
                + "}"
                + "</script>"
                + "</head><body onload='doTest()'>"
                + "<p id='myNode'></p>"
                + "</body></html>";

        final List collectedAlerts = new ArrayList();
        final HtmlPage page = loadPage(content, collectedAlerts);
        assertEquals("test_hasChildNodes", page.getTitleText());

        final List expectedAlerts = Arrays.asList(new String[]{
            "false"
        });

        assertEquals(expectedAlerts, collectedAlerts);
    }    
}