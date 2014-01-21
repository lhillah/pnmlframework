/**
 * (C) Sorbonne Universités, UPMC Univ Paris 06, UMR CNRS 7606 (LIP6/MoVe)
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
 * $Id ggiffo, Thu Jan 02 00:08:30 CET 2014$
 */
package fr.lip6.move.pnml.pthlpng.hlcorestructure.hlapi;

import fr.lip6.move.pnml.pthlpng.booleans.And;
import fr.lip6.move.pnml.pthlpng.booleans.Bool;
import fr.lip6.move.pnml.pthlpng.booleans.BooleanConstant;
import fr.lip6.move.pnml.pthlpng.booleans.Equality;
import fr.lip6.move.pnml.pthlpng.booleans.Imply;
import fr.lip6.move.pnml.pthlpng.booleans.Inequality;
import fr.lip6.move.pnml.pthlpng.booleans.Not;
import fr.lip6.move.pnml.pthlpng.booleans.Or;

import fr.lip6.move.pnml.pthlpng.booleans.impl.BooleansFactoryImpl;

import fr.lip6.move.pnml.pthlpng.dots.Dot;
import fr.lip6.move.pnml.pthlpng.dots.DotConstant;

import fr.lip6.move.pnml.pthlpng.dots.impl.DotsFactoryImpl;

import fr.lip6.move.pnml.pthlpng.hlcorestructure.Condition;
import fr.lip6.move.pnml.pthlpng.hlcorestructure.Declaration;
import fr.lip6.move.pnml.pthlpng.hlcorestructure.HLAnnotation;
import fr.lip6.move.pnml.pthlpng.hlcorestructure.HLMarking;
import fr.lip6.move.pnml.pthlpng.hlcorestructure.Name;
import fr.lip6.move.pnml.pthlpng.hlcorestructure.PNType;
import fr.lip6.move.pnml.pthlpng.hlcorestructure.Page;
import fr.lip6.move.pnml.pthlpng.hlcorestructure.PetriNet;
import fr.lip6.move.pnml.pthlpng.hlcorestructure.PetriNetDoc;
import fr.lip6.move.pnml.pthlpng.hlcorestructure.ToolInfo;
import fr.lip6.move.pnml.pthlpng.hlcorestructure.Type;

import fr.lip6.move.pnml.pthlpng.hlcorestructure.impl.HlcorestructureFactoryImpl;

import fr.lip6.move.pnml.pthlpng.multisets.All;
import fr.lip6.move.pnml.pthlpng.multisets.Empty;

import fr.lip6.move.pnml.pthlpng.multisets.impl.MultisetsFactoryImpl;

import fr.lip6.move.pnml.pthlpng.partitions.Partition;
import fr.lip6.move.pnml.pthlpng.partitions.PartitionElement;

import fr.lip6.move.pnml.pthlpng.partitions.impl.PartitionsFactoryImpl;

import fr.lip6.move.pnml.pthlpng.terms.MultisetSort;
import fr.lip6.move.pnml.pthlpng.terms.NamedOperator;
import fr.lip6.move.pnml.pthlpng.terms.NamedSort;
import fr.lip6.move.pnml.pthlpng.terms.Operator;
import fr.lip6.move.pnml.pthlpng.terms.ProductSort;
import fr.lip6.move.pnml.pthlpng.terms.Sort;
import fr.lip6.move.pnml.pthlpng.terms.Term;
import fr.lip6.move.pnml.pthlpng.terms.VariableDecl;

import fr.lip6.move.pnml.pthlpng.terms.impl.TermsFactoryImpl;

import java.util.List;

import  fr.lip6.move.pnml.framework.hlapi.*;
import fr.lip6.move.pnml.pthlpng.booleans.hlapi.*;
import fr.lip6.move.pnml.pthlpng.dots.hlapi.*;
import fr.lip6.move.pnml.pthlpng.hlcorestructure.hlapi.*;
import fr.lip6.move.pnml.pthlpng.multisets.hlapi.*;
import fr.lip6.move.pnml.pthlpng.partitions.hlapi.*;
import fr.lip6.move.pnml.pthlpng.terms.hlapi.*;

