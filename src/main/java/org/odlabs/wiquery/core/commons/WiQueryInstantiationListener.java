/*
 * Copyright (c) 2009 WiQuery team
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
package org.odlabs.wiquery.core.commons;

import java.io.Serializable;

import org.apache.wicket.Component;
import org.apache.wicket.MetaDataKey;
import org.apache.wicket.RequestCycle;
import org.apache.wicket.application.IComponentInstantiationListener;
import org.apache.wicket.behavior.HeaderContributor;

/**
 * $Id: WiQueryInstantiationListener.java 89 2009-06-02 21:42:53Z lionel.armanet
 * $
 * <p>
 * Listens to WiQuery components instantiation and automatically binds a
 * {@link WiQueryCoreHeaderContributor} to these components.
 * </p>
 * <p>
 * The added header contributor will generated the needed JavaScript code and
 * will import all needed resources (e.g. CSS/JavaScript files).
 * </p>
 * 
 * @author Lionel Armanet
 * @since 0.6
 */
public class WiQueryInstantiationListener implements
		IComponentInstantiationListener, Serializable {

	private static final long serialVersionUID = -7398777039788778234L;

	/** meta data for WiQueryCoreHeaderContributor. */
	private static final MetaDataKey<WiQueryCoreHeaderContributor> WIQUERY_KEY = new MetaDataKey<WiQueryCoreHeaderContributor>() {
		private static final long serialVersionUID = 1L;
	};

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.apache.wicket.application.IComponentInstantiationListener#onInstantiation
	 * (org.apache.wicket.Component)
	 */
	public void onInstantiation(final Component component) {
		// theme management
		if (component instanceof IWiQueryPlugin) {
			WiQueryCoreHeaderContributor wickeryHeaderContributor = bindToRequestCycle();
			// binding component as a plugin
			wickeryHeaderContributor.addPlugin((IWiQueryPlugin) component);
			component.add(new HeaderContributor(wickeryHeaderContributor));
		}
	}

	public static WiQueryCoreHeaderContributor bindToRequestCycle() {
		WiQueryCoreHeaderContributor wickeryHeaderContributor = RequestCycle
				.get().getMetaData(WIQUERY_KEY);
		if (wickeryHeaderContributor == null) {
			wickeryHeaderContributor = new WiQueryCoreHeaderContributor();
			RequestCycle.get().setMetaData(WIQUERY_KEY,
					wickeryHeaderContributor);
		}
		return wickeryHeaderContributor;
	}

}
