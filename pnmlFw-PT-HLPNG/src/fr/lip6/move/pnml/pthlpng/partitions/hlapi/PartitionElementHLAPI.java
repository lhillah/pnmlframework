/**
 *  Copyright 2009-2015 Université Paris Ouest and Sorbonne Universités,
 * 							Univ. Paris 06 - CNRS UMR 7606 (LIP6)
 *
 *  All rights reserved.   This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 *
 *  Project leader / Initial Contributor:
 *    Lom Messan Hillah - <lom-messan.hillah@lip6.fr>
 *
 *  Contributors:
 *    ${ocontributors} - <$oemails}>
 *
 *  Mailing list:
 *    lom-messan.hillah@lip6.fr
 */
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
 * $Id ggiffo, Tue Dec 23 11:30:49 CET 2014$
 */
package fr.lip6.move.pnml.pthlpng.partitions.hlapi;

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

import fr.lip6.move.pnml.pthlpng.hlcorestructure.Annotation;
import fr.lip6.move.pnml.pthlpng.hlcorestructure.AnnotationGraphics;
import fr.lip6.move.pnml.pthlpng.hlcorestructure.AnyObject;
import fr.lip6.move.pnml.pthlpng.hlcorestructure.Arc;
import fr.lip6.move.pnml.pthlpng.hlcorestructure.ArcGraphics;
import fr.lip6.move.pnml.pthlpng.hlcorestructure.CSS2Color;
import fr.lip6.move.pnml.pthlpng.hlcorestructure.CSS2FontFamily;
import fr.lip6.move.pnml.pthlpng.hlcorestructure.CSS2FontSize;
import fr.lip6.move.pnml.pthlpng.hlcorestructure.CSS2FontStyle;
import fr.lip6.move.pnml.pthlpng.hlcorestructure.CSS2FontWeight;
import fr.lip6.move.pnml.pthlpng.hlcorestructure.Condition;
import fr.lip6.move.pnml.pthlpng.hlcorestructure.Declaration;
import fr.lip6.move.pnml.pthlpng.hlcorestructure.Dimension;
import fr.lip6.move.pnml.pthlpng.hlcorestructure.Fill;
import fr.lip6.move.pnml.pthlpng.hlcorestructure.Font;
import fr.lip6.move.pnml.pthlpng.hlcorestructure.FontAlign;
import fr.lip6.move.pnml.pthlpng.hlcorestructure.FontDecoration;
import fr.lip6.move.pnml.pthlpng.hlcorestructure.Gradient;
import fr.lip6.move.pnml.pthlpng.hlcorestructure.HLAnnotation;
import fr.lip6.move.pnml.pthlpng.hlcorestructure.HLMarking;
import fr.lip6.move.pnml.pthlpng.hlcorestructure.Label;
import fr.lip6.move.pnml.pthlpng.hlcorestructure.Line;
import fr.lip6.move.pnml.pthlpng.hlcorestructure.LineShape;
import fr.lip6.move.pnml.pthlpng.hlcorestructure.LineStyle;
import fr.lip6.move.pnml.pthlpng.hlcorestructure.Name;
import fr.lip6.move.pnml.pthlpng.hlcorestructure.Node;
import fr.lip6.move.pnml.pthlpng.hlcorestructure.NodeGraphics;
import fr.lip6.move.pnml.pthlpng.hlcorestructure.Offset;
import fr.lip6.move.pnml.pthlpng.hlcorestructure.PNType;
import fr.lip6.move.pnml.pthlpng.hlcorestructure.Page;
import fr.lip6.move.pnml.pthlpng.hlcorestructure.PetriNet;
import fr.lip6.move.pnml.pthlpng.hlcorestructure.PetriNetDoc;
import fr.lip6.move.pnml.pthlpng.hlcorestructure.Place;
import fr.lip6.move.pnml.pthlpng.hlcorestructure.PlaceNode;
import fr.lip6.move.pnml.pthlpng.hlcorestructure.PnObject;
import fr.lip6.move.pnml.pthlpng.hlcorestructure.Position;
import fr.lip6.move.pnml.pthlpng.hlcorestructure.RefPlace;
import fr.lip6.move.pnml.pthlpng.hlcorestructure.RefTransition;
import fr.lip6.move.pnml.pthlpng.hlcorestructure.ToolInfo;
import fr.lip6.move.pnml.pthlpng.hlcorestructure.Transition;
import fr.lip6.move.pnml.pthlpng.hlcorestructure.TransitionNode;
import fr.lip6.move.pnml.pthlpng.hlcorestructure.Type;

import fr.lip6.move.pnml.pthlpng.hlcorestructure.impl.HlcorestructureFactoryImpl;

import fr.lip6.move.pnml.pthlpng.multisets.Add;
import fr.lip6.move.pnml.pthlpng.multisets.All;
import fr.lip6.move.pnml.pthlpng.multisets.Cardinality;
import fr.lip6.move.pnml.pthlpng.multisets.CardinalityOf;
import fr.lip6.move.pnml.pthlpng.multisets.Contains;
import fr.lip6.move.pnml.pthlpng.multisets.Empty;
import fr.lip6.move.pnml.pthlpng.multisets.NumberOf;
import fr.lip6.move.pnml.pthlpng.multisets.ScalarProduct;
import fr.lip6.move.pnml.pthlpng.multisets.Subtract;

import fr.lip6.move.pnml.pthlpng.multisets.impl.MultisetsFactoryImpl;

import fr.lip6.move.pnml.pthlpng.partitions.Partition;
import fr.lip6.move.pnml.pthlpng.partitions.PartitionElement;

import fr.lip6.move.pnml.pthlpng.partitions.impl.PartitionsFactoryImpl;

