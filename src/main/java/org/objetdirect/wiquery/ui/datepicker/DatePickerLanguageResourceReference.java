/*
 * Copyright (c) 2008 Objet Direct
 * 
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * 
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package org.objetdirect.wiquery.ui.datepicker;

import java.util.Locale;

import org.apache.wicket.markup.html.resources.JavascriptResourceReference;

/**
 * $Id$
 * <p>
 * Provides a JavaScript reference to display the date picker labels for a given
 * local.
 * </p>
 * 
 * @author Lionel Armanet
 * @since 0.6
 */
public class DatePickerLanguageResourceReference extends
		JavascriptResourceReference {

	private static final long serialVersionUID = 5955164494361831059L;

	public DatePickerLanguageResourceReference(Locale locale) {

		super(DatePickerLanguageResourceReference.class, "i18n/ui.datepicker-"
				+ locale.getLanguage() + ".js");
	}

}
