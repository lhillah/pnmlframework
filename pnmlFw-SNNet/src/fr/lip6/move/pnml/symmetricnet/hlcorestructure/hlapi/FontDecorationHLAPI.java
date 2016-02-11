
/**
 * (C) Sorbonne Universités, UPMC Univ Paris 06, UMR CNRS 7606 (LIP6)
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *  
 *  Contributors: 
 *    Lom HILLAH (LIP6) - Initial models and implementation
 *    Rachid Alahyane (UPMC) - Infrastructure and continuous integration
 *    Bastien Bouzerau (UPMC) - Architecture 
 *    Guillaume Giffo (UPMC) - Code generation refactoring, High-level API
 *
 * $Id ggiffo, Thu Feb 11 16:29:02 CET 2016$
 */
package fr.lip6.move.pnml.symmetricnet.hlcorestructure.hlapi;
import fr.lip6.move.pnml.symmetricnet.hlcorestructure.FontDecoration;
public enum FontDecorationHLAPI{
	UNDERLINE("underline"),
	OVERLINE("overline"),
	LINETHROUGH("linethrough");

	private final FontDecoration item;

	private FontDecorationHLAPI(String name) {
		this.item = FontDecoration.get(name);
	}
	
	/**
	 * Return one HLAPI enum (used for tests).
	 * @return one of the enum, null if the int is "out of bounds"
	 */
	public static FontDecorationHLAPI get(int num) {
	
      if(num == 0){
         return UNDERLINE;
      }
	
      if(num == 1){
         return OVERLINE;
      }
	
      if(num == 2){
         return LINETHROUGH;
      }
	
		return null;
	}

	public FontDecoration getContainedItem() {
		return item;
	}

	
}