import fr.lip6.move.pnml.pthlpng.terms.Declarations;
import fr.lip6.move.pnml.pthlpng.terms.MultisetSort;
import fr.lip6.move.pnml.pthlpng.terms.NamedOperator;
import fr.lip6.move.pnml.pthlpng.terms.NamedSort;
import fr.lip6.move.pnml.pthlpng.terms.Operator;
import fr.lip6.move.pnml.pthlpng.terms.ProductSort;
import fr.lip6.move.pnml.pthlpng.terms.Sort;
import fr.lip6.move.pnml.pthlpng.terms.Term;
import fr.lip6.move.pnml.pthlpng.terms.VariableDecl;

import fr.lip6.move.pnml.pthlpng.terms.impl.TermsFactoryImpl;

import java.math.BigDecimal;

import java.net.URI;

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
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import org.apache.axiom.om.*;
import fr.lip6.move.pnml.framework.utils.IdRefLinker;
import org.eclipse.emf.common.util.DiagnosticChain;
import fr.lip6.move.pnml.pthlpng.partitions.*;
import fr.lip6.move.pnml.pthlpng.partitions.impl.*;
import fr.lip6.move.pnml.framework.utils.exception.InnerBuildException;
import fr.lip6.move.pnml.framework.utils.exception.InvalidIDException;
import fr.lip6.move.pnml.framework.utils.exception.VoidRepositoryException;
import fr.lip6.move.pnml.framework.utils.exception.OtherException;
import fr.lip6.move.pnml.framework.utils.IdRepository;
import fr.lip6.move.pnml.framework.utils.ModelRepository;


public class PartitionElementHLAPI implements HLAPIClass,TermsDeclarationHLAPI,OperatorDeclHLAPI{

	/**
	 * The contained LLAPI element.
	 */
	private PartitionElement item;

	/**
	 * this constructor allows you to set all 'settable' values
	 * excepted container.
	 */
	
	public PartitionElementHLAPI(
		 java.lang.String id
	
		, java.lang.String name
	) throws InvalidIDException ,VoidRepositoryException {//BEGIN CONSTRUCTOR BODY
		PartitionsFactory fact = PartitionsFactoryImpl.eINSTANCE;
		synchronized(fact){item = fact.createPartitionElement();}
	
 		
			if(id!=null){
			
				item.setId(ModelRepository.getInstance().getCurrentIdRepository().checkId(id, this));
			}
		
	
 		
			if(name!=null){
			
				item.setName(name);
			}
		
	
	}

	/**
	 * this constructor allows you to set all 'settable' values, including container if any.
	 */
	
	public PartitionElementHLAPI(
		 java.lang.String id
	
		, java.lang.String name
	
		, DeclarationsHLAPI containerDeclarations
	) throws InvalidIDException ,VoidRepositoryException {//BEGIN CONSTRUCTOR BODY
		PartitionsFactory fact = PartitionsFactoryImpl.eINSTANCE;
		synchronized(fact){item = fact.createPartitionElement();}
	
 		
			if(id!=null){
			
				item.setId(ModelRepository.getInstance().getCurrentIdRepository().checkId(id, this));
			}
		
	
 		
			if(name!=null){
			
				item.setName(name);
			}
		
	
 		
 		if(containerDeclarations!=null)
			item.setContainerDeclarations((Declarations)containerDeclarations.getContainedItem());
		
	
	}

	/**
	 * this constructor allows you to set all 'settable' values, including container if any.
	 */
	
	public PartitionElementHLAPI(
		 java.lang.String id
	
		, java.lang.String name
	
		, PartitionHLAPI refpartition
	) throws InvalidIDException ,VoidRepositoryException {//BEGIN CONSTRUCTOR BODY
		PartitionsFactory fact = PartitionsFactoryImpl.eINSTANCE;
		synchronized(fact){item = fact.createPartitionElement();}
	
 		
			if(id!=null){
			
				item.setId(ModelRepository.getInstance().getCurrentIdRepository().checkId(id, this));
			}
		
	
 		
			if(name!=null){
			
				item.setName(name);
			}
		
	
 		
 		if(refpartition!=null)
			item.setRefpartition((Partition)refpartition.getContainedItem());
		
	
	}



	
	

	/**
	 * This constructor encapsulate a low level API object in HLAPI.
	 */
	public PartitionElementHLAPI(PartitionElement lowLevelAPI){
		item = lowLevelAPI;
	}

	// access to low level API
	/**
	 * Return encapsulated object
	 */
	public PartitionElement getContainedItem(){
		return item;
	}

	//getters giving LLAPI object
	
	/**
	 * Return the encapsulate Low Level API object.
	 */
	public String getId(){
		return item.getId();
	}
	
	/**
	 * Return the encapsulate Low Level API object.
	 */
	public String getName(){
		return item.getName();
	}
	
	/**
	 * Return the encapsulate Low Level API object.
	 */
	public Declarations getContainerDeclarations(){
		return item.getContainerDeclarations();
	}
	
	/**
	 * Return the encapsulate Low Level API object.
	 */
	public Partition getRefpartition(){
		return item.getRefpartition();
	}
	
	/**
	 * Return the encapsulate Low Level API object.
	 */
	public List<Term> getPartitionelementconstants(){
		return item.getPartitionelementconstants();
	}
	

	//getters giving HLAPI object
	
	
	
	
	
		/**
		 * This accessor automatically encapsulate an element of the current object.
		 * WARNING : this creates a new object in memory.
		 * @return : null if the element is null
		 */
		
		public DeclarationsHLAPI getContainerDeclarationsHLAPI(){
			if(item.getContainerDeclarations() == null) return null;
			return new DeclarationsHLAPI(item.getContainerDeclarations());
		}
		
	
	
	
	
		/**
		 * This accessor automatically encapsulate an element of the current object.
		 * WARNING : this creates a new object in memory.
		 * @return : null if the element is null
		 */
		
		public PartitionHLAPI getRefpartitionHLAPI(){
			if(item.getRefpartition() == null) return null;
			return new PartitionHLAPI(item.getRefpartition());
		}
		
	
	
	
	