import java.util.ArrayList;
import java.util.List;
import org.apache.axiom.om.*;
import fr.lip6.move.pnml.framework.utils.IdRefLinker;
import org.eclipse.emf.common.util.DiagnosticChain;
import fr.lip6.move.pnml.pthlpng.hlcorestructure.*;
import fr.lip6.move.pnml.pthlpng.hlcorestructure.impl.*;
import fr.lip6.move.pnml.framework.utils.exception.InnerBuildException;
import fr.lip6.move.pnml.framework.utils.exception.InvalidIDException;
import fr.lip6.move.pnml.framework.utils.exception.VoidRepositoryException;
import fr.lip6.move.pnml.framework.utils.IdRepository;
import fr.lip6.move.pnml.framework.utils.ModelRepository;
import org.testng.annotations.*;
public class PetriNetHLAPITest {

	
	private String itemid;
		
	private PNTypeHLAPI itemtype;
		
	private NameHLAPI itemname;
		
	
	private PetriNetDocHLAPI itemcontainerPetriNetDoc;
	


	@AfterTest(groups = { "PetriNetHLAPI", "hlapi" })
	public void After() {
	    System.out.println("done for "+"PetriNetHLAPI(hlcorestructure)");
	}


	@BeforeMethod(groups = { "PetriNetHLAPI", "hlapi" })
	public void setup() throws Exception{
	//ModelRepository.reset(); ModelRepository.getInstance().createDocumentWorkspace("void");
	ModelRepository mr = ModelRepository.getInstance();
	mr.createDocumentWorkspace("void");
	
			itemid = new String("unid");
			
		itemtype = PNTypeHLAPI.get(0);
		
			
			//HlcorestructureFactoryImpl
			itemname = new NameHLAPI(new HlcorestructureFactoryImpl().createName());
			
		

	
		
		itemcontainerPetriNetDoc = new PetriNetDocHLAPI(new HlcorestructureFactoryImpl().createPetriNetDoc());
		
	
	}

	/**
	 * this constructor allows you to set all 'settable' values
	 * excepted container.
	 */
	@Test(groups = { "hlapi", "PetriNetHLAPI"}, dependsOnMethods={"PetriNetHLAPI_LLAPI"})
	public void PetriNetHLAPI_1() throws InvalidIDException ,VoidRepositoryException   {//BEGIN CONSTRUCTOR BODY
   @SuppressWarnings("unused")
	PetriNetHLAPI totest = new PetriNetHLAPI(
		itemid
		,	
		itemtype
		,	
		itemname
	);
	
	
	assert totest.getId().equals(itemid);
	
	
	
	
	
	
	assert totest.getName().equals(itemname.getContainedItem());
	
	
	}

	/**
	 * this constructor allows you to set all 'settable' values, including container if any.
	 */
	@Test(groups = { "hlapi", "PetriNetHLAPI"}, dependsOnMethods={"PetriNetHLAPI_LLAPI"})
	public void PetriNetHLAPI_2_containerPetriNetDoc() throws InvalidIDException ,VoidRepositoryException   {//BEGIN CONSTRUCTOR BODY

	PetriNetHLAPI totest = new PetriNetHLAPI(
		itemid
		,	
		itemtype
		,	
		itemname
	,	
		itemcontainerPetriNetDoc
	);
	
	
			assert totest.getId().equals(itemid);
		
	
	
		
	
		
			assert totest.getName().equals(itemname.getContainedItem());
		
	
	assert totest.getContainerPetriNetDoc().equals(itemcontainerPetriNetDoc.getContainedItem());
	}

	/**
    * This constructor give access to required stuff only (not container if any)
    */
   @Test(groups = { "hlapi", "PetriNetHLAPI"}, dependsOnMethods={"PetriNetHLAPI_LLAPI"})
	public void PetriNetHLAPI_3() throws InvalidIDException ,VoidRepositoryException   {//BEGIN CONSTRUCTOR BODY

	PetriNetHLAPI totest = new PetriNetHLAPI(
		itemid
		,	
		itemtype
	);

	
	
			assert totest.getId().equals(itemid);
		
	
	
		
	}