		/**
		 * This accessor automatically encapsulate all elements of the selected sublist.
		 * WARNING : this can creates a lot of new object in memory.
		 */
		
			
		public java.util.List<TermHLAPI> getPartitionelementconstantsHLAPI(){
			java.util.List<TermHLAPI> retour = new ArrayList<TermHLAPI>();
			for (Term elemnt : getPartitionelementconstants()) {
				
				if(elemnt.getClass().equals(fr.lip6.move.pnml.pthlpng.partitions.impl.GreaterThanImpl.class)){
					retour.add(new fr.lip6.move.pnml.pthlpng.partitions.hlapi.GreaterThanHLAPI(
						(fr.lip6.move.pnml.pthlpng.partitions.GreaterThan)elemnt
						));
					continue;
				}
				
				if(elemnt.getClass().equals(fr.lip6.move.pnml.pthlpng.partitions.impl.PartitionElementOfImpl.class)){
					retour.add(new fr.lip6.move.pnml.pthlpng.partitions.hlapi.PartitionElementOfHLAPI(
						(fr.lip6.move.pnml.pthlpng.partitions.PartitionElementOf)elemnt
						));
					continue;
				}
				
				if(elemnt.getClass().equals(fr.lip6.move.pnml.pthlpng.partitions.impl.LessThanImpl.class)){
					retour.add(new fr.lip6.move.pnml.pthlpng.partitions.hlapi.LessThanHLAPI(
						(fr.lip6.move.pnml.pthlpng.partitions.LessThan)elemnt
						));
					continue;
				}
				
				if(elemnt.getClass().equals(fr.lip6.move.pnml.pthlpng.booleans.impl.EqualityImpl.class)){
					retour.add(new fr.lip6.move.pnml.pthlpng.booleans.hlapi.EqualityHLAPI(
						(fr.lip6.move.pnml.pthlpng.booleans.Equality)elemnt
						));
					continue;
				}
				
				if(elemnt.getClass().equals(fr.lip6.move.pnml.pthlpng.booleans.impl.InequalityImpl.class)){
					retour.add(new fr.lip6.move.pnml.pthlpng.booleans.hlapi.InequalityHLAPI(
						(fr.lip6.move.pnml.pthlpng.booleans.Inequality)elemnt
						));
					continue;
				}
				
				if(elemnt.getClass().equals(fr.lip6.move.pnml.pthlpng.booleans.impl.BooleanConstantImpl.class)){
					retour.add(new fr.lip6.move.pnml.pthlpng.booleans.hlapi.BooleanConstantHLAPI(
						(fr.lip6.move.pnml.pthlpng.booleans.BooleanConstant)elemnt
						));
					continue;
				}
				
				if(elemnt.getClass().equals(fr.lip6.move.pnml.pthlpng.booleans.impl.OrImpl.class)){
					retour.add(new fr.lip6.move.pnml.pthlpng.booleans.hlapi.OrHLAPI(
						(fr.lip6.move.pnml.pthlpng.booleans.Or)elemnt
						));
					continue;
				}
				
				if(elemnt.getClass().equals(fr.lip6.move.pnml.pthlpng.booleans.impl.AndImpl.class)){
					retour.add(new fr.lip6.move.pnml.pthlpng.booleans.hlapi.AndHLAPI(
						(fr.lip6.move.pnml.pthlpng.booleans.And)elemnt
						));
					continue;
				}
				
				if(elemnt.getClass().equals(fr.lip6.move.pnml.pthlpng.booleans.impl.ImplyImpl.class)){
					retour.add(new fr.lip6.move.pnml.pthlpng.booleans.hlapi.ImplyHLAPI(
						(fr.lip6.move.pnml.pthlpng.booleans.Imply)elemnt
						));
					continue;
				}
				
				if(elemnt.getClass().equals(fr.lip6.move.pnml.pthlpng.booleans.impl.NotImpl.class)){
					retour.add(new fr.lip6.move.pnml.pthlpng.booleans.hlapi.NotHLAPI(
						(fr.lip6.move.pnml.pthlpng.booleans.Not)elemnt
						));
					continue;
				}
				
				if(elemnt.getClass().equals(fr.lip6.move.pnml.pthlpng.dots.impl.DotConstantImpl.class)){
					retour.add(new fr.lip6.move.pnml.pthlpng.dots.hlapi.DotConstantHLAPI(
						(fr.lip6.move.pnml.pthlpng.dots.DotConstant)elemnt
						));
					continue;
				}
				
				if(elemnt.getClass().equals(fr.lip6.move.pnml.pthlpng.multisets.impl.CardinalityImpl.class)){
					retour.add(new fr.lip6.move.pnml.pthlpng.multisets.hlapi.CardinalityHLAPI(
						(fr.lip6.move.pnml.pthlpng.multisets.Cardinality)elemnt
						));
					continue;
				}
				
				if(elemnt.getClass().equals(fr.lip6.move.pnml.pthlpng.multisets.impl.ContainsImpl.class)){
					retour.add(new fr.lip6.move.pnml.pthlpng.multisets.hlapi.ContainsHLAPI(
						(fr.lip6.move.pnml.pthlpng.multisets.Contains)elemnt
						));
					continue;
				}
				
				if(elemnt.getClass().equals(fr.lip6.move.pnml.pthlpng.multisets.impl.CardinalityOfImpl.class)){
					retour.add(new fr.lip6.move.pnml.pthlpng.multisets.hlapi.CardinalityOfHLAPI(
						(fr.lip6.move.pnml.pthlpng.multisets.CardinalityOf)elemnt
						));
					continue;
				}
				
				if(elemnt.getClass().equals(fr.lip6.move.pnml.pthlpng.multisets.impl.AddImpl.class)){
					retour.add(new fr.lip6.move.pnml.pthlpng.multisets.hlapi.AddHLAPI(
						(fr.lip6.move.pnml.pthlpng.multisets.Add)elemnt
						));
					continue;
				}
				
				if(elemnt.getClass().equals(fr.lip6.move.pnml.pthlpng.multisets.impl.AllImpl.class)){
					retour.add(new fr.lip6.move.pnml.pthlpng.multisets.hlapi.AllHLAPI(
						(fr.lip6.move.pnml.pthlpng.multisets.All)elemnt
						));
					continue;
				}
				
				if(elemnt.getClass().equals(fr.lip6.move.pnml.pthlpng.multisets.impl.EmptyImpl.class)){
					retour.add(new fr.lip6.move.pnml.pthlpng.multisets.hlapi.EmptyHLAPI(
						(fr.lip6.move.pnml.pthlpng.multisets.Empty)elemnt
						));
					continue;
				}
				
				if(elemnt.getClass().equals(fr.lip6.move.pnml.pthlpng.multisets.impl.NumberOfImpl.class)){
					retour.add(new fr.lip6.move.pnml.pthlpng.multisets.hlapi.NumberOfHLAPI(
						(fr.lip6.move.pnml.pthlpng.multisets.NumberOf)elemnt
						));
					continue;
				}
				
				if(elemnt.getClass().equals(fr.lip6.move.pnml.pthlpng.multisets.impl.SubtractImpl.class)){
					retour.add(new fr.lip6.move.pnml.pthlpng.multisets.hlapi.SubtractHLAPI(
						(fr.lip6.move.pnml.pthlpng.multisets.Subtract)elemnt
						));
					continue;
				}
				
				if(elemnt.getClass().equals(fr.lip6.move.pnml.pthlpng.multisets.impl.ScalarProductImpl.class)){
					retour.add(new fr.lip6.move.pnml.pthlpng.multisets.hlapi.ScalarProductHLAPI(
						(fr.lip6.move.pnml.pthlpng.multisets.ScalarProduct)elemnt
						));
					continue;
				}
				
				if(elemnt.getClass().equals(fr.lip6.move.pnml.pthlpng.terms.impl.VariableImpl.class)){
					retour.add(new fr.lip6.move.pnml.pthlpng.terms.hlapi.VariableHLAPI(
						(fr.lip6.move.pnml.pthlpng.terms.Variable)elemnt
						));
					continue;
				}
				
				if(elemnt.getClass().equals(fr.lip6.move.pnml.pthlpng.terms.impl.TupleImpl.class)){
					retour.add(new fr.lip6.move.pnml.pthlpng.terms.hlapi.TupleHLAPI(
						(fr.lip6.move.pnml.pthlpng.terms.Tuple)elemnt
						));
					continue;
				}
				
				if(elemnt.getClass().equals(fr.lip6.move.pnml.pthlpng.terms.impl.UserOperatorImpl.class)){
					retour.add(new fr.lip6.move.pnml.pthlpng.terms.hlapi.UserOperatorHLAPI(
						(fr.lip6.move.pnml.pthlpng.terms.UserOperator)elemnt
						));
					continue;
				}
				
			}
			return retour;
		}
		
	
	

	//Special getter for list of generics object, return only one object type.
	
	
	
		
		
		/**
		 * This accessor return a list of encapsulated subelement, only of GreaterThanHLAPI kind.
		 * WARNING : this method can creates a lot of new object in memory.
		 */
		public java.util.List<fr.lip6.move.pnml.pthlpng.partitions.hlapi.GreaterThanHLAPI> getPartitionelementconstants_partitions_GreaterThanHLAPI(){
			java.util.List<fr.lip6.move.pnml.pthlpng.partitions.hlapi.GreaterThanHLAPI> retour = new ArrayList<fr.lip6.move.pnml.pthlpng.partitions.hlapi.GreaterThanHLAPI>();
			for (Term elemnt : getPartitionelementconstants()) {
				if(elemnt.getClass().equals(fr.lip6.move.pnml.pthlpng.partitions.impl.GreaterThanImpl.class)){
					retour.add(new fr.lip6.move.pnml.pthlpng.partitions.hlapi.GreaterThanHLAPI(
						(fr.lip6.move.pnml.pthlpng.partitions.GreaterThan)elemnt
						));
				}
			}
			return retour;
		}
		
		
		/**
		 * This accessor return a list of encapsulated subelement, only of PartitionElementOfHLAPI kind.
		 * WARNING : this method can creates a lot of new object in memory.
		 */
		public java.util.List<fr.lip6.move.pnml.pthlpng.partitions.hlapi.PartitionElementOfHLAPI> getPartitionelementconstants_partitions_PartitionElementOfHLAPI(){
			java.util.List<fr.lip6.move.pnml.pthlpng.partitions.hlapi.PartitionElementOfHLAPI> retour = new ArrayList<fr.lip6.move.pnml.pthlpng.partitions.hlapi.PartitionElementOfHLAPI>();
			for (Term elemnt : getPartitionelementconstants()) {
				if(elemnt.getClass().equals(fr.lip6.move.pnml.pthlpng.partitions.impl.PartitionElementOfImpl.class)){
					retour.add(new fr.lip6.move.pnml.pthlpng.partitions.hlapi.PartitionElementOfHLAPI(
						(fr.lip6.move.pnml.pthlpng.partitions.PartitionElementOf)elemnt
						));
				}
			}
			return retour;
		}
		
		
		/**
		 * This accessor return a list of encapsulated subelement, only of LessThanHLAPI kind.
		 * WARNING : this method can creates a lot of new object in memory.
		 */
		public java.util.List<fr.lip6.move.pnml.pthlpng.partitions.hlapi.LessThanHLAPI> getPartitionelementconstants_partitions_LessThanHLAPI(){
			java.util.List<fr.lip6.move.pnml.pthlpng.partitions.hlapi.LessThanHLAPI> retour = new ArrayList<fr.lip6.move.pnml.pthlpng.partitions.hlapi.LessThanHLAPI>();
			for (Term elemnt : getPartitionelementconstants()) {
				if(elemnt.getClass().equals(fr.lip6.move.pnml.pthlpng.partitions.impl.LessThanImpl.class)){
					retour.add(new fr.lip6.move.pnml.pthlpng.partitions.hlapi.LessThanHLAPI(
						(fr.lip6.move.pnml.pthlpng.partitions.LessThan)elemnt
						));
				}
			}
			return retour;
		}
		
		
		/**
		 * This accessor return a list of encapsulated subelement, only of EqualityHLAPI kind.
		 * WARNING : this method can creates a lot of new object in memory.
		 */
		public java.util.List<fr.lip6.move.pnml.pthlpng.booleans.hlapi.EqualityHLAPI> getPartitionelementconstants_booleans_EqualityHLAPI(){
			java.util.List<fr.lip6.move.pnml.pthlpng.booleans.hlapi.EqualityHLAPI> retour = new ArrayList<fr.lip6.move.pnml.pthlpng.booleans.hlapi.EqualityHLAPI>();
			for (Term elemnt : getPartitionelementconstants()) {
				if(elemnt.getClass().equals(fr.lip6.move.pnml.pthlpng.booleans.impl.EqualityImpl.class)){
					retour.add(new fr.lip6.move.pnml.pthlpng.booleans.hlapi.EqualityHLAPI(
						(fr.lip6.move.pnml.pthlpng.booleans.Equality)elemnt
						));
				}
			}
			return retour;
		}
		
		
		/**
		 * This accessor return a list of encapsulated subelement, only of InequalityHLAPI kind.
		 * WARNING : this method can creates a lot of new object in memory.
		 */
		public java.util.List<fr.lip6.move.pnml.pthlpng.booleans.hlapi.InequalityHLAPI> getPartitionelementconstants_booleans_InequalityHLAPI(){
			java.util.List<fr.lip6.move.pnml.pthlpng.booleans.hlapi.InequalityHLAPI> retour = new ArrayList<fr.lip6.move.pnml.pthlpng.booleans.hlapi.InequalityHLAPI>();
			for (Term elemnt : getPartitionelementconstants()) {
				if(elemnt.getClass().equals(fr.lip6.move.pnml.pthlpng.booleans.impl.InequalityImpl.class)){
					retour.add(new fr.lip6.move.pnml.pthlpng.booleans.hlapi.InequalityHLAPI(
						(fr.lip6.move.pnml.pthlpng.booleans.Inequality)elemnt
						));
				}
			}
			return retour;
		}
		
		
		/**
		 * This accessor return a list of encapsulated subelement, only of BooleanConstantHLAPI kind.
		 * WARNING : this method can creates a lot of new object in memory.
		 */
		public java.util.List<fr.lip6.move.pnml.pthlpng.booleans.hlapi.BooleanConstantHLAPI> getPartitionelementconstants_booleans_BooleanConstantHLAPI(){
			java.util.List<fr.lip6.move.pnml.pthlpng.booleans.hlapi.BooleanConstantHLAPI> retour = new ArrayList<fr.lip6.move.pnml.pthlpng.booleans.hlapi.BooleanConstantHLAPI>();
			for (Term elemnt : getPartitionelementconstants()) {
				if(elemnt.getClass().equals(fr.lip6.move.pnml.pthlpng.booleans.impl.BooleanConstantImpl.class)){
					retour.add(new fr.lip6.move.pnml.pthlpng.booleans.hlapi.BooleanConstantHLAPI(
						(fr.lip6.move.pnml.pthlpng.booleans.BooleanConstant)elemnt
						));
				}
			}
			return retour;
		}
		
		
		/**
		 * This accessor return a list of encapsulated subelement, only of OrHLAPI kind.
		 * WARNING : this method can creates a lot of new object in memory.
		 */
		public java.util.List<fr.lip6.move.pnml.pthlpng.booleans.hlapi.OrHLAPI> getPartitionelementconstants_booleans_OrHLAPI(){
			java.util.List<fr.lip6.move.pnml.pthlpng.booleans.hlapi.OrHLAPI> retour = new ArrayList<fr.lip6.move.pnml.pthlpng.booleans.hlapi.OrHLAPI>();
			for (Term elemnt : getPartitionelementconstants()) {
				if(elemnt.getClass().equals(fr.lip6.move.pnml.pthlpng.booleans.impl.OrImpl.class)){
					retour.add(new fr.lip6.move.pnml.pthlpng.booleans.hlapi.OrHLAPI(
						(fr.lip6.move.pnml.pthlpng.booleans.Or)elemnt
						));
				}
			}
			return retour;
		}
		
		
		/**
		 * This accessor return a list of encapsulated subelement, only of AndHLAPI kind.
		 * WARNING : this method can creates a lot of new object in memory.
		 */
		public java.util.List<fr.lip6.move.pnml.pthlpng.booleans.hlapi.AndHLAPI> getPartitionelementconstants_booleans_AndHLAPI(){
			java.util.List<fr.lip6.move.pnml.pthlpng.booleans.hlapi.AndHLAPI> retour = new ArrayList<fr.lip6.move.pnml.pthlpng.booleans.hlapi.AndHLAPI>();
			for (Term elemnt : getPartitionelementconstants()) {
				if(elemnt.getClass().equals(fr.lip6.move.pnml.pthlpng.booleans.impl.AndImpl.class)){
					retour.add(new fr.lip6.move.pnml.pthlpng.booleans.hlapi.AndHLAPI(
						(fr.lip6.move.pnml.pthlpng.booleans.And)elemnt
						));
				}
			}
			return retour;
		}
		
		
		/**
		 * This accessor return a list of encapsulated subelement, only of ImplyHLAPI kind.
		 * WARNING : this method can creates a lot of new object in memory.
		 */
		public java.util.List<fr.lip6.move.pnml.pthlpng.booleans.hlapi.ImplyHLAPI> getPartitionelementconstants_booleans_ImplyHLAPI(){
			java.util.List<fr.lip6.move.pnml.pthlpng.booleans.hlapi.ImplyHLAPI> retour = new ArrayList<fr.lip6.move.pnml.pthlpng.booleans.hlapi.ImplyHLAPI>();
			for (Term elemnt : getPartitionelementconstants()) {
				if(elemnt.getClass().equals(fr.lip6.move.pnml.pthlpng.booleans.impl.ImplyImpl.class)){
					retour.add(new fr.lip6.move.pnml.pthlpng.booleans.hlapi.ImplyHLAPI(
						(fr.lip6.move.pnml.pthlpng.booleans.Imply)elemnt
						));
				}
			}
			return retour;
		}
		
		
		/**
		 * This accessor return a list of encapsulated subelement, only of NotHLAPI kind.
		 * WARNING : this method can creates a lot of new object in memory.
		 */
		public java.util.List<fr.lip6.move.pnml.pthlpng.booleans.hlapi.NotHLAPI> getPartitionelementconstants_booleans_NotHLAPI(){
			java.util.List<fr.lip6.move.pnml.pthlpng.booleans.hlapi.NotHLAPI> retour = new ArrayList<fr.lip6.move.pnml.pthlpng.booleans.hlapi.NotHLAPI>();
			for (Term elemnt : getPartitionelementconstants()) {
				if(elemnt.getClass().equals(fr.lip6.move.pnml.pthlpng.booleans.impl.NotImpl.class)){
					retour.add(new fr.lip6.move.pnml.pthlpng.booleans.hlapi.NotHLAPI(
						(fr.lip6.move.pnml.pthlpng.booleans.Not)elemnt
						));
				}
			}
			return retour;
		}
		
		
		/**
		 * This accessor return a list of encapsulated subelement, only of DotConstantHLAPI kind.
		 * WARNING : this method can creates a lot of new object in memory.
		 */
		public java.util.List<fr.lip6.move.pnml.pthlpng.dots.hlapi.DotConstantHLAPI> getPartitionelementconstants_dots_DotConstantHLAPI(){
			java.util.List<fr.lip6.move.pnml.pthlpng.dots.hlapi.DotConstantHLAPI> retour = new ArrayList<fr.lip6.move.pnml.pthlpng.dots.hlapi.DotConstantHLAPI>();
			for (Term elemnt : getPartitionelementconstants()) {
				if(elemnt.getClass().equals(fr.lip6.move.pnml.pthlpng.dots.impl.DotConstantImpl.class)){
					retour.add(new fr.lip6.move.pnml.pthlpng.dots.hlapi.DotConstantHLAPI(
						(fr.lip6.move.pnml.pthlpng.dots.DotConstant)elemnt
						));
				}
			}
			return retour;
		}
		
		
		/**
		 * This accessor return a list of encapsulated subelement, only of CardinalityHLAPI kind.
		 * WARNING : this method can creates a lot of new object in memory.
		 */
		public java.util.List<fr.lip6.move.pnml.pthlpng.multisets.hlapi.CardinalityHLAPI> getPartitionelementconstants_multisets_CardinalityHLAPI(){
			java.util.List<fr.lip6.move.pnml.pthlpng.multisets.hlapi.CardinalityHLAPI> retour = new ArrayList<fr.lip6.move.pnml.pthlpng.multisets.hlapi.CardinalityHLAPI>();
			for (Term elemnt : getPartitionelementconstants()) {
				if(elemnt.getClass().equals(fr.lip6.move.pnml.pthlpng.multisets.impl.CardinalityImpl.class)){
					retour.add(new fr.lip6.move.pnml.pthlpng.multisets.hlapi.CardinalityHLAPI(
						(fr.lip6.move.pnml.pthlpng.multisets.Cardinality)elemnt
						));
				}
			}
			return retour;
		}
		
		
		/**
		 * This accessor return a list of encapsulated subelement, only of ContainsHLAPI kind.
		 * WARNING : this method can creates a lot of new object in memory.
		 */
		public java.util.List<fr.lip6.move.pnml.pthlpng.multisets.hlapi.ContainsHLAPI> getPartitionelementconstants_multisets_ContainsHLAPI(){
			java.util.List<fr.lip6.move.pnml.pthlpng.multisets.hlapi.ContainsHLAPI> retour = new ArrayList<fr.lip6.move.pnml.pthlpng.multisets.hlapi.ContainsHLAPI>();
			for (Term elemnt : getPartitionelementconstants()) {
				if(elemnt.getClass().equals(fr.lip6.move.pnml.pthlpng.multisets.impl.ContainsImpl.class)){
					retour.add(new fr.lip6.move.pnml.pthlpng.multisets.hlapi.ContainsHLAPI(
						(fr.lip6.move.pnml.pthlpng.multisets.Contains)elemnt
						));
				}
			}
			return retour;
		}
		
		
		/**
		 * This accessor return a list of encapsulated subelement, only of CardinalityOfHLAPI kind.
		 * WARNING : this method can creates a lot of new object in memory.
		 */
		public java.util.List<fr.lip6.move.pnml.pthlpng.multisets.hlapi.CardinalityOfHLAPI> getPartitionelementconstants_multisets_CardinalityOfHLAPI(){
			java.util.List<fr.lip6.move.pnml.pthlpng.multisets.hlapi.CardinalityOfHLAPI> retour = new ArrayList<fr.lip6.move.pnml.pthlpng.multisets.hlapi.CardinalityOfHLAPI>();
			for (Term elemnt : getPartitionelementconstants()) {
				if(elemnt.getClass().equals(fr.lip6.move.pnml.pthlpng.multisets.impl.CardinalityOfImpl.class)){
					retour.add(new fr.lip6.move.pnml.pthlpng.multisets.hlapi.CardinalityOfHLAPI(
						(fr.lip6.move.pnml.pthlpng.multisets.CardinalityOf)elemnt
						));
				}
			}
			return retour;
		}
		
		
		/**
		 * This accessor return a list of encapsulated subelement, only of AddHLAPI kind.
		 * WARNING : this method can creates a lot of new object in memory.
		 */
		public java.util.List<fr.lip6.move.pnml.pthlpng.multisets.hlapi.AddHLAPI> getPartitionelementconstants_multisets_AddHLAPI(){
			java.util.List<fr.lip6.move.pnml.pthlpng.multisets.hlapi.AddHLAPI> retour = new ArrayList<fr.lip6.move.pnml.pthlpng.multisets.hlapi.AddHLAPI>();
			for (Term elemnt : getPartitionelementconstants()) {
				if(elemnt.getClass().equals(fr.lip6.move.pnml.pthlpng.multisets.impl.AddImpl.class)){
					retour.add(new fr.lip6.move.pnml.pthlpng.multisets.hlapi.AddHLAPI(
						(fr.lip6.move.pnml.pthlpng.multisets.Add)elemnt
						));
				}
			}
			return retour;
		}
		
		
		/**
		 * This accessor return a list of encapsulated subelement, only of AllHLAPI kind.
		 * WARNING : this method can creates a lot of new object in memory.
		 */
		public java.util.List<fr.lip6.move.pnml.pthlpng.multisets.hlapi.AllHLAPI> getPartitionelementconstants_multisets_AllHLAPI(){
			java.util.List<fr.lip6.move.pnml.pthlpng.multisets.hlapi.AllHLAPI> retour = new ArrayList<fr.lip6.move.pnml.pthlpng.multisets.hlapi.AllHLAPI>();
			for (Term elemnt : getPartitionelementconstants()) {
				if(elemnt.getClass().equals(fr.lip6.move.pnml.pthlpng.multisets.impl.AllImpl.class)){
					retour.add(new fr.lip6.move.pnml.pthlpng.multisets.hlapi.AllHLAPI(
						(fr.lip6.move.pnml.pthlpng.multisets.All)elemnt
						));
				}
			}
			return retour;
		}
		
		
		/**
		 * This accessor return a list of encapsulated subelement, only of EmptyHLAPI kind.
		 * WARNING : this method can creates a lot of new object in memory.
		 */
		public java.util.List<fr.lip6.move.pnml.pthlpng.multisets.hlapi.EmptyHLAPI> getPartitionelementconstants_multisets_EmptyHLAPI(){
			java.util.List<fr.lip6.move.pnml.pthlpng.multisets.hlapi.EmptyHLAPI> retour = new ArrayList<fr.lip6.move.pnml.pthlpng.multisets.hlapi.EmptyHLAPI>();
			for (Term elemnt : getPartitionelementconstants()) {
				if(elemnt.getClass().equals(fr.lip6.move.pnml.pthlpng.multisets.impl.EmptyImpl.class)){
					retour.add(new fr.lip6.move.pnml.pthlpng.multisets.hlapi.EmptyHLAPI(
						(fr.lip6.move.pnml.pthlpng.multisets.Empty)elemnt
						));
				}
			}
			return retour;
		}
		
		
		/**
		 * This accessor return a list of encapsulated subelement, only of NumberOfHLAPI kind.
		 * WARNING : this method can creates a lot of new object in memory.
		 */
		public java.util.List<fr.lip6.move.pnml.pthlpng.multisets.hlapi.NumberOfHLAPI> getPartitionelementconstants_multisets_NumberOfHLAPI(){
			java.util.List<fr.lip6.move.pnml.pthlpng.multisets.hlapi.NumberOfHLAPI> retour = new ArrayList<fr.lip6.move.pnml.pthlpng.multisets.hlapi.NumberOfHLAPI>();
			for (Term elemnt : getPartitionelementconstants()) {
				if(elemnt.getClass().equals(fr.lip6.move.pnml.pthlpng.multisets.impl.NumberOfImpl.class)){
					retour.add(new fr.lip6.move.pnml.pthlpng.multisets.hlapi.NumberOfHLAPI(
						(fr.lip6.move.pnml.pthlpng.multisets.NumberOf)elemnt
						));
				}
			}
			return retour;
		}
		
		
		/**
		 * This accessor return a list of encapsulated subelement, only of SubtractHLAPI kind.
		 * WARNING : this method can creates a lot of new object in memory.
		 */
		public java.util.List<fr.lip6.move.pnml.pthlpng.multisets.hlapi.SubtractHLAPI> getPartitionelementconstants_multisets_SubtractHLAPI(){
			java.util.List<fr.lip6.move.pnml.pthlpng.multisets.hlapi.SubtractHLAPI> retour = new ArrayList<fr.lip6.move.pnml.pthlpng.multisets.hlapi.SubtractHLAPI>();
			for (Term elemnt : getPartitionelementconstants()) {
				if(elemnt.getClass().equals(fr.lip6.move.pnml.pthlpng.multisets.impl.SubtractImpl.class)){
					retour.add(new fr.lip6.move.pnml.pthlpng.multisets.hlapi.SubtractHLAPI(
						(fr.lip6.move.pnml.pthlpng.multisets.Subtract)elemnt
						));
				}
			}
			return retour;
		}
		
		
		/**
		 * This accessor return a list of encapsulated subelement, only of ScalarProductHLAPI kind.
		 * WARNING : this method can creates a lot of new object in memory.
		 */
		public java.util.List<fr.lip6.move.pnml.pthlpng.multisets.hlapi.ScalarProductHLAPI> getPartitionelementconstants_multisets_ScalarProductHLAPI(){
			java.util.List<fr.lip6.move.pnml.pthlpng.multisets.hlapi.ScalarProductHLAPI> retour = new ArrayList<fr.lip6.move.pnml.pthlpng.multisets.hlapi.ScalarProductHLAPI>();
			for (Term elemnt : getPartitionelementconstants()) {
				if(elemnt.getClass().equals(fr.lip6.move.pnml.pthlpng.multisets.impl.ScalarProductImpl.class)){
					retour.add(new fr.lip6.move.pnml.pthlpng.multisets.hlapi.ScalarProductHLAPI(
						(fr.lip6.move.pnml.pthlpng.multisets.ScalarProduct)elemnt
						));
				}
			}
			return retour;
		}
		
		
		/**
		 * This accessor return a list of encapsulated subelement, only of VariableHLAPI kind.
		 * WARNING : this method can creates a lot of new object in memory.
		 */
		public java.util.List<fr.lip6.move.pnml.pthlpng.terms.hlapi.VariableHLAPI> getPartitionelementconstants_terms_VariableHLAPI(){
			java.util.List<fr.lip6.move.pnml.pthlpng.terms.hlapi.VariableHLAPI> retour = new ArrayList<fr.lip6.move.pnml.pthlpng.terms.hlapi.VariableHLAPI>();
			for (Term elemnt : getPartitionelementconstants()) {
				if(elemnt.getClass().equals(fr.lip6.move.pnml.pthlpng.terms.impl.VariableImpl.class)){
					retour.add(new fr.lip6.move.pnml.pthlpng.terms.hlapi.VariableHLAPI(
						(fr.lip6.move.pnml.pthlpng.terms.Variable)elemnt
						));
				}
			}
			return retour;
		}
		
		
		/**
		 * This accessor return a list of encapsulated subelement, only of TupleHLAPI kind.
		 * WARNING : this method can creates a lot of new object in memory.
		 */
		public java.util.List<fr.lip6.move.pnml.pthlpng.terms.hlapi.TupleHLAPI> getPartitionelementconstants_terms_TupleHLAPI(){
			java.util.List<fr.lip6.move.pnml.pthlpng.terms.hlapi.TupleHLAPI> retour = new ArrayList<fr.lip6.move.pnml.pthlpng.terms.hlapi.TupleHLAPI>();
			for (Term elemnt : getPartitionelementconstants()) {
				if(elemnt.getClass().equals(fr.lip6.move.pnml.pthlpng.terms.impl.TupleImpl.class)){
					retour.add(new fr.lip6.move.pnml.pthlpng.terms.hlapi.TupleHLAPI(
						(fr.lip6.move.pnml.pthlpng.terms.Tuple)elemnt
						));
				}
			}
			return retour;
		}
		
		
		/**
		 * This accessor return a list of encapsulated subelement, only of UserOperatorHLAPI kind.
		 * WARNING : this method can creates a lot of new object in memory.
		 */
		public java.util.List<fr.lip6.move.pnml.pthlpng.terms.hlapi.UserOperatorHLAPI> getPartitionelementconstants_terms_UserOperatorHLAPI(){
			java.util.List<fr.lip6.move.pnml.pthlpng.terms.hlapi.UserOperatorHLAPI> retour = new ArrayList<fr.lip6.move.pnml.pthlpng.terms.hlapi.UserOperatorHLAPI>();
			for (Term elemnt : getPartitionelementconstants()) {
				if(elemnt.getClass().equals(fr.lip6.move.pnml.pthlpng.terms.impl.UserOperatorImpl.class)){
					retour.add(new fr.lip6.move.pnml.pthlpng.terms.hlapi.UserOperatorHLAPI(
						(fr.lip6.move.pnml.pthlpng.terms.UserOperator)elemnt
						));
				}
			}
			return retour;
		}
		
	
	