	/**
    * This constructor give access to required stuff only (and container)
    */
   @Test(groups = { "hlapi", "PetriNetHLAPI"}, dependsOnMethods={"PetriNetHLAPI_LLAPI"})
	public void PetriNetHLAPI_4_containerPetriNetDoc() throws InvalidIDException ,VoidRepositoryException   {//BEGIN CONSTRUCTOR BODY

	PetriNetHLAPI totest = new PetriNetHLAPI(
		itemid
		,	
		itemtype
	,	
	  itemcontainerPetriNetDoc
	);

	
	
			assert totest.getId().equals(itemid);
		
	
	
		
	assert totest.getContainerPetriNetDoc().equals(itemcontainerPetriNetDoc.getContainedItem());
	}


	/**
	 * This constructor encapsulate a low level API object in HLAPI.
	 */
	@Test(groups = { "hlapi", "PetriNetHLAPI"})
	public void PetriNetHLAPI_LLAPI(){
	   PetriNet llapi = new HlcorestructureFactoryImpl().createPetriNet();
	   fr.lip6.move.pnml.pthlpng.hlcorestructure.hlapi.PetriNetHLAPI hlapi = new PetriNetHLAPI(llapi);
		assert hlapi.getContainedItem().equals(llapi);
	}

	//getters giving HLAPI object
	
	
	

	
		/**
		 * This test add a random number of desired objet in the list or of one of each existing subtypes.
		 * then test how many objet are retuned and if any exist inthe original list.
		 */
		@Test(groups = { "hlapi", "PetriNetHLAPI"})
		public void getPagesHLAPITest(){
			PetriNet llapi = new HlcorestructureFactoryImpl().createPetriNet();
			int howmany;
			
			howmany = (int)(Math.random()*10);
			for(int i =0; i<howmany;i++)
			llapi.getPages().add(new HlcorestructureFactoryImpl().createPage());
			

			PetriNetHLAPI elem = new PetriNetHLAPI(llapi);
			List<PageHLAPI> totest = elem.getPagesHLAPI();

			assert totest.size() == howmany;

			for (PageHLAPI unit : totest) {
             assert llapi.getPages().contains(unit.getContainedItem()) : "missing element";
         }
		}
	
	

	
		
		/**
		 * This accessor automatically encapsulate an element of the current object.
		 * WARNING : this creates a new object in memory.
		 * @return : null if the element is null
		 */
		@Test(groups = { "hlapi", "PetriNetHLAPI"})
		public void getNameHLAPITest(){
			PetriNetHLAPI elem = new PetriNetHLAPI(new HlcorestructureFactoryImpl().createPetriNet());

			
				elem.setNameHLAPI(itemname);
				NameHLAPI totest = elem.getNameHLAPI();
				assert totest.getContainedItem().equals(elem.getName());
			
		}
	
	

	
		/**
		 * This test add a random number of desired objet in the list or of one of each existing subtypes.
		 * then test how many objet are retuned and if any exist inthe original list.
		 */
		@Test(groups = { "hlapi", "PetriNetHLAPI"})
		public void getToolspecificsHLAPITest(){
			PetriNet llapi = new HlcorestructureFactoryImpl().createPetriNet();
			int howmany;
			
			howmany = (int)(Math.random()*10);
			for(int i =0; i<howmany;i++)
			llapi.getToolspecifics().add(new HlcorestructureFactoryImpl().createToolInfo());
			

			PetriNetHLAPI elem = new PetriNetHLAPI(llapi);
			List<ToolInfoHLAPI> totest = elem.getToolspecificsHLAPI();

			assert totest.size() == howmany;

			for (ToolInfoHLAPI unit : totest) {
             assert llapi.getToolspecifics().contains(unit.getContainedItem()) : "missing element";
         }
		}
	
	

	
		