	//setters (including container setter if aviable)
	
	
	/**
	 * set Id
	 */
	public void setIdHLAPI(
	
	java.lang.String elem) throws InvalidIDException ,VoidRepositoryException   {
	
	
		if(elem!=null){
		
			try{
			item.setId(ModelRepository.getInstance().getCurrentIdRepository().changeId(this, elem));
			}catch (OtherException e){
			ModelRepository.getInstance().getCurrentIdRepository().checkId(elem, this);
			}
		}
	
	}
	
	/**
	 * set Name
	 */
	public void setNameHLAPI(
	
	java.lang.String elem){
	
	
		if(elem!=null){
		
			item.setName(elem);
		}
	
	}
	
	/**
	 * set ContainerDeclarations
	 */
	public void setContainerDeclarationsHLAPI(
	
	DeclarationsHLAPI elem){
	
	
 		if(elem!=null)
			item.setContainerDeclarations((Declarations)elem.getContainedItem());
	
	}
	
	/**
	 * set Refpartition
	 */
	public void setRefpartitionHLAPI(
	
	PartitionHLAPI elem){
	
	
 		if(elem!=null)
			item.setRefpartition((Partition)elem.getContainedItem());
	
	}
	

	//setters/remover for lists.
	
	
	public void addPartitionelementconstantsHLAPI(TermHLAPI unit){
	
		item.getPartitionelementconstants().add((Term)unit.getContainedItem());
	}

	public void removePartitionelementconstantsHLAPI(TermHLAPI unit){
		item.getPartitionelementconstants().remove((Term)unit.getContainedItem());
	}
	

	//equals method
	public boolean equals(PartitionElementHLAPI item){
		return item.getContainedItem().equals(getContainedItem());
	}

	//PNML
	
	/**
	 * Returns the PNML xml tree for this object.
	 */
	public String toPNML(){
		return item.toPNML();
	}
	
	/**
	 * Writes the PNML XML tree of this object into file channel.
	 */
	public void toPNML(FileChannel fc){
		 item.toPNML(fc);
	}

	/**
	 * creates an object from the xml nodes.(symetric work of toPNML)
	 */
	public void fromPNML(OMElement subRoot,IdRefLinker idr) throws InnerBuildException, InvalidIDException, VoidRepositoryException{
		item.fromPNML(subRoot,idr);
	}
	

	public boolean validateOCL(DiagnosticChain diagnostics){
		return item.validateOCL(diagnostics);
	}

}