		/**
		 * This accessor automatically encapsulate an element of the current object.
		 * WARNING : this creates a new object in memory.
		 * @return : null if the element is null
		 */
		@Test(groups = { "hlapi", "PetriNetHLAPI"})
		public void getContainerPetriNetDocHLAPITest(){
			PetriNetHLAPI elem = new PetriNetHLAPI(new HlcorestructureFactoryImpl().createPetriNet());

			
				elem.setContainerPetriNetDocHLAPI(itemcontainerPetriNetDoc);
				PetriNetDocHLAPI totest = elem.getContainerPetriNetDocHLAPI();
				assert totest.getContainedItem().equals(elem.getContainerPetriNetDoc());
			
		}
	
	

	
		/**
		 * This test add a random number of desired objet in the list or of one of each existing subtypes.
		 * then test how many objet are retuned and if any exist inthe original list.
		 */
		@Test(groups = { "hlapi", "PetriNetHLAPI"})
		public void getDeclarationHLAPITest(){
			PetriNet llapi = new HlcorestructureFactoryImpl().createPetriNet();
			int howmany;
			
			howmany = (int)(Math.random()*10);
			for(int i =0; i<howmany;i++)
			llapi.getDeclaration().add(new HlcorestructureFactoryImpl().createDeclaration());
			

			PetriNetHLAPI elem = new PetriNetHLAPI(llapi);
			List<DeclarationHLAPI> totest = elem.getDeclarationHLAPI();

			assert totest.size() == howmany;

			for (DeclarationHLAPI unit : totest) {
             assert llapi.getDeclaration().contains(unit.getContainedItem()) : "missing element";
         }
		}
	

	//Special getter for list of generics object, return only one object type.
	
	
	
	
	
	

	//setters/remover for lists.
	
	@Test(groups = { "hlapi", "PetriNetHLAPI"})
	public void addPagesHLAPITest(){
		PetriNetHLAPI elem = new PetriNetHLAPI(new HlcorestructureFactoryImpl().createPetriNet());
		int howmany = (int)(Math.random()*10);
		for(int i =0; i<howmany;i++)
			
			elem.addPagesHLAPI(new PageHLAPI(new HlcorestructureFactoryImpl().createPage()));
			

		assert elem.getContainedItem().getPages().size() == howmany;
	}

	@Test(groups = { "hlapi", "PetriNetHLAPI"})
	public void removePagesTest(){
		PetriNetHLAPI elem = new PetriNetHLAPI(new HlcorestructureFactoryImpl().createPetriNet());
		int howmany = (int)(Math.random()*10);
		int howdiff = (int)(Math.random()*10);

			
			PageHLAPI sav;

		for(int i =0; i<(howmany);i++)
			
			elem.addPagesHLAPI(new PageHLAPI(new HlcorestructureFactoryImpl().createPage()));
			


		
		sav = new PageHLAPI(new HlcorestructureFactoryImpl().createPage());
		

		elem.addPagesHLAPI(sav);
		assert elem.getContainedItem().getPages().size() == howmany+1;

		for(int i =0; i<(howdiff);i++)
			
			elem.addPagesHLAPI(new PageHLAPI(new HlcorestructureFactoryImpl().createPage()));
			


		elem.removePagesHLAPI(sav);

		assert elem.getContainedItem().getPages().size() == howmany+howdiff;
	}
	
	@Test(groups = { "hlapi", "PetriNetHLAPI"})
	public void addToolspecificsHLAPITest(){
		PetriNetHLAPI elem = new PetriNetHLAPI(new HlcorestructureFactoryImpl().createPetriNet());
		int howmany = (int)(Math.random()*10);
		for(int i =0; i<howmany;i++)
			
			elem.addToolspecificsHLAPI(new ToolInfoHLAPI(new HlcorestructureFactoryImpl().createToolInfo()));
			

		assert elem.getContainedItem().getToolspecifics().size() == howmany;
	}

	@Test(groups = { "hlapi", "PetriNetHLAPI"})
	public void removeToolspecificsTest(){
		PetriNetHLAPI elem = new PetriNetHLAPI(new HlcorestructureFactoryImpl().createPetriNet());
		int howmany = (int)(Math.random()*10);
		int howdiff = (int)(Math.random()*10);

			
			ToolInfoHLAPI sav;

		for(int i =0; i<(howmany);i++)
			
			elem.addToolspecificsHLAPI(new ToolInfoHLAPI(new HlcorestructureFactoryImpl().createToolInfo()));
			


		
		sav = new ToolInfoHLAPI(new HlcorestructureFactoryImpl().createToolInfo());
		

		elem.addToolspecificsHLAPI(sav);
		assert elem.getContainedItem().getToolspecifics().size() == howmany+1;

		for(int i =0; i<(howdiff);i++)
			
			elem.addToolspecificsHLAPI(new ToolInfoHLAPI(new HlcorestructureFactoryImpl().createToolInfo()));
			


		elem.removeToolspecificsHLAPI(sav);

		assert elem.getContainedItem().getToolspecifics().size() == howmany+howdiff;
	}
	
	@Test(groups = { "hlapi", "PetriNetHLAPI"})
	public void addDeclarationHLAPITest(){
		PetriNetHLAPI elem = new PetriNetHLAPI(new HlcorestructureFactoryImpl().createPetriNet());
		int howmany = (int)(Math.random()*10);
		for(int i =0; i<howmany;i++)
			
			elem.addDeclarationHLAPI(new DeclarationHLAPI(new HlcorestructureFactoryImpl().createDeclaration()));
			

		assert elem.getContainedItem().getDeclaration().size() == howmany;
	}

	@Test(groups = { "hlapi", "PetriNetHLAPI"})
	public void removeDeclarationTest(){
		PetriNetHLAPI elem = new PetriNetHLAPI(new HlcorestructureFactoryImpl().createPetriNet());
		int howmany = (int)(Math.random()*10);
		int howdiff = (int)(Math.random()*10);

			
			DeclarationHLAPI sav;

		for(int i =0; i<(howmany);i++)
			
			elem.addDeclarationHLAPI(new DeclarationHLAPI(new HlcorestructureFactoryImpl().createDeclaration()));
			


		
		sav = new DeclarationHLAPI(new HlcorestructureFactoryImpl().createDeclaration());
		

		elem.addDeclarationHLAPI(sav);
		assert elem.getContainedItem().getDeclaration().size() == howmany+1;

		for(int i =0; i<(howdiff);i++)
			
			elem.addDeclarationHLAPI(new DeclarationHLAPI(new HlcorestructureFactoryImpl().createDeclaration()));
			


		elem.removeDeclarationHLAPI(sav);

		assert elem.getContainedItem().getDeclaration().size() == howmany+howdiff;
	}
	

	@Test(groups = { "hlapi", "PetriNetHLAPI"})
	public void equalsTest(){
		PetriNet a = new HlcorestructureFactoryImpl().createPetriNet();
		PetriNet b = new HlcorestructureFactoryImpl().createPetriNet();
		PetriNetHLAPI aprime = new PetriNetHLAPI(a);
		PetriNetHLAPI asecond = new PetriNetHLAPI(a);
		PetriNetHLAPI bprime = new PetriNetHLAPI(b);

		assert aprime.equals(asecond);
		assert !aprime.equals(bprime);
	}

	//cloning method
	//public PetriNetHLAPI clone(){
	//	return new PetriNetHLAPI(this);
	//}

	//PNML
	
	/**
	 * return the PNML xml tree for this object.
	 */
	//public String toPNML(){
		//return item.toPNML();
	//}

	/**
	 * creates an object from the xml nodes.(symetric work of toPNML)
	 */
	//public void fromPNML(OMElement subRoot,IdRefLinker idr) throws InnerBuildException, InvalidIDException, VoidRepositoryException{
		//item.fromPNML(subRoot,idr);
	//}
	
}